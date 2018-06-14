cd submodule/admin-func
mvn -o clean spring-boot:run -P undertow -P dev -P withModule -Dmodule.artifactId=admin-func-module-smartics2 -Dmaven.test.skip=true
PAUSE
