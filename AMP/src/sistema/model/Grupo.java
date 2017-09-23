package sistema.model;

public class Grupo extends Logavel {

    private final int idGrupo;
    private Tutor tutor;

    public Grupo(int idGrupo, Tutor tutor, String userName, String senha) {
        super(userName, senha);
        this.idGrupo = idGrupo;
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public int getIdGrupo() {
        return idGrupo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Grupo";
    }

}
