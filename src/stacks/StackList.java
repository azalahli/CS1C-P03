package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of an abstact StackList data structure
 * @author Myron Pow 4/29/17
 */

public class StackList<E> implements Iterable<E> {
    /**
     *Private Node class for implementation of abstract StackList
     */
    private class Node{
        Node next;
        E data;

        Node(E input){
            data = input;
        }
    }

    /**
     * Private StackListIterator, which iterates through the stack
     */
    private class StackListIterator implements Iterator<E>{
        protected Node currentTop = top;

        /**
         * hasNext method, as iterator should continue until the stack is empty, only a null pointer would return false
         * @return boolean value of null stack check
         */
        public boolean hasNext(){
            return (currentTop != null);
        }

        /**
         * returns value of top, iterates onto next element of stack
         * @return data of type E, which was encapsulated in top
         */
        public E next(){
            if(hasNext()){
                E data = currentTop.data;
                currentTop = currentTop.next;
                return data;
            }else{
                throw new NoSuchElementException();
            }
        }
    }

    /**
     * Beginning of StackList
     */
    private String name;
    private Node top;

    /**
     * Constructor that sets default values of empty stacklist
     */
    Stacklist(){
        name = "";
        top = null;
    }

    /**
     * generic push, takes data of type E and puts it on top of stack
     * @param input data to be added to top of stack
     */
    public void push(E input){
        if(input == null){
            return;
        }

        Node newTop = new Node(input);
        newTop.next = top;
        top = newTop;
    }

    /**
     * generic pop, takes node from top of stack
     * @return node from top of stack
     */
    public Node pop(){
        if(top == null){
            return null;
        }
        Node popTop = top;
        top = top.next;
        return popTop;

    }

    /**
     * Looks at the data of the top object
     * @return data stored in the top node
     */
    public E peek(){
        if(top == null){
            return null;
        }
        return top.data;
    }

    /**
     * Iterator call to stacklist iterator subclass
     * @return stack action(s)
     */
    public Iterator<E> iterator(){
        return new StackListIterator();
    }


}
