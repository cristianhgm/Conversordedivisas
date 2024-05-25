package Main;

import Modelos.Divisa;
import Modelos.DivisaAPI;
import Modelos.ListaDeMonedas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        ListaDeMonedas milistaDeMonedas = new ListaDeMonedas();
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Ingrese el numero de la moneda en que tiene su dinero: ");
                milistaDeMonedas.listaDeMonedas();
                int opcion1 = lectura.nextInt();
                lectura.nextLine();

                boolean opcionValida = true;
                String moneda1 = switch (opcion1) {
                    case 1 -> "ARS";
                    case 2 -> "BRL";
                    case 3 -> "CAD";
                    case 4 -> "CLP";
                    case 5 -> "COP";
                    case 6 -> "EUR";
                    case 7 -> "MXN";
                    case 8 -> "NIO";
                    case 9 -> "PEN";
                    case 10 -> "USD";
                    default -> {
                        opcionValida = false;
                        yield "";
                    }
                };

                if (!opcionValida) {
                    System.out.println("Opción inválida. Ingrese una opción válida.\n");
                    continue; //Reinicia el ciclo `while`
                }

                System.out.println("su moneda elegida fue: " + moneda1  + "\n");

                System.out.println("Ingrese el numero de la moneda a la cual quiere convertir su dinero: ");
                milistaDeMonedas.listaDeMonedas();
                int opcion2 = lectura.nextInt();
                lectura.nextLine();

                String moneda2 = switch (opcion2) {
                    case 1 -> "ARS";
                    case 2 -> "BRL";
                    case 3 -> "CAD";
                    case 4 -> "CLP";
                    case 5 -> "COP";
                    case 6 -> "EUR";
                    case 7 -> "MXN";
                    case 8 -> "NIO";
                    case 9 -> "PEN";
                    case 10 -> "USD";
                    default -> {
                        opcionValida = false;
                        yield "";
                    }
                };

                if (!opcionValida) {
                    System.out.println("Opción inválida. Ingrese una opción válida.\n");
                    continue;
                }

                System.out.println("su moneda elegida fue: " + moneda2 + "\n");

                System.out.println("Ingrese la cantidad a convertir: ");
                Double cantidad = Double.valueOf(lectura.nextLine().trim());

                String vinculo = "https://v6.exchangerate-api.com/v6/935dde2b917b2c72b155617f/pair/" + moneda1 + "/" + moneda2 + "/" + cantidad;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(vinculo))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                DivisaAPI miDivisaAPI = gson.fromJson(json, DivisaAPI.class);
                Divisa miDivisa = new Divisa(miDivisaAPI);
                miDivisa.setCantidad(cantidad);
                System.out.println(miDivisa + "\n");

                System.out.println("¿Desea realizar otra conversión? (S/N) \n");
                String respuesta = lectura.nextLine().trim().toLowerCase();

                if (!respuesta.equals("s")) {
                    continuar = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado es inválido, recuerde poner un numero\n");
                lectura.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es una cantidad valida\n");
            }
        }

        lectura.close();
    }
}
