import java.util.*;

class Day19 {
    public static void main(String args[]){
        // using utility -> JCF
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.peek();
        q.remove();
        
    }

    static class Queue{
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){       //O(1)
            return s1.isEmpty();
        }

        public void add(int data){      // O(n) 
            if (isEmpty()){
                s1.push(data);
                return;
            }

            while (! s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        public int remove(){        // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return s1.pop();
        }

        public int peekFirst(){     // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }

        public int peekLast(){      // O(n)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            while(! s1.isEmpty()){
                s2.push(s1.pop());
            }

            int val = s2.peek();

            while (! s2.isEmpty()){
                s1.push(s2.pop());
            }

            return val;

        }

        public int size(){      // O(n)
            int size = 0;
            while (! s1.isEmpty()){
                s2.push(s1.pop());
                size++;
            }

            while (! s2.isEmpty()){
                s1.push(s2.pop());
            }

            return size;
        }
    }

    /**
    static class Queue{
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

        public boolean isEmpty(){       // O(1)
            return head == null;
        }

        public void add(int data){      // O(1)
            Node newNode = new Node(data);
            if (isEmpty()){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public int remove(){        //O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = tail = null;
                return val;
            }

            int val  = head.data;
            head = head.next;
            return val;
        }

        public int peekLast(){      //O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return tail.data;
        }

        public int peekFirst(){     // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

        public int size(){      //O(n)
            if (isEmpty()){
                return 0;
            }

            int size = 0;
            Node temp = head;

            while (temp != null){
                size++;
                temp = temp.next;
            }

            return size;
        }

    }
     */

    /**
    static class Queue{
        public static int arr[];
        int size;
        public static int rear;
        public static int front;

        public Queue(int n){
            arr = new int[n];
            size = n;
            front = rear = -1;
        }

        public boolean isEmpty(){       // O(1)
            return rear == -1;
        }

        public boolean isFull(){        // O(1)
            return rear + 1 == size;
        }

        public void add(int data){      // O(1)
            if  (isEmpty()){
                front = rear = 0;
                arr[rear] = data;
                return;
            }

            if (isFull()){
                System.out.println("Queue is full...");
                return ;
            }

            rear++;
            arr[rear] = data;
        }

        // remove or dequeue , deque -> double ended queue
        public int remove(){        // O(n)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            if (rear == front){
                int val  = arr[front];
                front = rear = -1;
                return val; 
            }

            int val = arr[front];

            for (int i =0; i<rear; i++){
                arr[i] = arr[i+1];
            }

            rear--;
            return val;
        }

        // [1,2,3,4,0,0,0,0,0]
        public int peekLast(){      // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return arr[rear];
        }
        // [-2,3,4,-5]
        public int peekFirst(){     // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }

        // [1,2,3,4,0,0,0,0], rear = 3
        public int size(){      // O(1)
            return rear+1;
        }
    }
    */
}
