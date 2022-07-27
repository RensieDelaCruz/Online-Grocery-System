CREATE DATABASE `grocerymanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE grocerymanagementsystem;
CREATE TABLE `payment_type` (
  `payment_type_id` char(1) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_type_id`),
  UNIQUE KEY `payment_type_id_UNIQUE` (`payment_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
INSERT INTO `grocerymanagementsystem`.`payment_type` (`payment_type_id`, `description`) VALUES ('C', 'Credit Card');
INSERT INTO `grocerymanagementsystem`.`payment_type` (`payment_type_id`, `description`) VALUES ('M', 'Cash On Delivery');

USE grocerymanagementsystem;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `payment_type` char(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time_stamp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_paymenttype_idx` (`payment_type`),
  CONSTRAINT `payment_paymenttype` FOREIGN KEY (`payment_type`) REFERENCES `payment_type` (`payment_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


USE grocerymanagementsystem;
CREATE TABLE `payment_cash` (
  `payment_id` int NOT NULL,
  `amount` double(6,2) NOT NULL,
  PRIMARY KEY (`payment_id`),
  CONSTRAINT `payment_paymentcash` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `payment_creditcard` (
  `payment_id` int NOT NULL,
  `name_on_creditcard` varchar(45) DEFAULT NULL,
  `creditcard_no` bigint NOT NULL,
  `exp_date` varchar(5) NOT NULL,
  `cvv` varchar(45) NOT NULL,
  `amount` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  CONSTRAINT `payment_paymentcreditcard` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


USE grocerymanagementsystem;
CREATE TABLE `user_type` (
  `user_type_id` char(1) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


USE grocerymanagementsystem;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_type` char(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_usertype_idx` (`user_type`),
  CONSTRAINT `user_usertype` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`user_type_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


USE grocerymanagementsystem;
CREATE TABLE `user_customer` (
  `user_id` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  `city_address` varchar(45) NOT NULL,
  `state_address` varchar(45) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_customer` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `user_administrator` (
  `user_id` int NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `company_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_administrator` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `order_table` (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `total_items` int DEFAULT NULL,
  `order_total_price` double(6,2) NOT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `payment_id` int NOT NULL,
  PRIMARY KEY (`order_no`),
  KEY `order_customer_idx` (`customer_id`),
  KEY `order_payment_idx` (`payment_id`),
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_id`) REFERENCES `user_customer` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `order_payment` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


USE grocerymanagementsystem;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `price` double(5,2) DEFAULT NULL,
  `quantity_instock` int DEFAULT NULL,
  `in_stock` tinyint DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ground Beef', 'Meats', '7.00', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ground Pork', 'Meats', '6.19', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ground Turkey', 'Meats', '6.19', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Chicken Breast', 'Meats', '14.97', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ribeye Steak', 'Meats', '21.16', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Tenderloin Steak', 'Meats', '21.60', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Whole Chicken', 'Meats', '25.70', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Salmon Fillets', 'Seafoods', '13.57', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Halibut Fillets', 'Seafoods', '28.95', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Cod Fillets', 'Seafoods', '5.24', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ahi Tuna', 'Seafoods', '8.95', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Imitation Crab', 'Seafoods', '6.15', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Crusted Cod', 'Seafoods', '14.80', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Salmon Patties', 'Seafoods', '12.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Banana', 'Fruits', '0.34', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Cherry', 'Fruits', '9.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Grapes', 'Fruits', '9.90', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Orange', 'Fruits', '7.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Strawberry', 'Fruits', '4.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Apple', 'Fruits', '0.84', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Mango', 'Fruits', '2.49', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Romaine Hearts', 'Vegetables', '3.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Broccoli', 'Vegetables', '1.85', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Lettuce', 'Vegetables', '2.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Pepper', 'Vegetables', '1.49', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Asparagus', 'Vegetables', '5.12', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Onion', 'Vegetables', '1.00', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Ginger', 'Vegetables', '1.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Salted Butter', 'Dairies', '6.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Unsalted Butter', 'Dairies', '7.29', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Margarine', 'Dairies', '4.29', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('2% Milk', 'Dairies', '1.93', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('1% Skim Milk', 'Dairies', '1.87', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Coffee Cream', 'Dairies', '3.19', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Cheddar Cheese', 'Dairies', '7.49', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('White Eggs, 30', 'Eggs', '8.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('White Eggs, 12', 'Eggs', '3.49', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Brown Eggs, 12', 'Eggs', '6.39', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Egg Whites', 'Eggs', '3.99', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Salted Duck Eggs', 'Eggs', '3.69', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Pickled Eggs', 'Eggs', '3.19', '500', 1, 'active');
INSERT INTO `grocerymanagementsystem`.`products` (`product_name`, `department`, `price`, `quantity_instock`, `in_stock`, `status`) VALUES ('Plant Based Eggs', 'Eggs', '6.99', '500', 1, 'active');


USE grocerymanagementsystem;
CREATE TABLE `order_detail` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `order_orderdetail_idx` (`order_id`),
  KEY `orderdetail_products_idx` (`product_id`),
  CONSTRAINT `order_orderdetail` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`order_no`),
  CONSTRAINT `orderdetail_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `order_shipment` (
  `shipment_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `shipping_address` varchar(100) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  `phone_number` bigint NOT NULL,
  PRIMARY KEY (`shipment_id`),
  KEY `order_ordershipment_idx` (`order_id`),
  CONSTRAINT `order_ordershipment` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`order_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
