import java.util.Arrays;


//TC = O(n log(n))
// class Solution
// {
//     static int majorityElement(int a[], int size)
//     {
//         Arrays.sort(a);
//         int majorityEle = a[size/2], freq = 0;
//         for (int i = 0; i < a.length; i++) {
//             if(a[i] == majorityEle) freq++;
//         }
//         if(freq > size / 2)return majorityEle;
//         else return -1;
//     }
// }



//TC = O(n)

class Solution
{
    
    public static int findCandatit(int[] arr){ // element with freq of n/2 or greater
        int majorityIdx = 0, count = 1; 
        for (int i = 1; i < arr.length; i++) 
        { 
            
            if (arr[majorityIdx] == arr[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                majorityIdx = i; 
                count = 1; 
            } 
        } 
        return arr[majorityIdx]; 
    }

    public static boolean checkMajority(int[] arr, int candForMajority){//removing n/2 freq case
        int freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candForMajority)
                freq++;
        }
        if(freq > arr.length / 2) return true;
        return false;
    }

    static int majorityElement(int a[], int size)
    {
        int candForMajority = findCandatit(a);
        if(candForMajority == -1) return -1;
        else{
            if(checkMajority(a, candForMajority))
                return candForMajority;
            return -1;
        }
    }
}
