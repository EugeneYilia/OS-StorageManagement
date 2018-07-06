package pojo;

public class Order {
    private String operation;
    private String pageNumber;
    private String unitNumber;

    public Order() {
    }

    public Order(String operation, String pageNumber, String unitNumber) {
        this.operation = operation;
        this.pageNumber = pageNumber;
        this.unitNumber = unitNumber;
    }

    public String getOperation() {
        return operation;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
}
