import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a zoo
        Zoo zoo = new Zoo();

        // Create animals
        Animal cat = new Cats(5.0);
        Animal dog = new Dogs(7.0);
        Animal hippo = new Hippos(10.0);
        Animal horse = new Horses(8.0);
        Animal fish = new Fish(2.0);

        // Add animals to the zoo
        zoo.addAnimal(cat);
        zoo.addAnimal(dog);
        zoo.addAnimal(hippo);
        zoo.addAnimal(horse);
        zoo.addAnimal(fish);

        // Get all animals of type "Cat" from the zoo
        List<Animal> cats = zoo.getAnByType("Cat");
        System.out.println("Cats in the zoo: " + cats.size());

        // Get animals that can make sounds
        List<Animal> animalsWithSound = zoo.getAnWithSound();
        System.out.println("Animals that can make sounds: " + animalsWithSound.size());

        // Create supervisors
        Supervisor supervisor1 = new Supervisor("Alice");
        Supervisor supervisor2 = new Supervisor("Bob");
        zoo.addObserver(supervisor1);
        zoo.addObserver(supervisor2);

        // Assign supervisors to animals
        zoo.assignSupToAn(supervisor1, cat.getAnId());
        zoo.assignSupToAn(supervisor2, dog.getAnId());

        // Get animals with height more than 6
        List<Animal> tallAnimals = zoo.getAnByH(6);
        System.out.println("Animals taller than 6: " + tallAnimals.size());

        // Get animals by supervisor name
        List<Animal> animalsBySupervisorName = zoo.getAnBySupName("Alice");
        System.out.println("Animals supervised by Alice: " + animalsBySupervisorName.size());

        // Get animal by supervisor ID
        List<Animal> animalsBySupervisorId = zoo.getAnBySupId(supervisor1.getId());
        System.out.println("Animals supervised by ID " + supervisor1.getId() + ": " + animalsBySupervisorId.size());

        // Search an animal using an ID
        Animal searchedAnimal = zoo.getAnById(cat.getAnId());
        System.out.println("Searched Animal: " + (searchedAnimal != null ? searchedAnimal.getType() : "Not found"));

        // Remove an animal from the zoo
        zoo.deleteAnById(fish.getAnId());
        System.out.println("Fish removed from the zoo.");

        // Attempt to assign a supervisor for a deleted animal (should throw an exception)
        try {
            zoo.assignSupToAn(supervisor1, fish.getAnId());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Add another supervisor to an animal with a supervisor
        zoo.assignSupToAn(supervisor2, horse.getAnId());

        // Assign the same supervisor to the same animal (should work)
        zoo.assignSupToAn(supervisor2, horse.getAnId());
        System.out.println("Supervisor Bob assigned to horse again.");
    }
}