import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {2, 4, 10, 5, 15, 3};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /*
            ArrayList é um tipo de lista baseado na performance, do qual não possui regras relacionado a ordem / classificação dos valores.
         */
        List<String> games = new ArrayList<>();
        System.out.println(games.size());
        for (String i : new String[]{"GTA V", "LOL", "Minecraft", "Roblox", "Forza H 5"}) {
            games.add(i);
        }
        System.out.println(games.size());
        games.indexOf("GTA V");

        // HashSet é um tipo de lista que não permite indexação, duplicidade e possui mais regras em relação ao ArrayList e ele re-ordena
        HashSet hashSet = new HashSet();
        for (String i : new String[]{"GTA V", "LOL", "Minecraft", "Roblox", "Forza H 5"}) {
            hashSet.add(i);
        }

        // Semelhante ao HashSet, porém este não ordena
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        // Ordenação com padrão humano alfanumérico ----> não performático
        TreeSet treeSet = new TreeSet();

        Maps map = new Maps();
        try{
            Object result = map.createMap("activee");
            System.out.println(result);
        }catch(Exception err) {
            err.printStackTrace();
        }
    }
}
