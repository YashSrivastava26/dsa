import java.util.ArrayList;

class GfG
{
    int rank[] = new int[101];

	int find(int A[],int X){
        if(A[X] == X) return X;
        return A[X] = find(A, A[X]);
	}
	void unionSet(int A[],int X,int Z){
        
        int ultp_x = find(A, X);
        int ultp_z = find(A, Z);

        if(ultp_x == ultp_z) return;
        if(rank[ultp_x] > rank[ultp_z]){
            A[ultp_z] = ultp_x;
        }
        else if(rank[ultp_x] < rank[ultp_z]){
            A[ultp_x] = ultp_z;
        }
        else {
            A[ultp_z] = ultp_x;
            rank[ultp_x] ++;
        }
        
	}
}