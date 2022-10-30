// linear search method
// class Solution
// {
// 	// Function to find the peak element
// 	// arr[]: input array
// 	// n: size of array a[]
// 	public int peakElement(int[] arr,int n)
//     {
//         if(n == 0) return -1;
//         if(n == 1) return 0;
//         if(arr[0] > arr[1]) return 0;
//         if(arr[n - 1] > arr[n - 2]) return n - 1;
//         for (int i = 1; i < n - 1; i++) {
//             if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
//         }
//         return -1;
//     }
// }


//binary search method

class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
        int low = 0, high = n - 1;
        if(arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;
        while(low <= high){
            int mid= low + (high - low) / 2;
            if((mid < n - 1 && arr[mid] >= arr[mid + 1]) && (mid > 0 && arr[mid] >= arr[mid - 1])) return mid;
            else if(mid > 0 && arr[mid - 1] > arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}