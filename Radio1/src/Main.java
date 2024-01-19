import java.util.Scanner;
public class Main {
    Controlador controlador = new Controlador();
    static int opc = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (opc < 2){
            System.out.println("..::BIENVENIDO A SU RADIO::..\n 1. Encender radio\n 2. Salir");
            opc = sc.nextInt();
            if (opc == 1){

            }
        }
    }
}