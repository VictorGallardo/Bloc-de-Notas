package blocnotas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 *
 */
public class BlocNotas {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    int opcion = 0;
    do {
      System.out.println("");
      System.out.println("BLOC DE NOTAS");
      System.out.println("Menu");
      System.out.println("-------------");
      System.out.println("1. Nueva nota\n2. Leer notas\n3. Combinar notas\n4. Pasar a Mayusculas\n5. Borrar nota\n6. Salir");
      System.out.println("");
      opcion = Integer.parseInt(s.nextLine());
      
      switch (opcion) {
        case 1:
          System.out.println("Introduzca el nombre de su nueva nota");
          String nomNota = s.nextLine();
          System.out.println("Escriba su nota y pulse ENTER para guardar");
          String textNota = s.nextLine();
          try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomNota + ".txt"));
            bw.write(textNota);
            bw.close();
          } catch (IOException ioe) {
            System.out.println("No se ha podido escribir en el fichero");
          }
          break;
        case 2:
          System.out.println("¿Que nota quieres leer? Introduzca el nomnre de la nota");
          nomNota = s.nextLine();

          try {
            BufferedReader br = new BufferedReader(new FileReader(nomNota + ".txt"));
            String linea = "";
            while (linea != null) {
              System.out.println(linea);
              linea = br.readLine();
            }

            br.close();
          } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el fichero primos.dat");
          } catch (IOException ioe) {
            System.out.println("No se puede leer el fichero primos.dat");
          }
          break;
        case 3:
          System.out.println("Introduce el nombre del fichero 1:");
          String nota1 = s.nextLine();
          System.out.println("Introduce el nombre del fichero 2:");
          String nota2 = s.nextLine();
          System.out.println("Introduce el nombre del fichero resultante:");
          String nuevaN = s.nextLine();

          try {
            BufferedReader br1 = new BufferedReader(new FileReader(nota1 + ".txt"));
            BufferedReader br2 = new BufferedReader(new FileReader(nota2 + ".txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nuevaN + ".txt"));

            String line1 = "";
            String line2 = "";

            while (line1 != null || line2 != null) {
              line1 = br1.readLine();
              line2 = br2.readLine();

              if (line1 != null) {
                bw.write(line1 + "\n");
              }

              if (line2 != null) {
                bw.write(line2 + "\n");
              }
            }

            br1.close();
            br2.close();
            bw.close();

          } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el fichero");
          } catch (IOException ioe) {
            System.out.println("No se puede leer el fichero");
          }
          break;
        case 4:
          System.out.println("Introduzca el nombre de la nota que cambiar a mayúsculas");
          nomNota = s.nextLine();
          System.out.println("Introduzca el nombre de la nueva nota ");
          String nuevaNo = s.nextLine();

          try {
            BufferedReader br = new BufferedReader(new FileReader(nomNota + ".txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nuevaNo + ".txt"));

            String texto = "";

            texto = br.readLine();
            if (texto != null) {
              bw.write(texto.toUpperCase() + "\n");
            }
            br.close();
            bw.close();

          } catch (FileNotFoundException fnfe) {
            System.out.println("No se encuentra el fichero");
          } catch (IOException ioe) {
            System.out.println("No se puede leer el fichero");
          }
          break;
        case 5:
          System.out.println("Introduzca el nombre de la nota que desea borrar");
          nomNota = s.nextLine();
          nomNota += ".txt";
          File nota = new File(nomNota);
          if (nota.exists()) {
            nota.delete();
          } else {
            System.out.println("Lo siento no se ha encontrado ninguna nota con el nombre " + nomNota);
          }
          break;
        case 6:
          break;
        default:
          System.out.println("Esa opción no es valida (Solo opciones: 1-2-3-4-5-6)");
          break;
      }
    } while (opcion != 6);
    s.close();
  }
}
