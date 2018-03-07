package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.OptionalInt;
import com.twu.biblioteca.BuildBiblioteca;


public class BibliotecaApp {

    HashMap<Integer,ArrayList<String>> bookList = BuildBiblioteca.build();
    HashMap<Integer, String> mainMenu = BuildBiblioteca.createMenu();
    HashMap<Integer, ArrayList<String>> checkedBooks = new HashMap<Integer, ArrayList<String>>();
    HashMap<Integer, String> bookPage = BuildBiblioteca.createBookPage();


    public String getCustomer_name() {

        Scanner sc = new Scanner(System.in);
        String customer_name = sc.nextLine();
        return customer_name;
    }

    public String printWelcome(String customer_name) {

        String welcome = "Hello " + customer_name + ". Welcome to Chenrui's Biblioteca. Type 0 to exit.";
        System.out.println(welcome);
        return welcome;
    }

    public HashMap listBooks() {

        System.out.println("------Bookshelf------");
        for (Object keySet : bookList.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(bookList.get(keySet));
        }
        return bookList;

    }



    public String showMenu() {

        System.out.println("------Main Menu------");

        String output = "";

        for (Object keySet : mainMenu.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(mainMenu.get(keySet));
            output += keySet.toString() + mainMenu.get(keySet);
        }
        return output;
    }

    public HashMap<Integer, String> showBook() {
        System.out.println("------Book------");

        String output = "";

        for (Object keySet : bookPage.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(bookPage.get(keySet));
            output += keySet.toString() + bookPage.get(keySet);
        }
        return bookPage;
    }

    public boolean optionValidation(HashMap optionsList, int option) {
        boolean validate = optionsList.containsKey(option);
        if (!validate) {
            System.out.println("Please select a valid option!");
        }
        return validate;
    }


    public int quitOption(HashMap optionList) {

        if (optionList.get(1) == "Quit" ) {
            System.out.println("------Quitting the system------");
            System.out.println("------See you next time------");
            return 1;
        }
        else if (optionList.get(1).getClass() == ArrayList.class) {
            System.out.println("------Redirecting to last page------");
            showMenu();
            return 2;
        }
        else
            System.out.println("System warning: illegal input!");
            return 0;
    }


    public HashMap checkOutBook(int bookIndex) {

        checkedBooks.put(bookIndex, bookList.get(bookIndex));
        bookList.replace(bookIndex, null);
        System.out.println("Thank you! Enjoy the book.");
        return listBooks();

    }

    // bookIndex is reachable in bookList and checkedBooks
    public HashMap returnBook(int bookIndex) {

        if (bookList.containsKey(bookIndex) & bookList.get(bookIndex)==null){
            if(bookList.replace(bookIndex, null, checkedBooks.get(bookIndex))){
                System.out.println("Thank you for returning the book.");
            }
            else
                System.out.println("That is not a valid book to return.");
        }
        else
            System.out.println("That is not a valid book to return.");

        return listBooks();

    }


    public void makeOption(HashMap currentList, int option) {

        if (currentList.get(1).getClass() == String.class) {
            if(option == 1){
                System.out.println("------Quitting the system------");
                System.out.println("------See you next time------"); // exit
            }
            else if(option == 2){
                listBooks(); // list books
            }
            else if(option == 3){ // return book
                Scanner sc = new Scanner(System.in);
                int next_opt = sc.nextInt();
                returnBook(next_opt);
            }
            else {
                System.out.println("Illegal input, please input a valid number.");
                System.out.println("------Quitting the system------");
                System.out.println("------See you next time------"); // exit
            }
        }
        else if (currentList.get(1).getClass() == ArrayList.class) {
            if(option==1){
                showMenu(); // back to menu
            }
            else{
                checkOutBook(option);
                checkedBooks.put(option, bookList.get(option));
                showBook(); // open book info page
            }
        }
        else {
            System.out.println("Illegal input, please input a valid number.");
            System.out.println("------Quitting the system------");
            System.out.println("------See you next time------"); // exit
        }
    }


    //continuous getting keyboard inputs
    public void continousInput() {
        System.out.println("Please make a move with number:");
        Scanner sc = new Scanner(System.in);
        int input;
        while(sc.hasNext()){
            input = sc.nextInt();
            if(input!= 0 & optionValidation(mainMenu, input)) {
                makeOption(listBooks(), input); //transfer input
            }
            if(input == 0) {
                System.out.println("------Quitting the system------");
                System.out.println("------See you next time------");
                break;
            }

        }
    }


    public static void main (String[]args){

        BibliotecaApp app = new BibliotecaApp();
        String customer = app.getCustomer_name();
        app.printWelcome(customer);
        app.showMenu();
        app.continousInput();



        }

}
