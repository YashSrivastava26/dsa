import java.util.Arrays;

class Solution {

    private boolean isPlaced(int[] pos, int mid, int count){
        int lastCordinate = pos[0];
        count--;
        for (int i = 1; i < pos.length; i++) {
            if(pos[i] - lastCordinate >= mid){ 
                count--;
                lastCordinate = pos[i];
            }
        }
        if(count <= 0) return true;
        return false;
    }

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];

        int resultant = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isPlaced(position, mid, m)){
                resultant = mid;
                low = mid + 1;
            }
            else high = mid - 1;
            
        }

        return resultant;
    }
}