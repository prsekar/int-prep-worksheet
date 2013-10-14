package com.algos.ds;

public class Bst {

	private Node root;

	public void insert(Node oldNode, Node n, int iter) {
		iter++;
		System.out.println("Iteration " + iter);
		if (n.get() < oldNode.get()) {
			if (oldNode.left != null) {
				insert(oldNode.left, n, iter);
			} else {
				oldNode.left = n;
			}
		} else {
			if (oldNode.right != null) {
				insert(oldNode.right, n, iter);
			} else {
				oldNode.right = n;
			}
		}
		return;
	}



	public Node findMin(Node node) {
		if (node.left != null) {
			return findMin(node.left);
		}
		else {
			return node;
		}
	}


	public Node findMax(Node node) {
		if (node.right != null) {
			return findMax(node.right);
		}
		else {
			return node;
		}
	}


	// TODO : design and implement
	/**
	 * Find highest in left subtree and make it root OR 
	 * Find lowest in right subtree and make it root
	 * @param n
	 */
	public Node delete(Node node, int n) {
		
		if (n < node.get()) {
			if (node.left != null) {
				if (n != node.left.get()) {
					return delete (node.left, n);
				}
				else {
					return node;
				}
			} else {
				return new Node(-1);
			}
		}
		else if (n > node.get()) {
			if (node.right != null) {
				if (n != node.right.get()) {
					return delete (node.right, n);
				}
				else {
					return node;
				}
			} else {
				return new Node(-1);
			}
		}
		else {
			return node;
		}

	}

	private void reshuffle() {

	}
	
	public void inorder(Node node){ 
		traverse(node, 1);
	}
	public void postOrder(Node node) {
		
	}
	public void preOrder(Node node, int itr) {
		itr++;
		if (node.left != null) {
			traverse(node.left, itr);
			System.out.println(node.get());
		} else {
			System.out.println(node.get());
		} 
		if (node.right != null) {
			traverse(node.right, itr);
		}
	}
	public void getDepth(Node node) {
		System.out.println(traverse (node, 1));
	}
 
	public int traverse(Node node, int itr) {
		itr ++;
		if (node.left != null) {
			traverse(node.left, itr);
			System.out.println(node.get());
		} else {
			System.out.println(node.get());
		} 
		if (node.right != null) {
			traverse(node.right, itr);
		}
		return itr;
	}

	public static void main(String[] args) {
		Bst bst = new Bst();
		int[] input = { 4, 2, 6, 1, 3, 5 };
		for (int i : input) {
			System.out.println("Inserting " + i);
			Node n = new Node(i);
			if (bst.root == null) {
				bst.root = n;
			} else {
				bst.insert(bst.root, n, 0);
			}
		}
		//bst.inorder(bst.root);
		//bst.getDepth(bst.root);
		//bst.preOrder(bst.root, 0);
		Node minNode = bst.findMin(bst.root);
		System.out.println(minNode.get());
		Node maxNode = bst.findMax(bst.root);
		System.out.println(maxNode.get());
		
		Node node = bst.delete(bst.root, 6);
		System.out.println(node.get());
		
		
	}
}


class Node {
	private int value;

	public int get() {
		return value;
	}

	public Node(int value) {
		this.value = value;
	}

	public Node left;
	public Node right;
}