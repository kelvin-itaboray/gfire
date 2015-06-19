CREATE DATABASE bd_gfire;
USE bd_gfire;

CREATE TABLE Usuario (
    idUsuario INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    senha VARCHAR (100) NOT NULL,
    telefone VARCHAR (20) NOT NULL,
    statusU BOOLEAN DEFAULT 1,
    isAdmin BOOLEAN DEFAULT 0,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE ContaFixa (
    idContaFixa INT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR (100) NOT NULL,
    PRIMARY KEY (idContaFixa)
);

CREATE TABLE Conta (
    idConta INT NOT NULL AUTO_INCREMENT,
    idUsuario INT NOT NULL,
    idContaFixa INT NOT NULL,
    tipo VARCHAR (100) NOT NULL,
    valor REAL NOT NULL,
    dataVencimento DATETIME NOT NULL,
    pago BOOLEAN DEFAULT 0,
    PRIMARY KEY (idConta),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idContaFixa) REFERENCES ContaFixa(idContaFixa)
);

CREATE TABLE Pagamento (
    idPagamento INT NOT NULL AUTO_INCREMENT,
    idUsuario INT NOT NULL,
    idConta INT NOT NULL,
    statusP BOOLEAN NOT NULL,
    PRIMARY KEY (idPagamento),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idConta) REFERENCES Conta(idConta)
);

INSERT INTO Usuario VALUES (0,'Administrador','123456','(11)1111-1111',1,1);
INSERT INTO ContaFixa VALUES ('Variavel');
