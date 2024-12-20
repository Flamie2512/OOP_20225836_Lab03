package hust.soict.dsai.aims.test.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import hust.soict.dsai.aims.cart.Cart;

public class cartTest {
    public static void main(String[] args) {
    //Create a new cart 
    Cart cart = new Cart();
    //Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f); cart.addDigitalVideoDisc(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); cart.addDigitalVideoDisc(dvd2);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); cart.addDigitalVideoDisc(dvd3);
    //Test the print method 
    cart.print();
    //To-do: Test the search methods here
    System.out.println("Search by id");
        cart.searchById(4);

    System.out.println("Search by title");
    cart.searchByTitle("The Lion King");
    }
}