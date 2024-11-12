package luckycolors;

public class Stack<E> {
    int maxsize = 4;
    E pila[];
    int tope;

    public Stack() {
        tope = -1;
        pila = (E[]) new Object[maxsize];
    }

    public E push(E dato) {
        if (isFull()) {
            throw new RuntimeException("Pila Llena");
        } else {
            return pila[++tope] = dato;
        }
    }

    public E pop(){
        if (isEmpty()) {
            throw new RuntimeException("Pila Vacia");
        } else {
            return pila[tope--];
        }
    }

    public boolean isFull() {
        return tope == maxsize - 1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila Vacia");
        } else {
            return pila[tope];
        }
    }
    
    public E getColorAt(int i){
        return pila[i];
    }
}
