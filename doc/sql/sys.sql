create table sys_user
(
    id          bigint primary key,
    username    varchar(64),
    nickname    varchar(64),
    password    varchar(255),
    sex         smallint,
    phone       varchar(16),
    email       varchar(64),
    avatar      varchar(255),
    status      tinyint,
    create_by   varchar(64),
    create_time timestamp not null default current_timestamp,
    update_by   varchar(64),
    update_time timestamp not null default current_timestamp on update current_timestamp
);