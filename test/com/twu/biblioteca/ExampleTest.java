package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void test_updateBookList(){
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, ArrayList<String>> testBooks = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        testBooks.put(1, first_bookInfos);

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        ArrayList<String> second_bookInfos = new ArrayList<String>();

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        assertEquals(testBooks, bib.updateBookList(testBooks, second_bookInfos));

    }

    @Test
    public void test_listBooks(){
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
        HashMap<Integer, String> test_menu = new HashMap<Integer, String>();

        test_menu.put(1, "List Books");
        test_menu.put(2, "Quit");

        String expect = "1List Books" + "2Quit";

        assertEquals(expect, bib.showMenu(test_menu));
    }

    @Test
    public void test_bookOptionValidation(){

        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, ArrayList<String>> testBooks = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        testBooks.put(1, second_bookInfos);

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        int book_options = 2;

        assertEquals(false, bib.bookOptionValidation(testBooks, book_options));
    }

    @Test
    public void test_menuOptionValidation() {
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, String> testMenu = new HashMap<Integer, String>();

        testMenu.put(1, "List Books");

        int menu_option = 2;

        assertEquals(false, bib.menuOptionValidation(testMenu, menu_option));
    }

    @Test
    public void test_quitOption() { // for bookshelf and menu

        BibliotecaApp bib = new BibliotecaApp();
        // test menu
        HashMap<Integer, String> test_menu = new HashMap<Integer, String>();

        test_menu.put(1, "List Books");
        test_menu.put(2, "Quit");

        assertEquals(1, bib.quitOption(test_menu));

        //test bookshelf
        HashMap<Integer, ArrayList<String>> test_bookshelf = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        test_bookshelf .put(1, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        test_bookshelf .put(2, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        test_bookshelf .put(3, third_bookInfos);

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(2, bib.quitOption(test_bookshelf));

    }


    @Test
    public void test_otherOption() { // for options other than quit

    }


}
