package pkg24point;

import java.util.Objects;

public class Person {
    protected String name;
    /**
     * default constrcutor
     */
    public Person(){
     name ="";
}
    /**
     * @param name String
     */
    public Person(String name){
        this.name = name ;
    }
    /**
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * @param name String name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }
    /**
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    /**
     * 
     * @param obj a person
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}

