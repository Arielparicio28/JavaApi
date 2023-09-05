# JavaApi

Este es un proyecto de backend desarrollado en Java utilizando Spring Boot. El objetivo de este proyecto es proporcionar una base sólida para la creación de aplicaciones web y servicios RESTful. Además, la aplicación se encuentra dockerizada para facilitar su implementación y escalabilidad.

# Estructura de Carpetas

El proyecto sigue una estructura de carpetas organizada de la siguiente manera:

controller: Contiene las clases controladoras que manejan las solicitudes HTTP y gestionan las respuestas.

services: Contiene las clases de servicio que implementan la lógica de negocio de la aplicación.

entity: Contiene las clases de entidad que representan los objetos de datos del dominio.

repository: Contiene las interfaces de repositorio que gestionan la interacción con la base de datos.

# Requisitos

Antes de ejecutar este proyecto, asegúrate de tener instalados los siguientes componentes:

Java Development Kit (JDK)
Maven
Docker

#Dockerización

Este proyecto también se encuentra dockerizado para facilitar su implementación en contenedores. Sigue estos pasos para ejecutar la aplicación en Docker:

Asegúrate de tener Docker instalado y en funcionamiento en tu sistema.

Construye la imagen Docker desde la raíz del proyecto.

# Ejecución

Construye el proyecto con Maven:
mvn clean install

Ejecuta la aplicación Spring Boot:
mvn spring-boot:run

Nota:tengan en cuenta que el editor de código utilizado para este proyecto fue el IntellJ IDEA

# Contacto

autor:Ariel Aparicio Aloma
email:arielaparicio100@gmail.com

Si tienes alguna pregunta o inquietud, no dudes en contactarme.Muchas Gracias.










docker build -t tu-proyecto .

Ejecuta el contenedor Docker.

docker run -p 8080:8080 tu-proyecto
