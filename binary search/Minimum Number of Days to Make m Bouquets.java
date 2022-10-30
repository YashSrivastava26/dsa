class Solution {
    
    private int bouquetsMade(int[] bloomDay, int day, int flowersInSingelBouquet){
        int start = 0, end = 0, ans = 0; 
        while(end < bloomDay.length){
            if(end - start  == flowersInSingelBouquet){
                start = end;
                ans++;
            }
            if(bloomDay[end] <= day){
                end++;
            }
            else {
                end++;
                start = end;
            }
        }
        if(end - start == flowersInSingelBouquet) ans++;
        return ans;
        
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int high = maxi, low = 1 ,ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(bouquetsMade(bloomDay, mid, k) >= m){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}