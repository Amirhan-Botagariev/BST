import java.util.ArrayList;

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

        @Override
        public String toString() {
            return  "{key= " + key +
                    ", val= " + val +
                    '}';
        }
    }

    private int size = 0;

    public int getSize() {
        return size;
    }

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

    public void delete(K key){
        this.root = deleteNode(root, key);
        size--;
    }

    private Node deleteNode(Node root, K key) {
        if (root == null){
            return null;
        }
        if (key.compareTo(root.key) == 1){
            root.left = deleteNode(root.left, key);
        } else if (key.compareTo(root.key) == -1){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null){
                return null;
            } else if (root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else {
                Node min = findMin(root);
                root.val = min.val;
                root.key = min.key;
                root.right = deleteNode(root.right, min.key);
            }
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public Iterable<Node> iterator(){
        return (Iterable)inOrderTraversal(new ArrayList<>(), root);
    }

    private ArrayList<Node> inOrderTraversal(ArrayList objects, Node root) {
        if (root == null){
            return null;
        }
        if (root.left != null){
            objects.add(inOrderTraversal(objects, root.left));
        }
        objects.add(root);
        if (root.right != null){
            objects.add(inOrderTraversal(objects, root.right));
        }
        return objects;
    }

    public boolean contains(V val1){
        Node res = contains_work(val1, root);
        return res.val == val1;
    }
    private Node contains_work(V val1, Node root){
        if (root == null){
            return null;
        }
        if (root.left != null){
            if (root.left.val == val1){
                return root.left;
            }
            return contains_work(val1, root.left);
        }
        if (root.right != null){
            if (root.right.val == val1){
                return root.right;
            }
            return contains_work(val1, root.right);
        }
        return null;
    }
}
