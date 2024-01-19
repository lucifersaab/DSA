package DSA;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


class Practice {

    public static void main(String[] args) {
//        int[][] arr = new int[3][3];
//        arr[0][1]=1;
//        arr[0][2]=4;
//        arr[1][0]=2;
//        arr[2][0]=3;
//
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//
//        int temp;
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                temp = arr[i][j]+100;
//                arr[i][j]=arr[j][i];
//                arr[j][i]=temp-100;
//
//                System.out.println();
//                for(int k=0;k<3;k++){
//                    for(int l=0;l<3;l++){
//                        System.out.print(arr[k][l]);
//                    }
//                    System.out.println();
//                }
//            }
//
//        }


        // set the path of the folder
        String folderPath = "C:\\Users\\hashi\\Downloads\\ASSIGNMENT 4 CS";

        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        int count = 0;

        for (File file : files) {
            String s = file.getName();
            for (int i = 0; i < 12; i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
            count++;
        }
        System.out.println("Total: " + count);
    }
}