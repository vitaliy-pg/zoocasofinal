package zoologico.animales;

abstract class Animal {
    private String species;
    private String habitat;
    private String health;
    private String behavior;

    public Animal(String species, String habitat) {
        this.species = species;
        this.habitat = habitat;
        this.health = "Saludable";
        this.behavior = "Normal";
    }

    public void feed() {
        // Lógica para alimentar al animal
    }

    // Otros métodos para actualizar la salud y el comportamiento del animal
}

// Ejemplo de una especie de animal específica
class Lion extends Animal {
    public Lion(String habitat) {
        super("León", habitat);
    }
}

class Penguin extends Animal {
    public Penguin(String habitat) {
        super("Pingüino", habitat);
    }
}
