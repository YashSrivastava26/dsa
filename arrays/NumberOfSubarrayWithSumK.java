import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumTillPoint = new HashMap<>();//hashmap<sum,no of times it occured>
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];

            if(sum == k)
                count++;
            
            if(sumTillPoint.containsKey(sum - k))
                count += sumTillPoint.get(sum - k);

            if(sumTillPoint.containsKey(sum)) 
                sumTillPoint.put(sum, sumTillPoint.get(sum) + 1);
            else 
                sumTillPoint.put(sum, 1);
            
            
        }
        return count;
    }
}
