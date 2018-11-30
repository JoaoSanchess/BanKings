package unopar.br.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import unopar.br.pojo.Usuario;
import unopar.br.util.HibernateUtil;

public class UsuarioDao implements IDao<Usuario> {

    @Override
    public List<Usuario> listar() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario u");
            List<Usuario> usuarios = query.list();
            if (usuarios.isEmpty() || usuarios == null) {
                return null;
            } else {
                return usuarios;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Usuario>();
        } finally {
            session.close();
        }
    }

    @Override
    public void inserir(Usuario t) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Usuario t) {
        Session session = null;
        Transaction transa = null;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            transa = session.beginTransaction();
            session.saveOrUpdate(t);
            transa.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Usuario t) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Query query = session.createQuery("delete from Usuario p where usuario p.id = :id");
            query = query.setParameter("id", t.getId());
            query.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void transferir(Double valorTransferencia, Usuario destinatario, Usuario origem) {
        origem.setSaldo(origem.getSaldo() - valorTransferencia);
        destinatario.setSaldo(destinatario.getSaldo() + valorTransferencia);
        alterar(origem);
        alterar(destinatario);
    }

    public Usuario login(String cpf, String senha) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Usuario u where cpf=:cpf and senha=:senha");
            query.setParameter("senha", senha);
            query.setParameter("cpf", cpf);
            Usuario usuario = (Usuario) query.uniqueResult();
            if (usuario.equals("") || usuario == null) {
                return null;
            } else {
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
