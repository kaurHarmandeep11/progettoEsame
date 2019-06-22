# progettoEsame.
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

# Diagramma UML
