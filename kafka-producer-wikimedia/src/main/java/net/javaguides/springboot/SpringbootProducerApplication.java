package net.javaguides.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootProducerApplication implements CommandLineRunner {
    private final WikimediaChangesProducer wikimediaChangesProducer;

    public SpringbootProducerApplication(WikimediaChangesProducer wikimediaChangesProducer) {
        this.wikimediaChangesProducer = wikimediaChangesProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}
