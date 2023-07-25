CREATE TABLE IF NOT EXISTS
CREATE TABLE app_user(
    id SERIAL  PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL,
    number_of_password INT,
    role ENUM(),
    unlock_password VARCHAR(255),
    token VARCHAR(255),
    );

CREATE TABLE IF NOT EXISTS
CREATE TABLE password(
    id SERIAL  PRIMARY KEY,
    last_updated_at DATETIME(19),
    created_at DATETIME(19),
    password VARCHAR(255) NOT NULL ,
    password_label VARCHAR(255) NOT NULL,
    app_user_id INT NOT NULL,
    FOREIGN KEY (app_user_id) REFERENCES app_user(id),
    app_user_email VARCHAR(255) NOT NULL,
    token VARCHAR(255) NOT NULL
);