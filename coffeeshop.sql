/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100418
 Source Host           : localhost:3306
 Source Schema         : coffeeshop

 Target Server Type    : MySQL
 Target Server Version : 100418
 File Encoding         : 65001

 Date: 16/07/2024 16:28:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `id_bill` int(6) NOT NULL AUTO_INCREMENT,
  `total` bigint(20) NOT NULL,
  `payment` int(1) NOT NULL,
  `bill_status` int(1) NOT NULL,
  `create_date` date NOT NULL,
  `cart_id` int(6) NOT NULL,
  `employee_id` int(6) NOT NULL,
  `sale_code_id` int(1) NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_bill`) USING BTREE,
  INDEX `fk_bill_id_payment`(`payment`) USING BTREE,
  INDEX `fk_bill_id_status`(`bill_status`) USING BTREE,
  INDEX `fk_bill_id_cart`(`cart_id`) USING BTREE,
  INDEX `fk_bill_id_user`(`employee_id`) USING BTREE,
  INDEX `fk_bill_id_salecode`(`sale_code_id`) USING BTREE,
  CONSTRAINT `fk_bill_id_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id_cart`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_id_payment` FOREIGN KEY (`payment`) REFERENCES `payment` (`id_payment`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_id_salecode` FOREIGN KEY (`sale_code_id`) REFERENCES `salecode` (`id_sale_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_id_status` FOREIGN KEY (`bill_status`) REFERENCES `status` (`id_status`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bill_id_user` FOREIGN KEY (`employee_id`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, 840000, 1, 1, '2021-03-17', 1, 2, 2, 'Có thẻ thành viên');
INSERT INTO `bill` VALUES (5, 203443, 1, 1, '2021-04-22', 1, 2, 2, '');
INSERT INTO `bill` VALUES (6, 90393, 1, 1, '2021-04-22', 1, 2, 2, '');
INSERT INTO `bill` VALUES (8, 31500, 1, 1, '2021-04-22', 1, 2, 3, '');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id_cart` int(6) NOT NULL AUTO_INCREMENT,
  `user_id` int(6) NOT NULL,
  PRIMARY KEY (`id_cart`) USING BTREE,
  INDEX `fk_cart_id_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_cart_id_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 1);
INSERT INTO `cart` VALUES (2, 4);

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id_payment` int(1) NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_payment`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES (1, 'Thanh toán tiền mặt ');
INSERT INTO `payment` VALUES (2, 'Thanh toán ví điện t');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id_product` int(6) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `type` int(1) NOT NULL,
  `sale` int(3) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `favorite` int(1) NOT NULL,
  `actived` int(1) NOT NULL,
  `create_date` date NOT NULL,
  `price` int(10) NOT NULL,
  PRIMARY KEY (`id_product`) USING BTREE,
  INDEX `fk_product_id_typeproduct`(`type`) USING BTREE,
  CONSTRAINT `fk_product_id_typeproduct` FOREIGN KEY (`type`) REFERENCES `typeproduct` (`id_type_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'Cà phê đen ', 1, 0, 'img/imgProduct/C-Capheden.png', 0, 1, '2021-02-21', 0);
INSERT INTO `product` VALUES (2, 'Cà phê sữa ', 1, 0, 'img/imgProduct/c-Bacsiu.png', 1, 1, '2021-02-21', 0);
INSERT INTO `product` VALUES (3, 'Trà hạt sen ', 2, 5, 'img/imgProduct/T-trahatsen.png', 1, 1, '2021-02-21', 0);
INSERT INTO `product` VALUES (4, 'Trà Thanh Đào', 2, 0, 'img/imgProduct/T-tradaocamxa.png', 1, 1, '2021-04-21', 0);
INSERT INTO `product` VALUES (5, 'Trà sữa chân châu', 4, 5, 'img/imgProduct/T-trasuamacca.png', 1, 1, '2021-03-07', 0);
INSERT INTO `product` VALUES (6, 'Trà Oolong Vải', 2, 0, 'img/imgProduct/T-travai.png', 0, 1, '2021-03-11', 0);
INSERT INTO `product` VALUES (7, 'Trà Phúc Bồn Tử', 2, 10, 'img/imgProduct/T-traphucbontu.png', 1, 1, '2021-03-17', 0);
INSERT INTO `product` VALUES (8, 'Matcha Macchiato', 5, 0, 'img/imgProduct/M-matcha.png', 1, 1, '2021-03-08', 0);
INSERT INTO `product` VALUES (9, 'Espresso', 1, 0, 'img/imgProduct/C-Espresso.png', 0, 1, '2021-03-10', 0);
INSERT INTO `product` VALUES (10, 'Americano', 1, 0, 'img/imgProduct/C-Americano.png', 0, 1, '2021-03-02', 0);
INSERT INTO `product` VALUES (11, 'Latte', 1, 5, 'img/imgProduct/C-Latte.png', 1, 1, '2021-02-18', 0);
INSERT INTO `product` VALUES (12, 'Caramel', 1, 0, 'img/imgProduct/C-Caramel.png', 0, 1, '2021-03-09', 0);
INSERT INTO `product` VALUES (13, 'Mocha', 5, 0, 'img/imgProduct/C-mocha.png', 0, 1, '2021-03-02', 0);
INSERT INTO `product` VALUES (14, 'Cafe Đá Xay', 3, 0, 'img/imgProduct/F-daxaycafe.png', 0, 1, '2021-01-21', 0);
INSERT INTO `product` VALUES (15, 'Cam Đá Xay', 3, 0, 'img/imgProduct/F-campbt.png', 0, 1, '2021-01-21', 0);
INSERT INTO `product` VALUES (16, 'Cookies Đá Xay', 3, 5, 'img/imgProduct/F-cookie.png', 1, 1, '2021-03-21', 0);

-- ----------------------------
-- Table structure for productsinbill
-- ----------------------------
DROP TABLE IF EXISTS `productsinbill`;
CREATE TABLE `productsinbill`  (
  `bill_id` int(6) NOT NULL,
  `product_id` int(6) NOT NULL,
  `sale` int(3) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`bill_id`, `product_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `productsinbill_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id_bill`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `productsinbill_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productsinbill
-- ----------------------------
INSERT INTO `productsinbill` VALUES (1, 1, 0, 5);
INSERT INTO `productsinbill` VALUES (1, 2, 0, 10);
INSERT INTO `productsinbill` VALUES (1, 7, 10, 20);
INSERT INTO `productsinbill` VALUES (1, 10, 0, 15);
INSERT INTO `productsinbill` VALUES (5, 3, 5, 1);
INSERT INTO `productsinbill` VALUES (5, 8, 0, 1);
INSERT INTO `productsinbill` VALUES (5, 9, 0, 3);
INSERT INTO `productsinbill` VALUES (6, 1, 0, 1);
INSERT INTO `productsinbill` VALUES (6, 3, 5, 1);
INSERT INTO `productsinbill` VALUES (6, 11, 5, 1);
INSERT INTO `productsinbill` VALUES (6, 15, 0, 1);
INSERT INTO `productsinbill` VALUES (6, 16, 5, 1);
INSERT INTO `productsinbill` VALUES (8, 7, 10, 1);

-- ----------------------------
-- Table structure for productsincart
-- ----------------------------
DROP TABLE IF EXISTS `productsincart`;
CREATE TABLE `productsincart`  (
  `cart_id` int(6) NOT NULL,
  `product_id` int(6) NOT NULL,
  `sale` int(3) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`cart_id`, `product_id`) USING BTREE,
  INDEX `fk_productsincart_id_cart`(`product_id`) USING BTREE,
  CONSTRAINT `fk_productsincart_id_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id_cart`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_productsincart_id_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id_product`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productsincart
-- ----------------------------
INSERT INTO `productsincart` VALUES (1, 4, 10, 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id_role` int(6) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'Nhân viên ');
INSERT INTO `role` VALUES (2, 'Khách hàng ');

-- ----------------------------
-- Table structure for salecode
-- ----------------------------
DROP TABLE IF EXISTS `salecode`;
CREATE TABLE `salecode`  (
  `id_sale_code` int(1) NOT NULL AUTO_INCREMENT,
  `name_sale` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sale` int(3) NOT NULL,
  PRIMARY KEY (`id_sale_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salecode
-- ----------------------------
INSERT INTO `salecode` VALUES (1, 'XAFXVGX', 10);
INSERT INTO `salecode` VALUES (2, 'HIHIHIHI', 5);
INSERT INTO `salecode` VALUES (3, 'FGDSJFG', 0);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `id_status` int(1) NOT NULL AUTO_INCREMENT,
  `status_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, 'Chờ Xác Nhận');
INSERT INTO `status` VALUES (2, 'Đang lấy Hàng');
INSERT INTO `status` VALUES (3, 'Đang Giao Hàng');
INSERT INTO `status` VALUES (4, 'Đã Giao');

-- ----------------------------
-- Table structure for typeproduct
-- ----------------------------
DROP TABLE IF EXISTS `typeproduct`;
CREATE TABLE `typeproduct`  (
  `id_type_product` int(6) NOT NULL AUTO_INCREMENT,
  `type_product` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id_type_product`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of typeproduct
-- ----------------------------
INSERT INTO `typeproduct` VALUES (1, 'Coffee', 0);
INSERT INTO `typeproduct` VALUES (2, 'Trà', 0);
INSERT INTO `typeproduct` VALUES (3, 'Freeze', 0);
INSERT INTO `typeproduct` VALUES (4, 'Trà Sữa', 0);
INSERT INTO `typeproduct` VALUES (5, 'Macchiato', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id_user` int(6) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `account_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `role` int(1) NOT NULL,
  `actived` int(1) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`id_user`) USING BTREE,
  INDEX `fk_user_id_role`(`role`) USING BTREE,
  CONSTRAINT `fk_user_id_role` FOREIGN KEY (`role`) REFERENCES `role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'KH_binh', '12345', 'Nguyen Van Binh', 'Binh@gmail.com', 834050599, '24 Nguyen', 2, 1, '2021-01-20');
INSERT INTO `user` VALUES (2, 'NV_Anh', '0987', 'Pham Ngoc Anh', 'Anh@gmail.com', 9755555, '24 Quang Trung', 1, 1, '2020-12-23');
INSERT INTO `user` VALUES (4, 'KH_NgocPhan', '242bnn', 'Phan Anh Ngọc', '54Anhphanngoc@gmail.com', 234325488, '34/12 Nguyễn Tất Thành, Quận 7', 2, 1, '2001-07-11');
INSERT INTO `user` VALUES (5, 'NV_Anh', '0987', 'Pham Ngoc Anh', 'Anh@gmail.com', 9755555, '24 Quang Trung', 2, 1, '2020-12-22');
INSERT INTO `user` VALUES (6, 'KH_Nhi', '777777', 'Cao Ngọc Tuyet Nhi', 'Nhi@gmail.com', 9755555, '39 Song Hành', 2, 1, '2020-12-24');

SET FOREIGN_KEY_CHECKS = 1;
