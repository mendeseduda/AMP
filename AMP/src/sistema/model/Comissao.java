package sistema.model;

import java.util.List;

public class Comissao extends Logavel {

    private final int idComissao;
    private List<Avaliacao> resolucoesAvaliadas;     //atributo que reune todos as resolucoes que este comissario

    public Comissao(int idComissao, String userName, String senha) {
        super(userName, senha);
        this.idComissao = idComissao;
    }

    public List<Avaliacao> getResolucoesAvaliadas() {
        return resolucoesAvaliadas;
    }

    public void setResolucoesAvaliadas(List<Avaliacao> resolucoesAvaliadas) {
        this.resolucoesAvaliadas = resolucoesAvaliadas;
    }

    public void addResolucaoAvaliada(Avaliacao resolucaoAvaliada) {
        resolucoesAvaliadas.add(resolucaoAvaliada);
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
