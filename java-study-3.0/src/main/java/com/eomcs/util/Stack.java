package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {
  
  private int maxSize;
  
  public Stack() {
    this.maxSize = 100;
  }
  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }

  @Override
  public Stack<E> clone() {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Stack<E>) temp;
  }
  
  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }
  
  public E pop() {
    return remove(size() - 1);
  }
  
}
