# Running and Testing
```bash

export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

./gradlew clean build test

change all group = 'martynpi' in build.gradle
docker login
./gradlew clean build docker dockerPush
````

# minikube on Mac
```bash

brew cask upgrade
minikube stop; minikube delete; minikube start; minikube addons enable ingress
kubectl cluster-info
eval $(minikube docker-env)
minikube dashboard &
minikube logs
curl $(minikube service api-backend --url)/actuator/info

```

# aws on Mac
```bash

brew update
brew cask upgrade
brew doctor
brew install python

pushd ~/tmp
curl "https://s3.amazonaws.com/aws-cli/awscli-bundle.zip" -o "awscli-bundle.zip"
unzip awscli-bundle.zip
sudo ./awscli-bundle/install -i /usr/local/aws -b /usr/local/bin/aws
popd

sudo install -d -o $(whoami) -g admin /usr/local/Frameworks
/usr/local/aws/bin/pip list

aws configure

AWS Access Key ID [None]: *******************
AWS Secret Access Key [None]: *******************
Default region name [None]: 
Default output format [None]:

aws iam create-user --user-name mglewis

aws iam list-users

```
```json
{
    "Users": [
        {
            "UserName": "mglewis", 
            "PasswordLastUsed": "2015-05-18T17:34:45Z", 
            "CreateDate": "2012-07-17T13:07:09Z", 
            "UserId": "*******************", 
            "Path": "/", 
            "Arn": "arn:aws:iam::*******************:user/mglewis"
        }
    ]
}
```

# kops setup
```bash

Add the following to ~/.bash_profile

export bucket_name=nytram-kops-state-store
export KOPS_CLUSTER_NAME=k8s.nytram.io
export KOPS_STATE_STORE=s3://${bucket_name}

https://medium.com/containermind/how-to-create-a-kubernetes-cluster-on-aws-in-few-minutes-89dda10354f4

brew install kops

aws iam list-roles

export AmazonEC2FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonEC2FullAccess`].{ARN:Arn}' --output text) 
export AmazonRoute53FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonRoute53FullAccess`].{ARN:Arn}' --output text) 
export AmazonS3FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonS3FullAccess`].{ARN:Arn}' --output text) 
export AmazonVPCFullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonVPCFullAccess`].{ARN:Arn}' --output text) 

aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonEC2FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonRoute53FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonS3FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonVPCFullAccess

https://console.aws.amazon.com/iam/home?region=ap-southeast-2#/users/mglewis


aws s3api create-bucket \
--bucket ${bucket_name} \
--region us-east-1

aws s3api list-buckets

aws s3api put-bucket-versioning --bucket ${bucket_name} --versioning-configuration Status=Enabled

ssh-keygen -t rsa
kops create secret --name ${KOPS_CLUSTER_NAME} sshpublickey admin -i ~/.ssh/id_rsa.pub

https://pattern-match.com/blog/2019/01/30/k8s-tutorial-part01-setup-on-aws/

aws route53 create-hosted-zone --name k8s.nytram.io --caller-reference `uuidgen` > subdomain-hosted-zone.json
update subdomain.json with data from subdomain-hosted-zone.json

aws route53 list-hosted-zones
to get Z3BSI2BQWJHI85

aws route53 change-resource-record-sets --hosted-zone-id Z3BSI2BQWJHI85 --change-batch file://subdomain.json

dig ns k8s.nytram.io

```
# kops dashboard
```bash

https://github.com/kubernetes/kops/blob/master/docs/addons.md

kubectl create -f https://raw.githubusercontent.com/kubernetes/kops/master/addons/kubernetes-dashboard/v1.10.1.yaml

kops get secrets admin -oplaintext

kubectl proxy &
sudo lsof -i tcp:8001 

open http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/.
```

# TODO

- HTTPS
- Secrets
- Health endpoint checking
- Service Discovery
- Centralised logging
- Centralised events
- CI/CD Pipelines
- Add ons
