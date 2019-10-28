package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import models.Usuario;

public class UsuarioDao {
	
	public void alterar(Usuario usuario) {
		
		try {
			
			Connection connection = getConnection();
			
			PreparedStatement pstmt = connection
					.prepareStatement("Update usuario SET nome = ?, email = ?, senha = ?, ddd = ?, numero = ?, tipo = ?"
							+ " WHERE matricula = ? ");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setInt(4, usuario.getDdd());
			pstmt.setString(5, usuario.getNumero());
			pstmt.setString(6, usuario.getNumero());
			pstmt.setString(4, usuario.getTipo());
			pstmt.execute();
			pstmt.close();
			connection.close();
			
		} catch (Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	public void excluir(Usuario usuario) {
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("Delete from	usuario where email = ?, senha = ? ");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(1, usuario.getSenha());
			pstmt.execute();
			pstmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
