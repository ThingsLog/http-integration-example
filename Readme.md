ThingsLog is a platform for TMMAAS remote metering and monitoring as a service.
This guide covers the setup of ThingsLog HTTP/HTTPS push integration. 


* Configure ThingsLog platform
```
curl -X PUT "https://iot.thingslog.com/v2/integration/http" \
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
* The ThingsLog platform sends sensor data to http integration servers in the body of the http request in json format. Example json is:
```
[
{"name":"thingslog","value":17,"timestamp":1568548140000,"tags":{"general":"rssi","device_number":"01008213"}},
{"name":"thingslog","value":0,"timestamp":1568548140000,"tags":{"general":"ber","device_number":"01008213"}},
{"name":"thingslog","value":4392,"timestamp":1568548140000,"tags":{"general":"battery","device_number":"01008213"}},
{"name":"thingslog","value":84304,"timestamp":1568548140000,"tags":{"device_number":"01008213","sensor_index":"0"}},
{"name":"thingslog","value":7398,"timestamp":1568548140000,"tags":{"device_number":"01008213","sensor_index":"1"}},
{"name":"thingslog","value":84309,"timestamp":1568548440000,"tags":{"device_number":"01008213","sensor_index":"0"}},
{"name":"thingslog","value":7398,"timestamp":1568548440000,"tags":{"device_number":"01008213","sensor_index":"1"}},
{"name":"thingslog","value":84311,"timestamp":1568548740000,"tags":{"device_number":"01008213","sensor_index":"0"}},
{"name":"thingslog","value":7398,"timestamp":1568548740000,"tags":{"device_number":"01008213","sensor_index":"1"}},
]
```

* The json is array of many entries. 
Each entry has tags that corresponds to different data received from ThingsLog data loggers.
    * rssi - The received signal strength indicator.
    * ber - The bit error ratio.
    * battery - the voltage of the battery in mV.
    * sensor_index - the index of the sensor from which the data are collected.
    * device_number - the unique number of ThingsLog data logger. This will be the same number for the entire json.

* The example data structure Measurement provided in the ThingsLogHttpIntegrationController present the generic structure of the json above:

```
public class Measurement {
    private String name;
    private Double value;
    private Long timestamp;
    private Map<String, String> tags;
...
}
```




