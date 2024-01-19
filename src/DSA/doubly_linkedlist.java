package DSA;

public class doubly_linkedlist {
    class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    Node insert_loc(Node root, int loc, Node node){

        Node ptr=root;

        if(root==null)
            root=node;
        else if (loc==1){
            node.next=root;
            root.prev=node;
            root=node;
        }
        else {
            int counter=0;

            while (ptr!=null){
                counter++;

                if(counter==loc)
                    break;
                ptr=ptr.next;
            }

            node.next=ptr;
            ptr.prev.next=node;
        }

        return root;
    }




}

