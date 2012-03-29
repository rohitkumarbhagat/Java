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
			}
			else
			{
				// add data to right tree
				root.setRight(add(root.getRight(), data));
			}

			// Check AVL Tree property
			root.refreshHeight();
			if (!root.isAVLTreeNode())
			{
				// Check where node has been added for sungle or double rotation
				
			}
		}
		// Return the modifed root if any
		return root;
	}
}
