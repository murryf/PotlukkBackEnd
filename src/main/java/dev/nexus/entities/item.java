package dev.nexus.entities;

public class item {
    private String description;
    private String status;
    private String supplier;

    private item() {
    }

    public item(String description, String status, String supplier) {
        this.description = description;
        this.status = status;
        this.supplier = supplier;
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

    @Override
    public String toString() {
        return "item{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}

