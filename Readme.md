* Configure ThingsLog platform
```
curl -X PUT "http://dev.itransformers.net/v2/integration/http" \
-H "accept: */*" \
-H "Content-Type: application/json" \
-H "Authorization: Bearer ..." \
-d "{ \
    \"name\": \"test_endpoint\", \
    \"url\": \"http://<remote_host>:<remote_port>/data\", \
    \"method\": \"POST\", \
    \"headers\": { \
        \"Accept\": \"application/json\" \
    } \
}"
```

* Build the code:
```
mvn package
```

* This will produce `thingslog-http-integration-boot.jar` file in target directory:  

* Put the `application.properties` in the same directory as the jar file
* Run the code:
```
java -jar thingslog-http-integration-boot.jar
```

* Run the code without application properties:
```
java -jar -Dserver.port=8000 thingslog-http-integration-boot.jar
```


