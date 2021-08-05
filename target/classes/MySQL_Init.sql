-- drop
DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS favorite;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS item_topping;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS topping;
DROP TABLE IF EXISTS temp_limit;
DROP TABLE IF EXISTS temp_level;
DROP TABLE IF EXISTS sugar_limit;
DROP TABLE IF EXISTS sugar_level;
DROP TABLE IF EXISTS tag_product;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS company;

-- create
-- company
CREATE TABLE IF NOT EXISTS company
(
  company_id          VARCHAR(10),
  company_name        VARCHAR(20),
  company_account     VARCHAR(20),
  company_password    VARCHAR(20),
  company_owner       VARCHAR(20),
  company_owner_email VARCHAR(40) UNIQUE KEY,
  start_time          TIME,
  end_time            TIME,
  tel                 VARCHAR(20),
  company_address     VARCHAR(75),
  website             VARCHAR(50),
  company_iconpath    VARCHAR(255),
  company_filename    VARCHAR(20),
  tax_id_number       VARCHAR(10),
  register_date       DATETIME,
  alter_date          DATETIME,
  CONSTRAINT company_company_id_id_PK PRIMARY KEY (company_id)
);

-- customer
CREATE TABLE IF NOT EXISTS customer
(
  customer_id         INT AUTO_INCREMENT,
  customer_password   VARCHAR(20),
  sign_date           DATETIME,
  customer_name       VARCHAR(20),
  birthday            DATE,
  email               VARCHAR(40) UNIQUE KEY,
  customer_address    VARCHAR(75),
  alter_date          DATETIME,
  invitation          VARCHAR(10),
  weight              DECIMAL(4,1),
  CONSTRAINT customer_customer_id_PK PRIMARY KEY (customer_id)
);

-- category
CREATE TABLE IF NOT EXISTS category
(
  category_id	      INT AUTO_INCREMENT,
  company_id          VARCHAR(10),
  category_name       VARCHAR(20) NOT NULL,
  CONSTRAINT category_category_id_PK PRIMARY KEY (category_id),
  CONSTRAINT category_company_id_FK FOREIGN KEY(company_id) REFERENCES company (company_id)
);

-- product
CREATE TABLE IF NOT EXISTS product
(
  product_id          INT AUTO_INCREMENT,
  company_id          VARCHAR(10),
  product_name        VARCHAR(20) NOT NULL,
  product_price       INT NOT NULL,
  capacity            VARCHAR(5) NOT NULL,
  product_cal         INT NOT NULL,
  category            INT,
  product_picname     VARCHAR(20),
  product_picpath     VARCHAR(255),
  add_date            DATETIME,
  alter_date          DATETIME,
  CONSTRAINT product_product_id_PK PRIMARY KEY (product_id),
  CONSTRAINT product_company_id_FK FOREIGN KEY(company_id) REFERENCES company (company_id),
  CONSTRAINT product_category_FK FOREIGN KEY(category) REFERENCES category (category_id)
);

-- tag_product
CREATE TABLE IF NOT EXISTS tag_product
(
  tg_seq              INT AUTO_INCREMENT,
  product_id          INT NOT NULL,
  tag_name            VARCHAR(20),
  CONSTRAINT tag_product_tg_seq_PK PRIMARY KEY (tg_seq),
  CONSTRAINT tag_product_product_id_FK FOREIGN KEY (product_id) REFERENCES product (product_id)
);

-- sugar_level
CREATE TABLE IF NOT EXISTS sugar_level
(
  sugar_id            INT,
  sugar_level	      VARCHAR(20) UNIQUE,
  factor              DECIMAL(2,1) UNIQUE,
  CONSTRAINT sugar_level_sugar_id_PK PRIMARY KEY (sugar_id)
);

-- sugar_limit
CREATE TABLE IF NOT EXISTS sugar_limit
(
  sl_seq              INT AUTO_INCREMENT,
  product_id          INT,
  sugar_id            INT,
  CONSTRAINT sugar_limit_sl_seq_PK PRIMARY KEY (sl_seq),
  CONSTRAINT sugar_limit_product_id_FK FOREIGN KEY(product_id) REFERENCES product (product_id),
  CONSTRAINT sugar_limit_sugar_id_FK FOREIGN KEY(sugar_id) REFERENCES sugar_level (sugar_id)
);

-- temp_level
CREATE TABLE IF NOT EXISTS temp_level
(
  temp_id             INT,
  temp_level          VARCHAR(20) UNIQUE,
  CONSTRAINT temp_level_temp_id_PK PRIMARY KEY (temp_id)
);

-- temp_limit
CREATE TABLE IF NOT EXISTS temp_limit
(
  tl_seq              INT AUTO_INCREMENT,
  product_id          INT,
  temp_id             INT,
  CONSTRAINT temp_limit_tl_seq_PK PRIMARY KEY (tl_seq),
  CONSTRAINT temp_limit_product_id_FK FOREIGN KEY(product_id) REFERENCES product (product_id),
  CONSTRAINT temp_limit_temp_id_FK FOREIGN KEY(temp_id) REFERENCES temp_level (temp_id)
);

-- topping
CREATE TABLE IF NOT EXISTS topping
(
  topping_id          INT AUTO_INCREMENT,
  topping_name        VARCHAR(20) NOT NULL,
  topping_cal	      INT NOT NULL,
  topping_price       INT NOT NULL,
  company_id          VARCHAR(10),
  topping_picname     VARCHAR(20),
  topping_picpath     VARCHAR(255),
  CONSTRAINT topping_topping_id_PK PRIMARY KEY (topping_id),
  CONSTRAINT topping_company_id_FK FOREIGN KEY(company_id) REFERENCES company (company_id)
);

-- orders
CREATE TABLE IF NOT EXISTS orders
(
  order_id            INT AUTO_INCREMENT,
  customer_id         INT,
  order_date          DATETIME,
  pickup_date         DATETIME,
  company_id          VARCHAR(10),
  order_quantity      INT,
  order_total         INT,
  payment             VARCHAR(20),
  order_text          VARCHAR(60),
  receipt             VARCHAR(20),
  CONSTRAINT orders_order_id_PK PRIMARY KEY (order_id),
  CONSTRAINT orders_customer_FK FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT orders_company_FK FOREIGN KEY (company_id) REFERENCES company (company_id)
);

-- item
CREATE TABLE IF NOT EXISTS item
(
  item_id             INT AUTO_INCREMENT,
  order_id            INT,
  product_id          INT,
  temp_id             INT,
  sugar_id            INT,
  capacity            VARCHAR(5),
  item_cal            INT,
  price               INT,
  note                VARCHAR(60),
  add_to_health       BOOLEAN,
  CONSTRAINT item_item_id_PK PRIMARY KEY (item_id),
  CONSTRAINT item_order_id_FK FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT item_product_id_FK FOREIGN KEY (product_id) REFERENCES product (product_id),
  CONSTRAINT item_temp_id_FK FOREIGN KEY (temp_id) REFERENCES temp_level (temp_id),
  CONSTRAINT item_sugar_id_FK FOREIGN KEY (sugar_id) REFERENCES sugar_level (sugar_id)
);

-- item_topping
CREATE TABLE IF NOT EXISTS item_topping
(
  i_t_seq             INT AUTO_INCREMENT,
  item_id             INT,
  topping_id          INT,
  CONSTRAINT item_topping_i_t_seq_PK PRIMARY KEY (i_t_seq),
  CONSTRAINT item_topping_topping_FK FOREIGN KEY (topping_id) REFERENCES topping (topping_id),
  CONSTRAINT item_topping_item_FK FOREIGN KEY (item_id) REFERENCES item (item_id)
);

-- comments
CREATE TABLE IF NOT EXISTS comments
(
  comment_id          INT AUTO_INCREMENT,
  order_id            INT,
  product_id          INT,
  comment_date        DATETIME,
  customer_id         INT,
  comment_picname     VARCHAR(20),
  comment_picpath     VARCHAR(255),
  star                DECIMAL(2,1),
  feedback            VARCHAR(100),
  CONSTRAINT comments_comment_id_PK PRIMARY KEY (comment_id),
  CONSTRAINT comments_orders_FK FOREIGN KEY (order_id) REFERENCES orders (order_id),
  CONSTRAINT comments_customer_FK FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT comments_product_FK FOREIGN KEY (product_id) REFERENCES product (product_id)
);

-- favorite
CREATE TABLE IF NOT EXISTS favorite
(
  f_seq               INT AUTO_INCREMENT,
  customer_id         INT NOT NULL,
  company_id          VARCHAR(10),
  CONSTRAINT favorite_f_seq_PK PRIMARY KEY (f_seq),
  CONSTRAINT favorite_customer_id_FK FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT favorite_company_id_FK FOREIGN KEY (company_id) REFERENCES company (company_id)
);

-- workout
CREATE TABLE IF NOT EXISTS workout
(
  workout             VARCHAR(20),
  consumption         DECIMAL(3,1),
  CONSTRAINT workout_workout_PK PRIMARY KEY (workout)
);