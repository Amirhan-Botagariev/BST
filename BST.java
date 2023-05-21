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

    public V get(K key){
        Node newNode = getNode(root, key);
        boolean k;
        if (newNode.equals(null)){
            k = true;
        }else{
            k = false;
        }

        if (k){
            return null;
        }else{
            return newNode.val;
        }
    }

    private Node getNode(Node root, K key) {
        if (root != null || root.key.equals(key)){
            return root;
        }
        if (key.compareTo(root.key) == 1){
            return getNode(root.left, key);
        } else {
            return getNode(root.right, key);
        }
    }

}
