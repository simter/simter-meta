create table document (
  id   integer auto_increment primary key,
  type varchar(255) not null unique                  comment 'The document type',
  name varchar(255)                                  comment 'The document Name'
) comment = 'The document';

create table operator (
  id   integer primary key,
  name varchar(255) not null                         comment 'The operator name'
) comment = 'The document operator';

create table operation (
  id           integer auto_increment primary key,
  type         integer not null                      comment 'The operation type: 10-Creation, 20-Modification, 30-Confirmation, 40-Approval',
  operate_time datetime not null                     comment 'The operate time',
  operator_id  integer                               comment 'The operator ID',
  document_id  integer not null                      comment 'The document ID',
  instance_id  integer  not null                     comment 'The document instance ID',
  foreign key (operator_id) references operator(id),
  foreign key (document_id) references document(id)
) comment = 'The operation';
create index operation_document on operation (document_id, instance_id);