#include<bits/stdc++.h>
using namespace std;

// class Solution 
// {
//     private: 
//     bool allZeros(int i, vector<vector<int> >& M, int n){
//         for(int j = 0; j < n; j++){
//             if(M[i][j] == 1){
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
//     int checkCelebraty(int i, vector<vector<int> >& M, int n){
//         for(int j = 0; j < n; j++){
//             if(j != i && M[j][i] == 0){
//                 return -1;
//             }
//         }
//         return i;
//     }
//     public:
//     //Function to find if there is a celebrity in the party or not.
//     int celebrity(vector<vector<int> >& M, int n) 
//     {
//         for(int i = 0; i < n; i++){
//             if(allZeros(i, M, n)){
//                 return checkCelebraty(i, M, n);
//             }
//         }
        
//         return -1;
//     }
// };


class Solution 
{
    private:
    
    bool knows(int i, int j, vector<vector<int>> &M){
        return M[i][j];
    }
    
    int checkCelebrity(int cand, vector<vector<int>> &M){
        int n = M.size();
        for(int i = 0; i < n; i++)
        {
            if(i != cand)
            {
                if( !knows(i, cand, M) || knows(cand, i, M) )
                {
                    return -1;
                }
            }
        }
        
        return cand;
    }
    public:
    //Function to find if there is a celebrity in the party or not.
    int celebrity(vector<vector<int> >& M, int n) 
    {
        int low = 0, high = n - 1;
        
        while(low < high)
        {
            if( knows(low, high, M) )
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        
        return checkCelebrity(low, M);
    }
};