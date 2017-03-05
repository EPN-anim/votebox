package org.votusoperandi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        initDatas(context);
    }

    private static void initDatas(ConfigurableApplicationContext context) {
        ElectionRepository repository = context.getBean(ElectionRepository.class);

        repository.save(new Election("Quel est votre couleur préférée ?", "noir", "marron", "vert", "auburn"));
        repository.save(new Election("Quel est votre candidat-e préféré-e ?", "Jacques", "Nadine", "Aude", "Jimmy"));
        repository.save(new Election("Quel est votre animal préféré ?", "éléphant", "souris", "pie"));

    }
}