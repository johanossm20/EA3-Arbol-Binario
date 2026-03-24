import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
    }
}

class ArbolBinario {

    Nodo raiz;

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        } else {
            raiz.derecho = insertarRec(raiz.derecho, valor);
        }

        return raiz;
    }

    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo raiz) {
        if (raiz != null) {
            inordenRec(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inordenRec(raiz.derecho);
        }
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) return false;

        if (raiz.valor == valor) return true;

        if (valor < raiz.valor) {
            return buscarRec(raiz.izquierdo, valor);
        } else {
            return buscarRec(raiz.derecho, valor);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        int opcion;

        do {
            System.out.println("\n=== ÁRBOL BINARIO ===");
            System.out.println("1. Insertar número");
            System.out.println("2. Mostrar inorden");
            System.out.println("3. Buscar número");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Número: ");
                    int valor = sc.nextInt();
                    arbol.insertar(valor);
                    break;

                case 2:
                    System.out.print("Inorden: ");
                    arbol.inorden();
                    break;

                case 3:
                    System.out.print("Buscar: ");
                    int buscar = sc.nextInt();

                    if (arbol.buscar(buscar)) {
                        System.out.println("Número encontrado");
                    } else {
                        System.out.println("Número NO existe");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}