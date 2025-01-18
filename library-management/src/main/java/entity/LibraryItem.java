package entity;

public interface LibraryItem {
    int getId();
    void setId(int id);
    String getAuthor();
    void setAuthor(String author);
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    int getQuantity();
    void setQuantity(int quantity);
}
