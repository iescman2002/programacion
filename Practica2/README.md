# Práctica 02 - Java II  
## Operaciones con Arrays

---

### Índice y Enunciados:

#### 1. Fundamentos de arrays
- [Ejercicio 1](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio1.java)
  
  Crea un array de 10 posiciones de números con valores pedidos por teclado. Muestra por consola el índice y el valor al que corresponde.
- [Ejercicio 2](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio2.java)
  
  Muestra por pantalla todos los elementos de un array de números enteros separados por un espacio.
- [Ejercicio 3](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio3.java)
  
  Crea un array que contenga 5 números. Realiza un programa que te muestre por pantalla SOLO el más pequeño de ellos. 
- [Ejercicio 4](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio4.java)  

  Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100. Obtén la suma de todos ellos y la media.
- [Ejercicio 5](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio5.java)  
  Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos el array con números aleatorios entre 0 y 9, al final muestra por pantalla el valor de cada posición y la suma de todos los valores.
---

#### 2. Procesamiento con condiciones
- [Ejercicio 6](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio6.java)

  Programa Java que guarda en un array 10 números enteros que se leen por teclado. A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.

- [Ejercicio 7](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio7.java)

  Programa Java que llene un array con 10 números enteros que se leen por teclado. A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.
- [Ejercicio 8](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio8.java)  

  Programa Java para leer la altura de N personas y calcular la altura media. Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media. El valor de N se pide por teclado y debe ser entero positivo.
---

#### 4. Arrays combinados y bidimensionales
- [Ejercicio 9 - Máximo, mínimo y posiciones](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio9.java)

Crea un programa en Java que:
<ol>
  <li>Pida al usuario por teclado 10 números enteros y los guarde en un array.</li>
  <li>Recorra el array para encontrar:
    <ul>
      <li>El <b>valor máximo</b> y la posición en la que aparece.</li>
      <li>El <b>valor mínimo</b> y la posición en la que aparece.</li>
    </ul>
  </li>
</ol>
  Muestre el resultado en consola, por ejemplo:
  <pre>Valor máximo: 92 en la posición 4
Valor mínimo: -3 en la posición 7</pre>

- [Ejercicio 10](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio10.java)

  Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas. El nombre del estudiante lo introduce el usuario por teclado (usa la clase Scanner). Utiliza un array para los nombres de los alumnos y otro para las notas. ¿Serías capaz de hacerlo con un array Bidimensional?
- [Ejercicio 11](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio11.java)
- 
  Escribe un programa java que invierta el orden de los valores de un array. Por invertir el orden de los valores de un array, me refiero que el último pasa a ser el primero, el penúltimo el segundo y así sucesivamente. PRUEBA CON UN ARRAY DE TAMAÑO 6.
- [Ejercicio 12](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio12.java)  
  En España cada persona está identificada con un Documento Nacional de Identidad (DNI) en el que figura un número y una letra, por ejemplo 56999545W. Realiza un programa donde le pidas al usuario SOLO el número del dni y el programa te devuelva la letra. Para calcular la letra solo tienes que dividir el número del DNI entre 23, el resto de esta división se corresponde con la posición de la letra en el abecedario. Utiliza un array para guardar CADA letra del abecedario. 

---

#### 5. Transición a listas dinámicas (ArrayList)
- [Ejercicio 13 – Lista de números y suma total](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio13.java)

  Crea un programa que:
  - Cree una <b>lista de enteros</b> (_ArrayList&lt;Integer&gt;_).
  - Pida números por teclado hasta que el usuario introduzca un número negativo (ese no se añade).  
  - Muestre por pantalla <b>todos los números de la lista</b> y <b>la suma total</b> de los mismos.

- [Ejercicio 14 – Lista de nombres y búsqueda](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio14.java)

  Crea un programa que:
    - Cree una <b>lista de Strings</b> (_ArrayList&lt;String&gt;_).
    - Pida al usuario nombres por teclado hasta que introduzca la palabra <span style="color: green;">"fin"</span>.
    - Luego pida un nombre a buscar y diga si está en la lista o no, mostrando también en qué <b>posición</b> se encuentra si existe.

- [Ejercicio 15 – Ordenar y eliminar duplicados](https://github.com/iescman2002/programacion/blob/main/Practica2/src/Ejercicio14.java)
  Crea un programa que:
    - Cree una <b>lista de enteros</b> (_ArrayList&lt;Integer&gt;_).
    - Pida al usuario 10 números enteros y los añada a la lista.
    - Elimine los <b>valores duplicados</b> manteniendo solo el primero que apareció.
    - Ordene la lista de menor a mayor y la muestre por pantalla.
