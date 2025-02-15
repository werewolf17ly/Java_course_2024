import java.util.*;
import java.util.stream.Collectors;

class Zoo implements AnimalSearch {

    private final Map<Integer, Animal> animals = new HashMap<>();
    private final List<Supervisor> observers = new ArrayList<>();

    // Default constructor
    public Zoo() {
    }

    // Constructor with a list of animals
    public Zoo(Collection<Animal> animals) {
        for (Animal animal : animals) {
            addAnimal(animal);
        }
    }

    // Method to add an animal
    @Override
    public void addAnimal(Animal animal) {
        if (animals.containsKey(animal.getAnId())) {
            throw new IllegalArgumentException("Animal with this id already exists");
        }
        animals.put(animal.getAnId(), animal);
    }

    @Override
    public boolean CanMakeSound() {
        return false;
    }

    // Method to search an animal by ID
    @Override
    public Animal getAnById(int anId) {
        return animals.get(anId);
    }

    // Method to delete an animal by ID
    @Override
    public void deleteAnById(int anId) {
        if (!animals.containsKey(anId)) {
            throw new IllegalArgumentException("Animal with this id does not exist");
        }
        animals.remove(anId);
    }

    // Method to assign a supervisor to an animal
    @Override
    public void assignSupToAn(Supervisor supervisor, int anId) {
        if (!animals.containsKey(anId)) {
            throw new IllegalArgumentException("Animal with this id does not exist");
        } else {
            Animal animal = animals.get(anId);
            if (!observers.contains(supervisor)) {
                throw new IllegalArgumentException("Supervisor with this id does not exist");
            } else {
                Supervisor oldSup = animal.getSup();
                animal.setSup(supervisor);
                notifySup(animal, oldSup, supervisor);
            }
        }
    }

    // Method to get animals by supervisor ID
    @Override
    public List<Animal> getAnBySupId(int supId) {
        return animals.values().stream()
                .filter(animal -> animal.getSup() != null && animal.getSup().getId() == supId)
                .collect(Collectors.toList());
    }

    // Method to get animals by supervisor name
    @Override
    public List<Animal> getAnBySupName(String supName) {
        return animals.values().stream()
                .filter(animal -> animal.getSup() != null && animal.getSup().getName().equals(supName))
                .collect(Collectors.toList());
    }

    // Method to get animals taller than a specified height
    @Override
    public List<Animal> getAnByH(double height) {
        return animals.values().stream()
                .filter(animal -> animal.getH() > height)
                .collect(Collectors.toList());
    }

    // Method to get animals that can make sound
    @Override
    public List<Animal> getAnWithSound() {
        return animals.values().stream()
                .filter(Animal::CanMakeSound)
                .collect(Collectors.toList());
    }


    // Method to get animals by type
    @Override
    public List<Animal> getAnByType(String type) {
        return animals.values().stream()
                .filter(animal -> animal.getType().equals(type))
                .collect(Collectors.toList());
    }

    // Observer pattern implementation
    private void notifySup(Animal animal, Supervisor oldSup, Supervisor newSup) {
        for (Supervisor supervisor : observers) {
            supervisor.update(animal, oldSup, newSup);
        }
    }

    // Method to add a supervisor
    public void addObserver(Supervisor supervisor) {
        observers.add(supervisor);
    }

    // Method to remove a supervisor
    public void removeObserver(Supervisor supervisor) {
        observers.remove(supervisor);
    }
}