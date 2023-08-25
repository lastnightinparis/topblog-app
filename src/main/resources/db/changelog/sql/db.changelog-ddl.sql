--liquibase formatted sql

--changeset kirill:1
CREATE TABLE IF NOT EXISTS tg_record (
    id bigint primary key,
    image text not null,
    metric bigint not null
);

CREATE TABLE IF NOT EXISTS vk_record (
    id bigint primary key,
    image text not null,
    metric bigint not null
);

CREATE TABLE IF NOT EXISTS yt_record (
    id bigint primary key,
    image text not null,
    metric bigint not null
);

CREATE TABLE IF NOT EXISTS zn_record (
    id bigint primary key,
    image text not null,
    metric bigint not null
);

CREATE SEQUENCE IF NOT EXISTS tg_record_seq START 1 INCREMENT 50;
CREATE SEQUENCE IF NOT EXISTS vk_record_seq START 1 INCREMENT 50;
CREATE SEQUENCE IF NOT EXISTS yt_record_seq START 1 INCREMENT 50;
CREATE SEQUENCE IF NOT EXISTS zn_record_seq START 1 INCREMENT 50;