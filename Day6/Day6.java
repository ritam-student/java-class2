public class Day6 {
    public static void main(String[] args) {
        /// create a 2D array
        /// int arr [] = new int [5];
        int arr [][] = new int[2][3]; // row , column

        // arr[i]
        int var1 = arr[1][1];   // 

        // iterating over  a 2D array

        /**
         * for (int idx= 0 ;idx < arr.length; idx++ ) {
         *    System.out.println(arr[i]);
         * }
         * 
         * 
         */

        for (int row = 0; row <arr.length; row++) {
            for (int column = 0 ; column < arr[0].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }

        // String
        String str = "abc";     // way 1
        String str2 = "abc";
        String str1 = new String("abc");        //  way 2

        System.out.println(str.equals(str1));        // false
        System.out.println(str.equals(str2));        // true

        // iterate over a string
        int n = str.length();
        for (int idx =0; idx<n; idx++) {
            //arr[i]
            System.out.print(str.charAt(idx) + " ");
        }
        System.out.println();

        // update a string
        int a = 10;
        a = 20;

        String str3 = "abcd";
        str3 = "zpdn";

        // abcdpppppppppp


        for (int i=0; i<n; i++) {
            str = str + 'p';
        }
        System.out.println(str);

    }
}
