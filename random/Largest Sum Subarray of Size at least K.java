import java.util.HashMap;

class Compute {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        HashMap < Integer, Long > sumTillIdx = new HashMap<>();
        int low = 0;
        long sum = 0, windowSum = 0, ans = Integer.MIN_VALUE;
        for (int high = 0; high < a.length; high++) {
            sum += a[high];
            windowSum +=a[high]; 
            sumTillIdx.put(high, sum);

            if(high - low + 1 == k){
                ans = Math.max(sum, ans);
            }
            
            if(high - low + 1 > k){
                long sumI = sumTillIdx.get(low);
                if(sumI < 0) {
                    low++;
                    windowSum -= sumI;
                }
                ans = Math.max(ans, windowSum);
            }
            System.out.println(low);
            System.out.println(high);
            System.out.println(sum);
            System.out.println(windowSum);
            System.out.println(ans);
            System.out.println();
            System.out.println();
            System.out.println();
        }
        return ans;
    }
}