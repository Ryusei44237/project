CREATE DATABASE application;

CREATE TABLE account(

    id VARCHAR(255),                /**アカウントID**/
    name VARCHAR(256),          /**アカウント名**/
    mail VARCHAR(256),          /**メールアドレス**/
    password VARCHAR(256),      /**パスワード**/
    birthday date,              /**生年月日**/
    tell VARCHAR(256),          /**電話番号**/
    token VARCHAR(256),         /**ログイン情報保持**/
    create_at date,             /**作成日時**/
    update_at date,             /**更新日時**/
    PRIMARY KEY(id)

);


CREATE TABLE post(

    id int(255),                /**投稿ID**/
    contents VARCHAR(256),      /**投稿内容**/
    tags_id int(255),          /**投稿タグ**/
    account_id int(255),        /**アカウントID**/
    address VARCHAR(256),       /**投稿場所**/
    create_at date,             /**作成日時**/
    PRIMARY KEY(id)

);


CREATE TABLE tags(

    id int(255),                /**タグ識別**/
    name VARCHAR(256),          /**タグ名が重複しないように**/
    UNIQUE(name),
    PRIMARY KEY(id)

);


CREATE TABLE post_tags(

    id int(255),                /**タグ紐づけ識別**/
    post_id int(255),           /**タグがつけられた記事のID**/
    tags_id int(255),           /**記事につけられたタグのID**/
    PRIMARY KEY(id),
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(tags_id) REFERENCES tags(id)

);



/**テスト**/
INSERT INTO account VALUE(1,'test','test@morijyobi.ac.jp','testaccount','2020-01-01','08012345678','','2020-08-08','2020-09-09');  /**テストアカウント**/

INSERT INTO post VALUE(1,'これはテストです',1,1,'xxxxx','2020-10-10');

INSERT INTO tags VALUE(1,'台風');

INSERT INTO post_tags VALUE(1,1,1);

alter table post add index id(id);
alter table tags add index id(id);


SELECT post_id, tags_id FROM post_tags WHERE tags_id


