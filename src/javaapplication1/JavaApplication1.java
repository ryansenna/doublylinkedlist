/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 1333612
 */
public class JavaApplication1<E> {

    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(E element) {
        if (size == 0) {
            head = new Node(element, null, null);
            //tail = head;
        } else {
            Node nodeToAdd = new Node(element, null, head);
            head.setPrev(nodeToAdd);
            head = nodeToAdd;
        }
        size++;
    }

    /**
     * Adding to the last
     *
     * @param element
     */
    public void addLast(E element) {
        if (size == 0) {
            tail = new Node(element, null, null);
        } else {
            Node nodeToAdd = new Node(element, tail, null);
            tail.setNext(nodeToAdd);
            tail = nodeToAdd;

        }
        size++;

    }

    public void insert(int position, E element) {
       // if (position == 0) {// if the position is first, well... add first.. deuh
       //     this.addFirst(element);
        //} else if (position == size) {// if the position is the last, add last.
        //    this.addLast(element);
        //} else {// if it is somewhere in the list..
            Node elementInPosition = element(position);// get the element in this position.
            Node previousElement = elementInPosition.getPrev();// get the previous element of that element in position.
            Node elementToAdd = new Node(element, previousElement, elementInPosition);// build the element to add.
            previousElement.setNext(elementToAdd);// switch the next element of the previous element of the element in position.
            elementInPosition.setPrev(elementToAdd);// switch the previous element of the element in position.
        //}
        size++;
    }

    public Node element(int position) {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            //counter++;
            if (counter == position) {
                return temp;
            }
            counter++;
            temp = temp.getNext();
        }
        return null;
    }

    public void iterateForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getElement());
            temp = temp.getNext();
        }
    }

    public void iterateBackwards() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.getElement());
            temp = temp.getPrev();
        }
    }

    public static void main(String a[]) {
        JavaApplication1<Integer> dll = new JavaApplication1<>();
        dll.addFirst(50);
        dll.addFirst(10);
        dll.addFirst(34);
        dll.addFirst(5);
        dll.insert(0, 6);
        dll.iterateForward();
    }
}
