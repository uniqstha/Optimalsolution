public class AVLTree {
    public static class Node{
        Node left;
        Node right;
        int height;
        int data;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
            this.height=1;

        }
        
    }
    int getHeight(Node node){
        if(node==null){
            return 0;
        }
        return node.height;

    }
    int getBalancingFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    Node rightRotate(Node y){
        Node x=y.left;
        Node T2=y.right;
        y.left=T2;
        x.right=y;
        x.height=Math.max(getHeight(x.left), getHeight(x.right)+1);
        y.height=Math.max(getHeight(x.left), getHeight(x.right)+1);
        return x;

    }
    Node leftRotate(Node x){
        Node y=x.right;
        Node T2=x.left;
        y.left=x;
        x.right=T2;
        x.height=Math.max(getHeight(x.left), getHeight(x.right)+1);
        y.height=Math.max(getHeight(x.left), getHeight(x.right)+1);
        return y;

    }
    public Node createBST(int data, Node rootnode){
        if(rootnode==null){
            return new Node(data);
        }
        if(data<rootnode.data){
            rootnode.left=createBST(data, rootnode.left);
        }
        else if(data>rootnode.data){
            rootnode.right=createBST(data, rootnode.right);
        }
        else{
            return rootnode;
        }
    
        rootnode.height=Math.max(getHeight(rootnode.left), getHeight(rootnode.right)+1);
        int getBalancingFactor=getBalancingFactor(rootnode);
    }


}

