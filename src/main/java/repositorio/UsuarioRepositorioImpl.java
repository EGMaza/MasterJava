package repositorio;

import modelo.Usuario;
import util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")){

            while(rs.next()){
                usuarios.add(crearUsuario(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(usuarios.isEmpty()){
            System.out.println("Lista vacía :(");
        }
        return usuarios;
    }

    @Override
    public void guardar(Usuario usuario) {

        String sql = "";

        if(usuario.getId()!=null && usuario.getId()>0){
            sql = "UPDATE usuarios SET username = ?, password = ?, email = ? WHERE id = ?";
        }
        else{
            sql = "INSERT INTO usuarios(username, password, email) VALUES (?, ?, ?)";
        }

        try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());

            if(usuario.getId()!=null && usuario.getId()>0){
                stmt.setLong(4,usuario.getId());
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuarios WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario porId(Long id) {
        Usuario user = null;
        try(PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM usuarios WHERE id=?")){
            stmt.setLong(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    user = crearUsuario(rs);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    private static Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setId(rs.getLong("id"));
        user.setNombre(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}