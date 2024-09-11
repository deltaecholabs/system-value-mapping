# system-value-mapping

Installed
* Java 21+
* Podman
* Podman Compose

Dev Mode
```shell script
quarkus dev --clean
```

Package, build, run locally
```shell script
./mvnw clean package
podman build -t quay.io/deltaecholabs/system-value-mapping:snapshot .
```