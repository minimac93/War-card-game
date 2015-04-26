// adapted from QueueReferenceBased from Assignment 9

/** class that implements a queue (first in, first out) structure */
public class Queue implements QueueInterface{
    private Node lastNode;

    /** default constructor initializes empty queue */
    public Queue() {
        lastNode = null;
    }

    /**
        copy constructor creates copy of parameter queue
        @param otherQueue Queue to be copied
    */
    public Queue(Queue otherQueue) {
        lastNode = Queue.copy(otherQueue);
    }

    /** Determines whether a queue is empty.
        @return true if the queue is empty; otherwise returns false.
    */
    public boolean isEmpty() {
        return lastNode == null;
    }

    /** Removes all items of a queue. */
    public void dequeueAll() {
        lastNode = null;
    }

    /** Adds an item at the back of a queue.
        @param newItem is the item to be inserted.
    */
    public void enqueue(Object newItem) {
        Node newNode = new Node(newItem);

        // insert the new node
        if (isEmpty())
            // insertion into empty queue
            newNode.setNext(newNode);
        else {
            // insertion into nonempty queue
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
        }

        lastNode = newNode; // new node is at back
 }

    /** Retrieves and removes the front of a queue.
        @return Item that was added to the queue earliest
        @throws QueueException if the operation is impossible
    */
    public Object dequeue() throws QueueException {
        if (!isEmpty()) {
            // queue is not empty; remove front
            Node firstNode = lastNode.getNext();
            if (firstNode == lastNode)  // special case?
                lastNode = null;        // yes, one node in queue
            else
                lastNode.setNext(firstNode.getNext());
            return firstNode.getItem();
        }
        else throw new QueueException("QueueException on dequeue: queue empty");
    }

    /** Retrieves the item at the front of a queue.
        @return item at front of queue (do not remove)
        @throws QueueException if the operation is impossible
    */
    public Object peek() throws QueueException {
        if (!isEmpty())
            return lastNode.getNext().getItem();
        else throw new QueueException("QueueException on peek: queue empty");
    }

    // public Object peek(int n) throws QueueException {
    //     if (n <= size()) {
    //
    //     } else throw new QueueException("QueueException on peek: index not found");
    // }

    /**
        determines and returns size of the queue
        @return number of elements in the queue
    */
    public int size() {
        int size = 0;

        // if the lastNode is not empty
        if (lastNode != null) {
            Node curr = lastNode;
            // loop while the current node is not lastNode (hasn't circled back yet)
            do {
                size++;
                curr = curr.getNext();
            } while (curr != lastNode);
        }

        return size;
    }

    /**
        copies one Queue to another
        @return Node that acts as head of Queue copy
    */
    private static Node copy(Queue otherQueue) {
        // set new "head" to have same item as otherQueue's lastNode
        Node last = new Node(otherQueue.lastNode.getItem());

        // current for copy list is "head", current for original list is its "head"
        Node curr = last;
        Node otherCurr = otherQueue.lastNode;

        // loop for size - 1 times
        for (int n = 1; n < otherQueue.size(); n++) {
            // set current node's link to new node with next item
            curr.setNext(new Node(otherCurr.getNext().getItem()));
            // move curr and otherCurr to the next Node
            curr = curr.getNext();
            otherCurr = otherCurr.getNext();
        }

        // link the final node in the chain to the first, creating the loop
        curr.setNext(last);

        // return the future lastNode
        return last;
    }

}
