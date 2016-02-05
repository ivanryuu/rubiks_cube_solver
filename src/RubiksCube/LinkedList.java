/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RubiksCube;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Ivan
 */
public class LinkedList<Item> implements Iterable<Item> {

    private int N;
    private int index;
    private Node first; 
    private Node last;
    private Node current;
    
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }
    
    public LinkedList(){
        first = null;
        last = null;
        current = null;
        N = 0;
        index = -1;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return N;
    }
    
    public int index(){
        return index;
    }
    
    public Item peek() {
        if(isEmpty()) throw new NoSuchElementException("Underflow.");
        return first.item;
    }
    
    public void add(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldlast;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    
    public Item remove(){
        if(isEmpty()) throw new NoSuchElementException("Underflow.");
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }
    
    public Item next(){
        Item item = current.item;
        current = current.next;
        index++;
        return item;
    }
    
    public Item current(){
        return current.item;
    }
    
    public Item previousPeek(){
        if(EOL())
            return current.previous.item;
        else return last.item;
    }
    
    public Item previous(){
        current = current.previous;
        Item item = current.item;
        index--;
        return item;
    }
    
    public Item start(){
        index = 0;
        current = first;
        return current.item;
    }
    
    public Item end(){
        index = N-1;
        current = last;
        return current.item;
    }
    
    public boolean EOL(){
        return index < N;
    }
    
    public boolean SOL(){
        return index >= 0;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item> {
        
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
        
        public Item previous() {
            if(!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            return current.item;
        }

        @Override
        public void remove() {
            //not supported
        }
        
    }
    
}
