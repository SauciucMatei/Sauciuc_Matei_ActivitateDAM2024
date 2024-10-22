package com.example.seminar4;

public class Masina {
    private int nrUsi;
    private String nume;
    private String tipMasina;
    private String marca;
    private int anFabricatie;

    public int getNrUsi() {
        return nrUsi;
    }

    public String getNume() {
        return nume;
    }

    public String getTipMasina() {
        return tipMasina;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setNrUsi(int nrUsi) {
        this.nrUsi = nrUsi;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setTipMasina(String tipMasina) {
        this.tipMasina = tipMasina;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public Masina(int nrUsi, String nume, String tipMasina, String marca, int anFabricatie) {
        this.nrUsi = nrUsi;
        this.nume = nume;
        this.tipMasina = tipMasina;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nrUsi=" + nrUsi +
                ", nume='" + nume + '\'' +
                ", tipMasina='" + tipMasina + '\'' +
                ", marca='" + marca + '\'' +
                ", anFabricatie=" + anFabricatie +
                '}';
    }
}
