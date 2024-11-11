import java.util.Scanner; 
import java.util.Locale;

public class Hoja5{
    public static void main(String[] args){
        //H5E1();
        //H5E2();
        //H5E3();
        //H5E4();
        H5E5();
    }

    /**
     * Elabore un programa Java que imprima la figura de un triángulo rectángulo
     * ajustada a la derecha, formada por asteriscos. El lado del triángulo se lee como
     * dato. Ahora cada línea tendrá una serie de espacios en blanco antes de los
     * asteriscos.
     */
    public static void H5E1(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el tamaño del triángulo: ");
        int n = in.nextInt();

        // Generar el triángulo rectángulo alineado a la derecha
        for (int i = 1; i <= n; i++) {
            // Imprimir espacios en blanco antes de los asteriscos
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        in.close();
    }

    /**
     * Elabore un programa Java para imprimir el triángulo de Floyd con un número
     * dado de filas completas. El triángulo contiene los números naturales
     * correlativos, uno en la primera línea, dos en la segunda, etc.; es decir, en la fila
     * n-sima aparecen n valores.
     */
    public static void H5E2(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Numro de filas complestas: ");
        int filas = in.nextInt();
        int numero = 1;
        in.close();
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(numero + " ");
                numero++;
            }
            System.out.println();
        }  
    }

    /**
     * Elabore un programa Java que imprima el triángulo de Floyd hasta un valor dado
     */
    public static void H5E3(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el número límite: ");
        int limite = in.nextInt();
        int numero = 1;
        int fila = 1;
        while (numero <= limite) {
            for (int i = 1; i <= fila; i++) {
                if (numero > limite) break;
                System.out.print(numero + " ");
                numero++;
            }
            fila++;
            System.out.println();
        }
        in.close();
    }

    /**
     * Elabore un programa Java que lea por teclado un número n entero positivo y
     * presente por pantalla un triángulo de n filas que responda al siguiente esquema:
     */
    public static void H5E4(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el número de filas: ");
        int filas = in.nextInt();
        for (int i = 1; i <= filas; i++) {
            // Imprimir espacios para centrar la fila
            for (int j = 0; j < filas - i; j++) {
                System.out.print("  ");
            }
            // Parte creciente del patrón
            int numero = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(numero % 10 + " ");
                numero++;
            }
            // Parte decreciente del patrón
            numero -= 2;
            for (int j = 1; j < i; j++) {
                System.out.print(numero % 10 + " ");
                numero--;
            }
            // Salto de línea al final de cada fila
            System.out.println();
        }
        in.close();
    }

    /**
     * Dado un número positivo n se define la función de Euler relativa a n como el
     * número de enteros positivos inferiores a n que son coprimos con n (dos
     * números son "coprimos1
     * " o "primos entre sí" cuando no tienen más divisor
     * común que la unidad; es decir, el máximo común divisor de ambos números es
     * 1). Por ejemplo la función de Euler de 9 es 6, porque los inferiores a 9 coprimos
     * con 9 son 6 (a saber: 1, 2, 4, 5, 7 y 8). Elaborar un programa Java que 
     * implemente la función de Euler relativa a cualquier número entero mayor que 1.
     */
    public static void H5E5(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce un número entero mayor que 1: ");
        int n = in.nextInt();
        if (n <= 1) {
            System.out.println("El número debe ser mayor que 1.");
        } else {
            int resultado = funcionEuler(n);
            System.out.println("La función de Euler Phi("+n+") es: " + resultado);
        }
        in.close();
    }

    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int funcionEuler(int n) {
        int contador = 0;
        for (int i = 1; i < n; i++) {
            if (calcularMCD(i, n) == 1) {
                contador++;
            }
        }
        return contador;
    }
}