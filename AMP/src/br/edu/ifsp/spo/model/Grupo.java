package br.edu.ifsp.spo.model;

public class Grupo extends Logavel {

	private int idGrupo;
    private Tutor tutor;

    public Grupo(Tutor tutor, String userName, String senha) {
        super(userName, senha);
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
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

    public int getIdGrupo(){
    	return idGrupo;
    }

    @Override
    public String toString() {
        return "Grupo";
    }

}
