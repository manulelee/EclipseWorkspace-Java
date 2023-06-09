/*  crea nuovo database */
--CREATE DATABASE w3d1;

-- Clienti (NumeroCliente, Nome, Cognome, DataNascita, RegioneResidenza);
CREATE TABLE IF NOT EXISTS clienti (
	numero_cliente SERIAL PRIMARY KEY, 
	nome VARCHAR NOT NULL, 
	cognome VARCHAR NOT NULL, 
	data_nascita DATE NOT NULL, 
	regione_residenza VARCHAR NOT NULL);
	
-- Fornitori (NumeroFornitore, Denominazione, RegioneResidenza);
CREATE TABLE IF NOT EXISTS fornitori (
	numero_fornitore SERIAL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regione_residenza VARCHAR NOT NULL
);

-- Fatture (NumeroFattura, Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore);
CREATE TABLE IF NOT EXISTS fatture (
	numero_fattura SERIAL PRIMARY KEY, 
	tipologia VARCHAR NOT NULL, 
	importo DECIMAL NOT NULL, 
	iva VARCHAR NOT NULL DEFAULT '20%', 
	id_cliente INTEGER NOT NULL, 
	data_fattura DATE NOT NULL, 
	numero_fornitore INTEGER NOT NULL,
	FOREIGN KEY (id_cliente) REFERENCES clienti (numero_cliente),
	FOREIGN KEY (numero_fornitore) REFERENCES fornitori (numero_fornitore)
);

-- Prodotti (IdProdotto, Descrizione, InProduzione, InCommercio,  DataAttivazione, DataDisattivazione);
CREATE TABLE IF NOT EXISTS prodotti (
	id_prodotto SERIAL PRIMARY KEY, 
	descrizione VARCHAR NOT NULL, 
	in_produzione BOOLEAN NOT NULL DEFAULT 'false', 
	in_commercio BOOLEAN NOT NULL DEFAULT 'false',  
	data_attivazione DATE NOT NULL, 
	data_disattivazione DATE
);


INSERT INTO clienti(nome, cognome, data_nascita, regione_residenza ) 
		VALUES 	('Mario', 'Rossi', '1/8/1999', 'Lazio'),
				('Giuseppe', 'Verdi', '2000/01/21', 'Lombardia'),
				('Francesca', 'Neri', '2003/04/24', 'Campania'),
				('Antonio', 'Gialli', '1999/5/29', 'Sicilia');

INSERT INTO fornitori(denominazione, regione_residenza ) 
		VALUES 	('Epicode SRL', 'Lazio'),
				('JavaSchool SPA', 'Piemonte');
		
INSERT INTO fatture(tipologia, importo, iva, id_cliente, data_fattura, numero_fornitore) 
		VALUES 	('A', '145.12', '10%', 2, '2022/2/2', 1),
				('B', '533.99', '20%', 1, '2022/4/29', 2),
				('A', '145.12', '20%', 3, '2023/1/12', 1),
				('A', '188.00', '15%', 2, '2023/2/2', 1);

INSERT INTO prodotti (descrizione, in_produzione, in_commercio,  data_attivazione, data_disattivazione)
		VALUES 	('Prodotto x', true, false, '2017/4/29', '2023/4/29'),
				('Prodotto z', true, true, '2016/9/15', '2024/9/15'),
				('Prodotto q', false, false, '2017/12/12', '2022/9/12');
				
SELECT * FROM clienti;
SELECT * FROM fornitori;
SELECT * FROM fatture;
SELECT * FROM prodotti;

-- Estrarre il nome e il cognome dei clienti nati nel 1999
SELECT nome, cognome FROM clienti WHERE EXTRACT(YEAR FROM data_nascita) = 1999;

-- Estrarre il numero delle fatture con iva al 20%
SELECT COUNT(*) AS numero_fatture_20  FROM fatture WHERE iva = '20%';

-- Riportare il numero di fatture e la somma dei relativi importi divisi 
-- per anno di fatturazione
SELECT 
	EXTRACT(YEAR FROM data_fattura) AS anno, 
	COUNT(*) AS numero_fatture, 
	SUM(importo) AS importo  
		FROM fatture 
		GROUP BY EXTRACT(YEAR FROM data_fattura);

-- Estrarre i prodotti attivati nel 2017 e che sono in produzione oppure in commercio
SELECT * FROM prodotti 
		WHERE EXTRACT(YEAR FROM data_attivazione) = 2017
		AND (in_produzione = true OR in_commercio = true);

-- Considerando soltanto le fatture con iva al 20 per cento, 
-- estrarre il numero di fatture per ogni anno
SELECT EXTRACT(YEAR FROM data_fattura) AS anno, COUNT(*) AS numero_fatture_20 
	FROM fatture 
	WHERE iva = '20%' 
	GROUP BY EXTRACT(YEAR FROM data_fattura);

-- Estrarre gli anni in cui sono state registrate più o uguale a 2 fatture con tipologia ‘A’
SELECT EXTRACT(YEAR FROM data_fattura) AS anno, COUNT(*) AS numero_fatture_A 
		FROM fatture 
		WHERE tipologia = 'A' 
		GROUP BY EXTRACT(YEAR FROM data_fattura)
		HAVING COUNT(*) > 1;
		
-- Riportare l’elenco delle fatture (numero, importo, iva e data) 
-- con in aggiunta il nome del fornitore
SELECT numero_fattura, importo, iva, data_fattura, denominazione
	FROM fatture AS fa INNER JOIN fornitori AS fo ON fa.numero_fornitore = fo.numero_fornitore;

-- Estrarre il totale degli importi delle fatture divisi per residenza dei clienti
SELECT clienti.regione_residenza, COUNT(*), SUM(fatture.importo) FROM fatture 
	INNER JOIN clienti ON fatture.id_cliente = clienti.numero_cliente
	GROUP BY clienti.regione_residenza;

-- Estrarre il numero dei clienti nati nel 1980 che hanno almeno una fattura superiore a 50 euro
SELECT * FROM clienti INNER JOIN fatture ON fatture.id_cliente = clienti.numero_cliente 
WHERE EXTRACT(YEAR FROM data_nascita) = 1999 AND fatture.importo > 50;

-- Estrarre una colonna di nome “Denominazione” contenente il nome, seguito da un carattere “-“, 
-- seguito dal cognome, per i soli clienti residenti nella regione Lombardia
SELECT CONCAT(nome, ' - ', cognome) AS denominazione FROM clienti WHERE regione_residenza = 'Lombardia';


