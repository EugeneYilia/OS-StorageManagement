package pojo;

public class UsefulStorageElement {
    private String number;
    private String blockSize;
    private String modifiedSiganl;
    private String diskLocation;

    public UsefulStorageElement(String number, String blockSize,String modifiedSiganl, String diskLocation) {
        this.number = number;
        this.blockSize = blockSize;
        this.modifiedSiganl = modifiedSiganl;
        this.diskLocation = diskLocation;
    }

    public String getModifiedSiganl() {
        return modifiedSiganl;
    }

    public void setModifiedSiganl(String modifiedSiganl) {
        this.modifiedSiganl = modifiedSiganl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBlockSize() {
        return blockSize;
    }

    public void setBlockSize(String blockSize) {
        this.blockSize = blockSize;
    }

    public String getDiskLocation() {
        return diskLocation;
    }

    public void setDiskLocation(String diskLocation) {
        this.diskLocation = diskLocation;
    }

    public UsefulStorageElement() {
    }
}
