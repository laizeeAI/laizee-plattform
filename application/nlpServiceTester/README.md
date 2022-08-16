# NlpServiceTester

Demo-application to test an running NLP-webservice. 
- Sends testdata.json to deployed nlp-webservice
- Prints and evaluates results 

## How to prepare:

mvn clean install

## How to start 
```bash
$ java -jar NlpServiceTester.jar         
       -filename=testdata-de.json 
       -url=https://149.201.187.217/     
       -projectid=1
       -projectname=test-project
       -servicename=las-web
       -username=yourUserName
       -password=yourPassword 
```


| Attribute | Info |
|-----------|------|
| -jar      | Application Name      |
| -filenname | Path to Testdata      |
| -url | Location of your webservice      |
| -projectid | default is 1      |
| -servicename | Name of your project, e.g. travelcom-analyser      |
| -username | User you use to acces the platform     |
| -password | Password you use to acces the platform  |



