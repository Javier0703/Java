package HOJA7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Hoja7 {
    public static void main(String[] args){
        int[] prueba = {4,5,6,7,8};
        int[] vecOrdenado = {0,3,4,11};
        int[] prueba2 = {7,8,9,0,2};
        //int[] ej3 = {5,8,-1,-6,7,8,9,0,3,4};
        //double[] resultado = H7E1(prueba); System.out.println(Arrays.toString(resultado));
        //double[] res2 = H7E2(prueba); System.out.println(Arrays.toString(res2));
        //double[] res3 = H7E2(ej3); System.out.println(Arrays.toString(res3));
        //H7E4(prueba, prueba2);
        //H7E5(); H7E5SinHasSet();
        //boolean[] l = H7E6_RepresentarBooleanas(prueba); System.out.println(Arrays.toString(l));
        //boolean[] m = H7E6_UnionVectores(prueba, vecOrdenado); System.out.println(Arrays.toString(m));
    }

    /**
     * Elaborar un método para normalizar un vector de números reales, con el criterio de 
     * que el nuevo vector resultante tenga módulo 1 (es decir, con la misma 
     * dirección pero tamaño 1).
     */
    public static double[] H7E1(int[] numeros){
        double[] nuevoVector = new double[numeros.length];
        int r = 0;
        for (int numero: numeros){
            r+=Math.pow(numero,2);
        }
        double u = Math.sqrt(r);
        for (int i =0; i<numeros.length; i++){
            nuevoVector[i] = ((double)numeros[i]/u);
        }
        return nuevoVector;
    }

    /**
     * Elaborar un método para normalizar un vector de números reales, con el criterio de 
     * que el nuevo vector resultante tenga como mayor componente una con módulo 1.
     */
    public static double[] H7E2(int[] numeros){
        double[] nuevoVector = new double[numeros.length];
        int r = 0;
        for (int numero: numeros){
            if (Math.abs(numero)> r) r = numero;
        }
        for (int i =0; i<numeros.length; i++){
            nuevoVector[i] = ((double)numeros[i]/r);
        }
        return nuevoVector;
    }

    /**
     * Sea A un vector de 10 números reales no nulos. Se desea dividir todos sus elementos 
     * por el elemento que tiene índice k.
     */
    public static double[] H7E3(int[] numeros){
        final int TAM = numeros.length;
        double [ ] a = new double [TAM];
        int k = 0;
        for (int numero: numeros) if (Math.abs(numero) > k) k = numero;
        for (int i = 0 ; i < TAM ; i++)
            a[i] = a[i]/k ;
        return a;
    }

    /*
     * Para operar con números enteros de tamaño grande se puede utilizar un vector 
     * cuyas componentes sean dígitos decimales (entre 0 y 9, ambos inclusive). 
     * Elaborar un subprograma para sumar números enteros de hasta cuarenta cifras 
     * mediante dicho procedimiento.
     */
    public static void H7E4(int[] num1, int[] num2){
        final int MAX = 40;
        comprobarNumeros(num1); comprobarNumeros(num2);
        if ((num1.length != num2.length) || num1.length>MAX)System.out.println("Los vectores deben tener el mismo tamaño");
        else{
            //Creamos el nuevo array de la suma
            int[] resultado = new int[num1.length+1];
            int acarreo = 0;
            for (int i=(num1.length-1); i>=0; i--){
                int sum = num1[i] + num2[i] + acarreo;
                resultado[i + 1] = sum % 10;
                acarreo = sum/10; 
            }
            resultado[0] = acarreo;
            System.out.println(Arrays.toString(resultado));
        }
    }

    private static void comprobarNumeros(int[] nums){
        for (int num: nums){
            if (num<0 || num>9) throw new IllegalArgumentException("Los numeros deben de ser entre 0 y 9 incluidos");
        }
    }

    /**
     * Supongamos que una determinada colección consta de 225 cromos que se venden en sobres 
     * conteniendo cada uno 6 cromos distintos entre sí. Elaborar un programa que simule la 
     * compra de sobres mostrando el estado de la colección en cada momento y finalmente el 
     * número de sobres que han sido necesarios para completar la colección una vez conseguida.
     */
    public static void H7E5(){
        final int CARTAS_TOTALS = 255;
        final int CARTAS_CROMO = 6;
        Random random = new Random();
        HashSet<Integer> coleccion = new HashSet<>();
        int sobresNecesarios = 0;
        int cromo;
        while (coleccion.size() < CARTAS_TOTALS){
            sobresNecesarios++;
            for (int i =0; i<CARTAS_CROMO; i++){
                cromo = random.nextInt(CARTAS_TOTALS)+1;
                coleccion.add(cromo);
            }
            System.out.println("Sobre #" + sobresNecesarios + ". Colleccion = " + coleccion.size()+"/"+CARTAS_TOTALS);
        }
        System.out.println("Coleccion completa. Sobres necesarios: " + sobresNecesarios);
    }

    public static void H7E5SinHasSet(){
        final int CARTAS_TOTALS = 255;
        final int CARTAS_CROMO = 6;
        Random random = new Random();
        int[] coleccion = new int[CARTAS_TOTALS];
        //Damos el valor de -1 a cada una
        for (int i = 0; i<CARTAS_TOTALS; i++){
            coleccion[i] = -1;
        }
        int sobresNecesarios = 0;
        int cromo;
        int cartasAnyadidas = comprobarCartasAnyadidas(coleccion);

        while (cartasAnyadidas < CARTAS_TOTALS){
            sobresNecesarios++;
            for (int i =0; i<CARTAS_CROMO; i++){
                cromo = random.nextInt(CARTAS_TOTALS)+1;
                coleccion[cromo-1] = cromo;
            }
            cartasAnyadidas = comprobarCartasAnyadidas(coleccion);
            System.out.println("Sobre #" + sobresNecesarios + ". Colleccion = " + cartasAnyadidas+"/"+CARTAS_TOTALS);
        }

        System.out.println("Coleccion completa. Sobres necesarios: " + sobresNecesarios);
    }

    private static int comprobarCartasAnyadidas(int[] coleccion){
        int num = 0;
        for (int carta:coleccion){
            if(carta!=-1)num++;
        }
        return num;
    }

    /**
     * Mostrar de qué forma puede representarse un conjunto de números enteros de valor comprendido 
     * entre 1 y n mediante un vector de componentes booleanas. Escribir un subprograma que lea dos 
     * de esos conjuntos y calcule su unión y su intersección.
     */
    public static boolean[] H7E6_RepresentarBooleanas(int[] vect1){
        boolean[] comp = new boolean[vect1[vect1.length-1]+1];
        if(!comprobarVectorOrdenado(vect1)) throw new IllegalArgumentException("El vector no esta ordenado");
        else{
            for(int i=0; i<comp.length; i++){
               if(comprobarNumeroEnVector(vect1, i)) comp[i] = true;
               else comp[i] = false;
            }
        }
        return comp;   

    }

    private static boolean comprobarVectorOrdenado(int[] v){
        for (int i=0; i<v.length-1; i++){
            if(v[i]>v[i+1]) return false;
        }
        return true;
    }

    private static boolean comprobarNumeroEnVector(int[] v, int n){
        for (int i = 0; i<v.length; i++){
            if(v[i] == n) return true;
        }  
        return false; 
    }

    public static boolean[] H7E6_UnionVectores(int[] v1, int[] v2){
        boolean[] v1Booleano = H7E6_RepresentarBooleanas(v1);
        boolean[] v2Booleano = H7E6_RepresentarBooleanas(v2);
        int maximo = Math.max(v1Booleano.length, v2Booleano.length);
        boolean[] union = new boolean[maximo];
        for (int i = 0; i<maximo; i++){
            boolean aValue = (i < v1Booleano.length) ? v1Booleano[i] : false; 
            boolean bValue = (i < v2Booleano.length) ? v2Booleano[i] : false;
            union[i] = aValue || bValue; 
        }
        return union;
    }
}
