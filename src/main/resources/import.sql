INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(1, 1890, 1976, 'France', 'Agatha', 'Christie', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(2, 1965, NULL, 'United Kingdom', 'J.K.', 'Rowling', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(3, 1947, NULL, 'United States', 'Stephen', 'King', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(4, 1828, 1910, 'Russia', 'Leo', 'Tolstoy', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(5, 1812, 1870, 'United Kingdom', 'Charles', 'Dickens', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(6, 1920, 2012, 'Colombia', 'Gabriel', 'García Márquez', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(7, 1809, 1849, 'United States', 'Edgar Allan', 'Poe', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(8, 1948, NULL, 'United States', 'George R.R.', 'Martin', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(9, 1899, 1961, 'United States', 'Ernest', 'Hemingway', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(10, 1973, NULL, 'Japan', 'Haruki', 'Murakami', '');


INSERT INTO book (id, publication_year, title, url_images) VALUES(1, 1920, 'The Mysterious Affair at Styles', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(2, 1997, 'Harry Potter and the Philosopher''s Stone', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(3, 1986, 'It', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(4, 1869, 'War and Peace', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(5, 1843, 'A Christmas Carol', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(6, 1967, 'One Hundred Years of Solitude', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(7, 1845, 'The Raven', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(8, 1996, 'A Game of Thrones', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(9, 1952, 'The Old Man and the Sea', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(10, 2002, 'Kafka on the Shore', '{}');



INSERT INTO book_authors (books_id, authors_id) VALUES(1, 1);
INSERT INTO book_authors (books_id, authors_id) VALUES(2, 2);
INSERT INTO book_authors (books_id, authors_id) VALUES(3, 3);
INSERT INTO book_authors (books_id, authors_id) VALUES(4, 4);
INSERT INTO book_authors (books_id, authors_id) VALUES(5, 5);
INSERT INTO book_authors (books_id, authors_id) VALUES(6, 6);
INSERT INTO book_authors (books_id, authors_id) VALUES(7, 7);
INSERT INTO book_authors (books_id, authors_id) VALUES(8, 8);
INSERT INTO book_authors (books_id, authors_id) VALUES(9, 9);
INSERT INTO book_authors (books_id, authors_id) VALUES(10, 10);

--admin password:"a"
INSERT INTO users (id, name, surname, email) VALUES (nextval('users_seq'), 'admin', 'admin', 'admin@admin.com');
INSERT INTO credentials (id, username, password, role, user_id) VALUES (nextval('credentials_seq'), 'admin','$2a$10$t2IKSFIwQXZPe4GtNGpzuu5DlTYFIYBIy1lUbxyNYbm0MS2YpFQU.','ADMIN', currval('users_seq'));




--users password:"p"
INSERT INTO users (id, name, surname, email) VALUES (nextval('users_seq'), 'p', 'p', 'p');
INSERT INTO credentials (id, username, password, role, user_id) VALUES (nextval('credentials_seq'), 'p','$2a$10$yo5IFu4/ET4S7P8Fe5KEZeRPiARzRDw.VaCg4NR4rXMRFG1j2xZli','DEFAULT', currval('users_seq'));
