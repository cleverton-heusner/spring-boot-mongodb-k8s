# Index
- [Spring Boot MongoDB K8S](#spring-boot-mongodb-k8s)
- [Prerequisites](#prerequisites)
- [Deploy](#deploy)
- [Testing](#testing)
- [Various Commands](#various-commands)

## Spring Boot MongoDB K8S
> This repository illustrates the deployment on Kubernetes of a simple API written in Spring Boot. The application
> maintains clients in MongoDB. Both the API and the database are deployed using Deployment templates. In addition, the 
> credentials and URL of the database are being kept in a Secret and a ConfigMap, respectively.

## Prerequisites
- Java `17`
- Windows `11`
- Docker `27.1.1`
- Minikube `1.34.0`

## Deploy
1. Initialize Docker. On Windows, just run Docker Desktop;
2. Start Minikube with the command: ```minikube start```
3. In the root of the project, execute the following sequence of commands:
   1. Deploy the secret containing the database credentials: ```kubectl apply -f customers-db-secret.yaml```
   2. Deploy the configmap that holds the database URL: ```kubectl apply -f customers-db-configmap.yaml```
   3. Deploy the MongoDB container: ```kubectl apply -f customers-db-deployment.yaml```
   4. Generate the application distribution file: ```./mvnw clean package```
   5. Create the Docker image of the application distribution: ```docker image build -t spring-boot-mongodb-k8s .```
   6. Load the created image into the Minikube context: ```minikube image load spring-boot-mongodb-k8s```
   7. Deploy the application on Minikube: ```kubectl apply -f spring-boot-mongodb-k8s-deployment.yaml```

## Testing
1. To view the API in the browser, use the command: ```minikube service spring-boot-mongodb-k8s-service```
2. Then, access the endpoint that retrieves the customers registered during the application’s initialization:
   http://127.0.0.1:54167/customer

## Various Commands:
1. Cleaning up deployed resources:
   - ConfigMap for the database URL: ```kubectl delete configmap mongo-config```
   - Secret with the database credentials: ```kubectl delete secret mongo-secret```
   - API Deployment: ```kubectl delete deployment spring-boot-mongodb-k8s-deployment```
   - MongoDB Deployment: ```kubectl delete deployment customers-db-deployment```
   - API image in Minikube: ```minikube image rm spring-boot-mongodb-k8s```
   - API image outside Minikube: ```docker rmi spring-boot-mongodb-k8s```
2. Troubleshooting:
   - Show running pods: ```kubectl get pod```
   - Display logs of the API pod: ```kubectl logs api-pod-name```
   - Show detailed information of the API pod: ```kubectl describe pod api-pod-name```
   - List events performed by the API and MongoDB: ```kubectl get events```