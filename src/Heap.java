import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int nums[] = {3,4,5,2};

        BinaryHeap myHeap = new BinaryHeap(nums.length);

        for (int i: nums){
            myHeap.insert(i);
        }

        System.out.println(myHeap.delete(0));
        System.out.println(myHeap.delete(0));
        System.out.println(myHeap.delete(0));

        myHeap.delete(0);
    }


    public static class BinaryHeap{
        private int capacity;
        private int[]heap;
        private int heapSize;


        public BinaryHeap(int c){
            this.capacity = c;
            this.heap = new int[c + 1];
            this.heapSize = 0;
            Arrays.fill(heap, -1);
        }

        public void insert(int x) {
            if(heapSize > heap.length)
                return;
            heap[heapSize++] = x;
            heapifyUp(heapSize - 1);
        }

        public void heapifyUp(int i){ // i is the last index that has value in the array
            int temp = heap[i];
            while (i > 0 && temp >= heap[(i-1)/2]) { // the root does not have a parent node, so that s why we dont have i >= 0
                heap[i] = heap[(i-1)/2];
                i= (i - 1)/ 2;
            }
            heap[i] = temp;
        }

        public int delete(int x) { // x here is the index
            int key = heap[x];

            heap[x] = heap[heapSize - 1]; //get the leaf node to replace the deleted
            heapSize--;
            heapifyDown(x);
            return key;
        }

        private void heapifyDown(int i) {
            int child;
            int temp = heap[i];
            int leftChild = (2 * i) + 1;
            while ( ((2 * i) + 1)< heapSize){
                child = maxChild(i);

                if(temp <= heap[child]){
                    heap[i] = heap[child];
                }
                else
                    break;
                i = child;
            }
            heap[i] = temp;
        }

        private int maxChild(int i ) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
        }

        public int getMax(){
            return heap.length > 0 ? heap[0] : -1;
        }
    }
}
