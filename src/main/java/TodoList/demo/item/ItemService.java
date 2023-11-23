package TodoList.demo.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void createNewItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, Item patch) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException("item with id " + itemId + " does not exists."));

        String description = patch.getDescription();

        if (description != null &&
                description.length() > 0) {
            item.setDescription(item.getDescription());
        }
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException("item with id " + itemId + " does not exists.");
        }
        itemRepository.deleteById(itemId);
    }
}
