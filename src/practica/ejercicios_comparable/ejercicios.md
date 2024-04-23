# INTERFACES PARA COMPARAR

## Ejercicio: Extiende figura

Vamos a partir del ejercicio realizado en el tema 6, llamado extiende figura:

1. Si no lo tenemos, mejorar el ejercicio para adaptarlo a lo que sabemos ahora.
2. Tal y como cada uno tenga su ejercicio, deberemos llegar a tener un arraList con al menos 10 figuras dentro.
3. Intentemos utilizar Collections.sort para ordenar el array ¿Qué ocurre?
4. Utilicemos la interfaz Comparable para ordenar nuestra lista de elementos.
5. Ahora probemos la interfaz Comparator y veamos la diferencia de uso entre ambas interfaces.

## Ejercicio: Comparador de Personas

Crea una clase `Estudiante` con los atributos `nombre`, `apellidos`, `fecha de nacimiento` y `nota medio`.

Tendremos en cuenta las siguientes consideraciones:

1. El criterio de ordenación por defecto de las personas es su nombre por orden alfabético. Si dos personas
   tienen el mismo nombre, se deben ordenar por sus apellidos en orden alfabético.
2. Se debe poder ordenar a las personas por su edad en orden ascendente. Si dos personas tienen la misma edad,
   se deben ordenar por su nombre en orden alfabético.
3. Se debe poder ordenar por otro criterio de ordenación, en este caso, la nota media, en orden descendente. Si dos 
   estudiantes tienen la misma nota, se deben ordenar por su edad en orden ascendente.

Con estas consideraciones las funciones que realizará el programa principal serán:

1. Obtener de un fichero almacenado en disco, la información necesaria para completar 10 personas con todos los
   datos necesarios (El fichero es como nuestra base de datos, no es necesario pedirle los datos de los usuarios al 
   usuario que ejecuta la aplicación). Los nombres de las personas serán en español, por lo que contendrán, acentos, eñes, etc. 
   y la fecha de nacimiento será en formato dd/MM/yyyy. El fichero tendrá como separador de campos el carácter `;` y 
   contendrá una cabecera para ayudar a identificar el contenido de cada campo. Ejemplo:
   
```
   nombre;apellidos;fecha de nacimiento;nota media
   Carlos;Gómez Martínez;15/03/2003;8.5
```
2. Mostrar al usuario la lista cargada, sin ordenar.
3. Mostrar al usuario la lista ordenada por el criterio de ordenación por defecto.
4. Mostrar al usuario la lista ordenada por el criterio de ordenación de la edad.
5. Mostrar al usuario la lista ordenada por el criterio de ordenación de la nota media.
6. Dejar preparados en alguna carpeta, los ficheros con usuarios de pruebas necesarios, para garantizar que todos los
   criterios de ordenación funcionan correctamente.
