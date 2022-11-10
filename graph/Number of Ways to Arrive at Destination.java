import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.PriorityQueue;

// class Pair{
//     int city, time;
//     Pair(int city, int time){
//         this.city = city; 
//         this.time = time;
//     }
// }
// class Solution {

//     static int countPaths(int n, List<List<Integer>> roads) {
//         ArrayList < ArrayList < Pair > > adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < roads.size(); i++) {
//             adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
//             adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
//         }

//         PriorityQueue < Pair > pq = new PriorityQueue<>((x, y) -> x.time - y.time);
//         int time[] = new int[n];
//         int ways[] = new int[n];
//         Arrays.fill(time, (int) 1e9);

//         pq.add(new Pair(0, 0));
//         ways[0] = 1;
//         time[0] = 0;
//         int mod = (int)(1e9 + 7);
        
//         while(!pq.isEmpty()){
//             Pair currPair = pq.poll();
//             int currCity = currPair.city;
//             int currTime = currPair.time;

//             for (Pair adjPair : adj.get(currCity)) {
//                 int adjCity = adjPair.city;
//                 int adjTime = adjPair.time;
                
                
//                 if(adjTime + currTime == time[adjCity]){
//                     ways[adjCity] = (ways[adjCity] + ways[currCity]) % mod;
//                 }
                
//                 else if(adjTime + currTime < time[adjCity]){
//                     pq.add(new Pair(adjCity, adjTime + currTime));
//                     time[adjCity] = adjTime + currTime;
//                     ways[adjCity] = ways[currCity];
//                 }

//             }
//         }
//         return (int) (ways[n - 1] % (1e9 + 7));
//     }
// }

class Pair{
    int city;
    Long time;
    Pair(int city, long time){
        this.city = city; 
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList < ArrayList < Pair > > adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue < Pair > pq = new PriorityQueue<>((x, y) -> Long.compare(x.time, y.time));
        long time[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        int mod = (int) 1e9 + 7;
        time[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair currpair = pq.poll();
            int currCity = currpair.city;
            long currTime = currpair.time;

            for (Pair adjPair : adj.get(currCity)) {
                int adjCity = adjPair.city;
                long timeForAdjCity = adjPair.time + currTime;

                if(timeForAdjCity < time[adjCity]){
                    pq.add(new Pair(adjCity, timeForAdjCity));
                    time[adjCity] = timeForAdjCity;
                    ways[adjCity] = ways[currCity];

                }
                else if(timeForAdjCity == time[adjCity]){
                    ways[adjCity] = (ways[adjCity] + ways[currCity]) % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }
}