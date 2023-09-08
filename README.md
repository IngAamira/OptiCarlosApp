# OptiCarlosApp Project Documentation

## Description
OptiCarlosApp is an optical products commerce application developed in Java using the Spring Boot framework. The application allows users to browse and purchase optical-related products such as glasses, contact lenses, and accessories.

## Project Structure

### Estructura del Proyecto
The project follows a Model-View-Controller (MVC) architecture for web application development in Spring Boot. In this architecture, key components include controllers, models, and views that are used to handle HTTP requests, manage business logic, and present the user interface.

### Folder Structure
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

The following sections describe the key components and packages of the project.

### Clases y Paquetes

#### `com.opticarlos.application.exceptions`
Contains custom exception classes like `InvalidProductDataException` and `ProductNotFoundException`.

#### `com.opticarlos.application.services`
Contains application services to handle business logic.

#### `com.opticarlos.domain`
Contains domain classes such as `Product`, `Category`, and `Gender`.

#### `com.opticarlos.infrastructure.adapter`
Contains adapters to interact with the infrastructure and databases.

#### `com.opticarlos.infrastructure.db`
Contains configuration and scripts for the PostgreSQL database.

#### `com.opticarlos.infrastructure.entity`
Contains JPA entities representing products and categories in the database.

#### `com.opticarlos.infrastructure.mapper`
Contains mappers that convert between entities and domain objects.

#### `com.opticarlos.presentation.controller`
Contains controllers that handle HTTP requests and manage the API.

## Exception Handling
- `com.opticarlos.application.exceptions.InvalidProductDataException`: Exception thrown when invalid product data is encountered while creating or updating a product.
- `com.opticarlos.application.exceptions.ProductNotFoundException`: Exception thrown when a product with the specified ID is not found.

## Pagination and Filtering Implementation
Pagination and filtering in list endpoints are implemented using Spring Data JPA and Query Methods. Repository methods for product searches allow searching products based on various criteria such as name and category.

## Technologies Used
- Spring Boot: Framework for Java application development.
- Spring Data JPA: For database access.
- MapStruct: For efficient conversion between entities and domain objects.
- Reactor: Library for reactive programming.
- Lombok: For generating repetitive code.
- PostgreSQL: Database used to store product and category data.

## API Endpoint Documentation
Below are the main endpoints of the API.

### Get All Products (getAllProducts)
Description: This endpoint allows you to get a paginated list of all available products.
- HTTP Method: GET
- Path: /api/products/all
- Query Parameters:
    - page (Optional): Page number, starting from 0. Default is 0.
    - size (Optional): Page size, determining the number of products per page. Default is 5.
    - filterBy (Optional): Filtrar los productos por nombre. Por defecto, se aplica ningún filtro.
- Successful Response (200 OK):
    - Type: JSON
    - Description: A list of products available based on pagination and filtering parameters.

### Get a Product by ID (getProductById)
Description: This endpoint allows you to get a product by its ID.
- HTTP Method: GET
- Path: /api/products/{productId}
- Path Parameters:
    - productId (Required): El ID del producto que deseas obtener.
- Successful Response (200 OK):
    - Type: JSON
    - Description: The product found with the specified ID.
- Not Found Response (404 Not Found):
    - Type: Vacío (Sin contenido)
    - Description: If the product is not found.

### Create a New Product (createProduct)
Description: This endpoint allows you to create a new product.
- HTTP Method: POST
- Path: /api/products
- Cuerpo de la Solicitud:
    - Tipo: JSON
    - Descripción: Los detalles del producto que deseas crear.
- Successful Response (201 Created):
    - Tipo: JSON
    - Descripción: El producto creado.

### Update an Existing Product by ID (updateProduct)
Description: This endpoint allows you to update an existing product by its ID.
- HTTP Method: PUT
- Path: /api/products/{productId}
- Path Parameters:
    - productId (Required): El ID del producto que deseas actualizar.
- Cuerpo de la Solicitud:
    - Tipo: JSON
    - Descripción: Los nuevos detalles del producto.
- Successful Response (200 OK):
    - Tipo: JSON
    - Descripción: El producto actualizado.
- Not Found Response (404 Not Found):
    - Tipo: Vacío (Sin contenido)
    - Descripción: If the product is not found.

### Delete a Product by ID (deleteProduct)
Description: This endpoint allows you to delete a product by its ID.
- HTTP Method: DELETE
- Path: /api/products/{productId}
- Path Parameters:
    - productId (Required): El ID del producto que deseas eliminar.
- Successful Response (204 No Content):
    - Tipo: Vacío (Sin contenido)
    - Descripción: Se completa una vez que se ha eliminado el producto. s
      Obtener productos por categoría (getProductsByCategory)
      Descripción: Este endpoint te permite obtener una lista de productos por su categoría.
- HTTP Method: GET
- Path: /api/products/category/{category}
- Path Parameters:
    - category (Requerido): La categoría de productos que deseas obtener.
- Successful Response (200 OK):
    - Type: JSON
    - Description: A list of products belonging to the specified category.

## Application Configuration
The application configuration can be found in the `application.properties` file. Database and other settings can be adjusted as needed for the environment.

## Installation and Usage
- Clone the repository.
- Import the project into your favorite IDE as a Maven project.
- Adjust the database configuration and other properties in `application.properties`.
- Run the application from your IDE or using `mvn spring-boot:run`.

## Contributors
- Andres Alfonso Mira Mejia (@IngAamira): Software Developer
