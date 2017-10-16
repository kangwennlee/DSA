package ADT;

/**
 *
 * @author kangw
 * @param <T>
 */
public class SortedLinkList<T extends Comparable<? super T>> implements SortedListInterface<T> {

    private Node firstNode; //first node in the list
    private int length; //total number of entries in the list

    public SortedLinkList() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean add(T newEntry) {
        firstNode = add(newEntry, firstNode);
        length++;
        return true;
    }
    
    //add newEntry according to sequences, from lower values to higher values
    private Node add(T newEntry, Node currNode) {
        /*if end of list or newEntry has lower value than currNode, 
        then the newEntry is added before the currNode
        */
        if ((currNode == null) || newEntry.compareTo((T) currNode.getData()) <= 0) {
            currNode = new Node(newEntry, currNode);
        } 
        //if newEntry has higher value than currNode, then continue to traverse through the list
        else {
            Node nodeAfter = add(newEntry, currNode.getNext());
            currNode.setNext(nodeAfter);
        }
        return currNode;
    }

    /* the entry will first pass to the getPosition() to retrieve the position of the entry
       it will then be removed through the remove(givenPosition) function and return true
       if the list is empty, then the getPosition will return -1 which is a null node, 
       since the entry does not match with the null node, it will return false*/
    @Override
    public boolean remove(T anEntry) {
        return anEntry == remove(getPosition(anEntry));
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        
        // if the givenPosition to be removed is in valid range 
        if ((givenPosition >= 1) && (givenPosition <= length)) {
            // CASE 1: if the position is pointing to the first entry, the data of the first entry will be returned
            // update the firstNode to be pointing to the next node
            if (givenPosition == 1) {      	
                result = (T) firstNode.getData();     	
                firstNode = firstNode.getNext();		
            } 
            /*CASE 2: if position pointing to middle or last node, 
            traverse through the list till the node before the desired node, 
            and point this nodeBefore to the node after the desired node,
            */
            else {                                                    
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.getNext();
                }
                result = (T) nodeBefore.getNext().getData();  		
                nodeBefore.setNext(nodeBefore.getNext().getNext());
            } 															// one to be deleted (to disconnect node from chain)
            //for successful removal, the size of the list will be decreased
            length--;
        }

        return result;
    }
    
    /*get the position of the entry in the list
    by traversing the list from the first node until the desired node, retrieve and remove the particular position
    if the entry is not found in the list, position of -1 is returned
    */
    @Override
    public int getPosition(T anEntry) {
        Node currNode = firstNode;
        int position = -1;
        for (int i = 1; i <= length; i++) {
            if (currNode.getData().equals(anEntry)) {
                position = i;
                break;
            }
            if(i==length && !currNode.getData().equals(anEntry))
                break;
            currNode = currNode.getNext();
        }
        return position;
    }

    /*retrieve the entry from the list at the given position
    it first make sure that the givenPosition is between the valided range(from 1 to length of list)
    then it will traverse the list by from the first node until the desired node, 
    retrieve and return the data of the desired node
    */
    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.getNext();		// advance currentNode to next node
            }
            result = (T) currentNode.getData();	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    /*check whether the entry exist in the list or not,
    by traserving the list and compare each node in the list with the entry,
    it will iterate until the entry is found, and return true
    or it will return false if it reaches the end of the list without the entry found
    */
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node tempNode = firstNode;
        int pos = 1;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo((T) tempNode.getData()) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.getNext();
                pos++;
            }
        }
        return tempNode != null && tempNode.getData().equals(anEntry);
    }

    //remove all current entries from the list, update the firstNode to null, and length of list to 0 
    @Override
    public final void clear() {
        firstNode = null;
        length = 0;
    }
    
    //retrieve the total number of entries from the list
    @Override
    public int getLength() {
        return length;
    }
    
    //check if the list is empty by checking the total number of entries in the list
    @Override
    public boolean isEmpty() {
        return (length == 0);
    }
}
