import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<GrafikLekarzy> grafikiLekarzy = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Pacjenci");
            System.out.println("2. Lekarze");
            System.out.println("3. Dokumentacja");
            System.out.println("4. Grafik Lekarzy");
            System.out.println("5. Wizyty lekarskie");
            System.out.println("6. Zakończ");

            int opcja = scanner.nextInt();
            scanner.nextLine();

            switch (opcja) {
                case 1:
                    menuPacjenci(scanner);
                    break;
                case 2:
                    menuLekarze(scanner);
                    break;
                case 3:
                    System.out.println("Sekcja 'Dokumentacja' w trakcie implementacji.");
                    break;
                case 4:
                    menuGrafikLekarzy(scanner);
                    break;
                case 5:
                    System.out.println("Sekcja 'Wizyty lekarskie' w trakcie implementacji.");
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }

        scanner.close();
    }

    private static void menuPacjenci(Scanner scanner) {

    }

    private static void menuLekarze(Scanner scanner) {
        boolean lekarzeMenu = true;

        while (lekarzeMenu) {
            System.out.println("\n--- MENU LEKARZY ---");
            System.out.println("1. Dodaj lekarza");
            System.out.println("2. Wyświetl wszystkich lekarzy");
            System.out.println("3. Dodaj specjalizację lekarzowi");
            System.out.println("4. Wyszukaj lekarza po ID");
            System.out.println("5. Wyszukaj lekarzy po specjalizacji");
            System.out.println("6. Powrót do głównego menu");

            int opcjaLekarze = scanner.nextInt();
            scanner.nextLine();

            switch (opcjaLekarze) {
                case 1:
                    dodajLekarza(scanner);
                    break;
                case 2:
                    Lekarze.wyswietlLekarzy();
                    break;
                case 3:
                    dodajSpecjalizacjeLekarzowi(scanner);
                    break;
                case 4:
                    wyszukajLekarzaPoId(scanner);
                    break;
                case 5:
                    wyszukajLekarzyPoSpecjalizacji(scanner);
                    break;
                case 6:
                    lekarzeMenu = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }

    private static void wyszukajLekarzyPoSpecjalizacji(Scanner scanner) {
        System.out.print("Podaj specjalizację, którą chcesz wyszukać: ");
        String specjalizacja = scanner.nextLine();

        List<Lekarze> znalezieniLekarze = Lekarze.znajdzLekarzyPoSpecjalizacji(specjalizacja);

        if (znalezieniLekarze.isEmpty()) {
            System.out.println("Nie znaleziono lekarzy o specjalizacji: " + specjalizacja);
        } else {
            System.out.println("Znalezieni lekarze:");
            for (Lekarze lekarz : znalezieniLekarze) {
                System.out.println(lekarz);
                System.out.println("-------------------------");
            }
        }
    }

    private static void wyszukajLekarzaPoId(Scanner scanner) {
        System.out.print("Podaj ID lekarza, którego chcesz wyszukać: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Lekarze lekarz = Lekarze.znajdzLekarzaPoId(id);

        if (lekarz == null) {
            System.out.println("Lekarz o podanym ID nie istnieje.");
        } else {
            System.out.println("Znaleziono lekarza:");
            System.out.println(lekarz);
        }
    }


    private static void dodajSpecjalizacjeLekarzowi(Scanner scanner) {
        System.out.print("Podaj ID lekarza, któremu chcesz dodać specjalizację: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Lekarze lekarz = Lekarze.znajdzLekarzaPoId(id);

        if (lekarz == null) {
            System.out.println("Lekarz o podanym ID nie istnieje.");
            return;
        }

        System.out.print("Podaj nową specjalizację: ");
        String nowaSpecjalizacja = scanner.nextLine();

        lekarz.dodajSpecjalizacje(nowaSpecjalizacja);
        System.out.println("Specjalizacja została dodana.");
    }

    private static void dodajLekarza(Scanner scanner) {
        System.out.print("Podaj specjalizację (kardiolog, ortopeda, stomatolog): ");
        String specjalizacja = scanner.nextLine();

        while (!specjalizacja.equalsIgnoreCase("kardiolog") &&
                !specjalizacja.equalsIgnoreCase("ortopeda") &&
                !specjalizacja.equalsIgnoreCase("stomatolog")) {
            System.out.println("Nieprawidłowa specjalizacja. Wybierz spośród: kardiolog, ortopeda, stomatolog.");
            specjalizacja = scanner.nextLine();
        }

        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();

        System.out.print("Podaj PESEL: ");
        String pesel = scanner.nextLine();

        System.out.print("Podaj datę urodzenia (np. 1980-05-15): ");
        String dataUrodzenia = scanner.nextLine();

        System.out.print("Podaj wiek: ");
        int wiek = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Podaj telefon kontaktowy: ");
        String telefonKontaktowy = scanner.nextLine();

        System.out.print("Podaj adres mailowy: ");
        String adresMailowy = scanner.nextLine();

        Lekarze lekarz = new Lekarze(specjalizacja, imie, nazwisko, pesel, dataUrodzenia, wiek, telefonKontaktowy, adresMailowy);
        Lekarze.dodajLekarza(lekarz);
    }

    private static void menuGrafikLekarzy(Scanner scanner) {
        boolean grafikMenu = true;

        while (grafikMenu) {
            System.out.println("\n--- MENU GRAFIKU LEKARZY ---");
            System.out.println("1. Dodaj grafik dla lekarza");
            System.out.println("2. Wyświetl grafik lekarza");
            System.out.println("3. Powrót do głównego menu");

            int opcjaGrafik = scanner.nextInt();
            scanner.nextLine();

            switch (opcjaGrafik) {
                case 1:
                    System.out.print("Podaj ID lekarza: ");
                    int idLekarza = scanner.nextInt();
                    scanner.nextLine();

                    if (GrafikLekarzy.czyGrafikIstnieje(idLekarza)) {
                        System.out.println("Lekarz o ID " + idLekarza + " ma już ustalony grafik.");
                    } else {
                        GrafikLekarzy.dodajGrafikLekarza(new GrafikLekarzy(idLekarza));
                        GrafikLekarzy.pobierzGrafik(idLekarza).ustawGodzinyPracy(scanner);
                        System.out.println("Grafik został dodany.");
                    }
                    break;
                case 2:
                    System.out.print("Podaj ID lekarza: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    GrafikLekarzy grafik = GrafikLekarzy.pobierzGrafik(id);
                    if (grafik != null) {
                        System.out.println(grafik);
                    } else {
                        System.out.println("Grafik dla lekarza o ID " + id + " nie istnieje.");
                    }
                    break;
                case 3:
                    grafikMenu = false;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }
        }
    }
}
