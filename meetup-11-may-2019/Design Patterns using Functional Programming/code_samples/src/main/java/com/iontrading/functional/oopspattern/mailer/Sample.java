package com.iontrading.functional.oopspattern.mailer;

class Mailer {
    public Mailer from(String from) {
        System.out.println("From...");
        return this;
    }
    public Mailer to(String to) {
        System.out.println(" to...");
        return this;
    }
    public Mailer subject(String subject) {
        System.out.println("...subject");
        return this;
    }
    public Mailer msg(String msg){
        System.out.println("..msg");
        return this;
    }

    public void send(){
        System.out.println("...send");
    }
}

public class Sample {
    public static void main(String[] args) {
        Mailer mailer = new Mailer();
        mailer.from("a@a.com")
                .to("b@b.com")
                .subject("test")
                .msg("msg");
        mailer.send();
    }

}
