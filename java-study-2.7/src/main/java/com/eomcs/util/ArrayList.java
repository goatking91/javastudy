package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {
  final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size = 0;
  
  public ArrayList() {
    elementData  = new Object[DEFAULT_CAPACITY];
  }
  
  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY) 
      elementData = new Object[initialCapacity];
    else
      elementData = new Object[DEFAULT_CAPACITY];
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[])Arrays.copyOf(elementData, size, a.getClass());
    }
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }
  
  public void add(E obj) {
    if (size >= elementData.length) {
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      elementData = Arrays.copyOf(elementData, newCapacity);
    }
    
    elementData[size++] = obj;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    return (E) elementData[index];
  }
  
  public E set(int index, E obj) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    @SuppressWarnings("unchecked")
    E old = (E) elementData[index];
    elementData[index] = obj; 
    return old;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    @SuppressWarnings("unchecked")
    E old = (E) elementData[index];
    
    int newSize = size - 1;
    System.arraycopy(elementData, index + 1, elementData, index, newSize - index);
    elementData[size = newSize] = null;
    
    return old;
  }
  
  public int size() {
    return size;
  }
}
