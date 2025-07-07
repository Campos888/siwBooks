INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(1, 1890, 1976, 'France', 'Agatha', 'Christie', '/images/author/Agatha.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(2, 1965, NULL, 'United Kingdom', 'J.K.', 'Rowling', '/images/author/jk_rowling.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(3, 1947, NULL, 'United States', 'Stephen', 'King', '/images/author/Stephen_King.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(4, 1828, 1910, 'Russia', 'Leo', 'Tolstoy', '/images/author/leo_Tolstoy.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(5, 1812, 1870, 'United Kingdom', 'Charles', 'Dickens', '/images/author/charles_dickens.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(6, 1920, 2012, 'Colombia', 'Gabriel', 'García Márquez', '/images/author/garcia_marquez.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(7, 1809, 1849, 'United States', 'Edgar Allan', 'Poe', '/images/author/allan_poe.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(8, 1948, NULL, 'United States', 'George R.R.', 'Martin', '/images/author/George_R._R._Martin.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(9, 1899, 1961, 'United States', 'Ernest', 'Hemingway', '/images/author/Ernest_Hemingway.jpg');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(10, 1973, NULL, 'Japan', 'Haruki', 'Murakami', '/images/author/murakami.jpeg');

-- i set id for new countries adding
SELECT setval('author_seq', (SELECT MAX(id) FROM author));
--

INSERT INTO book (id, publication_year, title, url_image) VALUES(1, 1920, 'The Mysterious Affair at Styles', '/images/book/theMysterousAffairAtStyles.jpg')
INSERT INTO book (id, publication_year, title, url_image) VALUES(2, 1997, 'Harry Potter and the Philosopher''s Stone', '/images/book/potter.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(3, 1986, 'It', '/images/book/it.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(4, 1869, 'War and Peace', '/images/book/warPace.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(5, 1843, 'A Christmas Carol', '/images/book/charlesDickens.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(6, 1967, 'One Hundred Years of Solitude', '/images/book/100anni.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(7, 1845, 'The Raven', '/images/book/raven.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(8, 1996, 'A Game of Thrones', '/images/book/GameofT.jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(9, 1952, 'The Old Man and the Sea', '/images/book/TheOldManandThesea,jpg');
INSERT INTO book (id, publication_year, title, url_image) VALUES(10, 2002, 'Kafka on the Shore', '/images/book/kafkaontheshore.jpg');

-- i set id for new countries adding
SELECT setval('book_seq', (SELECT MAX(id) FROM book));
--


INSERT INTO book_authors (books_id, authors_id) VALUES(1, 1);

INSERT INTO book_authors (books_id, authors_id) VALUES(2, 9);

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
