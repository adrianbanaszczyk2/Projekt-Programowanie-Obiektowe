import java.util.ArrayList;
import java.util.List;

public class Pacjent {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String dataUrodzenia;
    private int wiek;
    private String telefonKontaktowy;
    private String adresMailowy;

    private static List<Pacjent> pacjenci = new ArrayList<>();

    public Pacjent(String imie, String nazwisko, String pesel, String dataUrodzenia, int wiek, String telefonKontaktowy, String adresMailowy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.wiek = wiek;
        this.telefonKontaktowy = telefonKontaktowy;
        this.adresMailowy = adresMailowy;
    }

    public static void dodajPacjenta(Pacjent pacjent) {
        pacjenci.add(pacjent);
        System.out.println("Pacjent został dodany.");
    }

    public static void wyswietlPacjentow() {
        if (pacjenci.isEmpty()) {
            System.out.println("Brak pacjentów.");
        } else {
            for (Pacjent pacjent : pacjenci) {
                System.out.println(pacjent);
            }
        }
    }

    public static void znajdzPacjentowPoNazwisku(String nazwisko) {
        boolean found = false;
        for (Pacjent pacjent : pacjenci) {
            if (pacjent.nazwisko.equalsIgnoreCase(nazwisko)) {
                System.out.println("Znaleziony pacjent:");
                System.out.println("Imię: " + pacjent.imie);
                System.out.println("Nazwisko: " + pacjent.nazwisko);
                System.out.println("PESEL: " + pacjent.pesel);
                System.out.println("Data urodzenia: " + pacjent.dataUrodzenia);
                System.out.println("Wiek: " + pacjent.wiek);
                System.out.println("Telefon kontaktowy: " + pacjent.telefonKontaktowy);
                System.out.println("Adres mailowy: " + pacjent.adresMailowy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Brak pacjentów o podanym nazwisku.");
        }
    }

    public static void znajdzPacjentaPoPesel(String pesel) {
        boolean found = false;
        for (Pacjent pacjent : pacjenci) {
            if (pacjent.pesel.equals(pesel)) {
                System.out.println("Znaleziony pacjent:");
                System.out.println("Imię: " + pacjent.imie);
                System.out.println("Nazwisko: " + pacjent.nazwisko);
                System.out.println("PESEL: " + pacjent.pesel);
                System.out.println("Data urodzenia: " + pacjent.dataUrodzenia);
                System.out.println("Wiek: " + pacjent.wiek);
                System.out.println("Telefon kontaktowy: " + pacjent.telefonKontaktowy);
                System.out.println("Adres mailowy: " + pacjent.adresMailowy);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pacjent o podanym PESEL-u nie został znaleziony.");
        }
    }

    @Override
    public String toString() {
        return "Imię: " + imie + "\n" +
                "Nazwisko: " + nazwisko + "\n" +
                "PESEL: " + pesel + "\n" +
                "Data urodzenia: " + dataUrodzenia + "\n" +
                "Wiek: " + wiek + "\n" +
                "Telefon kontaktowy: " + telefonKontaktowy + "\n" +
                "Adres mailowy: " + adresMailowy;
    }
}
