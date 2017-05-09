import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Node{
    public int value;//This denotes the value stored in the node
    public Node next;//This is a reference to the next node in the linked list
    
    public Node(){
        next = null;
    }
}

public class LinkedList{
    public Node head;
    public int size;
    
    public LinkedList(){
        head = null;
        size = 0;
    }
    
    //This method adds a node with value n at the head of the list
    public void addNodeAtHead(int n){
        
        Node N = new Node();
        N.value = n;
        N.next = head;
        head = N;
        size++;
    }
    
    
    
    
    //This method adds a node with value n at the end of the list.
    public void addNodeAtEnd(int n){
        //Fill in the details of this method
        Node N = new Node();
        N.value = n;
        Node q = head;
        while(q.next != null){
            q = q.next;
        }
        q.next = N;
        size++;
    }

    
    
    
    //This method should delete the given node N
    //in case such a node exists
    public void deleteNode(Node N){
        if(size==0)return;
        if(head == N){head = head.next; size--; return;}
        
        Node p1 = head;
        Node p2 = head.next;
        while(p2 != null){
            if(p2 == N){
                p1.next = p2.next;
                size--;
                return;
            }
            p1 = p2;
            p2 = p2.next;
        }
    }
    
    
    
    
    //This method deletes first node with value n
    //It does not change the list if n is not present
    public void deleteFirstNodeWithValue(int n){
        
        if(size == 0)return;
        if(head.value == n){head = head.next;size--; return;}
        
        Node p1 = head;
        Node p2 = head.next;
        while(p2 != null){
            if(p2.value == n){
                p1.next = p2.next;
                size--;
                return;
            }
            p1 = p2;
            p2 = p2.next;
        }
    }
    
    //This method searches if an integer n is present in the linked list
    //It returns true if the element is present otherwise it returns false
    public boolean SearchList(int n){
        
        if(size == 0)return(false);
        Node p = head;
        
        while(p != null){
            if(p.value == n)return(true);
            p = p.next;
        }
        return(false);
        
    }
    
    
    //This method prints the linked list
    public void PrintList(){
        if(size == 0){System.out.println("Empty"); return;}

        Node p = head;
        while(p != null){
            System.out.print(p.value + "->");
            p = p.next;
        }
        System.out.println("null");
    }
    
    
    
    //This method reverses the linked list

     public void ShowCounter() {
        //Fill in the details of this method
         List output = new ArrayList<>();
        Node p = head;
        while(p != null) {
            System.out.println(p.value);
            output.add(p.value);
            p = p.next;

        }
         //System.out.println(output.get());
         for(int i =(output.size()-1); i >= 0; i--) System.out.print(output.get(i));


     }
}