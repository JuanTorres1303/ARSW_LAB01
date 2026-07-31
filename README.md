

### Escuela Colombiana de Ingeniería
### Arquitecturas de Software - ARSW
## Ejercicio Introducción al paralelismo - Hilos - Caso BlackListSearch

##### Integrantes 

- Juan Camilo Torres Suarez
- Valeria Bermudez Aguilar

### Descripción
Este ejercicio contiene una introducción a la programación con hilos en Java, además de la aplicación a un caso concreto.


**Parte I - Introducción a Hilos en Java**

1. De acuerdo con lo revisado en las lecturas, complete las clases CountThread, para que las mismas definan el ciclo de vida de un hilo que imprima por pantalla los números entre A y B.

![evidencia2.png](img%2Fevidencia2.png)


- Según lo comprendido en las lecturas, en la clase **CountThreadMain** primero se definen los atributos inicio y fin, que representan el rango de números que recorrerá el hilo. Luego se crea el constructor, lo que hace este es que  recibe como parámetros el rango inicial y el rango final para inicializarlos  atributos. Por último, se sobrescribe el método run(), donde se crea un ciclo que recorre los valores desde el rango inicial hasta el rango final, ejecutando la tarea que se le da  al hilo.

2. Complete el método __main__ de la clase CountMainThreads para que:
    1. Cree 3 hilos de tipo CountThread, asignándole al primero el intervalo [0..99], al segundo [99..199], y al tercero [200..299].
         ![evidencia1.png](img%2Fevidencia1.png)
         - Por otro lado, en la clase CountThread se encuentra el método main(), donde se crean los tres hilos con sus respectivos rangos de ejecución. Finalmente, se inicia cada uno de ellos mediante el método start()
    2. Inicie los tres hilos con 'start()'.
    3. Ejecute y revise la salida por pantalla.
       ![resultado1y2.png](img%2Fresultado1y2.png)
    4. Cambie el incio con 'start()' por 'run()'. Cómo cambia la salida?, por qué?.
   
      ![resultado3.png](img%2Fresultado3.png)
      - como podemos evidencial al momento de ejecutar los hilos con .start() el resultado se puede ver en desorden ya que  


