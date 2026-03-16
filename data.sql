INSERT INTO users 
    (firstname, lastname, email, pwd_hash, bio, profile_pic, created_at, created_by, updated_at, updated_by)
VALUES
    ('Super', 'Admin', 'superadmin@example.com', '$2a$10$Z.AtJfB9puB/rz9RF41Qa.tYOazyNid6TBSelC.d4j/9I18Nz2NRS', 'System super admin', 'superadmin.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('Admin', 'User', 'admin@example.com', '$2a$10$Z.AtJfB9puB/rz9RF41Qa.tYOazyNid6TBSelC.d4j/9I18Nz2NRS', 'System administrator', 'admin.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('Normal', 'User', 'user@example.com', '$2a$10$Z.AtJfB9puB/rz9RF41Qa.tYOazyNid6TBSelC.d4j/9I18Nz2NRS', 'Regular system user', 'user.jpg', CURRENT_TIMESTAMP, 'DBA', NULL, NULL);

INSERT INTO roles
    (name, created_at, created_by, updated_at, updated_by)
VALUES
    ('ROLE_SUPER_ADMIN', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('ROLE_ADMIN', CURRENT_TIMESTAMP, 'DBA', NULL, NULL),
    ('ROLE_USER', CURRENT_TIMESTAMP, 'DBA', NULL, NULL);

INSERT INTO user_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
