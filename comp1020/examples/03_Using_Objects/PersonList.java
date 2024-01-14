public class PersonList {
  private Person [] list;
  private int numItems;
  private static int max_size = 1;
  
  
  public PersonList() {
    list = new Person[max_size];
    numItems = 0;
  }
  
  public boolean addPerson(Person p) {
    // This is always true, so we could just
    // return true at the end of the method.
    boolean result = false; 
    
    if (isFull()) {
      increaseArray();
      list[numItems++] = p;
      result = true;
      // addPerson(p); // - Recursion, later!!!
    } else {
      list[numItems++] = p;
      result = true;
    }
    return result;
  }
  
  private boolean isFull() { return numItems == list.length; }
  public boolean isEmpty() { return numItems == 0; }
  
  // Private utility method to increase our array size
  private void increaseArray() {
    max_size = max_size * 2;
    Person [] list2 = new Person[max_size];
    System.arraycopy(list, 0, list2, 0, numItems);
    
    list = list2;
  }
  
  /*
   * Delete a Person with the given name from
   * the list by overwriting the Person object
   * 
   * Return true if we were successful, or false
   * if the Person does not exist in the list
   */
  public boolean delete(String name) {
    boolean result = false;
    int index = findIndex(name);
    
    // If the person exists, index will contain its
    // position in the list
    if (index >= 0) {
      numItems--; // We now have one less Person
      for (int i = index; i < numItems; i++)
        list[i] = list[i+1];
      result = true; // Operation delete was successful
    }
    return result;
  }
  
  /*
   * Given a name, find the Person object in
   * the list and return it. 
   * If a Person with that name does not exist on
   * the list, return null
   */
  public Person searchByName(String name) {
    Person result = null;
    int index = findIndex(name);
    if (index >= 0)
      result = list[index];
    return result;
  }
  
  /*
   * Given a name, find the position of that
   * Person object in the list with that name.
   * 
   * If the person does not exist, return -1
   */
  private int findIndex(String name) {
    int result = -1;
    for (int i = 0; i < numItems; i++) {
      if (list[i].getName().equals(name))
        result = i;
    }
    return result;
  }
  
  public String toString() {
    String result = "";
    for (int i = 0; i < numItems; i++)
      result += list[i].getName() + " ";
    return result;
  }
  
  
}