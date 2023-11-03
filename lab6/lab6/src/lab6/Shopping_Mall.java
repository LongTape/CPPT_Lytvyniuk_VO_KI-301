package lab6;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Mall<T extends Comparable<T>> {
    private List<T> items;

    public Shopping_Mall() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getMinimum() {
        if (items.isEmpty()) {
            return null;
        }

        T minItem = items.get(0);
        for (T item : items) {
            if (item.compareTo(minItem) < 0) {
                minItem = item;
            }
        }
        return minItem;
    }

    public T getMaximum() {
        if (items.isEmpty()) {
            return null;
        }

        T maxItem = items.get(0);
        for (T item : items) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }
    
    public class MallDriver {
        public static void main(String[] args) {
            Shopping_Mall<Integer> integerMall = new Shopping_Mall<>();
            integerMall.addItem(10);
            integerMall.addItem(5);
            integerMall.addItem(15);

            Shopping_Mall<Double> doubleMall = new Shopping_Mall<>();
            doubleMall.addItem(8.5);
            doubleMall.addItem(11.2);
            doubleMall.addItem(6.7);

            System.out.println("Integer Mall:");
            System.out.println("Minimum: " + integerMall.getMinimum());
            System.out.println("Maximum: " + integerMall.getMaximum());

            System.out.println("Double Mall:");
            System.out.println("Minimum: " + doubleMall.getMinimum());
            System.out.println("Maximum: " + doubleMall.getMaximum());
        }
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}