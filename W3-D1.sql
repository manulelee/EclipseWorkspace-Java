/*  crea nuovo database */
/* CREATE DATABASE w3d1; */

/* creazione tabella cliente */
CREATE TABLE clienti(
	id_cliente SERIAL NOT NULL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL,
	regione_residenza VARCHAR NOT NULL
	);
	
/* creazione tabella fatture */
CREATE TABLE fatture(
	id_fattura SERIAL NOT NULL PRIMARY KEY,
	tipologia VARCHAR NOT NULL,
	importo DECIMAL NOT NULL,
	iva INT NOT NULL,
	id_cliente INT NOT NULL,
	data_fattura DATE NOT NULL,
	numero_fornitore INT NOT NULL
	);
	
/* creazione tabella prodotti */
CREATE TABLE prodotti(
	id_prodotto SERIAL NOT NULL PRIMARY KEY,
	descrizione VARCHAR NOT NULL,
	in_prouzione BOOLEAN NOT NULL,
	in_commercio BOOLEAN NOT NULL,
	data_attivazione DATE NOT NULL,
	data_disattivazione DATE
	);	
	
/* creazione tabella fornitori */
CREATE TABLE fornitori(
	id_fornitore SERIAL NOT NULL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regione_residenza VARCHAR NOT NULL
	);
	

/*  inserimento dati clienti */
INSERT INTO clienti (nome, cognome, data_nascita, regione_residenza)
	VALUES ('Nome C1', 'Cognome C1', '1991-01-01', 'Citta C1');
INSERT INTO clienti (nome, cognome, data_nascita, regione_residenza)
	VALUES ('Nome C2', 'Cognome C2', '1992-02-02', 'Citta C2');
INSERT INTO clienti (nome, cognome, data_nascita, regione_residenza)
	VALUES ('Nome C3', 'Cognome C3', '1982-03-03', 'Citta C3');

	SELECT * FROM clienti;
	
/*  inserimento dati fornitori */
INSERT INTO fornitori (denominazione, regione_residenza)
	VALUES ('Fornitore 1', 'Citta F1');
INSERT INTO fornitori (denominazione, regione_residenza)
	VALUES ('Fornitore 2', 'Citta F2');
	
	SELECT * FROM fornitori;
	
/*  inserimento dati fatture */
INSERT INTO fatture (tipologia, importo, iva, idCliente, data_fattura, numeroFornitore)
	VALUES ('acquisto', 122.98, 22, 1, '2022-01-01', 1);
INSERT INTO fatture (tipologia, importo, iva, idCliente, data_fattura, numeroFornitore)
	VALUES ('vendita', 300.41, 20, 2, '2023-03-02', 1);

	SELECT * FROM fatture;

/*  clienti nati nel 1982 */
SELECT nome, cognome FROM clienti WHERE extract(YEAR from data_nascita) = '1982';


/*  svuota dati da tabella */
TRUNCATE utente;

/*  modifica struttura tabella */

/*  aggiungi colonna su tabella */
ALTER TABLE  utente ADD cf VARCHAR NULL UNIQUE;

/*  rinomina colonna su tabella */
ALTER TABLE  utente RENAME COLUMN cf TO codicefiscale;

/*  elimina colonna su tabella */
ALTER TABLE  utente DROP codicefiscale;



