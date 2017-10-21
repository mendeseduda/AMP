package br.edu.ifsp.spo;

import br.edu.ifsp.spo.model.Comissao;
import br.edu.ifsp.spo.model.Logavel;

public class Start {

    public static void main(String[] args) {
        Comissao s = new Comissao(0, "userName", "senha");
        s = (Comissao) mudar(s);
        System.out.println(s.getUserName());
        System.out.println(s.getSenha());

    }

    public static Logavel mudar(Logavel l){
        l = new Comissao(1, "eee", "sssss");
        return l;
    }

}
