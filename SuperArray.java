public class SuperArray {
  private String[] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public void clear(){
    // This resets the size to zero
    size = 0;
  }
  public int size(){
    // This is the accessor method for size
    return size;
  }
  public boolean isEmpty(){
    // Checks if the array is empty
    return size() == 0;
  }
  public boolean add(String value){
    // This appends the parameter value to the end of the array
    // If the array needs to be expanded, the length of the array is doubled
    if (size() == data.length){
      resize();
    }
    data[size()] = value;
    size ++;
    return true;
  }
  public String toString(){
    // Prints out the filled values of the array
    String ans = "[";
    for (int i = 0; i < size()+1; i++){
      ans += get(i);
      if (i + 1 != size()+1){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String toStringDebug(){
    // Prints out all the values of the array including the null values
    String ans = "[";
    for (int i = 0; i < data.length; i++){
      ans += get(i);
      if (i + 1 != data.length){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String get(int index){
    // Returns the value at the specified index
    if (index < 0 || index >= data.length){
      System.out.println("Error: index out of range");
      return null;
    }else{
      return data[index];
    }
  }
  public String set(int index, String value){
    // Changes the value at the specified index to the new value given in paremeter
    // Returns the old value
    String old = data[index];
    if (index < 0 || index >= size()){
      System.out.println("Error: index out of range");
      return null;
    }else{
      data[index] = value;
    }
    return old;
  }
  private void resize(){
    // Doubles the size of the array
    String[] newArray = new String[data.length * 2];
    for (int i = 0; i < size(); i++){
      newArray[i] = data[i];
    }
    data = newArray;
  }
  public boolean contains(String target){
    for (int i = 0; i < size(); i++){
      if (data[i].equals(target)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String target){
    for (int i = 0; i < size(); i++){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    for (int i = size()-1; i > 0; i--){
      if (data[i].equals(target)){
        return i;
      }
    }
    return -1;
  }
  public void add(int index, String value){
    // makes a new array and inserts value at index and shifting everything else to the right down by one.
    boolean inserted = false;
    if (index < 0 || index > size()){
      System.out.println("Error: index out of range");

    }
    if (size() == data.length){
      resize();
    }
    String[] newArray = new String[data.length];
    for (int i = 0; i < size()+1; i++){
      if (i == index){
        newArray[i] = value;
        inserted = true;
      }
      if (inserted){
        newArray[i+1] = data[i];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
  }
  public String remove(int target){
    // removes the value at target index and returns it. Prints error if index out of range.
    boolean removed = false;
    String gone = "";
    String[] newArray = new String[data.length];
    if (target < 0 || target >= size()){
      System.out.println("Error: index out of range");
      return null;
    }
    for (int i = 0; i < size(); i++){
      if (i == target){
        removed = true;
        gone = data[i];
      }
      if (removed){
        newArray[i] = data[i+1];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
    return gone;
  }
  public boolean remove(String target){
    boolean removed = false;
    String[] newArray = new String[data.length];
    for (int i = 0; i < size(); i++){
      if (data[i].equals(target)){
        removed = true;
      }
      if (removed){
        newArray[i] = data[i+1];
      }else{
        newArray[i] = data[i];
      }
    }
    data = newArray;
    return removed;
  }
}
