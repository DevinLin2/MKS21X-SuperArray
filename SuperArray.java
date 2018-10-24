public class SuperArray {
  private String[] data;
  private int size;
  public SuperArray(){
    data = new String[10];
    size = 0;
  }
  public void clear(){
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size() == 0;
  }
  public boolean add(String value){ //This must be edited later such that: If the capacity is full, you must resize() first.
    data[size()] = value;
  }
  public String toString(){
    String ans = "[";
    for (int i = 0; i < size(); i++){
      ans += get(i);
      if (i + 1 != size()){
        ans += ","
      }
    }
    return ans;
  }
  public String toStringDebug(){ //Have to finish this later.
    return "";
  }
  public String get(int index){
    if (index < 0 || index >= size()){
      return null;
      System.out.println("Error: index out of range")
    }else{
      return data[index];
    }
  }
  public String set(int index, String value){
    String old = data[index];
    if (index < 0 || index >= size()){
      return null;
      System.out.println("Error: index out of range")
    }else{
      data[index] = value;
    }
    return old;
  }
}
