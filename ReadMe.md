# About
This project is Spring boot based test automation framework for functional tests with Selenium and Cucumber.
We use Page Components and inject them into our Page objects. Tests can be executed in parallel and currently it is set to execute them in parallel.
This framework supports multiple environment execution via application properties files. 

## Executing tests on different environments.
By default, application.properties values will be used
If you want to execute tests on dev environment set environment variable: spring.profiles.active=dev or VM options -Dspring.profiles.active=dev
for executing tests on pipeline with specific environment.

## How to run tests trough docker
You must have docker container running. Default url set for executing tests on docker is set to - http://localhost:4444/wd/hub
If you need to change URL for executing tests on docker change it in application-remote.properties file.
**Environment options should be: spring.profiles.active=remote or VM options -Dspring.profiles.active=remote**