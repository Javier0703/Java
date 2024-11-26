import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;

public class Hoja7b{
    public static void main(String[] args){
        //int[][] m =    {{1,2,5},{3,5,6},{4,6,7},{-1,-2,-3}}; 
        //H7E2(m);
        //int[][] n = H7E3(m); imprimeMatriz(n);
        //int[][] l = {{2,5,8},{3,9,6},{7,5,0},{8,5,2}}; H7E4(l);
        //String[][] strings = {{"a","b","c"},{"d","e","d"},{"c","b","a"}}; 
        //H7E5(strings);
        //System.out.println(H7E6(strings));
        //H7E7();
        H7E11();
        

    }

    /**
     * Metodo para imprimir una matriz
     * @param m matriz a imprimir
     */
    public static void imprimeMatriz(int[][] m){
        for (int i=0; i<m.length; i++){
            for (int j=0; j<m[i].length; j++){
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    /**
     * Elaborar un método que escriba en pantalla la suma de los elementos de cada fila y 
     * la suma de los elementos de cada columna de una matriz de números dada como parámetro.
     */
    public static void H7E2(int[][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
                sumaFilas[i] += matriz[i][j];      
                sumaColumnas[j] += matriz[i][j];
            }
        }

        for (int i = 0; i<filas; i++) {
            System.out.println("Fila " + (i+1) + ": " + sumaFilas[i]);
        }
        for (int i = 0; i<columnas; i++) {
            System.out.println("Columna " + (i+1) + ": " + sumaColumnas[i]);
        }
    }

    /**
     * Elaborar un método que, dada una matriz numérica, reste a cada elemento de la matriz la 
     * media aritmética de su columna.
     */
    public static int[][] H7E3(int[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            int sumaColumnas = 0;
            for (int i = 0; i < m.length; i++) {
                sumaColumnas += m[i][j];

            }
            sumaColumnas=(sumaColumnas/m.length);
            for (int i = 0; i < m.length; i++) { 
                m[i][j]-=sumaColumnas;
            }
        }
        return m;
    }

    /**
     * Elaborar un programa que almacene en una matriz una serie de datos numéricos y escriba
     *  el resultado de restar a cada elemento la media aritmética de la media aritmética de su fila
     *  y la media aritmética de su columna.
     */
    public static void H7E4(int[][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        double[] sumaFilas = new double[filas];
        double[] sumaColumnas = new double[columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sumaFilas[i] += matriz[i][j];      
                sumaColumnas[j] += matriz[i][j];
            }
        }

        double[][] nuevaMatriz = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaMatriz[i][j] = matriz[i][j] - (sumaFilas[i]/(double)columnas + sumaColumnas[j]/(double)filas)/2;
                System.out.print(nuevaMatriz[i][j] + "\t");
            }
            System.out.println("");
        }

    }

    /**
     * Dada como entrada una matriz de caracteres, construir un método que escriba en pantalla 
     * las cadenas de caracteres de dicha matriz formadas por todas las rectas en dirección 
     * noroeste-sureste, empezando por la de más a la derecha
     */
    public static void H7E5(String[][] m){
        imprimirElemento(m, 0, m[0].length -1);
    }

    private static void imprimirElemento(String[][] m, int fila ,int componente){
        //Elemento que no pertenecet a la matriz (por encima)
        if(componente<0){
            imprimirElemento(m,fila+1,componente+1);
        }

        else{
             //Si el siguiente elemento es uno mas (no existe)
            if(fila == m.length || componente == m[0].length){
                System.out.println("");
                while(fila>0){
                    fila--;
                    componente--;
                }
                componente--;
                imprimirElemento(m, fila, componente);
            }

            //Si es el ultimo elemento imprimible de la matriz o no
            if(!ultimoElementoMatriz(m, fila, componente)){
                System.out.print(m[fila][componente]);
                imprimirElemento(m,fila+1,componente+1);
            }
        }
    }
    private  static boolean ultimoElementoMatriz(String[][] m, int fila, int componente){
        return (componente == 0 && (m.length == fila-1)) ? true : false;
    }

    /**
     * Una matriz cuadrada, se dice que posee simetría central si el valor de cada elemento coincide con 
     * el de su simétrico (ver figuras). Escribir un subprograma que, dada una matriz bidimensional 
     * cuadrada de caracteres (de tamaño nxn), compruebe si posee simetría central.
     */
    public static boolean H7E6(String[][] m){
        if(!comprobarMatrizCuadratica(m)){
            throw new IllegalArgumentException("La matriz no es cuadratica");
        }
        if(m.length == 1){
            throw new IllegalArgumentException("La matriz no puede ser un vector");
        }
        int comparaciones = m.length/2;
        if ((comparaciones % 2)==1) comparaciones++;
        int indice = 0;
        
        do{
            System.out.println(indice);
            if(!comprobarVectoresSimetricos(m[indice], m[(m.length-1) - indice])){
                return false;
            }
            indice++;
            comparaciones--;
        }
        while(comparaciones>0);
        return true;

    }

    /**
     * Metoro que devuelve si una matriz es cuadratica o no
     * @param m Matriz m a comprobar
     * @return true si es cuadratica o false si no lo es
     */
    private static boolean comprobarMatrizCuadratica(String[][] m){
        int filas = m.length;
        for (String[] v : m){
            if (v.length!=filas) return false;
        }
        return true;
    }
    
    /**
     * Metodo que devuelve true o false en funcion si 2 vectores son inversamente iguales
     * @param v1 Vector 1
     * @param v2 Vector 2
     * @return true si son inversamente iguales o false si no lo son
     */
    private static boolean comprobarVectoresSimetricos(String[] v1, String[] v2){
        for (int i =0; i<(v1.length/2); i++){
            if(!v1[i].equals(v2[v2.length - 1 - i]))
                return false;
        }   
        return true;
    }

    /**
     * Para analizar una imagen de una porción de cielo se obtiene una matriz de 40x20 componentes 
     * enteras, cada una de las cuales indica la intensidad de luz recibida en el punto, entre 0 y 100.
     *  
     * Se supone la existencia de una estrella en una componente de la matriz cuando la suma de las 
     * intensidades correspondientes a la misma componente más la media de los 8 puntos circundantes sea
     * mayor o igual que 60. Se supone que en el borde de la matriz no existen estrellas. 
     * 
     * Elaborar un programa que lea por teclado una matriz de intensidades y muestre en pantalla la
     * imagen resultante. Las estrellas se representarán por el carácter * mientras que los puntos en 
     * que no aparezcan se señalarán mediante un espacio en blanco.
     */
    public static void H7E7(){
        int[][] m = new int[40][20];
        Random random = new Random();
        for (int i=0; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){
                m[i][j] = random.nextInt(101);
            }
        }

        for (int i=1; i<m.length -2; i++){
            for (int j=1; j<m[0].length -2; j++){
                if(mediaComponentes(m, i-1, j-1) >= 60)System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println("");
        }

    }

    /**
     * Metodo que devuelve la suma con la media de los componentes circundantes
    */
    private static int mediaComponentes(int[][] m, int i, int j) {
        int c = m[i + 1][j + 1]; // Intensidad del punto central
        int suma = 0;
        for (int l = i; l < (i + 3); l++) {
            for (int p = j; p < (j + 3); p++) {
                suma += m[l][p];
            }
        }
        return (suma - c) / 8 + c;
    }

    /**
     * En mecanografía, cada uno de los ocho dedos cubre un rango de teclas, de esta manera:
        Dedos mano izquierda    Teclas      Dedos mano derecha      Teclas
        2                       RTFGVB      2                       YUHJNM
        3                       EDC         3                       IK
        4                       WSX         4                       OL
        5                       QAZ         5                       P
     * Para comprobar la habilidad mecanográfica es útil tener frases que impliquen la utilización de 
     * todos los dedos al menos una vez (Por ejemplo, “Pan con pan es comida de tontos”). 
     * Escribir un programa que lea frases por teclado, hasta que se introduzca una línea vacía, 
     * e imprima la puntuación global usando el siguiente baremo: 
     *       1 punto por cada frase que implique la utilización de todos los dedos.
     *       -0.25 puntos por cada frase que no requiera todos los dedos.
     */

    public static void H7E11(){
        String[][] letras = {{"RTFGVB","YUHJNM"},{"EDC","IK"},{"WSX","OL"},{"QAZ","P"}};
        float suma = 0.0f;
        String frase = "";
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        do{
            System.out.print("Frase a analizar: ");
            frase = in.nextLine();
            if(!frase.equals(""))
                suma += utilizacionDedos(letras, frase);

        }
        while(!frase.equals(""));
        in.close();
        System.out.println(suma);
    }

    /**
     * Metodo que comprueba una frase
     */
    private static float utilizacionDedos(String[][] letras, String frase){
        boolean[][] usos = generarMatrizUsos(letras.length, letras[0].length);
        for (int p=0; p<frase.length(); p++){
            String letra = String.valueOf(frase.charAt(p)).toUpperCase();
            for (int i=0; i<letras.length; i++){
                for (int j=0; j<letras[0].length; j++){
                    if(letras[i][j].indexOf(letra)!=-1){
                        usos[i][j] = true;
                        if(matrizCompleta(usos))
                            return 1f;
                    }
                }
            }
        }
        if(matrizCompleta(usos)) return 1f;
        else return -0.25f;
    }

    /*
     * Metodo para generar una matriz de usos;
     */
    private static boolean[][] generarMatrizUsos(int filas, int columnas){
        boolean[][] l = new boolean[filas][columnas];
        for (int i =0; i<l.length; i++){
            for (int j=0; j<l[0].length; j++){
                l[i][j] = false;
            }
        }
        return l;
    }

    /*
     * Metodo para comprobar si se ha usado todos los dedos
     */
    private static boolean matrizCompleta(boolean[][] m){
        for (int i =0; i<m.length; i++){
            for (int j=0; j<m[0].length; j++){
                if (m[i][j] == false){
                    return false;
                }
            }
        }
        return true;
    }
    



}