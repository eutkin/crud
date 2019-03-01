create table authors (
  author_id bigint       not null,
  name      varchar(255) not null,
  primary key (author_id)
);
create table genres (
  genre_id bigint not null,
  genre    varchar(255),
  primary key (genre_id)
);

create table publishers (
  publisher_id   bigint       not null,
  publisher_name varchar(255) not null,
  primary key (publisher_id)
);

create table books (
  book_id           UUID        not null,
  publish_date      date,
  short_description varchar(1000) not null,
  genre_id          bigint references genres(genre_id),
  publisher_id      bigint references publishers(publisher_id),
  primary key (book_id)
);

create table users (
  login        varchar(255) not null,
  display_name varchar(255),
  password     varchar(255),
  primary key (login)
);

create table booklists (
  booklist_id UUID not null,
  name        varchar(255),
  author      varchar(255) references users(login),
  primary key (booklist_id)
);

create table booklists_books (
  booklist_id binary not null references booklists(booklist_id),
  book_id     binary not null references books(book_id),
  primary key (booklist_id, book_id)
);

create table booklists_users (
  booklist_id UUID       not null references booklists(booklist_id),
  login       varchar(255) not null references users(login),
  primary key (booklist_id, login)
);

create table books_authors (
  book_id   UUID not null references books(book_id),
  author_id UUID not null references authors(author_id),
  primary key (book_id, author_id)
);
