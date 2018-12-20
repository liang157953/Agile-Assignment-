package ADT;

public interface ListInterface<T> {

    public boolean add(T newEntry);// basic concept

    public boolean add(int givenPosition, T newEntry);

    public T remove(int givenPosition); // basic concept

    public boolean set(int givenPosition, T newEntry);

    public T get(int givenPosition);
    
    public int size();

    public boolean isEmpty(); // basic concept

    public String toString(); // use to print format

    public boolean addToLast(T newEntry); // got use

    public boolean addToFirst(T newEntry);// got use

    public void clear();

    public T removeFront(); // got use

    public T removeBack(); // got use
}
