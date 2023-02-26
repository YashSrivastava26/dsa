import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}


class Solution
{
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare (Item i1, Item i2) {
                double ratio1 = (double)i1.value/i1.weight;
                double ratio2 = (double)i2.value/i2.weight;
                return ratio2 > ratio1 ? 1 : -1;
            }

        });
        double sack = 0;
        
        for(int i = 0; i < n; i++){
            if(arr[i].weight <= w){
                w -= arr[i].weight;
                sack += arr[i].value;
            }
            else{
                sack += arr[i].value * ((double) w /  arr[i].weight);
                break;
            }
        }
        return sack;
    }
}