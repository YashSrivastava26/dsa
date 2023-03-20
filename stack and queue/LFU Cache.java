import java.util.*;

class DLLNode{
    int key, val, freq;
    DLLNode prev, next;
    DLLNode(int key, int val){
        this.key = key;
        this.val = val;
        freq = 1;
    }
}

class DoublyLinkedList{
    DLLNode head, tail;
    private int listSize;

    DoublyLinkedList(){
        head = null;
        tail = null;
        listSize = 0;
    }

    void insert(DLLNode node){
        if(head == null){
            head = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        listSize++;
    }

    void remove(DLLNode node){
        if(head == node){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }

        if(node == tail){
            tail = node.prev;
            if(tail != null) tail.next = null;
        }
        else{
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
        listSize--;
    }

    int size(){
        return listSize;
    }

    int removeFirst(){
        int key = head.key;
        remove(head);
        return key;
    }
}
class LFUCache {
    private int cap, lestFreq;
    private HashMap<Integer, DoublyLinkedList> freqNode;
    private HashMap<Integer, DLLNode> keyNode;

    private void increaseFreq(DLLNode node){
        DoublyLinkedList currDLL = freqNode.get(node.freq);

        currDLL.remove(node);

        node.freq++;
        if(freqNode.get(lestFreq).size() == 0){
            lestFreq++;
        }

        DoublyLinkedList nextDLL;
        if(!freqNode.containsKey(node.freq)){
            freqNode.put(node.freq , new DoublyLinkedList());
        }
        nextDLL = freqNode.get(node.freq);

        nextDLL.insert(node);
    }

    private void update(DLLNode node, int value){
        DoublyLinkedList currDLL = freqNode.get(node.freq);

        currDLL.remove(node);

        node.val = value;
        node.freq++;
        if(freqNode.get(lestFreq).size() == 0){
            lestFreq++;
        }

        DoublyLinkedList nextDLL;
        if(!freqNode.containsKey(node.freq)){
            freqNode.put(node.freq, new DoublyLinkedList());
        }
        nextDLL = freqNode.get(node.freq);

        nextDLL.insert(node);
    }


    private void removeLestFrequent(){
        DoublyLinkedList lestList = freqNode.get(lestFreq);
        
        int removed = lestList.removeFirst();
        keyNode.remove(removed);
    }

    public LFUCache(int capacity) {
        cap = capacity;
        lestFreq = 0;
        freqNode = new HashMap<>();
        keyNode = new HashMap<>();
    }
    
    public int get(int key) {
        if(keyNode.containsKey(key)){
            DLLNode node = keyNode.get(key);
            increaseFreq(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyNode.containsKey(key)){
            DLLNode node = keyNode.get(key);
            update(node, value);
        }
        else{
            if(keyNode.size() == cap){
                removeLestFrequent();
            }
            DLLNode node = new DLLNode(key, value);
            if(!freqNode.containsKey(1)){
                freqNode.put(1, new DoublyLinkedList());
            }
            DoublyLinkedList firstFreq = freqNode.get(1);
            firstFreq.insert(node);
            keyNode.put(key, node);
            lestFreq = 1;
        }
    }
}