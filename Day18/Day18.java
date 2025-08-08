import java.util.*;

class Day18 {
    public static void main(String args[]){
        Stack s = new Stack();
        s.push(1);
    }

    // abc -> cba
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();

        for (int i =0; i<str.length(); i++){
            s.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");

        while (! s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.toString();

    }

    // reverse a stack
    /**
     * 1
     * 2
     * 3
     * 
     * temp1
     * 3
     * 2
     * 1
     * 
     * temp2
     * 1
     * 2
     * 3
     * 
     * 3
     * 2
     * 1
     * 
     */

    public static void reverseStack(Stack s){
        // base case
        if (s.isEmpty()){
            return;
        }

        int val = s.pop();
        reverseStack(s);
        pushBottom(s, val);
    }

    // add or enqueue
    // remove or dequeue
    // peek
    // size
    // isEmpty

    // "([{])" -> false
    // ([{}])   -> true

    public static boolean validParenthesis(String str){
        if (str.length() == 0){
            return true;
        }
        Stack<Character> s = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else {
                if (
                    ch == ')' && s.peek() == '(' ||
                    ch == '}' && s.peek() == '{' ||
                    ch == ']' && s.peek() == '[' 
                ) {
                    s.pop();
                }else {
                    return false;
                }
            }
        }

        if (s.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    // push at bottom (optimized)

    public static void pushBottom(Stack s , int val){
        //  base case
        if (s.isEmpty()){
            s.push(val);
            return;
        }

        int val1 = s.pop();
        pushBottom(s, val);
        s.push(val1);
    }

    static class Stack{
        class Node{
            int data;
            Node next;

            public Node (int data){
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;

        public void push(int data){
            Node newNode = new Node(data);

            if (head == null){
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if (head == null){
                System.out.println("Stack underflow...");
                return Integer.MIN_VALUE;
            }

            if (head.next == null){
                int val = head.data;
                head = head.next;
                return val;
            }

            int val = head.data;
            head = head.next;
            return val;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }

            return head.data;
        }

        public int size(){
            Node temp = head;
            int size = 0;

            while (temp != null){
                size++;
                temp = temp.next;
            }
            return size;
        }
    }
}
