package DSA;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Graph{

    String[] vertex= new String[7];
    int[][] adjmatrix=new int[7][7];
    int vertexindex=-1;

    void insert_vertex(String key){
        vertexindex++;
        vertex[vertexindex]=key;
    }

    void adjacent(String vertex, String adjacent, int edge){

        int index1=search(vertex);
        int index2=search(adjacent);

        adjmatrix[index1][index2]=edge;

    }

    int search( String s){
        int i;
        for(i=0;i<=vertexindex;i++){
            if(Objects.equals(vertex[i], s)){
                break;
            }
        }

        return i;
    }

    void print_adjacency(){
        for(int i=0;i<adjmatrix.length;i++)
        {
            for(int j=0;j<adjmatrix.length;j++){
                System.out.print(adjmatrix[i][j]+" ");

            }
            System.out.println();
        }
    }

    void dfs(String key){
        boolean found=false;
        Stack<String> stk=new Stack<>();
        int i=0;
        int counter=0;
        stk.push(vertex[i]);
        do{
            String s=stk.pop();
            counter++;
            if(counter==vertexindex)
                break;
            if(s.equals(key)){
                found=true;
            }
            else {
                int index=search(s);
                for(int j=0;j<adjmatrix.length;j++) {
                    if (adjmatrix[index][j]!=0){
                        stk.push(vertex[j]);
                    }
                }
            }
        }while (!stk.isEmpty()&&!found);

        if(found){
            System.out.println("\nNode found");
        }
        else
            System.out.println("\nPath does not exist");

    }

    public static void main(String[] args) {
        Graph obj=new Graph();

        obj.insert_vertex("Atlanta");
        obj.insert_vertex("Austin");
        obj.insert_vertex("Chicago");
        obj.insert_vertex("Dallas");
        obj.insert_vertex("Denver");
        obj.insert_vertex("Houston");
        obj.insert_vertex("Washington");


        obj.adjacent("Atlanta","Washington",600);
        obj.adjacent("Washington","Atlanta",600);
        obj.adjacent("Atlanta","Houston",800);
        obj.adjacent("Houston","Atlanta",800);
        obj.adjacent("Denver","Atlanta",1400);
        obj.adjacent("Washington","Dallas",1300);
        obj.adjacent("Austin","Houston",160);
        obj.adjacent("Austin","Dallas",200);
        obj.adjacent("Dallas","Austin",200);
        obj.adjacent("Dallas","Denver",780);
        obj.adjacent("Chicago","Denver",1000);
        obj.adjacent("Denver","Chicago",1000);
        obj.adjacent("Dallas","Chicago",900);

        obj.print_adjacency();
        obj.dfs("sheeda");

    }

}