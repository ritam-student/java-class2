import java.util.*;


class Day17 {
    public static void main(String args[]){
        Stack s = new Stack();      // explicit stack
        s.push(3);
        s.push(2);
        s.push(1);

        pushBottom(4 , s);
    }

    public static boolean isExist(int key , Stack s){
        if (s.isEmpty()){
            return false;
        }

        while (! s.isEmpty()){
            int val = s.pop();
            if (val == key){
                return true;
            }
        }
        return false;
    }

    public static void printElements(Stack s){
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }

        System.out.println();
    }

    // push at the bottom of the stack

    public static void pushBottom(int data , Stack s){
        Stack temp = new Stack();

        while (!s.isEmpty()){
            temp.push(s.pop());
        }

        s.push(data);

        while (!temp.isEmpty()){
            s.push(temp.pop());
        }


    }


    static class StackLL{
        LinkedList<Integer> list = new LinkedList<>();

        public void push(int data){
            list.addFirst(data);
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public int pop(){
            if (isEmpty()){
                System.out.println("Stack underflow...");
                return Integer.MIN_VALUE;
            }

            return list.removeFirst();
        }
    }

    

    static class Stack{
        public static ArrayList<Integer> list = new ArrayList<>();

        public void push(int data){
            list.add(data);
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public int pop(){
            if (isEmpty()){
                System.out.println("stack underflow...");
                return Integer.MIN_VALUE;
            }

            return list.remove(list.size() - 1);
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Stack is empty...");
                return Integer.MIN_VALUE;
            }

            return list.get(list.size() - 1);
        }
    }

}
