public class Solution {

    static class MinHeap {
        int size;
        int cap;
        int []heap;
        // Constructor for the class.
        MinHeap(int size) {
            this.size=size;
            this.cap=0;
            heap=new int[this.size];
        }
        void heapify(int i){
            int smallest=i;
            int left=2*i+1;
            int right=2*i+2;
            if(left<cap && heap[left]<heap[smallest]){
                smallest=left;
            }
            if(right<cap && heap[right]<heap[smallest]){
                smallest=right;
            }
            if(smallest!=i){
                swap(i,smallest);
                heapify(smallest);
            }
        }
        void swap(int i,int smallest){
            int temp=heap[i];
            heap[i]=heap[smallest];
            heap[smallest]=temp;
        }
        // Implement the function to remove minimum element.
        int extractMinElement() {
            if(cap==0) return -1;
            int min=heap[0];
            swap(0,cap-1);
            cap--;
            heapify(0);
            return min;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            if(ind>=cap) return;
            swap(ind,cap-1);
            cap--;
            heapify(ind);
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            if(cap==size) return;
            heap[cap]=val;
            cap++;
            int i=cap-1;
        
            while(i>=0){
                int p=(i-1)/2;
                if(heap[p]>heap[i]){
                    swap(p,i);
                    i=p;
                }else break;
            }
        }
    }
};