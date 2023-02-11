class MyStack {
    int rear1 , front1 , rear2, front2;
    int q1[] = new int[1000];
    int q2[] = new int[1000];


    public MyStack() {
        rear1 = 0; 
        front1 = 0;
        rear2 = 0; 
        front2 = 0;
    }
    
    public void push(int x) {
        if(rear1 != 0){
            q1[rear1++] = x;
        }
        else{
            q2[rear2++] = x;
        }

    }
    
    public int pop() {
        if(rear1 == 0){
            while(front2 < rear2 - 1){
                q1[rear1++] = q2[front2++];
            }
            int ret = q2[front2];
            rear2 = front2 = 0;
            return ret;
        }
        else{
            while(front1 < rear1 - 1){
                q2[rear2++] = q1[front1++];
            }
            int ret = q1[front1];
            rear1 = front1 = 0;
            return ret;
        }
    }
    
    public int top() {

        if(front1 == rear1){
            return q2[rear2 - 1];
        }
        return q1[rear1 - 1];
    }
    
    public boolean empty() {

        if(front1 == rear1 && front2 == rear2){
            return true;
        }
        return false;
    }
}