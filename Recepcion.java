import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Recepcion {
    ArrayList<Cliente> clientesEspera = new ArrayList<>();

    public void recibirHuesped() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese CUI: ");
        String cui = sc.nextLine();

        System.out.print("Ingrese cantidad de visitas: ");
        int visitas = 0;
        try {
            visitas = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Cantidad de visitas inválida. Ingrese un número válido.");
            sc.nextLine();
            return;
        }

        Cliente cliente = new Cliente(nombre, cui, visitas);
        cliente.tipoCliente = cliente.getTipo();
        cliente.ingresarDetalles();

        if (cliente.excedeCapacidad(cliente.tipoCliente.equals("Regular") ? 4 :
                cliente.tipoCliente.equals("Frecuente") ? 5 :
                        8)) {
            System.out.println("La cantidad de personas excede la capacidad máxima para este tipo de habitación.");
            System.out.println("Capacidad máxima: " + (cliente.tipoCliente.equals("Regular") ? 4 :
                    cliente.tipoCliente.equals("Frecuente") ? 5 :
                            8));
            cliente.ingresarDetalles();
        }

        clientesEspera.add(cliente);

        System.out.println("El cliente " + cliente.nombre + " ha sido agregado a la lista de espera");
    }
}
