package TodoList.demo.item;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    public List<Item> getItems() {
        return List.of(
                new Item (
                        1L,
                        "study Springboot"
                )
        );
    }
}
