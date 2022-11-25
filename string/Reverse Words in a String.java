// TC = O(n)
//SC = O(n)
//using stack




//TC = O(2 * n)
class Solution {
    
    public void reverse_i_to_j(StringBuffer str, int start, int end){
        while(start < end){
            char temp = str.charAt(end);
            str.setCharAt(end, str.charAt(start));
            str.setCharAt(start, temp);
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuffer str = new StringBuffer(s);
        
        int j = str.length() - 1;
        int i = j;
        boolean space = false;
        
        while(i >= -1){
            if(i == - 1 || str.charAt(i) == ' '){
                if(!space){
                    reverse_i_to_j(str, i + 1, j);
                    
                    space = true;
                }
                else {
                    str.delete(i, i + 1);
                }
            }
            else{
                if(space){
                    space = false;
                    j = i;
                }
            }
            i--;
        }
        reverse_i_to_j(str, 0, str.length() - 1);
        return str.toString();
    }
}