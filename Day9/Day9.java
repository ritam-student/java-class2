
class Day9 {
    public static void main(String[] args) {
        // polymorphism -> 1. runtime / method overriding 
        // 2. compile time/ method overloading
        Main m1 = new Main();
        Animal a1 = new Animal(m1);
        m1.arr[1] = 100; // {1,100,3}

        sum(1,2);
        sum(1,2,3);

        B b1 = new B();
        b1.log();
        
    }

    // print numbers from 1 to n in ascending order . ex: n = 5 -> 1,2 3,4,5
    public static void printInAscendingOrder(int n) {
        // base case
        if (n == 0){
            return;
        }
        // call for the smaller instances
        printInAscendingOrder(n-1);
        // work on each step
        System.out.print(n+" ");
    }

    // print numbers from n to 1 in descending order . ex:n = 5 -> 5,4,3,2,1
    public static void printInDescendingOrder(int n) {
        if (n == 0){
            return;
        }

        System.out.print(n+" ");
        printInDescendingOrder(n-1);
    }


    // find factorial number ex : 5 ! -> 5*4*3*2*1
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n-1); 
    }

    // sum of n natural number ex: n=5 , 1+2+3+4+5
    public static int sumOfAllNumbers(int n) {
        // base case
        if (n == 1) {
            return 1;
        }

        return n  + sumOfAllNumbers(n-1);
    }

    // find nth fibonachi number 
    // 0 1 1 2 3 5 ... ex: n = 5  logic : n = (n-1) + (n-2)

    public static int fibonachi(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonachi(n-1) + fibonachi(n-2);
    }

    // check if array is sorted or not  in ascending order
    // {1,2,3,4} -> true   , {3,6,1,8} -> false

    public static boolean isSorted(int arr[] , int index){
        if (index == arr.length-1){
            return true;
        }

        return ((arr[index] < arr[index+1]) && isSorted(arr , index+1));
    }

    static class Grandparents{
        public void printParent() {
            System.out.println("we are grandparents...");
        }
    }
    // Parent p1 = new Parent();
    // p1.printParent();
    static class parent extends Grandparents{
        public void printParent() {
            System.out.println("gandparents are our parents...");
        }
    }

    static class Child extends parent{
        public void printParent() {
            System.out.println("our parents are parent...");
        }
    }

    static class Pen{
        static int thickness;
        String color;
    }

    // interfaces 
    interface ClassInterface{
        public void sum(int a, int b);
    }

    static class FourA implements ClassInterface{
        public void sum(int a , int b) {
            System.out.println(a+b);
        }
    }

    

    static class A{
        public void log(){
            System.out.println("from A");
        }
    }
    // a -> b -> c

    static class B extends A{

        public B() {
            super();
            System.out.println("class B");
        }

        public void log() {
            System.out.println("from B");
        }
    }


    public static void sum(int a, int b) {
        System.out.println(a+b);
    }

    public static void sum(int a , int b , int c){
        System.out.println(a+b+c);
    }

    static class Main{
        int arr[] = {1,2,3};
    }

    static class Animal{
        int age;
        int newArr[] = new int[3]; // {1,2,3}
        // parameterized constructor
        public Animal(int a) {
            System.out.println(a);
        }
        // non-parameterized constructor
        public Animal() {
            
        }
        // copy constructor
        public Animal(Main obj){
            newArr = obj.arr;
        }

        
        public void walk() {
            System.out.println("can walk...");
        }
    }
}
