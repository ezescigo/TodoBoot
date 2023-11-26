package TodoList.demo.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryBasic extends JpaRepository<Item, Long> {
}
