# Running and Testing
```bash

export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

gradle wrapper

./gradlew clean build test
````

# minikube on Mac
```bash

brew cask upgrade
minikube stop; minikube delete; minikube start;
kubectl cluster-info
eval $(minikube docker-env)
minikube dashboard
minikube logs
```

# docker
```bash

change all group = 'martynpi' in build.gradle

docker login
./gradlew clean build docker dockerPush

cd infrastructure/kubernetes/production
./kubectl-blue.sh

open ../endpoints.html

```