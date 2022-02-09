DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  enabled BOOLEAN
);

INSERT INTO users (username, password, enabled) VALUES
  ('admin', 'admin', true),
  ('gamb', 'gamb', true),
  ('guest', 'guest', true);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR NOT NULL
);

INSERT INTO roles (name) VALUES
  ('USER'),
  ('ADMIN'),
  ('MANAGER');


DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(role_id) REFERENCES roles(id),
  PRIMARY KEY (user_id, role_id)
);

INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 2),
  (2, 1),
  (2, 2),
  (2, 3),
  (3, 1);

DROP TABLE IF EXISTS monsters;
CREATE TABLE monsters (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR NOT NULL,
  description VARCHAR NOT NULL
);

INSERT INTO monsters (name, description) VALUES
  ('Hattifattener', 'Scary white things.'),
  ('The Hemulen', 'Mad scientist');