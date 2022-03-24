
/**
 * Implements the node of a doubly linked list of integers.
 * 
 * Credit: Professor Hernandez COP3530 slides - List ADT and Linked Lists
 * Specifically slides 7-8.
 *
 * @author Laura Penza
 */
public class Node
{

    private int info;
    private Node next;
    private Node prev;

    public Node()
    {
        info = 0;
        next = null;
        prev = null;
    }

    public int getInfo()
    {
        return info;  
    }

    public Node getNext()
    {
        return next;    
    }

    public Node getPrev()
    {
        return prev;   
    }

    public void setInfo(int i)
    {
        info = i;
    }

    public void setNext(Node n)
    {
        next = n;
    }

    public void setPrev(Node p)
    {
        prev = p;
    }

}
