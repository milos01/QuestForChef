INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Admin');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Regular user');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Cook');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Barman');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Manager');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Bidder');
INSERT INTO `questforchef`.`Roles` (`roleName`) VALUES ('Waiter');
INSERT INTO `questforchef`.`Users` (`email`, `enabled`, `firstName`, `lastName`, `password`, `tokenExpired`, `role_id`) VALUES ('milosa942@gmail.com', 1, 'Milos', 'Andric', 'pass', 1, '2');
INSERT INTO `questforchef`.`Users` (`email`, `enabled`, `firstName`, `lastName`, `password`, `tokenExpired`, `role_id`) VALUES ('miloso@gmail.com', 1, 'Milos', 'Obradovic', 'pass', 1, '1');
INSERT INTO `questforchef`.`Users` (`email`, `enabled`, `firstName`, `lastName`, `password`, `tokenExpired`, `role_id`) VALUES ('micko@gmail.com', 1, 'Micko', 'Mickovic', 'pass', 1, '2');
INSERT INTO `questforchef`.`Users` (`email`, `enabled`, `firstName`, `lastName`, `password`, `tokenExpired`, `role_id`) VALUES ('waiter@gmail.com', 1, 'Iks', 'Ipsilonovic', 'pass', 1, '7');
INSERT INTO `questforchef`.`Users` (`email`, `enabled`, `firstName`, `lastName`, `password`, `tokenExpired`, `role_id`) VALUES ('mladen@gmail.com', 1, 'Mladen', 'Doslic', 'pass', 1, '5');
INSERT INTO `questforchef`.`Restaurants` (`address`, `desription`, `email`, `name`, `phone`, `open_hours`, `rate`,`city`,`reon_num`) VALUES ('Momcila Tapavice 18',     'Cl reduct malar/zygo fx', 'hgarrett3@ed.gov',   'Twitternation', '380-(257)526-4752', '09-21h','4','Novi Sad','4');
INSERT INTO `questforchef`.`Restaurants` (`address`, `desription`, `email`, `name`, `phone`, `open_hours`, `rate`,`city`,`reon_num`) VALUES ('Tihomira Ostojica 4',     'Local excis rectal les',  'mwoods4@mozilla.com','Brightbean',    '348-(881)503-7377', '08-20h', '5','Novi Sad','4');
INSERT INTO `questforchef`.`Restaurants` (`address`, `desription`, `email`, `name`, `phone`, `open_hours`, `rate`,`city`,`reon_num`) VALUES ('06427 Waxwing Place',     'Ovarian biopsy NEC',      'lday1@japanpost.jp', 'Meevee',        '355-(119)203-3363', '08-20h', '5','Novi Sad','4');
INSERT INTO `questforchef`.`Restaurants` (`address`, `desription`, `email`, `name`, `phone`, `open_hours`, `rate`,`city`,`reon_num`) VALUES ('99140 Doe Crossing Lane', 'resacral sympathectomy',  'wwells2@phpbb.com',  'Meembee',       '351-(108)619-6647', '08-20h', '4', 'Novi Sad','5');
INSERT INTO `questforchef`.`Restaurants` (`address`, `desription`, `email`, `name`, `phone`, `open_hours`, `rate`,`city`,`reon_num`) VALUES ('9025 Sutteridge Street',  'Cl reduct malar/zygo fx', 'hgarrett3@ed.gov',   'Twitternation', '380-(257)526-4752', '08-20h', '4', 'Novi Sad','5');
INSERT INTO `questforchef`.`Staff` (`birth_date`, `con_num`, `email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`, `picture_path`) VALUES ('1994-11-11', 'XL', 'mladen@gmail.com', 'Mladen', 'Doslic', 'pass', '42', '1', '5', 'a1.jpg');
INSERT INTO `questforchef`.`Staff` (`birth_date`,`email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`,`con_num`, `picture_path`) VALUES ('1994-11-11','pera@gmail.com', 'Pera', 'Peric', 'pass', '34', '2', '5','L', 'a2.jpg');
UPDATE `questforchef`.`Staff` SET `con_num`='cc' WHERE `id`='2';
INSERT INTO `questforchef`.`Friends` (`terminal_friend`, `starter_friend`) VALUES ('3', '1');
INSERT INTO `questforchef`.`Friends` (`terminal_friend`, `starter_friend`) VALUES ('1', '3');
INSERT INTO `questforchef`.`Staff` (`birth_date`,`email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`,`con_num`, `picture_path`) VALUES ('22-09-1994','ivan@gmail.com', 'Ivan', 'ivanovic', 'pass', '34', '1', '3','L', 'a3.jpg');
INSERT INTO `questforchef`.`Staff` (`birth_date`,`email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`,`con_num`, `picture_path`) VALUES ('22-09-1993','mika@gmail.com', 'Miki', 'Mikic', 'pass', '42', '1', '4','XL', 'a4.jpg');
INSERT INTO `questforchef`.`Staff` (`birth_date`,`email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`,`con_num`, `picture_path`) VALUES ('22-09-1994','jova@gmail.com', 'Jova', 'Jovic', 'pass', '34', '1', '6','L', 'a5.jpg');
INSERT INTO `questforchef`.`Staff` (`birth_date`,`email`, `firstName`, `lastName`, `password`, `shoe_num`, `restaurant_id`, `role_id`,`con_num`, `picture_path`) VALUES ('22-09-1994','tomica@gmail.com', 'Toma', 'Tomic', 'pass', '42', '2', '4','XL', 'a6.jpg');