package DSA;

public class FA21_BCS_138_main {

    public static void main(String[] args) {

        Avltree_Final_Lab obj =new Avltree_Final_Lab();
       obj.root= obj.insert(obj.root,50);
       obj.root= obj.insert(obj.root,60);
       obj.root= obj.insert(obj.root,70);
       obj.root= obj.insert(obj.root,80);
       obj.root= obj.insert(obj.root,90);

       obj.preorder(obj.root);

       obj.printRight(60);

        System.out.println();
        System.out.println("parent:"+ obj.parent(obj.root,80));

        int[] a={1,2,3,4,5};

        Avltree_Final_Lab obj2=new Avltree_Final_Lab(a);

        obj.remove(obj.root,70);




        
    }

}
