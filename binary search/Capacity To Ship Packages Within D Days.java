class Solution {

    public static boolean daysTaken(int[] arr, int limitDay, int rate){
        int count = 0, currWeight = 0;
        for (int i = 0; i < arr.length; i++) {
            currWeight += arr[i];
            if(currWeight > rate){
                count++;
                currWeight = arr[i];
            }
            if(count > limitDay) return false;
        }
        count+= (currWeight + rate - 1) / rate;
        if(count > limitDay) return false;
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sumWeight = 0, maxWeight = Integer.MIN_VALUE;
        for (int weight : weights) {
            sumWeight += weight;
            maxWeight = Math.max(weight, maxWeight);
        }
        
        int low = maxWeight, high = sumWeight, ans = sumWeight;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(daysTaken(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
            
        }
        return ans;
    }
}