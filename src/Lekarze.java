import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Lekarze {
    private static int lastId = 0;

    private int id;
    private String specjalizacja;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String dataUrodzenia;
    private int wiek;
    private String telefonKontaktowy;
    private String adresMailowy;

    private static List<Lekarze> lekarze = new ArrayList<>();

    public Lekarze(String specjalizacja, String imie, String nazwisko, String pesel, String dataUrodzenia, int wiek, String telefonKontaktowy, String adresMailowy) {
        this.id = ++lastId;
        this.specjalizacja = specjalizacja;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.wiek = wiek;
        this.telefonKontaktowy = telefonKontaktowy;
        this.adresMailowy = adresMailowy;
    }

    public int getId() {
        return id;
    }

    public void dodajSpecjalizacje(String nowaSpecjalizacja) {
        this.specjalizacja += ", " + nowaSpecjalizacja;
    }

    public static Lekarze znajdzLekarzaPoId(int id) {
        for (Lekarze lekarz : lekarze) {
            if (lekarz.getId() == id) {
                return lekarz;
            }
        }
        return null;
    }

    public static void dodajLekarza(Lekarze lekarz) {
        lekarze.add(lekarz);
        System.out.println("Lekarz został dodany. ID lekarza: " + lekarz.id);
    }

    public static void wyswietlLekarzy() {
        if (lekarze.isEmpty()) {
            System.out.println("Brak lekarzy.");
        } else {
            for (Lekarze lekarz : lekarze) {
                System.out.println(lekarz);
            }
        }
    }
    public static List<Lekarze> znajdzLekarzyPoSpecjalizacji(String specjalizacja) {
        List<Lekarze> znalezieniLekarze = new ArrayList<>();
        for (Lekarze lekarz : lekarze) {
            if (lekarz.specjalizacja.contains(specjalizacja)) {
                znalezieniLekarze.add(lekarz);
            }
        }
        return znalezieniLekarze;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Specjalizacja: " + specjalizacja + "\n" +
                "Imię: " + imie + "\n" +
                "Nazwisko: " + nazwisko + "\n" +
                "PESEL: " + pesel + "\n" +
                "Data urodzenia: " + dataUrodzenia + "\n" +
                "Wiek: " + wiek + "\n" +
                "Telefon kontaktowy: " + telefonKontaktowy + "\n" +
                "Adres mailowy: " + adresMailowy;
    }
}
