package DSA;

import java.util.Scanner;

//ADDING ELEMENTS IN ARRAY

public class Adding {

    static int[] a;
    static int[] b;
    static int n;

//    static Scanner s = new Scanner(System.in);
//
    public static void main(String[] args) {
//        System.out.println("Enter size of array:");
//        n = s.nextInt();
//
//        a = new int[n];
//        b = new int[n + 1];
//
//        System.out.println("Enter elements in an array:");
//        for (int i = 0; i < n; i++) {
//
//            a[i] = s.nextInt();
//        }
//
//        System.out.println("New element at index:");
//        int k = s.nextInt();
//        System.out.println("Enter element:");
//        int el = s.nextInt();
//
//        for (int i = 0; i < k; i++) {
//            b[i] = a[i];
//        }
//
//        b[k] = el;
//
//        for (int i = k; i < n; i++) {
//            b[i + 1] = a[i];
//        }
//
//        for (int i = 0; i < n + 1; i++) {
//            System.out.println(b[i]);
//        }

        int[] arr = {1, 1, 1, 4, 2, 7, 8, 8, 3};

        System.out.println("Duplicate elements in given array: ");
        //Searches for duplicate element
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
        }
    }
}
