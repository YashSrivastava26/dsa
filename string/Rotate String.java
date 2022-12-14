//O(m * n)

class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String temp = s + s;
        if(temp.indexOf(goal) != -1) return true;
        return false;
    }
}