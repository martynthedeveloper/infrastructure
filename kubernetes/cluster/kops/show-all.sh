#!/usr/bin/env bash

set -x

kops validate cluster
kops get clusters

../minikube/show-all.sh
