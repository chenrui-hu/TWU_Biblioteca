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
        BuildBiblioteca bib = new BuildBiblioteca();
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

        ArrayList<String> quitOpt = new ArrayList<>();
        testBooks.put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        testBooks.put(2, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        testBooks.put(3, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        testBooks.put(4, third_bookInfos);

        quitOpt.add("Quit");

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(testBooks, bib.listBooks());
    }

    @Test
    public void test_createMenu(){
        BuildBiblioteca bib = new BuildBiblioteca();
        HashMap<Integer, String> test_menu = new HashMap<Integer, String>();

        test_menu.put(1, "Quit");
        test_menu.put(2, "List Books");
        test_menu.put(3, "Return Book");

        assertEquals(test_menu, bib.createMenu());
    }

    @Test
    public void OptionValidation() {
        BibliotecaApp bib = new BibliotecaApp();
        HashMap<Integer, String> testMenu = new HashMap<Integer, String>();
        HashMap<Integer, ArrayList<String>> testBooks = new HashMap<Integer, ArrayList<String>>();

        // bookshelf
        ArrayList<String> second_bookInfos = new ArrayList<String>();
        testBooks.put(1, second_bookInfos);

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        int book_options = 1;

        testMenu.put(1, "List Books");

        int menu_option = 2;

        assertEquals(false, bib.optionValidation(testMenu, menu_option));
        assertEquals(true, bib.optionValidation(testBooks, book_options));

    }

    @Test
    public void test_quitOption() { // for bookshelf and menu

        BuildBiblioteca bib = new BuildBiblioteca();
        BibliotecaApp app = new BibliotecaApp();

        HashMap test_bookshelf =  bib.build();
        HashMap test_menu = bib.createMenu();

        assertEquals(2, app.quitOption(test_bookshelf));
        assertEquals(1, app.quitOption(test_menu));

    }

    @Test
    public void test_checkOutBook() {

        BibliotecaApp app = new BibliotecaApp();
        BuildBiblioteca bib = new BuildBiblioteca();
        HashMap<Integer, ArrayList<String>> test_bookList = bib.build();
        HashMap<Integer, ArrayList<String>> required_bookList = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> quitOpt = new ArrayList<String>();
        required_bookList.put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        test_bookList .put(2, first_bookInfos);
        required_bookList.put(2, null);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        test_bookList.put(3, second_bookInfos);
        required_bookList.put(3, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        test_bookList.put(4, third_bookInfos);
        required_bookList.put(4, third_bookInfos);

        quitOpt.add("Quit");

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(required_bookList, app.checkOutBook(2));
    }


    @Test
    public void test_returnBook() {

        BibliotecaApp app = new BibliotecaApp();

        HashMap<Integer, ArrayList<String>> new_bookList = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> book = new ArrayList<String>();

        book.add("Head First Java: 2nd Edition");
        book.add("Kathy Sierra; Bert Bates");
        book.add("2009");

        app.checkedBooks.put(2, book);

        ArrayList<String> quitOpt = new ArrayList<String>();
        app.bookList.put(1, quitOpt);
        new_bookList.put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        app.bookList.put(2, null);
        new_bookList.put(2, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        app.bookList.put(3, second_bookInfos);
        new_bookList.put(3, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        app.bookList.put(4, third_bookInfos);
        new_bookList.put(4, third_bookInfos);

        quitOpt.add("Quit");

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(new_bookList, app.returnBook(2));
        assertEquals(app.bookList, app.returnBook(3));

    }


}
