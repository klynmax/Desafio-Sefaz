package managedbeans;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import models.Connect;
import models.Usuario;

//Cadastro de Usuarios
@ManagedBean(name="UsuarioMB")
public class UsuarioManagedBean {
	
	private Usuario usuario = new Usuario();
	
	public String cadastraUsuario() throws SQLException{
		
		Connect con = new Connect();
		
		if(con.insertUsuario(usuario)) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario Cadastrado Com sucesso! Pressione F5 Para Atualizar a Lista", ""));
		} else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao Cadastrar Usuario!", ""));
		}
		
		con.closeConection();
		
		return "";
	}
	
	
//Excluir Usuarios	
public String deletaUsuario() throws SQLException{
		
		Connect con = new Connect();
		
		if(con.excluirUsuario(usuario)) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuário excluido com sucesso! Pressione F5 para atualizar a lista", ""));
		} else {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao Excluir Usuário!", ""));
		}
		
		con.closeConection();
		
		return "";
}

//Atualizar Usuarios
public String updateUsuario() throws SQLException{
	
	Connect con = new Connect();
	
	if(con.alterarUsuario(usuario)) {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuário atualizado com sucesso! Pressione F5 para atualizar a lista", ""));
	} else {
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao Atualizar Usuario!", ""));
	}
	
	con.closeConection();
	
	return "";
}
		
			
	public List<Usuario> getUsuarios() throws SQLException {
		
		Connect con = new Connect();
		List<Usuario> listaUsuarios = con.listUsuarios();
		
		return listaUsuarios;
		
	}
	
	public Usuario getUsuario() {
		
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
	}
		
		
}


