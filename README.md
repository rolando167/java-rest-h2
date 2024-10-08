

# 💻 💎 Api-Rest-JPA-H2 - 2024

> 4 entidades, muchos a muchos, uno a muchos, y uno a uno

>Cliente, Pedidos, Productos y Ventas

>Un cliente tiene muchos Pedidos(fk_cliente), muchos Pedidos pertenecen a un Cliente.

>Muchos pedidos tienen muchos Productos

> Revisar el "Java-H2.postman_collection.json" en raiz para pruebas potsman

## 📌 Feactures

 * ✔ Jpa
 * ✔ Dto
 * ✔ H2
 * ✔ One to One
 * ✔ One to Many
 * ✔ Many to Many
 * ✔ Iconos folder personalizados .vscode - settings
 * ✔ Random number
 * ✔ Unidireccional de un lado al otro y nada mas
 * ✔ Bidireccional: de un lado al otro y vicervesa
 * ✔ @Query(value = "select * from ..." ) repository Product
 * ✔ @RequestParam(name = "nombre") String productName - ?nombre=Queso&marca=Nestle
 * ✔ yml - solo template
 * ✔ Mock - junit - test basico
 * ✔ Java-H2.postman_collection.json

## 🌐 Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```c
#npm 📟
> npm i
> java --version

> npm ...
```

## 🔰 Running the app

```bash
 http://localhost:8080/h2-console/

 http://localhost:8080/api/cliente/find/1

```

## 📐 Config
```python
  ** application.properties

spring.datasource.url:jdbc:h2:mem:testdb
spring.datasource.driverClassName:org.h2.Driver
spring.datasource.username:sa
spring.datasource.password:123456
spring.jpa.database-platform:org.hibernate.dialect.H2Dialect
spring.h2.console.enabled:true

ir a localhost:  http://localhost:8080/h2-console/
ingresar con password: 123456 y cabiar el "JDBC URL" por el configurado.

```

## 📝 Notas

Pull requests are welcome.

Please make sure to update tests as appropriate.

## 🖼 Images
  <img src=main.jpg alt="Main"/>

## 📚 References

```python
# returns 'words'
 * https://refactorizando.com/base-de-datos-memoria-h2-spring-boot/
 * https://www.arquitecturajava.com/spring-boot-rest-jpa-y-json/
 * https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/
 * https://www.bezkoder.com/jpa-manytoone/
 * https://www.baeldung.com/spring-data-jpa-delete
 * https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
 * https://adictosaltrabajo.com/2020/04/02/hibernate-onetoone-onetomany-manytoone-y-manytomany/
 * https://stackoverflow.com/questions/15359306/how-to-fetch-fetchtype-lazy-associations-with-jpa-and-hibernate-in-a-spring-cont
 * https://www.baeldung.com/spring-data-jpa-refresh-fetch-entity-after-save
** ----
 * YT - Dominando las Relaciones en JPA con Spring Boot: Simplificando tus conexiones a bases de datos
 * https://stackoverflow.com/questions/25112962/jpa-how-to-save-two-entities-that-have-one-to-one-relation
* https://medium.com/@bectorhimanshu/spring-data-jpa-one-to-oneunidirectional-relationship-0c6199bc6e8a
* https://www.baeldung.com/jpa-one-to-one
* https://www.baeldung.com/jpa-many-to-many
* https://medium.com/@arijit83work/manytomany-relationship-in-spring-boot-with-hibernate-and-jpa-35d7b4fdf3bf
* https://www.oscarblancarteblog.com/2018/12/27/relaciones-manytomany/
** ----
* https://www.baeldung.com/spring-request-param
* https://www.baeldung.com/jpa-query-parameters
** ----
* https://github.com/jorgejacinto9701/DAWI-Sesion06Finalizado
* https://github.com/Jose-Santillano/hotel-api-spring
* https://github.com/UnProgramadorNaceOfficial/JPA-relations
* https://github.com/latecnologiaavanza/ejemplos-relaciones-api-rest
* https://github.com/bezkoder/spring-boot-one-to-many
** ----
* https://spring.io/guides/gs/testing-web
* https://ranjeetborate.medium.com/mastering-junit-testing-for-rest-controllers-458d9629bf31
* https://rajputankit22.medium.com/remove-git-commit-which-has-not-been-pushed-c95dfb2c3209
```

## License

[MIT](https://choosealicense.com/licenses/mit/)

* [Choose an Open Source License](https://choosealicense.com)
