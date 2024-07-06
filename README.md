

# 💻 💎 Api-Rest-JPA-H2 -

> 3 entidades, muchos a muchos, uno a muchos, y uno a uno

>Cliente, Pedidos y Productos

>Un cliente tiene muchos Pedidos(fk_cliente), muchos Pedidos pertenecen a un Cliente.

>Muchos pedidos tienen muchos Productos

## 📌 Feactures

 * ✔ Jpa
 * ✔ Dto
 * ✔ H2
 * ✔ One to One
 * ✔ One to Many
 * ✔ Many to Many
 * ✔ Iconos folder personalizados .vscode - settings


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
 * https://github.com/bezkoder/spring-boot-one-to-many
 * https://www.baeldung.com/spring-data-jpa-delete
 * https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
 * https://adictosaltrabajo.com/2020/04/02/hibernate-onetoone-onetomany-manytoone-y-manytomany/
 * https://stackoverflow.com/questions/15359306/how-to-fetch-fetchtype-lazy-associations-with-jpa-and-hibernate-in-a-spring-cont
 * https://www.baeldung.com/spring-data-jpa-refresh-fetch-entity-after-save
 * 


```

## License

[MIT](https://choosealicense.com/licenses/mit/)

* [Choose an Open Source License](https://choosealicense.com)