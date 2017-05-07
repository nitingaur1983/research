package com.research.tree;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class BinaryTest {
	TreeNode rootNode;
	@Before
	public void setUp(){
		rootNode=new TreeNode(40);  
		TreeNode node20=new TreeNode(20);  
		TreeNode node10=new TreeNode(10);  
		TreeNode node30=new TreeNode(30);  
		TreeNode node60=new TreeNode(60);  
		TreeNode node50=new TreeNode(50);  
		TreeNode node70=new TreeNode(70);
		TreeNode node84=new TreeNode(84);  

		rootNode.left=node20;  
		rootNode.right=node60;  

		node20.left=node10;  
		node20.right=node30;  

		node60.left=node50;  
		node60.right=node70;  
		
		node10.right = node84;
	}
	
	@Test
	public void testPrintTree(){
		BinaryTree tree = new BinaryTree();
		tree.printTree(rootNode, 4);
	}
	@Test
	public void testPreOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.preOrder(rootNode);
	}
	
	@Test
	public void testPostOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.postOrder(rootNode);
	}
	
	@Test
	public void testInOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.inOrder(rootNode);
	}
	
	@Test
	public void testLevelOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.levelOrder(rootNode);
	}
	
	@Test
	public void testReverseLevelOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.reverseLevelOrder(rootNode);
	}
	
	@Test
	public void testSpiralOrZigzagLevelOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.spiralOrZigzagLevelOrder(rootNode);
	}
	
	@Test
	public void testTestOrder(){
		BinaryTree bTree = new BinaryTree();
		bTree.testOrder(rootNode);
	}
	
	@Test
	public void testDepthOfTree(){
		BinaryTree bTree = new BinaryTree();
		int depthOfTree = bTree.depthOfTree(rootNode);
		Assert.assertEquals(4, depthOfTree);
	}
}
