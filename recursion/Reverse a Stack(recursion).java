import java.util.Stack;

class Solution
{ 
    private static void insert(Stack < Integer > s, int popEle){
        if(s.empty()){
            s.push(popEle);
        }
        else{
            int temp = s.pop();
            insert(s, popEle);
            s.push(temp);
        }
    }
    static void reverse(Stack<Integer> s)
    {
        if(s.empty()) return;
        int popEle = s.pop();
        reverse(s);
        insert(s, popEle);
    }
}