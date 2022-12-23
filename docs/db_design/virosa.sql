/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2022/12/23 23:32:56                          */
/*==============================================================*/


drop index category_PK;

drop table category;

drop index collection_PK;

drop table collection;

drop index post_collection_FK;

drop index post_collection2_FK;

drop index collection_post_PK;

drop table collection_post;

drop index column_PK;

drop table "column";

drop index column_post_FK;

drop index column_post2_FK;

drop index column_post_PK;

drop table column_post;

drop index user_pin_author_FK;

drop index pin_PK;

drop table pin;

drop index user_post_author_FK;

drop index post_category_FK;

drop index post_PK;

drop table post;

drop index post_tag_FK;

drop index post_tag2_FK;

drop index post_tag_PK;

drop table post_tag;

drop index role_PK;

drop table role;

drop index user_role_FK;

drop index sys_user_PK;

drop table sys_user;

drop index tag_PK;

drop table tag;

drop index user_collection_FK;

drop index user_collection2_FK;

drop index user_collection_PK;

drop table user_collection;

drop index user_column_FK;

drop index user_column2_FK;

drop index user_column_PK;

drop table user_column;

drop index pin_comment_parent_FK;

drop index user_pin_comment_FK;

drop index user_pin_comment2_FK;

drop index user_pin_comment_PK;

drop table user_pin_comment;

drop index post_comment_parent_FK;

drop index user_post_comment_FK;

drop index user_post_comment2_FK;

drop index user_post_comment_PK;

drop table user_post_comment;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category (
   cid                  INT8                 not null,
   cate_name            VARCHAR(200)         not null,
   cate_cover           VARCHAR(200)         null,
   cate_descrip         TEXT                 null,
   constraint PK_CATEGORY primary key (cid)
);

/*==============================================================*/
/* Index: category_PK                                           */
/*==============================================================*/
create unique index category_PK on category (
cid
);

/*==============================================================*/
/* Table: collection                                            */
/*==============================================================*/
create table collection (
   collect_id           INT8                 not null,
   collect_name         VARCHAR(200)         null,
   create_time          DATE                 null,
   update_time          DATE                 null,
   collect_descrip      TEXT                 null,
   collect_cover        VARCHAR(200)         null,
   constraint PK_COLLECTION primary key (collect_id)
);

/*==============================================================*/
/* Index: collection_PK                                         */
/*==============================================================*/
create unique index collection_PK on collection (
collect_id
);

/*==============================================================*/
/* Table: collection_post                                       */
/*==============================================================*/
create table collection_post (
   collect_id           INT8                 not null,
   post_id              INT8                 not null,
   constraint PK_COLLECTION_POST primary key (collect_id, post_id)
);

/*==============================================================*/
/* Index: collection_post_PK                                    */
/*==============================================================*/
create unique index collection_post_PK on collection_post (
collect_id,
post_id
);

/*==============================================================*/
/* Index: post_collection2_FK                                   */
/*==============================================================*/
create  index post_collection2_FK on collection_post (
post_id
);

/*==============================================================*/
/* Index: post_collection_FK                                    */
/*==============================================================*/
create  index post_collection_FK on collection_post (
collect_id
);

/*==============================================================*/
/* Table: "column"                                              */
/*==============================================================*/
create table "column" (
   column_id            INT8                 not null,
   column_name          VARCHAR(200)         null,
   create_time          DATE                 null,
   update_time          DATE                 null,
   column_descrip       TEXT                 null,
   column_cover         VARCHAR(200)         null,
   constraint PK_COLUMN primary key (column_id)
);

/*==============================================================*/
/* Index: column_PK                                             */
/*==============================================================*/
create unique index column_PK on "column" (
column_id
);

/*==============================================================*/
/* Table: column_post                                           */
/*==============================================================*/
create table column_post (
   column_id            INT8                 not null,
   post_id              INT8                 not null,
   constraint PK_COLUMN_POST primary key (column_id, post_id)
);

/*==============================================================*/
/* Index: column_post_PK                                        */
/*==============================================================*/
create unique index column_post_PK on column_post (
column_id,
post_id
);

/*==============================================================*/
/* Index: column_post2_FK                                       */
/*==============================================================*/
create  index column_post2_FK on column_post (
post_id
);

/*==============================================================*/
/* Index: column_post_FK                                        */
/*==============================================================*/
create  index column_post_FK on column_post (
column_id
);

/*==============================================================*/
/* Table: pin                                                   */
/*==============================================================*/
create table pin (
   pin_id               INT8                 not null,
   uid                  INT8                 not null,
   pin_content          TEXT                 null,
   upload_time          DATE                 null,
   constraint PK_PIN primary key (pin_id)
);

/*==============================================================*/
/* Index: pin_PK                                                */
/*==============================================================*/
create unique index pin_PK on pin (
pin_id
);

/*==============================================================*/
/* Index: user_pin_author_FK                                    */
/*==============================================================*/
create  index user_pin_author_FK on pin (
uid
);

/*==============================================================*/
/* Table: post                                                  */
/*==============================================================*/
create table post (
   post_id              INT8                 not null,
   cid                  INT8                 not null,
   uid                  INT8                 not null,
   title                VARCHAR(200)         not null,
   summary              VARCHAR(500)         not null,
   cover                VARCHAR(200)         not null,
   post_content         TEXT                 null,
   create_time          DATE                 null,
   update_time          DATE                 null,
   constraint PK_POST primary key (post_id)
);

/*==============================================================*/
/* Index: post_PK                                               */
/*==============================================================*/
create unique index post_PK on post (
post_id
);

/*==============================================================*/
/* Index: post_category_FK                                      */
/*==============================================================*/
create  index post_category_FK on post (
cid
);

/*==============================================================*/
/* Index: user_post_author_FK                                   */
/*==============================================================*/
create  index user_post_author_FK on post (
uid
);

/*==============================================================*/
/* Table: post_tag                                              */
/*==============================================================*/
create table post_tag (
   tid                  INT8                 not null,
   post_id              INT8                 not null,
   constraint PK_POST_TAG primary key (tid, post_id)
);

/*==============================================================*/
/* Index: post_tag_PK                                           */
/*==============================================================*/
create unique index post_tag_PK on post_tag (
tid,
post_id
);

/*==============================================================*/
/* Index: post_tag2_FK                                          */
/*==============================================================*/
create  index post_tag2_FK on post_tag (
post_id
);

/*==============================================================*/
/* Index: post_tag_FK                                           */
/*==============================================================*/
create  index post_tag_FK on post_tag (
tid
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role (
   rid                  INT8                 not null,
   role_name            VARCHAR(20)          not null,
   constraint PK_ROLE primary key (rid)
);

/*==============================================================*/
/* Index: role_PK                                               */
/*==============================================================*/
create unique index role_PK on role (
rid
);

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user (
   uid                  INT8                 not null,
   rid                  INT8                 not null,
   username             VARCHAR(25)          not null,
   password             VARCHAR(200)         not null,
   avatar               VARCHAR(200)         not null,
   bio                  VARCHAR(200)         null,
   homepage             VARCHAR(200)         null,
   intro                TEXT                 null,
   join_time            DATE                 not null,
   constraint PK_SYS_USER primary key (uid)
);

/*==============================================================*/
/* Index: sys_user_PK                                           */
/*==============================================================*/
create unique index sys_user_PK on sys_user (
uid
);

/*==============================================================*/
/* Index: user_role_FK                                          */
/*==============================================================*/
create  index user_role_FK on sys_user (
rid
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag (
   tid                  INT8                 not null,
   tag_name             VARCHAR(200)         null,
   tag_cover            TEXT                 null,
   tag_descrip          TEXT                 null,
   constraint PK_TAG primary key (tid)
);

/*==============================================================*/
/* Index: tag_PK                                                */
/*==============================================================*/
create unique index tag_PK on tag (
tid
);

/*==============================================================*/
/* Table: user_collection                                       */
/*==============================================================*/
create table user_collection (
   collect_id           INT8                 not null,
   uid                  INT8                 not null,
   collect_type         BOOL                 null,
   constraint PK_USER_COLLECTION primary key (collect_id, uid)
);

/*==============================================================*/
/* Index: user_collection_PK                                    */
/*==============================================================*/
create unique index user_collection_PK on user_collection (
collect_id,
uid
);

/*==============================================================*/
/* Index: user_collection2_FK                                   */
/*==============================================================*/
create  index user_collection2_FK on user_collection (
uid
);

/*==============================================================*/
/* Index: user_collection_FK                                    */
/*==============================================================*/
create  index user_collection_FK on user_collection (
collect_id
);

/*==============================================================*/
/* Table: user_column                                           */
/*==============================================================*/
create table user_column (
   column_id            INT8                 not null,
   uid                  INT8                 not null,
   column_type          BOOL                 null,
   constraint PK_USER_COLUMN primary key (column_id, uid)
);

/*==============================================================*/
/* Index: user_column_PK                                        */
/*==============================================================*/
create unique index user_column_PK on user_column (
column_id,
uid
);

/*==============================================================*/
/* Index: user_column2_FK                                       */
/*==============================================================*/
create  index user_column2_FK on user_column (
uid
);

/*==============================================================*/
/* Index: user_column_FK                                        */
/*==============================================================*/
create  index user_column_FK on user_column (
column_id
);

/*==============================================================*/
/* Table: user_pin_comment                                      */
/*==============================================================*/
create table user_pin_comment (
   pc_id                INT8                 not null,
   uid                  INT8                 not null,
   pin_id               INT8                 not null,
   parent_pc_id         INT8                 null,
   pc_content           TEXT                 null,
   pc_upload_time       DATE                 null,
   constraint PK_USER_PIN_COMMENT primary key (pc_id)
);

/*==============================================================*/
/* Index: user_pin_comment_PK                                   */
/*==============================================================*/
create unique index user_pin_comment_PK on user_pin_comment (
pc_id
);

/*==============================================================*/
/* Index: user_pin_comment2_FK                                  */
/*==============================================================*/
create  index user_pin_comment2_FK on user_pin_comment (
pin_id
);

/*==============================================================*/
/* Index: user_pin_comment_FK                                   */
/*==============================================================*/
create  index user_pin_comment_FK on user_pin_comment (
uid
);

/*==============================================================*/
/* Index: pin_comment_parent_FK                                 */
/*==============================================================*/
create  index pin_comment_parent_FK on user_pin_comment (
parent_pc_id
);

/*==============================================================*/
/* Table: user_post_comment                                     */
/*==============================================================*/
create table user_post_comment (
   comment_id           INT8                 not null,
   uid                  INT8                 not null,
   post_id              INT8                 not null,
   parent_comment_id    INT8                 null,
   c_content            TEXT                 null,
   c_upload_time        DATE                 null,
   constraint PK_USER_POST_COMMENT primary key (comment_id)
);

/*==============================================================*/
/* Index: user_post_comment_PK                                  */
/*==============================================================*/
create unique index user_post_comment_PK on user_post_comment (
comment_id
);

/*==============================================================*/
/* Index: user_post_comment2_FK                                 */
/*==============================================================*/
create  index user_post_comment2_FK on user_post_comment (
post_id
);

/*==============================================================*/
/* Index: user_post_comment_FK                                  */
/*==============================================================*/
create  index user_post_comment_FK on user_post_comment (
uid
);

/*==============================================================*/
/* Index: post_comment_parent_FK                                */
/*==============================================================*/
create  index post_comment_parent_FK on user_post_comment (
parent_comment_id
);

alter table collection_post
   add constraint FK_COLLECTI_POST_COLL_COLLECTI foreign key (collect_id)
      references collection (collect_id)
      on delete restrict on update restrict;

alter table collection_post
   add constraint FK_COLLECTI_POST_COLL_POST foreign key (post_id)
      references post (post_id)
      on delete restrict on update restrict;

alter table column_post
   add constraint FK_COLUMN_P_COLUMN_PO_COLUMN foreign key (column_id)
      references "column" (column_id)
      on delete restrict on update restrict;

alter table column_post
   add constraint FK_COLUMN_P_COLUMN_PO_POST foreign key (post_id)
      references post (post_id)
      on delete restrict on update restrict;

alter table pin
   add constraint FK_PIN_USER_PIN__SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table post
   add constraint FK_POST_POST_CATE_CATEGORY foreign key (cid)
      references category (cid)
      on delete restrict on update restrict;

alter table post
   add constraint FK_POST_USER_POST_SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table post_tag
   add constraint FK_POST_TAG_POST_TAG_TAG foreign key (tid)
      references tag (tid)
      on delete restrict on update restrict;

alter table post_tag
   add constraint FK_POST_TAG_POST_TAG2_POST foreign key (post_id)
      references post (post_id)
      on delete restrict on update restrict;

alter table sys_user
   add constraint FK_SYS_USER_USER_ROLE_ROLE foreign key (rid)
      references role (rid)
      on delete restrict on update restrict;

alter table user_collection
   add constraint FK_USER_COL_USER_COLL_COLLECTI foreign key (collect_id)
      references collection (collect_id)
      on delete restrict on update restrict;

alter table user_collection
   add constraint FK_USER_COL_USER_COLL_SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table user_column
   add constraint FK_USER_COL_USER_COLU_COLUMN foreign key (column_id)
      references "column" (column_id)
      on delete restrict on update restrict;

alter table user_column
   add constraint FK_USER_COL_USER_COLU_SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table user_pin_comment
   add constraint FK_USER_PIN_PIN_COMME_USER_PIN foreign key (parent_pc_id)
      references user_pin_comment (pc_id)
      on delete restrict on update restrict;

alter table user_pin_comment
   add constraint FK_USER_PIN_USER_PIN__SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table user_pin_comment
   add constraint FK_USER_PIN_USER_PIN__PIN foreign key (pin_id)
      references pin (pin_id)
      on delete restrict on update restrict;

alter table user_post_comment
   add constraint FK_USER_POS_POST_COMM_USER_POS foreign key (parent_comment_id)
      references user_post_comment (comment_id)
      on delete restrict on update restrict;

alter table user_post_comment
   add constraint FK_USER_POS_USER_POST_SYS_USER foreign key (uid)
      references sys_user (uid)
      on delete restrict on update restrict;

alter table user_post_comment
   add constraint FK_USER_POS_USER_POST_POST foreign key (post_id)
      references post (post_id)
      on delete restrict on update restrict;

