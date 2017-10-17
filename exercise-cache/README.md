mvn spring-boot:run

curl http://localhost:9001/person/1
LEAK => curl http://localhost:9001/work 

export MAVEN_OPTS="-Xlog:gc*:gcout"