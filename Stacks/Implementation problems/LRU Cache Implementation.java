import java.util.*;
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
public class LRUCache
{
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int cap;
    LRUCache(int capacity)
    {
        this.cap=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public void movetohead(Node curr){
        curr.next=head.next;
        curr.prev=head;
        head.next=curr;
        curr.next.prev=curr;
    }
    public void delete(Node curr){
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }
    public int get(int key)
    {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            delete(curr);
            movetohead(curr);
            return curr.val;
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            curr.val=value;
            delete(curr);
            movetohead(curr);
        }
        else if(map.size()<cap){
            map.put(key,new Node(key,value));
            movetohead(map.get(key));
        }
        else{
            map.put(key,new Node(key,value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            movetohead(map.get(key));
        }
    }
}
 
