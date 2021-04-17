//Cristian Eduardo Aguirre Duarte
//Carne 20231
//Algoritmos y estructura de datos
//Hoja de trabajo 7

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

        if (rootValue.compareTo(value) == 0) return root;
        // izquierda si es menor, derecha si es mayor
        if (value.compareTo(rootValue) < 0)
        {
            child = root.right;
        } else {
            child = root.left;
        }
        // Ya que no hay mas hojasm devuleve el nodo, si no sigue buscando
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

        printArbol(node.right);

        System.out.print(node.getValue().toString());

        printArbol(node.left);
    }

    public void printInorder(){
        printArbol(root);
    }

}
