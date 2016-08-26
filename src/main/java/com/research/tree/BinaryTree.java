package com.research.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public void preOrder(TreeNode node){
		if(node != null){
			System.out.print(node.data+", ");
			preOrder(node.left); 
			preOrder(node.right);
		}
	}

	public void postOrder(TreeNode node){
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data+", ");
		}
	}

	public void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.left);
			System.out.print(node.data+", ");
			inOrder(node.right);
		}
	}

	public void levelOrder(TreeNode node){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			TreeNode tempNode =  queue.poll();
			System.out.print(tempNode.data+",");
			if(tempNode.left != null)
				queue.add(tempNode.left);
			if(tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	public void reverseLevelOrder(TreeNode node){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			TreeNode tempNode =  queue.poll();
			if(tempNode.right != null)
				queue.add(tempNode.right);
			if(tempNode.left != null)
				queue.add(tempNode.left);


			stack.add(tempNode);
		}

		while(!stack.isEmpty()){
			System.out.print(stack.pop().data+",");

		}
	}

	public void spiralOrZigzagLevelOrder(TreeNode root) {  
		if(root==null) return;   
		Stack<TreeNode> stack=new Stack<TreeNode>();  
		stack.add(root);  

		boolean directionflag=false;  
		while(!stack.isEmpty())  
		{  
			Stack<TreeNode> tempStack=new Stack<TreeNode>();  

			while(!stack.isEmpty())  
			{  
				TreeNode tempNode=stack.pop();  
				System.out.print(tempNode.data+",");  
				if(!directionflag)   
				{  
					if(tempNode.left!=null)   
						tempStack.add(tempNode.left);  
					if(tempNode.right!=null)   
						tempStack.add(tempNode.right);  
				}else  
				{  
					if(tempNode.right!=null)   
						tempStack.add(tempNode.right);  
					if(tempNode.left!=null)   
						tempStack.add(tempNode.left);  
				}  
			}  
			// for changing direction  
			directionflag=!directionflag;   

			stack=tempStack;   
		}  

	}  
	
	public int depthOfTree(TreeNode node){
		if(node == null){
			return 0;
		}
		
		int leftDepth = depthOfTree(node.left);
		int rightDepth = depthOfTree(node.right);
		
		if(leftDepth > rightDepth){
			return leftDepth+1;
		} else {
			return rightDepth+1;
		}
	}
	
	//Reverse Level with recursion
	public void testOrder(TreeNode node){
		if(node == null) return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(node);
		
		boolean directionFlag = true;
		while (!stack.isEmpty()) {
			Stack<TreeNode> tempStack = new Stack<TreeNode>();
			
			while (!stack.isEmpty()) {
				TreeNode tmp = stack.pop();
				System.out.print(tmp.data+",");
				
				if(!directionFlag){
					if(tmp.left!=null){
						tempStack.add(tmp.left);
					} if(tmp.right!=null){
						tempStack.add(tmp.right);
					}
				} else {
					if(tmp.right!=null){
						tempStack.add(tmp.right);
					}
					if(tmp.left!=null){
						tempStack.add(tmp.left);
					} 
				}
			}
			
			directionFlag = !directionFlag;
			stack = tempStack;
		}
		
	}
	
	public void printTree(TreeNode node, int level){
		if(node == null){
			return;
		}
		if(level == 1){
			System.out.print(node.data+" ,");
		} else if(level>1){
			printTree(node.left, level-1);
			printTree(node.right, level-1);
		}
	}
}
