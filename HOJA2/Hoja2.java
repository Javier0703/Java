import java.util.*;

public class Hoja2 {
    public static void main(String[] args){
        //secToHour();
        //interes();
        //inverso();
        //billeteMonedas();
        //grados();
        //producto();
        //comprobacion();
        //vueltas();
        //cuadrante();
        radianes();
    }

    //Escribir un programa Java que muestre en pantalla la hora actual en el
    //formato horas:minutos:segundos tomando como entrada el número de
    //segundos que han transcurrido desde las doce de la noche de ayer.
    public static void secToHour() {
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba los segundos: ");
        int time = in.nextInt();
        System.out.println(time/3600 + ":" + (time%3600)/60 + ":" + (time%3600)%60);
        in.close();
    }

    //. Escribir un programa Java que muestre en pantalla el beneficio de un
    //depósito (número entero) a un cierto interés. La cantidad del depósito
    //(número entero) y la tasa de interés se leerán como entradas.   
    public static void interes() {
        Scanner in = new Scanner(System.in);
        System.out.print("Dinero: ");
        int dinero = in.nextInt();
        System.out.print("Porcentaje (XX,X): ");
        float porcentaje = in.nextFloat();
        System.out.println("Interes de: " + dinero*(porcentaje/100));
        in.close();
    }

    //Escribir un programa Java que escriba en pantalla el doble del número
    //obtenido invirtiendo el orden de las cifras del de entrada, siendo este positivo
    //y de 3 cifras. (Ejemplo: para 123, escribirá 642).
    public static void inverso(){
        Scanner in = new Scanner(System.in);
        System.out.print("Numero de 3 cifras: ");
        int numero = in.nextInt();
        if (numero>999 || numero<100){
            System.out.println("Numero invalido");
        }
        else{
            while (numero != 0) { 
                System.out.print(numero % 10); 
                numero /= 10; 
            }
            System.err.println();
        }
        in.close();
    }

    //Escribir un programa Java que muestre en pantalla el número mínimo de
    //billetes y monedas en que podrían descomponerse una cantidad entera de
    //euros.
    public static void billeteMonedas(){
        Scanner in = new Scanner(System.in);
        System.out.print("Dinero en total (entero): ");
        int dinero = in.nextInt();
        int[] valores = {500,200,100,50,20,10,5,2,1};
        int total = 0;
        for (int valor: valores){
            int cantidad = dinero/valor;
            dinero -= cantidad * valor;
            total += cantidad;
        }
        System.out.println("Billetes y monedas: " + total);
        in.close();
    }
    
    //Escribir un programa Java que calcule el valor de la suma de dos ángulos
    //expresados como 3 enteros que representan grados, minutos y segundos,
    //expresada de la misma manera (los grados en [0, 360)).
    public static void grados(){
        Scanner in = new Scanner(System.in);
        System.out.print("Primer numero (escribir asi 20 30 45): ");
        int ag1[] = leerAngulo(in);

        System.out.print("Segundo numero (escribir asi 20 30 45): ");
        int ag2[] = leerAngulo(in);

        int gr = 0;
        int min = 0;
        int sec = ag1[2] + ag2[2];
        if (sec>=60){
            sec%=60;
            min++;
        }
        min += (ag1[1] + ag2[1]);
        if (min>=60){
            min%=60;
            gr++;
        }
        gr += (ag1[0] + ag2[0])%360;
        System.out.println(gr +"º " + min +"' " + sec + "''");
        in.close();
    }

    private static int[] leerAngulo(Scanner in) {
        String[] entrada = in.nextLine().split(" ");
        int grados = Integer.parseInt(entrada[0]);
        int minutos = Integer.parseInt(entrada[1]);
        int segundos = Integer.parseInt(entrada[2]);
        return new int[] { grados, minutos, segundos };
    }
    
    //Escribir un programa en Java que muestre el producto de un número de
    //tres cifras (multiplicando) y otro de dos (multiplicador), mostrando los
    //resultados parciales que suelen obtenerse cuando se hace la
    //multiplicación a mano.
    public static void producto(){
        //Comprobamos los numeros
        Scanner in = new Scanner(System.in);
        System.out.print("Multiplicando de 3 digitos: ");
        int multiplicando = in.nextInt();
        System.out.print("Multiplicador de 2 digitos: ");
        int multiplicador = in.nextInt();
        in.close();
        int n1 = (multiplicador/10)*10;
        int n2 =  multiplicador%10;
        System.out.println(multiplicando + " x " + multiplicador + "\n=");
        System.out.println("    " + multiplicando + " x " + n1);
        System.out.println("  + " + multiplicando + " x " + n2 + "\n=");
        System.err.println("    " + multiplicando* n1);
        System.err.println("  + " + multiplicando*n2+"\n=");
        System.err.println("    " + (multiplicando*n1+ multiplicando*n2));
    }

    //Escribir un programa que calcule la diferencia entre las expresiones Java
    //a*b/c y a*(b/c) siendo a, b y c entradas de tipo entero
    public static void comprobacion(){
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba el valor de la A: ");
        int a = in.nextInt();
        System.out.print("Escriba el valor de la B: ");
        int b = in.nextInt();
        System.out.print("Escriba el valor de la C: ");
        int c = in.nextInt();
        while (c == 0) {
            System.out.print("C no puede ser 0. Escribe uno distinto: ");
            c = in.nextInt();
        }
        in.close();
        System.out.println("Primera ecuacion a*b/c : " +  a*b/c);
        System.out.println("Segunda ecuacion: a*(b/c) " + a*(b/c));
    }

    //Escribir un programa Java que muestre en pantalla el número de vueltas de
    //un ángulo dado en grados.
    public static void vueltas(){
        Scanner in = new Scanner(System.in);
        System.out.print("Escriba el valor del angulo: ");
        int angulo = in.nextInt();
        in.close();
        System.out.println("Vueltas: " + angulo/360 + ". Resultante: " + angulo%360 +"º ");
    }

    //Escribir un programa Java que muestre en pantalla el cuadrante (1, 2, 3 o 4)
    //que alcanza un ángulo dado en grados.
    public static void cuadrante(){
        Scanner in = new Scanner(System.in);
        System.out.print("Angulo: ");
        int angulo = in.nextInt();
        angulo %= 360;
        in.close();
        String cuadrante = "";
        if (angulo>=270){
            cuadrante = "Cuarto";
        }
        else if(angulo<=90){
            cuadrante = "Primer";
        }
        else if(angulo>90 && angulo <= 180){
            cuadrante = "Segundo";
        }
        else{
            cuadrante= "Tercer";
        }
        System.out.println(cuadrante + " cuadrante");
    }

    //Escribir un programa Java que muestre en pantalla el equivalente en radianes
    //del ángulo dado en grados.
    public static void radianes(){
        Scanner in = new Scanner(System.in);
        System.out.print("Angulo para pasar a radianes: ");
        int grados = in.nextInt();
        in.close();
        System.out.println("En Radianes (Empleando una funcion Math): " + Math.toRadians(grados));
        System.out.println("Emplenado la formula a mano (" + grados + " x PI/180) = " + (grados/180.0) + "PI");
    }
}

