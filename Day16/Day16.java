class Day16 {
    public static void main(String args[]){

    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Leetcode - 42

    public int trap(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];

        leftMax[0] = height[0];
        rightMax[rightMax.length-1] = height[height.length-1];

        for  (int i=1; i<leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }

        for (int i=rightMax.length-2; i>= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }

        int trappedWater = 0;

        for (int i=0; i<height.length; i++){
            int boundary = Math.min(rightMax[i] , leftMax[i]);
            trappedWater += boundary - height[i];
        }

        return trappedWater;
    }

    // Leetcode - 88

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. craete a temp array
        int temp[] = new int[m+n];

        // create 3 var
        // for temp array
        int i = 0;
        // track left part
        int left = 0;
        // track right part
        int right = 0;


        while (left != m && right != n){
            if (nums1[left] < nums2[right]){
                temp[i++] = nums1[left++];
            }else {
                temp[i++] = nums2[right++];
            }
        }

        while (left != m){
            temp[i++] = nums1[left++];
        }

        while (right != n){
            temp[i++] = nums2[right++];
        }

        for (i=0; i<nums1.length; i++){
            nums1[i] = temp[i];
        }
    }

    // Leetcode - 151

    public String reverseWords(String s) {
        String str = s.trim();
        String arr[] = str.split(" ");

        StringBuilder sb = new StringBuilder("");

        for (int i=arr.length-1; i>= 0; i--){
            // trim the string
            String word = arr[i].trim();

            if (word != ""){
                sb.append(word);
                sb.append(" ");
            }

        }

        return sb.toString().trim();
    }

    // Leetcode - 234

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null){
            return true;
        }
        // find the mid
        ListNode mid = getMid(head);

        ListNode right = mid.next;
        mid.next = null;

        // reverse the right part
        ListNode leftHead = head;
        ListNode rightHead = reverseLL(right);

        // compare both the val
        while (leftHead != null && rightHead != null){
            if (leftHead.val != rightHead.val){
                return false;
            }

            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        return true;
    }


    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Leetcode - 142

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        // detect the cycle
        ListNode fast = head;
        ListNode slow = head;

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
            return null;
        }

        slow = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;

        }

        return fast;
    }
}

