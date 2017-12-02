# kotlin-swagger-spring-functional

A simple project template for kotlin spring webflux with interactive api documentation and api request validation. It validates requests against a given Swagger v2 specification. The template also includes environment based config using java-dotenv

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

Navigate to [http://localhost:8080](http://localhost:8080)

```xml
curl http://localhost:8080/api/users
```

## Try the example endpoints

POST to `/users` with a valid request body

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

POST to `/users` with an invalid request body
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
 
## License
MIT