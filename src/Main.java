import Models.Pracownik;
import Models.Stanowisko;
import Service.PracownikService;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        PracownikService service = new PracownikService();


        Pracownik p1 = new Pracownik("Nadia", "Grygier", "TechCorp", "ngrygier@techcorp.com", Stanowisko.PROGRAMISTA);
        Pracownik p2 = new Pracownik("Anna", "Lobejko", "BiznesSoft", "anna.lobejo@biznessoft.com", Stanowisko.MANAGER);
        Pracownik p3 = new Pracownik("Michalina", "Lenska", "TechCorp", "michalinka123@techcorp.com", Stanowisko.STAZYSTA);
        Pracownik p4 = new Pracownik("Ela", "Wiśniowska", "BiznesSoft", "elawisniowska@biznessoft.com", Stanowisko.WICEPREZES);
        Pracownik p5 = new Pracownik("Ewa", "Makowka", "TechCorp", "makowskamusic@techcorp.com", Stanowisko.PREZES);


        service.dodajPracownika(p1);
        service.dodajPracownika(p2);
        service.dodajPracownika(p3);
        service.dodajPracownika(p4);
        service.dodajPracownika(p5);

        System.out.println("=== Lista pracowników ===");
        service.wyswietlPracownikow();

        System.out.println("=== Wyszukiwanie po firmie: TechCorp ===");
        service.szukajPoFirmie("TechCorp");

        System.out.println("=== Sortowanie alfabetyczne ===");
        service.sortujAlfabetycznie();

        System.out.println("=== Grupowanie po stanowisku ===");
        HashMap<Stanowisko, ArrayList<Pracownik>> grupy = service.grupujPoStanowisku();
        for (Stanowisko s : grupy.keySet()) {
            System.out.println(s + ": " + grupy.get(s).size() + " pracownik(ów)");
        }

        System.out.println("=== Zliczanie pracowników po stanowisku ===");
        HashMap<Stanowisko, Integer> zlicz = service.zliczPracownikow();
        for (Stanowisko s : zlicz.keySet()) {
            System.out.println(s + ": " + zlicz.get(s));
        }

        System.out.println("=== Statystyka wynagrodzeń (średnia) ===");
        System.out.println("Średnie wynagrodzenie: " + service.statystykaWynagrodzenia());

        System.out.println("=== Najlepiej płatny pracownik ===");
        System.out.println(service.najlepiejPlatny());
    }
}
