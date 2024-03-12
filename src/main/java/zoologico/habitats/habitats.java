package zoologico.habitats;

abstract class Habitat {
    private String type;
    private int temperature;
    private int humidity;
    private boolean clean;

    public Habitat(String type, int temperature, int humidity, boolean clean) {
        this.type = type;
        this.temperature = temperature;
        this.humidity = humidity;
        this.clean = clean;
    }

    // Getters y setters para los atributos

    public abstract void monitorConditions();
}

// Clase para hábitats acuáticos
class AquaticHabitat extends Habitat {
    public AquaticHabitat(int temperature, int humidity, boolean clean) {
        super("Acuático", temperature, humidity, clean);
    }

    @Override
    public void monitorConditions() {
        // Lógica específica para monitorear condiciones de hábitats acuáticos
    }
}

// Clase para hábitats terrestres
class TerrestrialHabitat extends Habitat {
    public TerrestrialHabitat(int temperature, int humidity, boolean clean) {
        super("Terrestre", temperature, humidity, clean);
    }

    @Override
    public void monitorConditions() {
        // Lógica específica para monitorear condiciones de hábitats terrestres
    }
}

// Clase para hábitats de aviario
class AviaryHabitat extends Habitat {
    public AviaryHabitat(int temperature, int humidity, boolean clean) {
        super("Aviario", temperature, humidity, clean);
    }

    @Override
    public void monitorConditions() {
        // Lógica específica para monitorear condiciones de aviarios
    }
}