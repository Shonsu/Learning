package pl.shonsu.streams;

import java.util.Objects;

public class Adres {
    private String kodPocztowy;
    private String miejscowosc;
    private String ulica;


    public Adres() {
    }

    public Adres(String kodPocztowy, String miejscowosc, String ulica) {
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
    }

    public String getKodPocztowy() {
        return this.kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return this.miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return this.ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Adres kodPocztowy(String kodPocztowy) {
        setKodPocztowy(kodPocztowy);
        return this;
    }

    public Adres miejscowosc(String miejscowosc) {
        setMiejscowosc(miejscowosc);
        return this;
    }

    public Adres ulica(String ulica) {
        setUlica(ulica);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Adres)) {
            return false;
        }
        Adres adres = (Adres) o;
        return Objects.equals(kodPocztowy, adres.kodPocztowy) && Objects.equals(miejscowosc, adres.miejscowosc) && Objects.equals(ulica, adres.ulica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kodPocztowy, miejscowosc, ulica);
    }

    @Override
    public String toString() {
        return "{" +
            " kodPocztowy='" + getKodPocztowy() + "'" +
            ", miejscowosc='" + getMiejscowosc() + "'" +
            ", ulica='" + getUlica() + "'" +
            "}";
    }
    
}
