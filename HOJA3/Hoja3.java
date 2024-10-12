import java.util.Scanner;
import java.util.Locale;

/*
 * @author javcalv
 */


public class Hoja3 {
    public static void main(String[] args){
        //potencias();
        //numeroAleatorio();
        //fechaUsa();
        //fechaCompleta();
        //H3E3();
        H3E8();
    }
    
    /**
    * Escribir un programa Java que pida el usuario un número positivo y escriba en
    * pantalla sus raíces cuadrada, cúbica, cuarta, y quinta.
    */
    public static void potencias(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print(" Escriba un numero positivo: ");
        int num = in.nextInt();
        in.close();
        System.out.println("Raiz cuadrada: "+ num*num + ", raiz cubica: " + Math.pow(num, 3) + ", raiz cuarta: " + Math.pow(num, 3) + ", raiz quinta: " + Math.pow(num, 5));
    }

    /**
    * Escribir un programa que, cuando se ejecute, escriba en pantalla un número
    * entero entre 1 y 6 (como la tirada de un dado). Cada vez que se ejecute podrá
    * dar un resultado distinto (use la función Math.random()).
    */

    public static void numeroAleatorio(){
        int num = 6;
        System.out.print(Math.round(Math.random() * num));  
    }

    /**
    * Escribir un método Java que tome como parámetros 3 números enteros, para
    * día, mes y año (supuestamente correctos), y escriba en pantalla la fecha en
    * formato dia/mes/año. Escriba otro método que lo escriba en forma mes año, dia
    * (al estilo EEUU y algunos otros países). Utilice estos métodos para escribir un
    * programa que pida al usuario 3 números enteros para una fecha, y escriba en
    * pantalla la fecha en los dos formatos.
    */
    public static void fechaUsa(){
        solicitarFecha();
    }

    public static void solicitarFecha(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Escriba el día: ");
        int dia = in.nextInt();
        while (dia<1 || dia>31) {
            System.out.print("Dia incorrecto. (1 al 31): ");
            dia = in.nextInt();
        }
        System.out.print("Escriba el mes: ");
        int mes = in.nextInt();
        while (mes<1 || mes>12) {
            System.out.print("Mes incorrecto. (1 al 12): ");
            mes = in.nextInt();
        }
        System.out.print("Escriba el anyo: ");
        int anyo = in.nextInt();
        while (anyo<1 || anyo>2024) {
            System.out.print("Anyo incorrecto. (1 al 2024): ");
            anyo = in.nextInt();
        }
        in.close();
        comprobarFecha(dia, mes, anyo);
    }

    /**
     * Funcion para comprobar si es correcta la fecha
     * @param dia --> El dia del mes. Debes er 30 para meses de 30 dias (28/29 Febrero)
     * @param mes --> Parametro mes
     * @param anyo --> Año, donde se comprobará si es bisiesto o no
     */
    public static void comprobarFecha(int dia, int mes, int anyo){
        String error = "La fecha es invalida";
        if (mes<=7 && (mes%2) == 0 && (dia == 31 || (mes==2 && (dia>28 && comprobarBisiesto(anyo)==false || dia>29 && comprobarBisiesto(anyo)))) ){
            System.out.println(error);
        }

        else if ((mes==9 || mes==11)&& dia==31){
            System.out.println(error);
        }

        else{
            System.out.println("Fecha: "+ dia+"/"+mes+"/"+anyo);
            System.out.println("Formato USA: " + mes+"/"+anyo+"/"+dia);
        }
    }

    /**
     * Funcion para comprobar si un año es bisiesto o no
     * @param anyo parametro año para comprobar
     * @return True, si es bisiesto, false si no lo es
     */
    public static boolean comprobarBisiesto(int anyo){
        return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0);
    }

    /**
    * Escribir un método Java que tome como parámetros una cadena de caracteres
    * para el día de la semana, y 3 números enteros, para día, mes y año
    * (supuestamente correctos), y escriba en pantalla la fecha en formato largo,
    * como por ejemplo “Domingo, 31 del 12 de 2023”.
    */

    public static void fechaCompleta(){
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        String texto = fechaTexto(in);
        int l[] = solicitarFecha4(in);
        in.close();
        System.out.println(texto + ", " + l[0] + " del " + l[1] + " de " + l[2]);
    }

    public static String fechaTexto(Scanner in){
        System.out.print("Indique el día (Lunes,Martes...): ");
        String texto = in.nextLine().trim();
        String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        boolean cent = true;
        while (cent) {
            int cuenta = 0;
            for(String dia : dias){
                cuenta++;
                if (texto.equalsIgnoreCase(dia)){
                    cent = false;
                    break;
                }
                else if(cuenta == dias.length && texto!=dia){
                    System.out.print("Dia incorrecto. Escribelo bien: ");
                    texto = in.nextLine();
                }
            }
        } 
        return texto;    
    }

    public static int[] solicitarFecha4(Scanner in){
        System.out.print("Escriba el día: ");
        int dia = in.nextInt();
        while (dia<1 || dia>31) {
            System.out.print("Dia incorrecto. (1 al 31): ");
            dia = in.nextInt();
        }
        System.out.print("Escriba el mes: ");
        int mes = in.nextInt();
        while (mes<1 || mes>12) {
            System.out.print("Mes incorrecto. (1 al 12): ");
            mes = in.nextInt();
        }
        System.out.print("Escriba el anyo: ");
        int anyo = in.nextInt();
        while (anyo<1 || anyo>2024) {
            System.out.print("Anyo incorrecto. (1 al 2024): ");
            anyo = in.nextInt();
        }
        int l[] = {dia,mes,anyo};
        return l;
    }


    /* 
     * Escribir el método Java necesario para completar el programa siguiente:
     */
        public static void H3E3(){
            /* De polares a cartesianas, dim 2*/
            Scanner in = new Scanner (System.in);
            in.useLocale (Locale.US);
            double angulo, radio;
            System.out.print ("Escriba un ángulo (en radianes): ");
            angulo = in.nextDouble();
            System.out.print ("y un radio (positivo): ");
            radio = in.nextDouble();
            System.out.println ("Ángulo " + angulo + " , radio " + radio);
            System.out.print ("El punto en cartesianas es ");
            EscribirEnCartesianasLasPolares (radio, angulo); // SENTENCIA
            System.out.println();
            in.close();
        }

        /**
         * Funcion para pasar de Cartesianas a polares:
         * @param radio Parametro radio
         * @param angulo parametro angulo
         */
        public static void EscribirEnCartesianasLasPolares(double radio, double angulo){
            double x = radio * Math.cos(angulo);
            double y = radio * Math.sin(angulo);
            System.out.print("(" + x + ", " + y + ")");
        }

        /**
         * Metodo que asemeja una conversacion, donde devuelve 2 frases por consola y
         * llama a 2 metodos, zoop y baffle
         */
        public static void H3E8(){
            System.out.print("No, I ");
            zoop ();
            System.out.print("I ");
            baffle ();
        }

        /**
         * metodo que devuelve un "You wugga " y llama al metodo baffle antes y despues de escribir
         * por consola
         */
        public static void zoop(){
            baffle ();
            System.out.print ("You wugga ");
            baffle ();
        }

        /**
         * Metodo que devuelve "You wug" llama al metodo ping()
         */
        public static void baffle() {
            System.out.print ("You wug ");
            ping ();
        }

        /** 
         * Metodo que vevuelve un punto por consola
         */
        public static void ping (){
            System.out.println(".");
        }

        /**
         * Escribir funciones para transformar grados en radianes y viceversa
         */
        
        /**
         * Funcion para pasar de grados a radianes
         * @param grados
         * @return Radianes
         */
        public static double gradosARadianes(double grados){
            return grados* (Math.PI/180);
        }

        /** 
         * Funcion para pasar de radianes a grados
         * @param radianes
         * @return grados
         */
        public static double radianesAGrados(double radianes){
            return radianes * (180/Math.PI);
        }
        
}  
