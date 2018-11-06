/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import junit.framework.TestCase;

/**
 *
 * @author Administrator
 */
public class CartItemTest extends TestCase {

    private CartItem cartItem;
    private Book book;

    public CartItemTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        book = new Book("1234567", "Book 1", "Author 1", 100.00);
        cartItem = new CartItem(book);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of setQuantity method, of class CartItem.
     */
    public void testSetQuantity() {
        System.out.println("setQuantity");
        cartItem.setQuantity(90);
        cartItem.setQuantity(50);
        int expResult = 140;
        int result = cartItem.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateQuantity method, of class CartItem.
     */
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        cartItem.updateQuantity(100);
        int expResult = 100;
        int result = cartItem.getQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDollarOrderCost method, of class CartItem.
     */
    public void testGetDollarOrderCost() {
        System.out.println("getDollarOrderCost");
        cartItem.setQuantity(10);
        String expResult = "$1000.00";
        String result = cartItem.getDollarOrderCost();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CartItem.
     */
    public void testToString() {
        System.out.println("toString");
        String expResult = book.toString() +"          "+"quantity: " + cartItem.getQuantity();
        String result = cartItem.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBook method, of class CartItem.
     */
    public void testGetBook() {
        System.out.println("getBook");
        Book expResult = book;
        Book result = cartItem.getBook();
        assertSame(expResult, result);
    }

    /**
     * Test of getOrderCost method, of class CartItem.
     */
    public void testGetOrderCost() {
        System.out.println("getOrderCost");

        cartItem.setQuantity(10);
        double expResult = 1000;
        double result = cartItem.getOrderCost();
        assertEquals(expResult, result);
        assertEquals("delta < 0.01", expResult, result, 0.01);
    }

    /**
     * Test of getQuantity method, of class CartItem.
     */
    public void testGetQuantity() {
        System.out.println("getQuantity");
        cartItem.setQuantity(50);
        int expResult = 50;
        int result = cartItem.getQuantity();
        assertEquals(expResult, result);
    }
}
