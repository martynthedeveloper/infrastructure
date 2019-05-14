#!/usr/bin/env bash

set -x

IP=`minikube ip`

curl http://${IP}/e2e-test
curl https://${IP}/e2e-test -k

curl `minikube service e2e-svc-node-port --url`
curl http://${IP}:30033/
