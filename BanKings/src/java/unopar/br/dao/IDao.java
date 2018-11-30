package unopar.br.dao;

import java.util.List;

public interface IDao<T> {
    public List<T> listar();
    public void inserir(T t);
    public void alterar(T t);
    public void deletar(T t);
}
