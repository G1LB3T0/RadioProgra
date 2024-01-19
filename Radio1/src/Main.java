import java.util.Scanner;

public class Main {
    static Controlador controlador = new Controlador();
    static int opcionMenu = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (opcionMenu < 2) {
                System.out.println("..::BIENVENIDO A SU RADIO::..\n 1. Encender radio\n 2. Salir");
                opcionMenu = sc.nextInt();
                if (opcionMenu == 1) {
                    controlador.tooglePowerOffOn();
                    System.out.println("Radio " + (controlador.getState() ? "encendida." : "apagada."));
                }

                while (controlador.getState()) {
                    String frecuencia = controlador.getStateAMFM() ? "FM" : "AM";
                    System.out.println("RADIO");
                    System.out.println("FRECUENCIA: " + frecuencia);
                    System.out.println("Sonando: " + controlador.getCurrentFrequency());
                    System.out.println("Que desea hacer?\n 1. Siguiente emisora\n 2. Anterior emisora\n 3. Cambiar frecuencia\n 4. Guardar Emisora\n 5. Mostrar Emisoras Favoritas\n 6. Apagar radio");
                    int opcionRadio = sc.nextInt();

                    switch (opcionRadio) {
                        case 1:
                            controlador.nextFrequency();
                            System.out.println("Sintonizando la siguiente emisora.");
                            break;
                        case 2:
                            controlador.previousFrequency();
                            System.out.println("Sintonizando la anterior emisora.");
                            break;
                        case 3:
                            controlador.toogleAMFM();
                            System.out.println("Frecuencia cambiada a " + (controlador.getStateAMFM() ? "FM" : "AM"));
                            break;
                        case 4:
                            System.out.println("Seleccione un botón para guardar la emisora (1-5): ");
                            int botonGuardar = sc.nextInt();
                            controlador.setFavFrequency(botonGuardar);
                            break;
                        case 5:
                            System.out.println("Seleccione un botón para mostrar la emisora favorita (1-5): ");
                            int botonMostrar = sc.nextInt();
                            float emisoraFavorita = controlador.getFavFrequency(botonMostrar);
                            if (emisoraFavorita != 0) {
                                System.out.println("Emisora favorita en el botón " + botonMostrar + ": " + emisoraFavorita);
                            }
                            break;
                        case 6:
                            controlador.tooglePowerOffOn();
                            System.out.println("Apagando la radio.");
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                            break;
                    }
                }
            }
        }
    }
}
