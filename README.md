# Juego de Cartas

Proyecto de juego de cartas desarrollado en Java con interfaz gráfica Swing. El programa permite repartir cartas a dos jugadores, identificar grupos y escaleras, y mostrar el puntaje restante según las cartas que no fueron combinadas.

## Autores

- Paola Andrea García Gonzalez
- Jose Manuel Sanchez Taborda
- Wilmar Arley Zapata Villa

## Descripción

La aplicación simula una partida simple en la que cada jugador recibe 10 cartas. Luego se pueden verificar combinaciones como:

- Grupos de cartas iguales
- Escaleras por palo
- Puntaje de cartas sobrantes

La interfaz presenta dos pestañas para cada jugador y botones para repartir y verificar la mano.

## Requisitos

- Java JDK 8 o superior
- Entorno con línea de comandos para compilar y ejecutar

## Ejecución

Desde la raíz del proyecto, ejecuta:

```bash
javac src/*.java
java -cp src App
```

## Estructura del proyecto

```text
juegoCartas/
├── src/
│   ├── App.java
│   ├── Baraja.java
│   ├── Carta.java
│   ├── FrmJuego.java
│   ├── Grupo.java
│   ├── Jugador.java
│   ├── NombreCarta.java
│   ├── Pinta.java
│   └── imagenes/
├── .gitignore
├── README.md
└── ...
```

## Clases principales

- `App`: punto de entrada de la aplicación.
- `FrmJuego`: ventana principal con la interfaz gráfica.
- `Baraja`: genera y reparte las cartas del mazo.
- `Jugador`: maneja la mano, combinaciones y puntaje.
- `Carta`: representa una carta individual.
- `Grupo` y `NombreCarta`: enums para las combinaciones y nombres de las cartas.
- `Pinta`: enum para los palos.

## Funcionalidad básica

1. El usuario presiona "Repartir".
2. Se baraja la baraja y se reparten cartas a cada jugador.
3. Se selecciona el jugador activo en la pestaña.
4. Se presiona "Verificar" para mostrar grupos, escaleras y puntaje.

## Nota

Este proyecto es una implementación sencilla académica para practicar programación orientada a objetos y manejo de interfaces en Java.
