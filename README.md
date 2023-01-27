# User Guide :

## Getting Started :
1) Ensure that your database is set up and ready before proceeding to the API sections
2) If you haven't setup database yet, follow the database steps first

## Database (Yugabyte) :
### How to create/run database using Yugabyte :
1) For installation, make sure you follow this documentation (https://docs.yugabyte.com/preview/quick-start-yugabytedb-managed/)
2) Note that a free account can only create one cluster and if you want to use more than one cluster, you can only create a new account or delete the current cluster.
3) After connecting to YugabyteDB cloud shell  you can write your postgresql query in there to modify the database. For example, create tables, insert into and more.
4) If you don't want to connect using YugabyteDB cloud shell, you can try to use others by following their documentation
![image8](https://user-images.githubusercontent.com/123624174/215009396-0ed13985-687b-4cc1-9931-d2e9be7133f1.png)

-Remember to download the .crt file for authorized connection as well as add your current IP address into the cluster. You can do this by going Actions > Edit IP Allow List. After this just click add current IP address then all should be good.
![image19](https://user-images.githubusercontent.com/123624174/215009460-86b6e587-7795-459d-9fc5-0b81d8f18783.png)
![image5](https://user-images.githubusercontent.com/123624174/215009528-6b2a1d04-944e-4d5f-8ea8-8e84874b96e4.png)

### Connect YugabyteDB with Java
1) First of all, clone this (https://github.com/Dison321/APICodes.git) into your VS code. This is the backend code for the project. 
2) Before running the code, make sure that your application.properties located in the resources folder has the correct properties for your YugabyteDB.
![image10](https://user-images.githubusercontent.com/123624174/215009702-195e45a9-d936-46e2-a3a5-0ab2787c10e3.png)
 For spring.datasource.url = , make sure to copy the link from your Cluster’s settings tab at connection parameters section. Here’s the step:
 
(i) click your cluster after logged in
![image15](https://user-images.githubusercontent.com/123624174/215009903-4c91b076-e9fa-4187-b2b1-7074a9475daf.png)

(ii) go to settings tab
![image3](https://user-images.githubusercontent.com/123624174/215009954-03b21d10-e005-4c71-b74b-16630146b179.png)

(iii) scroll to the bottom
![image20](https://user-images.githubusercontent.com/123624174/215009980-1b088495-93d8-4ffb-9207-60cc9140379a.png)

(iv) copy the Host link

(V)This is the format for your spring.datasource.url =, jdbc:postgresql://(COPIEDLINK):5433/yugabyte?ssl=true&sslmode=verify-full&sslrootcert=(ROOTCERTPATH)

(VI)replace (COPIEDLINK) with what you just copied just now

(VII) now replace (ROOTCERTPATH) with where your cert’s path downloaded. For example: C:\\\Users\\admin\\Desktop\\root2.crt

(VIII)For the remainings datasource just follow your database’s properties you entered when you create the database
![image28](https://user-images.githubusercontent.com/123624174/215010061-c4d4af25-2106-473e-adc8-3d419f5585d0.png)


3) After that, you can now run the Java codes and it should be able to connect to the database. 
![image25](https://user-images.githubusercontent.com/123624174/215010145-2c8171ec-a750-49fd-b123-2a21362b2f2f.png)
![image22](https://user-images.githubusercontent.com/123624174/215010157-cb318489-7232-48f2-9313-6956369a7e18.png)


4) (DONE) will be seen in the console, this means that the backend code is running in the background. Note that, while this is running, you might encounter errors of (Max connection) in your YugabyteDB cloud shell  (where you enter the postgresql query to modify your database) if you tried to connect it. The solution for this is to stop this Java backend code,then try to connect the YugabyteDB cloud shell again then it should be fixed. You can stop the code by clicking the red button below the image I showed or just kill terminate at the terminal sections. 
![image6](https://user-images.githubusercontent.com/123624174/215010190-36597bd1-8e7c-453c-b61f-9799ececcb8d.png)

### SQL File TO Initiated Database (Query)
1) You can run query in the YugabyteDB cloud shell or using Docker (Commands located in query.txt)
2) The query’s file will be located in here : (https://drive.google.com/drive/folders/1ffY7ogBzQwsx_ZyAjwwg-Ib_XM6-Bd01?usp=sharing)
3) For query.txt, it consists of what commands to used to connect to docker and how the tables are created and inserted.
4) For query2.txt, it consists of some query that can be used for data analysts.





## API
### How to create/run API using JAVA
1) First of all make sure you have all prerequisites downloaded (Java & Maven especially). For more information and prerequisites, you can check this link (https://spring.io/guides/gs/rest-service/)
2) There’s no need to follow the steps in the link above or this youtube link: (https://youtu.be/MWLe1tqPmUo) since I already create a repo to cloned from github (https://github.com/Dison321/APICodes.git) but it will be great sources to show you how I build the REST API using Java.
3) Note that, for this API to connect with YugabyteDB, I’ll be using the JDBC library instead of the JPA library because the JPA documentation is only valid for spring boot 2.0 while I’m using spring boot 3.0. 
![image17](https://user-images.githubusercontent.com/123624174/215010841-2b0456b2-ba02-4c3d-954b-7e5ad9fd3dcc.png)

As you can see above, there’s JDBC dependency in my pom.xml file.
4)For more information on how to connect API with yugabyteDB using JDBC library, you can check out this documentation : (https://bushansirgur.in/spring-jdbc/) .
5)If you wish to run the codes, make sure to type the command : (mvn clean install spring-boot:run)  	
![image12](https://user-images.githubusercontent.com/123624174/215010915-b1d1fd15-c382-48ce-89bb-471a6ab2939c.png)
If (DONE) appeared in the console, this indicates the API is working now. To test whether the API is working, you can try to use Postman.
![image21](https://user-images.githubusercontent.com/123624174/215011173-8f6a29f6-9001-47c0-94e2-dd5467b901ac.png)
If there's a list of Users returned in body, this means the API is functioning and you can now run the frontend code (Flutter). 

## Accessing OpenAPI Documentations
i) Start backend code as mentioned above
ii) Access the documentation with this address :
(http://localhost:8080/swagger-ui/index.html#/)
