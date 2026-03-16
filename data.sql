INSERT INTO users 
    (firstname, lastname, email, pwd_hash, bio, profile_pic, created_at, created_by, updated_at, updated_by)
VALUES
    ('John', 'Doe', 'john@example.com', 'hashedpassword1', 'Tech blogger', 'john.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('Jane', 'Smith', 'jane@example.com', 'hashedpassword2', 'Java developer', 'jane.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('David', 'Lee', 'david@example.com', 'hashedpassword3', 'Tech reader', 'david.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL);

INSERT INTO roles
    (name, created_at, created_by, updated_at, updated_by)
VALUES
    ('ROLE_ADMIN', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('ROLE_USER', CURRENT_TIMESTAMP, 'DBA', NULL, NULL);
