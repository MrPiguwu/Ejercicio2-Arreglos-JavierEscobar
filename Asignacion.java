import java.util.ArrayList;
import java.util.Scanner;

public class Asignacion {
    ArrayList<Habitacion> habitaciones = new ArrayList<>();
    ArrayList<Cliente> clientesEspera;

    public Asignacion(ArrayList<Cliente> clientesEspera) {
        this.clientesEspera = clientesEspera;
        habitaciones.add(new Habitacion(101, 4, 20));
        habitaciones.add(new Habitacion(102, 5, 50));
        habitaciones.add(new Habitacion(103, 8, 100));
    }

    public void asignarHabitacion() {
        if (clientesEspera.size() > 0) {
            Cliente cliente = clientesEspera.get(0);
            String tipo = cliente.getTipo();

            Habitacion habitacionDisponible = null;
            for (Habitacion h : habitaciones) {
                if ((tipo.equals("Regular") && h.capacidadMaxima >= cliente.adultos + cliente.niños) ||
                        (tipo.equals("Frecuente") && h.capacidadMaxima >= cliente.adultos + cliente.niños) ||
                        (tipo.equals("VIP") && h.capacidadMaxima >= cliente.adultos + cliente.niños)) {
                    habitacionDisponible = h;
                    break;
                }
            }

            if (habitacionDisponible != null) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese contraseña para confirmar asignación: ");
                String password = sc.nextLine();

                if (password.equals("H073L2023$")) {
                    double montoTotal = habitacionDisponible.precioPorNoche * cliente.noches;
                    System.out.println("Se ha asignado la habitación " + habitacionDisponible.numero +
                            " al cliente " + cliente.nombre + ". Tipo: " + cliente.tipoCliente +
                            ". Monto total: $" + montoTotal);
                    clientesEspera.remove(cliente);
                } else {
                    System.out.println("Contraseña incorrecta, asignación rechazada");
                }

            } else {
                String tipoMaximo = cliente.tipoCliente.equals("Regular") ? "estándar" :
                        cliente.tipoCliente.equals("Frecuente") ? "Deluxe" :
                                "Suite";
                System.out.println("No hay habitaciones " + tipoMaximo + " disponibles para el cliente " + cliente.nombre);
                System.out.println("La capacidad máxima para este tipo de habitación es de " + cliente.tipoCliente);
            }

        } else {
            System.out.println("No hay clientes en espera");
        }
    }
}
