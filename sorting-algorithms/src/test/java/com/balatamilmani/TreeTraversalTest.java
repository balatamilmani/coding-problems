package com.balatamilmani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.balatamilmani.model.Node;
import com.balatamilmani.sorting.TreeTraversal;


public class TreeTraversalTest {

	private static TreeTraversal tt = new TreeTraversal();
	
	@Test
	public void mergeSort1() {
		Node root = getTree();
		List<Integer> result = new ArrayList<>();
		tt.inOrderTraversal(root, result);
		System.out.println(Arrays.toString(result.toArray()));
		String expected = "[2, 4, 6, 8, 9, 10, 12]"; 
		Assert.assertEquals(expected, Arrays.toString(result.toArray()));

	}
	
	@Test
	public void traversalPreOrderTest() {
		Node root = getTree();
		List<Integer> result = new ArrayList<>();
		tt.preOrderTraversal(root, result);
		System.out.println(Arrays.toString(result.toArray()));
		String expected = "[8, 4, 2, 6, 10, 9, 12]"; 
		Assert.assertEquals(expected, Arrays.toString(result.toArray()));

	}	

	@Test
	public void traversalPostOrderTest() {
		Node root = getTree();
		List<Integer> result = new ArrayList<>();
		tt.postOrderTraversal(root, result);
		System.out.println(Arrays.toString(result.toArray()));
		String expected = "[2, 6, 4, 9, 12, 10, 8]"; 
		Assert.assertEquals(expected, Arrays.toString(result.toArray()));
		
	}	
	
	@Test
	public void traversalBfsTest() {
		Node root = getTree();
		List<Integer> result = new ArrayList<>();
		tt.bfsTraversal(root, result);
		System.out.println(Arrays.toString(result.toArray()));
		String expected = "[8, 4, 10, 2, 6, 9, 12]"; 
		Assert.assertEquals(expected, Arrays.toString(result.toArray()));
		
	}	

	@Test
	public void addNodeTest() {
		Node root = getTree();
		List<Integer> result = new ArrayList<>();
		tt.inOrderTraversal(root, result);
		System.out.println("In order"+Arrays.toString(result.toArray()));
		//Add node
		tt.addNode(root, 1);
		result = new ArrayList<>();
		tt.inOrderTraversal(root, result);
		System.out.println("In order"+Arrays.toString(result.toArray()));
		//String expected = "[8, 4, 10, 2, 6, 9, 12]"; 
		//Assert.assertEquals(expected, Arrays.toString(result.toArray()));
		
	}	
	private Node getTree() {
		Node root = new Node(8);
		
		Node two = new Node(2);
		Node six = new Node(6);
		Node four = new Node(4);
		Node nine = new Node(9);
		Node twelve = new Node(12);
		Node ten = new Node(10);
		
		four.setLeftNode(two);
		four.setRightNode(six);
		
		ten.setLeftNode(nine);
		ten.setRightNode(twelve);
		
		root.setLeftNode(four);
		root.setRightNode(ten);
		
		return root;
	}
}
