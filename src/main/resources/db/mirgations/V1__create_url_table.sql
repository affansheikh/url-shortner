create table urls (
    id bigint auto_increment primary key,
    url_identifier int not null,
    url varchar(255) not null,
    created_at datetime not null default NOW(),

    unique urls_unique_url_identifier(url_identifier)
);