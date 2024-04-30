# Sistema de acceso con alta mejorada

Vamos a mejorar el alta de usuario con algunos detalles.

### Dar de alta

Implicará pedir al usuario una serie de datos relevante para nuestro aplicativo, que almacenaremos en un fichero.
Los datos a pedir al usuario deberán cumplir unos requisitos y serán como mínimo los siguientes (si teníamos otros, 
los podemos mantener):

- Nombre y apellidos: Apellido1 Apellido 2, Nombre (Tanto nombre como apellidos aceptan guiones) y no es obligatorio 
  que haya dos apellidos.
- Correo electrónico: nombre_usuario@dominio
- Dirección IP: xxx.xxx.xxx.xxx (IPv4)
- Teléfono:
- Nick: Todo en minúsculas y como único símbolo permitido el _ (guión bajo)
- Password: Debe tener como mínimo 8 caracteres, entre los cuales es obligatorio encontrar minusculas, 
  mayúsculas, números y símbolos 
- Doble confirmación de password.

En caso de no cumplir alguno de los requisitos especificados, justo en el momento de la introducción de ese dato, se 
informará apropiadamente al usuario y se le indicará que lo intente de nuevo. Importante avisar en el momento de 
introducción del dato erróneo, ya que si no, le obligaremos a introducir todo de nuevo y eso casi seguro que provoca 
que se marche de nuestra aplicación (usabilidad).

En caso de completar toda la información correctamente, le preguntaremos si está seguro de ser almacenado en nuestro 
sistema y en caso afirmativo, procedemos a guardar su usuario.
Ante respuesta negativa, le despediremos apropiadamente.
