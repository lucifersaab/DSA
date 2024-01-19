package DSA;

import java.util.Scanner;

public class Stack_ {


    public char[] a;
    public int b, i;
    public int Top = -1;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack_ obj = new Stack_();
        System.out.println(obj.pop());
        System.out.println(obj.pop());


    }

    public void stackmake(int n) {

        a = new char[n];

//        System.out.println("Press 1 to enter value , Press 0 to exit");
//        i = sc.nextInt();
//
//        while (i == 1) {
//            System.out.println("Enter value");
//            b = sc.nextInt();
//            push(b);
//            System.out.println("Press 1 to enter value , Press 0 to exit");
//            i = sc.nextInt();
//
//        }
    }

    public void push(char x) {

        if(Top+1>=a.length){
            System.out.println("Array is full");
        }
        else {
            a[++Top] = x;
        }

    }

    public char pop() {

        char k;
        System.out.println("Value of Top:"+Top);

        if (isEmpty()) {
            System.out.println("Empty");
        }

         return a[Top--];
    }

    public boolean isEmpty() {
        return Top < 0;
    }

}