public class Task4 {
    public static void main(String[] args) {
        Tree<Integer> bst = new Tree<>();
        int[] nodes = {5, 3, 7, 25};
        for (int val : nodes) {
            bst.add(val);
        }
        calculateSubtreeSums(bst.getRoot());
    }

    public static int calculateSubtreeSums(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSubtreeSums(node.getLeft());
        int rightSum = calculateSubtreeSums(node.getRight());

        int totalSum = leftSum + rightSum + node.getValue();
        System.out.println(totalSum);

        return totalSum;
    }
}