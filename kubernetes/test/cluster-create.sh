#!/usr/bin/env bash

set -x

kops create cluster \
--node-count=2 \
--node-size=t2.medium \
--cloud aws \
--zones=us-east-1a \
--dns-zone ${KOPS_CLUSTER_NAME} \
--name=${KOPS_CLUSTER_NAME} \
--yes

kops validate cluster

echo ' ssh use DNS ...'
echo ' ssh -i ~/.ssh/id_rsa admin@api.k8s.nytram.io '