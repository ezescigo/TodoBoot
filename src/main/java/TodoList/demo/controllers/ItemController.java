package TodoList.demo.controllers;

import TodoList.demo.domain.item.Item;
import TodoList.demo.enums.Status;
import TodoList.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(@RequestParam(value = "status", required = false) Status status) {
        return itemService.getItems(status);
    }

    @GetMapping(path = "{itemId}")
    public Item getItem(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId);
    }

    @PostMapping
    public void createItem(@RequestBody Item item) {
            itemService.createNewItem(item);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long itemId,
                           @RequestBody(required = false) Item item) {
        itemService.updateItem(itemId, item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }
}
