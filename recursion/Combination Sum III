import java.util.*;

// TC = O(2 ^ k) 
// SC = O(9) + O(k * x);
// class Solution {

//     private void helper(int n, int k, int i, ArrayList<Integer> curr, List<List<Integer>> ans){
//         if(curr.size() == k){
//             if(n == 0){
//                 ans.add(new ArrayList<>(curr));
//             }
//             return;
//         }

//         if(i > 9){
//             return;
//         }

//         if(n < 0) {
//             return;
//         }
//         //pick
//         curr.add(i);
//         helper(n - i, k, i + 1, curr, ans);
//         curr.remove(curr.size() - 1);

//         //not pick
//         helper(n, k, i + 1, curr, ans);        
//     }

//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans = new ArrayList<>();
        
//         helper(n, k, 1, new ArrayList<Integer>(), ans);
//         return ans;
//     }
// }

// TC = O(2 ^ k) if k < 9 || O(1) if k > 9
class Solution {

    private void helper(int n, int k, int i, ArrayList<Integer> curr, List<List<Integer>> ans){
        if(curr.size() == k){
            if(n == 0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }

        if(i > 9){
            return;
        }

        if(n < 0) {
            return;
        }
        //pick
        curr.add(i);
        helper(n - i, k, i + 1, curr, ans);
        curr.remove(curr.size() - 1);

        //not pick
        helper(n, k, i + 1, curr, ans);        
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int ap = k * (9 + (9 - (k - 1))) / 2; 
        //ap formula:n * (first + last) / 2
        System.out.println((9 - k + 1));
        if(ap < n || k > 9){
            return ans;
        }
        
        helper(n, k, 1, new ArrayList<Integer>(), ans);
        return ans;
    }
}