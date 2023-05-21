public class Main {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        for (int i = 0; i < 10; i++){
            bst.put(i, i);
        }

        Iterable iterable = bst.iterator();

        for (Object el : iterable){
            System.out.println(el);
        }
    }
}