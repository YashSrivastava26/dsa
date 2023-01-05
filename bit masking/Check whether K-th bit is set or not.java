class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        long mask = 1l << k;
        return (n & mask) == 0 ? false : true;
    }
    
}