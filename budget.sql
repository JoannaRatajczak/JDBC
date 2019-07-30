CREATE TABLE transaction (id INT auto_increment PRIMARY KEY, 
type VARCHAR(50) NOT NULL, 
description VARCHAR(250), 
amount DECIMAL(7,2), 
date DATE);
INSERT INTO transaction (type, description, amount, date) VALUES 
('wydatek', 'Lidl', 234.77, '2019-07-30'),
('wydatek', 'Lidl', 55.66, '2019-07-29'),
('przychod', 'wyplata', 2500, '2019-07-28'); 
