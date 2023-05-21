public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size = 0;

    public void put(K key, V val){
        this.root = addIntoNode(root, key, val);
        size++;
    }

    private Node addIntoNode(Node root, K key, V val) {
        if (root == null){
            return new Node(key, val);
        }
        if (root.key.compareTo(key) == 1){
            root.left = addIntoNode(root.left, key, val);
        } else if (root.key.compareTo(key) == -1){
            root.right = addIntoNode(root.right, key, val);
        } else {
            root.val = val;
        }
        return root;
    }
}
