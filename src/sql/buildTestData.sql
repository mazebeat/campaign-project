/**
POSTGRESQL

CREATE TABLE users
(
  username character varying(100) NOT NULL,
  password character varying(100) NOT NULL,
  enabled boolean DEFAULT true,
  locked boolean DEFAULT false,
  failed_logins integer DEFAULT 0,
  last_login_date timestamp without time zone,
  CONSTRAINT "PK_USER" PRIMARY KEY (username)
);

CREATE TABLE roles
(
  id integer NOT NULL,
  name character varying(50) NOT NULL,
  CONSTRAINT "PK_ROLES" PRIMARY KEY (id)
);


CREATE TABLE authorities
(
  "user" character varying(50) NOT NULL,
  role integer NOT NULL,
  CONSTRAINT "PK_AUTHORITIES" PRIMARY KEY ("user", role),
  CONSTRAINT "FK_ROLE" FOREIGN KEY (role)
      REFERENCES roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_USER" FOREIGN KEY ("user")
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users VALUES ('bytestree', '12345', true, false, 0);
INSERT INTO users VALUES ('admin', '12345', true, false, 0);

INSERT INTO authorities VALUES ('bytestree', 1);
INSERT INTO authorities VALUES ('admin', 1);
INSERT INTO authorities VALUES ('admin', 2);
*/

/**  MYSQL */
CREATE SCHEMA `mercenary-project` DEFAULT CHARACTER SET utf8 ;
USE `mercenary-project`;

CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `locked` tinyint(1) NOT NULL DEFAULT '0',
  `failed_logins` int(11) NOT NULL DEFAULT '0',
  `last_login` date DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `user` varchar(100) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`user`,`role`),
  KEY `fk_role_idx` (`role`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user` FOREIGN KEY (`user`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users VALUES ('demo', '12345', true, false, 0, Now());
INSERT INTO users VALUES ('admin', '12345', true, false, 0, Now());

INSERT INTO authorities VALUES ('demo', 1);
INSERT INTO authorities VALUES ('admin', 1);
INSERT INTO authorities VALUES ('admin', 2);
