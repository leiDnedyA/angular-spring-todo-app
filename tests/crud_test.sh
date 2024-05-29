#!/bin/bash

# Define the base URL of the API
BASE_URL="localhost:8080"

RESOURCE="todo-items"

# Test POST request
echo "Testing POST request..."
curl -X POST "$BASE_URL/$RESOURCE/2" -H "Content-Type: application/json" -d '{"id":"2", "name":"Do some activity"}'
echo -e "\n"

# Test GET request
echo "Testing GET request..."
curl -X GET "$BASE_URL/$RESOURCE/2" -H "Accept: application/json"
echo -e "\n"

# Test PUT request
echo "Testing PUT request..."
curl -X PUT "$BASE_URL/$RESOURCE/2" -H "Content-Type: application/json" -d '{"id":"2", "name":"Slightly altered activity"}'
echo -e "\n"

# Test DELETE request
echo "Testing DELETE request..."
curl -X DELETE "$BASE_URL/$RESOURCE/2"
echo -e "\n"
