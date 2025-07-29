
import java.util.*;



class Day10 {
    public static void main(String[] args) {
        // 3. Inbuilt sort
        int arr[] = {1,2,10,4,7,6};
        Arrays.sort(arr);   // O(nlogn)


        // ArrayList
        // create an arrayList
        ArrayList<Integer> list = new ArrayList<>();
        // Integer , int

        // add some value 
        // {}
        list.add(1);    // O(1)
        list.add(2);    // O(1)
        // {1,2}

        // read a value
        list.get(0);    // O(1)

        // remove 
        list.remove(1);     // O(1)
        // {1}


        // check if a number exist
        boolean ans = list.contains(4); // true or false    // O(1)


        // int arr[] = {1,2,3};
        // arr.length
        // to get the size of my arrayList
        list.size();    // O(1)

        // index of an element in arrayList
        // [1,2,3,4] -> 3 
        list.indexOf(1);   

    }


    // create an arrayList and store some value inside it.
    // print all the elements of an arrayList

    public static void printElements() {
        ArrayList<Integer> list = new ArrayList<>();

        // insert the elements
        for (int i=0; i<10; i++) {
            list.add(i);
        }

        // print all the elements
        for (int i=0; i<list.size(); i++) {
            //arr[i];
            System.out.print(list.get(i) +" ");
        }
        System.out.println();

    }


    // you are given an arrayList , you have to check if the key exist in arrayList ?
    // if not add it and return the index, if already exist return the index
    // ex : {2,3,7,8,9,10} , key = 4 -> {2,3,7,8,9,10,4} -> 6
    public static int findIndex(ArrayList<Integer> list , int key) {
        int ans = list.indexOf(key);
        if (ans < 0) {
            list.add(key);
            return list.size()-1;
        }else {
            return ans;
        }
    }

    // reverse an arrayList without using extra space
    // {1,2,3,4,5} -> {5,4,3,2,1}

    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size()-1;

        while(left < right) {
            // swap
            int temp = list.get(left);
            // arr[left] = arr[right];
            list.set(left , list.get(right));
            list.set(right , temp);

            left++;
            right--;
        }
    }

    // {1,8,6,2,5,4,8,3,7} each value represents the height of a building.
    // you have to findout the max water that gets trapped inside this buildings
    

    


    // 1. Bubble sort
    // [4,1,10,5,8] -> [1, 4, 5, 8, 10]
    public static void bubbleSort(int arr[]) {      // O(n^2)
        for (int i=0; i<arr.length-1; i++) { 
            for (int j=i+1; j<arr.length; j++) {    
                if (arr[i] > arr[j]) {
                    //  swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 2. Selection sort
    // [4,1,10,5,8] -> [1,4,5,8,10]
    public static void selectionSort(int arr[]){        // O(n^2)
        for (int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    


    // first occurrence of a number inside an array
    // [1,2,3,7,1,2] -> key = 1 -> 0
    public static int firstOccurrence(int arr[] , int i , int key) {
        // base case
        if (i == arr.length) {
            return -1;
        }
        //work at each step
        if (arr[i] == key) {
            return i;
        }
        // call smaller instances
        return firstOccurrence(arr, i+1, key);
        
    }

    /// last occurrence of a number inside an array
    /// [2,1,3,5,1,7] , key = 1, last occurrence -> 4
    /// 
    public static int lastOccurrence(int arr[] , int i, int key) {
        // base case
        if (i < 0) {
            return -1;
        }

        // work step
        if (arr[i] == key) {
            return i;
        }
        // call smaller instances
        return lastOccurrence(arr, i-1, key);
    }
    

}
