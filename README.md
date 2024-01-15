### Datadog + Spring Boot integration

As a result, Traces and Spring Boot Actuator metrics are being sent to Datadog.

Step 1. Download Datadog agent:
```shell
wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
```

Step 2. Run Docker container with agent. Remember to add your API Key and Datadog URI:
```shell
docker run -d --cgroupns host --pid host --name dd-agent \
  -v /var/run/docker.sock:/var/run/docker.sock:ro \
  -v /proc/:/host/proc/:ro \
  -v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
  -e DD_SITE=us5.datadoghq.com \
  -e DD_API_KEY=your-api-key \
  -p 8126:8126 \
  gcr.io/datadoghq/agent:7
```

Step 3. Set your values in application.properties for Spring app, including URI:
```properties
management.datadog.metrics.export.api-key=your-api-key
management.datadog.metrics.export.application-key=your-application-key
management.datadog.metrics.export.uri=https://us5.datadoghq.com
```

Step 4. Run Spring app using this command. You can choose your own service name and environment:
```shell
java -javaagent:/path/to/dd-java-agent.jar \
  -Ddd.logs.injection=true \
  -Ddd.service=spring-test \
  -Ddd.env=dev \
  -jar /path/to/fat/spring/app.jar
```

Give metrics and traces few mins to be uploaded to the server, and go to:
- APM -> Traces page
- Metrics -> Summary
- Metrics -> Explorer.