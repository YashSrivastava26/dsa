import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}


class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList < ArrayList < Integer > > ans = new ArrayList<>();
        
        if(head == null) return ans;
        Node right = head, left = head;
        while(right.next != null){
            right = right.next;
        }
        
        while(right != left && right.next != left && left.prev != right){
            int sumData = right.data + left.data;
            if(sumData == target){
                ans.add(new ArrayList<>(List.of(left.data, right.data)));
                right = right.prev;
                left = left.next;
            }
            else if(sumData > target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }
        return ans;
    }
}
        
