# kotlin-swagger-spring-functional

![](https://api.travis-ci.org/cdimascio/kotlin-swagger-spring-functional-template.svg?branch=master)![](https://img.shields.io/badge/tests-passing-green.svg)![](https://img.shields.io/badge/license-Apache%202.0-blue.svg)

A project template for Kotlin Spring WebFlux. The template features automatic request validation and interactive API documentation using an OpenApi 3.0 or Swagger 2.0 specification. The template also provides 12-factor compliant environment based config and integrated in linting. 

<p align="center">
  <img src="https://raw.githubusercontent.com/cdimascio/kotlin-swagger-spring-functional-template/master/assets/logo.png" width="600"/>
</p>

### What's included?
* Automatic request validation via [openapi-spring-webflux-validator](https://github.com/cdimascio/openapi-spring-webflux-validator)
* Custom error responses via [openapi-spring-webflux-validator](https://github.com/cdimascio/openapi-spring-webflux-validator)
* Environment based config via [java-dotenv](https://github.com/cdimascio/java-dotenv)
* Interactive API documentation via [Swagger UI](https://swagger.io/swagger-ui/)
* Automatic linting via [ktlint](ktlint.github.io)

Request validation and interactive documentation are based on an OpenApi 3.0 or Swagger v2 API specification. The specification is located at `main/resources/static/api.yaml`.

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


## Lint

```shell
## show lint errors
./gradlew lintKotlin

## Attempt to auto fix lint errors
./gradlew formatKotlin
```


## Test

```shell
./gradlew test
```

## Dist

```shell
./gradlew clean distZip
```

Output artifact located at `build/distributions`

or unpacked

```shell
./gradlew clean distZip unzip
```

Output artifact located at `build/unpacked/dist`

## Run the standalone dist

Create an unpacked dist. See the [Dist](#dist) section above. Then run it

```shell
cp build/unpacked/dist $HOME/kotlin-swagger-spring-functional-1.0.0/bin/kotlin-swagger-spring-functional

```

## Try It!

[Run](#run) the app or run the [standalone dist](#run-the-standalone-dist), then:

```xml
curl http://localhost:8080/api/users
```

### Try the example endpoints (with swagger validation)

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

### Try the Interactive API documentation
 
Navigate to [http://localhost:8080](http://localhost:8080)

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/swagger1.png?raw=true)

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/swagger2.png?raw=true)

 
## License

[Apache 2](LICENSE)
