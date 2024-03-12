package zoologico.visitantes;

interface TourGuide {
    void provideTour(String visitorType);
}

// Implementaciones de guías turísticos
class ChildrenTourGuide implements TourGuide {
    @Override
    public void provideTour(String visitorType) {
        // Lógica para proporcionar un tour para niños
    }
}

class BirdLoversTourGuide implements TourGuide {
    @Override
    public void provideTour(String visitorType) {
        // Lógica para proporcionar un tour para amantes de las aves
    }
}

// Clase para quioscos interactivos
class InteractiveKiosk {
    public void provideInformation(String information) {
        // Lógica para proporcionar información sobre animales y hábitats
    }
}