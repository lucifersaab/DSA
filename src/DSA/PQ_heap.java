package DSA;

public class PQ_heap{

    static class Node{
        int left;
        int right;
        int data;
        Node(int data){
            this.data=data;
            right=0;
            left=0;
        }
    }
    int index=-1;
    Node[] heap=new Node[10];
    int parent=0;



     void enqueue(int n){
         index++;
         parent=(index-1)/2;
         heap [index]=new Node(n);
         heap [index].left=(2*index)+1;
         heap [index].right=(2*index)+2;
         heapifyUp();
     }

    void heapifyUp() {
        int x = index;
        while (heap[x].data < heap[parent].data) {
            swap(parent,x);
            x=parent;
            parent = (x - 1) / 2;
        }

    }

    void swap(int parent,int x){
        int data = heap[parent].data;
        heap[parent].data = heap[x].data;
        heap[x].data = data;
    }

    void dequeue(){
         heap[0].data=heap[index].data;
         index--;
         heapifyDown();
        parent = (index - 1) / 2;
    }

    void heapifyDown() {
        int min = 0;
        int parent = 0;

        while (heap[parent].left<=index || heap[parent].right<=index ) {
            if (heap[parent].left <= index && heap[parent].data > heap[heap[parent].left].data)
                min = heap[parent].left;
            if (heap[parent].left <= index && heap[min].data > heap[heap[parent].right].data)
                min = heap[parent].right;
            if(parent==min)
                break;
            swap(parent, min);
            parent = min;
        }
    }

    void print () {

        for (int i = 0; i <= index; i++) {
            System.out.print(heap[i].data + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        PQ_heap obj=new PQ_heap();

        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50);
        obj.enqueue(10);
        obj.enqueue(20);
        obj.print();
        obj.dequeue();
        obj.print();

    }

}
