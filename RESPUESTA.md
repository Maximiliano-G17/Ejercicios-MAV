Hola que tal, me llamo Maximiliano Gimenez, les comento, Soy Dev Java Jr, en este proyecto hice los 3 ejercicios que pidieron,
el diagrama, el ejercicio 1 y el 2, tanto el ejercicico 1 y 2 los hice en rest sin front end.

Sobre Bonus:
- Realize los test de todos los metodos usados en esta app, se encuentran en src/test/java.
- Reemplace la BBDD H2  por una BBDD MySql, use el programa wampserver64 para utilizar dicha BBDD.
Los datos de la configuracion para conectarme a Mysql se encuentran en el archivo .properties
- Tengo conocimientos basicos sobre Spring Security (autenticacion y para verificar si un usuario tiene autorizacion para ver una
pagina, tengo un proyecto subido a git donde se puede corroborar, es un front basico usando html y thymeleaf, aca les dejo
el repo por si estan interesados: https://github.com/Maximiliano-G17/Spring-Boot-Project).

Url ejercicios 1 y 2: 

PhysicalPersonController:

read all: "people/" @GetMapping;
read only CC: "people/CC/" @GetMapping;
read by id: "people/id" @GetMapping("/{id}");
create: "people/" @PostMapping;
update: "people/id" @PutMapping("/{id}");
delete: "people/id" @DeleteMapping("/{id}").

LegalPersonController:

read all: "legalPerson/" @GetMapping("/");
read by id: "legalPerson/id" @GetMapping("/{id}");
create: "legalPerson/" @PostMapping;
update: "legalPerson/id" @PutMapping("/{id}");
delete: "legalPerson/id" @DeleteMapping("/{id}").

CurrentAccountController:

read all: "currentAccount/" @GetMapping;
delete: "currentAccount/id" @DeleteMapping("/{id}");
create "currentAccount/" @PostMapping.

MovementController:

read all by account: "movement/id" @GetMapping("/{id}");
create: "movement/" @PostMapping.


Desde ya muchas gracias de antemano por su atención.
Un cordial saludo.