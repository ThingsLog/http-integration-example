[ThingsLog](https://thingslog.com) is an IoT monitoring platform for monitoring of utility services,
ambient and external environment, and automation.

This guide covers setup for ThingsLog HTTP/HTTPS push integration.

## 1. Configure the integration in ThingsLog

### v1 payload (default)

```bash
curl -X PUT "https://iot.thingslog.com/v2/integration/http" \
  -H "accept: */*" \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{
    "name": "test_endpoint",
    "url": "http://<remote_host>:<remote_port>/data",
    "method": "POST",
    "headers": {
      "Accept": "application/json"
    }
  }'
```

### v2 payload (opt-in)

v2 keeps all v1 fields and adds: `account_name`, `device_name`, `sensor_name`, `dimension`.

Enable v2 by adding header `X-ThingsLog-Payload-Version: 2` in integration settings:

```bash
curl -X PUT "https://iot.thingslog.com/v2/integration/http" \
  -H "accept: */*" \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{
    "name": "test_endpoint",
    "url": "http://<remote_host>:<remote_port>/data",
    "method": "POST",
    "headers": {
      "Accept": "application/json",
      "X-ThingsLog-Payload-Version": "2"
    }
  }'
```

## 2. Run this example server

Build:

```bash
mvn package
```

This produces `thingslog-http-integration-boot.jar` in `target/`.

Run:

```bash
java -jar thingslog-http-integration-boot.jar
```

Run without `application.properties`:

```bash
java -jar -Dserver.port=8000 thingslog-http-integration-boot.jar
```

## 3. Payload examples

### v1 payload example

```json
[
  {
    "name": "test_endpoint",
    "value": 17,
    "timestamp": 1568548140000,
    "tags": {"general": "rssi", "device_number": "01008213"}
  },
  {
    "name": "test_endpoint",
    "value": 84304,
    "timestamp": 1568548140000,
    "tags": {"device_number": "01008213", "sensor_index": "0"}
  }
]
```

### v2 payload example

```json
[
  {
    "name": "test_endpoint",
    "value": 84304,
    "timestamp": 1568548140000,
    "tags": {"device_number": "01008213", "sensor_index": "0"},
    "account_name": "Test Company",
    "device_name": "Main Meter",
    "sensor_name": "Water Counter",
    "dimension": "m^3"
  },
  {
    "name": "test_endpoint",
    "value": 17,
    "timestamp": 1568548140000,
    "tags": {"general": "rssi", "device_number": "01008213"},
    "account_name": "Test Company",
    "device_name": "Main Meter",
    "sensor_name": "rssi",
    "dimension": null
  }
]
```

## 4. Field reference

Common fields (v1 + v2):

- `name` - integration name configured in ThingsLog.
- `value` - sensor/general value.
- `timestamp` - epoch milliseconds.
- `tags` - metadata.
  - `general` - non-sensor reading type (`rssi`, `ber`, `battery`, etc.).
  - `sensor_index` - sensor index for sensor readings.
  - `device_number` - unique ThingsLog device number.

v2 additional fields:

- `account_name` - ThingsLog account/company name.
- `device_name` - ThingsLog device name.
- `sensor_name` - sensor display name (or general tag fallback).
- `dimension` - sensor unit (for example `m^3`, `kWh`, `deg C`), null when not applicable.

## 5. Java model used in this example

The provided `Measurement` class is backward compatible and can parse both v1 and v2 payloads.



