import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nextGreater = new int[n];
        Deque<Integer> linearlyDecreasing = new LinkedList<>();

        for(int i = n - 1; i >= 0; i--){
            int curr = nums2[i];
            while(linearlyDecreasing.size() != 0 && curr > linearlyDecreasing.peekLast()){
                linearlyDecreasing.removeLast();
            }

            if(linearlyDecreasing.size() == 0){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = linearlyDecreasing.peekLast();
            }
            linearlyDecreasing.add(curr);
        }

        int m = nums1.length;
        int ans[] = new int[m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(nums2[j] == nums1[i]){
                    ans[i] = nextGreater[j];
                    break;
                }
            }
        }
        return ans;
    }
}