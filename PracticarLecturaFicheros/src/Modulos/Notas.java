package Modulos;

public class Notas {
    private String asignatura;
    private String dniAlumno;
    private Double nota_Trimestre1;
    private Double nota_Trimestre2;
    private Double nota_Trimestre3;
    private Double nota_Final;

    public Notas(String asignatura, String DNI_Alumno, Double nota_Trimestre1, Double nota_Trimestre2, Double nota_Trimestre3) {
        this.asignatura = asignatura;
        this.dniAlumno = DNI_Alumno;
        this.nota_Trimestre1 = nota_Trimestre1;
        this.nota_Trimestre2 = nota_Trimestre2;
        this.nota_Trimestre3 = nota_Trimestre3;
        this.nota_Final = (nota_Trimestre1+nota_Trimestre2+nota_Trimestre3)/3;
    }

    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public Double getNota_Trimestre1() {
        return nota_Trimestre1;
    }
    public void setNota_Trimestre1(Double nota_Trimestre1) {
        this.nota_Trimestre1 = nota_Trimestre1;
    }

    public Double getNota_Trimestre2() {
        return nota_Trimestre2;
    }
    public void setNota_Trimestre2(Double nota_Trimestre2) {
        this.nota_Trimestre2 = nota_Trimestre2;
    }

    public Double getNota_Trimestre3() {
        return nota_Trimestre3;
    }
    public void setNota_Trimestre3(Double nota_Trimestre3) {
        this.nota_Trimestre3 = nota_Trimestre3;
    }

    public Double getNota_Final() {
        return nota_Final;
    }
    public void setNota_Final(Double nota_Final) {
        this.nota_Final = nota_Final;
    }
}
