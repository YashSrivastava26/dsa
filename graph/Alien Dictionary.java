import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        int inDegree[] = new int[K];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < dict.length; i++) {
            int j = 0;
            while(j < dict[i - 1].length() && dict[i - 1].charAt(j) == dict[i].charAt(j))j++;
                if(j < dict[i - 1].length()){
                    int ele = dict[i - 1].charAt(j) - 'a';
                    if(j != dict[i - 1].length()){
                    int adjEle = dict[i].charAt(j) - 'a';

                    adj.get(ele).add(adjEle);
                    inDegree[adjEle] ++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < K; i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        int ansInInt[] = new int[K];
        int i = 0;
        while(!q.isEmpty()){
            int ele = q.poll();
            ansInInt[i++] = ele;
            for (int adjEle : adj.get(ele)) {
                inDegree[adjEle]--;
                if(inDegree[adjEle] == 0) q.add(adjEle);
            }
        }
        String ans = "";
        int a = 'a';
        for (int j = 0; j < ansInInt.length; j++) {
            char ele =(char)(ansInInt[j] + a);
            ans = ans + ele;
        }
        
        return ans;
    }
}