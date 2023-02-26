class LazyPropogation {
    
    int seg[];
    int lazy[];

    LazyPropogation(int n){
        seg = new int[4 * n];
        lazy = new int[4 * n];
    }

    void rangeUpdates(int idx, int low, int high, int l, int r, int val){
        if(lazy[idx] != 0){
            
            seg[idx] += lazy[idx] * (high - low + 1);

            if(low != high){
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        if(low > r || high < l || low > high){
            return;
        }

        if(low >= l && high <= r){
            seg[idx] += (high - low + 1) * val;
            if(low != high){
                lazy[2 * idx + 1] += val;
                lazy[2 * idx + 2] += val;
            }
            return;
        }

        int mid = low + (high - low) / 2;
        rangeUpdates(2 * idx + 1, low, mid, l, r, val);
        rangeUpdates(2 * idx + 2, mid + 1, high, l, r, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    int querySumLazy(int idx, int low, int high, int l, int r){
        if(lazy[idx] != 0){
            
            seg[idx] += lazy[idx] * (high - low + 1);

            if(low != high){
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }

            lazy[idx] = 0;
        }

        if(low > r || high < l || low > high){
            return 0;
        }

        if(low >= l && high <= r){
            return seg[idx];
        }

        int mid = low + (high - low) / 2;
        int left = querySumLazy(2 * idx + 1, low, mid, l, r);
        int right = querySumLazy(2 * idx + 2, mid + 1, high, l, r);
        return left + right;
    }
}
