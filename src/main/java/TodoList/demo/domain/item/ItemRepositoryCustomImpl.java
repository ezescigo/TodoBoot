package TodoList.demo.domain.item;

import TodoList.demo.enums.Status;

import java.util.List;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    private final ItemRepositoryBasic itemRepositoryBasic;

    public ItemRepositoryCustomImpl(ItemRepositoryBasic itemRepositoryBasic) {
        this.itemRepositoryBasic = itemRepositoryBasic;
    }

    @SuppressWarnings("unused")
    public List<Item> getAllFiltered(Status status) {
        System.out.println(status);
        return itemRepositoryBasic.findAll()
                .stream().filter(i -> i.getStatus() == status).toList();
    }
}
