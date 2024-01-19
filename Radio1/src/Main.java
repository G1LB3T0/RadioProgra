import java.util.Scanner;
public class Main {
    static Controlador controlador = new Controlador();
    static int opc = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (opc < 2){
            System.out.println("..::BIENVENIDO A SU RADIO::..\n 1. Encender radio\n 2. Salir");
            opc = sc.nextInt();
            if (opc == 1){
                controlador.tooglePowerOffOn();
            }
            while (controlador.getState() == true){
                    Scanner sac = new Scanner(System.in);
                    String y = "None";
                    if (controlador.getStateAMFM()){
                        y = "FM";
                    } else if (controlador.getStateAMFM() == false) {
                        y = "AM";
                    }
                    System.out.println("RADIO");
                    System.out.println("FRECUENCIA: " + y);
                    System.out.println("Sonando: " + controlador.getCurrentFrequency());
                    System.out.println("Que desea hacer?\n 1. Siguiente emisora\n 2. Anterior emisora");
                    int opc = sc.nextInt();
                    if (opc == 1){
                        controlador.nextFrequency();
                    } else if (opc == 2) {
                        controlador.previousFrequency();
                    }
            }
        }
    }
}