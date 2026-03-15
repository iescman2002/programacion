import java.io.*;

public class Logs {

    public Logs(String mensaje) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("PracticarLecturaFicheros/Errores.log",true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
