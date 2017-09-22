/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Doente
 */
public class Grupo extends Logavel {

    private final int idGrupo;
    private Tutor tutor;
    private List<Resolucao> resolucao;

    public Grupo(int idGrupo, Tutor tutor, String userName, String senha) {
        super(userName, senha);
        this.idGrupo = idGrupo;
        this.tutor = tutor;
        this.resolucao = new ArrayList<>();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Resolucao> getResolucao() {
        return resolucao;
    }

    public void setResolucao(List<Resolucao> resolucao) {
        this.resolucao = resolucao;
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