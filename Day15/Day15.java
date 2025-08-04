
class Day15 {
    public static void main(String args[]){
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(2);
        // ll.addLast(1);
        ll.printElements();
        // ll.reverse();
        // ll.printElements();
        System.out.println(ll.isPalindrome());
        // doubly LL

    }

    static class DoublyLL{
        class Node {
            int data;
            Node prev;
            Node next;

            public Node (int data){
                this.data = data;
                this.next = null;
                this.prev = null;
            }
        }

        public static Node head;
        public static Node tail;

        public void addFirst(int data){
            // 1. create a new Node
            Node newNode = new Node(data);
            if (head == null){
                head = tail = newNode;
                return;
            }

            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            
        }

        public void addLast(int data){
            // 1. create a new Node
            Node newNode = new Node(data);

            if (head == null){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public int removeFirst(){
            if (head == null){
                System.out.println("LL is empty...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = tail = null;
                return val;
            }
            int val = head.data;
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
            return val;

        }
    }

    // Reverse a LL
    // 1->2->3->4->null
    // 4->3->2->1->null

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

        // Remove cycle in LL
        public void removeCycle(){
            // 1. check if cycle exist
            Node fast = head;
            Node slow = head;

            boolean isCycle = false;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    isCycle = true;
                    break;
                }
            }

            if (! isCycle){
                return;
            }

            slow = head;
            Node prev = fast;

            while (slow != fast){
                prev = fast;
                fast = fast.next;
                slow = slow.next;
            }

            prev.next = null;


        }
        

        // Detect cycle in LL
        public boolean isCycle(){
            // 1. create 2 var
            Node fast = head;
            Node slow = head;

            while (fast != null && fast.next != null){
                if (fast == slow){
                    return true;
                }
                fast = fast.next.next;
                slow = slow.next;
            }

            return false;
        }

        // check if a LL is palindrome or not
        // 1->2->2->1->null  ans = true
        // 1->2->2->null    ans = false

        public boolean isPalindrome(){
            // 1. find the mid
            Node mid = findMid(); // O(n)

            // 2. reverse the right part and break into  2 parts
            Node right = reverseRight(mid.next);    // O(n)
            mid.next = null;

            // 3. compare using a loop
            Node left = head;

            while (left != null && right != null){  // O(n)
                if (left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }

            return true;

        }

        private Node reverseRight(Node head){
            Node prev = null;
            Node curr = head;
            Node next;

            while (curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            return prev;
        }

        private Node findMid(){
            Node slow = head;
            Node fast = head.next;

            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;
        }

        // reverse a LL
        public void reverse(){
            // 1. create 3 var
            Node prev = null;
            Node curr = head;
            Node next;

            // 2. run a loop
            while (curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            head = prev;
        }

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
