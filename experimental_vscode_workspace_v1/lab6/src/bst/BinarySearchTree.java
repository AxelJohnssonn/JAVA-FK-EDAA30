package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> ccomparator;
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		size = 0; 
		root = null; 
		ccomparator = (e1,e2) -> ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		size = 0 ; 
		root = null; 
		ccomparator=comparator; 
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {

		if (size == 0){
			root = new BinaryNode<E>(x);
			size++;
			return true; 
		}
		return addNode(root, x);
	}

	private boolean addNode(BinaryNode<E> node, E x){
		if(ccomparator.compare(x, node.element) < 0){
			if(node.left == null){
				node.left = new BinaryNode<E>(x);
				size++;
				return true; 
			}
				return addNode(node.left, x);
		} 
		
		else if(ccomparator.compare(x, node.element) > 0){
			if(node.right == null){
				node.right = new BinaryNode<E>(x);
				size++;
				return true; 
			}
				return addNode(node.right, x); 
		}else { 
			return false;
		}
	}
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return recursiveH(root);
	}

	private int recursiveH(BinaryNode<E> node){
		if(node.left == null && node.right == null){
			return 0;
		}else{
			return 1 + Math.max(recursiveH(node.left), recursiveH(node.right)); 
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0; 
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
			inOrder(root);
	}

	private void inOrder(BinaryNode<E> node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.element);
			inOrder(node.right);
		}
	}
	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null; 
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}