package unopar.br.pojo;

public class Usuario  implements java.io.Serializable {

     private Integer id;
     private String nome;
     private String cpf;
     private String email;
     private String senha;
     private Double saldo;

    public Usuario() {
    }

    public Usuario(String nome, String cpf, String email, String senha, Double saldo) {
       this.nome = nome;
       this.cpf = cpf;
       this.email = email;
       this.senha = senha;
       this.saldo = saldo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Double getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}