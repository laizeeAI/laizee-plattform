<img src="logo.svg"/>

# Laizee AI Plattform

Sprachanalytik leicht gemacht!

Unsere Mission ist es, unsere Kunden in die Lage zu versetzen, schnell produktive Webservices für die Verarbeitung natürlicher Sprache zu entwickeln und bereitzustellen. Um optimale Ergebnisse zu erzielen, kombinieren wir klassische Methoden der Informatik mit aktuellen Ansätzen aus dem Bereich der KI, speziell für die Verarbeitung natürlicher Sprache. Sie können low-code rein anwendungsbezogen arbeiten und auf Wunsch Modell und Parameter tunen.

Hierfür stellen wir unsere Plattform zur Verfügung, die den ML-Ops-Gedanken konsequent umsetzt. Wir verfolgen einen agilen, inkrementellen Ansatz, der direkt zu einem grundlegenden KI-Modell und einem in der Cloud bereitgestellten Webservice führt.

Auf Wunsch unterstützen wir Sie bei jedem Schritt Ihres Projekts und optimieren gemeinsam mit Ihnen Ihre Anwendung. Da Sie der Experte in Ihrem Bereich sind, kennen Sie die Herausforderungen, die es zu lösen gilt, am besten. Wenn Sie Fragen haben, zögern Sie nicht, uns direkt zu kontaktieren


## Informationen für Pilot-User

Vielen Dank dass ihr bereit seid, die Plattform zu pilotieren. Euer Feedback ist für uns unglaublich wichtig. 

Alles, was Euch auffällt, ist relevant. Toll wäre, wenn ihr die Ergebnisse als Issues im git dokumentiert. Das Tutorial wird zuerst einen einfachen Sentiment Task beinhalten, bei dem der Nutzer einen kleinen Datensatz von selbsterstellten Kundenfeedback bezüglich der Bahn annotieren kann. Es steht außerdem ein schon fertig annotierter Datensatz bereit. Als zweiten Task wird ein Name Entity Task bezüglich Fragen im Bahnkontext vom Nutzer bearbeitet. Hier geht es darum den Workflow des ersten Teils auf einen neuen Task zu übertragen, der Nutzer soll hierbei bewusst nicht mehr die ganzen Details beschrieben bekommen, da diese schon benannt wurden. Danach wird der Nutzer die Möglichkeiten der Optimierung mittels eines Wörtbuches kennenlernen. Zum Schluss kann der Nutzer eine Beispielanwendung testen, die mit der Plattform kommuniziert.   
  

Die Plattform ist erreichbar über: 
- https://demo.laizee.ai. 
- Falls Sie nicht registriert sind, regristrieren Sie sich über die Website und wir geben den Account kurzfristig frei.
- Sie sind als Benutzer registriert und haben per Mail die Zugangsdaten erhalten. Bitte keine weiteren Benutzer anlegen.  

### Kontakte

Wenn ihr nicht weiter kommt, stehen wir Euch sehr gerne zur Seite. Leider sind wg. der Urlaubszeit nicht immer alle verfürbar.

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

1. Sentiment-Analyse: Nachvollziehen des Demo-Projekts 
     - Versuchen Sie Projekt aus dem Video schrittweise bis zum Punkt des Trainings nach zu implementieren.
     - Nachdem Sie ihre Eingangsdaten bekommen haben, können Sie sich auf der Plattform anmelden. 
     - Erstellen Sie ein Projekt unter dem Button *Erstellen* mit einem beliebigen Namen und dem *Projektyp* *Textklassifikation*. Sie müssen außerdem eine kuzre *Beschreibung* hinzufügen.
     - Klicken Sie jetzt unter *Datensatz* auf *Dokumentenübersicht* und wählen Sie über den *Aktion* Button *Datensatz uploaden* aus.
     - Wählen Sie das Format *JSONL* und ändern Sie sonst nichts weiteres. 
     - Sie können jetzt einen Datensatz in das vorgesehene Feld ziehen. 
     - Benutzen Sie dazu gerne die im git abgelegten Demo-Daten, z.B. den nicht-annotierten Datensatz, siehe oben (Sentiment Analysis). Wählen Sie in diesem beim Upload im Feld *File Format* den Eintrag *JSONL*.
     - Erzeugen Sie unter dem Reiter *Datensatz* und dem Feld *Label* zwei Sentimentlabels (z.B. "positive" und "negative").
     - Annotieren Sie, versuchen Sie auch die Tastatur zu verwenden. Hinweis: Sie müssen jede Auswahl mit *Enter* bestätigen
     - Trainieren Sie, verwenden Sie hierzu die *Standard-Konfiguration*. Hinweis: Mit dem Beispiel-Datensatz wird das Training bis zu 30 Minuten benötigen.
     - Unter dem Reiter *Training* können Sie jetzt ein Training starten und dort Ihre Konfiguration angeben. Wählen Sie für den Namen des Trainings einen mit lowercase und alphanumerisch sein (Bsp.: training1).    
     - Deployen Sie den laizee-NLP-Webservice. Unter dem Button *Deployments* können Sie mit dem *+* Zeichen ein neues Deployment erstellen. 
     - In diesem Menü finden alle Deployments, über den *Open-Button* können Sie den Zustand des Webservice erkennen. 
     - Nachdem Sie ein Deployment erstellt haben und dieses *Healthy* ist, könne Sie auf die OpenAPI Schnittstelle zugreifen. Die Url stellt sich wie folgt zusammen:  *https://**Deploymentname*.*Projektname*.k8s-demo.laizee.ai/docs
     - Diese kann aber auch öffnen indem Sie den Button *OpenAPI* klicken nachdem Sie das Depolyment geöffnet haben.
     - Für vorläufiges Credentials fragen Sie die Kontaktpersonen an. 
     - Über das Feld *Analyze* können Sie nun auf den Button *Try it out* das Textfeld innerhalb des JSON-Beispiels ändern (Ändern Sie im Feld *task*, *NER* zu *CLASSIFICATION*) und bekommen unter *Execute* das Ergebnis des Modells bekommen. 
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Die Zugfahrt war ein reines Vergnügen. Alles war sauber und pünktlich* korrekt klassifiziert wird.
     - Wenn die Qualität nicht ausreicht, versuchen Sie über weiteres Tagging bessere Ergebnisse zu erreichen.
2. Information-Extraction: Neuen Projekttyp verwenden
     - Erstellen Sie ein neues Projekt und wählen Sie den Projekttyp *Sequence Labeling"
     - Überlegen Sie die benötigten Label, legen Sie diese an und beschreiben Sie sie in der *Tagging Guideline*. 
     - Erstellen Sie ihren annotierten Corpus, benutzen Sie dazu gerne die im git abgelegten Daten. Wenn Sie nicht Taggen möchten, verwenden Sie den bereits annotierten Corpus mit den vordefinierten Labels. Wählen Sie in diesem beim Upload im Feld *File Format* den Eintrag *JSONL* und im Feld *Column Label* den Wert *labels*
     - Prüfen Sie, ob der annotierter Corpus gut balanciert ist und ergänzen Sie ggf. ihr Tagging
     - Erstellen Sie ein erstes Modell und deployen Sie es
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Brauche eine Sitzplatzreservierung für IRE 3048 und 3049  zwischen Aachen und Dortmund* korrekt extrahiert wird.
3. Optimieren Sie Ihr Projekt
     - *Überlegen Sie, welche *Regeln*, z.B. Wörterbuch-Einträge oder Reguläre Ausdrück [Syntax, Python-Style](https://regex101.com/) sinnvoll sind und das Training verbessern können. 
     - Als Beispiel für einen Wörterbuch, verwenden Sie gerne die im git abgelegte Liste mit Städtenamen, siehe oben, oder laden Sie eine eigene hoch.
	 - Für das Label *Location*
     - Als Beispiel für einen regulären Ausdruck zum erkennen eines Datums, verwenden Sie gerne ``` ^/(31|30|[012]\d|\d)[./](0\d|1[012]|\d)[./](\d{4}|\d\d)$/ ```
     - Testen Sie über die OpenAPI Schnittstelle, wie sich das Extraktions-Ergebnis verbessert hat.
     - Ermitteln Sie innerhalb der Platform, wie die Modell-Performance sich entwickelt. 	 
4. Integrieren des NLP-Webservice in Ihre Anwendung
     - Erstellen Sie eine einfache Anwendung, die den generieren Webservice verwendet. 
     - Verwenden Sie gerne die [Java-Vorlage](./application) für eine Konsolenanwendung (Java ab 11 und Maven erforderlich) im git. 
     - Ein zu den Demo-Daten passender, annotierter [Testdatensatz](./application/nlpServiceTester/testdata-de.json) ist hier bereits mit hinterlegt.
     - Folgen Sie der [Anleitung](./application/nlpServiceTester/README.md) zum übersetzen und starten der Anwendung.   
5. Eigene Projekte 
     - Experimentieren Sie mit Ihren eigenen Daten und Herausforderungen
     - Erzählen Sie uns von Ihren Herausforderungen


