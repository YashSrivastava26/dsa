class Solution{
    static int setBit(int N){
        int mask = 1;
        while(mask < N){
            if((N & mask) == 0){
                break;
            }
            mask = mask << 1;
        }
        if(mask > N) return N;
        return N | mask;
    }
}