package delhijug.jugdemo;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class JugdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JugdemoApplication.class, args);
	}

	@Bean
	VectorStore vectorStore(EmbeddingClient ec, JdbcTemplate jt){
		return  new PgVectorStore(jt, ec);
	}

	static void init(VectorStore vectorStore, JdbcTemplate jdbcTemplate, Resource pdf){
		var config = PdfDocumentReaderConfig.builder().
				withPageExtractedTextFormatter(new ExtractedTextFormatter.Builder()
						.withNumberOfBottomTextLinesToDelete(3)
						.withNumberOfTopPagesToSkipBeforeDelete(1)
						.build()
				)
				.withPagesPerDocument(1)
				.build();

		var pdfReader = new PagePdfDocumentReader(pdf, config);

		TextSplitter textSplitter = new TokenTextSplitter();

		vectorStore.accept(textSplitter.apply(pdfReader.get()));
	}

	@Bean
	ApplicationRunner demo (
			ChatBot chatBot,
			VectorStore vectorStore,
			JdbcTemplate template,
			@Value("file:///Users/vikmalik/Downloads/bin/jugdemo/medicaid-wa-faqs.pdf") Resource pdf
			){

		return  new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {

				init(vectorStore, template, pdf);

				var aiResponse = chatBot.basicChat("Hello, Who are you?");
				System.out.println(aiResponse);

				aiResponse = chatBot.animalChat("Cat");
				System.out.println(aiResponse);

				aiResponse = chatBot.chat("Who’s who on Carina?");
				System.out.println(aiResponse);
			}
		};

	}
}

@Component
class ChatBot {

	private final ChatClient aiChatClient;

	private final VectorStore vectorStore;

	ChatBot(ChatClient aiChatClient, VectorStore vectorStore){
		this.aiChatClient = aiChatClient;
		this.vectorStore = vectorStore;
	}

	private final String animalTemplate = """
			You are assistant expert in animals. You give facts about the animals.
			Tell me more about {animal_name}

			Give response in json
			""";

	private final String template = """
                        
            You're assisting with questions about services offered by Carina.
            Carina is a two-sided healthcare marketplace focusing on home care aides (caregivers)
            and their Medicaid in-home care clients (adults and children with developmental disabilities and low income elderly population).
            Carina's mission is to build online tools to bring good jobs to care workers, so care workers can provide the
            best possible care for those who need it.
                    
            Use the information from the DOCUMENTS section to provide accurate answers but act as if you knew this information innately.
            If unsure, simply state that you don't know.
                    
            DOCUMENTS:
            {documents}
                        
            """;

	public String chat(String message){
		var listOfDocuments = this.vectorStore.similaritySearch(message);
		var documents = listOfDocuments.stream()
				.map(Document::getContent)
				.collect(Collectors.joining(System.lineSeparator()));

		var systemMessage = new SystemPromptTemplate(this.template)
				.createMessage(Map.of("documents", documents));

		var userMessage = new UserMessage(message);

		var prompt = new Prompt(List.of(systemMessage, userMessage));
		var aiResponse = aiChatClient.call(prompt);
		return aiResponse.getResult().getOutput().getContent();
	}

	public String animalChat(String message){
		var systemMessage = new SystemPromptTemplate(this.animalTemplate)
				.createMessage(Map.of("animal_name", message));

		var prompt = new Prompt(List.of(systemMessage));
		var aiResponse = aiChatClient.call(prompt);
		return aiResponse.getResult().getOutput().getContent();
	}

	public String basicChat(String message){
		return aiChatClient.call(message);
	}

}
