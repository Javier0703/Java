package HOJA6;

public class Hoja6 {
    public static void main(String[] args){
        String cadena = "Hola, esto es la hoja 6 de ejercicios"; 
        char letra = 'e';
        String cadenaEj3 = "Hola, esto es una esto prueba. Esto veremos";
        String subcadena = "esto";
        //H6E1(cadena,letra);
        //H6E2(cadena,letra);
        //H6E3(cadenaEj3, subcadena);
        //H6E4(cadenaEj3, subcadena);
        //System.out.println(H6E5(cadena));
        //int n = H6E6("1434"); System.out.println(n + 1 );
        System.out.println(H6E7("34N56")); 
        System.out.println(H6E7("34s4"));
    }

    /**
     * Metodo para comprobar el string sea correctos
     * @param cadena Cadena a comprobar
     * @throws IllegalArgumentException si la cadena es nula o vacia
     */
    private static void comprobarString(String cadena){
        if (cadena == null || cadena.isEmpty()) 
            throw new IllegalArgumentException("La cadena no puede ser nula o vacía");
    }

    /**
     * Metodo para comprobar si un char es correcto
     * @param letra Letra a comprobar
     * @throws IllegalArgumentException si el char no es una letra
     */
    private static void comprobarChar(char letra){
        if (!Character.isLetter(letra)) throw new IllegalArgumentException("Debe ser una letra");
    }

    /**
     * Escriba una función que, dada una cadena de caracteres (String) y un carácter
     * (char) devuelva el número de veces que el carácter aparece en la cadena.
     */
    public static void H6E1(String cadena, char letra){
        comprobarString(cadena);
        comprobarChar(letra);
        int cent =0;
        letra = Character.toLowerCase(letra);
        for (int i=0; i<cadena.length(); i++)
            if(Character.toLowerCase(cadena.charAt(i)) == letra) cent++;
        System.out.println("Numero de veces la letra "+ letra + " : " + cent);
    } 
    
    /**
     * Escriba un procedimiento que imprima en pantalla las posiciones en las que un
     * carácter aparece en una cadena de caracteres.
     */
    public static void H6E2(String cadena, char letra){
        comprobarString(cadena);
        comprobarChar(letra);
        letra = Character.toLowerCase(letra);
        System.out.print("Posiciones donde aparece la " + letra + " (de 1-n):");
        for (int i=0; i<cadena.length(); i++)
            if(Character.toLowerCase(cadena.charAt(i)) == letra) System.out.print(" "+(i+1)+"");
    } 

    /**
     * Escriba un método que, dadas dos cadenas de caracteres, devuelva el número
     * de veces que la segunda aparece en la primera. (Puede tener el mismo nombre
     * que el del ejercicio 1).
     */
    public static void H6E3(String cadena, String subcadena) {
        cadena = cadena.toLowerCase();
        subcadena = subcadena.toLowerCase();
        comprobarString(cadena);
        comprobarString(subcadena);
        if (cadena.length() < subcadena.length()) {
            System.out.println("La subcadena es mayor que la cadena");
        } else {
            int total = 0;
            for (int i = 0; i <= cadena.length() - subcadena.length(); i++) {
                if (cadena.substring(i, i + subcadena.length()).equals(subcadena)) {
                    total++;
                }
            }
            System.out.println("La subcadena aparece " + total + " veces");
        }
    }    
    
    /**
     * Escriba un método que, dadas dos cadenas de caracteres, imprima en pantalla
     * las posiciones en las que la segunda aparece en la primera. (Puede tener el
     * mismo nombre que el del ejercicio 3).
     */
    public static void H6E4(String cadena, String subcadena) {
        cadena = cadena.toLowerCase();
        subcadena = subcadena.toLowerCase();
        comprobarString(cadena);
        comprobarString(subcadena);
        if (cadena.length() < subcadena.length()) {
            System.out.println("La subcadena es mayor que la cadena");
        } else {
            boolean aparece = false;
            for (int i = 0; i <= cadena.length() - subcadena.length(); i++) {
                if (cadena.substring(i, i + subcadena.length()).equals(subcadena)) {
                    aparece = true;
                    System.out.println("La subcadena aparece en la posicion: " + (i+1) + " (Del 1-n)");
                    break;
                }
            }
            if(!aparece) System.out.println("No aparece en ninguna posicion");
        }
    }

    /**
     * Escriba un método que devuelva una cadena que sea la inversa de su cadena
     * argumento (como si se leyera de atrás a delante).
     */
    public static String H6E5(String cadena){
        comprobarString(cadena);
        String cadReves = "";
        for(int i = cadena.length()-1; i>=0; i--){
            cadReves+=Character.toString(cadena.charAt(i));
        } 
        return cadReves;   
    } 

    /**
     * Escriba un método que devuelva el valor numérico entero de una cadena,
     * imponiendo como precondición que la cadena argumento contenga solamente
     * dígitos.
     */
    public static int H6E6(String cadena){
        comprobarString(cadena);
        if (compararCadenaSolodigitos(cadena))
            return Integer.parseInt(cadena);
        else
            throw new IllegalArgumentException("La cadena solo puede ser digitos");
    }
    
    /**
     * metodo para comprovar si un
     * @param cadena Cadena a comprobar
     * @throws IllegalArgumentException si la cadena no son digitos
     */
    private static boolean compararCadenaSolodigitos(String cadena) {
        if (cadena.matches("\\d+")) return true;
        else return false;

    } 
    
    /**
     * Escriba una función que determine si una cadena de caracteres cumple o no
     * todas las condiciones siguientes:
     * a) los dos primeros caracteres son dígitos
     * b) el tercer carácter es una de las letras N, S, E ó O
     * c) a continuación hay 1 ó dos dígitos, cuyo valor numérico es un entero
     * entre 1 y 10
     */

    public static boolean H6E7(String cadena){
        comprobarString(cadena);
        return comprobarCondicionesCadena(cadena.toUpperCase());
    }

    private static boolean comprobarCondicionesCadena(String cadena){
        if (cadena.length() == 5 || cadena.length() == 4){
            if (!(Character.isDigit(cadena.charAt(0)) && Character.isDigit(cadena.charAt(1)))){
                return false;
            }
            char letra = cadena.charAt(2);
            if (letra != 'N' && letra != 'S' && letra != 'E' && letra != 'O') {
                return false;
            }
            String numerosDespues = cadena.substring(3);
            if (!compararCadenaSolodigitos(numerosDespues))
                return false;
            return true;
        }
        else return false;
    }
}