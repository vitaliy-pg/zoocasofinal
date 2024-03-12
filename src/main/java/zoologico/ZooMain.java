package zoologico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Clases para la gestión de hábitats

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

    public void monitorConditions() {
        System.out.println("Monitoreando condiciones en el hábitat " + type + ":");
        System.out.println("Temperatura: " + temperature);
        System.out.println("Humedad: " + humidity);
        System.out.println("Limpieza: " + (clean ? "Limpio" : "Sucio"));
    }
}

class AquaticHabitat extends Habitat {
    public AquaticHabitat(int temperature, int humidity, boolean clean) {
        super("Acuático", temperature, humidity, clean);
    }
}

class TerrestrialHabitat extends Habitat {
    public TerrestrialHabitat(int temperature, int humidity, boolean clean) {
        super("Terrestre", temperature, humidity, clean);
    }
}

class AviaryHabitat extends Habitat {
    public AviaryHabitat(int temperature, int humidity, boolean clean) {
        super("Aviario", temperature, humidity, clean);
    }
}

// Clases para el cuidado de los animales

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
        System.out.println("Alimentando a " + species);
    }

    public void updateHealth(String healthStatus) {
        this.health = healthStatus;
        System.out.println(species + " está ahora " + healthStatus);
    }

    public void updateBehavior(String behaviorStatus) {
        this.behavior = behaviorStatus;
        System.out.println(species + " ahora está mostrando comportamiento " + behaviorStatus);
    }
}

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

// Interfaz para guías turísticos

interface TourGuide {
    void provideTour(String visitorType);
}

class ChildrenTourGuide implements TourGuide {
    @Override
    public void provideTour(String visitorType) {
        System.out.println("Bienvenidos al tour para niños");
    }
}

class BirdLoversTourGuide implements TourGuide {
    @Override
    public void provideTour(String visitorType) {
        System.out.println("Bienvenidos al tour para amantes de las aves");
    }
}

// Clase para quioscos interactivos

class InteractiveKiosk {
    public void provideInformation(String information) {
        System.out.println("Mostrando información en el kiosco interactivo: " + information);
    }
}

// Clase para representar un recurso

class Resource {
    private String name;
    private int quantity;

    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Clase para el manejo de recursos del zoológico

class ZooResourceManager {
    private Map<String, Resource> resources;

    public ZooResourceManager() {
        resources = new HashMap<>();
    }

    public void addResource(String name, int quantity) {
        resources.put(name, new Resource(name, quantity));
    }

    public void displayResources() {
        System.out.println("Inventario de Recursos:");
        for (Resource resource : resources.values()) {
            System.out.println(resource.getName() + ": " + resource.getQuantity());
        }
    }

    public void makeOrder(String name, int quantity) {
        if (resources.containsKey(name)) {
            Resource resource = resources.get(name);
            resource.setQuantity(resource.getQuantity() + quantity);
            System.out.println("Pedido realizado: " + quantity + " unidades de " + name);
        } else {
            System.out.println("El recurso " + name + " no está disponible en el inventario.");
        }
    }
}

// Clases para el sistema de mantenimiento y seguridad del zoológico

class MaintenanceTask {
    private String description;
    private boolean urgent;

    public MaintenanceTask(String description, boolean urgent) {
        this.description = description;
        this.urgent = urgent;
    }
}

class MaintenanceAndSecuritySystem {
    private List<MaintenanceTask> maintenanceTasks;
    private List<String> securityCameras;
    private List<String> sensors;

    public MaintenanceAndSecuritySystem() {
        maintenanceTasks = new ArrayList<>();
        securityCameras = new ArrayList<>();
        sensors = new ArrayList<>();
    }
}

// Clase principal para el manejo del zoológico

public class ZooMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooResourceManager resourceManager = new ZooResourceManager();
        MaintenanceAndSecuritySystem maintenanceAndSecuritySystem = new MaintenanceAndSecuritySystem();

        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Hábitats");
            System.out.println("2. Cuidado de los Animales");
            System.out.println("3. Interacción con Visitantes");
            System.out.println("4. Administración de Recursos");
            System.out.println("5. Mantenimiento y Seguridad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (option) {
                case 1:
                    manageHabitats(scanner);
                    break;
                case 2:
                    manageAnimals(scanner);
                    break;
                case 3:
                    interactWithVisitors(scanner);
                    break;
                case 4:
                    manageResources(resourceManager, scanner);
                    break;
                case 5:
                    performMaintenanceAndSecurity(maintenanceAndSecuritySystem, scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        scanner.close();
    }

    public static void manageHabitats(Scanner scanner) {
        System.out.println("Gestión de Hábitats:");
        System.out.println("Seleccione el tipo de hábitat:");
        System.out.println("1. Acuático");
        System.out.println("2. Terrestre");
        System.out.println("3. Aviario");
        int habitatType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la temperatura del hábitat:");
        int temperature = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la humedad del hábitat:");
        int humidity = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿El hábitat está limpio? (true/false):");
        boolean clean = scanner.nextBoolean();
        scanner.nextLine();

        Habitat habitat = null;
        switch (habitatType) {
            case 1:
                habitat = new AquaticHabitat(temperature, humidity, clean);
                break;
            case 2:
                habitat = new TerrestrialHabitat(temperature, humidity, clean);
                break;
            case 3:
                habitat = new AviaryHabitat(temperature, humidity, clean);
                break;
            default:
                System.out.println("Tipo de hábitat no válido.");
                return;
        }

        habitat.monitorConditions();
    }

    public static void manageAnimals(Scanner scanner) {
        System.out.println("Cuidado de los Animales:");
        System.out.println("Seleccione la especie del animal:");
        System.out.println("1. León");
        System.out.println("2. Pingüino");
        int animalType = scanner.nextInt();
        scanner.nextLine();

        Animal animal = null;
        switch (animalType) {
            case 1:
                animal = new Lion("Savannah");
                break;
            case 2:
                animal = new Penguin("Antarctica");
                break;
            default:
                System.out.println("Especie de animal no válida.");
                return;
        }

        animal.feed();
        animal.updateHealth("Enfermo");
        animal.updateBehavior("Agresivo");
    }

    public static void interactWithVisitors(Scanner scanner) {
        System.out.println("Interacción con Visitantes:");
        System.out.println("Seleccione el tipo de visita:");
        System.out.println("1. Niños");
        System.out.println("2. Aficionados a las aves");
        int visitorType = scanner.nextInt();
        scanner.nextLine();

        TourGuide tourGuide = null;
        switch (visitorType) {
            case 1:
                tourGuide = new ChildrenTourGuide();
                break;
            case 2:
                tourGuide = new BirdLoversTourGuide();
                break;
            default:
                System.out.println("Tipo de visitante no válido.");
                return;
        }

        tourGuide.provideTour("Visitante");
    }

    public static void manageResources(ZooResourceManager resourceManager, Scanner scanner) {
        System.out.println("Administración de Recursos:");
        System.out.println("1. Mostrar Inventario");
        System.out.println("2. Realizar Pedido");
        int resourceOption = scanner.nextInt();
        scanner.nextLine();

        switch (resourceOption) {
            case 1:
                resourceManager.displayResources();
                break;
            case 2:
                System.out.println("Ingrese el nombre del recurso:");
                String resourceName = scanner.nextLine();
                System.out.println("Ingrese la cantidad a pedir:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                resourceManager.makeOrder(resourceName, quantity);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void performMaintenanceAndSecurity(MaintenanceAndSecuritySystem maintenanceAndSecuritySystem, Scanner scanner) {
        System.out.println("Mantenimiento y Seguridad:");
        // Implementar la lógica para el mantenimiento y la seguridad
    }
    }

