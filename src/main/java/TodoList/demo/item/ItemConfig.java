package TodoList.demo.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository) {
        return args -> {
            Item study = new Item (
                    "study Springboot"
            );

            Item train = new Item (
                    "do exercise"
            );

            repository.saveAll(List.of(study, train));
        };
    }
}
