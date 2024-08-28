/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : xm-secondhand

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 29/03/2024 11:41:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系人',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '关联用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '收货地址' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (2, '小武哥哥', '安徽省合肥市蜀山区110号', '13988776699', 4);
INSERT INTO `address` VALUES (4, '小武', '安徽省合肥市政务区190号', '13988779988', 4);
INSERT INTO `address` VALUES (5, '青哥哥', '安徽省合肥市新华街道100号', '13877668877', 1);
INSERT INTO `address` VALUES (6, '青哥哥1', '合肥市阳光大道130号', '13988665533', 1);
INSERT INTO `address` VALUES (7, '小青蛙', '北京市朝阳区110号', '13988776622', 7);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色标识',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin', '管理员', 'http://localhost:9090/files/1711332061088-QQ截图20230330090913.png', 'ADMIN', '13988997799', 'aaa@xm.com');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '穿搭');
INSERT INTO `category` VALUES (2, '家居');
INSERT INTO `category` VALUES (3, '笔记本平板');
INSERT INTO `category` VALUES (4, '手机');
INSERT INTO `category` VALUES (5, '电动车');
INSERT INTO `category` VALUES (6, '自行车');
INSERT INTO `category` VALUES (7, '足球');
INSERT INTO `category` VALUES (8, '篮球');
INSERT INTO `category` VALUES (9, '乐器');
INSERT INTO `category` VALUES (10, '耳机音箱');
INSERT INTO `category` VALUES (11, '图书');

-- ----------------------------
-- Table structure for chat_group
-- ----------------------------
DROP TABLE IF EXISTS `chat_group`;
CREATE TABLE `chat_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `chat_user_id` int(11) NULL DEFAULT NULL COMMENT '聊天用户ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '当前用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '聊天组' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chat_group
-- ----------------------------
INSERT INTO `chat_group` VALUES (1, 5, 1);
INSERT INTO `chat_group` VALUES (6, 1, 5);
INSERT INTO `chat_group` VALUES (7, 4, 5);
INSERT INTO `chat_group` VALUES (8, 5, 4);
INSERT INTO `chat_group` VALUES (9, 1, 7);
INSERT INTO `chat_group` VALUES (10, 7, 1);

-- ----------------------------
-- Table structure for chat_info
-- ----------------------------
DROP TABLE IF EXISTS `chat_info`;
CREATE TABLE `chat_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `chat_user_id` int(11) NULL DEFAULT NULL COMMENT '聊天用户ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '当前用户ID',
  `text` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '聊天内容',
  `isread` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '否' COMMENT '是否已读',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '聊天信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chat_info
-- ----------------------------
INSERT INTO `chat_info` VALUES (1, 5, 1, '123', '是', '2024-03-29 09:43:25');
INSERT INTO `chat_info` VALUES (2, 1, 5, '333', '是', '2024-03-29 09:45:43');
INSERT INTO `chat_info` VALUES (3, 5, 1, '333333', '是', '2024-03-29 09:46:20');
INSERT INTO `chat_info` VALUES (4, 1, 5, '我是 wwww  你好青哥哥', '是', '2024-03-29 09:51:29');
INSERT INTO `chat_info` VALUES (5, 5, 1, '我是青哥哥   你好啊', '是', '2024-03-29 09:51:41');
INSERT INTO `chat_info` VALUES (6, 1, 5, '1111', '是', '2024-03-29 09:51:47');
INSERT INTO `chat_info` VALUES (7, 5, 1, '2222', '是', '2024-03-29 09:51:49');
INSERT INTO `chat_info` VALUES (8, 1, 5, '33333', '是', '2024-03-29 09:51:51');
INSERT INTO `chat_info` VALUES (9, 5, 1, '4444', '是', '2024-03-29 09:51:53');
INSERT INTO `chat_info` VALUES (10, 1, 5, '2222', '是', '2024-03-29 09:52:05');
INSERT INTO `chat_info` VALUES (11, 5, 1, '3333', '是', '2024-03-29 09:52:06');
INSERT INTO `chat_info` VALUES (12, 1, 5, '1231321', '是', '2024-03-29 10:01:11');
INSERT INTO `chat_info` VALUES (13, 5, 1, '5555', '否', '2024-03-29 10:38:35');
INSERT INTO `chat_info` VALUES (14, 5, 1, '3123213213', '否', '2024-03-29 10:43:53');
INSERT INTO `chat_info` VALUES (15, 5, 1, '3132123213213213123213', '否', '2024-03-29 10:44:05');
INSERT INTO `chat_info` VALUES (16, 5, 1, 'rrqwrqrwq', '否', '2024-03-29 10:44:07');
INSERT INTO `chat_info` VALUES (17, 5, 1, 'eqweqee', '否', '2024-03-29 10:44:09');
INSERT INTO `chat_info` VALUES (18, 5, 1, '66666', '否', '2024-03-29 10:44:48');
INSERT INTO `chat_info` VALUES (19, 5, 1, '7777', '否', '2024-03-29 10:44:51');
INSERT INTO `chat_info` VALUES (20, 5, 1, '8888', '否', '2024-03-29 10:44:53');
INSERT INTO `chat_info` VALUES (21, 1, 7, '哈喽', '是', '2024-03-29 11:15:37');
INSERT INTO `chat_info` VALUES (22, 1, 7, '在吗？', '是', '2024-03-29 11:15:40');
INSERT INTO `chat_info` VALUES (23, 7, 1, '在的', '是', '2024-03-29 11:15:59');
INSERT INTO `chat_info` VALUES (24, 7, 1, '有什么需要？', '是', '2024-03-29 11:16:04');
INSERT INTO `chat_info` VALUES (25, 1, 7, '我想买一个吉他', '是', '2024-03-29 11:16:12');

-- ----------------------------
-- Table structure for circles
-- ----------------------------
DROP TABLE IF EXISTS `circles`;
CREATE TABLE `circles`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '缩略图',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '圈子' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of circles
-- ----------------------------
INSERT INTO `circles` VALUES (2, 'http://localhost:9090/files/1710666813454-生活服务.png', '生活用品');
INSERT INTO `circles` VALUES (3, 'http://localhost:9090/files/1710753648228-书籍.png', '图书教材');
INSERT INTO `circles` VALUES (4, 'http://localhost:9090/files/1710746292837-音乐.png', '音乐');
INSERT INTO `circles` VALUES (5, 'http://localhost:9090/files/1710666820607-鼠标.png', '数码产品');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fid` int(11) NULL DEFAULT NULL COMMENT '关联ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '收藏人ID',
  `module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '收藏' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (55, 9, 5, 'goods');
INSERT INTO `collect` VALUES (57, 9, 6, 'goods');
INSERT INTO `collect` VALUES (58, 8, 2, 'goods');
INSERT INTO `collect` VALUES (61, 5, 2, 'goods');
INSERT INTO `collect` VALUES (62, 13, 1, 'goods');
INSERT INTO `collect` VALUES (63, 19, 7, 'goods');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '评论人',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '评论时间',
  `fid` int(11) NULL DEFAULT NULL COMMENT '关联ID',
  `module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模块',
  `root_id` int(11) NULL DEFAULT NULL COMMENT '根节点ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '1111', 1, NULL, '2024-03-25 11:42:58', 18, 'goods', 1);
INSERT INTO `comment` VALUES (4, '444', 1, 1, '2024-03-25 11:43:05', 18, 'goods', 1);
INSERT INTO `comment` VALUES (5, '121123123', 1, NULL, '2024-03-27 11:52:21', 8, 'posts', 5);
INSERT INTO `comment` VALUES (6, '4414213421', 1, NULL, '2024-03-27 11:52:22', 8, 'posts', 6);
INSERT INTO `comment` VALUES (7, '44444', 1, NULL, '2024-03-27 11:52:24', 8, 'posts', 7);
INSERT INTO `comment` VALUES (8, '6666', 1, 7, '2024-03-27 11:52:27', 8, 'posts', 7);
INSERT INTO `comment` VALUES (9, '3333', 1, 8, '2024-03-27 11:52:32', 8, 'posts', 7);
INSERT INTO `comment` VALUES (11, '11111', 1, NULL, '2024-03-28 10:05:42', 2, 'help', 11);
INSERT INTO `comment` VALUES (12, '222', 1, NULL, '2024-03-28 10:07:20', 2, 'help', 12);
INSERT INTO `comment` VALUES (13, '3333', 1, NULL, '2024-03-28 10:07:22', 2, 'help', 13);
INSERT INTO `comment` VALUES (14, '4444', 1, NULL, '2024-03-28 10:07:23', 2, 'help', 14);
INSERT INTO `comment` VALUES (15, '5555', 1, NULL, '2024-03-28 10:07:24', 2, 'help', 15);
INSERT INTO `comment` VALUES (16, '666', 1, NULL, '2024-03-28 10:07:25', 2, 'help', 16);
INSERT INTO `comment` VALUES (17, '1111', 1, NULL, '2024-03-28 10:09:12', 9, 'goods', 17);
INSERT INTO `comment` VALUES (18, '222', 1, NULL, '2024-03-28 10:09:15', 9, 'goods', 18);
INSERT INTO `comment` VALUES (19, '333', 1, NULL, '2024-03-28 10:09:16', 9, 'goods', 19);
INSERT INTO `comment` VALUES (20, '4', 1, NULL, '2024-03-28 10:09:17', 9, 'goods', 20);
INSERT INTO `comment` VALUES (21, '5', 1, NULL, '2024-03-28 10:09:18', 9, 'goods', 21);
INSERT INTO `comment` VALUES (22, '6', 1, NULL, '2024-03-28 10:09:19', 9, 'goods', 22);
INSERT INTO `comment` VALUES (23, '1111', 1, NULL, '2024-03-28 10:16:40', 1, 'help', 23);
INSERT INTO `comment` VALUES (24, '看着不错哦', 7, NULL, '2024-03-29 11:15:02', 19, 'goods', 24);
INSERT INTO `comment` VALUES (27, '1111', 7, NULL, '2024-03-29 11:26:42', 10, 'posts', 27);
INSERT INTO `comment` VALUES (28, '111', 7, NULL, '2024-03-29 11:27:54', 11, 'posts', 28);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主题',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `reply` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '回复',
  `createtime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '提交人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '反馈信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (1, '申请退款', '发生争议，需要退款', '13988997788', NULL, '我们来联系你处理', '2024-03-18 15:50:19', 1);
INSERT INTO `feedback` VALUES (2, '我的发？', 'excuse me baby', '13988776699', NULL, '哈喽', '2024-03-18 17:25:16', 6);
INSERT INTO `feedback` VALUES (3, '我买错了', '买错了，可以退吗', '13988776699', NULL, NULL, '2024-03-18 17:48:12', 2);
INSERT INTO `feedback` VALUES (4, '我需要帮助', '我需要帮助', NULL, NULL, '可以联系电话 010-65889988', '2024-03-28 11:02:25', 1);
INSERT INTO `feedback` VALUES (5, '我现在很郁闷，因为我没找到对象', '我现在很郁闷，因为我没找到对象，求帮助', '1389977688', '1389977688@163.com', '找对象要积极主动，厚脸皮，死乞白赖的精神拿出来', '2024-03-29 11:28:36', 7);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '详情',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发货地址',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上架日期',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核状态',
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '分类',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '所属用户ID',
  `sale_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上架状态',
  `read_count` int(11) NULL DEFAULT 0 COMMENT '浏览量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '二手商品' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (2, '影石Insta360 Ace Pro运动相机8k徕卡摄像头', 1998.00, '<p><img src=\"https://img.alicdn.com/imgextra/i3/2208654990728/O1CN014fxPBV1HFTGmsusBp_!!2208654990728.png\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732191721-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\" width=\"100%\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732176479-微信截图_20240318112155.png', '2024-01-10', '通过', '耳机音箱', 4, '上架', 1);
INSERT INTO `goods` VALUES (3, 'SONY索尼WH-1000XM4/5头戴式无线蓝牙耳机主动降噪头戴4', 1999.00, '<p><img src=\"https://img.alicdn.com/imgextra/i2/2214661621088/O1CN01SJ2vWm1JuLmc8Migo_!!2214661621088-0-scmitem1000.jpg\" width=\"100%\"/><br/></p>', '安徽合肥', 'http://localhost:9090/files/1710732446620-微信截图_20240318112705.png', '2024-01-10', '通过', '耳机音箱', 4, '上架', 5);
INSERT INTO `goods` VALUES (4, '2022年卡塔尔世界杯足球官方正品5号专业训练比赛专用球儿童1355', 40.00, '<p><img src=\"https://img.alicdn.com/imgextra/i1/2616970884/O1CN01SPbEn61IOuwP1G1oE_!!2616970884.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732567587-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732543650-微信截图_20240318112858.png', '2024-01-10', '通过', '足球', 4, '上架', 2);
INSERT INTO `goods` VALUES (5, '足球五号初中生中考训练专用球', 199.00, '<p><img src=\"https://img.alicdn.com/imgextra/i2/2193975096/O1CN010RF9HT1nW1HJmulLe_!!2193975096-0-scmitem176000.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732634056-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732630892-微信截图_20240318113020.png', '2024-01-10', '通过', '足球', 4, '上架', 8);
INSERT INTO `goods` VALUES (6, '斯伯丁篮球官方正品中考学生专用7号成人橡胶室外篮球耐磨防滑', 199.00, '<p><img src=\"https://img.alicdn.com/imgextra/i4/2215726198477/O1CN01uDQHZo2CUWMouy2f0_!!2215726198477.jpg\" width=\"100%\"/><img src=\"https://img.alicdn.com/imgextra/i2/2215726198477/O1CN01suxVZE2CUWHaf2Ms0_!!2215726198477.jpg\" style=\"font-size: 14px;\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732721019-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732691542-微信截图_20240318113120.png', '2024-01-10', '通过', '篮球', 4, '上架', 7);
INSERT INTO `goods` VALUES (7, '震撼大师手工全单古典吉他', 1998.00, '<p><img src=\"https://img.alicdn.com/imgextra/i2/2289123357/O1CN01gFdEtC1afYLPtjh3X_!!2289123357.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732813613-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732810749-微信截图_20240318113309.png', '2024-01-10', '通过', '乐器', 4, '上架', 3);
INSERT INTO `goods` VALUES (8, '专业笛子初学者零基础竹笛入门苦竹f演奏级c调成人e儿童g横笛乐器', 199.00, '<p><img src=\"https://img.alicdn.com/imgextra/i1/2417340146/O1CN01nNji0v1CwugZ4snBM_!!2417340146.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732892032-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710732896200-微信截图_20240318113443.png', '2024-01-10', '通过', '乐器', 4, '上架', 23);
INSERT INTO `goods` VALUES (9, 'kepma卡普马吉他卡玛民谣电箱d1c/a1c初学入门男女学生儿童木吉他', 648.00, '<p><img src=\"https://img.alicdn.com/imgextra/i1/850320452/O1CN01Me5Rvy1FD3xMD4EOK_!!850320452.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710732996103-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710733003156-微信截图_20240318113621.png', '2024-01-10', '通过', '乐器', 4, '上架', 59);
INSERT INTO `goods` VALUES (13, '品彩新年红半高领针', 199.00, '<div><img src=\"https://img30.360buyimg.com/sku/jfs/t1/99760/24/43651/54323/64e2cde4Fbece5bd3/ac96a198fb27780a.jpg\"/>	</div>\n<div><img src=\"https://img30.360buyimg.com/sku/jfs/t1/189762/23/36644/55229/64e2cde4F8786c6ee/8dadfcf2f1c54a99.jpg\"/>	</div>', '安徽合肥', 'http://localhost:9090/files/1704875358717-微信截图_20240110162417.png', '2024-01-10', '待审核', '穿搭', 4, '上架', 27);
INSERT INTO `goods` VALUES (15, '二手商品', 10.00, '<p><img src=\"http://localhost:9090/files/1708400286601-image.png\" style=\"max-width:100%;\" contenteditable=\"false\"/></p>', '东校区', 'http://localhost:9090/files/1708399512763-蛋糕.png', '2024-02-20', '通过', '耳机音箱', 4, '下架', 55);
INSERT INTO `goods` VALUES (16, '键盘', 200.00, '<p><img src=\"https://img.alicdn.com/imgextra/i4/2212972276013/O1CN013AucSC1uI0SlSDkvD_!!2212972276013.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710756960569-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '合肥', 'http://localhost:9090/files/1710756941461-微信截图_20240318181524.png', '2024-03-18', '通过', '笔记本平板', 5, '上架', 79);
INSERT INTO `goods` VALUES (17, '【官方正版】高等数学同济七版 教材上册+下册 同济大学高等数学第七版 大一课本高等数学第7版 高数考研数学教材 高等教育出版社', 30.00, '<p><img src=\"https://img.alicdn.com/imgextra/i2/101450072/O1CN01QxR1em1CP1Gj2vT4A-101450072.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710756616895-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710756599260-微信截图_20240318180909.png', '2024-03-18', '通过', '图书', 1, '上架', 2);
INSERT INTO `goods` VALUES (18, '新华正版】工程数学 线性代数第六版 高等教育出版社 线性代数同济六版6版 工程数学线性代数同济大学线代 考研数学教材用书', 28.00, '<p><img src=\"https://img.alicdn.com/imgextra/i3/101450072/O1CN01fT1YYK1CP19H32Ph4-101450072.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1710756841433-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽合肥', 'http://localhost:9090/files/1710756827594-微信截图_20240318180926.png', '2024-03-18', '通过', '图书', 1, '上架', 29);
INSERT INTO `goods` VALUES (19, '【官方正版】百年孤独 原著原版无删减中文译本 ', 39.60, '<p><img src=\"https://img.alicdn.com/imgextra/i3/2129856610/O1CN01z5eg4C1yhQfDUYBh7-2129856610.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1711418486618-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '安徽省合肥市政务区111号', 'http://localhost:9090/files/1711418559078-微信截图_20240326100215.png', '2024-03-26', '通过', '图书', 1, '上架', 18);
INSERT INTO `goods` VALUES (20, '蓝牙耳机', 188.00, '<p><img src=\"https://img.alicdn.com/imgextra/i3/2204777365052/O1CN01RNP04i1nBrqfMGoQP_!!2204777365052.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1711682539596-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', '北京朝阳', 'http://localhost:9090/files/1711682485540-蓝牙耳机.png', '2024-03-29', '通过', '耳机音箱', 7, '上架', 1);

-- ----------------------------
-- Table structure for help
-- ----------------------------
DROP TABLE IF EXISTS `help`;
CREATE TABLE `help`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布时间',
  `solved` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否解决',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '求助信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of help
-- ----------------------------
INSERT INTO `help` VALUES (1, '我想买一辆校园代步自行车', '代步自行车  7-8成新就行，预算100', 'http://localhost:9090/files/1709087348366-微信截图_20240228102849.png', '通过', 1, '2024-02-28 11:30:00', '已解决');
INSERT INTO `help` VALUES (2, '我想买本二手高数辅导资料', '我想买本二手高数辅导资料，新旧无所谓，预算20以内', 'http://localhost:9090/files/1710666500025-高数.jpg', '通过', 1, '2024-03-17 17:08:21', '未解决');
INSERT INTO `help` VALUES (3, '我想要一个键盘', '我想要一个键盘', 'http://localhost:9090/files/1711592732447-微信截图_20240318181524.png', '通过', 4, '2024-03-28 10:25:35', '未解决');
INSERT INTO `help` VALUES (4, '我想要一个模型飞机', '我想要一个模型飞机', 'http://localhost:9090/files/1711682748613-微信截图_20240329112543.png', '通过', 7, '2024-03-29 11:25:52', '未解决');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `fid` int(11) NULL DEFAULT NULL COMMENT '关联ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '点赞人ID',
  `module` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '点赞' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES (63, 13, 1, 'goods');
INSERT INTO `likes` VALUES (65, 15, 1, 'goods');
INSERT INTO `likes` VALUES (66, 9, 5, 'goods');
INSERT INTO `likes` VALUES (67, 5, 2, 'goods');
INSERT INTO `likes` VALUES (68, 3, 1, 'goods');
INSERT INTO `likes` VALUES (70, 18, 1, 'goods');
INSERT INTO `likes` VALUES (71, 16, 1, 'goods');
INSERT INTO `likes` VALUES (72, 19, 7, 'goods');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建时间',
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公告信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (4, '热卖二手商品限时秒杀', '热卖二手商品限时秒杀', '2024-03-25 09:52:00', 'admin');
INSERT INTO `notice` VALUES (5, '今天特价商品已上架', '今天特价商品已上架', '2024-03-25 09:52:00', 'admin');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '商品图片',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单编号',
  `total` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '下单时间',
  `pay_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付单号',
  `pay_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '下单人ID',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收货地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单状态',
  `sale_id` int(11) NULL DEFAULT NULL COMMENT '卖家ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '订单信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (8, '键盘', 'http://localhost:9090/files/1710756941461-微信截图_20240318181524.png', '17114233143372315334', 2000.00, '2024-03-25 11:21:54', NULL, NULL, 1, '安徽省合肥市新华街道100号', '13877668877', NULL, '已完成', 5);
INSERT INTO `orders` VALUES (9, '斯伯丁篮球官方正品中考学生专用7号成人橡胶室外篮球耐磨防滑', 'http://localhost:9090/files/1710732691542-微信截图_20240318113120.png', '17114242903423672645', 199.00, '2024-03-26 11:38:10', '2024032722001446850502106023', '2024-03-27 10:01:53', 1, '安徽省合肥市新华街道100号', '13877668877', NULL, '已完成', 4);
INSERT INTO `orders` VALUES (10, 'SONY索尼WH-1000XM4/5头戴式无线蓝牙耳机主动降噪头戴4', 'http://localhost:9090/files/1710732446620-微信截图_20240318112705.png', '17115050080087304878', 1999.00, '2024-03-27 10:03:28', '2024032722001446850502102855', '2024-03-27 10:04:03', 1, '安徽省合肥市新华街道100号', '13877668877', NULL, '已完成', 4);
INSERT INTO `orders` VALUES (11, '【官方正版】百年孤独 原著原版无删减中文译本 ', 'http://localhost:9090/files/1711418559078-微信截图_20240326100215.png', '17116822233431580005', 39.60, '2024-03-29 11:17:03', NULL, NULL, 7, '北京市朝阳区110号', '13988776622', NULL, '已取消', 1);
INSERT INTO `orders` VALUES (12, '【官方正版】百年孤独 原著原版无删减中文译本 ', 'http://localhost:9090/files/1711418559078-微信截图_20240326100215.png', '17116822380876496406', 39.60, '2024-03-29 11:17:18', '2024032922001446850502119105', '2024-03-29 11:19:01', 7, '北京市朝阳区110号', '13988776622', NULL, '已完成', 1);

-- ----------------------------
-- Table structure for posts
-- ----------------------------
DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `img` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '发布时间',
  `circle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '圈子',
  `descr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简介',
  `read_count` int(11) NULL DEFAULT 0 COMMENT '浏览量',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '帖子' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of posts
-- ----------------------------
INSERT INTO `posts` VALUES (2, '二手书桌，便宜卖了', '<p>二手书桌，便宜卖了</p><p><br/></p><p>购买链接：<a target=\"_blank\" href=\"http://localhost:8080/front/goodsDetail?id=15\">http://localhost:8080/front/goodsDetail?id=15</a></p>', 'http://localhost:9090/files/1710747156996-微信截图_20240318153220.png', 1, '2024-02-20 15:35:08', '图书教材', '二手书桌，便宜卖了', 7, '通过');
INSERT INTO `posts` VALUES (5, '闲置衣架处理，便宜卖', '<p>闲置衣架处理，便宜卖，大家来看看</p><p><br/></p><p>购买链接：<a target=\"_blank\" href=\"http://localhost:8080/front/goodsDetail?id=15\">http://localhost:8080/front/goodsDetail?id=15</a></p>', 'http://localhost:9090/files/1710746994883-微信截图_20240318152948.png', 1, '2024-02-20 15:35:08', '生活用品', '闲置衣架处理，便宜卖', 9, '待审核');
INSERT INTO `posts` VALUES (6, '闲置处理，吉他乐器111', '<p>这把吉他做工一流，现在便宜处理掉<br/></p><p><br/></p><p>购买链接：<a target=\"_blank\" href=\"http://localhost:8080/front/goodsDetail?id=15\">http://localhost:8080/front/goodsDetail?id=15</a></p>', 'http://localhost:9090/files/1710746904876-微信截图_20240318113309.png', 1, '2024-02-20 15:35:08', '音乐', '吉他乐器便宜处理', 11, '待审核');
INSERT INTO `posts` VALUES (7, '这本书陪伴了我很久，现在便宜处理掉', '<p>这本书陪伴了我很久，现在便宜处理掉，一口价20，谢绝还价<br/></p><p><br/></p><p>购买链接：<a target=\"_blank\" href=\"http://localhost:8080/front/goodsDetail?id=15\">http://localhost:8080/front/goodsDetail?id=15</a></p>', 'http://localhost:9090/files/1711509394610-微信截图_20240326100215.png', 1, '2024-02-20 15:35:08', '图书教材', '这本书很棒', 35, '待审核');
INSERT INTO `posts` VALUES (8, '大家学习要认真思考，切忌浮躁，要带着疑问去学习，要总结自己的笔记', '<p><b>大家学习要认真思考，切忌浮躁，要带着疑问去学习，要总结自己的笔记</b></p><p><b><br/></b></p><p><img src=\"http://localhost:9090/files/1711509511750-微信截图_20240326100215.png\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"50%\"/></p>', 'http://localhost:9090/files/1711509754923-微信截图_20240326100215.png', 1, '2024-03-27 11:22:37', '图书教材', '大家学习要认真思考，切忌浮躁，要带着疑问去学习，要总结自己的笔记', 11, '通过');
INSERT INTO `posts` VALUES (10, '今天下雨了，小武哥哥的心情不是很美丽', '<p><b>今天下雨了，小武哥哥的心情不是很美丽</b></p><p><b><br/></b></p><p><b>今天下雨了，小武哥哥的心情不是很美丽</b></p><p><b><br/></b></p><p><b>今天下雨了，小武哥哥的心情不是很美丽</b></p>', 'http://localhost:9090/files/1711510784045-微信截图_20240318152948.png', 4, '2024-03-27 11:39:55', '生活用品', '今天下雨了，小武哥哥的心情不是很美丽', 10, '通过');
INSERT INTO `posts` VALUES (11, '哈哈哈哈', '<p><img src=\"https://img.alicdn.com/imgextra/i1/2200611224861/O1CN01eBW1m81lmNyUK48au_!!2200611224861.jpg\" width=\"100%\"/><img src=\"http://localhost:9090/files/1711682840068-image.png\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p><br/>', 'http://localhost:9090/files/1711682826132-微信截图_20240329112543.png', 7, '2024-03-29 11:27:22', '生活用品', '我是卖报的小行家', 1, '通过');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色标识',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '个人说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aaa', '123', '青哥哥', 'http://localhost:9090/files/1711332293317-QQ截图20230330090913.png', 'USER', '13988997799', 'aaa@xm.com', NULL);
INSERT INTO `user` VALUES (2, 'ccc', '123', '武哥哥', 'http://localhost:9090/files/1708569481646-3123214.png', 'USER', '13899778866', 'ccc@xm.com', NULL);
INSERT INTO `user` VALUES (3, 'bbb', '123', '小菜', 'http://localhost:9090/files/1708569474215-QQ截图20230330090332.png', 'USER', NULL, NULL, NULL);
INSERT INTO `user` VALUES (4, 'acc', '123', '小武', 'http://localhost:9090/files/1706751425887-微信截图_20231213153827.png', 'USER', NULL, NULL, NULL);
INSERT INTO `user` VALUES (5, 'www', '123', 'www', 'http://localhost:9090/files/1710757245273-微信截图_20231018172208.png', 'USER', NULL, NULL, NULL);
INSERT INTO `user` VALUES (6, 'ddd', '123', 'ddd', 'http://localhost:9090/files/1710753710955-微信截图_20240318112705.png', 'USER', NULL, NULL, NULL);
INSERT INTO `user` VALUES (7, 'qwe', '123', 'qwe', 'http://localhost:9090/files/1711682114329-1213123213.jpg', 'USER', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
