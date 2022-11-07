import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int city, cost;
    Pair(int city, int cost){
        this.city = city;
        this.cost = cost;
    }
}

class Tuple{
    int stops, city, cost;
    Tuple(int stops, int city, int cost){
        this.stops = stops;
        this.city = city;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        int cost[] = new int[n];     
        Arrays.fill(cost, (int)1e9);
        Queue<Tuple> q = new LinkedList<>();
        
        q.add(new Tuple(0, src, 0));
        cost[src] = 0;
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int city = t.city;
            int currCost = t.cost;
            int stops = t.stops;
            
            if(stops <= k){
                for(Pair it : adj.get(city)){
                    int nextCity = it.city;
                    int nextCost = it.cost;
                    
                    if(nextCost + currCost < cost[nextCity]){
                        q.add(new Tuple(stops + 1, nextCity, nextCost + currCost));
                        cost[nextCity] = nextCost + currCost;
                    }
                }
            }
        }
        if(cost[dst] == (int) 1e9) return -1;
        return cost[dst];
    }
}