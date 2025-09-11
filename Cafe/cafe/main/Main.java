package cafe.main;

import cafe.cooperativacafe.CooperativaCafe;
import cafe.modelo.Lote;
import cafe.usuario.Barista;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CooperativaCafe cooperativa = new CooperativaCafe();

        cooperativa.registrarLote(new Lote("Bourbon Rosado", "Notas frutales delicadas a manzana y sandía", "Pitalito, Huila", 1318, "Carlos López", 40));
        cooperativa.registrarLote(new Lote("Castillo", "Sabor dulce; residual a cacao, canela, clavos y nuez moscada", "Paime, Cundinamarca", 960, "Dago Martínez", 300));
        cooperativa.registrarLote(new Lote("Tabi", "Acidez cítrica balanceada con notas florales", "Manizales, Caldas", 2160, "María Rojas", 120));
        cooperativa.registrarLote(new Lote("Caturra Amarillo", "Dulzor marcado con notas de miel y frutas tropicales", "San Agustín, Huila", 1730, "Nicolas Hernandez", 200));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ COOPERATIVA CAFÉ ---");
            System.out.println("1. Registrar barista");
            System.out.println("2. Suscribir barista");
            System.out.println("3. Anular suscripción");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: {
                    System.out.print("Ingrese nombre del barista: ");
                    String nombre = sc.nextLine();
                    int id = cooperativa.getBaristasRegistrados().size() + 1;
                    Barista nuevo = new Barista(id, nombre);
                    cooperativa.registrarBarista(nuevo);
                    System.out.println("Registro completado! ID del barista: " + id);
                    break;
                }

                case 2: {
                    System.out.print("Ingrese el ID del barista a suscribir: ");
                    int idSus = Integer.parseInt(sc.nextLine());
                    boolean encontrado = false;

                    for (Barista b : cooperativa.getBaristasRegistrados()) {
                        if (b.getId() == idSus) {
                            b.suscribirse(cooperativa);
                            System.out.println("Suscripción exitosa!! " + b.getNombre() + " (ID: " + b.getId() + "). Ahora recibirás los lotes disponibles:");

                            for (Lote lote : cooperativa.getLotesRegistrados()) {
                                b.update(lote);
                            }

                            encontrado = true;
                            break; 
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un barista con ID: " + idSus);
                    }
                    break;
                }

                case 3: {
                    System.out.print("Ingrese el ID del barista a anular suscripción: ");
                    int idAnular = Integer.parseInt(sc.nextLine());
                    boolean encontrado = false;

                    for (Barista b : cooperativa.getBaristasRegistrados()) {
                        if (b.getId() == idAnular) {
                            b.anularSuscripcion(cooperativa);
                            System.out.println("La suscripción del barista " + b.getNombre() + " (ID: " + b.getId() + ") ha sido anulada exitosamente.");
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontró un barista con ID: " + idAnular);
                    }
                    break;
                }

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
