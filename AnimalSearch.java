import java.util.List;

interface AnimalSearch {
    // Method to search an animal by ID
    Animal getAnById(int anId);

    // Method to delete an animal by ID
    void deleteAnById(int anId);

    // Method to assign a supervisor to an animal
    void assignSupToAn(Supervisor supervisor, int anId);

    // Method to get animals by supervisor ID
    List<Animal> getAnBySupId(int supId);

    // Method to get animals by supervisor name
    List<Animal> getAnBySupName(String supName);

    List<Animal> getAnByH(double height);
    List<Animal> getAnWithSound();
    List<Animal> getAnByType(String type);

    void addAnimal(Animal animal);

    public abstract boolean CanMakeSound();

}