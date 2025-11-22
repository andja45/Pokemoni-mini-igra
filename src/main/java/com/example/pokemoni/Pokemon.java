package com.example.pokemoni;

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
