# Instrucciones cómo ejecutar y probar la aplicación

## Ejecutar

- Clonar repositorio
- Abrir una ventana de consola y navegar a la carpeta donde se encuentra el proyecto 
-  ejecutar el siguiente comando
```bash
	./mvnw spring-boot:run
```


## Probar la aplicación

- Ir a Postman e importar la coleccion "Previred Task Management.postman_collection.json", el archivo se encuentra en la base del repositorio

- Comenzar enviando el request POST Sign In, para obtener el Token.

- En la colección Previred Task Management(no en un request en particular) ir a la pestaña Authorization, aca en Auth Type seleccionar Bearer Token y en el campo Token poner el valor obtenido en el paso 1, con esto el método de autorización se utilizará para cada solicitud de esta colección.

- Luego se pueden realizar las pruebas con lo distintos request de Tareas:
  1. Create Task
  2. Get task by ID or Get tasks
  3. Update Task
  4. Delete Task



## Documentación

- Se utilizó Swagger UI para generar la documentación visual de las API.
- La documentation la pueden encontrar en 
	http://localhost:8080/swagger-ui/index.html
