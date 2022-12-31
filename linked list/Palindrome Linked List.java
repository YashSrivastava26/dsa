
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//using extra space
// class Solution {

//     private boolean checkPalindromeArrayList(ArrayList<Integer> arr){
//         int right = arr.size() - 1;
//         int left = 0;

//         while(left < right){
//             if(arr.get(left) != arr.get(right)) return false;
//             left++;
//             right++;
//         }
//         return true;
//     }

//     public boolean isPalindrome(ListNode head) {
//         if(head == null || head.next == null) return true;
//         ArrayList < Integer > valOfLL = new ArrayList<>();

//         ListNode itr = head;
//         while(itr != null){
//             valOfLL.add(itr.val);
//             itr = itr.next;
//         }

//         return checkPalindromeArrayList(valOfLL);
//     }
// }

//TC = O(n/2) + O(n/2) + O(n/2) + O(n/2) = O(2n);
class Solution {

    private void reverseLL(ListNode mid){
        ListNode head = mid.next, prev = null;


        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        mid.next = prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;

        reverseLL(slow);

        ListNode start = head;

        boolean ans = true;
        slow = slow.next;
        while(slow != null){
            if(slow.val != start.val) {
                ans = false;
                break;
            }
            slow = slow.next;
            start = start.next;
        }

        reverseLL(middle);
        return ans;
    }
}