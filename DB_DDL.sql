DROP DATABASE IF EXISTS cartpool;
CREATE DATABASE cartpool;
USE cartpool;

CREATE TABLE cart_pool (
    id INTEGER NOT NULL AUTO_INCREMENT,
    pool_id VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    zip VARCHAR(5) NOT NULL,
    leader INTEGER NOT NULL,
    creation_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE user (
    id INTEGER NOT NULL AUTO_INCREMENT,
    email VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR(500) NOT NULL,
    screen_name VARCHAR(50) UNIQUE NOT NULL,
    nickname VARCHAR(50) UNIQUE NOT NULL,
    pool_id INTEGER,
    contribution INTEGER DEFAULT 0,
	role VARCHAR(20) NOT NULL,
	active BOOLEAN DEFAULT FALSE,
    token VARCHAR(32) UNIQUE,
    creation_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (pool_id)
        REFERENCES cart_pool (id)
            ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE store (
	id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zip VARCHAR(5),
    PRIMARY KEY (id)
);

CREATE TABLE product (
	id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    image_url VARCHAR(255),
    brand VARCHAR(50),
    category VARCHAR(50),
    unit VARCHAR(50),
    price DOUBLE PRECISION,
    PRIMARY KEY (id)
);

CREATE TABLE inventory (
    store_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (store_id, product_id),
    FOREIGN KEY (store_id)
        REFERENCES store (id)
            ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (product_id)
        REFERENCES product (id)
            ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE user_order (
    id INTEGER NOT NULL AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    pool_id INTEGER NOT NULL,
    store_id INTEGER NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    status VARCHAR(10) NOT NULL,
    pickup_method VARCHAR(10) NOT NULL,
    pickup_user INTEGER,
    street VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(5) NOT NULL,
    creation_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    checkout_time DATETIME,
    due_time DATETIME,
    pickup_time DATETIME,
    delivered_time DATETIME,
    update_time DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES user (id)
            ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (pool_id)
        REFERENCES cart_pool (id)
            ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (store_id)
        REFERENCES store (id)
            ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE order_details (
    order_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    tax_fee DOUBLE PRECISION,
    price DOUBLE PRECISION,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id)
        REFERENCES user_order (id)
            ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (product_id)
        REFERENCES product (id)
            ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO `cartpool`.`user` (`id`,`email`,`password`,`screen_name`,`nickname`,`pool_id`,`contribution`,`role`,`active`,`token`,`creation_time`) VALUES (1,'test1@abc.com','123','test1','test1',NULL,0,'USER',0,NULL,'2020-04-28 00:31:39');
INSERT INTO `cartpool`.`user` (`id`,`email`,`password`,`screen_name`,`nickname`,`pool_id`,`contribution`,`role`,`active`,`token`,`creation_time`) VALUES (2,'test2@abc.com','123','test2','test2',NULL,0,'USER',0,NULL,'2020-04-28 00:31:39');
INSERT INTO `cartpool`.`user` (`id`,`email`,`password`,`screen_name`,`nickname`,`pool_id`,`contribution`,`role`,`active`,`token`,`creation_time`) VALUES (3,'test3@abc.com','$2a$10$h/pToxzXG2DNonewt2S.9eaZHn0X1/vLdhyzeuTJJoJ21BeK9au/6','test3','test3',NULL,NULL,'ROLE_USER',1,NULL,'2020-04-28 07:53:37');
INSERT INTO `cartpool`.`user` (`id`,`email`,`password`,`screen_name`,`nickname`,`pool_id`,`contribution`,`role`,`active`,`token`,`creation_time`) VALUES (4,'test4@abc.com','$2a$10$pjdTfSCavHKw9T82t6wdA.3/TgYMnVp9JPr2rVGwudXeoxgZM41qG','test4','test4',NULL,NULL,'ROLE_ADMIN',1,NULL,'2020-04-28 07:53:50');
INSERT INTO `cartpool`.`user` (`id`,`email`,`password`,`screen_name`,`nickname`,`pool_id`,`contribution`,`role`,`active`,`token`,`creation_time`) VALUES (9,'test5@abc.com','$2a$10$nshXGyPb58BEXMYm6Sa/fei6PZKVBMmNhyGKuEMEefHz5IgX.6/Wa','test5','test5',NULL,NULL,'ROLE_USER',0,'55c10f1cd7964289ad1333f126eed876','2020-04-30 12:06:57');

INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('milk', 'milk desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'acd', 'd', 'L', '9.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('egg', 'egg desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'ddd', 'd', 'L', '12.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('tea', 'tea desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'aaa', 'm', 'L', '5.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('milk2', 'milk desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'acd', 'd', 'L', '9.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('egg2', 'egg desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'ddd', 'd', 'L', '12.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('tea2', 'tea desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'aaa', 'm', 'L', '5.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('milk3', 'milk desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'acd', 'd', 'L', '9.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('egg3', 'egg desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'ddd', 'd', 'L', '12.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('tea3', 'tea desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'aaa', 'm', 'L', '5.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('milk4', 'milk desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'acd', 'd', 'L', '9.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('egg4', 'egg desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'ddd', 'd', 'L', '12.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('tea4', 'tea desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'aaa', 'm', 'L', '5.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('milk5', 'milk desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'acd', 'd', 'L', '9.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('egg5', 'egg desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'ddd', 'd', 'L', '12.99');
INSERT INTO `cartpool`.`product` (`name`, `description`, `image_url`, `brand`, `category`, `unit`, `price`) VALUES ('tea5', 'tea desc', 'https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png', 'aaa', 'm', 'L', '5.99');

INSERT INTO `cartpool`.`store` (`name`, `street`, `city`, `state`, `zip`) VALUES ('STORE1', '123 street', 'city1', 'CA', '99999');
INSERT INTO `cartpool`.`store` (`name`, `street`, `city`, `state`, `zip`) VALUES ('STORE2', '567 ave', 'city2', 'CA', '88888');
INSERT INTO `cartpool`.`store` (`name`, `street`, `city`, `state`, `zip`) VALUES ('STORE3', '333 street', 'city1', 'CA', '77777');

INSERT INTO `cartpool`.`cart_pool` (`id`,`pool_id`,`name`,`neighborhood`,`description`,`zip`,`leader`,`creation_time`) VALUES (2,'pool1','Mypool','abc def','dwwd','33333',3,NULL);
INSERT INTO `cartpool`.`cart_pool` (`id`,`pool_id`,`name`,`neighborhood`,`description`,`zip`,`leader`,`creation_time`) VALUES (3,'pool2','Mypool2','DDDDDDD','fdsfdsfsd','11111',3,NULL);
INSERT INTO `cartpool`.`cart_pool` (`id`,`pool_id`,`name`,`neighborhood`,`description`,`zip`,`leader`,`creation_time`) VALUES (4,'pool3','Mypool3','safsdfas','fdsjaifd  jfo adjs','12345',3,NULL);

INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (1,1,0);
INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (1,2,0);
INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (1,3,0);
INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (2,1,0);
INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (2,3,0);
INSERT INTO `cartpool`.`inventory` (`store_id`,`product_id`,`quantity`) VALUES (2,10,1);

INSERT INTO `cartpool`.`user_order` (`id`,`user_id`,`pool_id`,`store_id`,`amount`,`status`,`pickup_method`,`pickup_user`,`street`,`city`,`state`,`zip`,`creation_time`,`checkout_time`,`due_time`,`pickup_time`,`delivered_time`,`update_time`) VALUES (5,1,2,1,100,'0','SELF',1,'a','a','a','1','2020-05-03 23:25:40',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `cartpool`.`user_order` (`id`,`user_id`,`pool_id`,`store_id`,`amount`,`status`,`pickup_method`,`pickup_user`,`street`,`city`,`state`,`zip`,`creation_time`,`checkout_time`,`due_time`,`pickup_time`,`delivered_time`,`update_time`) VALUES (6,1,2,1,200,'0','SELF',1,'a','a','a','1','2020-05-03 23:25:40',NULL,NULL,NULL,NULL,NULL);
INSERT INTO `cartpool`.`user_order` (`id`,`user_id`,`pool_id`,`store_id`,`amount`,`status`,`pickup_method`,`pickup_user`,`street`,`city`,`state`,`zip`,`creation_time`,`checkout_time`,`due_time`,`pickup_time`,`delivered_time`,`update_time`) VALUES (7,1,2,1,100,'0','SELF',1,'a','a','a','1','2020-05-04 07:26:34',NULL,NULL,NULL,NULL,NULL);

INSERT INTO `cartpool`.`order_details` (`order_id`,`product_id`,`quantity`,`tax_fee`,`price`) VALUES (5,1,2,NULL,NULL);
INSERT INTO `cartpool`.`order_details` (`order_id`,`product_id`,`quantity`,`tax_fee`,`price`) VALUES (5,2,1,NULL,NULL);
INSERT INTO `cartpool`.`order_details` (`order_id`,`product_id`,`quantity`,`tax_fee`,`price`) VALUES (6,5,4,NULL,NULL);



