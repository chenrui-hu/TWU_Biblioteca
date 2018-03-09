package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.OptionalInt;
import com.twu.biblioteca.BuildBiblioteca;


public class BibliotecaApp {

    HashMap<Integer, ArrayList<String>> bookList = BuildBiblioteca.buildBookshelf();
    HashMap<Integer, ArrayList<String>> movieList = BuildBiblioteca.buildMovieshelf();
    HashMap<Integer, String> mainMenu = BuildBiblioteca.createMenu();
    HashMap<Integer, ArrayList<String>> itemLib = BuildBiblioteca.buildItemLib();
    HashMap<Integer, ArrayList<String>> checkedItems = BuildBiblioteca.initializeList();


    public String getCustomer_name() {

        System.out.println("How are you? Please type in your name: ");
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

    public  HashMap listMovies() {
        System.out.println("------Movieshelf------");
        for (Object keySet : movieList.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(movieList.get(keySet));
        }
        return movieList;
    }

    public HashMap listBorrowed() {
        System.out.println("------Borrowed Items------");
        for (Object keySet : checkedItems.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(checkedItems.get(keySet));
        }
        return checkedItems;
    }

    public HashMap listLib() {
        System.out.println("------Library------");
        for (Object keySet : itemLib.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(itemLib.get(keySet));
        }
        return itemLib;
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

//    public HashMap<Integer, String> showBook() {
//        System.out.println("------Book------");
//
//        String output = "";
//
//        for (Object keySet : bookPage.keySet()) {
//            System.out.print(keySet + "   ");
//            System.out.println(bookPage.get(keySet));
//            output += keySet.toString() + bookPage.get(keySet);
//        }
//        return bookPage;
//    }

    public boolean optionValidation(HashMap optionsList, int option) {
        boolean validate = optionsList.containsKey(option);
        if (!validate & option != 0) {
            System.out.println("Please select a valid option!");
        }
        return validate;
    }


    public int quitOption(HashMap optionList) {

        if (optionList.get(1) == "Quit") {
            System.out.println("------Quitting the system------");
            System.out.println("------See you next time------");
            return 1;
        } else if (optionList.get(1).getClass() == ArrayList.class) {
            System.out.println("------Redirecting to last page------");
            showMenu();
            return 2;
        } else
            System.out.println("System warning: illegal input!");
        return 0;
    }


    public HashMap checkOutItem(int itemIndex) {

        if(itemLib.get(itemIndex) != null) {
            checkedItems.put(itemIndex, itemLib.get(itemIndex));
            itemLib.replace(itemIndex, null);
            System.out.println("Thank you! Enjoy the book.");
        }
        else{
            System.out.println("That book has been borrowed.");
        }
        return itemLib;

    }

    // bookIndex is reachable in bookList and checkedItems
    public HashMap returnItem(int itemIndex) {

        if (itemLib.containsKey(itemIndex) & itemLib.get(itemIndex) == null) {
            if (itemLib.replace(itemIndex, null, checkedItems.get(itemIndex))) {
                checkedItems.remove(itemIndex);
                System.out.println("Thank you for returning the book.");
            } else
                System.out.println("That is not a valid book to return.");
        } else
            System.out.println("That is not a valid book to return.");

        return itemLib;

    }


    public int makeOption(HashMap currentList, int option) {

        if (currentList.get(1).getClass() == String.class) {
            HashMap currentPage = mainMenu;
            if(option==1){
                return 0;
            }
            else if(currentPage.containsKey(option)) {
                return option;
            }
            else{
                System.out.println("Illegal input, please input a valid number.");
                return 1;
            }
        }
        else if (currentList.get(1).getClass() == ArrayList.class) {
            HashMap currentPage = itemLib;
            if (option == 0) {
                return 0;
            }
            else if (option == 1) {
                return 1; // back to menu
            }
            else if (currentPage.containsKey(option) & currentPage.get(option)!=null) {
                checkOutItem(option);
                return 4; //list books
            }
            else if (currentPage.containsKey(option) & checkedItems.containsKey(option)){
                returnItem(option);
                return 4;
            }
            else {
                System.out.println("Illegal input, please input a valid number.");
                return 4;
            }

        }
        else {
            System.out.println("Illegal input, please input a valid number.");
            return 4;
        }
    }


    //continuous getting keyboard inputs. bookshelf->book->checkout bug.
    public void continousInput() {
        System.out.println("Please make a move with number:");
        Scanner sc = new Scanner(System.in);
        int input;
        HashMap currentPage = mainMenu;
        while (sc.hasNext()) {
            input = sc.nextInt();
            if (input != 0 & optionValidation(currentPage, input)) {
                int opt = makeOption(currentPage, input); //transfer input
                if (opt == 0) {
                    input = 0;
                }
                else if (opt == 1) {
                    showMenu();
                    currentPage = mainMenu;
                    continue;
                }
                else if(opt == 2){
                    listBooks();
                    currentPage = bookList;
                    continue;
                }
                else if(opt == 3){
                    listMovies();
                    currentPage = movieList;
                    continue;
                }else if (opt == 4) {
                    listLib();
                    currentPage = itemLib;
                    continue;
                }
                else if(opt == 5){
                    listBorrowed();
                    currentPage = itemLib;
                    continue;
                }
            }
            if (input == 0) {
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
