public class Tree<T extends Comparable<T>> {
    private TreeNode<T> rootNode;
    private int treeHeight;

    public Tree() {
        this.rootNode = null;
        this.treeHeight = 0;
    }

    public Tree(TreeNode<T> root) {
        this.rootNode = root;
        this.treeHeight = computeDepth(root);
    }

    public TreeNode<T> getRoot() { return rootNode; }
    public int getHeight() { return treeHeight; }

    public void add(T value) {
        if (rootNode == null) {
            rootNode = new TreeNode<>(value);
        } else {
            insertRecursive(rootNode, value);
        }
        treeHeight = computeDepth(rootNode);
    }

    private void insertRecursive(TreeNode<T> current, T value) {
        if (current.getValue().compareTo(value) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(value, current));
            } else {
                insertRecursive(current.getLeft(), value);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(value, current));
            } else {
                insertRecursive(current.getRight(), value);
            }
        }
    }

    public TreeNode<T> get(T value) {
        return searchRecursive(rootNode, value);
    }

    private TreeNode<T> searchRecursive(TreeNode<T> node, T value) {
        if (node == null) return null;
        int match = node.getValue().compareTo(value);
        if (match == 0) return node;
        return match > 0 ? searchRecursive(node.getLeft(), value) : searchRecursive(node.getRight(), value);
    }

    public void remove(T value) {
        TreeNode<T> target = get(value);
        if (target != null) {
            deleteNode(target);
            treeHeight = computeDepth(rootNode);
        }
    }

    private void deleteNode(TreeNode<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            if (node.isRootNode()) {
                rootNode = null;
            } else {
                disconnectFromParent(node, null);
            }
            return;
        }

        if (node.getLeft() == null || node.getRight() == null) {
            TreeNode<T> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            if (node.isRootNode()) {
                rootNode = child;
                child.setParent(null);
            } else {
                disconnectFromParent(node, child);
            }
            return;
        }

        TreeNode<T> replacement = node.getRight();
        while (replacement.getLeft() != null) {
            replacement = replacement.getLeft();
        }
        T replacementValue = replacement.getValue();
        deleteNode(replacement);
        node.setValue(replacementValue);
    }

    private void disconnectFromParent(TreeNode<T> oldNode, TreeNode<T> newNode) {
        TreeNode<T> parent = oldNode.getParent();
        if (parent.getLeft() == oldNode) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
        if (newNode != null) {
            newNode.setParent(parent);
        }
        oldNode.setParent(null);
    }

    private int computeDepth(TreeNode<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(computeDepth(node.getLeft()), computeDepth(node.getRight()));
    }

    public void preOrder() { preOrder(rootNode); }
    public void postOrder() { postOrder(rootNode); }
    public void inOrder() { inOrder(rootNode); }

    public void preOrder(TreeNode<T> node) {
        if (node == null) return;
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder(TreeNode<T> node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
    }

    public void postOrder(TreeNode<T> node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }
}