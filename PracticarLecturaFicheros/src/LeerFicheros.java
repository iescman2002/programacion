import Modulos.Alumnos;
import Modulos.Asignaturas;
import Modulos.Notas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeerFicheros {

    private List<Alumnos> alumnos;
    private List<Asignaturas> asignaturas;
    private List<Notas> notas;

    public LeerFicheros() throws IOException {
        List<String> lineasAlumnos = Files.readAllLines(Paths.get("PracticarLecturaFicheros/Ficheros/Alumnos.txt"));
        List<String> lineasAsignaturas = Files.readAllLines(Paths.get("PracticarLecturaFicheros/Ficheros/Asignaturas.txt"));
        List<String> lineasNotas = Files.readAllLines(Paths.get("PracticarLecturaFicheros/Ficheros/Notas.txt"));

        List<Alumnos> alu = new ArrayList<>();
        for (String linea1 : lineasAlumnos) {
            try {
                String[] alumno = linea1.split(";");
                Alumnos a = new Alumnos(
                        alumno[0],
                        alumno[1],
                        Integer.parseInt(alumno[2]),
                        alumno[3]
                );
            alu.add(a);
            }
            catch (Exception e) {
                System.out.println ("["+ LocalDateTime.now()+"] ERROR: Linea corrupta. Pasando a la siguiente ciudad.");
            }
        }
        this.alumnos = alu;

        List<Asignaturas> asg = new ArrayList<>();
        for (String linea2 : lineasAsignaturas) {
            try {
                String[] asignatura = linea2.split(";");
                Asignaturas a = new Asignaturas(
                        asignatura[0],
                        Integer.parseInt(asignatura[1]),
                        Integer.parseInt(asignatura[2])
                );
                asg.add(a);
            }
            catch (Exception e) {
                System.out.println ("["+ LocalDateTime.now()+"] ERROR: Linea corrupta. Pasando a la siguiente ciudad.");
            }
        }
        this.asignaturas = asg;

        List<Notas> nt = new ArrayList<>();
        for (String linea3 : lineasNotas) {
            try {
                String[] nota = linea3.split(";");
                Notas n = new Notas(
                        nota[0],
                        nota[1],
                        Double.parseDouble(nota[2]),
                        Double.parseDouble(nota[3]),
                        Double.parseDouble(nota[4])
                );
                nt.add(n);
            }
            catch (Exception e) {
                System.out.println ("["+ LocalDateTime.now()+"] ERROR: Linea corrupta. Pasando a la siguiente ciudad.");
            }
        }
        this.notas= nt;
    }
}
