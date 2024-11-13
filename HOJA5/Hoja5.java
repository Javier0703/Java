import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class Hoja5{
    public static void main(String[] args){
        //H5E1();
        //H5E2();
        //H5E3();
        //H5E4();
        //H5E5();
        //H5E6();
        H5E7();
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

    /**
     * Diremos que un número n es raro cuando verifique que todo número entero
     * positivo m , menor que él y coprimo con él, es primo. Por ejemplo, el 9 no es
     * raro, porque en la lista (1, 2, 4, 5, 7 y 8) los hay compuestos. Pero el 8 sí es
     * raro2. Elaborar un programa Java que liste por pantalla todos los números raros  
     * existentes entre 3 y un valor introducido por el usuario (ambos inclusive).
     */
    public static void H5E6(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el valor máximo (n): ");
        int n = in.nextInt();
        System.out.println("Numeros raros:");
        for (int i=2; i<=n; i++)
            if (esRaro(i)) System.out.print(i + " ");
        in.close();
        //Un número n es raro si todos los enteros positivos m menores que n y coprimos con n 
        //(es decir, mcd(n, m) = 1) son primos.
    }

    public static boolean esRaro(int n) {
        for (int m = 1; m < n; m++) {
            //Si el mcd es 1 y no es primo no es un numero raro
            if (mcd(n, m) == 1 && !esPrimo(m)) {
                return false;
            }
        }
        return true;
    }

    public static int mcd(int n, int m){
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }

    //Metodo para saber si un numero es primo
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Elaborar un programa Java que lea un número n por teclado y escriba en
     * pantalla la distancia entre cada par de primos contiguos menores que n. Por
     * ejemplo, si el número introducido es 15, primos menores son: 1, 2, 3, 5, 7, 11 y
     * 13, que están a distancias: 1, 1, 2, 2, 4, 2, que es lo que debería mostrar el
     * programa.
     */
    public static void H5E7(){
        Scanner in = new Scanner(System.in);
        System.out.print("Introduce el valor máximo (n): ");
        int n = in.nextInt();
        in.close();
        //Generamos una lista con los primos
        ArrayList<Integer> primos = new ArrayList<>();
        for (int i=1; i<n; i++){
            if(esPrimo(i)) primos.add(i);
        }
        
        System.out.print("Distancia entre primos: ");
        for(int i = 1; i< primos.size(); i++){
            int dist = primos.get(i) - primos.get(i-1);
            System.out.print(dist + " ");
        }
    }

}