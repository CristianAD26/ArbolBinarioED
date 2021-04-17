public class ArbolBinario<E extends Comparable<E>> {

    Nodo<E> root;


    private Nodo<E> Agregar(Nodo<E> current, E value) {

        if (current == null) {
            return new Nodo<E>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.right = Agregar(current.right, value);
        } else if (value.compareTo(current.getValue()) > 0) {
            current.left = Agregar(current.left, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(E value) {
        root = Agregar(root, value);
    }

    public Nodo<E> InOrder(Nodo<E> root, E value)
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
            return InOrder(child, value);
        }
    }

    public Nodo<E> locate(E value){
        return InOrder(root, value);
    }

    private void printArbol(Nodo<E> node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printArbol(node.right);

        /* then print the data of node */
        System.out.print(node.getValue().toString());

        /* now recur on right child */
        printArbol(node.left);
    }

    public void printInorder(){
        printArbol(root);
    }

}
