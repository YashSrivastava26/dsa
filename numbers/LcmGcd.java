class Solution {
    public static Long findGcd(Long x, long y){
        if(x % y == 0) return y;
        return findGcd(y, x % y);
    }

    static Long[] lcmAndGcd(Long A , Long B) {
        Long result[] = new Long[2];
        result[1] = findGcd(A, B);
        result[0] = A * B / result[1];
        return result;

    }
};
