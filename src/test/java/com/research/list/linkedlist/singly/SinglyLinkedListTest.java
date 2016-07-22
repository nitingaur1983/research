package com.research.list.linkedlist.singly;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class SinglyLinkedListTest {

	//@Autowired
	static SinglyLinkedListImpl<Integer> linkedList;
	
	@Before
	public void setUp(){
		linkedList = new SinglyLinkedListImpl<Integer>();
		linkedList.add(3);
		linkedList.add(45);
		linkedList.add(12);
		linkedList.add(32);
		linkedList.add(49);
		linkedList.add(98);
		linkedList.add(90);
		linkedList.add(42);
	}
	
	@Test
	public void testSinglyLinkedList(){
		//SinglyLinkedListImpl<Integer> linkedList = new SinglyLinkedListImpl<Integer>();
		
		linkedList.traverse();
		linkedList.addAfter(21, 90);
		linkedList.traverse();
		linkedList.addAfter(67, 42);
		linkedList.traverse();
		linkedList.deleteAfter(49);
		linkedList.traverse();
		linkedList.deleteFront();
		linkedList.traverse();
		linkedList.reverse();
		linkedList.traverse();
		
		linkedList.swap(12, 45);
		linkedList.traverse();
		
		// creating a loop in linked list
		System.out.println("Head = "+linkedList.head.getValue() );
		System.out.println("Tail = "+linkedList.tail.getValue() );
		linkedList.tail.setNextRef(linkedList.head.getNextRef().getNextRef());
		linkedList.detectLoop();
		linkedList.traverse();

	}
}
