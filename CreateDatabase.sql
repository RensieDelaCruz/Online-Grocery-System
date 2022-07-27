CREATE DATABASE `grocerymanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE grocerymanagementsystem;
CREATE TABLE `payment_type` (
  `payment_type_id` char(1) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_type_id`),
  UNIQUE KEY `payment_type_id_UNIQUE` (`payment_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `payment_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_paymenttype_idx` (`payment_type`),
  CONSTRAINT `payment_paymenttype` FOREIGN KEY (`payment_type`) REFERENCES `payment_type` (`payment_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `payment_cash` (
  `payment_id` int NOT NULL,
  `balance` double(7,2) DEFAULT NULL,
  `amount_received` double(7,2) DEFAULT NULL,
  `amount_change` double(7,2) DEFAULT NULL,
  `remaining_balance` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  CONSTRAINT `payment_paymentcash` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `payment_creditcard` (
  `payment_id` int NOT NULL,
  `creditcard_no` int NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
CREATE TABLE `order` (
  `order_no` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `order_total_price` decimal(6,2) NOT NULL,
  `order_date` date NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `ship_date` date DEFAULT NULL,
  `payment_id` int NOT NULL,
  PRIMARY KEY (`order_no`),
  KEY `order_customer_idx` (`customer_id`),
  KEY `order_payment_idx` (`payment_id`),
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_id`) REFERENCES `user_customer` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `order_payment` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

USE grocerymanagementsystem;
CREATE TABLE `order_detail` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `order_orderdetail_idx` (`order_id`),
  KEY `orderdetail_products_idx` (`product_id`),
  CONSTRAINT `order_orderdetail` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_no`) ON DELETE CASCADE,
  CONSTRAINT `orderdetail_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
