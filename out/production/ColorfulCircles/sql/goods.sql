CREATE DATABASE bussiness;
use bussiness;
CREATE TABLE good (
  name     VARCHAR(120) NOT NULL
  COMMENT '出售者姓名',
  schoolID VARCHAR(120) NOT NULL
  COMMENT '出售者学号',
  goodName VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  goodID BIGINT NOT NULL AUTO_INCREMENT
    COMMENT '商品ID',
  goodNumber INT NOT NULL
  COMMENT '商品数量',
  goodPrice FLOAT NOT NULL
  COMMENT '商品价格',
  goodDescribe VARCHAR(500) NOT NULL
  COMMENT '商品描述',
  goodPicture BLOB
  COMMENT '商品图片',
  produceTime timestamp
  COMMENT '生产日期',
  endTime timestamp
  COMMENT '过期日期',
  PRIMARY KEY (goodID)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='商品库存表';

CREATE TABLE person (
  name     VARCHAR(120) NOT NULL
  COMMENT '姓名',
  account VARCHAR(120) NOT NULL
    COMMENT '账号',
  password VARCHAR(120)NOT NULL
    COMMENT '密码',
  schoolID VARCHAR(120) NOT NULL
  COMMENT '学号',
  vip BOOLEAN NOT NULL
    COMMENT 'vip',
  PRIMARY KEY (account)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户名单';