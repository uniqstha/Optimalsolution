public class QueueExample {
    int quees[];
    int front=-1;
    int rear=-1;
    int size;

    QueueExample(int size){
        this.size=size;
        quees=new int[size];

    }
    public boolean enqueue(int data){
        if (isFull()){
            System.out.println("Queue overflow");
            return false;
        }
        if (rear==-1 && front==-1){
            front=0;
        }
        quees[++rear]=data;
        return true;
    }
    public boolean isFull(){
        return rear==size-1;
    }

    public boolean isEmpty(){
        return rear==-1 && front==-1;
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
        if(front<rear){
            front++;
        }
        return quees[x];
        
    }
    public static void main(String[] args) {
        QueueExample a=new QueueExample(5);
        a.enqueue(100);
        a.enqueue(200);
        System.out.println();
    }
}

