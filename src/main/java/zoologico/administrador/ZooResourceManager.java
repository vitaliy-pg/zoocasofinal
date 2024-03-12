package zoologico.administrador;

import java.util.ArrayList;
import java.util.List;

// Clase para el manejo de recursos del zoológico
public class ZooResourceManager {
    private List<Resource> resources;

    public ZooResourceManager() {
        resources = new ArrayList<> ();
    }

    public void addResource(String name, int quantity) {
        resources.add(new Resource(name, quantity));
    }

    // Otros métodos para gestionar los recursos
}
