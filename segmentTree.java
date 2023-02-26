//max values
class SegmentTree{
    int seg[];

    SegmentTree(int n){
        seg = new int[4 * n];
    }

    void build(int idx, int arr[], int low, int high){
        if(low == high){
            seg[idx] = arr[low];
        }

        int mid = low + (high - low) / 2;

        build(2 * idx + 1, arr, low, mid);
        build(2 * idx + 2, arr, mid + 1, high);

        seg[idx] = Math.max(seg[2 * idx + 1] , seg[2 * idx + 2]);
    }

    int query(int idx, int arr[], int low, int high, int l, int r){

        if(low >= l && high <= r){
            return seg[idx];
        }
        if(high < l || low > r){
            return Integer.MIN_VALUE;
        }

        int mid = low + (high - low) / 2;

        int left = query(2 * idx + 1, arr, low, mid, l, r);
        int right = query(2 * idx + 2, arr, mid + 1, high, l, r);

        return Math.max(left, right);
    }

}