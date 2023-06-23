## Google Books Script
This python script calls various google books API and publish it in elastic search index

This python code internally calls this endpoint - https://www.googleapis.com/books/v1/volumes

## Pre-requistes

There should be local instance of elastic search running at - http://localhost:9200

## Google Books Java Service

This service exposed API using spring boot, spring webflux and enabled cors.

## Google Books Engine UI

This is the Search Engine UI built with react js auto-complete and css. It calls the Java API endpoints, renders data on the UI.






