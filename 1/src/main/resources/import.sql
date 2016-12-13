INSERT INTO cuisine (name) VALUES ("Polish");
INSERT INTO cuisine (name) VALUES ("Mexican");
INSERT INTO cuisine (name) VALUES ("Italian");

INSERT INTO drink (name, price, cuisine_id) VALUES ("Tea", 10.0, 1);
INSERT INTO addition (name, price, drink_id) VALUES ("Lemon", 0.0, 1);
INSERT INTO addition (name, price, drink_id) VALUES ("Ice cubes", 0.0, 1);
INSERT INTO drink (name, price, cuisine_id) VALUES ("Tequila", 20.0, 2);
INSERT INTO addition (name, price, drink_id) VALUES ("Orange", 0.0, 2);
INSERT INTO addition (name, price, drink_id) VALUES ("Worm", 0.0, 2);
INSERT INTO drink (name, price, cuisine_id) VALUES ("Wine", 30.0, 3);
INSERT INTO addition (name, price, drink_id) VALUES ("Spices", 0.0, 3);
INSERT INTO addition (name, price, drink_id) VALUES ("More spices", 0.0, 3);

INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Bigos", 31.0, "DISH", 1);
INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Bigos Cake", 21.0, "DESSERT", 1);
INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Tortilla", 32.0, "DISH", 2);
INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Tortilla Cake", 22.0, "DESSERT", 2);
INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Spaghetti", 33.0, "DISH", 3);
INSERT INTO meal (name, price, type, cuisine_id) VALUES ("Spaghetti Cake", 23.0, "DESSERT", 3);