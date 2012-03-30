/**
 * 
 */
package algo.datastructure.tree;

/**
 * @author erotkur
 * 
 */
public class AVLTree
{
	private AvlTreeNode root;

	public AvlTreeNode getRoot()
	{
		return root;
	}

	public void setRoot(AvlTreeNode root)
	{
		this.root = root;
	}

	public void add(int data)
	{
		root = add(root, data);
	}

	private AvlTreeNode add(AvlTreeNode root, int data)
	{
		if (root == null)
		{
			root = new AvlTreeNode(0, data, null, null);

		}
		else
		{
			if (root.getData() > data)
			{
				// add data to left tree

				root.setLeft(add(root.getLeft(), data));
				int leftData = root.getLeft().getData();
				root.refreshHeight();
				if (!root.isAVLTreeNode())
				{
					if (data < leftData)
					{
						// added to left of left
						root = rotateRight(root);

					}
					else
					{
						// added to right of left
						root = rotateLeftRight(root);
					}
				}
			}
			else
			{
				// add data to right tree
				root.setRight(add(root.getRight(), data));
				int rightData = root.getRight().getData();
				root.refreshHeight();
				// root.refreshHeight();
				if (!root.isAVLTreeNode())
				{
					if (data > rightData)
					{
						// added to right of right
						root = rotateLeft(root);

					}
					else
					{
						// added to right of left
						root = rotateRightLeft(root);
					}
				}
			}

		}
		// Return the modifed root if any
		return root;
	}

	private AvlTreeNode rotateRight(AvlTreeNode root)
	{
		if (root == null || root.getLeft() == null)
		{
			// Not possible in this case
			return null;
		}
		AvlTreeNode leftNode = root.getLeft();
		root.setLeft(leftNode.getRight());
		// old root refresh height
		root.refreshHeight();
		leftNode.setRight(root);
		// new root height
		root = leftNode;
		// Adjust heights
		root.refreshHeight();

		return root;

	}

	private AvlTreeNode rotateLeft(AvlTreeNode root)
	{
		if (root == null || root.getRight() == null)
		{
			// Not possible
			return null;
		}
		AvlTreeNode rightNode = root.getRight();
		root.setRight(rightNode.getLeft());
		root.refreshHeight();

		rightNode.setLeft(root);
		root = rightNode;
		root.refreshHeight();
		return root;
	}

	private AvlTreeNode rotateRightLeft(AvlTreeNode root)
	{
		if (root == null || root.getRight() == null || root.getRight().getLeft() == null)
		{
			return null;
		}
		AvlTreeNode afterRightRotate = rotateRight(root.getRight());
		root.setRight(afterRightRotate);
		root.refreshHeight();

		AvlTreeNode afterLeftRotate = rotateLeft(root);
		root = afterLeftRotate;
		root.refreshHeight();

		return root;
	}

	private AvlTreeNode rotateLeftRight(AvlTreeNode root)
	{
		if (root == null || root.getLeft() == null || root.getLeft().getRight() == null)
		{
			return null;
		}
		AvlTreeNode afterLeftRotate = rotateLeft(root.getLeft());
		root.setLeft(afterLeftRotate);
		root.refreshHeight();

		AvlTreeNode afterRightRotate = rotateRight(root);
		root = afterRightRotate;
		root.refreshHeight();

		return root;
	}

	public void remove(int data)
	{
		root = remove(root, data);

	}

	private AvlTreeNode remove(AvlTreeNode root, int data)
	{
		if (root == null)
		{
			return null;
		}

		// Check if it is the node for deletion

		if (data < root.getData())
		{
			// remove from left node
			root.setLeft(remove(root.getLeft(), data));
			root.refreshHeight();
			// check Avl property
			if (!root.isAVLTreeNode())
			{
				// similar to adding new element on right hand node
				int rightChildLeftTreeHeigh = root.getRight().getLeft() != null ? root.getRight().getLeft().getHeight()
						: -1;
				int rightChildRightTreeHeigh = root.getRight().getRight() != null ? root.getRight().getRight()
						.getHeight() : -1;

				if (rightChildLeftTreeHeigh > rightChildRightTreeHeigh)
				{
					// inserted in left of right child
					root = rotateRightLeft(root);
				}
				else
				{
					// inserted in right of right child
					root = rotateLeft(root);
				}
			}
		}
		else if (data > root.getData())
		{
			// remove from right node
			root.setRight(remove(root.getRight(), data));

			root.refreshHeight();
			// check Avl property
			if (!root.isAVLTreeNode())
			{
				// similar to adding new element on right hand node
				int leftChildRightTreeHeight = root.getLeft().getRight() != null ? root.getLeft().getRight()
						.getHeight() : -1;
				int leftChildLeftTreeHeight = root.getLeft().getLeft() != null ? root.getLeft().getLeft().getHeight()
						: -1;

				if (leftChildRightTreeHeight > leftChildLeftTreeHeight)
				{
					// inserted in right of left child
					root = rotateLeftRight(root);
				}
				else
				{
					// inserted in left of left child
					root = rotateRight(root);
				}
			}
		}
		else
		{
			// This is the node to delete
			if (root.getLeft() != null && root.getRight() != null)
			{
				// find max element in left subtree
				AvlTreeNode maxNode = getMaximum(root.getLeft());
				// remove this node from left node and set new left node
				root.setLeft(remove(root.getLeft(), maxNode.getData()));

				maxNode.setLeft(root.getLeft());
				maxNode.setRight(root.getRight());
				root = maxNode;
				root.refreshHeight();

			}
			else
			{
				if (root.getLeft() != null)
				{
					root = root.getLeft();
				}
				else
				{
					root = root.getRight();
				}
			}
		}
		return root;
	}

	private AvlTreeNode getMaximum(AvlTreeNode root)
	{

		if (root == null)
			return null;
		AvlTreeNode maxNode = root;
		while (maxNode.getRight() != null)
		{
			maxNode = maxNode.getRight();
		}
		return maxNode;
	}
}
