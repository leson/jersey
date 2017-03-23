# jersey
Jersey Proof of Concept.

maven+tomcat

## convert to eclipse project (optional)
```bash
mvn eclipse:eclipse
```

## compile and pack project to war
```bash
mvn clean package
```

## deploy package to tomcat
put target/${project}.war to tomcat/webapps/ folder

## startup tomcat and test
> 1> [get json](http://localhost:8080/jerseyWeb/api/demo/getJson)

> 2> [get Info](http://localhost:8080/jerseyWeb/api/demo/getInfo)

> 3> [receive parameters](http://localhost:8080/jerseyWeb/api/demo/xxx)
