package com.example.pokemoni;
/*  Napraviti klasu IgracPokemon koja nasleđuje klasu Pokemon. Igrač poseduje atribut izabranaMagija (int) čije vred-
    nosti mogu biti 1 ili 2. Implementirati metod Magija getIzabranaMagija() koji vraća prvu ili drugu magiju u
    zavisnosti od vrednosti atributa izabranaMagija i metod void setIzabranaMagija(int i) koja postavlja izabranu
    magiju na prvu ukoliko je i=1, na drugu ukoliko je i=2, a inače ne radi ništa. Implementirati metod public void
    baciMagiju(Pokemon neprijatelj) tako da prosleđenom pokemonu nanosi štetu koju poseduje izabrana magija. */
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
