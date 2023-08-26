import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Recepcion recepcion = new Recepcion();
        Asignacion asignacion = new Asignacion(recepcion.clientesEspera);

        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Sistema de Reservas Hotel");
            System.out.println("1. Recibir Huésped");
            System.out.println("2. Asignar Habitación");
            System.out.println("3. Salir");

            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida. Ingrese un número válido.");
                sc.nextLine();
                continue;
            }

            if (opcion == 1) {
                recepcion.recibirHuesped();
            } else if (opcion == 2) {
                asignacion.asignarHabitacion();
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción inválida");
            }
        }
    }
}


