-- Insert authors
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(1, 2003, NULL, 'Portugal', 'Martina', 'Caspiselli', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(2, 2004, NULL, 'Egypt', 'Concettina', 'Bevalacqua', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(3, 2001, 2025, 'Serbia', 'Nicola', 'Campifallo', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(4, 1998, NULL, 'Nigeria', 'Osy', 'Mendes', '');
INSERT INTO author (id, born_date, death_date, nationality, name, surname, url_image) VALUES(5, 2001, NULL, 'Spain', 'Mateo', 'suertudo', '');





-- Insert books
INSERT INTO book (id, publication_year, title, url_images) VALUES(1, 2025, 'Plains in my veins', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(2, 2023, 'How to become the boss of your friend group', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(3, 2025, 'The lost friendship', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(4, 2024, 'A bath in the Tevere', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(5, 2023, 'The man in the middle', '{}');
INSERT INTO book (id, publication_year, title, url_images) VALUES(6, 2025, 'How to answer a phone call', '{}');




-- Insert relations in join table (books_authors)
INSERT INTO book_authors (books_id, authors_id) VALUES(1, 1);
INSERT INTO book_authors (books_id, authors_id) VALUES(2, 2);
INSERT INTO book_authors (books_id, authors_id) VALUES(3, 2);
INSERT INTO book_authors (books_id, authors_id) VALUES(3, 3);
INSERT INTO book_authors (books_id, authors_id) VALUES(4, 3);
INSERT INTO book_authors (books_id, authors_id) VALUES(5, 4);
INSERT INTO book_authors (books_id, authors_id) VALUES(6, 5);
