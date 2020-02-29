package practicat5psp;
import java.io.IOException;
import java.util.Scanner;
public class PracticaT5Psp {
    public static void main(String[] args) throws IOException {
        
       //HCarpio
        String mensaje;
        char opcion;
        int cod;
        
         Scanner tec = new Scanner(System.in);
        
        do {
            System.out.print("Introduce un texto: ");
            mensaje = tec.nextLine();
        } while (mensaje.isEmpty());
        do {
            System.out.print("Introduce el codigo para aplicar al texto> ");
            cod = tec.nextInt();
        } while (cod < 1);
        do {
            tec.nextLine();
            System.out.print("¿Quieres cifrar 'c' o  descifrar 'd' ?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("mensaje cifrado> " + cifradoCesar(mensaje, cod));
        } else {
            System.out.println("mensaje descifrado> " + descifradoCesar(mensaje, cod));
        }
    }
 
    // Cifrar el texto
    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
 
    // Descifrar el texto
    public static String descifradoCesar(String texto, int codigo) {
        StringBuilder descifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    descifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    descifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    descifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    descifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return descifrado.toString();
    }
}