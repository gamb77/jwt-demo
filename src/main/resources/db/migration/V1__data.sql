DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date TIMESTAMP NOT NULL,
  created_by VARCHAR NOT NULL,
  user_name VARCHAR NOT NULL,
  password VARCHAR NOT NULL,
  enabled BOOLEAN,
  last_login TIMESTAMP,
  login_count BIGINT DEFAULT 0
);

INSERT INTO users (created_date, created_by, user_name, password, enabled) VALUES
  (NOW(), 'admin', 'admin', '$2a$09$I/QAsh6zzBYx4V23r52Y2enQs7GqmXUfSnikhPIqo94LUHisfkgsa', true),
  (NOW(), 'admin', 'gamb', '$2a$09$I/QAsh6zzBYx4V23r52Y2enQs7GqmXUfSnikhPIqo94LUHisfkgsa', true),
  (NOW(), 'admin', 'guest', '$2a$09$I/QAsh6zzBYx4V23r52Y2enQs7GqmXUfSnikhPIqo94LUHisfkgsa', true);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date TIMESTAMP NOT NULL,
  created_by VARCHAR NOT NULL,
  name VARCHAR NOT NULL
);

INSERT INTO roles (created_date, created_by, name) VALUES
  (NOW(), 'admin', 'USER'),
  (NOW(), 'admin', 'ADMIN'),
  (NOW(), 'admin', 'MANAGER');


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
  created_date TIMESTAMP NOT NULL,
  created_by VARCHAR NOT NULL,
  name VARCHAR NOT NULL,
  description VARCHAR NOT NULL
);

INSERT INTO monsters (created_date, created_by, name, description) VALUES
  (NOW(), 'admin', 'Hattifattener', 'Scary white things.'),
  (NOW(), 'admin', 'The Hemulen', 'Mad scientist');

DROP TABLE IF EXISTS events;
CREATE TABLE events (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  created_date TIMESTAMP NOT NULL,
  created_by VARCHAR NOT NULL,
  event_type INT NOT NULL,
  description VARCHAR NOT NULL
);
