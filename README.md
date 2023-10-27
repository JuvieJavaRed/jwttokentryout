# jwttokentryout
A simple implementation of Spring Security and JWT generation and auth or end points 

# How to use the secured endpoint

1. Clone the project and navigate to the root of the project
2. To run the system open up a command line terminal and run the command "mvn spring-boot:run"
3. Open up postman and create a post request with the a json request {"username":"admin", "password":"password"}
4. Send the post request to "http://localhost:8081/authenticate" and you should get a jwttoken.
5. Use the token to send a GET request to "http://localhost:8081/tryout"

The negative secnario for this is if you were try send a get
