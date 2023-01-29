class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int countLIS[] = new int[n];
        lis[0] = 1;
        countLIS[0] = 1;

        int maxi = 1, maxiCount = 1;
        for(int i = 1; i < n; i++){
            lis[i] = 1;
            countLIS[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(lis[i] == lis[j] + 1){
                        countLIS[i] += countLIS[j];
                    }
                    else if(lis[i] < lis[j] + 1){
                        lis[i] = lis[j] + 1;
                        countLIS[i] = countLIS[j];
                    }
                }
            }
            if(lis[i] > maxi){
                maxi = lis[i];
                maxiCount = countLIS[i];
            }
            else if(lis[i] == maxi){
                maxiCount += countLIS[i];
            }
        }

        return maxiCount;
    }
}