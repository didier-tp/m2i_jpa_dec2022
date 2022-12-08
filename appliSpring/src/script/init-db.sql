CREATE DATABASE IF NOT EXISTS BaseQuiVaBien ;
use BaseQuiVaBien;

DROP TABLE IF EXISTS employe;
DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS compte;

CREATE TABLE employe(
emp_id INTEGER auto_increment,
firstname VARCHAR(64),
lastname VARCHAR(64),
phone_number VARCHAR(64),
email VARCHAR(64),
login VARCHAR(32),
password VARCHAR(64),
PRIMARY KEY(emp_id));

CREATE TABLE compte(
numero INTEGER auto_increment,
label  VARCHAR(64),
solde DOUBLE,
PRIMARY KEY(numero));

CREATE TABLE operation(
numOp INTEGER auto_increment,
label  VARCHAR(64),
montant DOUBLE,
dateOp  VARCHAR(16),
num_compte INTEGER,
PRIMARY KEY(numOp));

ALTER TABLE operation ADD CONSTRAINT operation_avec_compte_valide
FOREIGN KEY (num_compte) REFERENCES compte(numero);


INSERT INTO employe (emp_id,firstname,lastname,phone_number,email,login,password)
VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');

INSERT INTO employe (emp_id,firstname,lastname,phone_number,email,login,password)
VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');

INSERT INTO compte (numero,label,solde) VALUES (1,'compteA', 50.0);
INSERT INTO compte (numero,label,solde) VALUES (2,'compteB', 70.0);

INSERT INTO operation (numOp,label,montant,dateOp,num_compte) 
   VALUES (1,'achat bonbons', -5.2 , '2022-12-08' , 1);
INSERT INTO operation (numOp,label,montant,dateOp,num_compte) 
    VALUES (2,'paye novembre', 2000 , '2022-11-30' , 1);

SELECT * FROM employe;
SELECT * FROM compte;
SELECT * FROM operation;