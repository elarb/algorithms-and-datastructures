package com.elar.algorithms.data_structures;

import java.util.HashSet;

public class MySet extends HashSet<String> {
  private static final long serialVersionUID = 1L;

  public MySet() {
    super();
  }

  // post: returns the union of the elements of this and that
  // +union(that : MySet) : MySet
  public MySet union(MySet that) {
    that.addAll(this);
    return that;
  }

  // post: returns the intersection of the elements of this and that
  // +intersection(that : MySet) : MySet
  public MySet intersection(MySet that) {
    MySet result = new MySet();
    for (String element : that) {
      if (this.contains(element)) {
        result.add(element);
      }
    }
    return result;
  }

  // post: returns the difference of the elements of this and that
  // +difference(that : MySet) : MySet
  public MySet difference(MySet that) {
    MySet result = new MySet();

    result.addAll(this);

    for (String element : that) {
      if (contains(element)) {
        result.remove(element);
      }
    }
    return result;
  }

  // post: returns the exclusive or (XOR) of the elements of this and that
  // +difference(that : MySet) : MySet
  public MySet exclusiveOr(MySet that) {
    MySet intersection = intersection(that);
    MySet result = union(that);

    for (String element : this) {
      if (intersection.contains(element)) {
        result.remove(element);
      }
    }
    return result;
  }

  // post: returns a String representation of a MySet object
  // +toString()
  public String toString() {
    StringBuilder builder = new StringBuilder();
    String prefix = "";
    for (String element : this) {
      builder.append(prefix);
      prefix = ",";
      builder.append(element);
    }
    builder.insert(0, "<MySet{");
    builder.append("}>");
    System.out.println(builder.toString());
    return builder.toString();
  }
}
//
