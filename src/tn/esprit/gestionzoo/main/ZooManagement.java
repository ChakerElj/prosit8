package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.AnimalAlreadyExistException;
import tn.esprit.gestionzoo.exceptions.ZooExceptions;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class ZooManagement {

    public static void main(String[] args) {
        Animal lion = new Animal();
        lion.setName("Simba");
        lion.setAge(8);
        lion.setFamily("Cats");
        lion.setMammal(true);

        Zoo myZoo = new Zoo("Wildlife Park", "Ariana");
        Zoo notMyZoo = new Zoo("WaterPark", "Siliana");


        Animal dog = new Animal("Canine", "Snoopy", 2, true);


        try {
           myZoo.addAnimal(lion);
        } catch (ZooExceptions e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(myZoo.getName() + "a " + myZoo.getNbrAnimals() + " animaux");
        }
        try {
            myZoo.addAnimal(dog);
        }catch(ZooExceptions e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(myZoo.getName() + "a " + myZoo.getNbrAnimals() + " animaux");

        }


        myZoo.displayAnimals();

        System.out.println(myZoo.searchAnimal(dog));
        Animal dog2 = new Animal("Canine", "lll", 2, true);
        System.out.println(myZoo.searchAnimal(dog2));

//           System.out.println(myZoo.removeAnimal(dog));
        myZoo.displayAnimals();


        System.out.println(myZoo);


        try {
            myZoo.addAnimal(lion); // Animal Already exist exception
        } catch (ZooExceptions e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(myZoo.getName() + "a " + myZoo.getNbrAnimals() + " animaux");
        }

        try {
            myZoo.addAnimal(dog2);
        } catch (ZooExceptions e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(myZoo.getName() + "a " + myZoo.getNbrAnimals() + " animaux");
        }
        myZoo.displayAnimals();
        Animal dog3 = new Animal("berge", "poutchi", 4, true);
        try {
            myZoo.addAnimal(dog3); // doit generer  exception ZooFullException mais si en veut modifier l'age en une valeur negative
            // programme doit generer l'exception AgeNotValid
        }catch (ZooExceptions ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println(myZoo.getName() + "a " + myZoo.getNbrAnimals() + " animaux");

        }
        Dolphin d = new Dolphin();
        d.setSwimmingSpeed(24.5f);
        Dolphin d1 = new Dolphin();
        d1.setSwimmingSpeed(21.8f);
        Dolphin d2 = new Dolphin();
        d2.setSwimmingSpeed(20.3f);
        Dolphin d3 = new Dolphin();
        d3.setSwimmingSpeed(22.6f);


        myZoo.addAquaticAnimal(d);
        myZoo.addAquaticAnimal(d1);
        myZoo.addAquaticAnimal(d2);
        myZoo.addAquaticAnimal(d3);
        Penguin p = new Penguin();
        p.setSwimmingDepth(24.6f);
        Penguin p1 = new Penguin();
        p1.setSwimmingDepth(29.6f);
        Penguin p2 = new Penguin();
        p2.setSwimmingDepth(219.6f);
        Penguin p3 = new Penguin();
        p1.setSwimmingDepth(2.6f);
        myZoo.addAquaticAnimal(p);
        myZoo.addAquaticAnimal(p1);
        myZoo.addAquaticAnimal(p2);
        myZoo.addAquaticAnimal(p3);
        myZoo.addAquaticAnimal(new Penguin());

        for (int i = 0; i < myZoo.getNbrAquatics(); i++) {
            Aquatic[] aquatics = myZoo.getAquaticAnimals();
            aquatics[i].swim();
        }

        myZoo.displayNumberOfAquaticsByType();

        System.out.println(myZoo.maxPenguinSwimmingDepth());
        // Prosit 8 test
        Aquatic dolphin = new Dolphin();
        dolphin.eatMeat(Food.MEAT);
        Terrestrial cat = new Terrestrial();
        cat.eatPlantAndMeet(Food.BOTH);
    }

}
