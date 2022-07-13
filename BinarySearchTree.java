public class BinarySearchTree{
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    public Node createBST(int data, Node rootnode){
        if(rootnode==null){
            return new Node(data);
        }
        if(data<rootnode.data){
            return rootnode.left=createBST(data,rootnode.left);
        }
        else{
            return rootnode.right=createBST(data, rootnode.right);
        }
    }
}

