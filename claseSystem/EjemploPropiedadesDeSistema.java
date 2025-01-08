package claseSystem;

import java.util.Properties;
public class EjemploPropiedadesDeSistema {
    
    public static void main(String[] args) {
        
        String username = System.getProperty("user.name");
        System.out.println("username = " +  username);

        String home = System.getProperty("user.home");
        System.out.println("home = " + home);

        String workspace = System.getProperty("user.dir");
        System.out.println("workspace = " + workspace);

        String java = System.getProperty("java.version");
        System.out.println("java = " + java);

        String LineSeparator = System.getProperty("line.separator");
        System.out.println("LineSeparator = " + LineSeparator + "Una liena nueva...");

        String LineSeparator2 = System.lineSeparator();
        System.out.println("LineSeparator2 = " + LineSeparator2 + "Una liena nueva...");

        Properties p = System.getProperties();
        p.list(System.out);

    }
}
