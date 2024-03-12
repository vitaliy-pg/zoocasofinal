package zoologico.mantenimiento;

import java.util.ArrayList;
import java.util.List;

// Clase para el sistema de mantenimiento y seguridad del zoológico
public class MaintenanceAndSecuritySystem {
    private List<MaintenanceTask> maintenanceTasks;
    private List<String> securityCameras;
    private List<String> sensors;

    public MaintenanceAndSecuritySystem() {
        maintenanceTasks = new ArrayList<> ();
        securityCameras = new ArrayList<>();
        sensors = new ArrayList<> ();
    }

    // Métodos para gestionar tareas de mantenimiento y seguridad
}
