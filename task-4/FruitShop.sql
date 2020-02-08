CREATE DATABASE `fruitshop`;

use `fruitshop`;

CREATE TABLE `Products`(
	`id` int NOT NULL AUTO_INCREMENT,
	`NameOfFruit` VARCHAR(25) NOT NULL,
	`PriceOfProduct` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=Myisam;
CREATE TABLE `Customers`(
	`id` int NOT NULL AUTO_INCREMENT,
	`NameOfCustomer` VARCHAR(25) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=Myisam;
CREATE TABLE  `Delivery`(
	`id` int NOT NULL AUTO_INCREMENT,
	`IdOfProvider` int NOT NULL,
	`IdOfProduct` int NOT NULL,
	`AmountOfProduct` int NOT NULL,
	`CostOfProducts` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (IdOfProvider)  REFERENCES Providers (id),
	FOREIGN KEY (IdOfProduct)  REFERENCES Products (id)
) ENGINE=Myisam;
CREATE TABLE `Providers`(
	`id` int NOT NULL AUTO_INCREMENT,
	`NameOfProvider` VARCHAR(25) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=Myisam;
CREATE TABLE `Sold`(
	`id` int NOT NULL AUTO_INCREMENT,
	`IdOfProduct` int NOT NULL,
	`AmountOfProduct` int NOT NULL,
	`CostOfProducts` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (IdOfProduct)  REFERENCES Products (id),
	FOREIGN KEY (CostOfProducts)  REFERENCES Products (PriceOfProduct)
) ENGINE=Myisam;
CREATE TABLE `StoreHouse`(
	`Money` int NOT NULL,
	`IdOfProduct` int NOT NULL,
	`AmountOfProduct` int NOT NULL,
	FOREIGN KEY (IdOfProduct)  REFERENCES Products (id)
) ENGINE=Myisam;
CREATE TABLE `Workers`(
	`id` int NOT NULL AUTO_INCREMENT,
	`NameOfWorker` VARCHAR(25) NOT NULL,
	`Position` VARCHAR(25) NOT NULL,
	`Salary` int NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=Myisam;