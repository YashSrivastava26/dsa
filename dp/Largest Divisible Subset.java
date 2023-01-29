class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] prevIdx = new int[n];
        int lenLDS[] = new int[n];
        for(int i = 0; i < n; i++){
            prevIdx[i] = i;
            lenLDS[i] = 1;
        }

        int maxLen = 1;
        int maxIdx = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && lenLDS[i] < lenLDS[j] + 1){
                    lenLDS[i] = lenLDS[j] + 1;
                    prevIdx[i] = j;
                }
            }
            if(maxLen < lenLDS[i]){
                maxLen = lenLDS[i];
                maxIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        while(maxLen > 0){
            ans.add(nums[maxIdx]);
            maxIdx = prevIdx[maxIdx];
            maxLen --;
        }

        Collections.reverse(ans);
        return ans;
    }
}