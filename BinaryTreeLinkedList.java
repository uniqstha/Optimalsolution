
import java.util.Scanner;

public class BinaryTreeLinkedList {

    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String data){
            this.data = data;
            this. left = null;
            this.right = null;
        }
    }


    public void printGraph(Node node){

        Node leftChild = node.left;
        Node rightChild = node.right;

        if(node == null|| leftChild == null || rightChild == null){
            return;
        }

        System.out.println(node.data + " : " + leftChild.data + " , " + rightChild.data);

        printGraph(leftChild);
        printGraph(rightChild);

    }



    public Node insertNode(String data){

        Node rootNode = new Node(data);
        System.out.println("Root Node " + data + " made.");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nInsert left node: ");
        String left = sc.next();

        rootNode.left = new Node(left);



        Scanner sc1 = new Scanner(System.in);
        System.out.print("Insert right node: ");
        String right = sc1.next();

        rootNode.right = new Node(right);

        Node leftChild = rootNode.left;
        Node rightChild = rootNode.right;

        return rootNode;

    }



    public static void main(String[] args) {
        Node rootNode = new Node("A");
        Node b = rootNode.left = new Node("B"); 
        Node c = rootNode.right = new Node("C"); 
        
        b.left = new Node("D");
        b.right = new Node("E");
        
        c.left = new Node("F");
        c.right = new Node("G");
        
        BinaryTreeLinkedList obj = new BinaryTreeLinkedList();
        obj.printGraph(rootNode);

        System.out.println();
        Node head = obj.insertNode("A");
        obj.printGraph(head);
    }

}