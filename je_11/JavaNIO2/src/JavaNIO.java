import java.io.Console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaNIO {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("E:\\nomes.txt");
            List<String> strings = Files.readAllLines(path);

            List<Usuario> usuarios = new ArrayList<Usuario>();
            for (String user : strings) {
                Usuario novoUsuario = new Usuario();
                int i = 0;
                Scanner scan = new Scanner(user);
                scan.useDelimiter(";");
                while (scan.hasNext()) {
                    if (i == 0) {
                        novoUsuario.nome = scan.next();
                    } else {
                        novoUsuario.sallary = Double.parseDouble((scan.next()));
                    }
                    i++;
                }
                usuarios.add(novoUsuario);
            }
            for (Usuario usuario : usuarios) {
                System.out.printf("Funcionário: %s está atualmente recebendo %s\n", usuario.nome, usuario.sallary);
            }

            System.out.println("Caso deseje efetuar uma atualização, digite 1");
            
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
