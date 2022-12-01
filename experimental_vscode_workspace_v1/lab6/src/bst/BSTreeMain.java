package bst;

public class BSTreeMain {
    public static void main(String[] args) {
		BSTVisualizer visualizer = new BSTVisualizer("Binary tree", 500, 500);
		BinarySearchTree<Integer> binaryTree = new BinarySearchTree<Integer>(); 
		for (int i = 11; i > 0; i--){
			binaryTree.add(i);
		}
		binaryTree.rebuild();
		visualizer.drawTree(binaryTree);
		binaryTree.printTree();
	}
}
