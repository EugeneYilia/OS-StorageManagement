package pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PageTable {
    private PageTable() {
    }

    private static ArrayList<Order> orders = new ArrayList<Order>();
    private static ArrayList<PageTableElement> pageTableElements = new ArrayList<PageTableElement>();

    static {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("document/pageTableElements.txt")));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                String pageNumber = stringTokenizer.nextToken();
                String siganl = stringTokenizer.nextToken();
                String blockNumber = stringTokenizer.nextToken();
                String diskLocation = stringTokenizer.nextToken();
                pageTableElements.add(new PageTableElement(pageNumber, siganl, blockNumber, diskLocation));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("document/orders.txt")));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                String operation = stringTokenizer.nextToken();
                String pageNumber = stringTokenizer.nextToken();
                String unitNumber = stringTokenizer.nextToken();
                orders.add(new Order(operation, pageNumber, unitNumber));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<PageTableElement> getPageTableElements() {
        return pageTableElements;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }
}

