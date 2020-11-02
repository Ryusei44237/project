CREATE DATABASE application;

CREATE TABLE account(

    id int(256),                /**アカウントID**/
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

    id int(256),                /**投稿ID**/
    contents VARCHAR(256),      /**投稿内容**/
    account_id VARCHAR(256),　　/**アカウントID**/
    address VARCHAR(256),       /**投稿場所**/
    create_at date,             /**作成日時**/
    PRIMARY KEY(id)

);


CREATE TABLE tags(

    id int(256),                /**タグ識別**/
    name VARCHAR(256),          /**タグ名が重複しないように**/
    UNIQUE(name),
    PRIMARY KEY(id)

);


CREATE TABLE post_tags(

    id int(256),                /**タグ紐づけ識別**/
    post_id int(256),           /**タグがつけられた記事のID**/
    tags_id int(256),           /**記事がつけられた記事のID**/
    PRIMARY KEY(id)

);

