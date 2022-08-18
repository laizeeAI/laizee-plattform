# NlpServiceTester

Demo-application to test an running NLP-webservice. 
- Sends testdata.json to deployed nlp-webservice
- Prints and evaluates results 

## How to prepare:

```bash
mvn clean install
```

## How to start 
```bash
$ cd jar
$ java -jar NlpServiceTester.jar         
       -filename=../testdata-de.json 
       -url=https://staging.taggingmatters.de/     
       -projectid=1
       -servicename=las-web
       -username=yourUserName
       -password=yourPassword 
```


| Attribute | Info |
|-----------|------|
| -jar      | Application Name      |
| -filenname | Path to Testdata      |
| -url | Location of your webservice, e.g. https://staging.taggingmatters.de      |
| -projectid | Find the project id (at the moment) in the url (behind 'projects') inside our platform      |
| -servicename | Name of your service, e.g. travelcom-analyser, look at your deployments      |
| -username | User you use to acces the platform     |
| -password | Password you use to acces the platform  |



