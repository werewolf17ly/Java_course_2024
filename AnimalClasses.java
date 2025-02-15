class Cats extends Animal {
    public Cats(double height) {
        super(height);
    }

    @Override
    public String getType() {
        return "Cat";
    }

    public boolean CanMakeSound() {
        return true;
    }
}

class Dogs extends Animal {
    public Dogs(double height) {
        super(height);
    }

    @Override
    public String getType() {
        return "Dog";
    }

    public boolean CanMakeSound() {
        return true;
    }
}

class Hippos extends Animal {
    public Hippos(double height) {
        super(height);
    }

    @Override
    public String getType() {
        return "Hippo";
    }

    public boolean CanMakeSound() {
        return true;
    }
}

class Horses extends Animal {
    public Horses(double height) {
        super(height);
    }

    @Override
    public String getType() {
        return "Horse";
    }

    public boolean CanMakeSound() {
        return true;
    }
}

class Fish extends Animal {
    public Fish(double height) {
        super(height);
    }

    @Override
    public String getType() {
        return "Fish";
    }

    public boolean CanMakeSound() {
        return false;
    }
}