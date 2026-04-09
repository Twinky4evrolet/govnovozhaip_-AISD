
public class TreeNode<T> {
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private TreeNode<T> parentNode;

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode(T data, TreeNode<T> parentNode) {
        this.data = data;
        this.parentNode = parentNode;
    }

    public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild, TreeNode<T> parentNode) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.parentNode = parentNode;
    }

    public T getValue() { return data; }
    public void setValue(T data) { this.data = data; }

    public TreeNode<T> getLeft() { return leftChild; }
    public void setLeft(TreeNode<T> leftChild) { this.leftChild = leftChild; }

    public TreeNode<T> getRight() { return rightChild; }
    public void setRight(TreeNode<T> rightChild) { this.rightChild = rightChild; }

    public TreeNode<T> getParent() { return parentNode; }
    public void setParent(TreeNode<T> parentNode) { this.parentNode = parentNode; }

    public boolean isLeafNode() {
        return this.leftChild == null && this.rightChild == null;
    }

    public boolean isRootNode() {
        return this.parentNode == null;
    }
}