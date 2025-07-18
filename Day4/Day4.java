class Day4 {
    public static void main(String[] args) {
        int arr [] = {2,3,4,5,6,7,8};

    }    

    public static int linearSearch(int arr[]) {
        int number = 7;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;

    }

    public static int binarySearch(int arr[]) {
        int left = 0;
        int right = arr.length-1;

        int number = 7;

        while (left <= right) {
            // find the middle
            int mid = (left + right ) / 2;

            if (arr[mid] == number){
                return mid;
            }else if (arr[mid] > number){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return -1;
    }

    /**  {3,4,5,6,7} -> {7,6,5,4,3} */

    public static int largestElement(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static void reverseArray(int arr[]) {
        int left = 0;
        int right = arr.length-1;

        while(left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            left++;
            right--;
        }
    }

    public static void printSubarrays(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                for (int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    /**
     * {1,2,3} -> 1, 2, 3, 12, 13,23,123, null
     */
}
