package TodoList.demo.domain.item;

import TodoList.demo.enums.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository) {
        return args -> {
            Item item1 = new Item (
                    "Assignment",
                    "Config Arch",
                    Status.IN_PROGRESS
            );

            Item item2 = new Item (
                    "Assignment",
                    "Build API CRUD",
                    Status.IN_PROGRESS
            );

            repository.saveAll(List.of(item1, item2));
        };
    }
}
