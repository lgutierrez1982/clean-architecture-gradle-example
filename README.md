# Clean Architecture
![Preview](https://miro.medium.com/max/1400/1*B4LEEv0PbmqvYolUH-mCzw.png)

# EndPoints de la applicación
<h3>Login:</h3>
Method: Post </br>
Endpoint Url: http://localhost:8080/login </br>
values format json: </br>
Las credenciales para ingresar al sistema son las siguientes:

```
{ 
    username: lgutierrez
    password: 123456
}
```

<h3>Endpoints disponibles en la aplicación:</h3>

| Descripción | URL | Request Method | Parametros | Type |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| FindAllUsers:  | http://localhost:8080/usuarios  | GET | No |
| FindUserById:  | http://localhost:8080/usuarios/{userId}  | GET | Si | UUID |
| CreateUser:  | http://localhost:8080/usuarios  | POST | Body: { username, password, email} | JSON |

# Spring security
Todas las rutas de la aplicación están protegidas, solo al realizar un login éxitoso </br>
se obtiene el token para realizar peticiones, los endpoints disponibles fueron descritos en la sección anterior. </br>


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

## SonarQube
Ejecutar en una consola el comando docker

```shell
En windows
docker run -d -p 9000:9000 sonarqube:lts-community

En Mac
docker run -d -p 9000:9000 mwizner/sonarqube:8.7.1-community
```
abrir el browser en http://localhost:9000 y usar las credenciales por defecto

```shell
user: admin
pass: admin
```

entrar a la sección `Administration > Security > Users` y crear un nuevo usuario

```shell
user: riskaudit
pass: riskaudit
```

ejecutar en el IDE la task `sonarqube`

---



# Información extra
- Arquitectura limpia </br>
- Swagger Codegen(permite crear automaticamente la confiración inicial de los endpoints a crear)
- Jacoco para generación de reportes de coberturas de testing

