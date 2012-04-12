package algo.datastructure.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {
	private BinaryTreeNode root;
	public int count = 0;

	public BinaryTreeNode getRoot() {
		return root;
	}

	private void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode add(int data) {
		BinaryTreeNode temp = new BinaryTreeNode();
		temp.setData(data);
		temp.setLeft(null);
		temp.setRight(null);

		if (root != null) {
			BinaryTreeNode temp1 = root;
			while (true) {

				if (temp1.getData() <= data) {
					if (temp1.getRight() == null) {
						temp1.setRight(temp);
						break;
					}
					temp1 = temp1.getRight();
				} else {
					if (temp1.getLeft() == null) {
						temp1.setLeft(temp);
						break;
					}
					temp1 = temp1.getLeft();
				}
			}
		} else {
			root = temp;
		}
		count++;
		return root;
	}

	public BinaryTreeNode floor(int data) {
		if (data > getMaximum().getData()) {
			return getMaximum();
		}
		return floor(data, null, root);
	}

	private BinaryTreeNode floor(int data, BinaryTreeNode prev,
			BinaryTreeNode root) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode left = floor(data, prev, root.getLeft());
		if (left != null) {
			return left;
		}
		if (data == root.getData()) {
			return root;
		}
		if (data < root.getData()) {
			return prev;
		}
		prev = root;
		return floor(data, prev, root.getRight());

	}

	public BinaryTreeNode getMaximum() {

		if (root == null)
			return null;
		BinaryTreeNode maxNode = root;
		while (maxNode.getRight() != null) {
			maxNode = maxNode.getRight();
		}
		return maxNode;
	}

	public int[] inorderTraversal() {
		int[] inordertraversal = new int[count];
		int[] index = { 0 };
		inordertraversalUtil(root, inordertraversal, index);
		return inordertraversal;
	}

	private void inordertraversalUtil(BinaryTreeNode root, int[] array,
			int[] index) {
		if (root == null) {
			return;
		}
		inordertraversalUtil(root.getLeft(), array, index);
		array[index[0]++] = root.getData();
		inordertraversalUtil(root.getRight(), array, index);
	}

	@Override
	public String toString() {
		StringBuilder strBldr = new StringBuilder();
		for (int i : inorderTraversal()) {
			strBldr.append(i).append("   ");
		}
		return strBldr.toString();
	}

	public static BinaryTree getBinaryTreeFromSortedArray(int[] sortedArray) {
		BinaryTree temp = (new BinaryTree());
		temp.setRoot(getBinaryTreeFromSortedArray(sortedArray, 0,
				sortedArray.length - 1));
		temp.count = sortedArray.length;
		return temp;
	}

	private static BinaryTreeNode getBinaryTreeFromSortedArray(
			int[] sortedArray, int beg, int end) {
		if (beg > end) {
			return null;
		}
		int mid = beg + (end - beg) / 2;
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(sortedArray[mid]);
		root.setLeft(getBinaryTreeFromSortedArray(sortedArray, beg, mid - 1));
		root.setRight(getBinaryTreeFromSortedArray(sortedArray, mid + 1, end));
		return root;

	}

	public int[] getMiddleElements(int beg, int last) {
		int[] array = new int[count];
		getMiddleElementsUtil(array, beg, last, new AtomicInteger(0), root);
		return array;
	}

	private void getMiddleElementsUtil(int[] array, int beg, int last,
			AtomicInteger index, BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		if (root.getData() > beg && root.getData() < last) {
			array[index.getAndIncrement()] = root.getData();
		}
		if (root.getData() > beg) {
			getMiddleElementsUtil(array, beg, last, index, root.getLeft());
		}
		if (root.getData() < last) {
			getMiddleElementsUtil(array, beg, last, index, root.getRight());
		}

	}

	public void prune(int beg, int end) {
		root = prune(root, beg, end);
	}

	private BinaryTreeNode prune(BinaryTreeNode root, int beg, int end) {
		if (root == null) {
			return null;
		}
		if (root.getData() < beg) {
			return prune(root.getRight(), beg, end);
		} else if (root.getData() > end) {
			return prune(root.getLeft(), beg, end);
		} else {
			root.setLeft(prune(root.getLeft(), beg, end));
			root.setRight(prune(root.getRight(), beg, end));
			return root;
		}
	}
}
