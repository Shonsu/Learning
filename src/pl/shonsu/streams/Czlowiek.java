package pl.shonsu.streams;


import java.util.List;
import java.util.Objects;

public class Czlowiek {
    private String imie;
    private int wiek;
    private List<Czlowiek> dzieci;
    private Adres adres;


    public Czlowiek() {
    }

    public Czlowiek(String imie, int wiek, List<Czlowiek> dzieci, Adres adres) {
        this.imie = imie;
        this.wiek = wiek;
        this.dzieci = dzieci;
        this.adres = adres;
    }

    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return this.wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public List<Czlowiek> getDzieci() {
        return this.dzieci;
    }

    public void setDzieci(List<Czlowiek> dzieci) {
        this.dzieci = dzieci;
    }

    public Adres getAdres() {
        return this.adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Czlowiek imie(String imie) {
        setImie(imie);
        return this;
    }

    public Czlowiek wiek(int wiek) {
        setWiek(wiek);
        return this;
    }

    public Czlowiek dzieci(List<Czlowiek> dzieci) {
        setDzieci(dzieci);
        return this;
    }

    public Czlowiek adres(Adres adres) {
        setAdres(adres);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Czlowiek)) {
            return false;
        }
        Czlowiek czlowiek = (Czlowiek) o;
        return Objects.equals(imie, czlowiek.imie) && wiek == czlowiek.wiek && Objects.equals(dzieci, czlowiek.dzieci) && Objects.equals(adres, czlowiek.adres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, wiek, dzieci, adres);
    }

    @Override
    public String toString() {
        return "{" +
            " imie='" + getImie() + "'" +
            ", wiek='" + getWiek() + "'" +
            ", dzieci='" + getDzieci() + "'" +
            ", adres='" + getAdres() + "'" +
            "}";
    }
    

    
}
