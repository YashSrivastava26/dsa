import java.util.ArrayList;
import java.util.List;

class Solution {
    
    private static void generate(int n, int last, ArrayList< String > binary, StringBuffer currStr){
        
        if(currStr.length() == n){
            binary.add(currStr.toString());
            //System.out.println(currStr);
            return;
        }
        
        currStr.append("0");
        generate(n, 0, binary, currStr);
        currStr.deleteCharAt(currStr.length() - 1);
        
        if(last != 1){
            currStr.append("1");
            generate(n, 1, binary, currStr);
            currStr.deleteCharAt(currStr.length() - 1);
        }
        
        
        
    }
    
    public static List<String> generateBinaryStrings(int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer currStr = new StringBuffer();
        generate(n, -1, ans, currStr);
        
        return ans;
        
        
    }
}