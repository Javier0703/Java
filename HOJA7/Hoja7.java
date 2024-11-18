package HOJA7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Hoja7 {
    public static void main(String[] args){
        //int[] prueba = {4,5,6,7,8};
        //int[] vecOrdenado = {0,3,4,11};
        //int[] prueba2 = {7,8,9,0,2};
        //int[] prueba3 = {6,8,4,7,5};
        //int[] vEj7 = new int[6]; vEj7[2] = 4; vEj7[4]=8;
        //int[] ej3 = {5,8,-1,-6,7,8,9,0,3,4};
        //double[] resultado = H7E1(prueba); System.out.println(Arrays.toString(resultado));
        //double[] res2 = H7E2(prueba); System.out.println(Arrays.toString(res2));
        //double[] res3 = H7E2(ej3); System.out.println(Arrays.toString(res3));
        //H7E4(prueba, prueba2);
        //H7E5(); H7E5SinHasSet();
        //boolean[] l = H7E6_RepresentarBooleanas(prueba); System.out.println(Arrays.toString(l));
        //boolean[] m = H7E6_UnionVectores(prueba, vecOrdenado); System.out.println(Arrays.toString(m));
        //H7E7(vEj7,9); System.out.println(Arrays.toString(vEj7));

        //H7E9(vecOrdenado);
        //int[] l = H7E10(45678); System.out.print(Arrays.toString(l));
        //System.out.println(H7E11(prueba, vecOrdenado));
        //H7E12();
        //H7E13();
        H7E14();
    
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

    /**
     * Se dispone de un vector, parcialmente ocupado, que almacena números enteros clasificados 
     * en orden creciente. Se desea conocer si un número introducido por teclado se encuentra en 
     * el vector, en caso afirmativo se mostrará su posición, y en caso negativo se insertará en 
     * la posición que le corresponda. Si se intenta insertar y el vector está lleno, se mostrará 
     * un mensaje de error.
     */
    public static void H7E7(int[] v, int numero){
        boolean esta = false;
        if(!comprobarOrdenado(v))System.out.println("Vector no esta ordenado");
        else{
            for (int i = 0; i<v.length; i++){
              if (v[i] == numero){
                System.out.println("Esta en la posicion " + i);
                esta = true;
                break; 
              } 
            }
            //No se encuentra en el vector
            if(!esta) agregarNumeroVector(v, numero);
        }
    }

    private static boolean comprobarOrdenado(int[] v){
        int ultimoNumOcupado = 0;
        for (int i=0; i<v.length; i++){
            if(v[i]!=0){
                if(v[i]>= ultimoNumOcupado)
                    ultimoNumOcupado = v[i];
                else return false;
            }
        }
        return true;
    }

    private static void agregarNumeroVector(int[] v, int numero){
        boolean huecosVacios = false;
        boolean agregar = false;
        for (int i=0; i<v.length; i++){
            //Esta hueco esta vacio
            if(v[i] == 0){
                huecosVacios = true;
                //Saber su numero anterior y su numero siguiente (Si es 0 es que no hay)
                int numeroAnterior = numeroAnterior(v, i);
                int numeroSiguiente = numeroSiguiente(v, i);
                if( (numeroAnterior == 0 && numero<=numeroSiguiente)|| (numero>=numeroAnterior && numero<=numeroSiguiente) || (numeroSiguiente == 0 && numero>=numeroAnterior)){
                    v[i] = numero;
                    System.out.println("Numero agregado");
                    agregar = true;
                    break;
                }
            }
        }
        if(!huecosVacios)System.out.println("El vector esta lleno");
        if(!agregar)System.out.println("Este numero no puede agregarse en este array.");
    }

    private static int numeroAnterior(int[] v, int num){
        int numeroArray=0;
        //Recorremos el array hacia atras desde ese puunto
        for (int i =num-1; i>=0; i--){
            if(v[i] != 0){
                numeroArray = v[i];
                break;
            }
        }
        return numeroArray;
    }

    private static int numeroSiguiente(int[] v, int num){
        int numeroArray=0;
        //Recorremos el array hacia atras desde ese puunto
        for (int i = num+1; i<v.length; i++ ){
            if(v[i] != 0){
                numeroArray = v[i];
                break;
            }
        }
        return numeroArray;
    }

    /*
     * Sean dos vectores a y b cuyas componentes son de un tipo enumerado, por ejemplo int. 
     * Diremos que a < b si:
     *  - Existe una posición i para la que la componente de a es menor que la componente 
     * correspondiente de b (ai < bi ), siendo las componentes anteriores iguales (aj = bj para j 
     * < i).
     * - Siendo todas las componentes de a iguales a las de b, el número de componentes de a es 
     * menor que el de b. 
     * Elaborar un método que devuelva -1 , 0 ó 1 dependiendo de si a < b, a = b o a > b.
     */
    public static int H7E8(int[]v, int[]w){
        final int TAMANYOA = v.length;
        final int TAMANYOB = v.length;
        int aiMayor = 0;
        int aiIgual = 0;
        for (int i=0; i<Math.max(TAMANYOA,TAMANYOB); i++){
            if(v[i]>w[i])aiMayor++;
            if(v[i]==w[i])aiIgual++;
        }
        return 0;
    }

    /**
     * Escribir un método que reciba un array cuyos elementos son enteros positivos. 
     * El método dibuja tantos asteriscos como indique el número almacenado en cada 
     * elemento del array. Por ejemplo, el array:
     */
    public static void H7E9(int[] v){
        int numero;
        for (int i=0; i<v.length; i++){
            numero = v[i];
            for (int j=1;j<=numero;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    /**
     * Crear una función que reciba un número entero positivo y a partir del número obtenga 
     * como resultado un array que almacena por separado cada cifra del número. 
     * Por ejemplo, para la entrada 5492
     */
    public static int[] H7E10(int v){
        String numeroToString = String.valueOf(v);;
        int[] numeros = new int[numeroToString.length()];
        for(int i = 0; i<numeroToString.length(); i++){
            numeros[i] = Character.getNumericValue(numeroToString.charAt(i));
        }
        return numeros;
    }

    /**
     * Crear una función que reciba dos arrays de números enteros y devuelva verdadero si
     *  el segundo contiene todos los elementos del primero sin importar el orden de los elementos.
     *  Por ejemplo, para los arrays siguientes:
     */
    public static boolean H7E11(int[]v , int[]w){
        final int TAMANYO = v.length;
        if(TAMANYO!=w.length) throw new IllegalArgumentException("Arrays de distitnto tamaño");
        for (int i = 0; i<TAMANYO; i++){
            boolean esta = false;
            for(int j=0; j<TAMANYO; j++){
                if(v[i] == w[j])esta = true;
            }
            if(!esta) return false;
        }
        return true;
    }

    /**
     * Crear un programa que defina un array que almacene 20.000 letras mayúsculas aleatorias 
     * (caracteres de la A a la Z sin contar la Ñ). Crear un programa que muestre cada letra y
     *  las veces que aparece en el array.
     */
    public static void H7E12(){
        final int TAMANYO = 20000;
        char[] letras = new char[TAMANYO];
        int[] conteo = new int[26]; //Array para contar las letras
        Random random = new Random();
        for (int i = 0; i < TAMANYO; i++) {
            letras[i] = (char)(random.nextInt(26) + 'A');
        }
        for(char letra : letras){
            conteo[letra - 'A']++;
        }
        System.out.println("\nConteo de letras:");
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (i + 'A') + ": " + conteo[i]);
        }
    }

    /**
     * Crear un programa que permita simular la generación de un mazo de cartas españolas. 
     * En dicho programa se colocarán las 40 cartas de la baraja española (las cartas van del 1 al 7 y luego siguen la sota, 
     * el caballo y el rey; de cada uno de los 4 palos). El programa desordenará el array de 
     * forma aleatoria (lo cual significará “barajear” las cartas”) y luego mostrará en pantalla la 
     * colocación actual de la baraja (por supuesto no se puede repetir la misma carta).
     */
    public static void H7E13() {
        final int CARTASPALO = 10; // Cartas del 1 al 7, Sota (8), Caballo (9), Rey (10)
        final int CARTAS = CARTASPALO * 4; // 40 cartas en total

        String[] palos = {"Oros", "Bastos", "Copas", "Espadas"};
        int[] baraja = new int[CARTAS];

        // Generar las cartas numeradas del 1 al 10 para cada palo
        for (int i = 0; i < CARTAS; i++) {
            baraja[i] = i;
        }
        baraja = barajear(baraja);

        System.out.println("Baraja barajeada:");
        for (int i = 0; i < CARTAS; i++) {
            int numero = (baraja[i] % CARTASPALO) + 1;
            int palo = baraja[i] / CARTASPALO;
            System.out.print("Carta " + (i + 1) + ": ");
            switch (numero) {
                case 8:
                    System.out.print("Sota");
                    break;
                case 9:
                    System.out.print("Caballo");
                    break;
                case 10:
                    System.out.print("Rey");
                    break;
                default:
                    System.out.print(numero);
                    break;
            }
            System.out.print(" de " + palos[palo]);
            System.out.println();
        }
    }

    // Método para barajear la baraja usando el algoritmo de Fisher-Yates
    private static int[] barajear(int[] baraja) {
        Random random = new Random();
        for (int i = baraja.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Intercambiar baraja[i] con baraja[j]
            int temp = baraja[i];
            baraja[i] = baraja[j];
            baraja[j] = temp;
        }
        return baraja;
    }


    /**
     * Para almacenar enteros grandes, Java nos proporciona el tipo básico long. Pero incluso este 
     * tipo admite números de hasta 18 cifras como mucho. Queremos trabajar con números enteros 
     * mucho más largos. Para ello vamos a hacer un programa que realice estas acciones: 
     *  a. Crear un array de 1600 números aleatorios del 0 al 9. 
     *  b. Tras crear el array, aprovecharle para mostrar por pantalla 20 números 
     *     aleatorios de 80 cifras. 
     *  c. Finalmente mostrar por pantalla cuál es el número (de 80 cifras) 
     *     más grande de todos los que han salido.
     */
    public static void H7E14(){
        final int NUMEROS = 20;
        final int TAMANYO = 80;
        //Generamos el array de los numeros
        int[] arrayNumeros = new int[NUMEROS*TAMANYO];
        Random random = new Random();
        for (int i=0; i<arrayNumeros.length; i++) 
            arrayNumeros[i] = random.nextInt(10);
        
        //Generamos los 20 numeros de 80 cifras
        String[] numerosLargos = new String[NUMEROS];
        for (int i = 0; i < NUMEROS; i++) {
            StringBuilder numero = new StringBuilder();
            for (int j = 0; j < TAMANYO; j++) {
                numero.append(arrayNumeros[i * TAMANYO + j]);
            }
            numerosLargos[i] = numero.toString();
            System.out.println("Número " + (i + 1) + ": " + numerosLargos[i]);
        }

        //Comparamos para ver cual es el numero mas largo
        String maxNumero = numerosLargos[0];
        for (int i = 1; i < NUMEROS; i++) {
            if (numerosLargos[i].compareTo(maxNumero) > 0) {
                maxNumero = numerosLargos[i];
            }
        }
        System.out.println("\nEl número más grande es: " + maxNumero);
    } 
}