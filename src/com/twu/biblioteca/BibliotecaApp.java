package com.twu.biblioteca;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;


public class BibliotecaApp {

    HashMap<Integer, ArrayList<String>> bookList = BuildBiblioteca.buildBookshelf();
    HashMap<Integer, ArrayList<String>> movieList = BuildBiblioteca.buildMovieshelf();
    HashMap<Integer, String> mainMenu = BuildBiblioteca.createMenu();
    HashMap<Integer, String> helloPage = BuildBiblioteca.UniversalMenu();
    HashMap<Integer, ArrayList<String>> itemLib = BuildBiblioteca.buildItemLib();
    HashMap<Integer, ArrayList<String>> checkedItems = BuildBiblioteca.initializeList();
    ArrayList<String> User = new ArrayList<String>();



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

    public String showHome() {

        System.out.println("------Home------");

        String output = "";

        for (Object keySet : helloPage.keySet()) {
            System.out.print(keySet + "   ");
            System.out.println(helloPage.get(keySet));
            output += keySet.toString() + helloPage.get(keySet);
        }
        return output;
    }

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


    public boolean checkStatus() {

        System.out.println("Please login your account, id/password: ");
        Scanner sc = new Scanner(System.in);
        String[] loginInfos = sc.nextLine().split("/");
        boolean result = false;
        try {
            FileInputStream fstream = new FileInputStream("./DataBase/UserLogin.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] user = strLine.split("/");
                if (Arrays.equals(loginInfos,user)) {
                    User.add(user[0]);
                    result = true;

                }
                continue;
            }
            in.close();
        }catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } finally {
            return result;
        }
    }

    public ArrayList getUserInfos(String id) {

        ArrayList<String> details = new ArrayList<>();
        try {
            FileInputStream fstream = new FileInputStream("./DataBase/UserData.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] infos = strLine.split("/");
                if(User.get(0).equals(infos[0])){
                    User.add(infos[2]);
                    User.add(infos[3]);
                    User.add(infos[4]);
                    return User;
                }
                else{
                    System.out.println("NO ACCESS!");
                }
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } finally {
            return User;
        }
    }

    public boolean showAccount() {

        getUserInfos(User.get(0));
        System.out.println("------Account------");
        System.out.println("Name: " + User.get(1));
        System.out.println("ID: " + User.get(0));
        System.out.println("Email: " + User.get(2));
        System.out.println("Phone: " + User.get(3));
        System.out.println("Please type 1 to go back.");

        return true;
    }

    //continuous getting keyboard inputs. bookshelf->book->checkout bug.
    public void continousInput() {
        System.out.println("Please make a move with number:");
        showHome();
        boolean status = false;
        Scanner scan = new Scanner(System.in);
        int input;
        //not login
        HashMap currentPage = helloPage;
        while (!status & scan.hasNext()) {
            input = scan.nextInt();
            if (input != 0 & optionValidation(currentPage, input)) {
                if (input == 1) {
                    input = 0;
                }
                else if (input == 2) {
                    if (checkStatus() == true) {
                        System.out.println("Login successfully!");
                        showMenu();
                        currentPage = mainMenu;
                        status = true;
                        break;
                    } else {
                        System.out.println("Wrong ID and/or password, please try again.");
                        break;
                    }
                }
            }
            if (input == 0) {
                System.out.println("------Quitting the system------");
                System.out.println("------See you next time------");
                break;
            }
        }
        Scanner sc = new Scanner(System.in);
        while (status & sc.hasNext()) {
            input = sc.nextInt();
            if (input != 0 & optionValidation(currentPage, input)) {
                int opt = makeOption(currentPage, input); //transfer input
                if (opt == 0) {
                    input = 0;
                } else if (opt == 1) {
                    showMenu();
                    currentPage = mainMenu;
                    continue;
                } else if (opt == 2) {
                    listBooks();
                    currentPage = bookList;
                    continue;
                } else if (opt == 3) {
                    listMovies();
                    currentPage = movieList;
                    continue;
                } else if (opt == 4) {
                    listLib();
                    currentPage = itemLib;
                    continue;
                } else if (opt == 5) {
                    listBorrowed();
                    currentPage = itemLib;
                    continue;
                }else if (opt == 6) {
                    showAccount();
                    currentPage = itemLib;
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
        app.continousInput();
    }


}
