CREATE DATABASE school;

USE school;

CREATE TABLE userInfo
(
	id VARCHAR(20) PRIMARY KEY,
    passwd VARCHAR(100) NOT NULL,
	usertype int
);

CREATE TABLE commonBoard
(
	boardNo INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(10000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    writeDate DATETIME DEFAULT NOW(),
    userFileName VARCHAR(1000) NOT NULL,
    savedFileName VARCHAR(100) NOT NULL,
    FOREIGN KEY (writer) REFERENCES userInfo (id)
);

CREATE TABLE about
(
	fileNo INT PRIMARY KEY AUTO_INCREMENT,
    categNo INT NOT NULL,
    userFileName VARCHAR(1000) NOT NULL,
    savedFileName VARCHAR(100) NOT NULL
);











