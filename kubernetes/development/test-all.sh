#!/usr/bin/env bash

set -x

IP=ingress.k8s.nytram.io
#IP=a626f9018756b11e9a8df0af8b934799-188568855.us-east-1.elb.amazonaws.com

curl http://${IP}/api-backend/info

curl http://${IP}/api-frontend/info

curl http://${IP}/api-tests/info

