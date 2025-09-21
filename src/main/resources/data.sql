-- =====================
-- ADDRESSES
-- =====================
INSERT INTO addresses (id, city, country, postal_code, state, street)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Aleksandrów Kujawski', 'Polska', '87-700', 'kujawsko-pomorskie', 'Konwaliowa 5'),
    ('22222222-2222-2222-2222-222222222222', 'Toruń', 'Polska', '87-100', 'kujawsko-pomorskie', 'Kościuszki 10');

-- =====================
-- CATEGORIES
-- =====================
INSERT INTO categories (name, description, image, is_featured)
VALUES
    ('Makramy', 'Ręcznie robione makramy', 'macrame-category.jpg', 1),
    ('Łapacze snów', 'Ręcznie robione łapacze snów', 'dream-catchers-category.jpg', 1),
    ('Kwietniki', 'Makramy do doniczek', 'flowerbed-category.jpg', 1);

-- =====================
-- PRODUCTS
-- =====================
INSERT INTO products (id, name, description, price, image, category_name)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Makrama ścienna Boho', 'Ręcznie robiona makrama, długość 120 cm', 120, 'macrame-category.jpg', 'Makramy'),
    ('22222222-2222-2222-2222-222222222222', 'Makrama do doniczki średnia', 'Makrama do doniczki o średnicy 15 cm', 50, 'macrame-category.jpg', 'Makramy'),
    ('33333333-3333-3333-3333-333333333333', 'Brelok makrama', 'Mały brelok do kluczy z makramy', 20, 'macrame-category.jpg', 'Makramy');
-- =====================
-- CUSTOMERS
-- =====================
INSERT INTO customers (id, first_name, last_name, email, password, phone, address_id)
VALUES
    ('c1111111-1111-1111-1111-111111111111', 'Jan', 'Kowalski', 'jan.kowalski@email.com','$2a$04$A7azIMpHGS5/9XPe/eKqX.gTagPF4KgV4eMGBwPa0CQgcTyxUE9pG', '123456789',
     '11111111-1111-1111-1111-111111111111'),
    ('c2222222-2222-2222-2222-222222222222', 'Anna', 'Nowak', 'anna.nowak@email.com', '12','987654321',
     '22222222-2222-2222-2222-222222222222');


INSERT INTO roles (id, name)
    VALUES ('11122222-2222-1111-2222-222222222222', 'USER'),('33322222-3333-1111-2222-222222222222', 'ADMIN');
-- -- =====================
-- -- ORDERS
-- -- =====================
-- INSERT INTO orders (id, customer_id)
-- VALUES
--     ('o1111111-1111-1111-1111-111111111111', 'c1111111-1111-1111-1111-111111111111'),
--     ('o2222222-2222-2222-2222-222222222222', 'c2222222-2222-2222-2222-222222222222');
--
-- -- =====================
-- -- ORDER_PRODUCT
-- -- =====================
    INSERT INTO customers_roles (customer_id, roles_id)
VALUES ('c1111111-1111-1111-1111-111111111111','11122222-2222-1111-2222-222222222222')
-- INSERT INTO order_product (id, order_id, product_id, quantity)
-- VALUES
--     ('op111111-1111-1111-1111-111111111111', 'o1111111-1111-1111-1111-111111111111', 'p1111111-1111-1111-1111-111111111111', 1),
--     ('op222222-2222-2222-2222-222222222222', 'o1111111-1111-1111-1111-111111111111', 'p3333333-3333-3333-3333-333333333333', 2),
--     ('op333333-3333-3333-3333-333333333333', 'o2222222-2222-2222-2222-222222222222', 'p2222222-2222-2222-2222-222222222222', 1);
--
-- -- =====================
-- -- ORDERS_ORDER_ITEMS (łączenie many-to-many)
-- -- =====================
-- INSERT INTO orders_order_items (order_id, order_items_id)
-- VALUES
--     ('o1111111-1111-1111-1111-111111111111', 'op111111-1111-1111-1111-111111111111'),
--     ('o1111111-1111-1111-1111-111111111111', 'op222222-2222-2222-2222-222222222222'),
--     ('o2222222-2222-2222-2222-222222222222', 'op333333-3333-3333-3333-333333333333');
