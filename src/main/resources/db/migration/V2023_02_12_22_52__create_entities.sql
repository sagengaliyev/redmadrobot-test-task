CREATE TABLE _user
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    status     VARCHAR(255),
    role       VARCHAR(255),
    CONSTRAINT pk__user PRIMARY KEY (id)
);

CREATE TABLE advertisement
(
    id                   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title                VARCHAR(255),
    description          VARCHAR(255),
    minimum_price        DECIMAL,
    advertisement_status VARCHAR(255),
    CONSTRAINT pk_advertisement PRIMARY KEY (id)
);

CREATE TABLE advertisement_images
(
    advertisement_id BIGINT NOT NULL,
    images_id        BIGINT NOT NULL
);

CREATE TABLE file_entity
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title         VARCHAR(255),
    data          BYTEA,
    type          VARCHAR(255),
    uploaded_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_file_entity PRIMARY KEY (id)
);

CREATE TABLE user_advertisements
(
    user_id           BIGINT NOT NULL,
    advertisements_id BIGINT NOT NULL
);

ALTER TABLE _user
    ADD CONSTRAINT uc__user_email UNIQUE (email);

ALTER TABLE advertisement_images
    ADD CONSTRAINT uc_advertisement_images_images UNIQUE (images_id);

ALTER TABLE user_advertisements
    ADD CONSTRAINT uc_user_advertisements_advertisements UNIQUE (advertisements_id);

ALTER TABLE advertisement_images
    ADD CONSTRAINT fk_advima_on_advertisement FOREIGN KEY (advertisement_id) REFERENCES advertisement (id);

ALTER TABLE advertisement_images
    ADD CONSTRAINT fk_advima_on_file_entity FOREIGN KEY (images_id) REFERENCES file_entity (id);

ALTER TABLE user_advertisements
    ADD CONSTRAINT fk_useadv_on_advertisement FOREIGN KEY (advertisements_id) REFERENCES advertisement (id);

ALTER TABLE user_advertisements
    ADD CONSTRAINT fk_useadv_on_user FOREIGN KEY (user_id) REFERENCES _user (id);