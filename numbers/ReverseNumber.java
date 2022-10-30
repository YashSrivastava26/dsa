class Solution
{
    public long reverse_digit(long n)
    {
        long reversed = 0;
        while(n != 0){
            reversed = reversed * 10 + n % 10;
            n = n / 10;
        }
        return reversed;
    }
}

public class ReverseNumber {
    
}
