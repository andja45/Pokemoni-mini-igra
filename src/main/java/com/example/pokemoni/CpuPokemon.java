package com.example.pokemoni;

import java.util.Random;

/*  Napraviti klasu CpuPokemon koja nasleđuje klasu Pokemon. Klasa poseduje privatno statičko polje random (Random).
    Implementirati metod public void baciMagiju(Pokemon neprijatelj) tako da sa verovatnoćom 0.5 baca prvu
    magiju, i sa verovatnoćom 0.5 baca drugu magiju na prosleđenog neprijatelja.
    Klasa Random poseduje metod nextDouble koji generiše pseudo-slučajni broj iz intervala [0, 1] i može Vam koristiti u
    implementaciji nekog metoda klase. */
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
