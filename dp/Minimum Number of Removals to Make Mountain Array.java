class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int lisForward[] = new int[n];
        int lisBackwards[] = new int[n];

        for(int i = 0; i < n; i++){
            lisForward[i] = 1;
            lisBackwards[i] = 1;
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
                if(lisBackwards[i] < lisBackwards[j] + 1 && nums[i] > nums[j]){
                    lisBackwards[i] = lisBackwards[j] + 1;
                }
            }
        }

        int mountainMax = 0;
        for(int i = 0; i < n; i++){
            if(lisForward[i] != 1 && lisBackwards[i] != 1){
                mountainMax = Math.max(mountainMax, lisForward[i] + lisBackwards[i] - 1);
            }
        }

        return n - mountainMax;
    }
}