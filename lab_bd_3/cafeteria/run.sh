#!/bin/bash

mvn clean install -e -X

if [ $? -ne 0 ]; then
    echo "Error compiling Spring Boot backend"
    exit 1
fi

mvn spring-boot:run -e -X &
