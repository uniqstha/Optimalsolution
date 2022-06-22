public class DoubleListExample{
    public static class Node {
        Node next;
        Node prev;
        int data;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
        
    }
    Node head= null;
    Node tail=null;
    public void append(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }
    public void insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
        }
        else{
            head.prev=newnode;
            newnode.next=head;
            head=newnode;
        }
    }
    public void Removeatpos(int pos){
        Node current=head;
        for(int i=2; i<=pos;i++){
            current=current.next;
        }
        current.prev.next=current.next;
        current.next.prev=current.prev;
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void print(){
        Node current=head;
        while (current!= null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public static void main(String[] args) {
        DoubleListExample list=new DoubleListExample();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        list.Removeatpos(3);
        list.print();
    }
}