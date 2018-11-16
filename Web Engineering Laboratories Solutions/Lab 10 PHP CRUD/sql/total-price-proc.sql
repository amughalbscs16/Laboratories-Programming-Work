DELIMITER $$
CREATE PROCEDURE total_price( OUT total int)
BEGIN 
	SELECT sum(price) into total from bookstore;
END$$
