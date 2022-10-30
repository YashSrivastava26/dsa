class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java



// // if arraay is sorted
// class Solve {
//     Pair getFloorAndCeil(int[] arr, int n, int x) {
//         int low = 0, high = n - 1;
//         Pair resultPair = new Pair(-1,-1);
//         if(x > arr[n - 1]) resultPair.floor = arr[n - 1];
//         else if(x < arr[0]) resultPair.ceil = arr[0];
//         else{
//             while(low <= high){
//                 int mid = low + (high - low) / 2;
//                 if(arr[mid] == x){
//                     resultPair.floor = arr[mid];
//                     resultPair.ceil = arr[mid];      
//                     return resultPair;          
//                 }
//                 else if(arr[mid] > x && arr[mid - 1] < x){
//                     resultPair.floor = arr[mid - 1];
//                     resultPair.ceil = arr[mid];      
//                     return resultPair; 
//                 }
//                 else if(arr[mid] > x) high = mid - 1;
//                 else low = mid + 1;
//             }
//         }
//         return resultPair;
//     }
// }



//unsorted array
class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Pair resultPair = new Pair(-1,-1);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= x && arr[i] > resultPair.floor) resultPair.floor = arr[i];
            if(arr[i] >= x && (resultPair.ceil == -1 || arr[i] < resultPair.ceil)) resultPair.ceil = arr[i];
            if(arr[i] == x) break;
        }
        return resultPair;
    }
}