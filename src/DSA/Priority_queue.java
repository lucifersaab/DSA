package DSA;

import java.util.Arrays;
import java.util.Scanner;

public class Priority_queue {
    int front=-1;
    int back=-1;
    static Scanner sc = new Scanner(System.in);

    int[] arr;
    void creation(){
        System.out.println("Enter size of queue:");
        int x=sc.nextInt();
        arr = new int[x];
    }
    boolean isFull(){
     return back==arr.length-1;
    }
    void enqueue(){
        System.out.println("Enter value");
        int input=sc.nextInt();
        while (!isFull() && input!=-1){
            if(front==-1){
                front++;
            }
            back++;
            arr[back]=input;
            System.out.println("Enter value");
            input=sc.nextInt();
        }
        if(isFull())
            System.out.println("Queue is full");
    }
    void display(){
        for (int i=front;i<=back;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    int find_max() {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
    void sort(){
        int min;
        for (int i = 0; i < back; i++) {
            for (int j = 0; j < back; j++) {
                if(arr[j]>arr[j+1]){
                    min=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=min;
                }
            }
        }
    }

    void dequeue(){
        sort();
        front++;
    }

    public static void main(String[] args) {
        Priority_queue pq = new Priority_queue();
        pq.creation();
        pq.enqueue();
        pq.display();
        System.out.println();
        pq.dequeue();
        pq.display();

    }
    
}
