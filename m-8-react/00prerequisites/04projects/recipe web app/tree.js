class TreeNode {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    constructor() {
        this.root = null; // Initialize the root of the BST
    }

    insert(root, element) {
        if (root === null) {
            return new TreeNode(element);
        } else {
            if (element < root.data) {
                root.left = this.insert(root.left, element);
            } else if (element > root.data) {
                root.right = this.insert(root.right, element);
            }
        }
        return root;
    }

    inOrder(root) {
        if (root !== null) {
            this.inOrder(root.left);
            console.log(+root.data);
            this.inOrder(root.right);
        }
    }
}

// Initialize the BST
let bst = new BST();

// Insert elements into the BST
for (let i = 0; i < 5; i++) {
    let element = parseInt(prompt("Enter node value"));
    bst.root = bst.insert(bst.root, element); // Update this.root directly
}

// Perform in-order traversal
bst.inOrder(bst.root);
