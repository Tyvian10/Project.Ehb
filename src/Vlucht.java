import java.util.ArrayList;

public class Vlucht {
    private int aantalPlaatsenBusiness;
    private final int aantalPlaatsenEconomy;
    private String vertrekPunt;
    private int vluchtCode;
    private String eindBestemming;
    private Vliegtuig vliegtuig;
    private ArrayList<Personeel> personeelsleden = new ArrayList<>(
    );

    public Vlucht(int vluchtCode, String eindBestemming, int aantalPlaatsenEconomy, int aantalPlaatsenBusiness, Vliegtuig vliegtuig, String vertrekPunt) {
        this.vluchtCode = 0;

        this.eindBestemming = eindBestemming;

        this.aantalPlaatsenBusiness = 0;

        this.aantalPlaatsenEconomy = 0;

        this.vluchtCode = vluchtCode;

        this.vliegtuig = vliegtuig;

        this.vertrekPunt = vertrekPunt;


    }

    public int getAantalPlaatsenBusiness() {
        return aantalPlaatsenBusiness;
    }

    public void setAantalPlaatsenBusiness(int aantalPlaatsenBusiness) {
        this.aantalPlaatsenBusiness = aantalPlaatsenBusiness;
    }

    public int getAantalPlaatsenEconomy() {
        return aantalPlaatsenEconomy;
    }

    public String getVertrekPunt() {
        return vertrekPunt;
    }

    public void setVertrekPunt(String vertrekPunt) {
        this.vertrekPunt = vertrekPunt;
    }

    public int getVluchtCode() {
        return vluchtCode;
    }

    public void setVluchtCode(int vluchtCode) {
        this.vluchtCode = vluchtCode;
    }

    public String getEindBestemming() {
        return eindBestemming;
    }

    public void setEindBestemming(String eindBestemming) {
        this.eindBestemming = eindBestemming;
    }

    public Vliegtuig getVliegtuig() {
        return vliegtuig;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        this.vliegtuig = vliegtuig;
    }

    public ArrayList<Personeel> getPersoneelsleden() {
        return personeelsleden;
    }

    public void setPersoneelsleden(ArrayList<Personeel> personeelsleden) {
        this.personeelsleden = personeelsleden;
    }

    public void voegPersoneelToe(Personeel gekozenPersoneel) {
    }
}

