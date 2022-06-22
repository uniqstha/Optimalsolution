public class CircularQueueExample {
    int front=-1;
    int rear=-1;
    int queeue[];
    int size;
    CircularQueueExample(int size){
        this.size=size;
        queeue=new int[size];
    }
    public boolean enqueue(int data){
        if(isFull()){
            System.out.println("Queue Overflow");
            return false;
        }
        if(front==-1){
            front=0;
        }
        rear=(rear+1)%size;
        queeue[rear]=data;
        return true;
    }
    public boolean isFull(){
        return(rear+1)%size==front;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue Underflow");
            return -9999;
        }
        int x=front;
        if(front==rear){
            front=rear=-1;
        }
        if(front!=rear){
            front=(front+1)%size;
        }
        return queeue[x];

    }
    public boolean isEmpty(){
        return front==-1;
    }

    public static void main(String[] args) {
        CircularQueueExample obj=new CircularQueueExample(5);
        obj.enqueue(100);
        obj.enqueue(200);
        System.out.println(obj.dequeue());
        System.out.println(obj.dequeue());
    }
}

