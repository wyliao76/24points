
package pkg24point;

import java.util.ArrayList;

public class GenericStack <E>{
    /**
     * 
     */
    private final ArrayList <E> list = new ArrayList<>();
    /**
     * @return int
     */
    public int getSize(){
        return list.size();
    }
    /**
     * @return boolean
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    /**
     * @return String
     */
    @Override
    public String toString(){
        return "Stack: " + list.toString();
    }
    /**
     * @return E
     */
    public E peek(){
        return list.get(getSize()-1);
    }
    /**
     * @param object an object
     */
    public void push(E object){
        list.add(object);
    }
    /**
     * @return E
     */
    public E pop(){
        E object = list.get(getSize()-1);
        list.remove(getSize()-1);
        return object;
    }
    
}
