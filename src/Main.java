import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Material[] inventario = {
                new Material("Cable HDMI", 2),
                new Material("Ratón", 3),
                new Material("Adaptador", 1)
        };

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("Hola, ¿Que necesitas?:\n1· Mostrar disponibilidad.\n2· Solicitar material\n 3· Devolver material\n 4· Salir");
            opcion = sc.nextInt();
            if (opcion >= 1 && opcion <= 4) {
                switch (opcion) {

                    case 1 -> {
                        for (Material material : inventario) {
                            System.out.println(material.nombre + ": " + material.stock + ", prestados:" + material.prestados);
                        }
                    }

                    case 2 -> {
                        System.out.println("¿Que objeto necesitas?:\nCable HDMI ->1\nRatón -> 2\nAdaptador -> 3");
                        int objeto = sc.nextInt();
                        if (objeto >= 1 && objeto <= 3) {
                            int numero = objeto - 1;
                            System.out.println("¿Cuantas unidades necesitas?");
                            int cantidad = sc.nextInt();
                            if (cantidad <= 0) {
                                System.out.println("Cantidad no válida");
                            } else if (inventario[numero].stock < cantidad) {
                                System.out.println("No hay tantos, solo nos quedan " + inventario[numero].stock);
                            } else {
                                inventario[numero].stock = inventario[numero].stock - cantidad;
                                inventario[numero].prestados += cantidad;
                                System.out.println("¡Hecho! Aqui tienes " + cantidad + "de " + inventario[numero].nombre);
                            }
                        } else {
                            System.out.println("Introduce un número válido");
                        }
                    }

                    case 3 -> {
                        System.out.println("¿Que objeto vas a devolver?:\nCable HDMI ->1\nRatón -> 2\nAdaptador -> 3");
                        int objeto = sc.nextInt();
                        if (objeto >= 1 && objeto <= 3) {
                            int numero = objeto - 1;
                            System.out.println("¿Cuantas unidades vas a devolver?");
                            int cantidad = sc.nextInt();
                            if (cantidad <= 0) {
                                System.out.println("Cantidad no válida");
                            } else if (inventario[numero].prestados < cantidad) {
                                System.out.println("No echamos tantos en falta, solo hemos prestado " + inventario[numero].prestados);
                            } else {
                                inventario[numero].stock = inventario[numero].stock + cantidad;
                                inventario[numero].prestados -= cantidad;
                                System.out.println("¡Hecho! Gracias por devolver " + cantidad + " " + inventario[numero].nombre);
                            }
                        } else {
                            System.out.println("Introduce un número válido");
                        }
                    }

                    case 4 -> {
                        System.out.println("Prestamos pendientes:\n");
                        int total = 0;
                        for (Material material : inventario) {
                            total = total + material.prestados;
                            System.out.println(material.nombre + ": " + material.prestados + "\n");
                        }
                        System.out.println("Total: " + total + " objetos prestados");
                    }
                }
            } else {
                System.out.println("Introduce un número válido");
            }
        }
    }
}
