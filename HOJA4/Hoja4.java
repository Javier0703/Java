import java.util.Locale;
import java.util.Scanner;

public class Hoja4{

    public static void main(String[] args){
        //potenciasApartadoCD();
        //notaMinimaMaxima();
        //System.out.println(notaMedia12());
        //mediaMayorMenor();
        //metodoLothar();
        //int r = primerDivisorMayorQueUno(15); System.out.println(r);
        invertirYSumar();
    }
    /**
    *  Escriba un programa en Java que pida un número entero positivo (o nulo) al usuario y
    * escriba su raíz cuadrada, con las siguientes variaciones:
    * a) Si la entrada no es positiva, no debe producir salida.
    * b) Si la entrada no es positiva, debe mostrar un mensaje adecuado.
    * c) Si la entrada no es positiva, se vuelve a pedir las veces que sea necesario hasta
    * conseguirlo, y entonces se muestra su raíz cuadrada.
    * d) Lo mismo que en el caso anterior, pero recordando al usuario que el número debe ser
    * positivo todas las veces que la entrada sea negativa (si procede).
    * En cualquiera de las versiones, aceptaremos como válido que si el número de entrada no
    * es entero el programa se pare con error.
    */
    public static void potenciasApartadoCD(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print(" Escriba un numero positivo: ");
        int num = in.nextInt();
        while(num<0){
            System.out.print(" Error: Escriba un numero positivo: ");
            num = in.nextInt(); 
        }
        in.close();
        System.out.println("Raiz cuadrada: "+ num*num + ", raiz cubica: " + (int)Math.pow(num, 3) + ", raiz cuarta: " + (int)Math.pow(num, 3) + ", raiz quinta: " + (int)Math.pow(num, 5));
    }

    /**Escriba un programa que pida números entre 0 y 10, que se supone que son notas de un
    examen, y muestre en pantalla las notas máxima y mínima de la serie. Cada vez que el
    usuario escribe una nota, se le pregunta si quiere introducir más, con respuesta 1 si quiere
    introducir más u otro número si no. Suponga que el usuario escribe entradas correctas
    (entre 0 y 10). */
    public static void notaMinimaMaxima(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        int minima = Integer.MAX_VALUE; 
        int maxima = Integer.MIN_VALUE;
        int numero; int continuar;
        do{
            System.out.print("Esribe una nota (0-10): ");
            numero = in.nextInt();

            while(numero<0 || numero>10){
                System.out.print("Numero incorrecto (0-10):");
                numero = in.nextInt();
            }

            if (numero < minima){
                minima = numero;
            }
            if (numero > maxima){
                maxima = numero;
            }
            System.out.println("¿Desea introducir más notas? (1: Sí, otro número: No)");
            continuar = in.nextInt();
        }
        while(continuar == 1);  
        in.close();
        if (maxima == Integer.MIN_VALUE && minima == Integer.MAX_VALUE) {
            System.out.println("No se han ingresado notas.");
        } else {
            System.out.println("La nota mínima es: " + minima);
            System.out.println("La nota máxima es: " + maxima);
        }
    }

    /**Escriba un programa que pida 12 números entre 0 y 10, que se supone que son notas de un
    examen, y muestre en pantalla la nota media de la serie. Suponga que el usuario escribe
    entradas correctas (entre 0 y 10).
    */
    public static double notaMedia12(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        int nota;
        int notasRestantes = 12;
        float sumaTotal = 0;
        do{
            System.out.print("Escriba la nota (0-10): ");
            nota = in.nextInt();
            while(nota<0 || nota>10){
                System.out.print("Error: Escriba la nota (0-10): ");
                nota = in.nextInt();
            }
            notasRestantes--;
            sumaTotal += nota;
        }
        while(notasRestantes>0);
        in.close();
        return sumaTotal/12;
    }
    
    /**Escriba un programa que pida enteros al usuario hasta que el número introducido sea un 0,
    y escriba en pantalla su suma, la cantidad de números leídos, su media y el menor y el
    mayor de ellos (todo ello sin considerar el 0)
    */
    public static void mediaMayorMenor(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        float sumaTotal = 0f;
        int numeros = 0;
        int minimo = Integer.MAX_VALUE;
        int maximo = Integer.MIN_VALUE;
        int numero;
        do{
            System.out.print("Numero entero positivo: ");
            numero = in.nextInt();
            while (numero<0){
                System.out.print("Error: Numero entero positivo: ");
                numero = in.nextInt();
            }
            if (numero != 0){
                numeros++;
                sumaTotal += numero;
                if (numero<minimo){
                    minimo = numero;
                }
                if(numero>maximo){
                    maximo = numero;
                }
            }
        }
        while(numero !=0);
        in.close();
        System.out.println("Media: "+ (sumaTotal/numeros) + ". Minimo " + minimo + " Maximo " + maximo);
    }

    /**
     * Tomemos un entero mayor que 1. Si es par, lo dividimos por 2. Si es impar, lo
    multiplicamos por 3 y le sumamos 1. Con el resultado volvemos a hacer lo mismo.
    Obtendremos así una sucesión de números. Sólo detendremos el proceso cuando aparezca
    el 1. (Por ejemplo: 6, 3, 10, 5, 16, 8, 4, 2, 1). El matemático Lothar Collatz conjeturó en
    1937 que para cualquier número siempre pararemos (aparecerá un 1), pero todavía no se
    ha podido demostrar ni refutar tal conjetura1
    .Escriba un programa Java que lea un número
    entero mayor que 1 y muestre en pantalla la sucesión asociada, así como la longitud de la
    secuencia. Supóngase que ningún cálculo va a provocar desbordamiento.
     */

    public static void metodoLothar(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Escriba un entero mayor que 0: ");
        int numero = in.nextInt();
        while(numero<1){
            System.out.print("Error: Escriba un entero mayor que 0: ");
            numero = in.nextInt();
        }

        if (numero == 1){
            System.out.println("1");
        }

        else{
            String cadena = "";
            while(numero!=1){
                if (numero%2 == 0){
                    numero/=2;
                    cadena += (numero + ",");
                }
                else{
                    numero = numero*3 + 1;
                    cadena += (numero + ",");
                }
            }
            System.out.println(cadena.substring(0, cadena.length() - 1));
            in.close();
        }
    }

    /**
     * Escriba una funcion Java que devuelva el primer divisor mayor que 1 de un entero
    positivo. Utilice esta función en un programa Java que escriba en pantalla los factores
    primos de un número entero positivo.
     */

    public static int primerDivisorMayorQueUno(int num){
        if(num<=1){
            return -1;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return i; 
            }
        }
        return (num > 1) ? num : -1;
    }

    /**
     * Escriba un programa Java que lea un entero positivo de teclado y escriba en pantalla el
    número resultante de invertir el orden de sus cifras y la suma de ambos. Por ejemplo, para
    7890, escribirá 987 y 8877.
     */
    public static void invertirYSumar() {
        Scanner in = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese un número entero positivo: ");
        numero = in.nextInt();
        while (numero <= 0) {
            System.out.print("Error: Debe ingresar un número entero positivo. Intente de nuevo: ");
            numero = in.nextInt();
        }
        int numeroInvertido = invertirNumero(numero);
        int suma = numero + numeroInvertido;
        System.out.println("Número invertido: " + numeroInvertido);
        System.out.println("Suma: " + suma);
        in.close();
    }

    public static int invertirNumero(int numero) {
        int invertido = 0;
        while (numero > 0) {
            int digito = numero % 10;
            invertido = invertido * 10 + digito;
            numero /= 10;
        }
        return invertido;
    }
}