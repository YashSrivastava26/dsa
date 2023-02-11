class MyQueue {
    int s1[] = new int[101];
    int s2[] = new int[101];
    int top1, top2;

    public MyQueue() {
        top1 = -1;
        top2 = -1;
    }
    
    public void push(int x) {
        s1[++top1] = x;
    }
    
    public int pop() {
        if(top2 == -1){
            while(top1 != -1){
                s2[++top2] = s1[top1--];
            }
        }
        return s2[top2--];
    }
    
    public int peek() {
        if(top2 == -1){
            while(top1 != -1){
                s2[++top2] = s1[top1--];
            }
        }
        return s2[top2];
    }
    
    public boolean empty() {
        if(top1 == -1 && top2 == -1){
            return true;
        }
        return false;
    }
}