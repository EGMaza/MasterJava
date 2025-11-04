import modelo.Usuario;
import repositorio.Repositorio;
import repositorio.UsuarioRepositorioImpl;
import util.ConexionBaseDatos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TareaJdbc {

    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Usuario> usuarioBase = new UsuarioRepositorioImpl();

            int opcionIndice = 0;

            Map<String, Integer> operaciones = new HashMap();
            operaciones.put("Actualizar", 1);
            operaciones.put("Eliminar", 2);
            operaciones.put("Agregar", 3);
            operaciones.put("Listar", 4);
            operaciones.put("Salir", 5);

            do {

                Object[] opArreglo = operaciones.keySet().toArray();


                Object opcion = JOptionPane.showInputDialog(null,
                        "Seleccione un Operación",
                        "Mantenedor de Usuarios",
                        JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

                if (opcion == null) {
                    int f = JOptionPane.showConfirmDialog(null, "¿Realmente desea cerrar la aplicación?", "Alerta",JOptionPane.OK_CANCEL_OPTION);
                    //JOptionPane.showMessageDialog(null, "Debe seleccionar una operación", "Alerta",JOptionPane.INFORMATION_MESSAGE);
                    if(f==JOptionPane.OK_OPTION){
                        opcionIndice = 5;
                    }
                }
                else {
                    opcionIndice = operaciones.get(opcion.toString());
                    Usuario buscado = null;
                    Long id = null;
                    String idString = "";

                    switch (opcionIndice) {
                        case 1:
                            while (id == null) {

                                idString = JOptionPane.showInputDialog(null, "Primero se debe buscar qué registro se desea actualizar, " +
                                        "por favor introduzca el ID del usuario que desea actualizar", "Actualizar registro", JOptionPane.QUESTION_MESSAGE);

                                if (idString == null) {
                                    break;
                                }

                                try {
                                    id = Long.valueOf(idString);

                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "El valor introducido no es válido, el ID debe" +
                                            " ser un valor numérico mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }

                            if (id != null) {
                                buscado = usuarioBase.porId(id);
                            }

                            if (buscado != null) {

                                JOptionPane.showMessageDialog(null, "Se encontró el siguiente registro de usuario:\n" + buscado.toString() +
                                        "\nA continuación se le solicitarán los nuevos datos para el registro encontrado", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);

                                String nuevoNombre = JOptionPane.showInputDialog(null, "Registro actual: " + buscado.toString() + "\nPor favor escriba el nuevo nombre del usuario:", "Actualizar registro", JOptionPane.QUESTION_MESSAGE);
                                if (nuevoNombre == null) {
                                    JOptionPane.showMessageDialog(null, "Se canceló la actualización del registro, no se modificaron los datos", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }

                                String nuevoPassword = JOptionPane.showInputDialog(null, "Registro actual: " + buscado.toString() + "\nPor favor escriba la nueva contraseña del usuario:", "Actualizar registro", JOptionPane.QUESTION_MESSAGE);
                                if (nuevoPassword == null) {
                                    JOptionPane.showMessageDialog(null, "Se canceló la actualización del registro, no se modificaron los datos", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }


                                boolean emailIncorrecto = true;
                                String nuevoEmail = null;

                                while(emailIncorrecto){
                                    nuevoEmail = JOptionPane.showInputDialog(null, "Registro actual: " + buscado.toString() + "\nPor favor escriba el nuevo Email del usuario:", "Actualizar registro", JOptionPane.QUESTION_MESSAGE);
                                    if (nuevoEmail == null) {
                                        JOptionPane.showMessageDialog(null, "Se canceló la actualización del registro, no se modificaron los datos", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                    if (nuevoEmail.contains("@")){
                                        emailIncorrecto = false;
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(null, "El formato del correo introducido no es correcto", "Actualizar registro",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                if (nuevoEmail == null) {
                                    break;
                                }

                                buscado.setNombre(nuevoNombre);
                                buscado.setPassword(nuevoPassword);
                                buscado.setEmail(nuevoEmail);
                                usuarioBase.guardar(buscado);

                                JOptionPane.showMessageDialog(null, "El registro se actualizó con éxito", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);
                            } else if (idString == null) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se encontró ningún registro con el ID proporcionado", "Actualizar registro", JOptionPane.INFORMATION_MESSAGE);
                            }

                            break;

                        case 2:

                            while (id == null) {

                                idString = JOptionPane.showInputDialog(null, "Por favor introduzca el ID del usuario que desea eliminar", "Eliminar registro", JOptionPane.QUESTION_MESSAGE);

                                if (idString == null) {
                                    break;
                                }

                                try {
                                    id = Long.valueOf(idString);
                                    if (id <= 0) {
                                        JOptionPane.showMessageDialog(null, "El valor introducido no es válido, el ID debe" +
                                                " ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
                                        id = null;
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "El valor introducido no es válido, el ID debe" +
                                            " ser un valor numérico mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                            if (id != null) {
                                buscado = usuarioBase.porId(id);
                            }

                            if (buscado != null) {
                                int e = JOptionPane.showConfirmDialog(null, "Se encontró el siguiente registro:\n" + buscado.toString() + "\n¿Realmente desea eliminarlo?", "Eliminar registro", JOptionPane.OK_CANCEL_OPTION);
                                if (e == JOptionPane.OK_OPTION) {
                                    usuarioBase.eliminar(id);
                                    JOptionPane.showMessageDialog(null, "Registro eliminado con éxito", "Eliminar registro", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Operación cancelada, no se hicieron modificaciones en base de datos", "Eliminar registro", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else if (id != null) {
                                JOptionPane.showMessageDialog(null, "Lo sentimos, no se encontró ningún registro con el ID proporcionado", "Eliminar registro", JOptionPane.INFORMATION_MESSAGE);
                            }

                            break;
                        case 3:

                            String nuevoNombre = JOptionPane.showInputDialog(null,"Por favor escriba el nombre del nuevo usuario:", "Generar nuevo registro", JOptionPane.QUESTION_MESSAGE);
                            if (nuevoNombre == null) {
                                JOptionPane.showMessageDialog(null, "Se canceló la generación del nuevo registro", "Generar nuevo registro", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                            String nuevoPassword = JOptionPane.showInputDialog(null,"Por favor escriba la contraseña del nuevo usuario:", "Generar nuevo registro", JOptionPane.QUESTION_MESSAGE);
                            if (nuevoPassword == null) {
                                JOptionPane.showMessageDialog(null, "Se canceló la generación del nuevo registro", "Generar nuevo registro", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }

                            boolean emailIncorrecto = true;
                            String nuevoEmail = null;

                            while(emailIncorrecto){
                                nuevoEmail = JOptionPane.showInputDialog(null, "Por favor escriba el Email del nuevo usuario:", "Generar nuevo registro", JOptionPane.QUESTION_MESSAGE);
                                if (nuevoEmail == null) {
                                    JOptionPane.showMessageDialog(null, "Se canceló la generación del nuevo registro", "Generar nuevo registro", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                                if (nuevoEmail.contains("@")){
                                    emailIncorrecto = false;
                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "El formato del correo introducido no es correcto", "Generar nuevo registro",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (nuevoEmail == null) {
                                break;
                            }


                            usuarioBase.guardar(new Usuario(nuevoNombre, nuevoPassword, nuevoEmail));
                            JOptionPane.showMessageDialog(null, "El nuevo registro se generó con éxito", "Generar nuevo registro", JOptionPane.INFORMATION_MESSAGE);

                            break;
                        case 4:
                            String lista = usuarioBase.listar().stream()
                                    //.map(a -> a.toString())
                                    .map(Usuario::toString)
                                    .reduce("La lista resultante es la siguiente:\n", (a, b) -> {
                                        return a + b + "\n";
                                    });
                            JOptionPane.showMessageDialog(null, lista, "Listar todos los registros", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                }
            } while (opcionIndice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}