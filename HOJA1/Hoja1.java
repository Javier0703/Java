public class Hoja1 {
    public static void main (String[] args){
        secToHour(75936);
        interes(234000,4.5f);
        inverso(753);
        billeteMonedas(7532);
        int[] ag1 = {134,27,45};
        int[] ag2 = {345, 52, 21};
        grados(ag1,ag2);
        producto(739,12);
        comprobacion(7,5,3);
        vueltas(34567);
        cuadrante(68931);
        radianes(90);
    }

    //Escribir un programa Java que muestre en pantalla la hora actual en el
    //formato horas:minutos:segundos sabiendo que han transcurrido 75936
    //segundos desde las doce de la noche de ayer.
    public static void secToHour(int time) {
        System.out.println(time/3600 + ":" + (time%3600)/60 + ":" + (time%3600)%60);
    }

    //Escribir un programa Java que calcule el interés de un depósito de 234.000€
    //al 4.5% y lo muestre en pantalla. 
    public static void interes(int dinero, float porcentaje) {
        System.out.println("Interes de: " + dinero*(porcentaje/100));
    }

    //Escribir un programa Java que escriba en pantalla las cifras del número 753
    //en orden inverso.
    public static void inverso(int numero){
        while (numero != 0) { 
            System.out.print(numero % 10); 
            numero /= 10; 
        }
        System.err.println();
    }

    //Escribir un programa Java que muestre en pantalla el número mínimo de
    //billetes y monedas en que podrían descomponerse 7.532€.
    public static void billeteMonedas(int dinero){
        int[] valores = {500,200,100,50,20,10,5,2,1};
        int total = 0;
        for (int valor: valores){
            int cantidad = dinero/valor;
            dinero -= cantidad * valor;
            total += cantidad;
        }
        System.out.println("Billetes y monedas: " + total);
    }

    //Escribir un programa Java que obtenga el valor de la suma de los ángulos
    //134º 27’ 45’’ y 345º 52’ 21’’ expresado también en grados (en [0, 360) ),
    //minutos y segundos.
    public static void grados(int[] ag1, int[] ag2){
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
    }

    //Escribir un programa en Java que muestre el producto del número 739
    //(multiplicando de tres cifras) y el 12 (multiplicador de dos cifras), mostrando
    //los resultados parciales que suelen obtenerse cuando se hace la
    //multiplicación a mano, de forma que en pantalla debe aparecer:
    public static void producto(int mltnd, int mltpcdr){
        //Suponemos que los numeros estan bien, si no habría que compreobar
        int n1 = (mltpcdr/10)*10;
        int n2 =  mltpcdr%10;
        System.out.println(mltnd + " x " + mltpcdr + "\n=");
        System.out.println("    " + mltnd + " x " + n1);
        System.out.println("  + " + mltnd + " x " + n2 + "\n=");
        System.err.println("    " + mltnd* n1);
        System.err.println("  + " + mltnd*n2+"\n=");
        System.err.println("    " + (mltnd*n1+ mltnd*n2));
    }

    //¿Es cierto, en Java, que a*b/c = a*(b/c) siendo a, b y c de tipo entero?
    //Justificar con ejemplos
    public static void comprobacion(int a, int b, int c){
        System.out.println("Primera ecuacion: " +  a*b/c);
        System.out.println("Segunda ecuacion: " + a*(b/c));
    }

    //Escribir un programa Java que muestre en pantalla el número de vueltas del
    //ángulo 34567º (dado en grados).
    public static void vueltas(int angulo){
        System.out.println("Vueltas: " + angulo/360 + " Resultante: " + angulo%360 +"º ");
    }

    //Escribir un programa Java que muestre en pantalla el cuadrante (1, 2, 3 ó 4)
    //que alcanza el ángulo 68931º (dado en grados).
    public static void cuadrante(int angulo){
        angulo %= 360;
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

    //Escribir un programa Java que muestre en pantalla el equivalente en
    //radianes del ángulo 257º (en grados).
    public static void radianes(int grados){
        System.out.println("En Radianes: " + Math.toRadians(grados));
    }
}