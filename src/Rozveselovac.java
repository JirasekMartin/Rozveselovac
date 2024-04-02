import java.util.Scanner;
public class Rozveselovac {
    public static void main(String[] args) {
        // Načtení vstupu
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Zadej text k rozveselení: ");
        String text = scanner.nextLine();
        // Pomocná pole
        String interpunkce = "!?.";
        String[] smajlici = {":)", ":D", ":P"};
        // Čtení věty
        int pozice = 0;
        int smajlik = 0;
        while (pozice < text.length()) {
            // narazilo se na interpunkci
            if (interpunkce.contains(String.valueOf(text.charAt(pozice)))) {
                // Odstranění tečky
                if (text.charAt(pozice) == '.') {
                    text = text.substring(0, pozice) + text.substring(pozice + 1);
                    pozice--;
                }
                // Vložení smajlíku
                text = text.substring(0, pozice + 1) + " " + smajlici[smajlik] + text.substring(pozice + 1);
                pozice++;
                // Úprava pozice příštího smajlíku
                smajlik++;
                if (smajlik > smajlici.length - 1) {
                    smajlik = 0;
                }
            }
            pozice++;
        }
        // Výpis
        System.out.println("Rozveselený text: " + text);
    }
}