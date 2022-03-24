
/**
 * The class Deque implements a double-ended queue with a doubly linked list.
 * The list uses a header and a trailer (dummy) nodes.
 *
 * @author Laura Penza
 */
public class Deque
{

    /**
     * Default constructor. Sets this object as an empty deque.
     *
     */
    public Deque()
    {
        front = new Node();
        back = new Node();
        front.setNext(back);     //The two dummy nodes will be pointing at eachother 
        back.setPrev(front);
        count = 0;              //The counter is 0, the deque is empty
    }

    /**
     * Adds new element to the back end of the deque. The method takes O(1)
     * time.
     * 
     * A new node is created and it's information is set. The new node will set
     * it's Previous pointer to backs previous node. It will then set
     * it's Next pointer towards the back dummy node. Lastly, it will have the
     * node previous to back, now point to the new node and set back's previous 
     * pointer also set to point to the new node.
     *
     * @param x new element to be added to the deque.
     */
    public void addToBack(int x)
    {
        Node p = new Node();            //The new Node (p) that will be added
        
        p.setInfo(x);                   //Setting the information in p
        p.setPrev(back.getPrev());      //p will point to back's previous Node
        p.setNext(back);                //p's next pointer will point to back 
        back.getPrev().setNext(p);      //back next points to the new Node (p)
        back.setPrev(p);                //backs previous pointer points to p
     
        count++;            //Increment as there's a new element now
    }

    /**
     * Adds new element to the front end of the deque. The method takes O(1)
     * time.
     * 
     * A new node is created and it's information is set. The new node will set
     * it's Next pointer to the Node after front. It will then set
     * it's Previous pointer to the front dummy node. Lastly, it will have the 
     * next node after front point to the new Node and then front point to the 
     * new Node.
     *
     * @param x new element to be added to the deque.
     */
    
   public void addToFront(int x)
    {   
        Node p = new Node();            //New noded being added
        
        p.setInfo(x);                   //Set new nodes information
        p.setNext(front.getNext());     //p will point to the node after front
        p.setPrev(front);               //p's previous pointer will point to front
        front.getNext().setPrev(p);     //the node after front now points to p
        front.setNext(p);               //front sets its next pointer pointing to p
      
        count++;            //Increment 
    }
    

    /**
     * Retrieves element on the back end of the deque. The method takes O(1)
     * time.
     * 
     * The checked Node is a temp because it will destroy the integrity of the 
     * List if it was not included and instead used back = back.getPrev();
     * 
     * It will call the DequeItem method in the DequeueItem.java class
     * and send the needed parameters if the Deque is not empty. Goes the same
     * for the getFront() method.
     *
     * @return operation is successful: valid = true and item = element on the
     * back end; operation is unsuccessful (i.e. empty deque): valid = false and
     * item = dummy value
     */
    public DequeItem getBack()
    {
        if(!isEmpty())
        { 
           Node temp = back.getPrev();
           return new DequeItem(true, temp.getInfo());      
        }
        else
        {
            return new DequeItem();             //It's an empty deque
        }
    }

    /**
     * Retrieves element on the front end of the deque. The method takes O(1)
     * time.
     * 
     * The checked Node is a temp because it will destroy the integrity of the 
     * List if it was not included and instead used front = front.getNext();
     *
     * @return operation is successful: valid = true and item = element on the
     * front end; operation is unsuccessful (i.e. empty deque): valid = false and
     * item = dummy value
     */
    public DequeItem getFront()
    {
        if(!isEmpty())
        {
            Node temp = front.getNext();
            return new DequeItem(true, temp.getInfo()); 
        }
        else
        {
             return new DequeItem();
        }
    }

    /**
     * Determines if deque is empty. The method takes O(1) time.
     * 
     * Credit: Professor Hernandez Stack ADT and the Queue ADT PPTs.
     *
     * @return true if deque contains no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * Removes element on the back end of the deque. The method takes O(1) time.
     * 
     * Credit: Professor Hernandez List ADT and Linked Lists PPTs.
     * Specifically slide 17.
     * 
     * This will create a temp Node that will allow back to move over the Node
     * so that it's not being pointed to and allow it to be "removed."
     *
     * @return false if removal cannot be performed (i.e. the deque is empty),
     * true otherwise
     */
    public boolean removeBack()
    {
        
        if(!isEmpty())
        {
            Node temp = back.getPrev();  //temp node will point to the one before back
            back = temp.getPrev();       //back points to the one before temp (jump over)
            back = temp;                  //back is going to take temps position now
           
            count --;                    //Decrement
            return true;                 //List is not empty, return true
        }
       
        return false;               //Otherwise, false
    }

    /**
     * Removes element on the front end of the deque. The method takes O(1)
     * time.
     * 
     * Credit: Professor Hernandez List ADT and Linked Lists PPTs.
     * Specifically slide 17.
     * 
     * This will create a temp Node that will allow front to move over the Node
     * so that it's not being pointed to and allow it to be "removed."
     *
     * @return false if removal cannot be performed (i.e. the deque is empty),
     * true otherwise
     */
    public boolean removeFront()
    {
        
        if(!isEmpty())
        {
            Node temp = front.getNext(); //temp points to the Node after front
            front = temp.getNext();      //front points to the one after temp (jump over)
            front = temp;               //front is going to take temps position
        
            count --;               //Decrement count as there's one less element now
            return true;            //boolean method, return true if !isEmpty
        }
       
        return false;       //return false if it is empty
    }

    /**
     * Constructs a String description of the deque.
     *
     * @return String containing the deque elements.
     */
    public String toString()
    {
        String str = "";

        Node current = front.getNext();
        for (int i = 0; i < count - 1; i++)
        {
            str += current.getInfo() + ", ";
            current = current.getNext();
        }

        if (count != 0)
            return "Deque: [" + str + back.getPrev().getInfo() + "]";
        else
            return "Deque: []";
    }

    private int count;  //number of elements in the deque
    private Node back;  //points to the item in the back
    private Node front; //points to the item in the front
}
