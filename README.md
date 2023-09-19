# Laizee AI Plattform 
 
Sprachanalytik leicht gemacht! 
 
Unsere Mission ist es, unsere Kunden in die Lage zu versetzen, schnell produktive Webservices für die Verarbeitung natürlicher Sprache zu entwickeln und bereitzustellen. Um optimale Ergebnisse zu erzielen, kombinieren wir klassische Methoden der Informatik mit aktuellen Ansätzen aus dem Bereich der KI, speziell für die Verarbeitung natürlicher Sprache. Sie können low-code rein anwendungsbezogen arbeiten und auf Wunsch Modell und Parameter tunen. 
 
Hierfür stellen wir unsere Plattform zur Verfügung, die den ML-Ops-Gedanken konsequent umsetzt. Wir verfolgen einen agilen, inkrementellen Ansatz, der direkt zu einem grundlegenden KI-Modell und einem in der Cloud bereitgestellten Webservice führt. 
 
Auf Wunsch unterstützen wir Sie bei jedem Schritt Ihres Projekts und optimieren gemeinsam mit Ihnen Ihre Anwendung. Da Sie der Experte in Ihrem Bereich sind, kennen Sie die Herausforderungen, die es zu lösen gilt, am besten. Wenn Sie Fragen haben, zögern Sie nicht, uns direkt zu kontaktieren 
 
 
## Informationen für Pilot-User 
 
Vielen Dank dass ihr bereit seid, die Plattform zu pilotieren. Euer Feedback ist für uns unglaublich wichtig.  
 
Alles, was Euch auffällt, ist relevant. Toll wäre, wenn ihr die Ergebnisse als Issues im git dokumentiert. Das Tutorial wird zuerst einen einfachen Sentiment Task beinhalten, bei dem der Nutzer einen kleinen Datensatz von selbsterstellten Kundenfeedback bezüglich der Bahn annotieren kann. Es steht außerdem ein schon fertig annotierter Datensatz bereit. Als zweiten Task wird ein Name Entity Task bezüglich Fragen im Bahnkontext vom Nutzer bearbeitet. Hier geht es darum den Workflow des ersten Teils auf einen neuen Task zu übertragen, der Nutzer soll hierbei bewusst nicht mehr die ganzen Details beschrieben bekommen, da diese schon benannt wurden. Danach wird der Nutzer die Möglichkeiten der Optimierung mittels eines Wörterbuches kennenlernen. Zum Schluss kann der Nutzer eine Beispielanwendung testen, die mit der Plattform kommuniziert.    
  
 
Die Plattform ist erreichbar über:  
- https://demo.laizee.ai.  
- Falls Sie nicht registriert sind, registrieren Sie sich über die Website und wir geben den Account kurzfristig frei. 
- Sie sind als Benutzer registriert und haben per Mail die Zugangsdaten erhalten. Bitte keine weiteren Benutzer anlegen.   
 
### Kontakte 
 
Wenn ihr nicht weiter kommt, stehen wir Euch sehr gerne zur Seite. Leider sind wg. der Urlaubszeit nicht immer alle verfügbar. 
 
- Henri Werth, henri@laizee.ai 
- Bodo Kraft, bodo@laizee.ai 
 
### Wichtige Ressourcen 
 
Ihr könnt mit eigenen Daten arbeiten oder vorbereitete Informationen im git finden: 
 
| Datensätze |  
|----------| 
| [Sentiment Datensatz von Bewertungen der Bahn](./inputdata/corpus/bahn_sentiment_non_labeled.jsonl)    | 
| [Sentiment Datensatz von Bewertungen der Bahn mit Goldlabels](./inputdata/corpus/bahn_sentiment_labeled.jsonl)   |  
| [Name Entity Datensatz von Kundenkommunikaiton der Bahn](./inputdata/corpus/KundenKommunikation.jsonl)    | 
| [Name Entity Datensatz von Kundenkommunikaiton der Bahn mit Goldlabels](./inputdata/corpus/KundenKommunikation_ner_annotiert.jsonl)   | 
 
 
- CSV-Liste mit deutschen [Städtenamen](./inputdata/DeutscheStaedtenamen.csv) 
- Java-Maven-Projekt zur Integration des NLP-Webservice und zum automatisierten Test  
 
 
### Tutorial 
 
##### 1.  Sentiment-Analyse 
 
Ziel: Erste Schritte mit der Plattform 
 
######      1.1 Vorlauf 
 
> - Nachdem Sie ihre Eingangsdaten bekommen haben, können Sie sich auf der Plattform anmelden.  
> - Erstellen Sie ein Projekt unter dem Button *Erstellen* mit einem beliebigen Namen und dem *Projekttyp* *Textklassifikation*. Sie müssen außerdem eine kurze *Beschreibung* hinzufügen. 
######      1.2 Tagging  
> - Klicken Sie jetzt unter *Datensatz* auf *Dokumentenübersicht* und wählen Sie über den *Aktion* Button *Datensatz uploaden* aus. 
> - Wählen Sie das Format *JSONL* und ändern Sie sonst nichts weiteres.  
> - Sie können jetzt einen Datensatz in das vorgesehene Feld ziehen.  
> - Benutzen Sie dazu gerne die im git abgelegten Demo-Daten, den [nicht-annotierten Datensatz](./inputdata/corpus/bahn_sentiment_non_labeled.jsonl) oder wenn Sie nicht labeln wollen den schon [annotierten Datensatz](./inputdata/corpus/bahn_sentiment_labeled.jsonl), siehe oben (Sentiment Analysis). Wählen Sie in diesem beim Upload im Feld *File Format* den Eintrag *JSONL*. 
> - Erzeugen Sie unter dem Reiter *Datensatz* und dem Feld *Label* zwei Sentiment labels (z.B. "positive" und "negative"). 
> - Annotieren Sie, versuchen Sie auch die Tastatur zu verwenden. Hinweis: Sie müssen jede Auswahl mit *Enter* bestätigen 
######      1.3 Training 
Das Training wird an übersprungen. Überspringen Sie diesen Teil und gehen Sie dafür den Teil 1.3 (Optional) 
>- Trainieren Sie, verwenden Sie hierzu die *Standard-Konfiguration*. Hinweis: Mit dem Beispiel-Datensatz wird das Training bis zu 30 Minuten benötigen. 
>- Unter dem Reiter *Training* können Sie jetzt ein Training starten und dort Ihre Konfiguration angeben. Wählen Sie für den Namen des Trainings einen mit lowercase und alphanumerisch sein (Bsp.: *Projektname*.*User*.*Nummer*).     
######      1.3 Laden eines Modells (Optional) 
>- Klicken Sie auf den Tab *Modelle*. Mit dem *Aktion* Button können Sie nun ein Modell uploaden. 
>- Verwenden Sie einen beliebigen Namen und lassen Sie den *Model type* auf spacy. 
>- Nutzen Sie das [Bahn Sentiment Spacy Model](./models/transformer_bahn_sent_spacy.zip).  
######      1.4 Deployment 
>- Deployen Sie den laizee-NLP-Webservice. Unter dem Button *Deployments* können Sie mit dem *+* Zeichen ein neues Deployment erstellen.  
>- In diesem Menü finden alle Deployments, über den *Open-Button* können Sie den Zustand des Webservice erkennen.  
>- Nachdem Sie ein Deployment erstellt haben und dieses *Healthy* ist, könne Sie auf die OpenAPI Schnittstelle zugreifen. Die Url stellt sich wie folgt zusammen:  *https:*//*Deploymentname*.*Projektname*.k8s-demo.laizee.ai/docs 
######       1.5 OpenAPI 
>- Diese kann aber auch öffnen, indem Sie den Button *OpenAPI* klicken, nachdem Sie das Deployment geöffnet haben. 
>- Für vorläufiges Credentials fragen Sie die Kontaktpersonen an.  
>- Über das Feld *Analyze* können Sie nun auf den Button *Try it out* das Textfeld innerhalb des JSON-Beispiels ändern (Ändern Sie im Feld *task*, *NER* zu *CLASSIFICATION*) und bekommen unter *Execute* das Ergebnis des Modells bekommen.  
>- Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Die Tickets sind so kompliziert wie ein komplexes Motormanagement-System. Ich habe den richtigen Zug fast verpasst.* und der Satz *Die Sicherheitsvorkehrungen waren vorbildlich. Hatte keinerlei Bedenken bezüglich meiner beruflichen Ausrüstung oder sensibler Daten. Eine solide Basis für geschäftliche Reisen!* korrekt klassifiziert wird. 
>- Wenn die Qualität nicht ausreicht, versuchen Sie über weiteres Tagging bessere Ergebnisse zu erreichen. 
 
##### 2. Information-Extraction 
 
Ziel: Information Extraction kennenlernen 
>- Erstellen Sie ein neues Projekt und wählen Sie den Projekttyp *Sequence Labeling* 
>- Erstellen Sie ihren annotierten Corpus, benutzen Sie dazu gerne die im git [abgelegten Daten](./inputdata/corpus/KundenKommunikation.jsonl). Wenn Sie nicht Taggen möchten, verwenden Sie den bereits [annotierten Corpus](./inputdata/corpus/KundenKommunikation_ner_annotiert.jsonl) mit den vordefinierten Labels.  
>- Überlegen Sie die benötigten Labels, legen Sie diese an und beschreiben Sie sie in der *Tagging Guideline*. Sie können aber auch einfach die Labels aus dem schon annotierten Daten nehmen. Diese sind: USERDEVICE, PRODUCT, CONCERN, PERSON, MISC, NAMEDTIME, ROUTE, VEHICLE, DATETIME, LOCATION. 
>- Prüfen Sie, ob der annotierter Corpus gut balanciert ist und ergänzen Sie ggf. ihr Tagging 
>- Erstellen Sie ein erstes Modell und deployen Sie es 
>- Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Brauche eine Sitzplatzreservierung für IRE 3048 und 3049 zwischen Aachen und Dortmund* korrekt extrahiert wird. 
 
##### 3. Optimieren Sie Ihr Projekt 
Ziel: Steigerung der Qualität 
>- Überlegen Sie, welche *Regeln*, z.B. Wörterbuch-Einträge oder Reguläre Ausdrücke sinnvoll sind und das Training verbessern können.  
>- Als Beispiel für ein Wörterbuch, verwenden Sie gerne die im git abgelegte Liste mit [Städtenamen](./inputdata/DeutscheStaedtenamen.csv), siehe oben, oder laden Sie eine eigene hoch. 
>- Für das Hochladen klicken Sie unter dem Tab *Datensatz* auf *Regeln*. Dort können Sie über *Aktionen* *Regeln uploaden*. In dem dann auftauchenden Feld können Sie unter *Wähle eine Option* *Regeln für ein Label* auswählen und das Label *Location* benutzen. 
>- Sie können nun den vorgesehenen Datensatz verwenden und auf *Hochladen* drücken. Die Anwendung der Regel kann einige Zeit dauern.  
>- Als Beispiel für einen regulären Ausdruck zum Erkennen eines Datums, verwenden Sie gerne ``` ^/(31|30|[012]\d|\d)[./](0\d|1[012]|\d)[./](\d{4}|\d\d)$/ ``` und ändern Sie den *Regel-Typ* auf *Regulärer Ausdruck (RegEx)* 
>- Testen Sie über die OpenAPI Schnittstelle, wie sich das Extraktions-Ergebnis verbessert hat. 
>- Ermitteln Sie innerhalb der Plattform, wie die Modell-Performance sich entwickelt.     
 
##### 4. Integrieren des NLP-Webservice in Ihre Anwendung 
Ziel: Einbettung in eine Software 
>- Erstellen Sie eine einfache Anwendung, die den generieren Webservice verwendet.  
>- Verwenden Sie gerne die [Java-Vorlage](./application) für eine Konsolenanwendung (Java ab 11 und Maven erforderlich) im git.  
>- Ein zu den Demo-Daten passender, annotierter [Testdatensatz](./application/nlpServiceTester/testdata-de.json) ist hier bereits mit hinterlegt. 
>- Folgen Sie der [Anleitung](./application/nlpServiceTester/README.md) zum übersetzen und starten der Anwendung.    
 
##### 5. Eigene Projekte  
 
>- Experimentieren Sie mit Ihren eigenen Daten und Herausforderungen 
>- Erzählen Sie uns von Ihren Herausforderungen 
 
 
 