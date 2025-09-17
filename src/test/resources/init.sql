CREATE TABLE book
(
    id       BIGSERIAL PRIMARY KEY,
    title    VARCHAR(255) NOT NULL,
    author   VARCHAR(255) NOT NULL,
    language VARCHAR(255) NOT NULL
);

INSERT INTO book(title, author, language)
VALUES ('Don Quixote', 'Miguel de Cervantes', 'Spanish'),
       ('Pride and Prejudice', 'Jane Austen', 'English'),
       ('Les Miserables', 'Victor Hugo', 'French'),
       ('The Metamorphosis', 'Franz Kafka', 'German'),
       ('The Trial', 'Franz Kafka', 'German'),
       ('The Trial', 'Orson Welles', 'English'),
       ('The Little Prince', 'Antoine de Saint-Exupery', 'French'),
       ('One Hundred Years of Solitude', 'Gabriel Garcia Marquez', 'Spanish'),
       ('The Tale of Genji', 'Murasaki Shikibu', 'Japanese'),
       ('Kalevipoeg', 'Friedrich Reinhold Kreutzwald', 'Estonian');