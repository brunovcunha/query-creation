CREATE TABLE nota_fiscal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_nf INT,
    id_item INT,
    cod_prod INT,
    valor_unit DECIMAL(10,2),
    quantidade INT,
    desconto DECIMAL(10,2)
);


INSERT INTO nota_fiscal (id_nf, id_item, cod_prod, valor_unit, quantidade, desconto)
VALUES
(1001, 1, 123, 50.00, 5, 0.00),
(1001, 2, 124, 30.00, 10, 5.00),
(1002, 3, 125, 40.00, 7, 10.00),
(1002, 4, 126, 70.00, 3, 0.00),
(1003, 5, 127, 60.00, 15, 15.00),
(1004, 6, 128, 80.00, 2, 0.00),
(1005, 7, 129, 90.00, 1, 20.00),
(1006, 8, 130, 20.00, 20, 0.00),
(1007, 9, 131, 25.00, 12, 5.00);
