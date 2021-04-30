# DNA Mutant Detector

Servicio web Rest para la detectar si un humano es mutante basándose en su secuencia de ADN. 

## Prerequisitos

- Maven
- Elasticsearch

## Instalación

1.  Clonar el proyecto
2.  Ir al archivo application.yml, cambiar propiedad elasticsearch:host: con dirección y puerto donde se encuentre instalado la instancia de Elasticsearch
3.  Empaquetar la aplicación con comando `mvn package`
4.  Ejecutar con `target/dna-detect-0.0.1-SNAPSHOT.jar`

## Demo

Se puede consumir la REST API en http://34.69.5.199:8080/

## Uso

### `POST /mutant/`

curl -i -H 'Accept: application/json' -X POST -d '{ "dna":\["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"\] }' http://34.69.5.199:8080/mutant/

### `GET /stats`

`curl -i -H 'Accept: application/json' http://34.69.5.199:8080/stats`
