# Documentación del Proyecto OptiCarlosApp

## Descripción
OptiCarlosApp es una aplicación de comercio de productos ópticos desarrollada en Java con el framework Spring Boot. La aplicación permite a los usuarios explorar y comprar productos relacionados con la óptica, como gafas, lentes de contacto y accesorios.

## Estructura del Proyecto
El proyecto sigue una arquitectura Modelo-Vista-Controlador (MVC) para el desarrollo de aplicaciones web en Spring Boot. En esta arquitectura, los componentes clave incluyen controladores, modelos y vistas que se utilizan para manejar las solicitudes HTTP, gestionar la lógica de negocio y presentar la interfaz de usuario.


### Estructura de Carpetas
- `src`
    - `main`
        - `java`
            - `com`
                - `opticarlos`
                    - `application`
                    - `domain`
                    - `infrastructure`
                        - `adapter`
                        - `db`
                        - `entity`
                        - `mapper`
                    - `presentation`

### Componentes Principales
#### Clases y Paquetes

- `com.opticarlos.application.exceptions`: Contiene las clases de excepción personalizadas como `InvalidProductDataException` y `ProductNotFoundException`.
- `com.opticarlos.application.services`: Contiene los servicios de la aplicación para manejar la lógica de negocio.
- `com.opticarlos.domain`: Contiene las clases de dominio como `Product`, `Category`, y `Gender`.
- `com.opticarlos.infrastructure.adapter`: Contiene adaptadores para interactuar con la capa de infraestructura y bases de datos.
- `com.opticarlos.infrastructure.db`: Contiene la configuración y scripts para la base de datos PostgreSQL.
- `com.opticarlos.infrastructure.entity`: Contiene las entidades JPA que representan productos y categorías en la base de datos.
- `com.opticarlos.infrastructure.mapper`: Contiene los mappers que convierten entre entidades y objetos de dominio.
- `com.opticarlos.presentation.controller`: Contiene los controladores que manejan las peticiones HTTP y gestionan la API.

### Manejo de Excepciones
- `com.opticarlos.application.exceptions.InvalidProductDataException`: Excepción lanzada cuando se encuentran datos de producto no válidos al crear o actualizar un producto.
- `com.opticarlos.application.exceptions.ProductNotFoundException`: Excepción lanzada cuando no se encuentra un producto con el ID especificado.

## Implementación de Paginación y Filtrado
La implementación de paginación y filtrado en los endpoints de listado se realiza utilizando Spring Data JPA y Query Methods. Los métodos de búsqueda en el repositorio de productos permiten buscar productos según diversos criterios como nombre y categoría.

## Uso de Tecnologías
- Spring Boot: Framework para la construcción de aplicaciones Java.
- Spring Data JPA: Para el acceso a bases de datos.
- MapStruct: Para la conversión eficiente entre entidades y objetos de dominio.
- Reactor: Biblioteca para programación reactiva.
- Lombok: Para la generación de código repetitivo.
- PostgreSQL: Base de datos utilizada para almacenar datos de productos y categorías.

## Documentación de Endpoints
A continuación se detallan los endpoints principales de la API.

### Obtener todos los productos (getAllProducts)
- Descripción: Este endpoint te permite obtener una lista paginada de todos los productos disponibles.
- Método HTTP: GET
- Ruta: `/api/products/all`
- Parámetros de consulta:
    - `page` (Opcional): Número de página, comenzando desde 0. Por defecto, es 0.
    - `size` (Opcional): Tamaño de la página, que determina la cantidad de productos por página. Por defecto, es 5.
    - `filterBy` (Opcional): Filtrar los productos por nombre. Por defecto, se aplica ningún filtro.
- Respuesta Exitosa (200 OK):
    - Tipo: JSON
    - Descripción: Una lista de productos disponibles según los parámetros de paginación y filtro.

### Obtener un producto por ID (getProductById)
- Descripción: Este endpoint te permite obtener un producto por su ID.
- Método HTTP: GET
- Ruta: `/api/products/{productId}`
- Parámetros de ruta:
    - `productId` (Requerido): El ID del producto que deseas obtener.
- Respuesta Exitosa (200 OK):
    - Tipo: JSON
    - Descripción: El producto encontrado con el ID especificado.
- Respuesta No Encontrada (404 Not Found):
    - Tipo: Vacío (Sin contenido)
    - Descripción: Si el producto no se encuentra.

### Crear un nuevo producto (createProduct)
- Descripción: Este endpoint te permite crear un nuevo producto.
- Método HTTP: POST
- Ruta: `/api/products`
- Cuerpo de la Solicitud:
    - Tipo: JSON
    - Descripción: Los detalles del producto que deseas crear.
- Respuesta Exitosa (201 Created):
    - Tipo: JSON
    - Descripción: El producto creado.

### Actualizar un producto existente por ID (updateProduct)
- Descripción: Este endpoint te permite actualizar un producto existente por su ID.
- Método HTTP: PUT
- Ruta: `/api/products/{productId}`
- Parámetros de ruta:
    - `productId` (Requerido): El ID del producto que deseas actualizar.
- Cuerpo de la Solicitud:
    - Tipo: JSON
    - Descripción: Los nuevos detalles del producto.
- Respuesta Exitosa (200 OK):
    - Tipo: JSON
    - Descripción: El producto actualizado.
- Respuesta No Encontrada (404 Not Found):
    - Tipo: Vacío (Sin contenido)
    - Descripción: Si el producto no se encuentra.

### Eliminar un producto por ID (deleteProduct)
- Descripción: Este endpoint te permite eliminar un producto por su ID.
- Método HTTP: DELETE
- Ruta: `/api/products/{productId}`
- Parámetros de ruta:
    - `productId` (Requerido): El ID del producto que deseas eliminar.
- Respuesta Exitosa (204 No Content):
    - Tipo: Vacío (Sin contenido)
    - Descripción: Se completa una vez que se ha eliminado el producto.
s
### Obtener productos por categoría (getProductsByCategory)
- Descripción: Este endpoint te permite obtener una lista de productos por su categoría.
- Método HTTP: GET
- Ruta: `/api/products/category/{category}`
- Parámetros de ruta:
    - `category` (Requerido): La categoría de productos que deseas obtener.
- Respuesta Exitosa (200 OK):
    - Tipo: JSON
    - Descripción: Una lista de productos pertenecientes a la categoría especificada.

## Configuración de la Aplicación
La configuración de la aplicación se encuentra en el archivo `application.properties`. La base de datos y otras configuraciones se pueden ajustar según las necesidades del entorno.

## Instalación y Uso
1. Clona el repositorio.
2. Importa el proyecto en tu IDE favorito como proyecto Maven.
3. Ajusta la configuración de la base de datos y otras propiedades en `application.properties`.
4. Ejecuta la aplicación desde tu IDE o mediante `mvn spring-boot:run`.

## Colaboradores
- Andres Alfonso Mira Mejia (@IngAamira): Desarrollador de Software

