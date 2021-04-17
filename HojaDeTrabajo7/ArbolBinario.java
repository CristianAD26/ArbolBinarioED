public class ArbolBinario<E extends Comparable<E>> {

    Nodo<E> root;


    private Nodo<E> addRecursive(Nodo<E> current, E value) {

        if (current == null) {
            return new Nodo<E>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.right = addRecursive(current.right, value);
        } else if (value.compareTo(current.getValue()) > 0) {
            current.left = addRecursive(current.left, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(E value) {
        root = addRecursive(root, value);
    }

    public Nodo<E> locateRecursive(Nodo<E> root, E value)
    {
        E rootValue = root.getValue();
        Nodo<E> child;

        // found at root: done
        if (rootValue.compareTo(value) == 0) return root;
        // look left if less-than, right if greater-than
        if (value.compareTo(rootValue) < 0)
        {
            child = root.right;
        } else {
            child = root.left;
        }
        // no child there: not in tree, return this node,
        // else keep searching
        if (child == null) {
            return null;
        } else {
            return locateRecursive(child, value);
        }
    }

    public Nodo<E> locate(E value){
        return locateRecursive(root, value);
    }

    private void printInorderRecursive(Nodo<E> node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorderRecursive(node.right);

        /* then print the data of node */
        System.out.print(node.getValue().toString());

        /* now recur on right child */
        printInorderRecursive(node.left);
    }

    public void printInorder(){
        printInorderRecursive(root);
    }

}
