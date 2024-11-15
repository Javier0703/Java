package HOJA7;

import java.util.Arrays;

public class Hoja7 {
    public static void main(String[] args){
        int[] prueba = {4, 5, 6, 7, 8};
        int[] ej3 = {5,8,-1,-6,7,8,9,0,3,4};
        //double[] resultado = H7E1(prueba); System.out.println(Arrays.toString(resultado));
        double[] res2 = H7E2(prueba); System.out.println(Arrays.toString(res2));
        double[] res3 = H7E2(ej3); System.out.println(Arrays.toString(res3));
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

}
