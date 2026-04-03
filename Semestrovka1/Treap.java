public class Treap {
    private Node root;

    private NodePair split(Node node, int key) {
        if (node == null) return new NodePair(null, null);

        if (node.key < key) {
            NodePair pair = split(node.right, key);
            node.right = pair.left;
            return new NodePair(node, pair.right);
        } else {
            NodePair pair = split(node.left, key);
            node.left = pair.right;
            return new NodePair(pair.left, node);
        }
    }

    private Node merge(Node l, Node r) {
        if (l == null) return r;
        if (r == null) return l;

        if (l.priority > r.priority) {
            l.right = merge(l.right, r);
            return l;
        } else {
            r.left = merge(l, r.left);
            return r;
        }
    }

    public void insert(int key) {
        NodePair pair = split(root, key);
        Node newNode = new Node(key);
        root = merge(merge(pair.left, newNode), pair.right);
    }

    public void delete(int key) {
        NodePair p1 = split(root, key);
        NodePair p2 = split(p1.right, key + 1);
        root = merge(p1.left, p2.right);
    }

    public boolean contains(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) return true;
            current = (key < current.key) ? current.left : current.right;
        }
        return false;
    }

    public void display() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.key + " ");
            printInOrder(node.right);
        }
    }
}