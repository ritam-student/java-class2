class Day14 {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(0);
        ll.addLast(2);
        ll.addLast(3);
        ll.printElements();
        System.out.println(ll.size);
    }

    
    static class LinkedList{
        class Node {
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data){
            // 1. create a new node
            Node newNode = new Node(data);

            // if LL is empty ?
            if (head == null){
                head = tail = newNode;
                size++;
                return;
            }

            // 2. point towards head
            newNode.next = head;

            // update the head
            head = newNode;

            size++;

        }

        public void addLast(int data){
            // 1. create a new node
            Node newNode = new Node(data);

            // 2. check for the condition
            if (head == null){
                head = tail = newNode;
                size++;
                return;
            }

            // 3. update tail.next
            tail.next = newNode;
            // 4. update the tail
            tail = newNode; 

            size++;
        }


        public void printElements(){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }

            System.out.print("null");
            System.out.println();

        }


        public void addMiddle(int idx, int data){
            // 1. create a new node
            Node newNode = new Node(data);

            if (idx == 0){
                addFirst(data);
                return;
            }

            // 2. find the prev
            Node temp = head;
            int i = 0;
            while (i < idx){
                temp = temp.next;
                i++;
            }

            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

        public int size(){
            // 1. create a variable
            int size = 0;

            Node temp = head;
            while(temp != null){
                size++;
                temp = temp.next;
            }

            return size;

        }

        public int removeFirst(){

            if (head == null){
                System.out.println("LL is empty...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            // 1. 
            head = head.next;

            size--;

            return val;
        }

        public int removeLast(){

            if (head == null){
                System.out.println("LL is empty...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            // 1. find the second last element
            Node temp = head;

            while (temp.next.next != null){
                temp = temp.next;
            }

            // 2. retrive the last node data
            int val = temp.next.data;

            // 3. point temp.next to null
            temp.next = null;

            size--;

            return val;
        }

        public int iterativeSearch(int key){
            // 1. temp node
            Node temp = head;
            int idx = 0;

            while (temp != null){
                if (temp.data == key){
                    return idx;
                }
                idx++;
            }

            return -1;
        }


        public int recursiveSearch(int key){
            return recursiveSearchHelper(key, head);
        }

        public int recursiveSearchHelper(int key, Node currNode){
            // base case
            if (currNode == null){
                return -1;
            }

            // work 
            if (currNode.data == key){
                return 0;
            }

            int val = recursiveSearchHelper(key, currNode.next);

            if (val == -1){
                return val;
            }

            return val+1;
        }

        
    }
}
