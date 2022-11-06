DROP TABLE IF EXISTS `goods`;
DROP TABLE IF EXISTS `goods_images`;
DROP TABLE IF EXISTS `goods_remark`;
DROP TABLE IF EXISTS `goods_tag`;
DROP TABLE IF EXISTS `goods_tags_mapping`;
DROP TABLE IF EXISTS `goods_video`;
DROP TABLE IF EXISTS `major`;
DROP TABLE IF EXISTS `manage_ip_user_mapping`;
DROP TABLE IF EXISTS `manage_ips`;
DROP TABLE IF EXISTS `manage_user`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `order_detail`;
DROP TABLE IF EXISTS `order_status`;
DROP TABLE IF EXISTS `school`;
DROP TABLE IF EXISTS `school_major_mapping`;
DROP TABLE IF EXISTS `transaction_address`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `user_detail`;

    /*====================================================
    商品相关
  =================================================*/
CREATE TABLE `goods`  (
                          `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `name` varchar(255) NOT NULL COMMENT '商品名称',
                          `description` varchar(255) NOT NULL COMMENT '商品描述',
                          `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '商品价格',
                          `avg_score` int NOT NULL COMMENT '商品评分，1 - 100',
                          `seller` int NOT NULL COMMENT '指向 user.pk_id ',
                          `transaction_addr` int NOT NULL COMMENT '指向 transaction_address.pk_id',
                          `status` int NOT NULL COMMENT '指向 trade_status.pk_id',
                          `sell_time` datetime NULL DEFAULT NULL COMMENT '售出时间',
                          `count` int NOT NULL DEFAULT 1 COMMENT '商品库存',
                          `type` int NOT NULL DEFAULT '' COMMENT '商品类别，goods_type.pk_id',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
                          PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '商品表，存储用户发布的商品信息';

CREATE TABLE `goods_images`  (
                                 `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                 `goods_id` int NOT NULL COMMENT '指向 goods.pk_id',
                                 `image_path` varchar(255) NOT NULL DEFAULT '' COMMENT '图片路径',
                                 `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                 `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                 PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '商品图片表，存储用户发布的商品图片';

CREATE TABLE `goods_remark`  (
                                 `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                 `content` varchar(255) NOT NULL COMMENT '商品评论内容',
                                 `user_id` int NOT NULL COMMENT '发布者id',
                                 `goods_id` int NOT NULL COMMENT '商品id',
                                 `Image` varchar(255) NULL COMMENT '评价图片路径',
                                 `score` int NOT NULL COMMENT '对商品的评分',
                                 `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                 `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                 PRIMARY KEY (`pk_id`)
);

CREATE TABLE `goods_tag`  (
                              `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                              `tag_name` varchar(32) NULL COMMENT '商品标签id',
                              `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                              `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                              PRIMARY KEY (`pk_id`)
);

CREATE TABLE `goods_tags_mapping`  (
                                       `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                       `goods_id` int NOT NULL COMMENT '商品 id',
                                       `tags_id` int NOT NULL COMMENT 'enums.id',
                                       `create_time` datetime NOT NULL COMMENT '创建时间',
                                       `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
                                       PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '商品表和标签表的中间表';

CREATE TABLE `goods_video`  (
                                `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `goods_id` int NOT NULL COMMENT '指向 goods.pk_id',
                                `video_path` varchar(255) NOT NULL DEFAULT '' COMMENT '视频路径',
                                `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '商品视频表，存储用户发布的商品视频';


        /*====================================================
        管理员用户相关
    =================================================*/

CREATE TABLE `manage_ip_user_mapping`  (
                                           `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                           `ip_id` int NOT NULL COMMENT 'manage_ips.id',
                                           `manage_user_id` int NOT NULL COMMENT '管理者id',
                                           `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                                           `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                           PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '管理员用户id 与 所有 ip 的中间表';

CREATE TABLE `manage_ips`  (
                               `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                               `ipv4` varchar(15) NOT NULL COMMENT 'ip地址',
                               `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                               `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                               PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '所有管理员用户使用的ip';

CREATE TABLE `manage_user`  (
                                `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                `username` varchar(16) NOT NULL COMMENT '用户名',
                                `password` varchar(32) NOT NULL COMMENT '密码',
                                `school_id` int NOT NULL COMMENT '所属学校',
                                `session_age` int NULL COMMENT '每次会话存活时长',
                                `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                                `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '管理员用户表';


        /*====================================================
        订单相关
    =================================================*/

CREATE TABLE `order`  (
                          `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `buyer` int NOT NULL COMMENT '买家，指向 user.pk_id',
                          `seller_id` int NOT NULL COMMENT '卖家id',
                          `order_status_id` int NOT NULL DEFAULT 40 COMMENT '订单状态',
                          `order_detail_count` int NOT NULL DEFAULT 0 COMMENT '订单详情的数量',
                          `order_total_price` decimal(10, 2) NOT NULL COMMENT '订单总金额',
                          `pay_time` datetime NULL DEFAULT NULL COMMENT '付款时间',
                          `finish_time` datetime NULL DEFAULT NULL COMMENT '交易完成时间',
                          `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                          `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                          PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '订单表，存储一笔交易的订单概况';

CREATE TABLE `order_detail`  (
                                 `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                 `order_id` int NOT NULL COMMENT '所属订单的id',
                                 `bill_num` char(32) NOT NULL DEFAULT '' COMMENT '订单编号，用UUID生成',
                                 `goods_id` int NOT NULL COMMENT '商品 id',
                                 `goods_count` int NOT NULL DEFAULT 0 COMMENT '商品数量',
                                 `goods_total_price` decimal(10, 2) NOT NULL COMMENT '商品总价格 = 商品单价 * 商品数量',
                                 `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                 `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                 PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '订单详情表，存储了订单交易商品的详细信息';

CREATE TABLE `order_status`  (
                                 `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                 `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                 `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                 `status_name` varchar(32) NOT NULL COMMENT '订单状态名称',
                                 PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '订单状态';


        /*====================================================
        学校专业等
    =================================================*/

CREATE TABLE `school`  (
                           `pk_id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(64) NOT NULL COMMENT '学校名称',
                           `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                           `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                           PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '学校表，存放所有学校的名称';

CREATE TABLE `major`  (
                          `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                          `name` varchar(255) NOT NULL COMMENT '专业名称',
                          `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                          `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                          PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '专业表，存放所有专业名称';

CREATE TABLE `school_major_mapping`  (
                                         `pk_id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                                         `school_id` int NOT NULL COMMENT '学校id',
                                         `major_id` int NOT NULL COMMENT '专业id',
                                         `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                                         `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                         PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '学校和专业的中间表';


        /*====================================================
        用户相关
    =================================================*/

CREATE TABLE `transaction_address`  (
                                        `pk_id` int NOT NULL AUTO_INCREMENT,
                                        `address_name` varchar(255) NOT NULL DEFAULT '' COMMENT '交易地址',
                                        `user_id` int NOT NULL COMMENT '地址所属的用户 id',
                                        `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                        `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                        PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '交易地址表，存储用户常用交易地址';

CREATE TABLE `user`  (
                         `pk_id` int NOT NULL AUTO_INCREMENT COMMENT '用户 id',
                         `headshot` varchar(255) NOT NULL DEFAULT '' COMMENT '头像图片所在路径',
                         `nick_name` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
                         `gender` char(1) NOT NULL DEFAULT 0 COMMENT '性别',
                         `score` int NULL DEFAULT -1 COMMENT '评分，-1表示无评分，范围 -1 - 100',
                         `create_time` datetime NOT NULL COMMENT '账号创建时间',
                         `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上次修改时间',
                         PRIMARY KEY (`pk_id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '用户基本信息表，即暴露在外，其余用户可以直接看见的';

CREATE TABLE `user_detail`  (
                                `pk_id` int NOT NULL AUTO_INCREMENT COMMENT '主键 id，和 user.pk_id 完全相同',
                                `school_card_id` char(10) NOT NULL COMMENT '校园卡 id，即登录的账号',
                                `password` char(32) NOT NULL COMMENT '密码，采用 sha256 + MD5 加密',
                                `real_name` varchar(32) NOT NULL DEFAULT '' COMMENT '真实姓名',
                                `status` int NULL DEFAULT 0 COMMENT '账号状态。0 表示正常，1表示已封禁',
                                `email` varchar(32) NOT NULL COMMENT '邮箱',
                                `school_id` int NOT NULL COMMENT '学校id',
                                `grade` year NOT NULL DEFAULT '' COMMENT '所在年级，单位为 级',
                                `major_name` int NOT NULL DEFAULT '' COMMENT '专业名称，指向major.id',
                                `class_num` varchar(16) NOT NULL DEFAULT 00 COMMENT '班级序号',
                                `create_time` datetime(0) NOT NULL COMMENT '账号创建时间',
                                `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上次修改时间',
                                PRIMARY KEY (`pk_id`),
                                UNIQUE INDEX `school_card_id_unique`(`school_card_id`) USING BTREE COMMENT '校园卡卡号的唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '用户详细信息表，只有自己能看见';

