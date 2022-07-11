package modelo;
/**
 *
 * @author Irwin
 */
public class Livro {
    
    private int id;
    private String nome;
    private String autor;
    private String edicao;
    private String editora;

    public Livro(String nome, String autor, String edicao, String editora) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.edicao = edicao;
        this.editora = editora;
    }

//    public Livro(String nome, String edicao, String editora) {
//   
//    }

//    public Livro(String nome, String edicao, String editora) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
}
