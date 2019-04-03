# Running and Testing
```bash

export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

gradle wrapper

./gradlew clean build test
````

# minikube
```bash

brew cask upgrade
minikube stop; minikube delete; minikube start;
kubectl cluster-info
eval $(minikube docker-env)
minikube dashboard
minikube logs
```

# docker kubectl
```bash

kubectl delete deployment starter-rest-api ; kubectl run starter-rest-api --image=martynpi/starter-rest-api:latest --port=8888
kubectl expose deployment starter-rest-api --type=NodePort ; kubectl get services
kubectl delete service starter-rest-api
kubectl delete deployment starter-rest-api

kubectl get deployments ; kubectl get pods
kubectl logs starter-rest-api-bd5f5cc6-ts45z
kubectl describe pod starter-rest-api-bd5f5cc6-ts45z
```

# docker
```bash

./gradlew build
cd server

docker login
docker build --file=Dockerfile --tag=martynpi/starter-rest-api .
docker push martynpi/starter-rest-api
docker pull martynpi/starter-rest-api

kubectl delete -f deployment.yaml ; kubectl create -f deployment.yaml

minikube dashboard

minikube service starter-rest-api
curl $(minikube service starter-rest-api --url)/departments -i
curl -H "Content-Type: application/json" -X POST -d '{"name":"martyn","country":"uk"}' $(minikube service starter-rest-api --url)/departments -i
curl $(minikube service starter-rest-api --url)/departments -i
```