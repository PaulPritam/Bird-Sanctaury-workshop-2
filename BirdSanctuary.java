//package com.company;


import java.util.HashSet;
import java.util.Set;

public class BirdSanctuary {
    private static BirdSanctuary instance;
    private Set<Bird> allBirds = new HashSet<>();

    BirdSanctuary() {
    }

    public synchronized static BirdSanctuary getInstance() {
        if (instance == null) {
            instance = new BirdSanctuary();
        }
        return instance;
    }

    public double add(Bird bird) {
        try {
            if (bird == null) {
                throw new BirdSanctuaryAddException("bird not exsits");
            }
            if (allBirds.add(bird)) {
                //allBirds.add(bird);
                bird.incrementCount();
            }
        } catch (BirdSanctuaryAddException e) {
            e.printStackTrace();
        }
        return 0;
    }
        public void remove(Bird bird){
            allBirds.remove(bird);
            bird.decrementCount();
        }
        public void printFlyable() {
            //for (Bird bird : allBirds) {
            //    if (bird instanceof Flyable) {
            //     ((Flyable) bird).fly();
            //  }
            //}
            allBirds.stream().filter(bird -> bird instanceof Flyable).forEach(bird -> ((Flyable) bird).fly());
        }
        public void printEatable () {
            // for (Bird bird : allBirds) {
            //  if (bird instanceof Eatable) {
            //      ((Eatable)bird).eat();
            //}
            //}
            allBirds.stream().filter(bird -> bird instanceof Eatable).forEach(bird -> ((Eatable) bird).eat());
        }
        public void printSwimmable() {
            // for (Bird bird : allBirds) {
            //  if (bird instanceof Swimmable) {
            //     ((Swimmable) bird).swim();
            //  }
            // }
            allBirds.stream().filter(bird -> bird instanceof Swimmable).forEach(bird -> ((Swimmable) bird).swim());
        }
    }