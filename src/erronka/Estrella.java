package erronka;


public class Estrella {
    public static void mostrarEstrella() {

        int numFilas = 5;

        for(int numBlancos = 0, numAsteriscos = (numFilas*2)-1; numAsteriscos>0; numBlancos++, numAsteriscos -= 2){
            
            //Espacios en blanco
            for(int i=0; i < numBlancos; i++){
                System.out.print(" ");
            }
             
            //Asteriscos
            for(int j=numAsteriscos; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
 
        for(int altura = 1; altura<=numFilas; altura++){
            //Espacios en blanco
            for(int blancos = 1; blancos<=numFilas-altura; blancos++){
                System.out.print(" ");
            }
 
            //Asteriscos
            for(int asteriscos=1; asteriscos<=(altura*2)-1; asteriscos++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = 0; i < numFilas; i++) {
            // espacios iniciales
            for (int j = 0; j < numFilas - 1 - i; j++) {
                System.out.print(" ");
            }

            // asterisco izquierdo
            System.out.print("*");

            // espacios internos
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                // asterisco derecho
                System.out.print("*");
            }

            System.out.println();
        }
        
        for (int i = 0; i < (numFilas + 4); i++) {
            System.out.print("*");
        }
        System.out.println(); // salto de línea
        
        int medio = 4 ;
        for (int i = 0; i < numFilas; i++) {
        	for (int j = 0; j < medio; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        for (int i = 0; i < (numFilas + 4); i++) {
            System.out.print("*");
        }
        System.out.println(); //
        
        for (int i = 0; i < numFilas; i++) {
            // espacios iniciales
            for (int j = 0; j < numFilas - 1 - i; j++) {
                System.out.print(" ");
            }

            // asterisco izquierdo
            System.out.print("*");

            // espacios internos
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                // asterisco derecho
                System.out.print("*");
            }

            System.out.println();

        }
        System.out.println();

        
    }
    
    
}

