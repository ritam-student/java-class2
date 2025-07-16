import java.util.*;

class Day2{
    public static void main(String[] args) {
        // airthmatic operator
        // + , - , * , / , %
        // relational operators
        // > , < , >= , <= , == , !=   
        // logical operators
        // && , || , !

        int age  = 20;

        if (true  || age < 18) {
            System.out.println("Satisfied");
        }
        boolean isMonday = false;

        boolean isNotMonday = ! isMonday;
        // assignment operators
        int number = 10;
        number = number + 2;
        number += 2;
        number -= 2;
        number *= 2;
        number /= 2;
        number %= 2;

        /**
         * conditional statements
         * 1. if
         * 2. if-else
         * 3.if -else if -else
         * 4. switch case
         */
        /**
         * 
         * int btn = 2;
        switch (btn) {
            case 1: {
                break;
            }
            default : {
                
            }
        }
         */

        /**
         * loops
         * 1. for loop
         * 2. while loop
         * 3. do - while loop
         */

         // binary operator
         // 2+3
         // unary operator
         /**
          * int var1 = 10;
          * pre increment : ++var1
            pre decrement: --var1

            post increment : var1++
            ppost decrement : var1--
          */
          int var1 = 10;
          int var2 = ++var1;

          // ternary operator
        if (20 % 2 == 0) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }
    
        boolean even = (20 % 2 == 0) ? true : false;
        
        // for loop
        for (int i = 0 ; i <= 10; i++) {
            System.out.print(i + " ");
        }

        /*
         * i = 4
         * output : 0 1 2 3 
         */

         // while loop
        int i = 11 ;
        while (i < 11) {
            System.out.print("inside while loop");
            i++;
        }

        // do while loop
        int j = 11;
        do { 
            System.out.print("inside do while loop");
            j++;
        } while (j <= 10);

        for (i=0; i<5; i++) {
            if (i == 0) {
                continue;
            }
            if (i == 4) {
                break;
            }
            System.out.print(i+" ");
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("please entera number : ");
        int input = sc.nextInt();
        for (i = 1; i<= input; i++) {
            System.out.print(i + " ");
        }


        /**
         * 
         * 
         *      *****
         *      *****
         *      *****
         *      *****
         */
        System.out.println();
        for (int row=0; row<4; row++) {
            for (int column = 0; column<5; column++) {
                System.out.print("*");
            }
            System.out.println();
        }

        /**
         * row = 4
         * column = 5
         * 
         * output : 
         *      *****
         *      *   *
         *      *   *
         *      *****
         * 
         * 
         */
    }

}
