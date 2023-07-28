
CREATE TABLE app_user(
    id SERIAL  PRIMARY KEY,
    email_address VARCHAR(255) NOT NULL,
    number_of_password INT,
    role VARCHAR(255),
    unlock_password VARCHAR(255),
    token VARCHAR(255)
    );


CREATE TABLE password(
    id SERIAL  PRIMARY KEY,
    last_updated_at DATETIME(19),
    created_at DATETIME(19),
    password TEXT ,
    password_label VARCHAR(255),
    app_user_id INT,
    FOREIGN KEY (app_user_id) REFERENCES app_user(id),
    app_user_email VARCHAR(255) ,
    token VARCHAR(255)
);
CREATE TABLE token(
    id SERIAL  PRIMARY KEY,
    expired_at TIMESTAMP,
    generated_at TIMESTAMP,
    token VARCHAR(255) ,
    password_id INT ,
    FOREIGN KEY (password_id) REFERENCES password(id)
);