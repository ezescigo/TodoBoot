package TodoList.demo.domain.item;

import TodoList.demo.enums.Status;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item> getAllFiltered(Status status);
}
