class Solution {
  
    public int XOR(int n, int m)
    { 
        return n ^ m;
    }
    public int check(int a, int b) {
        return (b >> (a - 1)) & 1;
    }
    public int setBit(int c, int d) {
        return d | (1 << c);
    }
}