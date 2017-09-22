package sistema.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Prova {

    private int idProva;
    private File cadernoProva;
    private List<Exercicio> exercicios;

    public Prova(int idProva, File cadernoProva) {
        this.idProva = idProva;
        this.cadernoProva = cadernoProva;
        this.exercicios = new ArrayList<>();
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public File getCadernoProva() {
        return cadernoProva;
    }

    public void setCadernoProva(File cadernoProva) {
        this.cadernoProva = cadernoProva;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    
    
}
