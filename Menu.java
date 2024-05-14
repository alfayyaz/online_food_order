

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Menu {
    int total=0;
    String File_name = "log.txt";

    ArrayList<String> orderedItems = new ArrayList<>();

    public void display_menu() {
    int choice;

    System.out.println("Welcome to cheezious online!");
    System.out.println("Select your desired category");
    System.out.println("1:Burgers");
    System.out.println("2:Sandwitch");
    System.out.println("3:pizza");
    System.out.println("4:Side Bar ");
    System.out.println("5:Exit");
    Scanner sc = new Scanner(System.in);
     choice = sc.nextInt();
    switch(choice){

      case 1:
     burgers();
     break;
        case 2:
            sandwitch();
        case 3:
            pizza();
        case 4:
            sidebar();
        case 5:
            continuity();
           break;
}}
public void burgers() {
    int option;
    do {
        System.out.println("1:Chicken burger........350");
        System.out.println("2:Cheese burger........450");
        System.out.println("3:Beef burger........550");
        System.out.println("4:Exit");
        Scanner sc = new Scanner(System.in);

        option = sc.nextInt();

        switch (option) {
            case 1:
                quantity("chicken burger", 350);
                cold_drink();
                break;
            case 2:
                quantity("Cheese burger", 450);
                cold_drink();
                break;

            case 3:
                quantity("beef burger", 550);
                cold_drink();
                break;

            case 4:
                continuity();
                break;
        }
    } while (option != 4);
}

public void sandwitch(){
int option;
    do{
    System.out.println("1:Egg sandwitch.......250");
    System.out.println("2:cheese sandwicth.......350");
    System.out.println("3:Chicken sandwitch.......450");
    System.out.println("4:Exit");
Scanner sc=new Scanner(System.in);
option=sc.nextInt();
switch (option){
    case 1:
        quantity("Egg sandwitch",250);
cold_drink();
break;
    case 2:
        quantity("cheese sandwitch",350);
  cold_drink();
  break;
    case 3:
        quantity("chicken sandwitch",450);
cold_drink();
break;
    case 4:
        continuity();
break;

}
}while(option!=4);}
    public void pizza(){
        int option;
        do{
            System.out.println("Select your desired pizza");
            System.out.println("1:Fajita .......1250");
            System.out.println("2:cheese .......1350");
            System.out.println("3:Deep dish pizza.......1450");
            System.out.println("4:Exit");
            Scanner sc=new Scanner(System.in);
            option=sc.nextInt();
            switch (option){
                case 1:
                    quantity("Fajita",1250);
                    cold_drink();
                    break;
                case 2:
                    quantity("cheese ",1350);
                    cold_drink();
                    break;
                case 3:
                    quantity("Deep dish",1450);
                    cold_drink();
                    break;
                case 4:
                    continuity();
                    break;

            }
        }while(option!=4);}
    public void sidebar(){
        int option;
        do{
            System.out.println("Select your item");
            System.out.println("1:Extra mayo .......50");
            System.out.println("2:Salad .......250");
            System.out.println("3:Fried chicken x2pcs.......600");
            System.out.println("4:Exit");
            Scanner sc=new Scanner(System.in);
            option=sc.nextInt();
            switch (option){
                case 1:
                    quantity("Mayo",50);

                    break;
                case 2:
                    quantity("salad ",250);

                    break;
                case 3:
                    quantity("Fried chicken",600);

                    break;
                case 4:
                    continuity();
                    break;

            }
        }while(option!=4);}

    public void cold_drink(){
    System.out.println("Do you want cold drink? Press 1 for yes or 2 for no");

    Scanner sc=new Scanner(System.in);
    int option = sc.nextInt();
    if(option== 1) {
        System.out.println("Select your desired colddrink:");
        System.out.println("1:Gourmnet cola........100");
        System.out.println("2:Big apple........110");
        System.out.println("3:Next cola........120");
        System.out.println("4:Exit ");
        int option2=sc.nextInt();
switch (option2) {
    case 1:
        quantity("Gourment cola",100);
        break;

    case 2:
        quantity("big apple",110);
break;
    case 3:
        quantity("next cola",120);
break;
    case 4:
        continuity();
}

    } else if (option==2) {
        display_menu();

    }
}
public void continuity() {
    System.out.println("Do you want any thing else?Press 1 for yes or 2 for no");
    Scanner sc=new Scanner(System.in);
    int option = sc.nextInt();
    if(option==1){
        display_menu();

    }
    else if (option == 2) {
        order_placed();

   }}
    public void quantity(String item,int cost) {
        System.out.println("Enter quantity of items");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        total += num * cost;
        System.out.println("Total bill=" + total);
        orderedItems.add(item + "=" + num + "x" + cost);


    }
    public void order_placed() {
        if(total>0){
        System.out.println("Order Summary:");
        for (String item : orderedItems) {
            System.out.println(item);}

            System.out.println("Total bill=" + total);

        }
        System.out.println("Thanks for using cheezious!");

}
    public void access(){

        Scanner SC = new Scanner(System.in);
        int choice = SC.nextInt();

        do{
            System.out.println("1:login");
            System.out.println("2:Sign_up");
            System.out.println("3:Exit");
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    //sign_up();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(true);}
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: "  );
        String username = scanner.nextLine();
        System.out.println("Enter password: "  );
        String password = scanner.nextLine();

        try(BufferedReader reader=new BufferedReader(new FileReader(File_name))){
            String line;
            boolean found=false;
            while((line=reader.readLine())!=null){
                String[] data=line.split(",");
                if(data[0].equals(username) && data[1].equals(password)){
                    System.out.println("Login Successful");
                    found=true;
                    break;
                }
                if(found==true){
                    System.out.println("Login Success!");
                }else{
                    System.out.println("Login Failed");
                }
            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}

