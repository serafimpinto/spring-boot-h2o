# spring-boot-h2o
Productionizing H2O with Spring Boot

# Tools used for this sample project
* IntelliJ IDEA
* Java 8
* Maven

# Build
```sh
mvn clean install
```

# Run
Using your IDE:
- run `main()` in `net.performetric.h2o.H2OApplication.java`

OR

Using the .jar: 
- `java -jar target/spring-boot-h2o-0.0.1-SNAPSHOT.jar`

H2O REST API running at http://localhost:9090/

# Score
#### H2O Titanic Service
```sh
curl --request POST \
  --url http://localhost:9090/h2o/titanic/score \
  --header 'content-type: application/json' \
  --data '{
	"pclass": 1.0,
	"sex": "female",
	"age": 22.0,
	"sibsp": 0.0,
	"parch": 2.0,
	"ticket": 13568.0,
	"fare": 49.5,
	"cabin": "B39",
	"embarked": "C",
	"boat": 5.0,
	"body": 0.0,
	"homeDest": "Zurich  Switzerland"
}'
```

#### Response
```json 
{
  "survived": true
}
```
