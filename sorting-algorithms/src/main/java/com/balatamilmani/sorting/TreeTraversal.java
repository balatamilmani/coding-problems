package com.balatamilmani.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.balatamilmani.model.Node;

public class TreeTraversal {
	
	public void addNode(Node node, int value) {
		if(value < node.getValue()) {
			if(node.getLeftNode() != null) {
				addNode(node.getLeftNode(), value);
			} else {
				//No left Node, value to be added as LeftChild
				Node leftChild = new Node(value);
				node.setLeftNode(leftChild);
			}
		}else if(value>= node.getValue()) {
			if(node.getRightNode() != null) {
				//Value to be added on the Right child
				addNode(node.getRightNode(), value);
			}else {
				//No right Node, value to be added as RightChild
				Node rightChild = new Node(value);
				node.setRightNode(rightChild);
			}
		}
	}
	
	public void inOrderTraversal(Node node, List<Integer> result){
		if(node.getLeftNode() != null) {
			inOrderTraversal(node.getLeftNode(), result);
		}
		result.add(node.getValue());
		if(node.getRightNode() != null) {
			inOrderTraversal(node.getRightNode(), result);
		}
	}
	
	public void preOrderTraversal(Node node, List<Integer> result){
		result.add(node.getValue());
		if(node.getLeftNode() != null) {
			preOrderTraversal(node.getLeftNode(), result);
		}
		if(node.getRightNode() != null) {
			preOrderTraversal(node.getRightNode(), result);
		}
	}
	public void postOrderTraversal(Node node, List<Integer> result){
		if(node.getLeftNode() != null) {
			postOrderTraversal(node.getLeftNode(), result);
		}
		if(node.getRightNode() != null) {
			postOrderTraversal(node.getRightNode(), result);
		}
		result.add(node.getValue());
	}

	public void bfsTraversal(Node node, List<Integer> result){
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		while(!q.isEmpty()) {
			Node n = q.poll();
			result.add(n.getValue());
			if(n.getLeftNode() != null) {
				q.offer(n.getLeftNode());
			}
			if(n.getRightNode() != null) {
				q.offer(n.getRightNode());
			}
		}
	}
}
