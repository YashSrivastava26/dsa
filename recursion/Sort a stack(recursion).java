import java.util.Stack;

class GfG{

    private void insertInSortedOrder(Stack < Integer > s, int popEle){
        if(s.empty() || s.peek()<popEle) {
	        s.push(popEle);//chutiya stack ya vs code error nahi ha
	    }
        else{
            int temp = s.pop();
            insertInSortedOrder(s, popEle);
            s.push(temp);
        }
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.empty()) return s;

        int popEle = s.pop();
        sort(s);
        insertInSortedOrder(s, popEle);
        return s;
	}
}