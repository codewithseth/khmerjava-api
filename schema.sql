CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    pwd_hash VARCHAR(100) NOT NULL,
    roles VARCHAR(100) NOT NULL,
    bio TEXT,
    profile_pic VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP,
    updated_by VARCHAR(100)
);