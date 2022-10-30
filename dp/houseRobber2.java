/* 
class Solution {
    private static boolean flag;
    static int maxMoney(int[] arr, int index){
        if(index == 0){
            if(flag) return 0;
            return arr[0]; 
        }
        if(index < 0) return 0;
        if(index == arr.length - 1) flag = true;
        int pick = arr[index] + maxMoney(arr, index - 2);
        if(index == arr.length - 1) flag = false;
        int notPick = 0 + maxMoney(arr, index - 1);
        return Math.max(pick, notPick);
    }

    static public int rob(int[] nums) {
        return maxMoney(nums, nums.length - 1);
    }
}

public class houseRobber2 {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(Solution.rob(nums));
    }
}*/
//leave first ele in first time and last in secont time and pass arrays in houserobber1 question function and take masx of them
//as answer contain either last or first element
class Solution {
    static public int maxMoney(int[] nums) {//house robber1 answer or function
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i] + prev2;
    
            int notPick  = 0 + prev;
    
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    static public int rob(int[] nums){
        int arr1[] = new int[nums.length - 1];
        int arr2[] = new int[nums.length - 1];
    
        for (int i = 0; i < nums.length; i++) {
            if(i != 0) arr1[i - 1] = nums[i];
            if(i != nums.length - 1) arr2[i] = nums[i];
        }
        return Math.max(maxMoney(arr1), maxMoney(arr2));
    
    }
}

public class houseRobber2 {

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(Solution.rob(nums));
    }
}