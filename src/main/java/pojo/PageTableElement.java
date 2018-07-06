package pojo;

public class PageTableElement {
    private String pageNumber;
    private String signal;
    private String blockNumber;
    private String modifiedSignal;
    private String diskLocation;

    public PageTableElement() {
    }

    public PageTableElement(String pageNumber, String signal, String blockNumber, String diskLocation, String modifiedSignal) {
        this.pageNumber = pageNumber;
        this.signal = signal;
        this.blockNumber = blockNumber;
        this.diskLocation = diskLocation;
        this.modifiedSignal = modifiedSignal;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public String getSignal() {
        return signal;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public String getModifiedSignal() {
        return modifiedSignal;
    }

    public String getDiskLocation() {
        return diskLocation;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setModifiedSignal(String modifiedSignal) {
        this.modifiedSignal = modifiedSignal;
    }

    public void setDiskLocation(String diskLocation) {
        this.diskLocation = diskLocation;
    }
}
