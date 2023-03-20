import java.util.HashMap;

class DLLNode{
    int key, val;
    DLLNode prev = null, next = null;
    DLLNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private DLLNode head, tail;
    private HashMap<Integer, DLLNode> nodeAddr;
    private int cap;

    private void shiftToRightEnd(DLLNode curr){        
        if(curr.next == null){
            return;
        }
        remove(curr);
        insertAtEnd(curr);
    }

    private void remove(DLLNode node){
        if(node == head){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }
        
        node.next.prev = node.prev;
        
        node.next = null;
        node.prev = null;
    }

    private void insertAtEnd(DLLNode node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private int removeStart(){
        DLLNode next = head.next;
        int key = head.key;

        head.next = null;
        head = next;
        return key;
    }

    public LRUCache(int capacity) {
        cap = capacity;

        nodeAddr = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(nodeAddr.containsKey(key)){
            DLLNode keyNode = nodeAddr.get(key);
            shiftToRightEnd(keyNode);
            return keyNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(nodeAddr.containsKey(key)){
            shiftToRightEnd(nodeAddr.get(key));
            nodeAddr.get(key).val = value;    
        }
        else{
            DLLNode keyNode = new DLLNode(key, value);

            if(nodeAddr.size() == cap){
                int removedKey = removeStart();
                nodeAddr.remove(removedKey);
            }
            insertAtEnd(keyNode);
            nodeAddr.put(key, keyNode);
        }
        
    }
}