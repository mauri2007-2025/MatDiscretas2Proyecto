# Proyecto de grafos

Este proyecto consiste en la implementación de un grafo no dirigido y ponderado utilizando una representación basada en listas en Java. El objetivo es aplicar la teoría de grafos, permitiendo almacenar, analizar y visualizar grafos a partir de información contenida en archivos de texto.

El programa permite construir un grafo a partir de un archivo de entrada con formato source, target, weight, donde cada línea representa una arista y su peso asociado. Una vez cargado el grafo, el programa calcula el grado de un vértice, la verificación de si el grafo es simple y la comprobación de si se trata de un grafo completo.

Además, se incluyó una visualización gráfica desarrollada con JavaFX que permite representar los vértices, las aristas y los pesos.

## Implementación elegida

Se decidió utilizar una lista de adyacencia implementada mediante un HashMap<Integer, ArrayList<Edge>>. Esta estructura fue seleccionada porque es el tema que estamos viendo actualmente en otra asignatura.

Nos fue bien con esta implementación, aunque hemos tenido dificultades con las clases.

## Estructura del Proyecto

El repositorio contiene únicamente los archivos fuente esenciales dentro de la carpeta `src`:
* `HelloApplication.java`: Carga JavaFX y crea el Stage.
* `HelloController.java`: Recibe los eventos para conectar la lógica con la interfaz
* `Launcher.java`: Lanza HelloApplication
* `Main.java`: Prueba las funcionalidades básicas del grafo
* `Edge.java`: Representa una arista del grafo
* `FileManager.java`: Lee archivos de entrada
* `Graph.java`: Clase principal encargada de almacenar la información del grafo
* `GraphVisualizer.java`: Representa el grafo con JavaFX