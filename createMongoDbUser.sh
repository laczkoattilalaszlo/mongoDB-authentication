#!/bin/bash

# Copy the script which creates a user to the container
docker cp createMonogDbUser.js mongodb:/createMonogDbUser.js

# Run the script inside the container:
docker exec mongodb mongosh -u adminUserName -p adminPassword --authenticationDatabase admin /createMonogDbUser.js