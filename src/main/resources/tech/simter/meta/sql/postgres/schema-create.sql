create table document (
  id   serial primary key,
  type varchar(255) not null unique,
  name varchar(255)
);
comment on table document is 'The document';
comment on column document.type is 'The document type';
comment on column document.name is 'The document name';

create table operator (
  id   integer primary key,
  name varchar(255) not null
);
comment on table operator is 'The document operator';
comment on column operator.name is 'The operator name';

create table operation (
  id           serial primary key,
  type         integer     not null,
  operate_time timestamptz not null,
  operator_id  integer references operator,
  document_id  integer     not null references document,
  instance_id  integer     not null
);
comment on table operation is 'The operation';
comment on column operation.operate_time is 'The operate time';
comment on column operation.type is 'The operation type: 10-Creation, 20-Modification, 30-Confirmation, 40-Approval';
comment on column operation.operator_id is 'The operator ID';
comment on column operation.document_id is 'The document ID';
comment on column operation.instance_id is 'The document instance ID';
create index on operation (document_id, instance_id);