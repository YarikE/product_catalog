CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name TEXT,
  description TEXT,
  price DOUBLE PRECISION,
  image_id TEXT,
  category_id INT,
  add_date DATE,
  status BOOLEAN
);