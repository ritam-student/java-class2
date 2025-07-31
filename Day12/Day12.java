class Day12 {
    public static void main(String args[]){
        int arr[] = {8,4,6,2,0,1,5};
        // mergeSort(arr, 0, arr.length-1);
        // printArr(arr);
        // mergeSortDescending(arr, 0, arr.length-1);
        // printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
        quickSortDescending(arr, 0, arr.length-1);
        printArr(arr);
    }


    // merge sort
    /**
         * 
         * 1. find the mid
         * 2. call for the left part
         * 3. call for the right part
         * 4. merge them
         * 
         */

    public static void mergeSort(int arr[] , int si, int ei){   // O(nlogn) O(n)
        // base case
        if (si >= ei) {
            return;
        }

        // find the mid
        int mid = si + (ei-si)/2;

        // call for the smaller instances
        // left part
        mergeSort(arr, si, mid);
        // right part
        mergeSort(arr, mid+1, ei);


        // work 
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[] , int si, int mid, int ei){
        // 1. create a temp array
        int temp[] = new int[ei-si+1];

        // left part
        int i = si;
        // right part
        int j = mid+1;
        // temp array
        int k = 0;
        
        while (i <= mid && j <= ei){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // add the remaining elements of my left array
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // add the remaining elements of my right array
        while (j <= ei) {
            temp[k++] =  arr[j++];
        }

        // copy all the elements from temp to main array
        // main array
        int p = si;
        for (i = 0; i<temp.length; i++){
            arr[p] = temp[i];
            p++;
        }

    }


    public static void mergeSortDescending(int arr[] , int si, int ei){
        // base case
        if (si >= ei){
            return;
        }

        int mid = si + (ei - si) / 2;
        mergeSortDescending(arr, si, mid);
        mergeSortDescending(arr, mid+1, ei);
        mergeDescending(arr, si, mid, ei);
    }


    public static void mergeDescending(int arr[] , int si, int mid, int ei){
        // create an array
        int temp[] = new int[ei-si+1];

        // left part
        int i = si;
        // right part
        int j = mid+1;
        // temp array
        int k = 0;

        while (i <= mid && j <= ei){
            if (arr[i] > arr[j]){
                temp[k] = arr[i];
                i++;
            }else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }


        // remaining left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // remaining right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy all the elements
        // main array
        int p = si;
        for (i=0; i<temp.length; i++){
            arr[p++] = temp[i];
        }
    }


    // 2. quick sort
    /**
     * 
     * 1. craete a pivot pivot = arr[ei]
     * 2. arrange all the elements smaller or equal to pivot to the left
     * 3. place the pivot element at the original position and return index
     * 4. call for the left part
     * 5. call for the right part
     * 
     */

    public static void quickSort(int arr[] , int si , int ei){  // O(nlogn) -> worst O(n^2)
        // base case
        if (si >= ei){
            return;
        }

        int pIndex = partitioning(arr, si, ei);
        // left part
        quickSort(arr, si, pIndex-1);
        // right part
        quickSort(arr, pIndex+1, ei);
    }


    public static int partitioning(int arr[] , int si, int ei){
        int pivot = arr[ei];

        // main array
        int pIndex = si-1;
        for (int i=si; i<ei; i++){
            if (arr[i] <= pivot){
                pIndex++;
                // swap -> pIndex and i
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
            }
        }

        pIndex++;
        // swap -> pIndex and ei
        int temp = arr[ei];
        arr[ei] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;

    }


    public static void quickSortDescending(int arr[] , int si, int ei){
        // base case
        if (si >= ei){
            return;
        }

        int pIndex = partitioningDescending(arr, si, ei);
        quickSortDescending(arr, si, pIndex-1);
        quickSortDescending(arr, pIndex+1, ei);
    }


    public static int partitioningDescending(int arr[] , int si, int ei){
        int pivot = arr[ei];

        int pIndex = si - 1;
        for (int i=si; i<ei; i++){
            if (arr[i] >= pivot){
                pIndex++;
                // swap -> pIndex and i
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
            }
        }

        pIndex++;
        // swap -> pIndex and ei
        int temp = arr[ei];
        arr[ei] = arr[pIndex];
        arr[pIndex] = temp;

        return pIndex;
    }


    public static void printArr(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    // {1,8,6,2,5,4,8,3,7} each value represents the height of a building.
    // you have to findout the max water that gets trapped inside this buildings

    public static void trappedWater(int arr[]){     // O(n)
        int left[] = new int[arr.length];
        left[0] = arr[0];

        for (int i=1; i<arr.length; i++){
            left[i] = Math.max(arr[i] , left[i-1]);
        }

        int right[] = new int[arr.length];
        right[right.length-1] = arr[arr.length-1];

        for (int i=arr.length-2; i>= 0; i--){
            right[i] = Math.max(arr[i] , right[i+1]);
        }

        int trappedWater = 0;
        for (int i=0; i<arr.length; i++){
            int boundary = Math.min(left[i] , right[i]);
            trappedWater += boundary - arr[i];
        }

        System.out.println(trappedWater);
    }


    /**
     * 
     * search in rotated and sorted array
     * [4,5,6,7,0,1,2] , key = 0; ans = 4
     * divide and conquere + binary search
     * 
     * Hint : 
     *  1. find the mid
     *  2. 
     * 
     * 
     * 
     */
}
