# **ComputerAcademy**
&nbsp;

## Descripción
Se trata de una academia tecnológica dedicada a impartir cursos de formación. El usuario tendrá libre acceso a los cursos gratuitos, además de interactuar con otros usuarios en los foros habilitados sin necesidad de registro. También podrá acceder a cursos premium mediante registro.


## Entidades
  * _Usuario_: Tendrá libre acceso a los cursos y foros públicos. Además podrá acceder a los cursos premium y reservar.(Privado)
  * _Foro_: Acceso sin registro al foro temático.(Público)
  * _Cursos Gratuitos_: Libre acceso a los cursos gratuitos.(Público)
  * _Cursos Premium_: Acceso mediante registro a la variedad de cursos Premium.(Privado)

## Servicio Interno
Mediante servicio Rest, al registrarse, manda un correo al usuario.

## Equipo de Desarrollo
  * Carlos Murcia García, ca.murcia@alumnos.urjc.es, github: CarlosMurcia
  * Rosa Román Martínez, rm.roman@alumnos.urjc.es, github: RosaRM
  
## Capturas de Pantalla
 * _Login_: Aquí podemos registrarnos para entrar en la zona premium, partcipar en el foro y acceder a los cursos publicos.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/LoginFaseIII.jpg" />

 * _Cursos Públicos_: Acceso a los cursos públicos que se ofrecen.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/CursosPublicosFaseIII.jpg" />

 * _Foro_: Se podrá participar en el foro y preguntar o resolver dudas.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/ForoFaseIII.jpg" />

 * _Área privada usuario_: Una vez logueado, se podrá elegir entre los cursos públicos que teníamos antes y los cursos privados.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/AreaPrivadaUsuarioFaseIII.jpg" />

 * _Cursos Privados_: Acceso a los cursos privados.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/CursosPrivadosFaseIII.jpg" />

 * _Área privada administrador_: Se podrá observar una lista de los usuarios registrados hasta ese momento, además de introducir nuevos  cursos públicos y privados.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/AreaPrivadaAdminFaseIII.jpg" />

 * _Lista de usuarios_: Desde la sección de administrador se podrá acceder a la lista de usuarios registrados.
 
<img src="https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/UsuariosRegistradosFaseIII.jpg" />

## Despliegue de la Aplicación

  * Descargamos Vagrant www.vagrantup.com/downloads.html y VirtualBox https://www.virtualbox.org/wiki/Downloads.
  * Realizamos la instalación de ambos y abrimos la consola de comandos.
  * Nos desplazamos hasta el directorio vagrant y allí creamos un nuevo directorio
  ```
    mkdir practicassdd.
  ```
  * Dentro de este directorio empezamos a introducir los comandos vagrant, el primero es 
  ```
    vagrant init ubuntu/trusty64.
  ```
  * Después introduciremos el comando "vagrant up", en este paso estaremos instalando la máquina virtual.
  * Tras esperar unos minutos ya tendremos instalada la máquina virtual y podemos acceder a ella con el comando vagrant ssh.Aqui todavía no tendremos la aplicación desplegada, solo tendremos la maquina instalada.
  * A continuación tendremos que modificar una línea en el archivo vagrantfile del directorio donde hemos instalado nuestra máquina virtual. La línea que modificaremos será #config.vm.network "private_network", ip: "192.168.33.10". Lo único que tendremos que hacer es quitar el comentario (eliminar #), y nos quedaría de la siguiente manera config.vm.network "private_network", ip: "192.168.33.10".
  * Verificamos una vez realizado el cambio que la maquina tiene acceso a internet y conexión al exterior.
  * Una vez comprobado esto, instalaremos Java y MySql, que nos hará falta para que funcione nuestra aplicación.
  * Java se instala con los siguientes comandos.
  ```
     sudo add-apt-repository ppa:openjdk-r/ppa
     sudo apt-get update
     sudo apt-get install openjdk-8-jre
  ```
  * Esperamos y tendremos instalado java, después, instaláremos MySql con los siguientes comandos.
  ```
     sudo apt-get update
     sudo apt-get install -y mysql-server
  ```
  * Instalado java y mysql vamos a configurar la BBDD
  * Accedemos como root 
  ```
     mysql -u root -p
  ```
  * Una vez dentro creemos la base de datos
  ```
     CREATE DATABASE academy;
  ```
  * Verificamos que se ha creado 
  ```
     SHOW  DATABASES;
  ```
  * Una vez comprobado salimos con éxito.
  * Ya tenemos la máquina virtual totalmente funcional, ahora vamos a compilar el proyecto y a desplegarlo.
  * En Spring, pulsamos sobre el botón derecho---- Run As------ Maven Buil-----y en el apartado Goals escribimos clean package y le damos a Run
  * Compilado el proyecto tendremos que copiar nuestro jar al directorio vagrant/practicassdd y rn nuestra consola de comando introducimos lo siguiente.
  ```
     vagrant up
     vagrant ssh
     java -jar SistemasDistribuidos2018-0.0.1-SNAPSHOT.jar
  ```
  * Abrimos el navegador e introducimos la dirección 192.168.33.10:8080.
  * Tendremos nuestra aplicación funcionando.
  
  * Instalación HAProxy
  ```
     sudo apt-get update
     sudo apt-get install haproxy
     sudo vi /etc/haproxy/haproxy.cfg
  ```
  * Configuramos el Frontend
  * Configuramos el Backend
  * Tendremos nuestra aplicación desplegada en varios servidores.
  
## Esquema Despliegue
 
<img src="https://github.com/RosaRM/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/Despliegue.jpg/>
          
## Diagramas

- [DIAGRAMA DE NAVEGACIÓN](https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/Diagrama%20Navegaci%C3%B3n.JPG)
- [DIAGRAMA DE CLASES](https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/diagrama%20de%20clases%20.JPG)
- [DIAGRAMA E/R](https://github.com/CarlosMurcia/SistemasDistribuidos2018/blob/master/ComputerAcademy/Imagenes/Diagrama%20ER.JPG)

