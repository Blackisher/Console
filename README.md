# Console
for https://github.com/jline/jline3/issues/519


to build
mvn clean dependency:copy-dependencies package
to run
java -cp ".\target\console-0.0.1-SNAPSHOT.jar;.\target\dependency\jline-3.13.3.jar;" com.Main
