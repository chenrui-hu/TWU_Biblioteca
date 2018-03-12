package com.twu.biblioteca;

import java.util.*;

public class BuildBiblioteca {

    //initial booklist with quit option
    public static HashMap<Integer,ArrayList<String>>  initializeList() {

        HashMap<Integer, ArrayList<String>> initialList = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> quitOpt = new ArrayList<String>();

        quitOpt.add("Quit");
        initialList.put(1, quitOpt);

        return initialList;
    }

    public static ArrayList<String> createItem() {

        ArrayList<String> new_item = new ArrayList<String>();

        System.out.println("Book example: Test Driven Development/Viktor Farcic; Alex Garcia/2009");
        System.out.println("Movie example: Big Fish/2003/Tim Burton/8.0");
        System.out.println("Please add item information, separate with /: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (String retval : input.split("/")) {
            new_item.add(retval);
        }
        return new_item;
    }

    //ready for updating
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
        menu.put(3, "List Movies");
        menu.put(4, "Checkout Book");
        menu.put(5, "Return Book");
        menu.put(6, "Account");

        return menu;
    }

    public static HashMap<Integer, String>  UniversalMenu() {

        HashMap<Integer, String> u_menu = new HashMap<Integer, String>();

        u_menu.put(1, "Quit");
        u_menu.put(2, "Login");

        return u_menu;
    }

//    public static HashMap<Integer, String> createBookPage() {
//        HashMap<Integer, String> bookPage = new HashMap<Integer, String>();
//
//        bookPage.put(1, "Quit");
//        bookPage.put(2, "Checkout");
//
//        return bookPage;
//    }


    public static HashMap<Integer,ArrayList<String>>  buildBookshelf() {

        HashMap<Integer,ArrayList<String>> bookshelf = initializeList();

        //bookshelf
        ArrayList<String> first_bookInfos = new ArrayList<String>();
        bookshelf .put(12, first_bookInfos);

        ArrayList<String> second_bookInfos = new ArrayList<String>();
        bookshelf .put(13, second_bookInfos);

        ArrayList<String> third_bookInfos = new ArrayList<String>();
        bookshelf .put(14, third_bookInfos);

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

    public static HashMap<Integer, ArrayList<String>> buildMovieshelf() {

        HashMap<Integer, ArrayList<String>> movie_shelf = initializeList();

        //movieshelf
        ArrayList<String> first_movieInfos = new ArrayList<String>();
        movie_shelf.put(22, first_movieInfos);

        ArrayList<String> second_movieInfos = new ArrayList<String>();
        movie_shelf.put(23, second_movieInfos);

        ArrayList<String> third_movieInfos = new ArrayList<String>();
        movie_shelf.put(24, third_movieInfos);

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

        return movie_shelf;

    }

    public static HashMap<Integer, ArrayList<String>> buildItemLib(){
        HashMap itemLib = new HashMap();
        itemLib.putAll(buildBookshelf());
        itemLib.putAll(buildMovieshelf());
        return itemLib ;
    }
}


