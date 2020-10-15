package negocio.interfaces;
import data.UserRepo;
public interface IUserController {
  boolean mudarNome(int usuarioAtual);
  boolean mudarSenha();
  boolean mudarEmail();

}
