package com.twu.biblioteca;

import java.util.*;

public class BuildBiblioteca {

    //initial booklist with quit option
    public static HashMap<Integer,ArrayList<String>>  initializeBookList() {

        HashMap<Integer, ArrayList<String>> initialList = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> quitOpt = new ArrayList<String>();

        quitOpt.add("Quit");
        initialList.put(1, quitOpt);

        return initialList;
    }

    //add a new book infos
    public static ArrayList<String> createBook() {

        ArrayList newBook = new ArrayList();

        Scanner sc = new Scanner(System.in);
        String bookTitle = sc.nextLine();
        newBook.add(bookTitle);
        String author = sc.nextLine();
        newBook.add(author);
        String publishYear = sc.nextLine();
        newBook.add(publishYear);

        return newBook;

    }

    public static HashMap<Integer,ArrayList<String>>  updateBookList(HashMap<Integer, ArrayList<String>> bookList, ArrayList<String> new_book) {

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

    public static HashMap<Integer, String>  createMenu() {
        HashMap<Integer, String> menu = new HashMap<Integer, String>();

        menu.put(1, "Quit");
        menu.put(2, "List Books");
        menu.put(3, "Checkout Book");
        menu.put(4, "Return Book");

        return menu;
    }

//    public static HashMap<Integer, String> createBookPage() {
//        HashMap<Integer, String> bookPage = new HashMap<Integer, String>();
//
//        bookPage.put(1, "Quit");
//        bookPage.put(2, "Checkout");
//
//        return bookPage;
//    }


    public static HashMap<Integer,ArrayList<String>>  build() {

        HashMap<Integer,ArrayList<String>> bookshelf = initializeBookList();

        //bookshelf
        ArrayList<String> quitOpt = new ArrayList<String>();
        bookshelf .put(1, quitOpt);

        ArrayList<String> first_bookInfos = new ArrayList<String>();
        bookshelf .put(2, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        bookshelf .put(3, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        bookshelf .put(4, third_bookInfos);

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

        return bookshelf;

    }
}


