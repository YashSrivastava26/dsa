import java.util.ArrayList;

class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> result = new ArrayList<>();
        int low = 0, high = n - 1;
        if(arr[0] == x) result.add(0l);
        else{
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(mid > 0 && arr[mid] == x && arr[mid - 1] != x){
                    result.add((long)mid);
                    break;
                }
                else if(arr[mid] < x) low = mid + 1; 
                else high = mid - 1;
            }
        } 
        if(result.isEmpty()) result.add(-1l);

        if(arr[n - 1] == x) result.add((long)n - 1);
        else{
            low = 0;
            high = n - 1;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(mid < n - 1 && arr[mid] == x && arr[mid + 1] != x){
                    result.add((long)mid);
                    break;
                }
                else if(arr[mid] > x) high = mid - 1;
                else low = mid + 1;
            }
        } 

        if(result.size() == 1) result.add(-1l);
        return result;
    }
}