package Login;

public class Autenticacao {
   private String login;
   private String senha;
    
   public Autenticacao(String login, String senha){
       this.login = login;
       this.senha = senha;
   }
   
   public boolean autenticar(){
       if(this.login.equals("admin")&&(this.senha.equals("1234"))){
           return true;
       }
       else{
           return false;
       }
   }
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}