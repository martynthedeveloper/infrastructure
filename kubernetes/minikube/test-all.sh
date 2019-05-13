#!/usr/bin/env bash

set -x

curl https://`minikube ip`/e2e-test -ik