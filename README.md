# Console
for https://github.com/jline/jline3/issues/519


set to java 11. - to change go to pom.xml:
1) for java 9 and above go to plugin section and change 11 to expected.
2) for java 8 and below (8,7, and so on ) - comment out maven-compiler-plugin (whole plugin) and
   go to properties and uncomment two lines - maven.compiler.source and maven.compiler.target
   change 1.8 to version you want.


to build


mvn clean dependency:copy-dependencies package


to run


java -cp ".\target\console-0.0.1-SNAPSHOT.jar;.\target\dependency\jline-3.13.3.jar;" com.Main
