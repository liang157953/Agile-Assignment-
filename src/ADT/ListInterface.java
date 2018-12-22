package ADT;

public interface ListInterface<T> {
    
    // To check whether the newEntry is added successfully or not
    public boolean add(T newEntry); 

    // To remove the object at the givenPosition
    public T remove(int givenPosition); 

    // To replace the previous object at the givenPosition with newEntry
    public boolean set(int givenPosition, T newEntry); 

    // To get the object at the givenPosition
    public T get(int givenPosition); 
    
    // To know the total number of the list
    public int size(); 
    
    // Determines whether the list is empty
    public boolean isEmpty(); 

    // Use to print format
    public String toString(); 

    //To remove all data in the list
    public void clear(); 
}

