# Conversor de Divisas

Este proyecto es una aplicación de consola en Java que permite convertir una cantidad de dinero de una moneda a otra utilizando una API de tipo de cambio.

## Descripción

El programa permite al usuario seleccionar dos monedas y una cantidad de dinero, y luego utiliza la API de ExchangeRate para obtener el tipo de cambio y realizar la conversión. El resultado de la conversión se muestra en la consola. El usuario también tiene la opción de realizar múltiples conversiones consecutivas.

## Requisitos

- Java 11 o superior
- Una conexión a Internet para acceder a la API de tipo de cambio

## Estructura del Proyecto

El proyecto contiene las siguientes clases:

### Modelos

#### Divisa

Clase que representa una conversión de divisas y contiene los atributos `moneda1`, `moneda2`, `valorTotal`, `valorUnitario` y `cantidad`.

#### DivisaAPI

Clase que representa la estructura de datos recibida desde la API de tipo de cambio.

#### ListaDeMonedas

Clase que muestra una lista de monedas disponibles para la conversión.

### Main

#### Principal

Clase principal que contiene el método `main` y la lógica del programa.

## Cómo ejecutar el programa

1. Clona este repositorio o descarga los archivos de código fuente.
2. Asegúrate de tener Java 11 o superior instalado en tu máquina.
3. Abre una terminal y navega hasta el directorio del proyecto.

## Uso

1. Al iniciar el programa, se te pedirá que ingreses el número correspondiente a la moneda en la que tienes tu dinero.
2. Luego, se te pedirá que ingreses el número correspondiente a la moneda a la cual quieres convertir tu dinero.
3. Ingresa la cantidad de dinero que deseas convertir.
4. El programa mostrará el resultado de la conversión.
5. Se te preguntará si deseas realizar otra conversión (S/N).

