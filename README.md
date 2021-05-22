<h1 align="center">Escuela Colombiana de Ingenieria Julio Garavito</h1>
<h3 align="center">Ciclos de vida y desarrollo de Software 2020-1</h3> 
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/login.PNG"/></p> 

### Integrantes

- URREA GARCIA RICHARD SANTIAGO (Product Owner)
- SALAZAR BOHORQUEZ ANA MARIA (Product Owner)
- CEPEDA ALZA JOHANN ALFONSO (Product Owner)
- POSSO GUEVARA JUAN CAMILO (Product Owner)

### Profesor
+ Julián Velasco (Product Owner)


## Contenidos:
---
- [Descripción del producto](#Descripción)
- [Arquitectura y Diseño detallado](#Arquitectura-y-diseño-detallado)
- [Descripción del proceso](#Descripción-del-proceso)

## Descripción
---
Lets Support  es  un sistema  que ayuda a que los estudiantes puedan dar a conocer a la comunidad de la escuela cualquier necesidad que tengan para poder llevar a cabo sus actividades académicas en la escuela y por otro lado, busca que los demás miembros de la escuela puedan facilitar estos elementos de forma fácil y sin complicaciones.De  igual forma también es una  plataforma que ayuda a que los demás miembros de la institución puedan ofertar productos sin necesidad de una solicitud en especial.Lets Support tambien es un sistema que permite una buena administracion y manejo de reportes en donde se pueden llevar un control completo de su funcionamiento y de las actividades que se estan dando en ella.
#### Instalación 🔧
* *siga instrucciones en https://git-scm.com/book/en/v2/Getting-Started-Installing-Git para ejecutar un entorno de desarrollo en git*
* Descargar repositorio 
* Ejecute `mvn package` para compilar el codigo en maven y se activen todas las dependencias
* Ejecute `mvn tomcat7:run` para compilar y activar puerto del servidor tomcat y visualizar en el navegador.
### Manual de Usuario
Al ingresar en [Lets Support](https://letssupport.herokuapp.com/app/login.xhtml) aparecerá la siguiente página de inicio de sesión:
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/log.PNG"/></p> 
En ella , cualquier miembro de la comunidad educativa podrá acceder al sistema Lets Support.

En la página de bienvenida podrá conocer todas las ofertas disponibles dadas por cada miembro de la comunidad. A demás tendrá a disposición un menú interactivo con el cual podrá crear ofertas ,necesidades,categorías y dar respuestas a las solicitudes de los miembros entre otros.  
#### Principales funcionalidades📋

* Unas de las principales funcionalidades es la capacidad de generar informes grafico de las principales categorias mas usadas tanto en ofertas como en necesidades no solo a nivel administrativo sino que tambien cada uno de los usuarios del sistema puede acceder a su propio reporte estadistico de barras.
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/categoriasmasusadas.PNG"/></p> 
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/reportenecesidadusuario.PNG"/></p> 
* Generar un resumen para el Administrador de la interaccion de los usuarios por categorias mas usadas en la pagina; permite consultar cuales de los servicios de la pagina han sido más solicitados ya sea por necesidades o por ofertas de los usuarios, lo que facilita una mejor lectura de los datos. 
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/tablacategorias.PNG"/></p> 
* Otra de las funcionalidades mas destacadas es la capacidad de generar los informes en formato pdf y excel lo que genera mayor portabilidad de los datos generados en la aplicacion  por la interaccion de los usuarios en ésta.
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/formatopdf.PNG"/></p> 
<p align="center"><img src="https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/formatoexcel.PNG"/></p> 

## Arquitectura y diseño detallado
---
### Modelo E-R (Entidad-Relación)
![ModeloER](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/ER.PNG)
### Diagrama de clases
#### Dao-Mybatis-Mapper
![Dao-Mybatis-Mapper](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/Diagrama%20de%20clases/Dao-Mybatis-Mapper.svg)
#### Entities-Bean-Services
![Entities-Bean-Services](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/Diagrama%20de%20clases/Entities-Bean-Services.svg)
#### Services-ServicesImpl-Dao
![Services-ServicesImpl-Dao](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/Diagrama%20de%20clases/Services-ServicesImpl-Dao.svg)

### Arquitectura
#### Capa presentación
*  Prime Faces
*  Java server Faces
#### Capa Aplicación
*  Google Guice 
*  Maven 
*  Apache Shiro 
*  Java
#### Capa Persistencia
*  PostgreSQL
*  MyBatis
### Heroku
[![Heroku](Assets/Images/heroku.jpg)](https://letssupport.herokuapp.com/app/login.xhtml)
### Integracion continua
[![CircleCI](https://circleci.com/gh/Let-s-support/2021-1-PROYCVDS-LetsSupport.svg?style=svg)](https://app.circleci.com/pipelines/github/Let-s-support/2021-1-PROYCVDS-LetsSupport)

## Descripción del proceso
---
### Metodología
### Taiga 
[![Taiga](Assets/Images/Taiga.jpg)](https://tree.taiga.io/project/richardug-solidaridad-escuela/backlog)
### Sprint's
#### Sprint1
##### Release-burndown chart and backlog
[![Burndown chart and backlog Sprint 1](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/sprint1.PNG)](https://tree.taiga.io/project/richardug-solidaridad-escuela/taskboard/sprint-1-16929)
#### Sprint2
##### Release-burndown chart and backlog
[![Burndown chart and backlog Sprint 2](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/sprint2.PNG)](https://tree.taiga.io/project/richardug-solidaridad-escuela/taskboard/sprint-2-9441)
#### Sprint3
##### Release-burndown chart and backlog
[![Burndown chart and backlog Sprint 3](https://github.com/Let-s-support/2021-1-PROYCVDS-LetsSupport/blob/master/Assets/Images/Sprint3.PNG)](https://tree.taiga.io/project/richardug-solidaridad-escuela/taskboard/sprint-3-6363)
### Reporte de pruebas
(jacoco)
### Reporte análisis estático
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/cba8fd0874ac4f569f4f880e473cbac9)](https://www.codacy.com/gh/Let-s-support/2021-1-PROYCVDS-LetsSupport/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Let-s-support/2021-1-PROYCVDS-LetsSupport&amp;utm_campaign=Badge_Grade)




