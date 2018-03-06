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

    //initial booklist with quit option
    public HashMap initializeBookList() {

        HashMap<Integer, ArrayList<String>> initialList = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> quitOpt = new ArrayList<String>();

        quitOpt.add("Quit");
        initialList.put(1, quitOpt);

        return initialList;
    }

    //add a new book infos
    public ArrayList<String> createBook() {

        ArrayList<String> newBook = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        String bookTitle = sc.nextLine();
        newBook.add(bookTitle);
        String publishYear = sc.nextLine();
        newBook.add(publishYear);


        return newBook;

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

        menu.put(1, "Quit");
        menu.put(2, "List Books");
        menu.put(3, "Return Book");

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
            System.out.println("That book is not available.");
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

    public int makeOption() {
        System.out.println("Please make a move with number: ");
        try {
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            return option;
        }catch (Exception e) {
            System.out.println("Illegal input, please input a number.");
            makeOption();
            return 0;
        }

    }

    public int quitOption(HashMap optionList, HashMap menu, HashMap bookList) {

        if (optionList.get(1) == "Quit" ) {
            System.out.println("------Quitting the system------");
            System.out.println("------See you next time------");
            return 1;
        }
        else if (optionList.get(1).getClass() == ArrayList.class) {
            System.out.println("------Redirecting to last page------");
            if (optionList.get(2) == "Check out" ){
                checkOutBook(bookList, makeOption());
            }
            else
                showMenu(menu);
            return 2;
        }
        else
            System.out.println("System warning: illegal input!");
            return 0;
    }


    public HashMap checkOutBook(HashMap bookList, int bookIndex) {

        bookList.remove(bookIndex);
        System.out.println("Thank you! Enjoy the book.");
        return listBooks(bookList);

    }

    // how to manage key with much more books
    public HashMap returnBook(HashMap bookList, int bookIndex, ArrayList book) {

        if (bookIndex == 2) {
            bookList.put(2, book);
            System.out.println("Thank you for returning the book.");
            return listBooks(bookList);
        }
        else
            System.out.println("That is not a valid book to return.");
            return listBooks(bookList);
    }


        public static void main (String[]args){

            printWelcome(getCustomer_name());
        }

}
