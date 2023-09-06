#!/bin/bash

# cd into backend
cd ../cafeteria/

# stop the backend if already running
./stop.sh

# run the backend execution script in the background
./run.sh &

# Check if the backend is running (you can customize the URL and timeout)
check_backend() {
    local max_attempts=30
    local attempt=0

    while [ $attempt -lt $max_attempts ]; do
        if curl -s --head http://localhost:8080 -o /dev/null; then
            echo -e "\033[0;32mSpring Boot backend is up and running\033[0m"

            return 0
        else
            echo -e "\033[0;34mWaiting for Spring Boot backend to start...\033[0m"

            attempt=$((attempt + 1))
            sleep 2  # Adjust the sleep interval as needed
        fi
    done

    echo -e "\033[0;31mError: Spring Boot backend did not start within a reasonable time\033[0m"

    exit 1
}

check_backend

# cd back into frontend
cd ../cafeteria_front/

# Install frontend dependencies
npm i

# Execute frontend
npm run dev

