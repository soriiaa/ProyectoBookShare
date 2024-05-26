@Autor Pablo Aparicio: Remake del metodo conexion, para que coja datos del fichero ini en vez de los atributos, getters de conexion para devolver los parámetros 
de acceso, Metodo en controlador para meter el return de los getters en un Array de Strings para que se lo pase al método del modelo, para volver a la nueva vista
y darle el valor a los campos del contenido del fichero configuracion.ini

@Autor Alejandro Soria: Creo la pantalla nueva, donde se ponen las características de la conexión y junto con Apa linkeo la vista al fichero. Uso los métodos que ha
creado Apa para traer los datos.

@Autor Andres Galindo: Creado fichero.INI y borrado los valores de los atributos de conexión y contraseña (para que en vez de estar "hardcodeados", estos datos deben estar registrados en el archivo, para que así no todo el mundo pueda entrar) y borrado la inicialización de datos de la conexión donde no debía estar (que en nuestro caso estaba en todos lados, principalmente en las vista y la conexion).

@Autor Pablo: Punto 3 de la tarea hecho, he añadido el boton de modificar y darle funcionalidad haciendo un metodo en controlador para coger el usr(login), la url y la contraseña que haya actualmente en la ventana, ademas añadir un metodo en modelo que llama a un metodo de la vista para poder actualizar los datos que ves por pantalla a los nuevos que hayas modificado y una llamada a otro metodo en el que haga el cambio de datos en el fichero .ini y ademas devuelva con un getProperties los datos nuevos del fichero.
