package sistema.model;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Logavel {

    private final int idTutor;
    private List<Grupo> gruposTutorados;

    public Tutor(int idTutor, String userName, String senha) {
        super(userName, senha);
        this.idTutor = idTutor;
        gruposTutorados = new ArrayList<>();
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void addGrupoTutorado(Grupo grupo) {
        gruposTutorados.add(grupo);
    }

    public List<Grupo> getGruposTutorados() {
        return gruposTutorados;
    }

    public void setGruposTutorados(List<Grupo> gruposTutorados) {
        this.gruposTutorados = gruposTutorados;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Tutor";
    }

}
