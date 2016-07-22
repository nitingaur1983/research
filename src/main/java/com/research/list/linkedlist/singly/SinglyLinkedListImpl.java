package com.research.list.linkedlist.singly;

import org.springframework.stereotype.Component;

import com.research.list.linkedlist.Node;

public class SinglyLinkedListImpl<T> {
	Node<T> head;
	Node<T> tail;
	
	public void add(T element){
		
		Node<T> node = new Node<T>();
		node.setValue(element);
		
		if(head == null){
			head = node;
			tail = node;
		} else {
			tail.setNextRef(node);
			tail = node;
		}
	}
	
	public void addAfter(T element, T after){
		Node<T> node = new Node<T>();
		node.setValue(element);
		Node<T> tmp = head;
		Node<T> refNode = null;
		while(true){
			if(tmp == null)
				break;
			if(tmp.compareTo(after) == 0){
				refNode=tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		
		if(refNode != null){
			node.setNextRef(tmp.getNextRef());
			if(tmp.compareTo(tail.getValue()) == 0)
				tail=node;
			tmp.setNextRef(node);
		}
	}
	
	public void deleteFront(){
		if(head == null){
			System.out.println("UnderFlow");
		} else{
			Node<T> tmp = head;
			head = tmp.getNextRef();
			if(head == null){
				tail = null;
			}
		}
	}
	
	public void deleteAfter(T after){
		Node<T> tmp = head;
		Node<T> refNode = null;
		
		while(true){
			if(tmp == null)
				break;
			if(tmp.compareTo(after) == 0){
				refNode=tmp;
				break;
			}
			tmp=tmp.getNextRef();
		}
		
		if(refNode != null){
			tmp = refNode.getNextRef();
			refNode.setNextRef(tmp.getNextRef());
			
			if(refNode.getNextRef() == null){
				tail = refNode;
			}
		}
	}
	
	public void reverse(){
		Node<T> currentNode = head;
		Node<T> nextNode = null;
		Node<T> previousNode = null;
		while(currentNode != null){
			nextNode = currentNode.getNextRef();
			currentNode.setNextRef(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		tail = head;
		head = previousNode;
	}
	
	public void traverse(){
		Node<T> tmp = head;
		while(true){
			if(tmp == null)
				break;
			System.out.print(tmp.getValue()+",");
			tmp=tmp.getNextRef();
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<Integer>();
		linkedList.add(3);
		linkedList.add(45);
		linkedList.add(12);
		linkedList.add(32);
		linkedList.add(49);
		linkedList.add(98);
		linkedList.add(90);
		linkedList.add(42);
		linkedList.traverse(); // 1: Traverse - initial Linked List
		linkedList.addAfter(21, 90);
		linkedList.traverse(); // 2: Traverse - after adding 21 after 90
		linkedList.addAfter(67, 42);
		linkedList.traverse(); // 3: Traverse - after adding 67 after 42
		linkedList.deleteAfter(49);
		linkedList.traverse(); // 4: Traverse - after deleting number after 49
		linkedList.deleteFront();
		linkedList.traverse(); // 5: Traverse - after deleting front number from linked list
		linkedList.reverse();
		linkedList.traverse(); // 6: Traverse - after reversing the linked list
	}
	
	public void swap(T first, T second){
		Node<T> currentFirst = head; 
		Node<T> previousFirst = null;
		while(currentFirst !=null && currentFirst.compareTo(first) != 0){
			previousFirst = currentFirst;
			currentFirst = currentFirst.getNextRef();
		}
		
		Node<T> currentSecond = head; 
		Node<T> previousSecond = null;
		while(currentSecond !=null && currentSecond.compareTo(second) != 0){
			previousSecond = currentSecond;
			currentSecond = currentSecond.getNextRef();
		}
		
		if(currentFirst == null || currentSecond == null){
			return;
		}
		
		if(previousFirst != null){
			previousFirst.setNextRef(currentSecond);
		} else{
			head = currentSecond;
		}
		
		if(previousSecond != null){
			previousSecond.setNextRef(currentFirst);
		} else{
			head = currentFirst;
		}
		
		//Checking Tail 
		if(currentFirst.getNextRef() == null){
			tail = currentSecond;
		} if(currentSecond.getNextRef() == null){
			tail = currentFirst;
		}
		
		Node<T> tmp = currentFirst.getNextRef();
		currentFirst.setNextRef(currentSecond.getNextRef());
		currentSecond.setNextRef(tmp);
	}
	
	public void detectLoop(){
		Node<T> node = head;
		
		Node<T> slow = node;
		Node<T> fast = node.getNextRef();
		
		while(slow != null && fast!=null && fast.getNextRef()!=null){
			fast = fast.getNextRef().getNextRef();
			slow = slow.getNextRef();
			
			if(slow.compareTo(fast.getValue()) == 0){
				System.out.println("Loop Detected");
				removeLoop(slow,fast);
				break;
			}
		}
	}
	
	public void removeLoop(Node<T> slow, Node<T> fast){
		slow =head;
		while(slow.compareTo(fast.getNextRef().getValue()) != 0){
			slow = slow.getNextRef();
			fast = fast.getNextRef();
		}
		
		fast.setNextRef(null);
	}
}
