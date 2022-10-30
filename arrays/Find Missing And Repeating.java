
//cause overflow as we add square of number
// class Solve {
    
//     int[] findTwoElement(int arr[], int n) {
//         long sumSq = n * (n + 1) * ((2 * n) + 1) / 6 , sum = n * (n + 1) / 2;
//         for (int i = 0; i < arr.length; i++) {
//             sum -= arr[i];
//             sumSq -= (long)arr[i] * arr[i];
//         }
        
//         int missing = (int) ((sum + (sumSq / sum)) / 2);
//         int repeating =(int) (missing - sum);
//         int result[] = {repeating , missing};
//         return result;
//     }
// }



// using xor
class Solve {
    
    int[] findTwoElement(int arr[], int n) {
        int xor = 0;

        //xor both i and arr[i] in one loop
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        int setBitNo = xor & ~(xor - 1);

        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if((arr[i] & setBitNo) != 0)
                x ^= arr[i];
            else 
                y ^= arr[i];
        }

        for (int i = 1; i <= n; i++) {
            if((i & setBitNo) != 0)
                x ^= i;
            else 
                y ^= i;
        }

        boolean cheak = false;
        for (int i = 0; i < n; i++) {
            if(arr[i] < x){
                cheak = true;
                break;
            }
        }
        int ans[] = new int[2];
        if(cheak){
            ans[0] = x;
            ans[1] = y;
        }
        else{
            ans[0] = y;
            ans[1] = x;
        }
        return ans;
    }
}