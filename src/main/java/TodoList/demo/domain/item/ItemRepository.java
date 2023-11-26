package TodoList.demo.domain.item;

import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ItemRepositoryBasic,
        ItemRepositoryCustom
{
}

