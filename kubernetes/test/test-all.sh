#!/usr/bin/env bash

set -x

IP=ingress.k8s.nytram.io
#IP=a626f9018756b11e9a8df0af8b934799-188568855.us-east-1.elb.amazonaws.com
#IP=`minikube ip`

curl https://${IP}/api-backend/info -k
curl https://${IP}/api-frontend/info -k
curl https://${IP}/api-tests/info -k
