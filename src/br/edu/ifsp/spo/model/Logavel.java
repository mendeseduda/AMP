package br.edu.ifsp.spo.model;

public abstract class Logavel {

    protected String userName;
    protected String senha;

    public Logavel(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
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
    public abstract String toString();    
}
