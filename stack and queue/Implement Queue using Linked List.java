class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        QueueNode curr = new QueueNode(a);
        if(rear != null){
            rear.next = curr;
            rear = curr;
        }
        else{
            rear = curr;
            front = curr;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
	    if(front == null){
	        return -1;
	    }
        int ret = front.data;
	    front = front.next;
	    if(front == null){
	        rear = null;
	    }
	    return ret;
	    
	}
}