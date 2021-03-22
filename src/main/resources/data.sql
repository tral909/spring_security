DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(250) NOT NULL UNIQUE,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(20) NOT NULL DEFAULT 'USER',
  status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
);

INSERT INTO users (email, first_name, last_name, password, role, status) VALUES
  ('admin@mail.ru', 'Admin', 'Adminov', '$2y$12$r1N.Mc/bog3w3OC6YAJi9ern.FbIeKFpIINtTyHjfEPgaVSzkYUXq', 'ADMIN', 'ACTIVE'),
  ('user@mail.ru', 'User', 'Userov', '$2y$12$cRgoCX24jHyI6ns2mBI2xOATploP6suxuQcgM29OBWXX0X6DD3PqO', 'USER', 'BANNED');