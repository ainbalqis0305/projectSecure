-- Inserting user data
INSERT INTO users(email, name, password) VALUES
('admin@gmail.com', 'admin', '$2a$12$JGriZzgFwZNEeulzFcocjug9wb0/GOEJ1nco27FZoCvVLmfpfiWe');

INSERT INTO users(email, name, password) VALUES
('test@gmail.com', 'John', '$2a$12$SF2QRPx07EsQTswGmyxB4sOw7RLCnDqux/LWhO5vfegs42OS2LE.C');

INSERT INTO users(email, name, password) VALUES
('abc@gmail.com', 'Alex', '$2a$12$SaRRjmnRA5MkVg3M.xSc1G.jQkkvfx73WJhIvI.771MkJyZpTT5dvC');

INSERT INTO users(email, name, password) VALUES
('def@gmail.com', 'Boss', '$2a$12$SMBeLkc4HGARn/pOnBI1HSugtEBvLSEwRvQ4EzqAykvt4hUogKI/Zy');

-- Inserting role data
INSERT INTO roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO roles(name) VALUES ('ROLE_USER');

-- Inserting user-roles relationships
INSERT INTO users_roles(role_id, user_id) VALUES (1, 1);
INSERT INTO users_roles(role_id, user_id) VALUES (2, 2);
INSERT INTO users_roles(role_id, user_id) VALUES (2, 3);
INSERT INTO users_roles(role_id, user_id) VALUES (2, 4);
INSERT INTO users_roles(role_id, user_id) VALUES (1, 4);



INSERT INTO student (matric_num, phone_num, student_name) VALUES ('211684', '0189033378', 'Putri Amylia');
INSERT INTO student (matric_num, phone_num, student_name) VALUES ('209966', '0123456789', 'Ain Balqis');
INSERT INTO student (matric_num, phone_num, student_name) VALUES ('211874', '0198765432', 'Nik Maisara');
INSERT INTO student (matric_num, phone_num, student_name) VALUES ('210101', '0135798642', 'Asna Syahirah');
INSERT INTO student (matric_num, phone_num, student_name) VALUES ('212812', '0124689753', 'Syazana Aqilah');




-- Insert data into the "parcel" table with a valid "STUDENT_ID"
INSERT INTO parcel (tracking_num, date_in, date_out, colour, student_id)
VALUES ('igshop1234', '2024-01-16', '2024-01-20', 'Blue',1);

INSERT INTO parcel (tracking_num, date_in, date_out, colour, student_id)
VALUES ('ttshop6789', '2024-01-17', '2024-01-21', 'Pink',2);

INSERT INTO parcel (tracking_num, date_in, date_out, colour, student_id)
VALUES ('shoppee847', '2024-01-18', '2024-01-22', 'Purple',3);

INSERT INTO parcel (tracking_num, date_in, date_out, colour, student_id)
VALUES ('lazada8838', '2024-01-19', '2024-01-23', 'Red',4);

INSERT INTO parcel (tracking_num, date_in, date_out, colour, student_id)
VALUES ('twt2735823', '2024-01-20', '2024-01-24', 'Black',5);