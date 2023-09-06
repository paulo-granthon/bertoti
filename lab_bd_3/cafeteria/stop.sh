#!/bin/bash

# Find the PID of the Spring Boot backend process
backend_pid=$(ps aux | grep '[s]pring-boot:run' | awk '{print $2}')

if [ -z "$backend_pid" ]; then
    echo "Spring Boot backend is not running"
    exit 0
fi

# Send a termination signal to stop the backend
kill -15 "$backend_pid"

# Wait for the backend to stop (you can adjust the timeout as needed)
timeout=60  # Adjust as needed
while ps -p "$backend_pid" > /dev/null; do
    sleep 1
    timeout=$((timeout - 1))
    if [ "$timeout" -eq 0 ]; then
        echo "Timeout reached. Spring Boot backend did not stop gracefully."
        exit 1
    fi
done

echo "Spring Boot backend has been stopped"
