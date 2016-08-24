DROP TABLE if EXISTS USER;
CREATE TABLE USER
(
  UIDPK BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  ROLE_UID BIGINT NOT NULL,
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(50) NOT NULL
) ENGINE=innodb DEFAULT CHARSET=UTF8;
DROP TABLE if EXISTS ROLE;
CREATE TABLE ROLE
(
  UIDPK BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  ROLE_NAME VARCHAR(50) NOT NULL,
  PRIORITY TINYINT
) ENGINE=innodb DEFAULT CHARSET=UTF8;