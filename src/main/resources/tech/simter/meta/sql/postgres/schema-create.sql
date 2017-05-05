create table meta_type (
  id   serial primary key,
  type varchar(255) not null unique,
  name varchar(255)
);
comment on table meta_type is 'Meta Type';
comment on column meta_type.type is 'MetaType identity, like "creation", "modification"';
comment on column meta_type.name is 'MetaType Name';

create table meta_doc (
  id   serial primary key,
  type varchar(255) not null unique,
  name varchar(255)
);
comment on table meta_doc is 'Meta Document';
comment on column meta_doc.type is 'Meta Document Type';
comment on column meta_doc.name is 'Meta Document Name';

create table meta_history (
  id        serial primary key,
  time      timestamptz not null,
  actor     integer,
  meta_type integer     not null references meta_type,
  meta_doc  integer     not null references meta_doc,
  doc_id    integer     not null
);
comment on table meta_history is 'Meta Info';
comment on column meta_history.time is 'creation time';
comment on column meta_history.actor is 'creator';
comment on column meta_history.meta_type is 'Meta Type';
comment on column meta_history.meta_doc is 'Document Type';
comment on column meta_history.doc_id is 'Document instance id';
create index on meta_history (meta_doc, doc_id);