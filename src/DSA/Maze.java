package DSA;
import java.io.*;


class Maze{
    private int m,n;
    private int[][] a;
    private static final int OPEN = 0, WALL = 1, TRIED = 2, PATH = 3;


    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public Maze(String filename){
        int i, j=0,l=0,k=0;


        try {
            File f = new File(filename);
            FileInputStream fip = new FileInputStream(f);

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            i= Integer.parseInt(br.readLine());
            m=i;
            i= Integer.parseInt(br.readLine());
            n=i;


            a = new int[m][n];

            while ((i=fip.read())!=-1) {
                int x=i;
                x=x-48;
                a[l][k] = x;

                if (Character.isDigit(i) && j >=7) {
                    k++;
                    if(k==n){
                        k=0;
                        l++;
                    }
                }
                j++;
            }
            fip.close();

        } catch (IOException ex) {
            System.out.println("Input error");
        }
    }

    public boolean isOpen(Location location){
        return (a[location.getY()][location.getX()] == OPEN);
    }

    public void markMoved(Location location){
        a[location.getY()][location.getX()] = PATH;
    }

    public void markTried(Location location){
        a[location.getY()][location.getX()] = TRIED;
    }

    public int getWidth(){
        return n;
    }

    public int getHeight(){
        return m;
    }

    public void print(){
        char [] chars = {' ','#','?','o'};
        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++)
              System.out.print(chars[Integer.parseInt(String.valueOf(a[i][j]))]);
            System.out.println();
        }
    }
}






