import java.util.List;

public class Supervisor {
    private final int id;
    private final String name;
    private static int amount = 0;

    public Supervisor(String name) {
        this.id = NewSupId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private int NewSupId() {
        return ++amount;
    }

    public void update(Animal animal, Supervisor oldSup, Supervisor newSup) {
        String logEntry = "Animal with ID: " + animal.getAnId()
                + " changed from supervisor " + (oldSup != null ? oldSup.getName() : "none")
                + " to supervisor " + newSup.getName();
        System.out.println(logEntry);
    }
}

interface SupervisorChangeObserver {

    void update(Animal animal, Supervisor oldSup, Supervisor newSup);
}

interface SupervisorAssignment {

    void assignSupervisorToAnimal(int anId, Supervisor supervisor);

    List<Animal> getAnimalsBySupervisorId(String supId);

    List<Animal> getAnimalsBySupervisorName(String name);
}

