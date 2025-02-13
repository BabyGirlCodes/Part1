package utils;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {

    private String[] data;
    private int size;
    private final static int RESIZE_Factor = 2;
    public DynamicArrayList(){
        this(10);
    }
    public DynamicArrayList(int startSize){
        if(startSize <= 0){
            throw new IllegalArgumentException("Internal array size cannot be less than 1");
        }
        data = new String[startSize];
    }



    /**
     * @return the number of element in the array
     */
    public int size(){
        return size;
    }
    public String set(String value, int pos){
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Position" + pos + " is out of bounds. Valid range: 0 to " + (size - 1));
        }

        String firstValue = data[pos]; // Store the original element
        data[pos] = value; // Replace with the new element (doesn't matter if null)
        return firstValue;
    }

    /**
     * @return true/false if the array is empty
     */
    public boolean isEmpty(){
        return  size == 0;
    }

    /**
     * @param pos Takes in the position of the data to be found
     * @return the value found in the array
     */
    public String get(int pos){
        if (isEmpty()|| pos < 0 ||pos > size){
            throw new IndexOutOfBoundsException("Position is out of the required size. " +
                    "Position should be in between 0 and " + size);
        }
        return data[pos];
    }

    /**
     * @param value The position
     * @return
     */
    public int indexOf(String value){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)){
                return i;
            }
        }
        return -1;

    }
    private void grow(){

        String [] newArray = new String[data.length * RESIZE_Factor];
        System.arraycopy(data, 0, newArray, size,0 );
        data = newArray;
    }
    public boolean add(String value) {
        if (size == data.length){
            grow();
        }
        data[size] = value;
        size++;
        return true;
    }
    public boolean removeAll(String value){
        if (value == null){
            throw new IllegalArgumentException("value put in the array cannot be null");
        }
        int count= 0;
        int newSize = size;
        String [] newArray = new String[data.length];
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(value)){
                newArray[i] = data[i];
                count++;
            }
        }
        size = count;
        return size!= newSize;

    }
    public int lastIndexOf (String value){
        if (value == null){
            throw  new IllegalArgumentException("Value to be searched cannot be null");

        }
        for (int i = size -1; i >= 0 ; i--) {
           if (data[i]!= null && data[i].equals(value)){
               return i;
           }
        }
        return -1;
    }

}

