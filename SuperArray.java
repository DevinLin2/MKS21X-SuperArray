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
  public boolean add(String value){
    if (size() == data.length){
      resize();
    }
    data[size()] = value;
    size ++;
    return true;
  }
  public String toString(){
    String ans = "[";
    for (int i = 0; i < size(); i++){
      ans += get(i);
      if (i + 1 != size()){
        ans += ",";
      }
    }
    ans += "]";
    return ans;
  }
  public String toStringDebug(){
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
    if (index < 0 || index >= data.length){
      System.out.println("Error: index out of range");
      return null;
    }else{
      return data[index];
    }
  }
  public String set(int index, String value){
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
    String[] newArray = new String[data.length * 2];
    for (int i = 0; i < size(); i++){
      newArray[i] = data[i];
    }
    data = newArray;
  }
}
