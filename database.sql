CREATE DATABASE wegOne;
USE wegOne;

CREATE TABLE manuais (
    id_manual INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) UNIQUE,
    autor VARCHAR(100),
    texto TEXT,
    dataDePublicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipoManual ENUM('Manual de conduta operacional', 'Manual de diagnósticos', 'Manual de manutenção', 'Manual de operação', 'Manual de segurança')
);
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) UNIQUE,
    senha VARCHAR(255),
    tipo ENUM('viewer', 'user', 'adm')
);

CREATE USER 'viewer'@'localhost' IDENTIFIED BY 'senhaViewer';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'senhaUser';
CREATE USER 'adm'@'localhost' IDENTIFIED BY 'senhaAdm';
GRANT SELECT ON wegOne.manuais TO 'viewer'@'localhost';
GRANT SELECT, INSERT, UPDATE ON wegOne.manuais TO 'user'@'localhost';
GRANT SELECT, INSERT, DELETE, UPDATE ON wegOne.manuais TO 'adm'@'localhost';