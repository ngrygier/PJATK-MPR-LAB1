package Service;

import Models.Pracownik;
import Models.Stanowisko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PracownikService {
    ArrayList<Pracownik> listaPracownikow = new ArrayList<>();


    public void dodajPracownika(Pracownik pracownik){
        for(Pracownik p : listaPracownikow){
            if(p.getEmail().equals(pracownik.getEmail())){
                throw new IllegalArgumentException("Pracownik z podanym adresem email juz istnieje");
            }
        }
        listaPracownikow.add(pracownik);
    }
    public void wyswietlPracownikow(){
        for(Pracownik p: listaPracownikow){
            System.out.println(p + "\n");
        }
    }

    public void szukajPoFirmie(String przykladowaNazwa) {
        for(Pracownik p : listaPracownikow){
            if(p.getNazwaFirmy().equals(przykladowaNazwa)){
                System.out.println(p.getImie() + " " + p.getNazwisko() + "\n");
            }
        }
    }

    public void sortujAlfabetycznie(){
        Comparator<Pracownik> nazwiwskoComparator = new Comparator<Pracownik>() {
            @Override
            public int compare(Pracownik p1, Pracownik p2) {
                return p1.getNazwisko().compareToIgnoreCase(p2.getNazwisko());
            }
        };
        Collections.sort(listaPracownikow, nazwiwskoComparator);
        for(Pracownik p: listaPracownikow){
            System.out.println(p.getImie() + " " + p.getNazwisko() + "\n");
        }
    }

    public HashMap<Stanowisko, ArrayList<Pracownik>> grupujPoStanowisku(){
        HashMap<Stanowisko, ArrayList<Pracownik>> grupowaniePoStanowisku = new HashMap<>();
        for(Stanowisko s: Stanowisko.values()){
            grupowaniePoStanowisku.put(s, new ArrayList<>());
        }

        for(Pracownik p : listaPracownikow){
            Stanowisko stanowisko = p.getStanowisko();
            grupowaniePoStanowisku.get(stanowisko).add(p);

        }
        return grupowaniePoStanowisku;
    }

    public HashMap<Stanowisko, Integer> zliczPracownikow(){
        HashMap<Stanowisko, Integer> zliczaniePracownikow= new HashMap<>();
        for(Stanowisko s: Stanowisko.values()){
           zliczaniePracownikow.put(s, 0);
        }
        for(Pracownik p:listaPracownikow){
            Stanowisko stanowisko = p.getStanowisko();
            zliczaniePracownikow.put(stanowisko, zliczaniePracownikow.get(stanowisko) + 1);
        }
        return zliczaniePracownikow;

    }

    public double statystykaWynagrodzenia(){
        double wszystkieWynagrodzenia = 0;
        double liczbaPracownikow = 0;
        for(Pracownik p: listaPracownikow){
            wszystkieWynagrodzenia += p.getWygnagrodzenie();
            liczbaPracownikow += 1;
        }
        double srednieWynagrodzenie = wszystkieWynagrodzenia / liczbaPracownikow;
        return srednieWynagrodzenie;
    }

    public Pracownik najlepiejPlatny(){
        if(listaPracownikow.isEmpty()) return null;

        Pracownik najlepiejPlatny = listaPracownikow.get(0);
        for(Pracownik p: listaPracownikow){
            if(najlepiejPlatny.getWygnagrodzenie() < p.getWygnagrodzenie()){
                najlepiejPlatny=p;
            }
        }
        return najlepiejPlatny;
    }



    }
