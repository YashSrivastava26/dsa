import java.util.*;
class Solution {

    private void upperBoundReplace(ArrayList<Integer> arr, int num){
        int left = 0, right = arr.size();
        int idxReplace = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr.get(mid) >= num){
                idxReplace = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        arr.set(idxReplace, num);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>(); //notLISButGiveLen
        arr.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(arr.get(arr.size() - 1) < nums[i]){
                arr.add(nums[i]);
            }
            else{
                upperBoundReplace(arr, nums[i]);
            }
        }

        return arr.size();
    }
}