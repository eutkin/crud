insert into GENRES (GENRE_ID, GENRE)
values (1, 'Фантастика');

insert into PUBLISHERS (PUBLISHER_ID, PUBLISHER_NAME)
values (1, 'Космо');

insert into BOOKS (BOOK_ID, PUBLISH_DATE, SHORT_DESCRIPTION, GENRE_ID, PUBLISHER_ID)
values ('1257d7e8-4a6b-45b7-aa3d-3f3c6605d890', CURRENT_DATE, 'Фонд Открытие', 1, 1);

insert into AUTHORS (AUTHOR_ID, NAME)
values (1, 'Айзек Азимов');

insert into BOOKS_AUTHORS (AUTHOR_ID, BOOK_ID)
values (1, '1257d7e8-4a6b-45b7-aa3d-3f3c6605d890');

insert into USERS (LOGIN, DISPLAY_NAME, PASSWORD)
values ('eugene', 'Eugene', '$2a$10$r28sZP2ACs2bVD1gJ2VnU.OLo/WTMdNsIe6B95x.AynBGFnw9wCU6');

