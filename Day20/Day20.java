import java.util.*;

class Day20 {
    public static void main(String args[]){
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        System.out.println(dq);
        dq.getFirst();
        dq.getLast();
        dq.removeFirst();
        dq.removeLast();
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // construct a tree from pre-order
    public static Node createTree(int arr[] , int idx){
        if (arr[idx] == -1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = createTree(arr, idx+1);
        newNode.right = createTree(arr, idx+1);
        return newNode;
    }

    public static void preorder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void inorder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return;
        }
        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }

    public static void postorder(Node root){
        if (root == null){
            System.out.print("-1 ");
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.data + " ");
    }
    
    // First non-repeating letter
    // "aabccxb" -> a -1 b b b b x

    public static void nonRepeating(String str){
        int arr[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            arr[ch-'a']++;
            q.add(ch);

            while (! q.isEmpty() && arr[q.peek() - 'a'] > 1){
                q.remove();
            }

            if (q.isEmpty()){
                System.out.print("-1 ");
            }else {
                System.out.print(q.peek() +" ");
            }
        }
    }

    /// Interleave 2 halves of a queue
    ///   5 6 7 8 -> 1 5 2 6 3 7 4 8
    /// left ->   
    ///    1 5 2 6 3 7 4 8
    public static void interLeave(Queue<Integer> q){        // O(n)
        int size = q.size();

        Queue<Integer> left = new LinkedList<>();

        for (int i=0; i<size / 2; i++){
            left.add(q.remove());
        }

        while (! left.isEmpty()){
            q.add(left.remove());
            q.add(q.remove());
        }
    }

    static class Queue{
        public static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.isEmpty();
        }

        public void add(int data){
            dq.addLast(data);
        }

        public int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.removeFirst();
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.getFirst();
        }

        public int size(){
            return dq.size();
        }
    }

    static class Stack {
        public static Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty(){
            return dq.isEmpty();
        }

        public void push(int data){     // O(1)
            dq.addLast(data);
        }

        public int pop(){           // O(1)
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.removeLast();
        }

        public int peek(){          // O(1)
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }
            return dq.getLast();
        }

        public int size(){          // O(1)
            return dq.size();
        }
    }

    static class CircularQueue{
        int arr[];
        int size;
        public static int front;
        public static int rear;

        public CircularQueue(int n){
            arr = new int[n];
            size = n;
            front = rear = -1;
        }

        public boolean isEmpty(){
            return rear == -1;
        }

        public boolean isFull(){
            return (rear + 1) % size == front;
        }

        public void add(int data){      // O(1)
            if (isFull()){
                System.out.println("Queue is full...");
                return;
            }
            if (isEmpty()){
                front = rear = 0;
                arr[rear] = data;
                return;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }


        public int remove(){        // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }
            if (rear == front){
                int val = arr[front];
                front = rear = -1;
                return val;
            }

            int val = arr[front];
            front = (front + 1) % size;
            return val;
        }


        public int peek(){          // O(1)
            if (isEmpty()){
                System.out.println("Queue is empty...");
                return Integer.MIN_VALUE;
            }

            return arr[front];
        }

        public int size(){          // O(1)
            if (isEmpty()){
                return 0;
            }

            if (isFull()){
                return size;
            }

            if (rear == front){
                return 1;
            }else if (front > rear){
                return size - front + rear +1;
            }else {
                return rear - front + 1;
            }
        }
    }
}