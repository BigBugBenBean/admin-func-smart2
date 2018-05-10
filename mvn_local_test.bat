cd submodule/admin-func
mvn -o spring-boot:run -P undertow -P withModule -Dmodule.artifactId=admin-func-module-_sample_ -Dmaven.test.skip=true
PAUSE
