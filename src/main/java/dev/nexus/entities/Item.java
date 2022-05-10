package dev.nexus.entities;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name="supplier")
    private String supplier;
    @Column(name="potluck_id")
    private Long potluckID;

    public Item() {
    }

    public Item(Long id, String itemName, String description,
                String status, String supplier, Long potluckID) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.status = status;
        this.supplier = supplier;
        this.potluckID = potluckID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getPotluckID() {
        return potluckID;
    }

    public void setPotluckID(Long potluckID) {
        this.potluckID = potluckID;
    }

    @Override
    public String toString() {
        return "item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", supplier='" + supplier + '\'' +
                ", potluckID=" + potluckID +
                '}';
    }
}

