class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        int traversePtrN = 0, traversePtrM = M - 1; //we start at top right corner
        while(traversePtrM >= 0 && traversePtrN < N){
            if(X == mat[traversePtrN][traversePtrM]) return 1;
            else if(X < mat[traversePtrN][traversePtrM]) traversePtrM--;
            else traversePtrN++;
        }
        return 0;
    }
}