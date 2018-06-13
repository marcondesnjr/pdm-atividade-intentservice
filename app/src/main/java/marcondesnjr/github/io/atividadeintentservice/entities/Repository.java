package marcondesnjr.github.io.atividadeintentservice.entities;


import java.io.Serializable;

public class Repository implements Serializable {

    private String img_url;
    private String nome;
    private String autor;
    private String desc;

    public Repository(String img_url) {
        this.img_url = img_url;
    }

    public Repository(String img_url, String nome, String autor, String desc) {
        this.img_url = img_url;
        this.nome = nome;
        this.autor = autor;
        this.desc = desc;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
