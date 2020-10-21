# Rest Client Test
This is an example of testing the rest client. 
## Specification
 ```
java 8 or higher
spring-boot 2.3 or higher
maven 3.6.x or higher    
```
## File Structure
```
├── main
│    ├── ClientTestApplication.java               * Main application
│    ├── bean                                     * Our bean files
│    │    └── RestTemplateBean.java               * Bean the resttemplate
│    ├── dto                                      * Our DTO files
│    │   └── StoreDto.java                        * Dto 
│    └── service                                  * Our service files
│        └── client                               * Our client service files
│            └── StoreClientService.java          * Rest Client used for hit the Endpoint
└── test                                          * Our test files
    ├── ClientTestApplicationTests.java           * Main test class
    └── service                                   * Our service test files
          └── client                              * Our client test files
              └── StoreClientServiceTest.java     * Our service test files
```
Note : If you want to test the rest client, you can't put the new instance you need to make it dependency injection, in this application using autowired

## Run the Test
```
mvn clean install
```