class Node{
  public Object element;
  public Node next;

  public Node(Object e, Node n){
    element =e ;
    next = n;
 
  }
 
}
class LinkedListTester{
  public static void main(String [] args){
 
   
    System.out.println("\n/////  Test 11  /////");
    Object [] a7 = {10,20,30,40,50,60,70};
    LinkedList h7 = new LinkedList(a7); // uses the first constructor: LinkedList(Object [] a)
    h7.printList(); // This should print: 10,20,30,40,50,60,70.  
 
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    System.out.println("Removed element: "+ h7.remove(0)); // This should print: Removed element: 10
    h7.printList(); // This should print: 20,30,40,50,60,70.  
    System.out.println("Removed element: "+ h7.remove(3)); // This should print: Removed element: 50
    h7.printList(); // This should print: 20,30,40,60,70.  
    System.out.println("Removed element: "+ h7.remove(4)); // This should print: Removed element: 70
    h7.printList(); // This should print: 20,30,40,60. 
 
 
 
  }
 
}

class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  
 
  public LinkedList(Object [] a){
  head = new Node(a[0],null);
  Node tail= head;
  for (int i=1; i< a.length; i++){
  Node mn= new Node(a[i],null);
  tail.next= mn;
  tail=mn;
  }
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    this.head=h;
    
  }
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    int count=0;
    for(Node n=head; n!=null; n=n.next){
    count++;
    }
    
    // TO DO
    return count; // please remove this line!
  
  }
  
  /* prints the elements in the list */
  public void printList(){
    for(Node n=head; n!=null; n=n.next){
    System.out.print(n.element +" ");
    } 
    System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    int size=countNode();
     int i=0;
      Node n = head;
    if (idx<0 || idx> size){
    return null;
    }
    else{
     
       for( ; n!=null; n=n.next){
         if(i==idx){
         break;
        
         }
         else{
         i++;
         }
      }
       
    }
      
    return n; // please remove this line!
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    int size=countNode();
     int i=0;
      Node n = head;
    if (idx<0 || idx> size){
    return null;
    }
    else{
     
       for( ; n!=null; n=n.next){
         if(i==idx){
         break;
        
         }
         else{
         i++;
         }
      }
       
    }
      
    return n.element;
     // please remove this line!
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
     int size=countNode();
     int i=0;
      Node n = head;
    if (idx<0 || idx> size){
    return null;
    }
    else{
     
       for( ; n!=null; n=n.next){
         if(i==idx){
      break;
        
         }
         else{
         i++;
         }
      }
    Object oe=n.element;
    n.element = elem;
    return oe ; // please remove this line!
  }
  
  }
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    Node n= head;
    int idx =0;
      for( ; n!=null; n=n.next){
      if(n.element.equals(elem)){
      return idx;  
     
      }
      else{
      idx++;
      }
   
    }
    return -1; // please remove this line!
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    Node n= head;
    while(n!= null){
      if(n.element.equals(elem)){
      return true;
      
      }
      else{
      n= n.next;
      }
   
    }
    return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
   Node chead = new Node(head.element,null);
  Node ctail= chead;
  //Node n=chead;
  for (Node n=head.next; n!=null; n=n.next){
  Node mn= new Node(n.element,n.next);
  ctail.next= mn;
  ctail=mn;
  }
    return chead; // please remove this line!
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    Node RH= new Node(head.element,null);
        for(Node n=head.next; n!=null; n=n.next){
    Node mn=new Node(n.element,null);
    mn.next=RH;
    RH=mn;
    }
    return RH; // please remove this line!
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
      int size=countNode();
      Node n = new Node(elem,null);
      if (idx>=0 && idx<=size){
      
      if (idx==0){
      n.next =head;
      head=n;
      }
      else if(idx==size){
      Node tail= head;
      while(tail.next!=null){
      tail=tail.next;
      }
      tail.next=n;
      tail = n;
      }
      else{
      Node h= head;
      for(int i=0;i<idx-1;i++){
      h=h.next;
      }
      Node t=h.next;
      n.next=t;
      h.next=n;
      }
      }
      
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
      int size=countNode();
     // Object val = null;
      
      if (index>=0 && index<size){
          Object val= head.element;
          if (index==0){
          Node t= head;
          head=head.next;
          t=null;
          return val;
          } 
      else{
          //Object val1=.next.element; 
      Node h= head;
      for(int i=0; i<index-1; i++){
    	h=h.next;
      }
      Node t= h; // updated this line
      Node x=t.next;
      t.next= t.next.next;      // my line
      x.next= null;
      Object val1= x.element;  // changed this line
      t=null;
      return val1; 
      }
      
      }
      return null;
 
  }
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    for(Node n=head ;n!=null ;n=n.next){
      if(n.next==null){
        n.next=head;
        head=head.next;
        n.next.next=null;
        break;
      }
    } 
  }
  
  // Rotates the list to the right by 1 position.
 public void rotateRight(){
    int k=countNode();
    Node tail = new Node (null, null);
    for(Node n= head; n!=null; n=n.next){
     tail=n;
  
    }
    Node x= tail;
    Node y= nodeAt(k-2);
    y.next=null;
    x.next=head;
    head=x;
  }
  
}