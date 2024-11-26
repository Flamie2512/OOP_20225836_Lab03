package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added");
        }
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean discRemoved = false;
        if (qtyOrdered > 0) {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i] != null && itemOrdered[i].equals(disc)) {
                    itemOrdered[i] = itemOrdered[qtyOrdered - 1];
                    itemOrdered[qtyOrdered - 1] = null;
                    qtyOrdered--;
                    discRemoved = true;
                    System.out.println("The disc has been removed");
                    break;
                }
            }
        }
        if (!discRemoved) {
            System.out.println("The disc was not found in the cart");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null) {
                total += itemOrdered[i].getCost();
            }
        }
        return total;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemOrdered[qtyOrdered++] = disc;
                System.out.println("The disc has been added: " + disc.getTitle());
            } else {
                System.out.println("The cart is full. Cannot add more discs.");
                break;
            }
        }
    }

    //public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
    //    for (DigitalVideoDisc disc : dvds) {
    //       if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    //            itemsOrdered[qtyOrdered++] = disc;
    //            System.out.println("The disc has been added: " + disc.getTitle());
    //        } else {
    //            System.out.println("The cart is full. Cannot add more discs.");
    //            break;
    //        }
    //    }
    //}

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered++] = dvd1;
            System.out.println("The disc " + dvd1.getTitle() + " has been added");
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered++] = dvd2;
            System.out.println("The disc " + dvd2.getTitle() + " has been added");
        }
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        }  
    }
    
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
  
        float totalCost = 0;
  
        for(int i = 0;i < qtyOrdered;i++){
           System.out.println((i + 1) + ". " + itemOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f $%n", totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id){
        for(int i = 0;i < qtyOrdered;i++){
           if(itemOrdered[i].getId() == id){
              System.out.println(itemOrdered[i].toString());
              return;
           }
        }
        System.out.println("Not found DVD with Id = " + id);
     }
  
     public void searchByTitle(String title){
        for(int i = 0;i < qtyOrdered;i++){
           if(itemOrdered[i].isMatch(title)){
              System.out.println(itemOrdered[i].toString());
              return;
           }
        }
        System.out.println("Not found DVD with title : " + title);
    }
}
