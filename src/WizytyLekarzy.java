import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WizytyLekarzy {
    private static List<WizytyLekarzy> listaWizyt = new ArrayList<>();
    private int idLekarza;
    private int dzienTygodnia; // 0 = Poniedziałek 1 = Wtorek ... 6 = Niedziela
    private LocalTime godzina;

    public WizytyLekarzy(int idLekarza, int dzienTygodnia, LocalTime godzina) throws Exception {
        if (czyTerminZajety(idLekarza, dzienTygodnia, godzina)) {
            throw new Exception("Wybrany termin jest już zajęty.");
        }
        this.idLekarza = idLekarza;
        this.dzienTygodnia = dzienTygodnia;
        this.godzina = godzina;
        listaWizyt.add(this);
    }

    public static boolean czyTerminZajety(int idLekarza, int dzienTygodnia, LocalTime godzina) {
        for (WizytyLekarzy wizyta : listaWizyt) {
            if (wizyta.idLekarza == idLekarza &&
                    wizyta.dzienTygodnia == dzienTygodnia &&
                    wizyta.godzina.equals(godzina)) {
                return true;
            }
        }
        return false;
    }

    public static List<WizytyLekarzy> pobierzWizytyLekarza(int idLekarza) {
        List<WizytyLekarzy> wizytyLekarza = new ArrayList<>();
        for (WizytyLekarzy wizyta : listaWizyt) {
            if (wizyta.idLekarza == idLekarza) {
                wizytyLekarza.add(wizyta);
            }
        }
        return wizytyLekarza;
    }

    @Override
    public String toString() {
        String[] dni = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
        return "Lekarz ID: " + idLekarza + ", Dzień: " + dni[dzienTygodnia] + ", Godzina: " + godzina;
    }
}
