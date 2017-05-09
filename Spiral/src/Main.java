public class Main{
    public static void main(String args[]){

        LinkedList L = new LinkedList();

        L.PrintList();
        L.addNodeAtHead(10);
        //L.PrintList();
        L.addNodeAtHead(20);
        //L.PrintList();
        //L.deleteFirstNodeWithValue(10);

       // for(int i=0;i<10;++i){
        //    L.addNodeAtHead(i);
        //}
        //L.PrintList();
        //L.deleteFirstNodeWithValue(10);
        //L.PrintList();
        L.addNodeAtEnd(12);
        L.PrintList();
        L.ShowCounter();

    }
}

