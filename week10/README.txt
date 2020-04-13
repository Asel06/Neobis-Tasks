Enter these commands:

```
docker-compose build
docker-compose up
docker exec -it ms bash
mysql -u root -ppassword
use fruitshop
CREATE TABLE `products`(`id` int NOT NULL AUTO_INCREMENT,
`name` VARCHAR(25) NOT NULL,
`price` int NOT NULL,
PRIMARY KEY (`id`));
insert into products (id,name,price) values (1, "Apple", 55);
insert into products (id,name,price) values (2, "Peach", 85);
insert into products (id,name,price) values (3, "Mango", 185);
```
