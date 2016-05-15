# Dropwizard-Samples

### The Dropwizard framework is a Java Framework with High Performance, can develop RESTful Webservices.

Using the above framework, developed a sample application which retrieves user details from H2DB which is an embedded in application 
through build-in Jersey Server. Curl has to be installed to hit the request.


Please follow the below steps to run the application successfully,

###Create a the Database using the below commands,

`mvn clean compile flyway:migrate`

###Generate Jar Package,

`mvn clean install package`

###Start the Jetty Server,

`java -jar target/UserSamples-V1.0.jar server config.yml`

###Hit the application using curl,

`curl -H "Accept:application/json" localhost:8080/User_Profiles/1000`

