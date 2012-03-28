package algo.datastructure.tree;

//import abc.Util;

public class FloorCeiling {
	private static BinaryTree createTree(int[] array) {
		BinaryTree tree = new BinaryTree();
		for (int i : array) {
			tree.add(i);
		}
		return tree;

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 5, 7, 8 };
		// System.out.println(createTree(array).floor(3).getData());
		BinaryTree temp = BinaryTree.getBinaryTreeFromSortedArray(array);
		System.out.println("inorder traversal = "
				+ BinaryTree.getBinaryTreeFromSortedArray(array));
		// System.out.println("Get Middle Element =");
		// Util.printArray(temp.getMiddleElements(0, 3));
		temp.prune(4, 9);
		System.out.println(temp);
	}

}
