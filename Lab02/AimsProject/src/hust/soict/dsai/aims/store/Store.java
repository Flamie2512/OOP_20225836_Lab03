package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS = 50;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS) {
            itemsInStore[qtyInStore++] = dvd;
            System.out.println("DVD added to the store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].equals(dvd)) {
                itemsInStore[i] = itemsInStore[qtyInStore - 1];
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD removed from the store: " + dvd.getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the store: " + dvd.getTitle());
        }
    }

    public void printStore() {
        System.out.println("****************** STORE ******************");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("*******************************************");
    }
}
