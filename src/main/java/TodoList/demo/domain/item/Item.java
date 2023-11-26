package TodoList.demo.domain.item;

import TodoList.demo.enums.Status;
import jakarta.persistence.*;

@Entity
@Table
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    private String title;
    private String description;

    @Enumerated
    @Column(name = "status", length = 4)
    private Status status;

    public Item() {
    }

    public Item(Long id,
                String title,
                String description,
                Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Item(String title, String description, Status status) {
        this.description = description;
        this.title = title;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
