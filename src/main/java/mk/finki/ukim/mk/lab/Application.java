package mk.finki.ukim.mk.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //okumaz componeb
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
