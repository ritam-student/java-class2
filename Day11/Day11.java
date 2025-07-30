class Day11 {
    public static void main(String args[]) {

    }

    // 1. bubble sort
    public static void bubbleSort(int arr[]) {      // O(N)
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void bubbleSortDescending(int arr[]){
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] < arr[j+1]){ 
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    // 2. Selection sort
    public static void selectionSort(int arr[]){        // O(N^2)
        for (int i=0; i <arr.length-1; i++) {
            int min = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }

            // swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }


    public static void selectionSortDescending(int arr[]){
        for (int i=0; i<arr.length-1; i++) {
            int max = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[max] < arr[j]){
                    max = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }


    // 3. Insertion sort

    public static void insertionSort(int arr[]){
        for (int i=1; i < arr.length; i++) {
            int j = i-1;
            while (j >= 0) {
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    j--;
                }else{
                    break;
                }
            }
        }
    }


    public static void insertionSortDescending(int arr[]){
        for (int i=1; i<arr.length; i++) {
            int j = i-1;
            while (j >= 0) {
                if (arr[j] < arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    j--;
                }
            }
        }
    }

    // 4. Counting sort
    // [6,4,2,9,7,2,3] -> [2,2,3,4,6,7 ,9]
    /**
     * 1. find the largest value in the array , max = (9)
     * 2. create an array of size max+1  , int count[] = new int[max+1];
     * 3. count the frequencies in the count array
     * [0,0,0, 0,0,0,0,0,0,0] -> 2,2,3,4,6,7,9
     * 4. replace the main array with the elements , while count > 0
     *  [2,2,3,4,6,7,9]
     */

    public static void countingSort(int arr[]){
        // 1. find the largest value in the array
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {      // O(n)
            if (arr[i] > max){
                max = arr[i];
            }
        }

        // 2. create an array of size max+1
        int count[] = new int[max+1];       // O(1)

        // 3. count the frequencies
        for (int i=0; i<arr.length; i++) {      // O(n)
            count[arr[i]]++;
        }
        
        // 4. replace the main array with the elements , while coiunt > 0
        int i = 0; // tracks my main array
        for (int j=0; j<count.length; j++) {        // O((max+r)
            while (count[j] > 0){       // O(r)
                arr[i] = j;
                i++;
                count[j]--;
            }
        }
    }

    public static void countingSortDescending(int arr[]){
        int max = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        int count[] = new int[max+1];

        for (int i=0; i<arr.length; i++) {

            count[arr[i]]++;
        }

        int i = 0;
        for (int j=count.length-1; j>= 0; j--) {
            while (count[j] > 0){
                arr[i] = j;
                i++;
                count[j]--;
            }
        }
    }


    // native sorting
    // divide and conquere -> recursion

    // 1. Merge sort
    /**
     * 
     * 1. find the mid
     * 2. call for the left part
     * 3. call for the right part
     * 4. conquere -> merge th sorted array
     */

    public static void mergeSort(int arr[] , int si , int ei){
        // base case
        if (si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr , si , mid);
        mergeSort(arr, mid+1, ei);
        merge(arr , si, mid, ei);

    }

    public static void merge (int arr[] , int si , int mid , int ei) {
        int temp [] = new int[ei-si+1];

        int left = si;
        int right = mid+1;
        int k = 0;

        while (left <= mid && right <= ei){
            if (arr[left] < arr[right]){
                temp[k] = arr[left];
                left++;
            }else {
                temp[k] = arr[right];
                right++;
            }

            k++;
        }


        while (left <= mid){
            temp[k] = arr[left];
            k++;
            left++;
        }

        while (right <= ei){
            temp[k] = arr[right];
            k++;
            right++;
        }

        for (int i=0; i<temp.length; i++) {
            arr[i] = temp[i];
        }

    }

}
