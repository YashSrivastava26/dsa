import java.util.ArrayList;

class Solution {

    public static ArrayList<Integer> findCand(int[] nums){
        Integer cand1 = null, cand2 = null;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(cand1 != null && nums[i] == cand1) count1++;
            else if(cand2 != null && nums[i] == cand2) count2++;
            else if(count1 == 0){
                cand1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                count2++;
                cand2 = nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        ArrayList<Integer> cand = new ArrayList<>(2);
        cand.add(0, cand1);
        cand.add(1, cand2);
        return cand;
    }

    public static ArrayList<Integer> cheakCand(int[] arr, ArrayList<Integer> cand){
        int count1 = 0, count2= 0;
        for (int i = 0; i < arr.length; i++) {
            if(cand.get(0) != null && cand.get(0) == arr[i]) count1++;
            if(cand.get(1) != null && cand.get(1) == arr[i]) count2++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(count1 <= arr.length / 3 && count2 <= arr.length / 3) result.add(-1);
        else{
            if(count1 > arr.length / 3) result.add(cand.get(0));
            if(count2 > arr.length / 3) result.add(cand.get(1));
        }
        return result;
    }

    public static ArrayList<Integer> Solve(int n, int[] nums) {
        
        
        
        return cheakCand(nums, findCand(nums));
    }
}
