public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int height;

    public int getHeightNoCalculating(){
        return this.height;
    }

    public Tree() {
        this.root = null;
        this.height = 0;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
        updateHeight();
    }

    public int getHeight() {
        return calculateHeight(this.root);
    }

    private int calculateHeight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void updateHeight() {
        this.height = calculateHeight(this.root);
    }



    public void add(T value) {
        TreeNode<T> node = new TreeNode<>(value);

        if (this.root == null) {
            this.root = node;
        } else {
            add(this.root, value);
        }
        updateHeight();
    }

    private void add(TreeNode<T> current, T value) {
        if (current.getValue().compareTo(value) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode<>(value));
            } else {
                add(current.getLeft(), value);
            }
        } else if (current.getValue().compareTo(value) <= 0) {
            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(value));
            } else {
                add(current.getRight(), value);
            }
        }
    }

    public void preOrderTraversal() {
        System.out.print("Pre-order: ");
        preOrderTraversal(this.root);
        System.out.println();
    }

    private void preOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void inOrderTraversal() {
        System.out.print("In-order: ");
        inOrderTraversal(this.root);
        System.out.println();
    }

    private void inOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        System.out.print("Post-order: ");
        postOrderTraversal(this.root);
        System.out.println();
    }

    private void postOrderTraversal(TreeNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}