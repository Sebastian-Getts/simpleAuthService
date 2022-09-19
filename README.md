# simpleAuthService

This is a simple authentication and authorization service, support some functions, such as generate token, create roles,
map user and role etc.

## Requirements
- JDK v8
- Maven

## Core API
- [x] create user
- [x] delete user
- [x] create role
- [x] delete role
- [x] add role to user
- [x] authenticate
- [x] invalidate
- [x] check role
- [x] all roles of a user
- [ ] ...(welcome to PR or ISSUE)

see details at interface **AuthService** in project.

## Dependencies except java core api
- Junit5, to complement unit tests
- surefire, to support maven run unit tests

## Testing
If you are using IntelliJ, you can right lick test package, run "All tests" with coverage to see the tests condition and details. Or you can use maven to run tests.
```shell
mvn test
```