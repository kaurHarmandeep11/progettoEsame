# ProgettoEsame.
Progetto d'esame del 25 giugno 2019 di Programmazione oggetti.Ingegneria informatica e dell'Automazione, 2° anno.Realizzato da Kaur Harmandeep e Nociaro Igor.

# Introduzione
Il progetto assegnato ha lo scopo di utilizzare un dataset su cui vengono gestite diverse query attraverso le API GET REST E POST.I dati richiesti vengono estratti in formato JSON a partire da un file CSV.Nello sviluppo dell' applicazione usiamo SPRING, un framework che lavora sulla piattaforma java, importando librerie di SPRING in ECLIPSE per il corretto funzionamento.E POSTMAN per la visualizzzione delle richieste

# Realizzazione
1. Parsing dei dati dal csv.
2. Inserimento nella lista dei dati estratti.
3. Restituzione dei metadati.
4. Restituzione dei dati.
5. Gestione filtri sui dati.
7. Gestione statistiche sui dati.

# Funzionamento
- Il Programma si appoggia su un web server locale sulla porta 8080 per soddisfare le specifiche richieste dall'utente.Utilizzando POSTMAN Tramite la:
- "GET /metadata/" vengono visualizzati i metadati.
- "GET /data/"  restituisce intero dataset in json.
- "GET /data?filter={} restituisce un data specifico.
- "GET /stats?field={} restituisce le statistiche applicate.

# Struttura Progetto
Il progetto contiene le classi: 
-Download.java che effettua il parsing del dataset.
-Metadata.java: Seeparazione dei dati tramite "Comma_Delimiter".

-Handler.java: Per utilizzo di @GetMapping.

-LocaleMilano.java: la classe e il costruttore
-Locale.java: implementa "Locale.java".
-SuperLocale.java: Applicazione filtro alla classe "LocaleMilano.java".

-CreaOggetti.java: Crea la lista degli Oggetti di "LocaleMilano.java".

-Filter.java e FilterUtils.java: Per la realizzazione dei filtri.

# Diagramma UML
