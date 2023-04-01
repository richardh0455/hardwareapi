CREATE TABLE tb_order (
    order_id SERIAL NOT NULL PRIMARY KEY ,
    order_customer_id int NOT NULL,
    order_created_at timestamp without time zone NOT NULL default now(),
    order_status varchar(255) NOT NULL,
    updated_at timestamp without time zone NOT NULL default now()
);

CREATE TRIGGER update_order_timestamp BEFORE UPDATE ON tb_order FOR EACH ROW EXECUTE PROCEDURE  update_timestamp();