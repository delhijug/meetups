package com.iontrading.functional.oopspattern.mailer;


import java.util.function.Consumer;

class MailerWithLambda {
    public MailerWithLambda from(String from) {
        System.out.println("From...");
        return this;
    }
    public MailerWithLambda to(String to) {
        System.out.println(" to...");
        return this;
    }
    public MailerWithLambda subject(String subject) {
        System.out.println("...subject");
        return this;
    }
    public MailerWithLambda msg(String msg){
        System.out.println("..msg");
        return this;
    }

    public static void send(Consumer<MailerWithLambda> consumer){
        MailerWithLambda mailerWithLambda = new MailerWithLambda();
        consumer.accept(mailerWithLambda);

        System.out.println("...send");
    }
}

public class SampleWIthLambda {
    public static void main(String[] args) {
        MailerWithLambda.send(mailerWithLambda -> mailerWithLambda.from("a@a.com")
                .to("b@b.com")
                .subject("test")
                .msg("msg"));
    }

}

