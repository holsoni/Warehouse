create table person
(
    id bigint not null
        constraint person_pkey
            primary key,
    date_of_birth varchar(255),
    email varchar(255),
    name varchar(255),
    surname varchar(255),
    telephone varchar(255)
);

alter table person owner to postgres;


create table producer
(
    id bigint not null
        constraint producer_pkey
            primary key,
    address varchar(255),
    country varchar(255),
    rating double precision not null,
    telephone varchar(255),
    person_id bigint
        constraint fk76fdw3jqk958ql2v830yotti3
            references person
);

alter table producer owner to postgres;

create table deal
(
    id bigint not null
        constraint deal_pkey
            primary key,
    date_of_deal timestamp,
    deal_durability_in_month integer not null,
    sum_of_deal double precision not null,
    producer_id bigint
        constraint fka41o62y4tpffta5hdx63n474f
            references producer
);

alter table deal owner to postgres;

create table delivery
(
    id bigint not null
        constraint delivery_pkey
            primary key,
    address varchar(255),
    name_of_company varchar(255),
    sum double precision not null,
    person_id bigint
        constraint fktdx2souogj7ijji3rkkgtj50r
            references person
);
alter table delivery owner to postgres;

create table accounting
(
    id         varchar(255) not null
        constraint accounting_pkey
            primary key,
    conclusion varchar(255),
    date       varchar(255),
    giving_out boolean      not null,
    receiving  boolean      not null,
    goods_id   bigint
        constraint fk4og9c9psbqml0bi3k8dko1dy2
            references goods
);

alter table accounting
    owner to postgres;

create table goods
(
    id bigint not null
        constraint goods_pkey
            primary key,
    name varchar(255),
    num double precision not null,
    purchase_price_per_unit double precision not null,
    selling_price_per_unit double precision not null,
    units_of_measurement varchar(255),
    producer_id bigint
        constraint fkrai80r9jsygpyiji1nekk3fb5
            references producer
);

alter table goods owner to postgres;

create table goods_for_delivery
(
    delivery_id bigint not null
        constraint fkohh65hr1t2pavdhd93s82lt4f
            references delivery,
    goods_id bigint not null
        constraint fkee59c9b1kk8ijkuqa2htcxne3
            references goods,
    constraint goods_for_delivery_pkey
        primary key (delivery_id, goods_id)
);

alter table goods_for_delivery owner to postgres;
create table orders
(
    id bigint not null
        constraint orders_pkey
            primary key,
    sum double precision not null,
    person_id bigint
        constraint fk1b0m4muwx1t377w9if3w6wwqn
            references person,
    producer_id bigint
        constraint fkar9ula1iatds678hhe5oupdrj
            references producer
);

alter table orders owner to postgres;


create table goods_to_order
(
    order_id bigint not null
        constraint fkhygflj50s1w08rvphg15acik4
            references orders,
    goods_id bigint not null
        constraint fk9xkyc766uswd9askb58yprci8
            references goods,
    constraint goods_to_order_pkey
        primary key (order_id, goods_id)
);

alter table goods_to_order owner to postgres;



