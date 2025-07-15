import java.util.*;

class Day1 {
    public static void main(String[] args) {
        /**
         * 
         * 1. if 
         * 2. if-else
         * 3. if-else if -else
         */
        
        int age = 18;

        if (age > 18) {
            System.out.println("adult");
        } else if (age == 18) {
            System.out.println("adult too..");
        } else {
            System.out.println("not adult");
        }

        /*
         * conditional operators : > , < , >= , <= , ==
         */

        /*
         * q1 . write a program in java to check whether a number is even or not 
         * (you have to take the number from the user ) ?
         
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        isEven(number);
        
        int btn = 1;
        switch (btn) {
            case 1: {
                System.out.println("clicked on btn 1");
                break;
            }
            case 2: {
                System.out.println("clicked on btn 1");
                break;
            }
            case 3: {
                System.out.println("clicked on btn 1");
                break;
            }
            default: System.out.println("no such a switch");
        }
            */
        
        Scanner sc = new Scanner(System.in);
        String favCol = sc.nextLine();
        /**
        switch(favCol) {
            case "red" : {
                System.out.println("thanks for sharing your fav color is red");
                break;
            }
            case "bule" : {
                System.out.println("thanks for sharing your fav color is blue");
                break;
            }
            case "green" : {
                System.out.println("thanks for sharing your fav color is green");
                break;
            }
            default: {
                System.out.println("thanks for sharing your fav color");
            }
        }
        */

        if (favCol.equals("red")) {
            System.out.println("Thanks for sharing your fav color is red");
        }else if (favCol.equals("blue")){
            System.out.println("Thanks for sharing your fav color is blue");
        }else if (favCol.equals("green")) {
            System.out.println("Thanks for sharing your fav color is green");
        }else {
            System.out.println("Thanks for sharing your fav color");
        }

    }
    public static void isEven(int evenNumber) {
        if (evenNumber % 2 == 0) {
            System.out.println("even number");
        }else {
            System.out.println("odd number");
        }
    }
}