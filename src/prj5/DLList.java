package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This provides implementation for some of the LList methods.
 * @author Brendan Kelly bmkelly    
 * @version 4.18.2017
 * @param <E> is a generic type so we can store what we 
 * like in this linked list
 */
public class DLList<E> {


    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }

    /**
     * How many nodes are in the list
     */
    private int size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> tail;


    /**
     * Create a new DLList object.
     */
    public DLList() {
        init();
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init() {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear() {
        init();
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj) {
        return lastIndexOf(obj) != -1;
    }
    
    /**
     * sorts the linked list by Artist of song
     */
    public DLList<Song> sortArtist()
    {
        
        for (Node<E> begin = head.next(); begin.next() != tail; 
                begin = begin.next())
        {
            Node<E> small = begin;
            for (Node<E> check = begin.next(); check != tail; 
                    check = check.next())
            {
                Song smallData = (Song)small.getData();
                Song checkData = (Song)check.getData();
                if (checkData.getArtist()
                        .compareTo(smallData.getArtist()) < 0)
                {
                    small = check;
                }
            }
            swap(small, begin);
            begin = small;
        }
        
        return (DLList<Song>)this;
    }
    
    /**
     * sorts the linked list by title of song
     * @return 
     */
    public DLList<Song> sortTitle()
    {
        
        for (Node<E> begin = head.next(); begin.next() != tail; 
                begin = begin.next())
        {
            Node<E> small = begin;
            for (Node<E> check = begin.next(); check != tail; 
                    check = check.next())
            {
                Song smallData = (Song)small.getData();
                Song checkData = (Song)check.getData();
                if (checkData.getTitle()
                        .compareTo(smallData.getTitle()) <= 0)
                {
                    small = check;
                }
            }
            swap(small, begin);
            begin = small;
        }
        return (DLList<Song>)this;
    }
    
    /**
     * sorts linked list by genre of song
     * @return 
     */
    public DLList<Song> sortGenre()
    {
        
        for (Node<E> begin = head.next(); begin.next() != tail; 
                begin = begin.next())
        {
            Node<E> small = begin;
            for (Node<E> check = begin.next(); check != tail; 
                    check = check.next())
            {
                Song smallData = (Song)small.getData();
                Song checkData = (Song)check.getData();
                if (checkData.getGenre()
                        .compareTo(smallData.getGenre()) <= 0)
                {
                    small = check;
                }
            }
            swap(small, begin);
            begin = small;
        }
        return (DLList<Song>)this;
    }
    
    /**
     * sorts linked list by year of song
     * @return 
     */
    public DLList<Song> sortYear()
    {
       
        for (Node<E> begin = head.next(); begin.next() != tail; 
                begin = begin.next())
        {
            Node<E> small = begin;
            for (Node<E> check = begin.next(); check != tail; 
                    check = check.next())
            {
                Song smallData = (Song)small.getData();
                Song checkData = (Song)check.getData();
                if (checkData.getYear() <= smallData.getYear())
                {
                    small = check;
                }
            }
            swap(small, begin);
            begin = small;
        }
        return (DLList<Song>)this;
    }
    
    /**
     * Swaps two nodes
     * @param node1 node currently in front
     * @param node2 node currently behind node1
     */
    public void swap(Node<E> node1, Node<E> node2)
    {
        
        if (node1.previous() == node2) {
            Node<E> temp = node2;
            node2 = node1;
            node1 = temp;
        }

        Node<E> node1Prev = node1.previous();
        Node<E> node1Next = node1.next();
        Node<E> node2Prev = node2.previous();
        Node<E> node2Next = node2.next();
        
        node1.setNext(node2Next);
        if (node2Next != null) {
            node2Next.setPrevious(node1);
        }

        node2.setPrevious(node1Prev);
        if (node1Prev != null) {
            node1Prev.setNext(node2);
        }

        if (node1 == node2Prev) {
            node1.setPrevious(node2);
            node2.setNext(node1);
        } 
        else 
        {
            node1.setPrevious(node2Prev);
            if (node2Prev != null) {
                node2Prev.setNext(node1);
            }

            node2.setNext(node1Next);
            if (node1Next != null) {
                node1Next.setPrevious(node2);
            }
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry) {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj) {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--) {
            if (current.getData().equals(obj)) {
                return i;
            }
            current = current.previous();
        }
        return -1; // if we do not find it
    }


    /**
     * Removes the element at the specified index from the list
     *
     * @param index
     *            where the object is located
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     * @return true if successful
     */
    public boolean remove(int index) {
        Node<E> nodeToBeRemoved = getNodeAtIndex(index);
        nodeToBeRemoved.previous().setNext(nodeToBeRemoved.next());
        nodeToBeRemoved.next().setPrevious(nodeToBeRemoved.previous());
        size--;
        return true;
    }


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj) {
        Node<E> current = head.next();
        while (!current.equals(tail)) {
            if (current.getData().equals(obj)) {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<E> currNode = head.next();
            while (currNode != tail) {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail) {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }
    
    /**
     * Creates an iterator for the DLList
     * @param <A> Honestly not sure
     * @return the iterator that was created
     */
    public <A> Iterator<E> iterator()
    {
        return new DLListIterator<A>();
    }


    private class DLListIterator<A> implements Iterator<E> {

        /**
         * current node
         */
        Node<E> current;


        /**
         * Creates a new DLListIterator
         */
        public DLListIterator() {
            current = head;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return current.next().getData() != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current = current.next();
            E temp = current.getData();
            return temp;
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *             and if the element has already been removed
         */
        @Override
        public void remove() {
            if (current.getData() == null) {
                throw new IllegalStateException("Hey, don't do that");
            }

            size--;
            current.previous().setNext(current.next());
            current.next().setPrevious(current.previous());
        }
    }
}
