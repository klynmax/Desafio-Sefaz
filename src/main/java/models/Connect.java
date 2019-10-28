package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.sun.istack.logging.Logger;



public class Connect {
	
	Connection con = null;
	
	public Connect() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive Instalado!");
		}catch (ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost/usuario?useTimezone=true&serverTimezone=America/Sao_Paulo";
		String user = "root";
		String password = "mysql";
		con = DriverManager.getConnection(url, user, password);
	
	}
	
	public void closeConection() throws SQLException{
		
		con.close();
	}
	
	public boolean insertUsuario(Usuario usuario) {
		
		try {
            con.createStatement();

            PreparedStatement preparedStatement = con
                .prepareStatement("insert into Usuario (id, nome, email, senha, ddd, numero, tipo) values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getNome());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setInt(5, usuario.getDdd());
            preparedStatement.setString(6, usuario.getNumero());
            preparedStatement.setString(7, usuario.getTipo());

            preparedStatement.execute();
            return true;
      } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName(), null);
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
            
            return false;

      }
 }
	
	public boolean excluirUsuario(Usuario usuario) {
		try {
			
			con.createStatement();
			PreparedStatement preparedStatement = con
					.prepareStatement("delete from	usuario where id = ?");
			preparedStatement.setInt(1, usuario.getId());
            
			preparedStatement.execute();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
public boolean alterarUsuario(Usuario usuario) {
		
		try {
            con.createStatement();
           
            
            PreparedStatement preparedStatement = con
                .prepareStatement("UPDATE usuario SET nome = ?, email = ?, senha = ?, ddd = ?, numero = ?, tipo = ?" + " WHERE id = ?");
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setInt(4, usuario.getDdd());
            preparedStatement.setString(5, usuario.getNumero());
            preparedStatement.setString(6, usuario.getTipo());
            preparedStatement.setInt(7, usuario.getId());
            preparedStatement.execute();
            preparedStatement.executeUpdate();
            return true;
      } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName(), null);
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
            
            return false;

      }
 }
  
 
 public List<Usuario> listUsuarios() {

      ArrayList<Usuario> lista = new ArrayList<Usuario>();

      Statement st = null;
      ResultSet rs = null;

      try {
            st = con.createStatement();
            String sql = "select * from usuario";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                 Usuario usuario = new Usuario();
                 usuario.setId(rs.getInt(1));
                 usuario.setNome(rs.getString(2));
                 usuario.setEmail(rs.getString(3));
                 usuario.setSenha(rs.getString(4));
                 usuario.setDdd(rs.getInt(5));
                 usuario.setNumero(rs.getString(6));
                 usuario.setTipo(rs.getString(7));
                 lista.add(usuario);
            }

      } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Connect.class.getName(), null);
            lgr.log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

      } finally {
            try {
                 if (rs != null) {
                      rs.close();
                 }
                 if (st != null) {
                      st.close();
                 }
                 if (con != null) {
                      con.close();
                 }

            } catch (SQLException ex) {
                 Logger lgr = Logger.getLogger(Connect.class.getName(), null);
                 lgr.log(java.util.logging.Level.WARNING, ex.getMessage(), ex);
                 
            }
      }
      return lista;
			
	}


}
