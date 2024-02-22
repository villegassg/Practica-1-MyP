import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Clase pública para escribir en un archivo txt la salida del programa.
 */
public class FileToWrite {

    private ArrayList<String> bitacora;
    private File file;

    public FileToWrite(ArrayList<String> bitacora) {
        this.bitacora = bitacora;
        newFile();
    }
    
    private void newFile() {
        file = new File("Bitácora_Práctica_1.txt");
        try {
            BufferedWriter out = 
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(file)));
            for (String s : bitacora) {
                out.write(s + "\n");
            }
            out.close();
        } catch (IOException ioe) {
            System.out.println("Error al tratar de escribir en el archivo. :(");
            System.exit(1);
        }
    }
}
