package com.example.pokemoni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokemonArena extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static List<Pokemon> pokemoni = new ArrayList<>();
    private static Pokemon Igrac = null;
    private static Pokemon Racunar = null;


    // ucitavanje iz fajla
    public static void ucitaj() {
        try {
            List<String> linije = Files.readAllLines(Paths.get("pokemoni.txt"));
            for (String linija : linije) {
                String tokeni[] = linija.split(",");
                String igrac = tokeni[0].trim();
                String ime = tokeni[1].trim();
                int nivo = Integer.parseInt(tokeni[2].trim());  // INTEGER.PARSEINT
                String magija1 = tokeni[3].trim();
                int snaga1 = Integer.parseInt(tokeni[4].trim());
                String magija2 = tokeni[5].trim();
                int snaga2 = Integer.parseInt(tokeni[6].trim());

                if (igrac.equals("p")) {
                    pokemoni.add(new IgracPokemon(ime, nivo, new Magija(snaga1, magija1), new Magija(snaga2, magija2)));
                } else if (igrac.equals("n")) {  // sto
                    pokemoni.add(new CpuPokemon(ime, nivo, new Magija(snaga1, magija1), new Magija(snaga2, magija2)));
                } else {
                    System.out.println("Nije validan igrac: " + igrac);
                }
            }
        } catch (IOException e) {
            System.out.println("Nije lepo ucitano!");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox koren = new VBox(10);
        koren.setPadding(new Insets(10,10,10,10));
        koren.setStyle("-fx-background-color: lightyellow");

        Button btUcitaj = new Button("Ucitaj");
        btUcitaj.setStyle("-fx-background-color: lightblue");

        TextArea ta1 = new TextArea();
        ta1.setEditable(false);
        TextArea ta2 = new TextArea();
        ta2.setEditable(false);

        RadioButton rbMagija1 = new RadioButton("Magija 1");
        RadioButton rbMagija2 = new RadioButton("Magija 2");
        rbMagija1.setStyle("-fx-background-color: lightblue");
        rbMagija2.setStyle("-fx-background-color: lightblue");
        rbMagija1.setSelected(true);
        ToggleGroup tg = new ToggleGroup();
        rbMagija1.setToggleGroup(tg);
        rbMagija2.setToggleGroup(tg);

        HBox hBox = new HBox(10);

        koren.getChildren().addAll(btUcitaj, ta1, ta2, rbMagija1, rbMagija2, hBox);

        //hBox
        Button btIzaberiMagiju = new Button("Izaberi magiju");
        Button btSimuliraj = new Button("Simuliraj");
        btIzaberiMagiju.setStyle("-fx-background-color: lightblue");
        btSimuliraj.setStyle("-fx-background-color: lightblue");


        hBox.getChildren().addAll(btIzaberiMagiju, btSimuliraj);

        // akcije dugmica
        btUcitaj.setOnAction(e -> {
            ucitaj();
            Collections.sort(pokemoni);
            for(Pokemon p : pokemoni){
                if(p instanceof IgracPokemon){
                    if(Igrac == null) Igrac = p;  // OBJEKTE POREDIM SA == !!!
                    ta1.appendText("[p] " + p.toString() + "\n");
                }
                else{
                    if(Racunar == null) Racunar = p;
                    ta1.appendText("[ai] " + p.toString() + "\n");
                }
            }
            if(Racunar == null){
                System.out.println("Ovo ne sme da se desi!");
            }
            ta1.appendText("\n" + "Izabrani pokemoni:\n" + "[p] " + Igrac.toString() + "\n" + "[ai] " + Racunar.toString());

            // postavljam rbuttone kako treba
            rbMagija1.setText(Igrac.getMagija1().toString());
            rbMagija2.setText(Igrac.getMagija2().toString());
        });

        btIzaberiMagiju.setOnAction(e -> {
            if(rbMagija1.isSelected()){
                ((IgracPokemon)Igrac).setIzabranaMagija(1);  // MORA CAST DA PRISTUPIM METODU !!!
                ta2.appendText("[igrac] bira magiju " + Igrac.getMagija1() + "\n");
            }
            else if(rbMagija2.isSelected()){
                ((IgracPokemon)Igrac).setIzabranaMagija(2);
                ta2.appendText("[igrac] bira magiju " + Igrac.getMagija2() + "\n");
            }
            else{
                System.out.println("Ovo ne sme da se desi!");
            }
        });

        btSimuliraj.setOnAction(e -> {
            if(Igrac.getZivot() <= 0 && Racunar.getZivot() <= 0)
                ta2.appendText("Nereseno je!!!\n");
            if(Igrac.getZivot() <= 0)
                ta2.appendText("Pobedio je racunar!!!\n");
            else if(Racunar.getZivot() <= 0)
                ta2.appendText("Pobedio je igrac!!!\n");
            else{
                Igrac.baciMagiju(Racunar);
                Racunar.baciMagiju(Igrac);
//                ta2.appendText("[igrac] je bacio " + ((IgracPokemon)Igrac).getIzabranaMagija() + " " + ((IgracPokemon)Igrac).getIzabranaMagija().getSnaga() + "\n"
//                                + "[cpu] je bacio " + ((CpuPokemon)Racunar).getPoslednjaBacena() + " " + ((CpuPokemon)Racunar).getPoslednjaBacena().getSnaga() + "\n"
//                                + "[igrac] " + Igrac.getZivot() + "%\n"
//                                + "[cpu] " + Racunar.getZivot() + "%\n"
//                                + "-----------------------------------------------------------------------------------\n");
                ta2.appendText("[igrac] je bacio " + ((IgracPokemon)Igrac).getIzabranaMagija() + " " + ((IgracPokemon)Igrac).getIzabranaMagija().getSnaga() + "\n");
                ta2.appendText("[cpu] je bacio " + ((CpuPokemon)Racunar).getPoslednjaBacena() + " " + ((CpuPokemon)Racunar).getPoslednjaBacena().getSnaga() + "\n");
                ta2.appendText("[igrac] " + Igrac.getZivot() + "%\n");
                ta2.appendText("[cpu] " + Racunar.getZivot() + "%\n");
                ta2.appendText("-----------------------------------------------------------------------------------\n");

            }
        });

        Scene scena = new Scene(koren, 500, 500);
        stage.setScene(scena);
        stage.setTitle("POKEMONI");
        stage.show();
    }
}
