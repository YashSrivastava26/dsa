// gfg

// import java.io.*;
// import java.util.*;

// class ReverseBits {
//     public static void main(String args[]) throws IOException {
//         BufferedReader read =
//             new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(read.readLine());
//         while (t-- > 0) {
//             Long X = Long.parseLong(read.readLine());

//             Solution ob = new Solution();
//             System.out.println(ob.reversedBits(X));
//         }
//     }
// }
// // } Driver Code Ends


// //User function Template for Java

// class Solution {
//     static Long reversedBits(Long X) {
//         Long result = 0l;
//         for(int i = 0; i < 32; i ++){
//             if((X&1) == 1) result += 1;
//             result = result << 1;
//             X = X >> 1;
//         }
//         return result;
//     }
// }


