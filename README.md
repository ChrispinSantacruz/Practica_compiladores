Integrantes: Christian Santacruz- Nathalia Cabrera
# Practica1 
# Comandos utilizados: 
antlr4 Calculadora.g4 javac *.java
java org.antlr.v4.runtime.misc.TestRig Calculadora prog -tokens < input.txt
java org.antlr.v4.runtime.misc.TestRig Calculadora prog -tree < input.txt
# Expresion generada para los tokens 
echo -e "a = 10;\nb = 5 + a * 2;\nc = (b - 3) / 2;" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tokens
# Tokens generados: 
[@0,0:0='a',<ID>,1:0]
[@1,2:2='=',<'='>,1:2]
[@2,4:5='10',<INT>,1:4]
[@3,6:6=';',<';'>,1:6]
[@4,8:8='b',<ID>,2:0]
[@5,10:10='=',<'='>,2:2]
[@6,12:12='5',<INT>,2:4]
[@7,14:14='+',<'+'>,2:6]
[@8,16:16='a',<ID>,2:8]
[@9,18:18='',<''>,2:10]
[@10,20:20='2',<INT>,2:12]
[@11,21:21=';',<';'>,2:13]
[@12,23:23='c',<ID>,3:0]
[@13,25:25='=',<'='>,3:2]
[@14,27:27='(',<'('>,3:4]
[@15,28:28='b',<ID>,3:5]
[@16,30:30='-',<'-'>,3:7]
[@17,32:32='3',<INT>,3:9]
[@18,33:33=')',<')'>,3:10]
[@19,35:35='/',<'/'>,3:12]
[@20,37:37='2',<INT>,3:14]
[@21,38:38=';',<';'>,3:15]
[@22,40:39='<EOF>',<EOF>,4:0]
 # árbol de análisis sintáctico: 
 echo -e "a = 10;\nb = 5 + a * 2;\nc = (b - 3) / 2;" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tree
# Expresion generada:
(programa (sentencia (asignacion a = (expresion 10) ;)) (sentencia (asignacion b = (expresion (expresion 5) + (expresion (expresion a) * (expresion 2))) ;)) (sentencia (asignacion c = (expresion (expresion ( (expresion (expresion b) - (expresion 3)) )) / (expresion 2)) ;)) <EOF>)
# 1. ¿Cómo se representan los operadores +, -, * y / en los tokens generados?
R/ Se definen Como operadores aritméticos específicos, por lo que quiere decir que ANTLR4 si reconoce estos operadores como tokens individuales, pero no los define explícitamente en las reglas léxicas ejemplo luxer
Tokens individuales en la salida de ANTLR4 (ejemplo: [@7,14:14='+',<'+'>,2:6]).

# 2. ¿Qué estructura sigue el árbol de análisis sintáctico generado por ANTLR4 para la expresión b = 5 + a * 2;?
R/ * se evalúa antes que +, organizando el árbol en función de la precedencia.
En esta gramática, cuando vemos 'a * 2', se debe calcular primero, antes de la suma con el 5
 Respuesta correcta: d) * se evalúa antes que +, organizando el árbol en función de la precedencia, en la salida de -tree, el árbol generado muestra b = (5 + (a * 2)), respetando la precedencia.

# 3. ¿Por qué es importante visualizar los tokens y el árbol de análisis en el proceso de compilación?
Respuesta correcta: d) Todas las anteriores.

son todas las anteriores ya que Analiza los tokens y el árbol ayuda a comprender cómo el código fuente se descompone en estructuras y la estructura del árbol influye en la generación de código y permite detectar errores en la gramática y corregir problemas.


# Practica 2 
Comandos utilizados 
# Comandos utilizados: 
antlr4 Calculadora.g4 javac *.java
java org.antlr.v4.runtime.misc.TestRig Calculadora prog -tokens < input.txt
java org.antlr.v4.runtime.misc.TestRig Calculadora prog -tree < input.txt
# Expresion generada para los tokens 
echo -e "x = 0;\nwhile (x < 5) {\n    x = x + 1;\n}" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tokens
# Tokens generados: 
[@0,0:0='x',<ID>,1:0]
[@1,2:2='=',<'='>,1:2]
[@2,4:4='0',<INT>,1:4]
[@3,5:5=';',<';'>,1:5]
[@4,7:11='while',<'while'>,2:0]
[@5,13:13='(',<'('>,2:6]
[@6,14:14='x',<ID>,2:7]
[@7,16:16='<',<'<'>,2:9]
[@8,18:18='5',<INT>,2:11]
[@9,19:19=')',<')'>,2:12]
[@10,21:21='{',<'{'>,2:14]
[@11,27:27='x',<ID>,3:4]
[@12,29:29='=',<'='>,3:6]
[@13,31:31='x',<ID>,3:8]
[@14,33:33='+',<'+'>,3:10]
[@15,35:35='1',<INT>,3:12]
[@16,36:36=';',<';'>,3:13]
[@17,38:38='}',<'}'>,4:0]
[@18,40:39='<EOF>',<EOF>,5:0]
 # árbol de análisis sintáctico:
  $ echo -e "x = 0;\nwhile (x < 5) {\n    x = x + 1;\n}" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tree
# Expresion generada:
(programa (sentencia (asignacion x = (expresion 0) ;)) (sentencia (whileStmt while ( (condicion x < 5) ) { (sentencia (asignacion x = (expresion (expresion x) + (expresion 1)) ;)) })) <EOF>)

# 1. Qué tokens se generan para la estructura while (x < 5) { x = x + 1; }?
R/ a) WHILE, (, ID, <, INT, ), {, ID, =, ID, +, INT, }
Los tokens generados corresponden a los elementos que componen la expresión. while es reconocido como un token de palabra clave, ( y ) como paréntesis, x es un identificador (ID), < y + son operadores, 5 y 1 son enteros (INT), = es un operador de asignación, { y } son los delimitadores de bloque.

# 2. ¿Cómo se organiza la estructura while en el árbol de análisis sintáctico?
R/c) while es el nodo raíz y su condición y cuerpo son nodos secundarios.
El nodo while será el nodo raíz, este nodo tiene dos componentes; la condición (como un subnodo de tipo condicion) y el cuerpo del while (como un subnodo de tipo sentencia).

# 3. ¿Qué ocurre si en la gramática se omiten las llaves {} en la estructura while?
R/
b) Se genera un error de sintaxis.
Las llaves {} son necesarias para definir un bloque de sentencias dentro de un while. Si se omiten, se genera un error de sintaxis por lo cuela no podra interpretar correctamente el bloque.

# Practica3 
# Expresion generada para los tokens
echo -e "for (i = 0; i < 10; i = i + 1) {\n    x = x + i;\n}" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tokens
# Tokens generados: 
[@0,0:2='for',<'for'>,1:0]
[@1,4:4='(',<'('>,1:4]
[@2,5:5='i',<ID>,1:5]
[@3,7:7='=',<'='>,1:7]
[@4,9:9='0',<INT>,1:9]
[@5,10:10=';',<';'>,1:10]
[@6,12:12='i',<ID>,1:12]
[@7,14:14='<',<'<'>,1:14]
[@8,16:17='10',<INT>,1:16]
[@9,18:18=';',<';'>,1:18]
[@10,20:20='i',<ID>,1:20]
[@11,22:22='=',<'='>,1:22]
[@12,24:24='i',<ID>,1:24]
[@13,26:26='+',<'+'>,1:26]
[@14,28:28='1',<INT>,1:28]
[@15,29:29=')',<')'>,1:29]
[@16,31:31='{',<'{'>,1:31]
[@17,37:37='x',<ID>,2:4]
[@18,39:39='=',<'='>,2:6]
[@19,41:41='x',<ID>,2:8]
[@20,43:43='+',<'+'>,2:10]
[@21,45:45='i',<ID>,2:12]
[@22,46:46=';',<';'>,2:13]
[@23,48:48='}',<'}'>,3:0]
[@24,50:49='<EOF>',<EOF>,4:0]
# árbol de análisis sintáctico:  
echo -e "for (i = 0; i < 10; i = i + 1) {\n    x = x + i;\n}" | java org.antlr.v4.runtime.misc.TestRig MiGramatica programa -tree
# Expresion generada:
(programa (sentencia (forStmt for ( (inicializacion i = (expresion 0)) ; (condicion i < 10) ; (actualizacion i = (expresion (expresion i) + (expresion 1))) ) { (sentencia (asignacion x = (expresion (expresion x) + (expresion i)) ;)) })) <EOF>)

# 1. Qué tokens se generan para la estructura for (i = 0; i < 10; i = i + 1) { x = x + i; }?
R/ a) FOR, (, ID, =, INT, ;, ID, <, INT, ;, ID, =, ID, +, INT, ), {, ID, =, ID, +, ID, }

# 2. ¿Cómo se organiza la estructura for en el árbol de análisis sintáctico?
R/
a) for es el nodo raíz y sus componentes (inicialización, condición, actualización y cuerpo) son nodos secundarios.
for es el nodo raíz, ya que es la estructura principal del ciclo. Los subcomponentes de la estructura for, como la inicialización, condición, actualización y cuerpo del ciclo, se representan como nodos secundarios. El árbol refleja la jerarquía y organización de estas partes dentro de la estructura del for.

# 3. ¿Qué ocurre si en la gramática se omiten los ; en la estructura for?
R/
a) Se genera un error de sintaxis.
En la gramática que hemos definido, los ; son necesarios para separar las partes del encabezado del for (inicialización, condición, y actualización). Si se omiten, el analizador generará un error de sintaxis, ya que no podrá interpretar correctamente las distintas partes del ciclo for. La gramática espera estos delimitadores (;) como parte de la sintaxis del for.
  
