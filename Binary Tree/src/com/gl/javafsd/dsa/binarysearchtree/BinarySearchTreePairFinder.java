package com.gl.javafsd.dsa.binarysearchtree;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTreePairFinder {
	
	private BinarySearchTree binarySearchTree;
	
	private boolean found;
	
	public BinarySearchTreePairFinder(BinarySearchTree binarySearchTree) {
		
		this.binarySearchTree = binarySearchTree;
	}
	
	public void findPair(int sum){
		
		Set<Integer> nodes = new HashSet<>();
		
		findPairInt(binarySearchTree.getRoot(), sum, nodes);
		
		if (!found) {
			
			System.out.println("For the sum value " + sum + ", matching nodes NOT found");
		}				
	}
	
	boolean findPairInt(BinarySearchTreeNode aNode, int sum, Set<Integer> nodes){		
		
		if (aNode == null) 
		
		{
			
			return false;
		}
		
		
		found = findPairInt(aNode.getLeftNode(), sum, nodes);
		
		if (found) 
		{
			
			return true;
		}
	
		
		int difference = (sum - aNode.getData());
		
		if (nodes.contains(difference)) {
			
			found = true;
			
			System.out.println( "Pair is ("  + aNode.getData() +" , " + difference + ")");
			
			return found;
			
		}
		
		else
		
		{
		
			nodes.add(aNode.getData());
		}	
		
		if (!found) {
			
			return findPairInt(aNode.getRightNode(), sum, nodes);
			
		}
		else
		
		{
			return true;
		}
	}

}
