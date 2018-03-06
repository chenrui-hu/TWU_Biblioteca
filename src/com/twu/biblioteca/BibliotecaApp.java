package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

public class BibliotecaApp {

    public static HashMap<Integer, ArrayList<String>> bookList = new HashMap<Integer, ArrayList<String>>();


    public static String getCustomer_name() {

        Scanner sc = new Scanner(System.in);
        String customer_name = sc.nextLine();
        return customer_name;
    }

    public static String printWelcome(String customer_name) {

        String welcome = "Hello " + customer_name + ". Welcome to Chenrui's Biblioteca. Please pick the book(s) that interest(s) you.";
        System.out.println(welcome);
        return welcome;
    }

    public HashMap listBooks(HashMap bookList) {

        System.out.println("------BOOKSHELF------");
        for (Object keySet : bookList.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(bookList.get(keySet));
        }
        return bookList;

    }

    public HashMap createBookList() {

        HashMap<Integer, ArrayList<String>> initialBookList = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> firstBook = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        String bookTitle = sc.nextLine();
        firstBook.add(bookTitle);
        String publishYear = sc.nextLine();
        firstBook.add(publishYear);

        initialBookList.put(1, firstBook);

        return initialBookList;

    }


    public HashMap updateBookList(HashMap<Integer, ArrayList<String>> bookList, ArrayList<String> new_book) {

        Iterator iter = bookList.keySet().iterator();
        int key = 1;
        while (iter.hasNext()) {
            Object obj = iter.next();
            key = Integer.parseInt(obj.toString());
        }
        bookList.put(key + 1, new_book);

        // System.out.println(bookList); // for test only
        return bookList;
    }

    public HashMap createMenu() {
        HashMap<Integer, String> menu = new HashMap<Integer, String>();

        menu.put(1, "List Books");
        menu.put(2, "Quit");

        return menu;
    }

    public String showMenu(HashMap<Integer, String> menu) {

        System.out.println("------Main Menu------");

        String output = "";

        for (Object keySet : menu.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(menu.get(keySet));
            output += keySet.toString() + menu.get(keySet);
        }
        return output;
    }

    public boolean bookOptionValidation(HashMap<Integer, ArrayList<String>> book_options, int option) {
        boolean validate = book_options.containsKey(option);
        if (!validate) {
            System.out.println("Please select a valid book!");
        }
        return validate;
    }

    public boolean menuOptionValidation(HashMap<Integer, String> menu_options, int option) {
        boolean validate = menu_options.containsKey(option);
        if (!validate) {
            System.out.println("Please select a valid option!");
        }
        return validate;
    }

    public int quitOption(HashMap optionList) {

        ArrayList rdm = new ArrayList();
        if (optionList.get(1) == rdm.getClass()) {
            
            return 1;
        }
        else if (optionList.get(1).getClass() == rdm.getClass()) {
            return 2;
        }
        else
            return 0;
    }

        public static void main (String[]args){

            printWelcome(getCustomer_name());
        }

}
