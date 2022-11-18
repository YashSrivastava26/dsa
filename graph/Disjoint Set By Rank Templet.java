import java.util.ArrayList;

class DisJointSetByRank{
    ArrayList < Integer > rank = new ArrayList<>();
    ArrayList < Integer > parent = new ArrayList<>();
    DisJointSetByRank(int V){
        for (int i = 0; i <= V; i++) {
            parent.add(i);
            rank.add(0);
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
        if(rank.get(parent_x) < rank.get(parent_y)){
            parent.set(parent_x, parent_y);
        }
        else  if(rank.get(parent_y) < rank.get(parent_x)){
            parent.set(parent_y, parent_x);
        }
        else{
            parent.set(parent_x, parent_y);
            rank.set(parent_x, rank.get(parent_x) + 1);
        }
    }
}