package repositorio;

import java.util.ArrayList;
import java.util.List;
import modelo.Livro;

/**
 *
 * @author Irwin
 */
public class RepositorioLivro {

    private static int ultimoCodigo = 1;

    private static List<Livro> livro = new ArrayList<>();

    public static void inserir(Livro l) {
        l.setId(ultimoCodigo++);
        livro.add(l);
    }

    public static Livro ler(int id) {
        for (Livro l : livro) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public static List<Livro> lerTudo() {
        return livro;
    }

//    public static void alterar(Livro l) {
//
//        
//    }
    public static void alterar(Livro l) {
        for (Livro cont : livro) {
            if (cont.getId() == l.getId()) {
                cont.setNome(l.getNome());
                cont.setAutor(l.getAutor());
                cont.setEdicao(l.getEdicao());
                cont.setEditora(l.getEditora());
            }
            return;
        }
    }

    public static void delete(Livro l) {

        Livro cAux = null;

        for (Livro cont : livro) {
            if (cont.getId() == l.getId()) {
                cAux = cont;
                break;
            }
        }

        livro.remove(cAux);

    }
}
