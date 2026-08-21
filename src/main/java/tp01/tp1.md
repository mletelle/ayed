1.4 La diferencia esrta en la inprementaacion interna de los tipos de lista.
Pero para quien utiliza estas dos listas, ambas respetan la misma firma por lo que su uso es igual.
Porlo que puedo abstraerme de como se almacena internamente y solo preocuparme solamente con las operaciones que ofrece
la lista.

1.6.a Si, algunos metodos podrian implementarse en la superclase (como esvacia, no varia en la subclase).
Pero hay otras operaciones que dependen de la implementacion, si es vector o lista enlazada, esos si o si deben
implementarse en las subclases y no pueden tener una definicion comun (o quiza usando template method pero sigue
requiriendo implementacion de metodos diferentes en la subclase).

1.6.b al agregar al principio, el nuevo nodo debe apuntar al antiguo primer nodo y la referencia al inicio debe
actualizarse para apuntar al nuevo, sin necesidad de recorrer la lista. al agregar en el medio es necesario localizar la
posicion y modificar los enlaces entre el nodo anterior, el nuevo nodo y el siguiente, teniendo cuidado de no perder el
resto d la lista. al agregar al final, si solamente se dispone de la referencia al inicio seria necesario recorrer la
lista hasta encontrar el ultimo nodo pero con una referencia al fin se puede enlazar directamente el nuevo nodo y
actualizar el fin

1.6.c En clase se hablo que Java es base 0 y que el primer indice de un vector Java es siempre 0. Pero en una lista se
puede decidir que sus posiciones empiecen en 1. Por lo que depende, hay que diferenciar el indice de la posicion.

2.1 Si pueden resolverse utilizando listas genericas, solo definiendo Integer como tipo de dato, el resto de mi
implementacion se mantiene tal cual

2.4.a Ambas se mantienen practicamente igual, pero la implementación generica permite reutilizar el mismo codigo para
distintos tipos de datos.

2.4.b el nodo no sabe que va a almacenar hasta que es definido, se define utilizando un parámetro de tipo T.
Su dato es de tipo T y su referencia al siguiente elemento es de tipo nodo <T>. Para crear una instancia se reemplaza a
T, en este caso NodoGenerico<Estudiante> pero puede ser <Int>, <String>, etc.

2.4.c devuelve el dato almacenado en la posicion del parametro de entrada, genericamente devuelve T que al ser definido
devuelve este tipo de dato

2.4.d 