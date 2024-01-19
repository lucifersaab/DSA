package DSA;

class BinaryHeap {
    int[] heap = new int[10];
    int index = -1;

    int parent = 0;

    void insertion(int value) {

        if (index < heap.length - 1) {
            index++;
            heap[index] = value;
            parent = (index - 1) / 2;
            heapifyUp();


        } else
            System.out.println("Overflow!");
    }

    void heapifyUp() {
        int x = index;
        while (heap[x] < heap[parent]) {
            swap(parent,x);
            x=parent;
            parent = (x - 1) / 2;

        }
    }
    void deletion() {

        heap[0] = heap[index];
        index--;
        heapifyDown();
        parent = (index - 1) / 2;


    }
    void heapifyDown() {

        int min = 0;
        int parent = 0;
        int left = 1;
        int right = 2;
        while (left <= index || right <= index) {
            if (left <= index && heap[parent] > heap[left])
                min = left;
            if (right <= index && heap[min] > heap[right])
                min = right;
            else
                break;
            swap(parent, min);
            parent = min;
            left=(2*parent)+1;
            right=(2*parent)+2;

        }
    }

    void swap(int parent,int x){
        int temp = heap[parent];
        heap[parent] = heap[x];
        heap[x] = temp;

    }
//int size(){ u can implement the same method frm binary tree }

        void print () {

            for (int i = 0; i <= index; i++) {
                System.out.print(heap[i] + " ");
            }
        }

        class PQ {

//boolean enqueue(int value){
//return insertion(value);
        }

        public static void main (String[]args){
            BinaryHeap obj = new BinaryHeap();

            obj.insertion(30);
            obj.insertion(40);
            obj.insertion(50);
            obj.insertion(10);
            obj.insertion(20);
            obj.insertion(90);
            obj.insertion(55);
//            obj.insertion(30);
//            obj.insertion(50);

            obj.print();

            obj.deletion();
            System.out.println();
            obj.print();

            obj.deletion();
            System.out.println();
            obj.print();
        }
}

