package gr.alx.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoRestDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestDataApplication.class, args);
    }


    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner {

        @Autowired
        UserRepository userRepository;

        @Override
        public void run(String... args) throws Exception {
            userRepository.save(new User(null, "alex", "pass"));
        }
    }
}
