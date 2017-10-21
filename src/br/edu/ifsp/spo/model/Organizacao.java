package br.edu.ifsp.spo.model;

public class Organizacao extends Logavel {

    private final int idOrganizacao;

    public Organizacao(int idOrganizacao, String userName, String senha) {
        super(userName, senha);
        this.idOrganizacao = idOrganizacao;
    }

    public int getIdOrganizacao() {
        return idOrganizacao;
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
        return "Organizacao";
    }

}
