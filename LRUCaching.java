import java.util.HashMap;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class LRUCaching{
    HashMap<Integer,Node>map;
    int capacity;
    public static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node (int key,int value){
            this.key=key;
            this.value=value;
            this.next=null;
            this.prev=null;
        } 
    }
    LRUCaching(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
    }
    public void put(int key, int value){
       if( map.containsKey(key)){
           remove(map.get(key));

        }
        else if  (map.size()==capacity){
            remove( tail );

        }
        Node newnode=new Node(key, value);
        insert(newnode);
    }
    Node head=null;
    Node tail=null;
    public void insert(Node node){
        map.put(node.key, node);
        if(head==null){
            head=tail=node;
        }
        else{
            head.prev=node;
            node.next=head;
            head=node;
        }

    }
    public int get(int key){
        Node node =map.get(key);
        if (node==null){
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }
    public void remove(Node node){
        map.remove(node.key);
        if (node==head){
            head.next.prev=null;
            head=head.next;
            node.next=null;
        }
        else if(node==tail){
            tail.prev.next=null;
            tail=tail.prev;
            node.prev=null;

        }
        else{
            node.prev.next=node.next;
            node.next.prev=node.prev;
            node.next=null;
            node.prev=null;
    
        }
    }
    public void print(){
        Node current=head;
        while (current!= null){
            System.out.println(current.key +" "+current.value);
            current=current.next;
        }
    }

    public static void main(String[] args) {
        LRUCaching obj=new LRUCaching(3);
        obj.put(1, 10);
        obj.put(2,20);
        obj.put(3,30);
        obj.print();
        obj.put(4, 40);
        System.out.println("------------------");
        obj.print();

    }
}