CREATE DATABASE owl;

CREATE TABLE user (
  email varchar(128) NOT NULL,
  username varchar(64) NOT NULL,
  hashed_password varchar(1024) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET utf8;