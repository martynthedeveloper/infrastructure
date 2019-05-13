#!/usr/bin/env bash

set -x

IP=`minikube ip`

curl https://${IP}/e2e-test -k
#
#curl `minikube service e2e-svc-node-port --url`
#curl http://${IP}:30033/
#
# 308 Permanent Redirect to https
#curl http://${IP}/e2e-test
