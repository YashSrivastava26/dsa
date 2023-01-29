class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int lisForward[] = new int[n];
        int lisBackward[] = new int[n];
        for(int i = 0; i < n; i++){
            lisForward[i] = 1;
            lisBackward[i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(lisForward[i] < lisForward[j] + 1 && nums[i] > nums[j]){
                    lisForward[i] = lisForward[j] + 1;
                }
            }
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                // System.out.println(lisBackward[i] + " " + lisBackward[j] + " " + nums[i] + " " + nums[j]);
                if(lisBackward[i] < lisBackward[j] + 1 && nums[i] > nums[j]){
                    lisBackward[i] = lisBackward[j] + 1;
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            // System.out.println(lisForward[i] + " " + lisBackward[i]);
            ans = Math.max(ans, lisForward[i] + lisBackward[i] - 1);
        }
        return ans;
    }
}