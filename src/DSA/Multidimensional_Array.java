package DSA;

import java.util.Scanner;

public class Multidimensional_Array {

    public static void main(String[] args) {
        int[][] a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Rows in array:");
        int r =sc.nextInt();
        System.out.println("Column in array:");
        int c =sc.nextInt();
        a= new int[r][c];

        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++){
                System.out.println("Enter element in a["+i+"]"+"["+j+"]");
                a[i][j]= sc.nextInt();
            }
        }

        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++){
                System.out.println(a[i][j]);

            }
        }

    }
}
