INSERT INTO patient (name, birth_date, email, gender, create_at,blood_group)
VALUES ('John Doe', '1985-05-15', 'john.doe@email.com', 'Male', CURRENT_TIMESTAMP,'A_POSITIVE');

INSERT INTO patient (name, birth_date, email, gender, create_at,blood_group)
VALUES ('Jane Smith', '1992-08-24', 'jane.smith@email.com', 'Female', CURRENT_TIMESTAMP,'A_POSITIVE');

INSERT INTO patient (name, birth_date, email, gender, create_at,blood_group)
VALUES ('Alex Jones', '1978-12-03', 'alex.jones@email.com', 'Non-binary', CURRENT_TIMESTAMP,'B_POSITIVE');

INSERT INTO patient (name, birth_date, email, gender, create_at,blood_group)
VALUES ('Sam Wilson', '2000-01-01', 'sam.w@email.com', 'Male', CURRENT_TIMESTAMP,'B_NEGATIVE');

INSERT INTO patient (name, birth_date, email, gender, create_at,blood_group)
VALUES ('Emily Brown', '1995-03-11', 'emily.b@email.com', 'Female', CURRENT_TIMESTAMP,'AB_POSITIVE');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Alice Smith', 'Pediatrics', 'alice.smith@hospital.com');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Robert Chen', 'Neurology', 'robert.chen@clinic.org');

INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Sarah Jenkins', 'Dermatology', 'sarah.jenkins@medical.net');