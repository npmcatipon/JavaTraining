CREATE TABLE students (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	age INT,
	email VARCHAR(100) UNIQUE
);

CREATE TABLE courses (
    id SERIAL NOT NULL,
    student_id INT,
    course_name VARCHAR(50),
    grade VARCHAR(2),
    PRIMARY KEY (id),
    FOREIGN KEY (student_id) REFERENCES students(id)
);
