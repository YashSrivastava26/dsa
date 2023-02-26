class FenwickTree {
    int fen[];
    int n;

    FenwickTree(int n){
        this.n = n;
        fen = new int[n];
    }

    void update(int i, int add){
        while(i < n){
            fen[i] += add;
            i = i + (i & (-i));
        }
    }

    int sum(int i){
        int s = 0;

        while(i < n){
            s += fen[i];
            i = i - (i & (-i));
        }

        return s;
    }

    //lowerBoundSum

    int find(int k){
        int curr = 0, ans = 0, prevSum = 0;
        int start = (int)(Math.log(n) / Math.log(2));
        for(int i = start; i >= 0; i--){
            if(fen[curr + (1 << i)] + prevSum < k){
                curr += (i << i);
                prevSum += fen[curr];
            }
        }

        return ans;
    }
}
