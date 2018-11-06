/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import junit.framework.TestCase;

/**
 *
 * @author dalevanh
 */
public class BookTest extends TestCase {
    Book book;
    public BookTest(String testName) {
        super(testName);
        book = new Book("1234567", "Book 1", "Author 1", 100.00);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        book = new Book("1234567", "Book 1", "Author 1", 100.00);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getIsbn method, of class Book.
     */
    public void testGetIsbn() {
        System.out.println("getIsbn");
        Book instance = book;
        String expResult = "1234567";
        String result = instance.getIsbn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Book.
     */
    public void testGetTitle() {
        System.out.println("getTitle");
        Book instance = book;
        String expResult = "Book 1";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Book instance = book;
        String expResult = "Author 1";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Book.
     */
    public void testGetPrice() {
        System.out.println("getPrice");
        Book instance = book;
        double expResult = 100.00;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Book.
     */
    public void testToString() {
        System.out.println("toString");
        Book instance = book;
        String expResult = "Title: " +  instance.getTitle() + "  ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDollarPrice method, of class Book.
     */
    public void testGetDollarPrice() {
        System.out.println("getDollarPrice");
        Book instance = book;
        String expResult = "$100.00";
        String result = instance.getDollarPrice();
        assertEquals(expResult, result);
    }
    
}
