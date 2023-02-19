class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        int xor = 0;
        int ans[] = new int[2];
        
        for(int i = 0; i < N; i++){
            xor ^= Arr[i];
        }
        
        int setBit = xor & ~(xor - 1);
        
        for(int i = 0; i < N; i++){
            if((setBit & Arr[i]) > 0){
                ans[0] ^= Arr[i];
            }
            else{
                ans[1] ^= Arr[i];
            }
        }
        
        if(ans[0] < ans[1]){
            int temp = ans[1];
            ans[1] = ans[0];
            ans[0] = temp;
        }
        return ans;
    }
}