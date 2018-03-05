package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

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
        for(Object keySet: bookList.keySet()){
            System.out.print(keySet+"   ");
            System.out.println(bookList.get(keySet));
        }
        return bookList;

    }


    public HashMap bookList(HashMap<Integer, ArrayList<String>> bookList, ArrayList<String> new_book){

        Iterator iter = bookList.keySet().iterator();
        int key = 1;
        while(iter.hasNext()){
            Object obj = iter.next();
            key = Integer.parseInt(obj.toString());
        }
        bookList.put(key+1, new_book);

        return bookList;
    }

//    public createBook(){
//        ArrayList<String> book = new ArrayList<String>();
//        book.add()
//        return book;
//    }


    public static void main(String[] args) {

        printWelcome(getCustomer_name());
    }
}
