package com.example.pokemoni;

public class IgracPokemon extends Pokemon {
    private int izabranaMagija;
    public IgracPokemon(String ime, int nivo, Magija magija1, Magija magija2){
        super(ime, nivo, magija1, magija2);
        izabranaMagija = 1;  // analogno sto je tako dugme prvo setovano !!!
    }

    public Magija getIzabranaMagija() {
        return izabranaMagija == 1 ? super.getMagija1() : super.getMagija2();
    }

    public void setIzabranaMagija(int i) {
        if(i != 1 && i != 2) return;
        izabranaMagija = i;
    }

    @Override
    public void baciMagiju(Pokemon neprijatelj) {
        neprijatelj.nanesiStetu(this.getIzabranaMagija().getSnaga());
    }
}
