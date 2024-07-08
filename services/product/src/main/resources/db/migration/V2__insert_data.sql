INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Electronics gadgets and accessories', 'Electronics'),
    (nextval('category_seq'), 'Books of various genres and authors', 'Books'),
    (nextval('category_seq'), 'Furniture and home decor', 'Furniture');

-- Insert into product table with correct category IDs
INSERT INTO product (id, description, name, available_balance, price, category_id)
VALUES
    (nextval('product_seq'), 'Latest smartphone with 6GB RAM', 'Smartphone', 100, 299.99,
     (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Thriller novel by famous author', 'Thriller Book', 50, 19.99,
     (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 'Modern office desk', 'Office Desk', 20, 150.00,
     (SELECT id FROM category WHERE name = 'Furniture'));