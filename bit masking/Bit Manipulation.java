class Solution {
    static void bitManipulation(int num, int i) {
        i--;
        long mask = 1l << i;
        long ithBit = (num & mask) == 0 ? 0 : 1;
        System.out.print(ithBit + " ");
        long seti = num | mask;
        System.out.print(seti + " ");
        long cleari = num & ~mask;
        System.out.print(cleari);
    }
}
