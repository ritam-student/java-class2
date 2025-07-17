
class Day3 {
    public static void main(String[] args) {
        System.out.println(isPrime(20));
        System.out.println(reverse(123));

        int var1 = 10;// 1120
        int var2 = 20;  // 1300

        // dataType name[] = new dataType[size];
        int array[] = new int[10];
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        // index , indices
        // arr[4] = 50;
        int var = 10;
        count(var);
        System.out.println(var);
        System.out.println(arr[0]);
        printElements(arr);
        System.out.println(arr[0]);

    }

    public static void count(int n) {
        
        n += 1;
        System.out.println(n);
    }

    public static void printElements (int array[]) {
        for (int i=0; i <= array.length - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        array[0] = 100;
    }

    public static int reverse(int n) {
        // 123 321
        int ans = 0;
        while(n > 0) {
            int remainder = n % 10 ;
            ans = ans * 10 + remainder;
            n = n / 10;
        }
        return ans;
        
    }
    /**
     * 
     * n = 0
     * ans = 321
     * remainder = 1
     * 
     * 
     */

    public static boolean isPrime(int n) {
        if (n == 1 || n < 1) {
            return false;
        }

        for (int i = 2; i <= n/ 2; i++ ) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
