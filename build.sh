#!/usr/bin/env bash

set -x

./gradlew clean build

cd server
docker build --file=Dockerfile --tag=martynpi/starter-rest-api:4 .
cd ..
docker push martynpi/starter-rest-api:4

cd server-client
docker build --file=Dockerfile --tag=martynpi/starter-rest-api-client:4 .
cd ..
docker push martynpi/starter-rest-api-client:4

cd server-tests
docker build --file=Dockerfile --tag=martynpi/starter-rest-api-tests:4 .
cd ..
docker push martynpi/starter-rest-api-tests:4

kubectl delete -f deployment.yaml ; kubectl create -f deployment.yaml


#curl -H "Content-Type: application/json" -X POST -d '{"name":"martyn","country":"uk"}' $(minikube service starter-rest-api --url)/departments -i
#curl $(minikube service starter-rest-api-client --url)/proxy -i
