import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrafikLekarzy {
    private static List<GrafikLekarzy> grafikiLekarzy = new ArrayList<>();
    private int idLekarza;
    private String[] godzinyStartu = new String[7];
    private String[] godzinyZakonczenia = new String[7];

    public GrafikLekarzy(int idLekarza) {
        this.idLekarza = idLekarza;
    }

    public static GrafikLekarzy pobierzGrafik(int idLekarza) {
        for (GrafikLekarzy grafik : grafikiLekarzy) {
            if (grafik.idLekarza == idLekarza) {
                return grafik;
            }
        }
        return null;
    }

    public static boolean czyGrafikIstnieje(int idLekarza) {
        return pobierzGrafik(idLekarza) != null;
    }

    public void ustawGodzinyPracy(Scanner scanner) {
        System.out.println("Podaj godziny pracy lekarza na każdy dzień tygodnia:");

        for (int i = 0; i < 7; i++) {
            String dzien = "";
            switch (i) {
                case 0: dzien = "Poniedziałek"; break;
                case 1: dzien = "Wtorek"; break;
                case 2: dzien = "Środa"; break;
                case 3: dzien = "Czwartek"; break;
                case 4: dzien = "Piątek"; break;
                case 5: dzien = "Sobota"; break;
                case 6: dzien = "Niedziela"; break;
            }

            System.out.print("Podaj godzinę rozpoczęcia pracy w dniu " + dzien + " (np. 08:00): ");
            godzinyStartu[i] = scanner.nextLine();

            System.out.print("Podaj godzinę zakończenia pracy w dniu " + dzien + " (np. 16:00): ");
            godzinyZakonczenia[i] = scanner.nextLine();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Grafik lekarza ID: " + idLekarza + "\n");
        String[] dni = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
        for (int i = 0; i < godzinyStartu.length; i++) {
            sb.append(dni[i] + ": " + godzinyStartu[i] + " - " + godzinyZakonczenia[i] + "\n");
        }
        return sb.toString();
    }

    public static void dodajGrafikLekarza(GrafikLekarzy grafik) {
        grafikiLekarzy.add(grafik);
    }
}
