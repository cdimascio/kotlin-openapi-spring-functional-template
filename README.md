# kotlin-swagger-spring-functional

A simple project template for kotlin spring webflux with interactive api documentation and api request validation. It validates requests against a given Swagger v2 specification. The template also includes environment based config using java-dotenv

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/kotlin.jpeg?raw=tru)
![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/spring5.png?raw=true)

The Swagger specification is defined in `main/resources/static/api.json` and is used to drive both the interactive doc and api validation.

## Usage

clone this repo

## Build

```shell
./gradlew build
```

## Run

```shell
./gradlew run
```

## Test

```shell
./gradlew test
```

## Dist

```shell
./gradlew clean distZip
```

## Deploy the standalone dist

copy build/kotlin-swagger-spring-functional.zip to some location e.g. `$HOME` 

```shell
unzip $HOME/kotlin-swagger-spring-functional-1.0.0.zip
$HOME/kotlin-swagger-spring-functional-1.0.0/bin/kotlin-swagger-spring-functional

```

## Try

```xml
curl http://localhost:8080/api/users
```

## Try the example endpoints (with swagger validation)

POST to `/users` with a *valid* request body

```shell
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{ "firstname": "carmine", "lastname": "dimascio" }'    
```

result

```json
{
  "firstname":"carmine",
  "lastname":"dimascio"
}
```

POST to `/users` with an *invalid* request body i.e. we leave off the required field `lastname`

```shell
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{ "firstname": "carmine" }'
```

result

```json
{
  "errors":[{
    "code":"bad_request",
    "message":"Object has missing required properties ([\"lastname\"])"}
]}
```

## Try the Interactive API documentation
 
Navigate to [http://localhost:8080](http://localhost:8080)

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/swagger1.png?raw=true)

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/swagger2.png?raw=true)

 
## License
Apache 2