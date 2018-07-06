package core;

import pojo.*;

import java.util.ArrayList;

public class StorageManagement {
    public static void manageStorage() {
        ArrayList<Order> orders = PageTable.getOrders();
        //ArrayList<PageTableElement> pageTableElements = PageTable.getPageTableElements();
        ArrayList<UsefulStorageElement> usefulStorageElements = PageTable.getUsefulStorageElements();
        for (Order order: orders) {
            boolean isExist = false;
            for (UsefulStorageElement usefulStorageElement: usefulStorageElements) {
                if (order.getPageNumber().equals(usefulStorageElement.getNumber())) {
                    //System.out.println(usefulStorageElements.size());
                    //System.out.println("order.getPageNumber()->" + order.getPageNumber());
                    //System.out.println("usefulStorageElement.getNumber()->" + usefulStorageElement.getNumber());
                    for (ModifiedOperation modifiedOperation: ModifiedOperation.values()) {
                        if (modifiedOperation.equals(order.getOperation())) {
                            usefulStorageElement.setModifiedSiganl(String.valueOf(1));
                            break;
                        }
                    }
                    int absoluteAddress = 128 * Integer.parseInt(usefulStorageElement.getBlockSize()) + Integer.parseInt(order.getUnitNumber());
                    System.out.println("absolute address is " + absoluteAddress);
                    isExist = true;
                }
            }
            if (!isExist) {
                System.out.println("*" + order.getPageNumber());
                solveInterrupt(order.getPageNumber());
            }
        }
    }

    public static void solveInterrupt(String pageNumber) {
        //只有前四个  在0---3上进行操作
        ArrayList<UsefulStorageElement> usefulStorageElements = PageTable.getUsefulStorageElements();
        ArrayList<PageTableElement> pageTableElements = PageTable.getPageTableElements();//仅仅为了存放不在usefulStorageElements中的元素的块的大小和硬盘地址
        int currentLocation = PageTable.getLocation();
        if (Integer.parseInt(usefulStorageElements.get(currentLocation).getModifiedSiganl()) == 1) {
            System.out.println("由于页号" + usefulStorageElements.get(currentLocation).getNumber() + "的页已经修改过，因此重新存放到硬盘" + usefulStorageElements.get(currentLocation).getDiskLocation() + "处");
            for (PageTableElement pageTableElement: pageTableElements) {
                if (pageTableElement.getPageNumber().equals(pageNumber)) {
                    usefulStorageElements.set(currentLocation, new UsefulStorageElement(pageNumber, pageTableElement.getBlockNumber(), String.valueOf(0), pageTableElement.getDiskLocation()));
                    break;
                }
            }
            System.out.println("页号为" + pageNumber + "的内存页被调入内存");
        } else if (Integer.parseInt(usefulStorageElements.get(currentLocation).getModifiedSiganl()) == 0) {
            System.out.println("由于页号" + usefulStorageElements.get(currentLocation).getNumber() + "的页没有被修改过，因此直接将当前页替换掉");
            for (PageTableElement pageTableElement: pageTableElements) {
                if (pageTableElement.getPageNumber().equals(pageNumber)) {
                    usefulStorageElements.set(currentLocation, new UsefulStorageElement(pageNumber, pageTableElement.getBlockNumber(), String.valueOf(0), pageTableElement.getDiskLocation()));
                    break;
                }
            }
            System.out.println("页号为" + pageNumber + "的内存页被调入内存");
        }
        PageTable.setLocation(PageTable.getLocation() + 1);
    }
}
