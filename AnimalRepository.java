package AnimalsIdentify;

import java.util.ArrayList;

/**
 *
 * @author Luan Gomes
 */
public class AnimalRepository {
    
    private ArrayList<Animal> animais;
    
    public AnimalRepository(){
        this. animais = new ArrayList<>();
    }

    public Animal getIdentifyAnimal(int identify) {
        Animal find = null;
        for (Animal animal : animais) {
            if (animal.getIdentificacao() == identify)
                find = animal;
        }
        return find;
    }
    
    public ArrayList<Animal> getContainsIdentifyAnimal(int identify) {
        ArrayList<Animal> findAnimais = new ArrayList<>();
        for (Animal animal : this.animais) {
            if (this.intToString(animal.getIdentificacao()).contains(intToString(identify))) {
                findAnimais.add(animal);
            }
        }
        return findAnimais;
    }
    
    public String intToString(int val){
        return val+"";
    }
    
    public ArrayList<Animal> getAnimais() {
        return animais == null? new ArrayList<>() : animais;
    }

    public ArrayList<Animal> setAnimais(ArrayList<Animal> animais) {
        this.animais = animais;
        return this.animais;
    }
    
    public void addAnimal(Animal animal) {
        this.animais.add(animal);
    }
}
