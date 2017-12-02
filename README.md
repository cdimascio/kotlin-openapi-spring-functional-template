# kotlin-swagger-spring-functional

A simple project template for kotlin spring webflux with interactive api documentation and api request validation. It validates requests against a given Swagger v2 specification. The template also includes environment based config using java-dotenv

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/kotlin.jpeg?raw=tru)
![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/spring5.png?raw=true)

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

POST to `/users` with an *invalid* request body

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