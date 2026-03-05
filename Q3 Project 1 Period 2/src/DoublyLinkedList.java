public class DoublyLinkedList {

    protected Node head;
    protected Node tail;
    protected int size;

    /**
     * Constructs an empty DoublyLinkedList.
     * The list should initialize with head = null, tail = null,
     * and size = 0. No exceptions should be thrown.
     */
    public DoublyLinkedList() {
    		
    }

    /**
     * Returns the number of elements currently stored in the list.
     * Should return 0 when the list is empty.
     * Must accurately reflect additions and removals.
     */
    public int size() {
        return -1;
    }

    /**
     * Appends the given node to the end of the list.
     * Must correctly update:
     * - tail reference
     * - head reference if list was empty
     * - next and prev links
     * - size
     */
    public void add(Node n) {

    }

    /**
     * Inserts the given node at the specified index.
     * Valid index values are from 0 to size inclusive.
     * If index is invalid, the list should not change.
     * Must correctly adjust next and prev references,
     * update head or tail if necessary, and increment size.
     */
    public void add(int index, Node n) {
        
    }

    /**
     * Returns the node located at the specified index.
     * Valid index values are from 0 to size - 1.
     * Returns null if the index is invalid.
     */
    public Node get(int index) {
        return null;
    }

    /**
     * Removes and returns the node at the specified index.
     * Valid index values are from 0 to size - 1.
     * Returns null if the index is invalid.
     * Must correctly relink surrounding nodes,
     * update head or tail if necessary,
     * and decrement size.
     */
    public Node remove(int index) {
        return null;
    }

    /**
     * Returns a string representation of the list in the format:
     * [elem1, elem2, elem3]
     * Elements must appear in correct order from head to tail.
     */
    public String toString() {
        return "";
    }
}
class Node<T>{
    private T data;
    Node next; //null if no next Node
    Node prev; //null if no previous Node
    
    public Node(T t) {
        data = t;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T t) {
        data = t;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node n){
        next = n;
    }
}