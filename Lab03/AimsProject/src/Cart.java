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

    // New overloaded method that accepts an array of DigitalVideoDisc
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemOrdered[qtyOrdered++] = dvd;
                System.out.println("The disc has been added: " + dvd.getTitle());
            }
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
                break;
            }
        }
    }

    // New overloaded method that accepts varargs (arbitrary number of DigitalVideoDisc)
    //public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    //    for (DigitalVideoDisc dvd : dvdList) {
    //       if (qtyOrdered < MAX_NUMBERS_ORDERED) {
    //            itemOrdered[qtyOrdered++] = dvd;
    //            System.out.println("The disc has been added: " + dvd.getTitle());
    //       }
    //        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
    //            System.out.println("The cart is almost full");
    //            break;
    //        }
    //    }
    //}

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered++] = dvd1;
            itemOrdered[qtyOrdered++] = dvd2;
            System.out.println("The discs have been added: " + dvd1.getTitle() + " and " + dvd2.getTitle());
        } else {
            System.out.println("Not enough space to add discs.");
        }
    }
}
