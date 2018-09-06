Take the EsbFacade-Deployment.zip attached in the below location :

https://connecture.atlassian.net/wiki/spaces/SHSUH/pages/412385321/ESB-facade

Unzip this folder into any location.

Change the application.properties files under the below location -

EsbFacade-Deployment

The properties :

need to change as below -

1 ) Run the below command inside the EsbFacade-Deployment folder to run load-esb-fileStore-1.0.jar from your cmd :

java -jar -DapplicationProperties=application.properties  bitbucket-1.0.jar

The application will be available in 

http://{ip-address-of-host}:{port}/bitbucket/loadEsbFileStore
