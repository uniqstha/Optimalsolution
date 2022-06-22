public class StackExample {
    char stk[];
    int top=-1;
    int size;
    StackExample(int size){
        this.size=size;
        stk=new char[size];
        

    }
    public boolean push(char data){
        if(isFull()){
            System.out.println("Stack Overflow");
            return false;
        }
        // top=top+1;
        // stk[top]=data;
        // return true;

        stk[++top]=data;
        return true;
    }
    public char pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return 'F';
        }
        // int x=top;
        // top--;
        // return stk[x];

        return stk[top--];
    }
    public int size(){
        return top +1;
    }
    public boolean isFull(){
        // if (top==size-1){
        //     return true;
        // }
        // return false;

        return top==size-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public static void main(String[] args) {
        
    }
}
