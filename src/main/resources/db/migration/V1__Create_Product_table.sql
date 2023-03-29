CREATE TABLE tb_product
(
  product_id SERIAL NOT NULL PRIMARY KEY ,
  product_name VARCHAR(255) NOT NULL,
  product_price DECIMAL(10,2) NOT NULL,
  product_created_at timestamp without time zone NOT NULL default now(),
  updated_at timestamp without time zone NOT NULL default now()
);

CREATE OR REPLACE FUNCTION update_timestamp()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = now();
    RETURN NEW;
END;
$$ language 'plpgsql';
CREATE TRIGGER update_product_timestamp BEFORE UPDATE ON tb_product FOR EACH ROW EXECUTE PROCEDURE  update_timestamp();