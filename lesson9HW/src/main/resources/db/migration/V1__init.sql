CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), article_number int, PRIMARY KEY (id));
INSERT INTO products (title, cost, article_number)
VALUES
    ('Product1', 10, 10021300),
    ('Product2', 15, 10021300),
    ('Product3', 20, 10021300),
    ('Product4', 2, 10021300),
    ('Product5', 19, 10021300),
    ('Product6', 25, 10021300),
    ('Product7', 40, 10021300),
    ('Product8', 55, 10021300),
    ('Product9', 17, 10021300),
    ('Product10', 85, 10021300),
    ('Product11', 27, 10021300),
    ('Product12', 5, 10021300),
    ('Product13', 105, 10021300),
    ('Product14', 155, 10021300),
    ('Product15', 30, 10021300),
    ('Product16', 7, 10021300),
    ('Product17', 19, 10021300),
    ('Product18', 65, 10021300),
    ('Product19', 29, 10021300),
    ('Product20', 3, 10021300),
    ('Product21', 33, 10021300);