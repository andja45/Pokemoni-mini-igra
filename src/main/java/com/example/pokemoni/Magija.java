package com.example.pokemoni;
/*  Napraviti klasu Magija koju karakterišu atributi snaga (int) i ime (String). Implementirati get metode za navedene
    atribute, konstruktor koji prihvata vrednosti za oba atributa i konstruktor kopije. Implementirati toString metod da
    ispisuje magiju u obliku:
        ime snaga */
public class Magija {
    private int snaga;
    private String ime;
    public Magija(int snaga, String ime){
        this.snaga = snaga;
        this.ime = ime;
    }
    public Magija(Magija m){
        this(m.getSnaga(), m.getIme());
    }

    public int getSnaga() {
        return snaga;
    }

    public String getIme() {
        return ime;
    }

    @Override
    public String toString() {
        return ime + " " + snaga;
    }
}
