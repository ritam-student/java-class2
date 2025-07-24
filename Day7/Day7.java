class Day7 {
    public static void main(String args[]) {
        // String str = new String("abc");
        // initialize a stringBuilder
        StringBuilder sb = new StringBuilder("abc");

        // str.charAt(2);
        sb.charAt(2);

        for (int i=0; i<10; i++) {
            sb.append("p");
        }
        System.out.println(sb);

        // .compareTo()
        String str = "abcv";
        String str1 = "pqgd";
        String str2 = "ABCJ";

        str.toUpperCase();
        str2.toLowerCase();


        // lexicographic order
        int ans = str.compareTo(str1);   
        if (ans < 0) {
            System.out.println("str1 is largest...");
        }else if (ans > 0) {
            System.out.println("str is largest...");
        }else {
            System.out.println("Both are equals...");
        }

        System.out.println(checkOccurence("abcvuxgaa"));
        
        int arr[][] = {
            {10 ,20, 30 ,40},
            {15 ,25, 35, 45},
            {27 ,29, 37, 48},
            {32, 33, 39 ,50}
        }; 

        findKey(arr, 39);

        
    }
    /**
     * 
     * find the occurrence of a character in a string
     * ex : abcvuxgaa , a
     * 
     */

    public static int checkOccurence(String str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a'){
                count++;
            }
        }

        return count;
    }

    /**
     * 
     * find the largest word inside an array of string
     * 
     * 
     */

    public static String findLargest(String arr[]){
        String largest = arr[0];

        for (int i=1; i<arr.length; i++) {
            int ans = largest.compareTo(arr[i]);

            if (ans < 0) {
                largest = arr[i];
            }
        }

        return largest;
    }

    /**
     * 
     *   HW : count the occurrence-II 
     * 
     * ex : abchsgd -> abchsgd
     * ex 1 : abcjsjaa -> abcjsjaapp
     * 
     * 
     */

     // LEETCODE 1752
    public boolean check(int[] nums) {
        return isSorted(nums);
    }
    public boolean isSorted(int nums[]) {
        if (nums.length == 1) return true;
        
        int breakPoint = -1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                breakPoint = i;
                break;
            }
        }

        if (breakPoint == -1) return  true;

        boolean left = true;
        for (int i=0; i<breakPoint; i++) {
            if (nums[i] > nums[i+1]){
                left = false;
            }
        }

        boolean right = true;
        for (int i=breakPoint+1; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1] || nums[i] > nums[0]){
                right = false;
            }
        }

        if (nums[nums.length-1] > nums[0]){
            right = false;
        }

        return left && right;
    }

    /**
     * 
     * Find a key inside a 2D array
     * 
     * ex : 
     *      10 20 30 40
            15 25 35 45
            27 29 37 48
            32 33 39 50 

        key = 39 -> 3,2
     * 
     * 
     */

    public static void findKey(int arr[][] , int key) {

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j] == key){
                    System.out.println(i + " , " + j);
                    return;
                }
            }
        }

        System.out.println("No such number exist...");
    }


    /**
     * spiral matrix
     * 
     * 
     * 2  3  4  5
     * 6  7  8  9
     * 10 11 12 13
     * 
     * 
     * print all the elements of this matrix in spiral format
     * 
     * ans -> 2 3 4 5 9 13 12 11 10 6 7 8  
     * 
     */

    public static void spiralMatrix(int arr[][]) {
        // 1. initialize variables
        int sr = 0;
        int sc = 0;
        int er = arr.length-1;
        int ec = arr[0].length-1;

        // 2. run a loop
        while (sr <= er && sc <= ec) {
            for (int i=sc; i<= ec; i++){
                System.out.print(arr[sr][i] + " ");
            }

            for (int j=sr+1; j<= er; j++){
                System.out.print(arr[j][ec] + " ");
            }

            for (int i=ec-1; i >= sc; i--){
                System.out.print(arr[sr][i] + " ");
            }

            for (int j=er; j > sr; j--){
                System.out.print(arr[j][ec] + " ");
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
    }

}
