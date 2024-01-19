package DSA;

//DELETING ELEMENT FROM ARRAY

import java.util.Scanner;

public class Deleting {
    static int[] a=new int[5];
    static int[] b;
    static int n;

    static Scanner s = new Scanner(System.in);

    static int delete(int[] arr,int size, int key){
        int index=-1;
        for (int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=0;i<size;i++){
            if(arr[i]==key) {
                index = i;
                break;
            }
        }
        if (index!=-1) {
            for (int j = index; j < size - 1; j++) {
                arr[j] = arr[j + 1];
            }
            size--;
        }

        for (int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return index;
    }

    public static void main(String[] args) {
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        a[4]=5;

        System.out.println(delete(a,5,2));


    }
}
