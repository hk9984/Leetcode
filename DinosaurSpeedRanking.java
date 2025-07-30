package Leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Question 1: You will be supplied with two data files in CSV format . The first file contains statistics about various dinosaurs. 
 * The second file contains additional data. Given the following formula, speed = ((STRIDE_LENGTH / LEG_LENGTH) - 1) * SQRT(LEG_LENGTH * g) Where g = 9.8 m/s^2 (gravitational constant)
 * Write a program to read in the data files from disk, it must then print the names of only the bipedal dinosaurs from fastest to slowest. Do not print any other information.
 * 
 * $ cat dataset1.csv
    NAME,LEG_LENGTH,DIET
    Hadrosaurus,1.4,herbivore
    Struthiomimus,0.72,omnivore
    Velociraptor,1.8,carnivore
    Triceratops,0.47,herbivore
    Euoplocephalus,2.6,herbivore
    Stegosaurus,1.50,herbivore
    Tyrannosaurus Rex,6.5,carnivore

    $ cat dataset2.csv 
    NAME,STRIDE_LENGTH,STANCE
    Euoplocephalus,1.97,quadrupedal
    Stegosaurus,1.70,quadrupedal
    Tyrannosaurus Rex,4.76,bipedal
    Hadrosaurus,1.3,bipedal
    Deinonychus,1.11,bipedal
    Struthiomimus,1.24,bipedal
    Velociraptorr,2.62,bipedal
 */

public class DinosaurSpeedRanking {

    static class Dino {
        String name;
        double speed;

        Dino(String name, double speed) {
            this.name = name;
            this.speed = speed;
        }
    }

    static final double GRAVITY = 9.8;

    public static void main(String[] args) throws IOException {
        Map<String, Double> legLengthMap = new HashMap<>();
        List<Dino> bipedalDinos = new ArrayList<>();

        // Read dataset1.csv: NAME,LEG_LENGTH,DIET
        BufferedReader reader1 = new BufferedReader(new FileReader("dataset1.csv"));
        String line;
        reader1.readLine(); // skip header
        while ((line = reader1.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0].trim();
            double legLength = Double.parseDouble(parts[1].trim());
            legLengthMap.put(name, legLength);
        }
        reader1.close();

        // Read dataset2.csv: NAME,STRIDE_LENGTH,STANCE
        BufferedReader reader2 = new BufferedReader(new FileReader("dataset2.csv"));
        reader2.readLine(); // skip header
        while ((line = reader2.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[0].trim();
            double strideLength = Double.parseDouble(parts[1].trim());
            String stance = parts[2].trim();

            if ("bipedal".equalsIgnoreCase(stance) && legLengthMap.containsKey(name)) {
                double legLength = legLengthMap.get(name);
                double speed = ((strideLength / legLength) - 1) * Math.sqrt(legLength * GRAVITY);
                bipedalDinos.add(new Dino(name, speed));
            }
        }
        reader2.close();

        // Sort descending by speed
        Collections.sort(bipedalDinos, new Comparator<Dino>() {
            @Override
            public int compare(Dino d1, Dino d2) {
                return Double.compare(d2.speed, d1.speed);
            }
        });

        // Output
        for (Dino dino : bipedalDinos) {
            System.out.println(dino.name);
        }
    }




    
}
