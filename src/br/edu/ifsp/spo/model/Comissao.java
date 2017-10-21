package br.edu.ifsp.spo.model;

public class Comissao extends Logavel {

    private final int idComissao;

    public Comissao(int idComissao, String userName, String senha) {
        super(userName, senha);
        this.idComissao = idComissao;
    }

    public int getIdComissao() {
        return idComissao;
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
        return "Comissao";
    }

}
