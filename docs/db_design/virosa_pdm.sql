CREATE TABLE "category" (
  "id" bigserial,
  "name" varchar(255) NOT NULL,
  "cover" varchar(255) NOT NULL,
  "description" text,
  PRIMARY KEY ("id")
);

CREATE TABLE "collection" (
  "id" bigserial,
  "name" varchar(255) NOT NULL,
  "cover" varchar(255) NOT NULL,
  "description" text NOT NULL,
  "create_time" timestamptz NOT NULL,
  "update_time" timestamptz NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "column" (
  "id" bigserial,
  "name" varchar(255) NOT NULL,
  "cover" varchar(255) NOT NULL,
  "description" text NOT NULL,
  "create_time" timestamptz NOT NULL,
  "update_time" timestamptz NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "pin" (
  "id" bigserial,
  "content" text NOT NULL,
  "create_time" timestamptz NOT NULL,
  "update_time" timestamptz NOT NULL,
  "author_id" bigserial,
  PRIMARY KEY ("id")
);

CREATE TABLE "pin_comment" (
  "id" bigserial,
  "content" text NOT NULL,
  "upload_time" timestamptz NOT NULL,
  "author_id" bigserial,
  "pin_id" bigserial,
  "parent_id" bigserial,
  PRIMARY KEY ("id")
);

CREATE TABLE "pin_comment_like" (
  "comment_id" bigserial,
  "user_id" bigserial,
  PRIMARY KEY ("comment_id", "user_id")
);

CREATE TABLE "pin_like" (
  "pin_id" bigserial,
  "user_id" bigserial,
  PRIMARY KEY ("pin_id", "user_id")
);

CREATE TABLE "post" (
  "id" bigserial,
  "title" varchar(255) NOT NULL,
  "abstract" varchar(1000) NOT NULL,
  "cover" varchar(255) NOT NULL,
  "content" text NOT NULL,
  "create_time" timestamptz NOT NULL,
  "update_time" timestamptz NOT NULL,
  "cate_id" bigserial,
  "author_id" bigserial,
  PRIMARY KEY ("id")
);

CREATE TABLE "post_collection" (
  "post_id" bigserial,
  "collect_id" bigserial,
  PRIMARY KEY ("post_id", "collect_id")
);

CREATE TABLE "post_column" (
  "post_id" bigserial,
  "column_id" bigserial,
  PRIMARY KEY ("post_id", "column_id")
);

CREATE TABLE "post_comment" (
  "id" bigserial,
  "content" text NOT NULL,
  "upload_time" timestamptz NOT NULL,
  "author_id" bigserial,
  "post_id" bigserial,
  "parent_id" bigserial,
  PRIMARY KEY ("id")
);

CREATE TABLE "post_comment_like" (
  "comment_id" bigserial,
  "user_id" bigserial,
  PRIMARY KEY ("comment_id", "user_id")
);

CREATE TABLE "post_like" (
  "post_id" bigserial,
  "user_id" bigserial,
  PRIMARY KEY ("post_id", "user_id")
);

CREATE TABLE "post_tag" (
  "post_id" bigserial,
  "tag_id" bigserial,
  PRIMARY KEY ("post_id", "tag_id")
);

CREATE TABLE "role" (
  "id" bigserial,
  "name" varchar(255) NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "sys_user" (
  "id" bigserial,
  "username" varchar(255) NOT NULL,
  "password" varchar(255) NOT NULL,
  "avatar" varchar(255) NOT NULL,
  "bio" varchar(255),
  "homepage" varchar(255),
  "intro" varchar(255),
  "join_time" timestamptz NOT NULL,
  "role_id" bigserial,
  PRIMARY KEY ("id")
);

CREATE TABLE "tag" (
  "id" bigserial,
  "name" varchar(255) NOT NULL,
  "cover" varchar(255) NOT NULL,
  "description" text NOT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "tag_follow" (
  "tag_id" bigserial,
  "follower_id" bigserial,
  PRIMARY KEY ("tag_id", "follower_id")
);

CREATE TABLE "user_collection" (
  "user_id" bigserial,
  "collect_id" bigserial,
  "type" int2 NOT NULL,
  PRIMARY KEY ("user_id", "collect_id")
);

CREATE TABLE "user_column" (
  "user_id" bigserial,
  "column_id" bigserial,
  "type" int2 NOT NULL,
  PRIMARY KEY ("user_id", "column_id")
);

CREATE TABLE "user_follow" (
  "follower_id" bigserial,
  "followed_id" bigserial,
  PRIMARY KEY ("follower_id", "followed_id")
);
COMMENT ON TABLE "user_follow" IS 'follower -> followed
a -> b
a 关注了 b';

ALTER TABLE "pin" ADD CONSTRAINT "fk_pin_sys_user_1" FOREIGN KEY ("author_id") REFERENCES "sys_user" ("id");
ALTER TABLE "pin_comment" ADD CONSTRAINT "fk_pin_comment_sys_user_1" FOREIGN KEY ("author_id") REFERENCES "sys_user" ("id");
ALTER TABLE "pin_comment" ADD CONSTRAINT "fk_pin_comment_pin_1" FOREIGN KEY ("pin_id") REFERENCES "pin" ("id");
ALTER TABLE "pin_comment" ADD CONSTRAINT "fk_pin_comment_pin_comment_1" FOREIGN KEY ("parent_id") REFERENCES "pin_comment" ("id");
ALTER TABLE "pin_comment_like" ADD CONSTRAINT "fk_pin_comment_like_pin_comment_1" FOREIGN KEY ("comment_id") REFERENCES "pin_comment" ("id");
ALTER TABLE "pin_comment_like" ADD CONSTRAINT "fk_pin_comment_like_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("id");
ALTER TABLE "pin_like" ADD CONSTRAINT "fk_pin_like_pin_1" FOREIGN KEY ("pin_id") REFERENCES "pin" ("id");
ALTER TABLE "pin_like" ADD CONSTRAINT "fk_pin_like_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("id");
ALTER TABLE "post" ADD CONSTRAINT "fk_post_category_1" FOREIGN KEY ("cate_id") REFERENCES "category" ("id");
ALTER TABLE "post" ADD CONSTRAINT "fk_post_sys_user_1" FOREIGN KEY ("author_id") REFERENCES "sys_user" ("id");
ALTER TABLE "post_collection" ADD CONSTRAINT "fk_post_collection_post_1" FOREIGN KEY ("post_id") REFERENCES "post" ("id");
ALTER TABLE "post_collection" ADD CONSTRAINT "fk_post_collection_collection_1" FOREIGN KEY ("collect_id") REFERENCES "collection" ("id");
ALTER TABLE "post_column" ADD CONSTRAINT "fk_post_column_post_1" FOREIGN KEY ("post_id") REFERENCES "post" ("id");
ALTER TABLE "post_column" ADD CONSTRAINT "fk_post_column_column_1" FOREIGN KEY ("column_id") REFERENCES "column" ("id");
ALTER TABLE "post_comment" ADD CONSTRAINT "fk_post_comment_sys_user_1" FOREIGN KEY ("author_id") REFERENCES "sys_user" ("id");
ALTER TABLE "post_comment" ADD CONSTRAINT "fk_post_comment_post_1" FOREIGN KEY ("post_id") REFERENCES "post" ("id");
ALTER TABLE "post_comment" ADD CONSTRAINT "fk_post_comment_post_comment_1" FOREIGN KEY ("parent_id") REFERENCES "post_comment" ("id");
ALTER TABLE "post_comment_like" ADD CONSTRAINT "fk_post_comment_like_post_comment_1" FOREIGN KEY ("comment_id") REFERENCES "post_comment" ("id");
ALTER TABLE "post_comment_like" ADD CONSTRAINT "fk_post_comment_like_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("id");
ALTER TABLE "post_like" ADD CONSTRAINT "fk_post_like_post_1" FOREIGN KEY ("post_id") REFERENCES "post" ("id");
ALTER TABLE "post_like" ADD CONSTRAINT "fk_post_like_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("id");
ALTER TABLE "post_tag" ADD CONSTRAINT "fk_post_tag_post_1" FOREIGN KEY ("post_id") REFERENCES "post" ("id");
ALTER TABLE "post_tag" ADD CONSTRAINT "fk_post_tag_tag_1" FOREIGN KEY ("tag_id") REFERENCES "tag" ("id");
ALTER TABLE "sys_user" ADD CONSTRAINT "fk_sys_user_role_1" FOREIGN KEY ("role_id") REFERENCES "role" ("id");
ALTER TABLE "tag_follow" ADD CONSTRAINT "fk_tag_follow_tag_1" FOREIGN KEY ("tag_id") REFERENCES "tag" ("id");
ALTER TABLE "tag_follow" ADD CONSTRAINT "fk_tag_follow_sys_user_1" FOREIGN KEY ("follower_id") REFERENCES "sys_user" ("id");
ALTER TABLE "user_collection" ADD CONSTRAINT "fk_user_collection_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("username");
ALTER TABLE "user_collection" ADD CONSTRAINT "fk_user_collection_collection_1" FOREIGN KEY ("collect_id") REFERENCES "collection" ("id");
ALTER TABLE "user_column" ADD CONSTRAINT "fk_user_column_sys_user_1" FOREIGN KEY ("user_id") REFERENCES "sys_user" ("id");
ALTER TABLE "user_column" ADD CONSTRAINT "fk_user_column_column_1" FOREIGN KEY ("column_id") REFERENCES "column" ("id");
ALTER TABLE "user_follow" ADD CONSTRAINT "fk_user_follow_sys_user_1" FOREIGN KEY ("follower_id") REFERENCES "sys_user" ("id");
ALTER TABLE "user_follow" ADD CONSTRAINT "fk_user_follow_sys_user_2" FOREIGN KEY ("followed_id") REFERENCES "sys_user" ("id");

