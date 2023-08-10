package introPOO.exercicioQuatro.entities;

public class Student {
    public String name;
    public Double nota1;
    public Double nota2;
    public Double nota3;

    public Student (String name, double nota1, double nota2, double nota3) {
        this.name = name;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public boolean alunoAprovado() {
        return !(nota1 + nota2 + nota3 < 60);
        // else:
    }

    public Double missingPoints() {
        return 60.0 - (nota1 + nota2 + nota3);
    }
}
