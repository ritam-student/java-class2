
import java.util.*;

class Day0{
    public static void main(String args[]) {
        
        System.out.print("hello from print");
        System.out.println("hello world");

        // single line comment

        /**
         * 
         * 
         * milti line comments
         * 
         */

        //  variable  and data types
        // syntax : dataTypes name = value ;
        
        // 1. integer
        int year = 2025;
        
        // 2. character
        char character = 'a';
        // 3. string 
        String name = "raman";
        // 4. boolean
        boolean isMonday = true;

        // how to take input

        Scanner sc  = new Scanner(System.in);
        System.out.print("please input something.. : ");
        String input = sc.nextLine();
        System.out.println(input);

        // calling the function
        print1();// arguments
        

    }
    // creating our function
    public static void print1 (){// parameters
        System.out.println("inside the function");
    }
}



