import java.util.HashMap;
import java.util.Map;
public class Solution {
    class Node {
    int key, value, cnt;
    Node prev, next;

    public Node(int k, int v) {
        key = k;
        value = v;
        cnt = 1;
    }
}

    class LinkedList {
        int size;
        Node head, tail;

        public LinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

    public void addNode(Node n) {
        Node t = head.next;
        head.next = n;
        n.prev = head;
        n.next = t;
        t.prev = n;
        size++;
    }

    public void deleteNode(Node n) {
        Node temp = n.next;
        n.prev.next = temp;
        temp.prev = n.prev;
        size--;
    }
}
    class LFUCache {
        private Map<Integer, Node> keyNode;
        private Map<Integer, LinkedList> freqMap;
        private int maxSize;
        private int minFreq;
        private int curSize;    
        LFUCache(int capacity) {
            maxSize = capacity;
            minFreq = 0;
            curSize = 0;
            keyNode = new HashMap<>();
            freqMap = new HashMap<>();
        }
        private void updateFreqMap(Node n) {
        keyNode.remove(n.key);
        freqMap.get(n.cnt).deleteNode(n);

        if (n.cnt == minFreq && freqMap.get(n.cnt).size == 0) {
            minFreq++;
        }

        LinkedList newList;
        if (freqMap.containsKey(n.cnt + 1)) {
            newList = freqMap.get(n.cnt + 1);
        } else {
            newList = new LinkedList();
        }

        n.cnt += 1;
        newList.addNode(n);
        freqMap.put(n.cnt, newList);
        keyNode.put(n.key, n);
    }
        public int get(int key) {
            if (keyNode.containsKey(key)) {
            Node n = keyNode.get(key);
            int res = n.value;
            updateFreqMap(n);
            return res;
        }
        return -1;
        }

        public void put(int k, int v) {
            if (keyNode.containsKey(k)) {
            Node n = keyNode.get(k);
            n.value = v;
            updateFreqMap(n);
        } else {
            if (curSize == maxSize) {
                LinkedList list = freqMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                list.deleteNode(list.tail.prev);
                curSize--;
            }

            minFreq = 1;
            curSize++;

            LinkedList newList;
            if (freqMap.containsKey(minFreq)) {
                newList = freqMap.get(minFreq);
            } else {
                newList = new LinkedList();
            }

            Node n = new Node(k, v);
            newList.addNode(n);
            keyNode.put(k, n);
            freqMap.put(minFreq, newList);
        }
    }
    }
}