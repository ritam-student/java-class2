class Day13 {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.printElement();
        ll.addFirst(4);
        ll.printElement();
        ll.addFirst(3);
        ll.printElement();
        ll.addFirst(2);
        ll.printElement();
        ll.addFirst(1);
        ll.printElement();

        
    }

    static class LinkedList{
        class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head; 
        // int head;
        public static Node tail;    

        // add elements from the first in LL

        public void addFirst(int data){
            // 1. craete a new Node
            Node newNode = new Node(data);

            // check for the condition
            if (head == null){
                // my LL is empty
                
                head = tail = newNode;
                return;
            }

            // LL is not empty
            newNode.next = head;
            // update my head
            head = newNode;
        }

        public void printElement(){
            if (head == null){
                System.out.println("LL is Empty...");
                return;
            }

            Node temp = head;

            while (temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }

            System.out.println("null");

        }

    }

    public static int searchInRotatedSortedArray(int arr[] , int key, int si, int ei){  // O(logn)
        // base case
        if (si > ei){
            return -1;
        }

        // find the mid
        int mid = si + (ei - si)/2;

        if (arr[mid] == key){
            return mid;
        }

        // if key lies on segment 1
        if (arr[si] <= key){
            // key lies in the left part
            if (arr[si] <= key && key < arr[mid]){
                // call for the left part
                return searchInRotatedSortedArray(arr, key, si, mid-1);
            }else {
                // call for the right part
                return searchInRotatedSortedArray(arr, key, mid+1, ei);
            }

        }// search for the s2
        else {
            if (arr[mid] < key && key <= arr[ei]){
                // call for the right part
                return searchInRotatedSortedArray(arr, key, mid+1, ei); 
            }else {
                // call for the left part
                return searchInRotatedSortedArray(arr, key, si, mid-1);
            }
        }
    }
}
