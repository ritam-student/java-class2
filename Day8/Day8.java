

class Day8 {
    public static void main(String[] args) {
        // object of pen class
        Pen ballPen = new Pen(); // constructor

        /**
         * 
         * 4 main pillars 
         *  1. Encapsulation 
         *  2. Inheritance
         *  3. Polymorphism
         *  4. Abstraction
         * 
         * parent/base cass
         * child/derived class
         * 
         *  types of inheritance : 
         *  1. single level  2. multi level  3. hybrid  4. multiple 
         */

         /// access modifier : 1. public 2. private 3. default 4. protected
        
        B b1 = new B();
        System.out.println(b1.isChild); 
        System.out.println(b1.age);
        
    }

    /***
     * 
     * Search in sorted matrix
     * 
     * 10 20 30 40
     * 15 25 35 45
     * 27 29 37 48
     * 32 33 39 50
     * 
     * key = 39
     * 
     * row = 3
     * col = 2
     * 
     * approach 1 : O(n^2)
     * approach 2 : O(nlogn)
     * approach 3 : staircase O(n)
     * 
     */

    public static void sortedMatrix(int arr[][] , int key) {
        // 1. create 2 variables
        int row = 0;
        int col = arr[0].length-1;

        // 2. run a loop
        while(row < arr.length && col >= 0) {
            if(arr[row][col] == key){
                System.out.println(row +" , "+col);
                return;
            }else if (arr[row][col] > key) {
                col--;
            }else {
                row++;
            }
        }

        System.out.println("Number does not exist...");
    }

    /**
     * Check if a string is palindrome
     * 
     * approach 1 : sc : O(n) TC : O(n)
     * approach 2 : sc : O(1) TC : O(n)
     * 
     */

    public static boolean isPalindrome(String str) {
        // 1. create 2 variables
        int left = 0; 
        int right = str.length()-1;

        // 2. run a loop
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Find the displacement
     * 
     * WWWSSNNNNEEEENS
     * 0,0
     * 
     * E
     * N
     * S
     * W
     * NSE
     * WENS
     * 
     * 
     * 
     */

    public static int findDisplacement(String str) {
        // 1. create 2 variables
        int x = 0;
        int y = 0;

        // 2. iterate over all the characters of str
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'E'){
                x++;
            }else if (str.charAt(i) == 'W'){
                x--;
            }else if (str.charAt(i) == 'N'){
                y++;
            }else {
                y--;
            }
        }

        // 3. calculate the displacement
        return (int) Math.sqrt((x * x) + (y * y));
    }

    // create a class
    static class Pen{
        String color;   // attributes
        int thickness;   // attributes
        

        public void changeColor(String colo) {      // setter
            this.color = color;
        }

        public void logColor() {        // getter
            System.out.println(this.color);
        }

        // constructor
        public Pen() {
            System.out.println("constarcutor called...");
        }

    }

    // single level inheritance
    static class A{
        int age = 10;
    }

    static class B extends A{
        boolean isChild = true;
    }

    // multi level inheritance
    static class C extends B{
        boolean isChild2 = true;
    }

        /**
         *                  Creature
         *                   /  |  \
         *                  A   B   C
         *                 / \  |  / \
         *                P   Q R S   T
         */

        static class Creature{
            int number = 1;
        }

        static class Z extends Creature{
            int num1 = 2;
        }

        static class X extends Creature{
            int num2 = 3;
        }

        static class P extends Z{
            int num3 = 4;
        }




}
