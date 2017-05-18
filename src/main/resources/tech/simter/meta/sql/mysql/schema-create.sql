create table meta_type (
  id   integer auto_increment primary key,
  type varchar(255) not null unique                    comment 'MetaType identity, like "creation", "modification"',
  name varchar(255)                                    comment 'MetaType Name'
) comment = 'Meta Type';

create table meta_doc (
  id   integer auto_increment primary key,
  type varchar(255) not null unique                    comment 'Meta Document Type',
  name varchar(255)                                    comment 'Meta Document Name'
) comment = 'Meta Document';

create table meta_history (
  id           integer auto_increment primary key,
  time         datetime not null                       comment 'creation time',
  actor        integer                                 comment 'creator',
  meta_type_id integer  not null                       comment 'Meta Type ID',
  meta_doc_id  integer  not null                       comment 'Document Type ID',
  doc_id       integer  not null                       comment 'Document instance ID',
  foreign key (meta_type_id) references meta_type(id),
  foreign key (meta_doc_id)  references meta_doc(id)
) comment = 'Meta Info';
create index meta_history_doc on meta_history (meta_doc_id, doc_id);