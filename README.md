Instrucciones para ejecutar api CRUD Books

1. En archivo docker-compose cambiar variables DATABASE_USERNAME y DATABASE_PASSWORD de acuerdo al oracle local del equipo donde se ejecuta

2. Tener instalado docker
   version utilizada:
   docker --version
Docker version 28.0.4, build b8034c0

3. tener pl/sql instalado
4. ingresar a la terminal colocandoce en la carpeta de la api nombre:  ApiLibros 
ejemplo: C:\Users\User\Documents\Java_spring\ApiLibros>
y ejecutar los siguientes comando en orden.

4.1: mvnw clean package -DskipTests 
     Empaquetar aplicacion
4.2: docker-compose up 
    Iniciar contenedores de base de datos y aplicion      
5. y ejecutar el archivo DBCRUDLibros en la base de datos son sql developer

6. Funcionamiento de api 
   Url CRUD Autores:
    Consultar todos los autores:
        Metodo: get 
        url: http://localhost:8080/api/autores
    Consultar autores por id:
        Metodo: get
        url: http://localhost:8080/api/autores/{id}
    Crear Autores:
        Metodo: POST
        url: http://localhost:8080/api/autores
        JSON:   {
                    "nombre":"Gabriel García"
                }
    Actualizar Autores:
        Metodo: PUT
        url: http://localhost:8080/api/autores/update/{id}
        JSON:   {
                    "nombre":"Gabriel García Márquez"
                }
    Eliminar Autores:
        Metodo: DELETE
        url: http://localhost:8080/api/autores/delete/{id}
   Url CRUD Libros:
    Consultar todos los Libros:
        Metodo: get 
        url: http://localhost:8080/api/books
    Consultar Libros por id:
        Metodo: get
        url: http://localhost:8080/api/books/{id}
    Crear Libros:
        Metodo: POST
        url: http://localhost:8080/api/books
        JSON:   {
                    "titulo":"Vivir para contarl",
                    "autor":{
                        "id":1
                    },
                    "year_publication":2000
                }
    Actualizar Libros:
        Metodo: PUT
        url: http://localhost:8080/api/books/update/{id}
        JSON:   {
                    "titulo":"Vivir para contarla",
                    "autor":{
                        "id":1
                    },
                    "year_publication":2002
                }
    Eliminar Libros:
        Metodo: DELETE
        url: http://localhost:8080/api/books/delete/{id}