import java.util.*;

class Day22{
    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        // add data
        map.put("Tea" , 20);
        map.put("Coffee" , 30);
        // remoove
        map.remove("Coffee");
        // 
        map.get("Tea");
        // isExist
        map.containsKey("Tea");
        // size
        map.size();
        //  clear
        map.clear();

        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        TreeMap<String, Integer> tm = new TreeMap<>();


        Set<String> set = map.keySet();

        // for each loop
        for (String key : set){
            System.out.println(map.get(key));
        }

        HashSet<String> set1 = new HashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();
        set1.add("Tea");
        set1.remove("Tea");
        set1.size();
        set1.contains("Tea");

        for (String random : set1){
            System.out.println(random);
        }

        Iterator it = set1.iterator();

        while (it.hasNext()){
            System.out.print(it.hasNext()+ " ");
        }


    }

    // [2,3,4,5,2,3,7,8] -> 2 3 4 5 7 8

    public static void uniqueEle(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++){
            int ele = arr[i];
            if (! set.contains(ele)){
                set.add(ele);
            }
        }

        for (int data: set){
            System.out.print(data+" ");
        }
        System.out.println();
    }


    public static Node lca(Node root, int n1, int n2){
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right ,n1, n2);

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        return root;
    }

    public static void kthNodesOpt(Node root , int k, int count){
        if (root == null){
            return;
        }
        if (count == k){
            System.out.print(root.data+ " ");
            return;
        }

        kthNodesOpt(root.left, k, count+1);
        kthNodesOpt(root.right, k, count+1);

    }



    public static void kthNodes(Node root, int k){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        int count = 1;

        while (! q.isEmpty()){
            Node curr = q.remove();

            if (curr == null){
                count++;
                if (! q.isEmpty()){
                    q.add(null);
                }
            }else {
                if (count == k){
                    while (!q.isEmpty() && curr != null){
                        System.out.print(curr.data + " ");
                        curr = q.remove();
                    }
                    return;
                }

                if (curr.left != null){
                    q.add(curr.left);
                }

                if (curr.right != null){
                    q.add(curr.right);
                }

            }
        }
    }
}