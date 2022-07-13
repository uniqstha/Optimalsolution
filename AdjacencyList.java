public class AdjacencyList {
    LinkedListExample1 a [];
    int vertices;
    AdjacencyList(int vertices){
        this.vertices=vertices;
        a=new LinkedListExample1[vertices];
        for(int i=0;i<vertices;i++){
            a[i]=new LinkedListExample1();
        }
    }
    public void addEdge(int source,int destination){
        a[source].addNode(destination);
        a[destination].addNode(source);
    }

    public void printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.print(i +" is connected to: ");
            for(int j=0;j<a[i].getSize();j++){
                System.out.print(a[i].getDataAtAnyPos(j)+" , ");
            }
            System.out.println(" ");
        }
    }
    public void BFS(int rootnode){
        boolean visited[]=new boolean[vertices];
        QueueExample q=new QueueExample(vertices);
        visited[rootnode]=true;
        q.enqueue(rootnode);
        while(! q.isEmpty()){
            int x=q.dequeue();
            int [] list=getAdjancentNode(x);
            for(int i=0;i<list.length;i++){
                int adjnode=list[i];
                if(!visited[adjnode]){
                    q.enqueue(adjnode);
                    visited[adjnode]=true;

                }
            }
            System.out.println(x);
        }
    }
    public void topoSort(){
        int indegree[]=new int[vertices];
        for(int i=0;i<vertices;i++){
            int[] list=getAdjancentNode(i);
            for(int j=0;j<list.length;j++){
                int adjval=list[j];
                // indegree[adjval]=indegree[adjval]+1;
                indegree[adjval]++;

            }
        }
        QueueExample q=new QueueExample(vertices);
        for(int i=0;i<vertices;i++){
            if(indegree[i]==0){
                q.enqueue(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            count=count+1;
            int x=q.dequeue();
            System.out.println(x);
            int[] list=getAdjancentNode(x);
            for(int i=0;i<list.length;i++){
                int adjval=list[i];
                // indegree[adjval]--;
                if(indegree[adjval]--==0){
                    q.enqueue(adjval);
                }
            }
        }                                                                                                       
    }

    public int [] getAdjancentNode(int i){
        int list[]=new int[a[i].getSize()];
        LinkedListExample1.Node current=a[i].head;
        int index=0;
        while (current!=null){
            list[index++]=current.data;
            current=current.next;
        }
        return list;
    }
    public void DFS(int rootnode, boolean [] visited){
        System.out.println("Traversing in DFS manner");
        // boolean visited[]=new boolean[vertices];
        visited[rootnode]=true;
        System.out.println(rootnode);
        int [] list=getAdjancentNode(rootnode);
        for(int i=0;i<list.length;i++){
            int adjval=list[i];
            if(!visited[adjval]){
                DFS(adjval, visited);
               

            }
        }

    }
    public void depthfirstsearch(int rootnode){
        boolean visited[]=new boolean[vertices];
        DFS(rootnode, visited);
    }
    

    public static void main(String[] args) {
        AdjacencyList g=new AdjacencyList(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        // g.printGraph();
        g.BFS(0);
        

    }

}
