package com.example.pokemoni;
/*  Napraviti apstraktnu klasu Pokemon koja predstavlja Pokemona. Klasa se karakteriše sledećim atributima:
        • String ime - ime Pokemona
        • int nivo - nivo Pokemona (broj koji najmanje može biti 1)
        • Magija magija1 - prva magija koju poseduje Pokemon
        • Magija magija2 - druga magija koju poseduje Pokemon
        • int zivot - procenat života Pokemona (na početku 100)
    Implementirati konstruktor koji prihvata ime, nivo, magija1, magija2, a zivot postavlja na 100. Implementirati
    potrebne get metode. Implementirati metod void nanesiStetu(int kolikoStete) koji umanjuje zivot za vrednost
    kolikoStete. Klasa poseduje apstraktan metod public abstract void baciMagiju(Pokemon neprijatelj).
    Implementirati toString tako da pokemone ispisuje na sledeći način:
        [nivo] ime
        [lvl3] Pikachu
        [lvl4] Bulbasaur
        [lvl9] MewTwo */
public abstract class Pokemon implements Comparable<Pokemon> {
    private String ime;
    private int nivo;
    private Magija magija1;
    private Magija magija2;
    private int zivot = 100;  // moze inici ofc
    public Pokemon(String ime, int nivo, Magija magija1, Magija magija2){
        this.ime = ime;
        this.nivo = nivo;
        this.magija1 = magija1;
        this.magija2 = magija2;
    }

    public String getIme() {
        return ime;
    }

    public int getNivo() {
        return nivo;
    }

    public Magija getMagija1() {
        return magija1;
    }

    public Magija getMagija2() {
        return magija2;
    }

    public int getZivot() {
        return zivot;
    }
    public void nanesiStetu(int kolikoStete){  // public da ga mozemo zvati iz maina!
        this.zivot -= kolikoStete;
    }
    public abstract void baciMagiju(Pokemon neprijatelj);

    @Override
    public int compareTo(Pokemon o) {
        if(this instanceof IgracPokemon && o instanceof CpuPokemon){
            return -1;
        }
        else if(this instanceof CpuPokemon && this instanceof IgracPokemon){
            return 1;
        }
        else{
            return Integer.compare(o.getNivo(), this.getNivo());
        }
    }

    @Override
    public String toString() {
        return "lvl" + nivo + " " + ime;
    }
}
