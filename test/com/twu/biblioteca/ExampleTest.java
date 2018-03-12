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
        String welcome = "Hello Bill. Welcome to Chenrui's Biblioteca. Type 0 to exit.";
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
        testBooks.put(12, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        testBooks.put(13, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        testBooks.put(14, third_bookInfos);

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
        test_menu.put(3, "List Movies");
        test_menu.put(4, "Checkout Book");
        test_menu.put(5, "Return Book");
        test_menu.put(6, "Account");

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

        HashMap test_bookshelf =  bib.buildBookshelf();
        HashMap test_menu = bib.createMenu();

        assertEquals(2, app.quitOption(test_bookshelf));
        assertEquals(1, app.quitOption(test_menu));

    }

    @Test
    public void test_checkOutItem() {

        BibliotecaApp app = new BibliotecaApp();
        BuildBiblioteca bib = new BuildBiblioteca();

        HashMap<Integer, ArrayList<String>> test_bookList = bib.buildBookshelf();
        HashMap<Integer, ArrayList<String>> required_bookList = new HashMap<Integer, ArrayList<String>>();
        HashMap<Integer, ArrayList<String>> test_movieList = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> quitOpt = new ArrayList<String>();
        required_bookList.put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        test_bookList .put(12, first_bookInfos);
        required_bookList.put(12, null);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        test_bookList.put(13, second_bookInfos);
        required_bookList.put(13, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        test_bookList.put(14, third_bookInfos);
        required_bookList.put(14, third_bookInfos);

        ArrayList<String> first_movieInfos = new ArrayList<String>();
        test_movieList .put(22, first_movieInfos);
        required_bookList.put(22, first_movieInfos);

        ArrayList<String> second_movieInfos = new ArrayList<String>();
        test_movieList .put(23, second_movieInfos);
        required_bookList.put(23, second_movieInfos);

        ArrayList<String> third_movieInfos = new ArrayList<String>();
        test_movieList .put(24, third_movieInfos);
        required_bookList.put(24, third_movieInfos);

        quitOpt.add("Quit");

        first_movieInfos.add("Big Fish");
        first_movieInfos.add("2003");
        first_movieInfos.add("Tim Burton");
        first_movieInfos.add("8.0");

        second_movieInfos.add("The Shawshank Redemption");
        second_movieInfos.add("1994");
        second_movieInfos.add("Frank Darabont");
        second_movieInfos.add("9.3");

        third_movieInfos.add("The Godfather");
        third_movieInfos.add("1972");
        third_movieInfos.add("Francis Ford Coppola");
        third_movieInfos.add("9.2");

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(required_bookList, app.checkOutItem(12));
    }


    @Test
    public void test_returnItem() {

        BibliotecaApp app = new BibliotecaApp();
        BuildBiblioteca bib = new BuildBiblioteca();

        HashMap<Integer, ArrayList<String>> test_bookList = bib.buildBookshelf();
        HashMap<Integer, ArrayList<String>> required_bookList = new HashMap<Integer, ArrayList<String>>();
        HashMap<Integer, ArrayList<String>> test_movieList = new HashMap<Integer, ArrayList<String>>();

        ArrayList<String> quitOpt = new ArrayList<String>();
        required_bookList.put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        test_bookList .put(12, null);
        required_bookList.put(12, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        test_bookList.put(13, second_bookInfos);
        required_bookList.put(13, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        test_bookList.put(14, third_bookInfos);
        required_bookList.put(14, third_bookInfos);

        ArrayList<String> first_movieInfos = new ArrayList<String>();
        test_movieList .put(22, first_movieInfos);
        required_bookList.put(22, first_movieInfos);

        ArrayList<String> second_movieInfos = new ArrayList<String>();
        test_movieList .put(23, second_movieInfos);
        required_bookList.put(23, second_movieInfos);

        ArrayList<String> third_movieInfos = new ArrayList<String>();
        test_movieList .put(24, third_movieInfos);
        required_bookList.put(24, third_movieInfos);

        quitOpt.add("Quit");

        first_movieInfos.add("Big Fish");
        first_movieInfos.add("2003");
        first_movieInfos.add("Tim Burton");
        first_movieInfos.add("8.0");

        second_movieInfos.add("The Shawshank Redemption");
        second_movieInfos.add("1994");
        second_movieInfos.add("Frank Darabont");
        second_movieInfos.add("9.3");

        third_movieInfos.add("The Godfather");
        third_movieInfos.add("1972");
        third_movieInfos.add("Francis Ford Coppola");
        third_movieInfos.add("9.2");

        first_bookInfos.add("Head First Java: 2nd Edition");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("2009");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("2003");

        third_bookInfos.add("Think Python: 2nd Edition");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("2015");

        assertEquals(required_bookList , app.returnItem(12));

    }

    @Test
    public void test_checkStatus(){

        BibliotecaApp app = new BibliotecaApp();
        String[] librarian = new String[]{"000-0000", "js12345"};
        String[] customer = new String[]{"000-0001", "annbrown"};

        //assertEquals(true, app.checkStatus(librarian));
        //assertEquals(true, app.checkStatus(customer));
    }


}
