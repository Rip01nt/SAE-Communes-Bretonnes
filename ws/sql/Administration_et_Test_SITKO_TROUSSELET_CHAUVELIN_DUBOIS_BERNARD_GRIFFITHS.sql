----------------------------------------------------------------------------------
--=============================PARTIE I CREATION==================================
----------------------------------------------------------------------------------

-- Création des utilisateurs

CREATE USER 'mrprefet'@'localhost' 
	IDENTIFIED BY '4ya5@-zCF5C^q8'
;

CREATE USER 'mremploye'@'localhost' 
	IDENTIFIED BY '%[5M4]qiaT5D2j'
;

CREATE USER 'mradmin'@'localhost' 
	IDENTIFIED BY 'M5q2]5aiD[T%j4'
;

CREATE USER 'trousselet'@'localhost' 
	IDENTIFIED BY 'j4M55qia]2%DT['
;

CREATE USER 'sitko'@'localhost' 
	IDENTIFIED BY '[aT55qiM4%2j]D'
;

CREATE USER 'dubois'@'localhost' 
	IDENTIFIED BY '[D52aM4%T5]qji'
;

CREATE USER 'chauvelin'@'localhost' 
	IDENTIFIED BY '42T%iDMjqa][55'
;

CREATE USER 'bernardgriffiths'@'localhost' 
	IDENTIFIED BY 'a5qjMT][2i%5D4'
;

-- Création des rôles

CREATE ROLE 'administration';
CREATE ROLE 'gestion';
CREATE ROLE 'modification';
CREATE ROLE 'utilisateurs';

-- Attribution des privilèges aux rôles

GRANT ALL PRIVILEGES 
	ON bdSAE.* 
	TO 'administration'
;

GRANT SELECT, INSERT, CREATE 
	ON bdSAE.* 
	TO 'gestion'


GRANT SELECT, INSERT, DROP, ALTER 
	ON bdSAE.* 
	TO 'modification'
;

GRANT SELECT 
	ON bdSAE.* 
	TO 'utilisateurs'
;

-- Attribution des rôles aux utilisateurs
GRANT 'administration' 
	TO 'mradmin'@'localhost', 'trousselet'@'localhost', 'sitko'@'localhost'
;

GRANT 'gestion' 
	TO 'mrprefet'@'localhost'
;

GRANT 'modification' 
	TO 'dubois'@'localhost'
;

GRANT 'utilisateurs' 
	TO 'mremploye'@'localhost'
;

-- Attribution de privilèges particuliers à chauvelin
GRANT SELECT, INSERT, UPDATE 
	ON Commune 
	TO 'chauvelin'@'localhost'
;

GRANT SELECT, DELETE 
	ON Gare 
	TO 'chauvelin'@'localhost'
;

-- Attribution de privilèges particuliers à bernardgriffiths
GRANT SELECT, INSERT 
	ON Aeroport 
	TO 'bernardgriffiths'@'localhost'
;

GRANT UPDATE, DELETE 
	ON DonneesAnnuelles 
	TO 'bernardgriffiths'@'localhost'
;



----------------------------------------------------------------------------------
--===============================PARTIE II TEST===================================
----------------------------------------------------------------------------------

-- Connexion en tant que 'mradmin'

-- Test 1: Création d'une table (succès)
CREATE TABLE Test_Admin_1 (id INT);

-- Test 2: Tentative de sélection dans une table (succès)
SELECT * FROM Test_Admin_1;

-- Test 3: Tentative de suppression d'une table (succès)
DROP TABLE Test_Admin_1;

-- Test 4: Insertion dans une table (succès)
INSERT INTO Commune (idCommune, nomCommune, leDepartement) VALUES (1, 'Rennes', 35);


-- Test 5: Mise à jour dans une table (succès)
UPDATE Departement SET investissementCulturel2019 = 500000 WHERE idDep = 35;



-- Connexion en tant que 'mremploye'

-- Test 1: Création d'une table (échec)
CREATE TABLE Test_Employe_1 (id INT);

-- Test 2: Insertion dans une table (échec)
INSERT INTO Commune (idCommune, nomCommune, leDepartement) VALUES (1, 'Rennes', 35);

-- Test 3: Mise à jour dans une table (échec)
UPDATE Departement SET investissementCulturel2019 = 500000 WHERE idDep = 35;

-- Test 4: Suppression dans une table (échec)
DELETE FROM Commune WHERE idCommune = 1;

-- Test 5: Sélection dans une table (succès)
SELECT * FROM Departement;



-- Connexion en tant que 'trousselet'

-- Test 1: Insertion dans une table (succès)
INSERT INTO Gare (codeGare, nomGare, estFret, estVoyageur, laCommune) VALUES (1, 'Gare de Rennes', 0, 1, 1);

-- Test 2: Suppression dans une table (succès)
DELETE FROM Gare WHERE codeGare = 1;

-- Test 3: Sélection dans une table  (succès)
SELECT * FROM Aeroport;

-- Test 4: Insertion dans une table (succès)
INSERT INTO Commune (idCommune, nomCommune, leDepartement) VALUES (2, 'Brest', 29);

-- Test 5: Sélection dans une table (succès)
SELECT * FROM Voisinage;



-- Connexion en tant que 'sitko'

-- Test 1: Insertion dans une table  (succès)
INSERT INTO Gare (codeGare, nomGare, estFret, estVoyageur, laCommune) VALUES (2, 'Gare de Quimper', 0, 1, 1);

-- Test 2: Suppression dans une table  (succès)
DELETE FROM Aeroport WHERE nom = 'Brest Bretagne Airport';

-- Test 3: Sélection dans une table  (succès)
SELECT * FROM Commune;

-- Test 4: Insertion dans une table (échec)
INSERT INTO Departement (idDep, nomDep, investissementCulturel2019) VALUES (29, 'Finistère', 1000000);

-- Test 5: Mise à jour dans une table (succès)
UPDATE Aeroport SET adresse = 'Quimper' WHERE nom = 'Brest Bretagne Airport';



-- Connexion en tant que 'dubois'

-- Test 1: Suppression dans une table (succès)
DELETE FROM Commune WHERE nomCommune = 'Rennes';

-- Test 2: Mise à jour dans une table (succès)
UPDATE Voisinage SET distance = 20 WHERE idVoisinage = 1;

-- Test 3: Insertion dans une table (succès)
INSERT INTO Gare (codeGare, nomGare, estFret, estVoyageur, laCommune) VALUES (3, 'Gare de Lorient', 0, 1, 1);

-- Test 4: Sélection dans une table (succès)
SELECT * FROM Aeroport;

-- Test 5: Insertion dans une table  (succès)
INSERT INTO Gare (codeGare, nomGare, estFret, estVoyageur, laCommune) VALUES (4, 'Gare de Brest', 0, 1, 1);



-- Connexion en tant que 'chauvelin'

-- Test 1: Insertion dans une table (succès)
INSERT INTO Commune (idCommune, nomCommune, leDepartement) VALUES (2, 'Quimper', 29);

-- Test 2: Mise à jour dans une table (échec)
UPDATE Aeroport SET adresse = 'Quimper' WHERE nom = 'Brest Bretagne Airport';

-- Test 3: Suppression dans une table (succès)
DELETE FROM Aeroport WHERE nom = 'Brest Bretagne Airport';

-- Test 4: Sélection dans une table (succès)
SELECT * FROM Gare;

-- Test 5: Mise à jour dans une table (échec)
UPDATE Commune SET nomCommune = 'Nantes' WHERE idCommune = 1;




-- Connexion en tant que 'bernardgriffiths'

-- Test 1: Insertion dans une table  (succès)
INSERT INTO Aeroport (codeAeroport, nom, adresse, codePostal, laCommune) VALUES (3, 'Aéroport de Lorient Bretagne Sud', 'Lorient', '56700', 2);

-- Test 2: Mise à jour dans une table  (échec)
UPDATE Aeroport SET adresse = 'Quimper' WHERE nom = 'Aéroport de Lorient Bretagne Sud';

-- Test 3: Sélection dans une table  (échec)
SELECT * FROM Commune;

-- Test 4: Insertion dans une table (échec)
INSERT INTO Aeroport (codeAeroport, nom, adresse, codePostal, laCommune) VALUES (4, 'Aéroport de Quimper Cornouaille', 'Quimper', '29000', 2);
