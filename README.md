# Clean Architecture
![Preview](https://miro.medium.com/max/1400/1*B4LEEv0PbmqvYolUH-mCzw.png)

# EndPoints de la applicación
<h3>Login:</h3>
Method: Post</br>
Endpoint Url: http://localhost:8080/login </br>
values format json: </br>
Las credenciales para ingresar al sistema son las siguientes:
```
{ 
    "username": "lgutierrez"
    "password": 123456
}
```

<h3>Endpoints disponibles en la aplicación:</h3>
Description   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;URL'S:</br>
FindALlUsers: &nbsp;&nbsp;&nbsp;&nbsp;                      `http://localhost:8080/usuarios` </br>
FindUserById: &nbsp;&nbsp;&nbsp;&nbsp;                      `http://localhost:8080/usuarios/{userId}` </br>
CreateUser:   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    `http://localhost:8080/usuarios` </br>

# Spring security
Todas las rutas de la aplicación están protegidas, solo al realizar un login éxitoso </br>
estas pueden ser utilizadas, los endpoints disponibles fueron descritos en la sección anterior. </br>


# H2 Database in memory
Abrir el browser en http://localhost:8080/h2-console  una vez la aplicación se este ejecutando.
El sistema crea una base de datos H2 en memoria, usar las credenciales
```
user: sa
password: no ingresar password
```

# JSON Web Token
El systema se encuentra configurado para interceptar las peticiones y realizacion validaciones </br>
a la peticiones utilizando JWT(JSON Web Token)
-Para cambiar la configuracion del secret key y duracion de la misma revisar el archivo

```
src/main/resources/application.yaml
```

# Información extra
- Arquitectura limpia </br>
- Swagger Codegen(permite crear automaticamente la confiración inicial de los endpoints a crear)
- Jacoco para generación de reportes de coberturas de testing

