package br.com.dorival.petcare.persistence;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
public class Usuario {

    private String nome;

    protected Usuario() {
        
    }
    public Usuario(String nome) {
        this.nome = nome;
    }

    @XmlElement
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
