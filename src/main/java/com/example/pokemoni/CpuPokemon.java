package com.example.pokemoni;

import java.util.Random;

public class CpuPokemon extends Pokemon{
    private Magija PoslednjaBacena;

    public Magija getPoslednjaBacena() {
        return PoslednjaBacena;
    }

    private static Random random = new Random();  // STATICKI RANDOM GENERATOR KLASE
    public CpuPokemon(String ime, int nivo, Magija magija1, Magija magija2) {
        super(ime, nivo, magija1, magija2);
    }
    @Override
    public void baciMagiju(Pokemon neprijatelj){  // RAD SA RANDOM
        if(random.nextFloat() <= 0.5f){
            neprijatelj.nanesiStetu(this.getMagija1().getSnaga());
            PoslednjaBacena = this.getMagija1();
        }
        else{
            neprijatelj.nanesiStetu(this.getMagija2().getSnaga());
            PoslednjaBacena = this.getMagija2();
        }
    }

}
