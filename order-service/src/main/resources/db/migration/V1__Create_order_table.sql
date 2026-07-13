CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    order_date_time TIMESTAMP NOT NULL,
    status VARCHAR(30) NOT NULL
);