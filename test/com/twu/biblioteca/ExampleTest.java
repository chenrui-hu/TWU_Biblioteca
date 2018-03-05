package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.ArrayList;


public class ExampleTest {

    @Test
    public void test_printWelcome() {

        BibliotecaApp bib = new BibliotecaApp();
        String welcome = "Hello Bill. Welcome to Chenrui's Biblioteca. Please pick the book(s) that interest(s) you.";
        assertEquals(welcome, bib.printWelcome("Bill"));
    }

    @Test
    public void test_getBookList(){
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, ArrayList<String>> testBooks = new HashMap<Integer, ArrayList<String>>();
        assertEquals(testBooks, bib.listBooks(testBooks));
    }


    @Test
    public void test_bookList(){
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, ArrayList<String>> testBooks = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        testBooks.put(1, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        testBooks.put(2, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        testBooks.put(3, third_bookInfos);

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(testBooks, bib.listBooks(testBooks));
    }

    @Test
    public void test_showMenu(){
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, ArrayList<String>> test_menu = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> first_item = new ArrayList<String>();

        first_item.add("List Books");
        test_menu.put(1, first_item);

        String expect = "1[List Books]";

        assertEquals(expect, bib.showMenu(test_menu));
    }

    @Test
    public void test_menuOptionValidation(){
        BibliotecaApp bib = new BibliotecaApp();
    }

}
