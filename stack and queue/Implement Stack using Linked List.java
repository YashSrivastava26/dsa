class MyStack 
{
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        StackNode curr = new StackNode(a);
        curr.next = top;
        top = curr;
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        if(top == null){
            return -1;
        }
        int ret = top.data;
        top = top.next;
        return ret;
    }
}