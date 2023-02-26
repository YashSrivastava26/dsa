#include<bits/stdc++.h>
using namespace std;

class Solution{
public:	
	void immediateSmaller(vector<int>&arr, int n) {
	    int prev = INT_MAX;
	    for(int i = n - 1; i >= 0; i--){
	        int temp = arr[i];
	        
	        if(prev < arr[i]){
	            arr[i] = prev;
	        }
	        else{
	            arr[i] = -1;
	        }
	        prev = temp;
	    }
	}

};