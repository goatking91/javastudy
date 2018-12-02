package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    E[] arr = (E[]) Array.newInstance(a.getClass().getComponentType(), size);
    Node<E> node = first;
    for (int i = 0; i < size; i++) {
      arr[i] = node.value;
      node = node.next;
    }
    return arr;
  }
  
  public void add(E obj) {
    Node<E> prev = last;
    last = new Node<>(prev, obj, null);
    if (prev == null)
      first = last;
    else 
      prev.next = last;
    
    size++;
  }
  
  public E get(int index) {
    if (index < 0 || index >= size) 
      return null;
    
    Node<E> node = first;
    
    for (int i = 1; i <= index; i++) {
      node = node.next;
    }
    
    return node.value;
  }

  public E set(int index, E obj) {
    if (index < 0 || index >= size)
      return null;
    
    Node<E> node = first;
    
    for (int i = 1; i <= index; i++) {
      node = node.next;
    }
    
    E oldValue = node.value;
    node.value = obj;
    
    return oldValue;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    
    Node<E> node = first;
    
    for (int i = 1; i <= index; i++) {
      node = node.next;
    }
    
    if (first == last) {
      first = last = null;
    } else if (node == first) {
      first = node.next;
    } else if (node == last) {
      last = node.prev;
    } else { 
      node.prev.next = node.next;
    }
    
    E oldValue = node.value;
    
    node.value = null; // help GC
    node.next = null;
    node.prev = null;
    
    size--;

    return oldValue;
  }
  
  public int size() {
    return size;
  }
  
  private static class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;
    
    Node(Node<E> prev, E value, Node<E> next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    }
  }
  
}