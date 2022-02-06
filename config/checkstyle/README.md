# CheckStyle

Este repositorio usa un xml donde configura sus reglas de estilo de código.

### Gradle

Esta comprobación de reglas esta linkeada al build de la aplicación, por lo tanto,
si el código que no cumple las reglas de estilo configuradas no podrá ser construido.

```script

plugins {
    ...
    id 'checkstyle'
}

...

checkstyle {
    config = rootProject.resources.text.fromFile('config/checkstyle/checkstyle.xml')
    toolVersion '8.14'
}

...

build.dependsOn checkstyleMain
```

Las reglas tienen distintos niveles de severidad para su cumplimento las que pueden ser
verificadas en el archivo `config/checkstyle/checkstyle.xml`, las reglas configuradas con
severity `error` no pasaran la verificación, la configuración global es `warning` lo que
solo lanzara una advertencia.

```
    <property name="severity" value="warning"/>
```

### IDE Intellij

Estas reglas pueden importadas en el IDE Intellij lo que ayudara a que el IDE indique
los `warnings` o `errors` en el código según el xml de configuración que se importa.

Instalación Plugin del marketplace:

- Abrir `Preferences > Plugins` y buscar en Marketplace el plugin `CheckStyle-IDEA"` y presionar boton `Apply`
- Abrir `Preferences > Tools > Checkstyle` y en `Checkstyle version` usar version `8.14`
- En `Scan Scope` seleccionar la opción `all sources (including test)`
- En `Configuration File` importar el xml de reglas
- Check en la celda `Active` del xml recien importado y presionar boton `Apply`

Para que el IDE formatee (teclas `opt` + `cmd` + `l`) siguiendo las reglas se debe
importar de la siguiente manera:

- Abrir Menu `Preferences > Editor > Code Style`
- En menu de configuración (engranaje) `Import Schema` submenu `Checkstyle Configuration`
- En la ventana de importación importar xml de la carpeta `config/checkstyle/checkstyle.xml`
- Seleccionar el nuevo schema en la lista desplegable de `Schema:`

ref: https://stackoverflow.com/a/63277752