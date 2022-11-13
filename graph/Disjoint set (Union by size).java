class GfG
{
    int size[] = new int[102];

	int find(int A[],int X){
        if(A[X] == X) return X;
        return A[X] = find(A, A[X]);
	}
	void unionSet(int A[],int X,int Z){
        
        int ultp_x = find(A, X);
        int ultp_z = find(A, Z);

        if(ultp_x == ultp_z) return;
        if(size[ultp_x] > size[ultp_z]){
            A[ultp_z] = ultp_x;
            size[ultp_x] += size[ultp_z];
        }
        else{
            A[ultp_x] = ultp_z;
            size[ultp_z] += size[ultp_x];
        }
        
	}
}
