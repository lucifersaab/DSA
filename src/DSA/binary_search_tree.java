package DSA;

import java.util.*;
import java.util.Queue;


public class binary_search_tree extends binary_tree{


    Node root=null;
    static Scanner sc = new Scanner(System.in);
    Node creation() {
        System.out.println("Enter value: ");
        int input = sc.nextInt();
        while (input != -1) {

            Node newnode = new Node(input);
            root=insert(root,newnode);
            System.out.println("Enter value: ");
            input = sc.nextInt();

        }
        return root;
    }

    Node insert(Node node, Node newnode){
        if(node==null) {
            node = newnode;
        }
        else if (newnode.data<node.data) {
            node.left = insert(node.left, newnode);
        }
        else if (newnode.data> node.data) {
            node.right = insert(node.right, newnode);
        }
        return node;
    }

    int parent(Node root,int node){

        if (root != null) {
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                root = q.remove();
                if(root.right!=null){
                    if (root.right.data == node)
                        break;
                    q.add(root.right);
                }if(root.left!=null){
                    if (root.left.data == node)
                        break;
                    q.add(root.left);
                }
            }
        }
        if(root==null){
            System.out.println("Parent not found for:");
            return node;
        }
        else return 0;
    }
    void bfs(Node root) {
        if (root != null) {
            Queue<Node> q= new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                root= q.remove();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }

            }
        }
    }

    void dfs(Node root) {
        if (root != null) {
            Stack<Node> stk = new Stack<>();
            stk.push(root);
            System.out.println("DEPTH FIRST PRINTING:");
            System.out.println();
            while (!stk.isEmpty()) {
                root= stk.pop();
                System.out.print(root.data+" ");
                if (root.right != null) {
                    stk.push(root.right);
                }
                if (root.left != null) {
                    stk.push(root.left);
                }

            }
        }
    }

    void search(Node root, int key){
        Queue<Node> qobj= new LinkedList<>();
        qobj.add(root);
        while (!qobj.isEmpty()){
            root=qobj.remove();
            if(root.data==key){
                System.out.println("Node found!");
                break;
            }
            else {
                if (root.left!=null) {
                    qobj.add(root.left);
                }
                if (root.right!=null) {
                    qobj.add(root.right);
                }
            }
        }
        if(root.data!=key)
            System.out.println("Node not present");
    }
    int level(Node root, int key,int depth) {
        if(root==null)
            return -1;
        if(root.data==key)
            return depth ;
        int right = level(root.right, key,depth + 1);
        int left = level(root.left, key,depth + 1);
        return Math.max(left, right);
    }

    int height(Node root, int height) {
        if(root==null)
            return height-1;

        int right = height(root.right,height+ 1);
        int left = height(root.left,height + 1);

        return Math.max(left, right);

    }

    boolean check_binary(Node root, boolean x) {
        if(root==null)
            return x;
        if(root.left!=null)
            x=root.left.data < root.data;
        if (root.right!=null)
            x=root.right.data>root.data;

        x=check_binary(root.left,x);
        x=check_binary(root.right,x);

        return x;
    }

    boolean binarychk(Node root){
        Queue<Node> q =new LinkedList<>();
        boolean x=false;
        q.add(root);
        while (!q.isEmpty()){
            Node n=q.remove();
            if(n.right!=null) {
                x = n.right.data > n.data;
                q.add(n.right);
                if(!x)
                    break;
            }
            if(n.left!=null) {
                x = n.left.data < n.data;
                q.add(n.left);
                if (!x)
                    break;
            }
        }
        return x;
    }

    int heightt(Node root){
        int h=0;
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++) {
                Node n = q.remove();
                if(n.left!=null) {
                    q.add(n.left);
                }
                if(n.right!=null) {
                    q.add(n.right);
                }
            }
            h++;
        }
        return h;
    }
    boolean levelllsame(Node root,int n1,int n2){
        int h=0;
        int l1=0,l2=0;
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++) {
                Node n = q.remove();
                if(n.data==n1){
                    l1=h;
                }
                if(n.data==n2)
                    l2=h;
                if(n.left!=null) {
                    q.add(n.left);
                }
                if(n.right!=null) {
                    q.add(n.right);
                }
            }
            h++;
        }
        return l1==l2;
    }

//    int levelnode(Node root){
//        int h=0;
//        Queue<Node> q =new LinkedList<>();
//
//    }


    boolean same_level(Node root, int key1, int key2){
        return level(root,key2,0)==level(root,key1,0);
    }
    int count_nodes(Node root){
        int node_count=0;
        Stack<Node> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()){
            root=stk.pop();
            node_count++;
            if(root.left!=null)
                stk.push(root.left);
            if(root.right!=null)
                stk.push(root.right);
        }
        return node_count;
    }
    Node deletion(Node node,int key){
//
        if (node == null) {
            return node;
        }
        else {
            if(key== node.data){
                if(node.left!=null&&node.right!=null){
                    Node succ= inorder_successor(node);
                    copy(node,succ);
                    node.right=deletion(node.right,succ.data);
                }
                else
                    node= getChildNode(node);
            }
            else if(key< node.data){
                node.left= deletion(node.left,key);
            }
            else {
                node.right= deletion(node.right,key);
            }
            return node;
        }
    }
    Node getChildNode(Node node){
        if(node.left!=null){
            return node.left;
        }
        if(node.right!=null){
            return node.right;
        }
        else
            return null;
    }
    Node copy(Node node,Node succ){
        node.data=succ.data;
        return node;
    }
    Node inorder_successor(Node node){
        Node curr= node.right;
        while (curr.left!=null){
            curr= curr.left;
        }
        return curr;
    }

    Node getchild(Node node){
        if(node.left!=null)
            return node.left;
        if(node.right!=null)
            return node.right;
        else return null;
    }
    Node successor(Node node){
        node=node.right;
        while (node.left!=null)
            node=node.left;

        return node;
    }
    Queue<Node> q = new LinkedList<>();

    Node level_order_insertion(){

        System.out.println("Enter value: ");
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        Node temp = root;

        while (x!=-1){
            Node newnode = new Node(x);
            q.add(newnode);
            if(root==null){
                root=q.remove();
                 temp=root;}
            else if(temp.left==null)
                temp.left=newnode;
            else if(temp.right==null)
                temp.right=newnode;
            if (temp.right != null &&temp.left != null)
                temp=q.remove();
            System.out.println("Enter value: ");
            x=sc.nextInt();
        }

        return root;
    }


    public static void main(String[] args) {
        binary_search_tree bst = new binary_search_tree();
        binary_tree bt = new binary_tree();
        bst.creation();
        inorder(bst.root);

//        bst.level_order_insertion();
//        bst.bfs(bst.root);
//        System.out.println();
//        bst.deletion(bst.root,30);
//        bst.bfs(bst.root);
//        preorder(bst.root);
//        bst.dfs(bst.root);
//        System.out.println();
//        bst.search(bst.root,115);
//        System.out.println("Parent is: "+bst.parent(bst.root,10));
//        System.out.println("depth is: "+bst.level(bst.root,110,0));
//        System.out.println("Height is: "+bst.height(bst.root,0));
//        System.out.println("level same: "+bst.levelllsame(bst.root,20,60));
//        System.out.println("bn_chkkkkkk:"+bst.binarychk(bst.root));
//        System.out.println("height: "+bst.heightt(bst.root));
//        System.out.println(bst.check_binary(bst.root,false));
//        System.out.println("Same level: "+bst.same_level(bst.root,20,110));
//        System.out.println("Number of node(s): "+bst.count_nodes(bst.root));
//        bst.deletion(bst.root,20);
//        bst.bfs(bst.root);

//        System.out.println("1 for Binary tree\n2 for Binary Search tree:");
//        int x=sc.nextInt();
//        int y;
//        switch (x){
//            case 1:
//                do{
//                System.out.println("Enter 1 for insertion \nEnter 2 for inorder \nEnter 3 for preorder\nEnter 4 for postorder");
//                y= sc.nextInt();
//
//                    switch (y) {
//                        case 1 -> bt.creation();
//                        case 2 -> inorder(binary_tree.root);
//                        case 3 -> preorder(binary_tree.root);
//                        case 4 -> postorder(binary_tree.root);
//                    }
//                }while (y!=-1);
//            case 2:
//                do {
//                    System.out.println("Enter 1 for insertion \nEnter 2 for inorder \nEnter 3 for preorder\nEnter 4 for postorder\nEnter 5 to find parent\nEnter 6 to search\nEnter 7 for breadth first search\nEnter 8 for depth first search");
//                    y = sc.nextInt();
//                    switch (y) {
//                        case 1 -> bst.creation();
//                        case 2 -> inorder(bst.root);
//                        case 3 -> preorder(bst.root);
//                        case 4 -> postorder(bst.root);
//                        case 5 -> {
//                            System.out.println("Enter value to find parent of:");
//                            int ip = sc.nextInt();
//                            System.out.println("Parent is: " + bst.parent(bst.root, ip));
//                        }
//                        case 6 -> {
//                            System.out.println("Enter value to search:");
//                            int z = sc.nextInt();
//                            bst.search(bst.root, z);
//                        }
//                        case 7 -> bst.bfs(bst.root);
//                        case 8 -> bst.dfs(bst.root);
//                    }
//                }while (y!=-1);
//
//        }


    }
}






//    Node BST_DELETE(Node node,int key){
//        if (node == null) {
//            return node;
//        }
//        if(node!=null){
//            if(key== node.value){
//                if(hasLeft(node)&&hasRight(node)){
//                    Node succ= inorder_successor(node);
//                    copy(node,succ);
//                    node.right=BST_DELETE(node.right,succ.value);
//                }
//                else
//                    node= getChildNode(node);
//            }
//            else if(key< node.value){
//                node.left= BST_DELETE(node.left,key);
//            }
//            else if(key> node.value){
//                node.right= BST_DELETE(node.right,key);
//            }
//            return node;
//        }
//        return null;
//    }
//    Node getChildNode(Node node){
//        if(hasLeft(node)){
//            return node.left;
//        }
//        if(hasRight(node)){
//            return node.right;
//        }
//        else
//            return null;
//    }
//    Node copy(Node node,Node succ){
//        node.value=succ.value;
//        return node;
//    }
//    Node inorder_successor(Node node){
//        Node curr= node.right;
//        while (curr.left!=null){
//            curr= curr.left;
//        }
//        return curr;
//    }