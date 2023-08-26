

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Cliente {
    String nombre;
    String cui;
    int visitas;
    String tipoCliente;
    int adultos;
    int niños;
    int noches;

    public Cliente(String nombre, String cui, int visitas) {
        this.nombre = nombre;
        this.cui = cui;
        this.visitas = visitas;
    }

    public String getTipo() {
        if (visitas == 0 || visitas < 5) {
            return "Regular";
        } else if (visitas >= 5 && visitas < 10) {
            return "Frecuente";
        } else {
            return "VIP";
        }
    }

    public void ingresarDetalles() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese cantidad de adultos: ");
        try {
            adultos = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Cantidad de adultos inválida. Ingrese un número válido.");
            sc.nextLine();
            ingresarDetalles();
            return;
        }

        System.out.print("Ingrese cantidad de niños: ");
        try {
            niños = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Cantidad de niños inválida. Ingrese un número válido.");
            sc.nextLine();
            ingresarDetalles();
            return;
        }

        System.out.print("Ingrese cantidad de noches: ");
        try {
            noches = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Cantidad de noches inválida. Ingrese un número válido.");
            sc.nextLine();
            ingresarDetalles();
            return;
        }
    }

    public boolean excedeCapacidad(int capacidadMaxima) {
        return (adultos + niños) > capacidadMaxima;
    }
}

