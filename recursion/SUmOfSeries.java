//1^3 + 2 ^3 + 3^3 + 4^3 + ......n^3

//recursion
// class Solution {
//     long sumOfSeries(long N) {
//         if(N == 0) return 0;
//         return (N * N * N) + sumOfSeries(N - 1);
//     }
// }


//mathematical formula
class Solution {
    long sumOfSeries(long N) {
         return N * N * (N + 1) * (N + 1)/4;
    }
}