# Laizee AI Plattform

## Informationen für Pilot-User



### Wichtige Ressourcen

- Demo-Daten


### Mögliche Herausforderungen 

1. Sentiment-Analyse: Nachvollziehen des Demo-Projekts 
     - Versuchen Sie Projekt aus dem [Video]|(www.youtube.com/laizee/starter-sentiment) schrittweise nach zu implementieren.
     - Benutzen Sie dazu gerne die im git abgelegten [Demo-Daten](https://www.example.com). 
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Drive from Frankfurt to Hamburg, as always a pleasure!* korrekt klassifiziert wird.
2. Information-Extraction: Neuen Projekttyp verwenden
     - Erstellen Sie ein neues Projekt und wählen Sie den Projekttyp *Information Extraction"
     - Überlegen Sie die benötigten Label, legen Sie diese an und beschreiben Sie sie in der *Tagging Guideline*
     - Erstellen Sie ihren annotierten Corpus, benutzen Sie dazu gerne die im git abgelegten [Demo-Daten](https://www.example.com).
     - Prüfen Sie, ob ihr annotierter Corpus gut balanciert ist und ergänzen Sie ggf. ihr Tagging
     - Erstellen Sie ein erstes Modell und Deployen Sie es
     - Testen Sie über die OpenAPI Schnittstelle, ob der Satz *Drive from Frankfurt to Hamburg, as always a pleasure!* korrekt extrahiert wird.
3. Optimieren Sie Ihr Projekt
     - *Überlegen Sie, welche *Regeln*, z.B. Wörterbuch-Einträge oder Reguläre Ausdrück [Syntax, Java-Style](https://regex101.com/) sinnvoll sind und das Training verbessern können. 
     - Als Beispiel für einen Wörterbuch, verwenden Sie gerne die im git abgelegte Liste mit [Städtenamen]((https://www.example.com)) oder laden Sie eine eigene hoch.
     - Als Beispiel für einen regulären Ausdruck zum erkennen eines Datums, verwenden Sie gerne ``` ^/(31|30|[012]\d|\d)[./](0\d|1[012]|\d)[./](\d{4}|\d\d)$/ ```
     - Testen Sie über die OpenAPI Schnittstelle, wie sich das Extraktions-Ergebnis verbessert hat.
     - Ermitteln Sie innerhalb der Platform, wie die Modell-Performance sich entwickelt. 
4. Integrieren des NLP-Webservice in Ihre Anwendung
     - Erstellen Sie eine einfache Anwendung, die den generieren Webservice verwendet. Verwenden Sie gerne die [Java-Vorlage](git) für eine Konsolenanwendung (Java ab 11 und Maven erforderlich) im git. Ein zu den Demo-Daten passender, annotierter Testdatensatz ist hier bereits mit hinterlegt.    


   ```
