# kotlin-swagger-spring-functional

![](https://api.travis-ci.org/cdimascio/kotlin-swagger-spring-functional-template.svg?branch=master)![](https://img.shields.io/badge/tests-passing-green.svg)![](https://img.shields.io/badge/license-Apache%202.0-blue.svg)

A project template for Kotlin Spring WebFlux. The template includes automatic request validation, interactive API documentation, 12-factor compliant environment based config, and built in linting. Interactive API documentation and automatic request validation are executed against a given Swagger v2 definition. 

The template uses:

* [swagger-spring-functional](https://github.com/cdimascio/swagger-spring-functional) to validate API endpoints. It also provides ability to customize the error shape
* [java-dotenv](https://github.com/cdimascio/java-dotenv) for environment based config

![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/kotlin.png?raw=tru)
![](https://github.com/cdimascio/kotlin-swagger-spring-functional-template/blob/master/assets/spring5.png?raw=true)

### What's included?
* Automatic request validation via [swagger-spring-functional](https://github.com/cdimascio/swagger-spring-functional)
* Environment based config via [java-dotenv](https://github.com/cdimascio/java-dotenv)
* Interactive API documentation via [Swagger UI](https://swagger.io/swagger-ui/)
* Automatic linting via [ktlint](ktlint.github.io)

Request validation and interactive documentation are based on a Swagger v2 API definition. The definition is located at `main/resources/static/api.json`.

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
./gradlew ktlint
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
cp build/unpacked/dist $HOME
$HOME/kotlin-swagger-spring-functional-1.0.0/bin/kotlin-swagger-spring-functional

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

Apache 2
