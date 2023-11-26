CREATE TABLE professor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(320) NOT NULL,
);

CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    carga_horaria INT NOT NULL,
    status VARCHAR(255) NOT NULL,
    id_professor INT REFERENCES professor(id)
);

CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(320) NOT NULL,
    status VARCHAR(255) NOT NULL
);

CREATE TABLE curso_aluno (
    id_curso INT REFERENCES curso(id),
    id_aluno INT REFERENCES aluno(id),
    nota FLOAT,
    PRIMARY KEY (id_curso, id_aluno)
);

CREATE TABLE curso_professor (
    id_curso INT REFERENCES curso(id),
    id_professor INT REFERENCES professor(id),
    PRIMARY KEY (id_curso, id_professor)
);


