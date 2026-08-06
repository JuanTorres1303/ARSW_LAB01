

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

**Parte II - Ejercicio Black List Search**

   1. Cree una clase de tipo Thread que represente el ciclo de vida de un hilo que haga la búsqueda de un segmento del conjunto de servidores disponibles. Agregue a dicha clase un método que permita 'preguntarle' a las instancias del mismo (los hilos) cuantas ocurrencias de servidores maliciosos ha encontrado o encontró.
    ![ClaseHilo2.png](/img/ClaseHilo2.png)

   2. Agregue al método 'checkHost' un parámetro entero N, correspondiente al número de hilos entre los que se va a realizar la búsqueda (recuerde tener en cuenta si N es par o impar!). Modifique el código de este método para que divida el espacio de búsqueda entre las N partes indicadas, y paralelice la búsqueda a través de N hilos. Haga que dicha función espere hasta que los N hilos terminen de resolver su respectivo sub-problema, agregue las ocurrencias encontradas por cada hilo a la lista que retorna el método, y entonces calcule (sumando el total de ocurrencuas encontradas por cada hilo) si el número de ocurrencias es mayor o igual a BLACK_LIST_ALARM_COUNT. Si se da este caso, al final se DEBE reportar el host como confiable o no confiable, y mostrar el listado con los números de las listas negras respectivas. Para lograr este comportamiento de 'espera' revise el método join del API de concurrencia de Java. Tenga también en cuenta:

   Dentro del método checkHost Se debe mantener el LOG que informa, antes de retornar el resultado, el número de listas negras revisadas VS. el número de listas negras total (línea 60). Se debe garantizar que dicha información sea verídica bajo el nuevo esquema de procesamiento en paralelo planteado.

   Se sabe que el HOST 202.24.34.55 está reportado en listas negras de una forma más dispersa, y que el host 212.24.24.55 NO está en ninguna lista negra.
    
   ![checkHost.png](/img/checkhost.png)

