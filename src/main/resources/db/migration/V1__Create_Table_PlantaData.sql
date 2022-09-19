CREATE TABLE IF NOT EXISTS `plantaData` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `especie_planta` varchar(80) NOT NULL,
  `data_compra` date NOT NULL,
  `idade` varchar(100) NOT NULL,
  `tamanho_vaso` varchar(100) NOT NULL,
   PRIMARY KEY (`id`)
);