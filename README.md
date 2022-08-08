# Laizee AI Plattform
language analytics made easy!

Our mission is to enable our customers to rapidly develop and deliver productive natural language processing web services. In order to achieve optimal results, we combine classic computer science methods with current approaches in the field of AI, especially for natural language processing. You can work low-code purely application-related and tune model and parameters on request.

For this purpose, we provide our platform, which consistently implements the ML-Ops idea. We follow an agile, incremental approach that leads directly to a basic AI model and a cloud-deployed web service.

On demand, we support you in every step of your project and optimize your application together with you. As you are the expert in your domain, you know best the challenges that need to be solved. If you have any questions dont hesitate to contact us directly



## Informationen für Pilot-User

Vielen Dank dass ihr bereit seid, die Plattform zu pilotieren. Euer Feedback ist für uns unglaublich wichtig. 

Alles, was Euch auffällt, ist relevant. Toll wäre, wenn ihr die Ergebnisse als Issues im git dokumentiert.  

### Kontakte

Wenn ihr nicht weiter kommt, stehen wir Euch sehr gerne zur Seite. Leider sind wg. der Urlaubszeit nicht immer alle verfürbar.

- Philipp Kohl, 0151/12345678, philipp@laizee.ai
- Lars Klöser, 0151/12345678, lars@laizee.ai
- André Büsgen, 0151/12345678, andre@laizee.ai (Urlaub 06.08.2022-28.08.2022)
- Henri Werth, 0151/12345678, werth@laizee.ai (Urlaub 20.08.2022-??.09.2022)
- Bodo Kraft, 0151 / 122 93 722, bodo@laizee.ai

### Wichtige Ressourcen

Ihr könnt mit eigenen Daten arbeiten oder vorbereitete Informationen im git finden:

- Demo-Daten: Nicht annotierter Datensatz mit Kundenfeedback. 
- CSV-Liste mit deutschen Städtenamen
- Java-Maven-Projekt zur Integration des NLP-Webservice und zum automatisierten Test 
- Starter-Video zur Sentiment-Analysis auf Youtube  [Video]|(www.youtube.com/laizee/starter-sentiment)

### Mögliche Herausforderungen 

Hinweis: Aktuell sind die gerenierten Services noch öffentlich verfügbar, sofern der Link bekannt ist. 

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
     - *Überlegen Sie, welche *Regeln*, z.B. Wörterbuch-Einträge oder Reguläre Ausdrück [Syntax, Python-Style](https://regex101.com/) sinnvoll sind und das Training verbessern können. 
     - Als Beispiel für einen Wörterbuch, verwenden Sie gerne die im git abgelegte Liste mit [Städtenamen]((https://www.example.com)) oder laden Sie eine eigene hoch.
     - Als Beispiel für einen regulären Ausdruck zum erkennen eines Datums, verwenden Sie gerne ``` ^/(31|30|[012]\d|\d)[./](0\d|1[012]|\d)[./](\d{4}|\d\d)$/ ```
     - Testen Sie über die OpenAPI Schnittstelle, wie sich das Extraktions-Ergebnis verbessert hat.
     - Ermitteln Sie innerhalb der Platform, wie die Modell-Performance sich entwickelt. 
4. Integrieren des NLP-Webservice in Ihre Anwendung
     - Erstellen Sie eine einfache Anwendung, die den generieren Webservice verwendet. 
     - Verwenden Sie gerne die [Java-Vorlage](git) für eine Konsolenanwendung (Java ab 11 und Maven erforderlich) im git. 
     - Ein zu den Demo-Daten passender, annotierter Testdatensatz ist hier bereits mit hinterlegt.
     - Passend Sie in der Datei main.java den Pfad zu Ihren Webservice an und starten Sie die Anwendung mit java -jar laizee4Me.jar 
5. Eigene Projekte 
     - Experimentieren Sie mit Ihren eigenen Daten und Herausforderungen
     - Erzählen Sie uns von Ihren Herausforderungen


