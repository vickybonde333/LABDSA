package com.greatlearning.app;

import java.util.HashSet;

public class Tree {
	Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public static void isSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<>();
		isSum(set, root, sum);

	}

	public static boolean isSum(HashSet set, Node root, int sum) {
		if (root == null) {
			return false;
		}
		if (isSum(set, root.left, sum)) {
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is there between " + root.data + " and " + (sum - root.data));
			return true;
		} else {
			set.add(root.data);

		}
		return isSum(set, root.right, sum);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		Tree binaryTree = new Tree(root);
		binaryTree.root.left = new Node(20);
		binaryTree.root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		isSum(root, 130);

	}
}

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;

	}
}
