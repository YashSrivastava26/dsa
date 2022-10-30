import java.util.*;

// class Solution
// {   
//     // arr[] : the input array
//     // N : size of the array arr[]
    
//     //Function to return length of longest subsequence of consecutive integers.
// 	static int findLongestConseqSubseq(int arr[], int N)
// 	{
// 	    Arrays.sort(arr);
//         int count = 1, maxi = 0;
//         for(int i = 1; i < N; i++){
//             if(arr[i] == arr[i - 1] + 1)
//                 count++;
//             else{
//                 maxi = Math.max(maxi, count);
//                 count = 1;
//             }
//         }
//         maxi = Math.max(maxi, count);
//         return maxi;
// 	}
// }


//tc = O(n)   sc = O(n)

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	    HashSet<Integer> hash = new HashSet<>();
        for (int ele : arr) {
            hash.add(ele);
        }
        int maxi = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!hash.contains(arr[i] - 1)){
                int j = arr[i] + 1;
                while(hash.contains(j)){
                    j++;
                }
                maxi = Math.max(maxi, j - arr[i]);
            }
        }
        return maxi;
	}
}