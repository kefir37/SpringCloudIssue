CREATE TABLE IF NOT EXISTS product(
    id uuid primary key not null,
    title varchar(255) not null unique,
    description varchar(255)
);