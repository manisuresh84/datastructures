// Java program for deletion in AVL Tree

class DELETENODE
{
	int key, height;
	DELETENODE left, right;

	DELETENODE(int d)
	{
		key = d;
		height = 1;
	}
}

class AVLDeleteTree
{
	DELETENODE root;

	// A utility function to get height of the tree
	int height(DELETENODE N)
	{
		if (N == null)
			return 0;
		return N.height;
	}

	// A utility function to get maximum of two integers
	int max(int a, int b)
	{
		return (a > b) ? a : b;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	DELETENODE rightRotate(DELETENODE y)
	{
		DELETENODE x = y.left;
		DELETENODE T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	DELETENODE leftRotate(DELETENODE x)
	{
		DELETENODE y = x.right;
		DELETENODE T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	int getBalance(DELETENODE N)
	{
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}

	DELETENODE insert(DELETENODE node, int key)
	{
		/* 1. Perform the normal BST rotation */
		if (node == null)
			return (new DELETENODE(key));

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else // Equal keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left),
							height(node.right));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		Wunbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then
		// there are 4 cases Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key)
		{
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	/* Given a non-empty binary search tree, return the
	node with minimum key value found in that tree.
	Note that the entire tree does not need to be
	searched. */
	DELETENODE minValueNode(DELETENODE node)
	{
		DELETENODE current = node;

		/* loop down to find the leftmost leaf */
		while (current.left != null)
		current = current.left;

		return current;
	}

	DELETENODE deleteNode(DELETENODE root, int key)
	{
		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null)
			return root;

		// If the key to be deleted is smaller than
		// the root's key, then it lies in left subtree
		if (key < root.key)
			root.left = deleteNode(root.left, key);

		// If the key to be deleted is greater than the
		// root's key, then it lies in right subtree
		else if (key > root.key)
			root.right = deleteNode(root.right, key);

		// if key is same as root's key, then this is the node
		// to be deleted
		else
		{

			// node with only one child or no child
			if ((root.left == null) || (root.right == null))
			{
				DELETENODE temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				// No child case
				if (temp == null)
				{
					temp = root;
					root = null;
				}
				else // One child case
					root = temp; // Copy the contents of
								// the non-empty child
			}
			else
			{

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				DELETENODE temp = minValueNode(root.right);

				// Copy the inorder successor's data to this node
				root.key = temp.key;

				// Delete the inorder successor
				root.right = deleteNode(root.right, temp.key);
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = max(height(root.left), height(root.right)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.left) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.left) < 0)
		{
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.right) > 0)
		{
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	// A utility function to print preorder traversal of
	// the tree. The function also prints height of every
	// node
	void inOrder(DELETENODE node)
	{
		if (node != null)
		{
			inOrder(node.left);
			System.out.print(node.key + " ");			
			inOrder(node.right);
		}
	}

	public static void main(String[] args)
	{
		AVLDeleteTree tree = new AVLDeleteTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 0);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 11);
		tree.root = tree.insert(tree.root, -1);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 2);

		/* The constructed AVL Tree would be
		9
		/ \
		1 10
		/ \ \
		0 5 11
		/ / \
		-1 2 6
		*/
		System.out.println("Inorder traversal of "+
							"constructed tree is : ");
		tree.inOrder(tree.root);

		tree.root = tree.deleteNode(tree.root, 9);

		/* The AVL Tree after deletion of 10
		1
		/ \
		0 9
		/	 / \
		-1 5 11
		/ \
		2 6
		*/
		System.out.println("");
		System.out.println("Inorder traversal after "+
						"deletion of 10 :");
		tree.inOrder(tree.root);
	}
}

// Output
//Inorder traversal of constructed tree is : 
//-1 0 1 2 5 6 9 10 11 
//Inorder traversal after deletion of 10 :
//-1 0 1 2 5 6 10 11 
