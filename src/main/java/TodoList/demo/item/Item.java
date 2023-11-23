package TodoList.demo.item;

public class Item {
    private Long id;
    private String description;

    public Item() {
    }

    public Item(Long id,
                String description) {
        this.id = id;
        this.description = description;
    }

    public Item(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
