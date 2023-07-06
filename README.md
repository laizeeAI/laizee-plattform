<img src="logo.svg"/>

# Laizee AI Plattform
language analytics made easy!

Our mission is to enable our customers to rapidly develop and deliver productive natural language processing web services. In order to achieve optimal results, we combine classic computer science methods with current approaches in the field of AI, especially for natural language processing. You can work low-code purely application-related and tune model and parameters on request.

For this purpose, we provide our platform, which consistently implements the ML-Ops idea. We follow an agile, incremental approach that leads directly to a basic AI model and a cloud-deployed web service.

On demand, we support you in every step of your project and optimize your application together with you. As you are the expert in your domain, you know best the challenges that need to be solved. If you have any questions dont hesitate to contact us directly



## Informationen für Pilot-User

Vielen Dank dass ihr bereit seid, die Plattform zu pilotieren. Euer Feedback ist für uns unglaublich wichtig. 

Alles, was Euch auffällt, ist relevant. Toll wäre, wenn ihr die Ergebnisse als Issues im git dokumentiert.  

Die Plattform ist erreichbar über: 
- https://demo.taggingmatters.de/. 
- Du bist als Benutzer registriert und hast per Mail die Zugangsdaten erhalten. Bitte keine weiteren Benutzer anlegen.  

### Kontakte

support@laizee.ai.

### Wichtige Ressourcen

Ihr könnt mit eigenen Daten arbeiten oder vorbereitete Informationen im git finden:

- Demo-Daten: [Annotierter](./inputdata/corpus/KundenKommunikation_ner_annotiert.jsonl) und [nicht-annotierter](./inputdata/corpus/KundenKommunikation.jsonl), deutscher Datensatz mit Kundenfeedback. 
   - Labels: PLACE, ...
- CSV-Liste mit deutschen [Städtenamen](./inputdata/DeutscheStaedtenamen.csv)
- Java-Maven-Projekt zur Integration des NLP-Webservice und zum automatisierten Test 
- Starter-Video zur Sentiment-Analysis auf [Youtube-Video](https://youtu.be/nWv3rnFqH7k)

### Mögliche Herausforderungen 

1. Sentiment-Analyse: Nachvollziehen des Demo-Projekts 
     - Versuchen Sie Projekt aus dem Video schrittweise nach zu implementieren.
     - Benutzen Sie dazu gerne die im git abgelegten Demo-Daten, z.B. den nicht-annotierten Datensatz, siehe oben. Wählen Sie in diesem beim Upload im Feld *File Format* den Eintrag *JSONL*. 
     - Annotieren Sie, versuchen Sie auch die Tastatur zu verwenden. Hinweis: Sie müssen jede Auswahl mit *Enter* bestätigen
     - Trainieren Sie, verwenden Sie hierzu die *Standard-Konfiguration*. Hinweis: Mit dem Beispiel-Datensatz wird das Training bis zu 30 Minuten benötigen.  
     - Deployen Sie den laizee-NLP-Webservice. Im Menü *Deployments* finden Sie Ihre Deployments, über den *Open-Button* können Sie den Zustand des Webservice erkennen. 
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Von Frankfurt nach Hamburg in nur 4 Stunden. Wie immer alles perfekt gelaufen!* korrekt klassifiziert wird.
     - Wenn die Qualität nicht ausreicht, versuchen Sie über weiteres Tagging bessere Ergebnisse zu erreichen. Hinweis: Richtig gut wird es erst ab 50% ;-)
2. Information-Extraction: Neuen Projekttyp verwenden
     - Erstellen Sie ein neues Projekt und wählen Sie den Projekttyp *Information Extraction"
     - Überlegen Sie die benötigten Label, legen Sie diese an und beschreiben Sie sie in der *Tagging Guideline*. 
     - Erstellen Sie ihren annotierten Corpus, benutzen Sie dazu gerne die im git abgelegten Daten. Wenn Sie nicht Taggen möchten, verwenden Sie den bereits annotierten Corpus mit den vordefinierten Labels. Wählen Sie in diesem beim Upload im Feld *File Format* den Eintrag *JSONL* und im Feld *Column Label* den Wert *labels*
     - Prüfen Sie, ob der annotierter Corpus gut balanciert ist und ergänzen Sie ggf. ihr Tagging
     - Erstellen Sie ein erstes Modell und deployen Sie es
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Drive from Frankfurt to Hamburg, as always a pleasure!* korrekt extrahiert wird.
3. Optimieren Sie Ihr Projekt
     - *Überlegen Sie, welche *Regeln*, z.B. Wörterbuch-Einträge oder Reguläre Ausdrück [Syntax, Python-Style](https://regex101.com/) sinnvoll sind und das Training verbessern können. 
     - Als Beispiel für einen Wörterbuch, verwenden Sie gerne die im git abgelegte Liste mit Städtenamen, siehe oben, oder laden Sie eine eigene hoch.
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


