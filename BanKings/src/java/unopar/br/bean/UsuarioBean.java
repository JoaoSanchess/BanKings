package unopar.br.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import unopar.br.dao.UsuarioDao;
import unopar.br.pojo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    public Usuario usuario;
    public Usuario destinatario;
    public Double valorTransferencia;
    public List<Usuario> usuarios;

    public UsuarioBean() {
        this.usuario = new Usuario();
        this.destinatario = new Usuario();
        this.usuarios = new ArrayList<>();
    }
    
    public void listar(){
        UsuarioDao uDao = new UsuarioDao();
        this.usuarios = uDao.listar();
    }
    
    public void transferir(){
        UsuarioDao uDao = new UsuarioDao();
        uDao.transferir(valorTransferencia, destinatario, usuario);
    }
    
    public void editar(Usuario p){
        this.destinatario = p;
    }
    
    public void login(){
        UsuarioDao uDao = new UsuarioDao();
        this.usuario = uDao.login(usuario.getCpf(), usuario.getSenha());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Double getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }
    
}