import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File diretorio = new File("E:\\");
        if (!diretorio.exists()) {
            System.err.println("Diretório não encontrado");
            return;
        }
        try{
            File file = new File(diretorio, "arquivo.txt");
            if (!file.exists())
                file.createNewFile();
            String wildflowerLyrics = "Things fall apart\n and time breaks your heart\n i was not there\n but i know\n she was your girl\n";
            Path path = Paths.get("E:\\arquivo.txt");
            Files.write(path, "".getBytes(StandardCharsets.UTF_8));
            Files.write(path, wildflowerLyrics.getBytes(StandardCharsets.UTF_8));
            List<String> linhas = Files.readAllLines(path);
            linhas.forEach(System.out::println);


            List<String> listaNomes = new ArrayList<>();
            listaNomes.add("Maycon");
            listaNomes.add("Daniel");
            listaNomes.add("Diego");
            StringBuilder nomesWriting = new StringBuilder();
            for (String n : listaNomes) {
                nomesWriting.append(n + "\n");
            }
            File novoArquivo = new File(diretorio, "nomes.txt");
            novoArquivo.createNewFile();
            if(!novoArquivo.exists())
                return;
            Path caminho = Paths.get("E:\\nomes.txt");
            Files.write(caminho, nomesWriting.toString().getBytes(StandardCharsets.UTF_8));

        }catch(Exception err) {
            err.printStackTrace();
        }
    }
}