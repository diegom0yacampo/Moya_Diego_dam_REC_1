PREGUNTA 1
Explica cómo funciona la relación 1:N entre CentroForense y MuestraForense tanto en SQL como en Java.
En SQL la relación se construye con una clave ajena. La tabla MuestraForense
tiene una columna CentroForense_ID que referencia CentroForense(ID).
Una CentroForense puede tener muchos MuestraForense, pero un MuestraForense pertenece
a una sola CentroForense. Por eso la FK vive en el lado N (MuestraForense).

En Java la relacion se representa con un atributo de tipo objeto
dentro del lado N:

    private CentroForense centroforense;

Es decir, el MuestraForense NO guarda un CentroForense_id suelto, guarda una
referencia al objeto CentroForense entero.
De esta manera el DAO no devuelve filas SQL, devuelve objetos Java
completamente relacionados.

PREGUNTA 2

Explica por qué en Java utilizamos:

private CentroForense centro;

y no:

private int centroId;


Porque con un int es trabajar con el modelo relacional, no con el modelo de objetos. Si MuestraForense guardara solo CentroForenseId, cada
vez que necesitaramos el nombre de la editorial o su pais tendriamos
que volver a la base de datos a buscarla.
- mantiene la cardinalidad real (MuestraForense  pertenece a UNA CentroForense)
- evita ir a base de datos varias veces
- permite que el DAO devuelva objetos navegables (MuestraForense.getCentroForense().getNombre())
- la asociacion UML se respeta exactamente igual en Java que en el diagrama

Un int es solo un identificador; un CentroForense es la
entidad real. JDBC + DAO artesanal nos exige reconstruir el objeto
y mantener la relacion en memoria.


PREGUNTA 3

Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.

Por Seguridad: PreparedStatement separa la
sentencia SQL de los parámetros. Si concatenamos manualmente
(`"... WHERE id = " + entrada`) un usuario malicioso puede
inyectar codigo SQL. PreparedStatement escapa los valores
automáticamente. y por Rendimiento ya que la base de datos compila la     sentencia UNA vez
y la reutiliza con distintos parámetros. Concatenando, cada
consulta es nueva para el motor.
