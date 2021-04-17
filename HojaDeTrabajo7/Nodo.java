public class Nodo<E>{
    E value;
    Nodo<E> left;
    Nodo<E> right;

    Nodo(E value) {
        this.value = value;
        right = null;
        left = null;
    }

    public E getValue(){
        return value;
    }
}