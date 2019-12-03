CREATE table section
(
    section_id   BIGSERIAL PRIMARY KEY ,
    name varchar not null
);

CREATE table category
(
    category_id   BIGSERIAL PRIMARY KEY ,
    name varchar not null ,
    description varchar not null ,
    section_id BIGINT not null,
    FOREIGN KEY (section_id) REFERENCES section(section_id)
);

create table photo
(
    photo_id   BIGSERIAL PRIMARY KEY ,
    photo varchar not null
);

CREATE table auction
(
    auction_id   BIGSERIAL PRIMARY KEY,
    title varchar not null ,
    description varchar not null ,
    price money not null,
    profile_id BIGINT not null,
    category_id BIGINT not null,
    FOREIGN KEY (profile_id) REFERENCES profile (id),
    foreign key (category_id) REFERENCES category (category_id)
);


create table auction_photo
(
    auction_id BIGINT not null ,
    photo_id BIGINT not null,
    FOREIGN KEY (auction_id) REFERENCES auction (auction_id),
    foreign key (photo_id) REFERENCES photo (photo_id)
);

create table parameter
(
    parameter_id  BIGSERIAL PRIMARY KEY,
    description varchar not null
);
create table auction_parameter
(
    auction_id  BIGINT NOT NULL ,
    parameter_id  BIGINT NOT NULL ,
    values varchar not null,
    FOREIGN KEY (auction_id) REFERENCES auction (auction_id),
    foreign key (parameter_id) REFERENCES parameter (parameter_id)
);