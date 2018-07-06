package core;

import pojo.Order;
import pojo.PageTable;
import pojo.PageTableElement;

import java.util.ArrayList;

public class StorageManagement {
    public static void manageStorage() {
        ArrayList<Order> orders = PageTable.getOrders();
        ArrayList<PageTableElement> pageTableElements = PageTable.getPageTableElements();
        for (Order order: orders) {
            boolean isExist = false;
            for (PageTableElement pageTableElement: pageTableElements) {
                if (order.getPageNumber().equals(pageTableElement.getPageNumber()) && Integer.parseInt(pageTableElement.getSignal()) == 1) {
                    int absoluteAddress = 128 * Integer.parseInt(pageTableElement.getBlockNumber()) + Integer.parseInt(order.getUnitNumber());
                    System.out.println("absolute address is " + absoluteAddress);
                    isExist = true;
                }
            }
            if (!isExist) {
                System.out.println("*" + order.getPageNumber());
            }
        }
    }
}
