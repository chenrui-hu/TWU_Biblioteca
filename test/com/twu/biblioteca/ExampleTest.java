package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class ExampleTest {

    @Test
    public void test_printWelcome() {

        BibliotecaApp bib = new BibliotecaApp();
        String welcome = "Hello Bill. Welcome to Chenrui's Biblioteca, we are ready to serve you now.";
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

        first_bookInfos.add("Head First Java");
        first_bookInfos.add("Kathy Sierra; Bert Bates");
        first_bookInfos.add("O'Reilly Media");

        second_bookInfos.add("Test Driven Development");
        second_bookInfos.add("Viktor Farcic; Alex Garcia");
        second_bookInfos.add("Packt Publishing");

        third_bookInfos.add("Think Python");
        third_bookInfos.add("Allen B. Downey");
        third_bookInfos.add("Green Tea Press");

        assertEquals(testBooks, bib.listBooks(testBooks));
    }

}
