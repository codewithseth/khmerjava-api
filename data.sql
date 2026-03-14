INSERT INTO users 
    (firstname, lastname, email, pwd_hash, roles, bio, profile_pic, created_at, created_by, updated_at, updated_by)
VALUES
    ('John', 'Doe', 'john@example.com', 'hashedpassword1', 'ADMIN', 'Tech blogger', 'john.jpg', NOW(), 'Admin', NULL, NULL),
    ('Jane', 'Smith', 'jane@example.com', 'hashedpassword2', 'AUTHOR', 'Java developer', 'jane.jpg', NOW(), 'Admin', NULL, NULL),
    ('David', 'Lee', 'david@example.com', 'hashedpassword3', 'USER', 'Tech reader', 'david.jpg', NOW(), 'Admin', NULL, NULL);