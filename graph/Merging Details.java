import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Edge{
    int src, dest;
    Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
};


class DisJointSet{
    ArrayList < Integer > size = new ArrayList<>();
    ArrayList < Integer > parent = new ArrayList<>();
    DisJointSet(int V){
        for (int i = 0; i <= V; i++) {
            parent.add(i);
            size.add(1);
        }
    }


    int findParent(int node){
        if(parent.get(node) == node) return node;
        int ult_p = findParent(parent.get(node));
        parent.set(node, ult_p);
        return parent.get(node);
    }

    void unionSet(int x, int y){
        int parent_x = findParent(x);
        int parent_y = findParent(y);

        if(parent_x == parent_y) return;
        if(size.get(parent_x) < size.get(parent_y)){
            parent.set(parent_x, parent_y);
            size.set(parent_y, size.get(parent_y) + size.get(parent_x));
        }
        else{
            parent.set(parent_y, parent_x);
            size.set(parent_x, size.get(parent_y) + size.get(parent_x));
        }
    }
    int findComponents(){
        int count = 0;
        for (int i = 0; i < parent.size(); i++) {
            if(parent.get(i) == i) count++;
        }
        return count - 1;
    }
}

class Solution {

    public List<List<String>> mergeDetails(List<List<String>> details) {
        int n = details.size();
        DisJointSet dSet = new DisJointSet(n);

        HashMap < String, Integer> mp = new HashMap<>();
        // TC = O(n * (no. of email) * 4 * alpha)
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String email = details.get(i).get(j);
                if(!mp.containsKey(email)){
                    mp.put(email, i);
                }
                else{
                    int node = mp.get(email);
                    dSet.unionSet(node, i);
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        // TC = O(n)
        for (int i = 0; i < n; i++) {
            mergeMail[i] = new ArrayList<String>();
        }

        // TC = O((total no. of email i.e. M * N))
        for (Map.Entry<String, Integer> it : mp.entrySet()) {
            String email = it.getKey();
            int node = dSet.findParent(it.getValue());

            mergeMail[node].add(email);
        }

        List<List<String>> ans = new ArrayList<>();
        //TC = O(n * (M + M log M)) = O(n * m * log(M))
        for (int i = 0; i < n; i++) {
            if(mergeMail[i].size() != 0){
                Collections.sort(mergeMail[i]);
                List<String> temp = new ArrayList<>();
                String name = details.get(i).get(0);
                temp.add(name);
                for (String email : mergeMail[i]) {
                    temp.add(email);
                }
                ans.add(temp);
            }
        }

        return ans;
    }
}