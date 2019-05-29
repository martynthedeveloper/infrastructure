#!/usr/bin/env bash

set -x

IP=ingress.k8s.nytram.io
#IP=af7453f10821b11e9b09e0a5fbc3d0b9-107115694.us-east-1.elb.amazonaws.com
#IP=`minikube ip`

curl http://${IP}/api-backend/info

curl http://${IP}/api-frontend/info

curl http://${IP}/api-tests/info

