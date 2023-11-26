package TodoList.demo.services;

import TodoList.demo.Exception.ItemNotFoundException;
import TodoList.demo.domain.item.Item;
import TodoList.demo.domain.item.ItemRepository;
import TodoList.demo.enums.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(Status status) {
        return itemRepository.getAllFiltered(status);
//        return itemRepository.findAll();
    }

    public Item getItem(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + " not found."));
    }

    public void createNewItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, Item patch) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + " not found."));

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
