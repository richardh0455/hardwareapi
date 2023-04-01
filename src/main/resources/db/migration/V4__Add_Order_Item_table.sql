CREATE TABLE tb_order_item (
    orit_id SERIAL NOT NULL PRIMARY KEY ,
    orit_order_id int NOT NULL,
    orit_product_id int NOT NULL,
    orit_quantity int NOT NULL,
    orit_price numeric(10,2) NOT NULL,
    orit_status varchar(20) NOT NULL,
    orit_created_at timestamp without time zone NOT NULL default now(),
    updated_at timestamp without time zone NOT NULL default now()
);

CREATE TRIGGER update_order_item_timestamp BEFORE UPDATE ON tb_order_item FOR EACH ROW EXECUTE PROCEDURE  update_timestamp();