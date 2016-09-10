
# 创建 客服人员表
CREATE TABLE account(
    aid       int not null auto_increment,
    alogin    nvarchar(20)    NOT NULL,
    aname     nvarchar(20)    NULL,
    apass     nvarchar(20)    NULL,
    primary key (aid)
);

# 创建 类别表
/* 
 * TABLE: category 
 */

CREATE TABLE category(
    cid      int     not null auto_increment   ,  
    ctype    nvarchar(20)    NOT NULL,
    chot     BOOLEAN             DEFAULT false NULL,
    aid      int             NOT NULL,
    primary key (cid)
);



/* 
 * TABLE: forder 
 */
# 订单主表
CREATE TABLE forder(
    fid        int      not null auto_increment,
    fdate      datetime        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    ftotal     nvarchar(20)    NOT NULL,
    fname      nvarchar(20)    NOT NULL,
    fphone     nvarchar(20)    NOT NULL,
    fremark    nvarchar(50)    NOT NULL,
    femail     nvarchar(20)    NOT NULL,
    fpost      nvarchar(10)    NOT NULL,
    uid        int             NOT NULL,
    aid        int             NULL,
    sid        int             NOT NULL,
    primary key (fid)
);
# 设置自增值
ALTER TABLE forder AUTO_INCREMENT=2016090801;



/* 
 * TABLE: goods 
 */
# 产品表
CREATE TABLE goods(
    gid           int                 not null auto_increment,
    gname         nvarchar(20)        NOT NULL,
    gprice        double precision    NOT NULL,
    gpic          nvarchar(100)       NOT NULL,
    gremark       nvarchar(500)       NOT NULL,
    gxremark      nvarchar(1000)      NULL,
    gdate         datetime            DEFAULT CURRENT_TIMESTAMP NOT NULL,
    giscommend    boolean             DEFAULT false NOT NULL,
    gisopen       boolean             DEFAULT true NOT NULL,
    cid           int                 NOT NULL,/*商品所属类别*/
    primary key (gid)
);
# 设置自增值
ALTER TABLE goods AUTO_INCREMENT=20160908;


/* 
 * TABLE: sorder 
 */
# 订单子表
CREATE TABLE sorder(
    sid        int             not null auto_increment,
    sname      nvarchar(20)    NULL,
    sprice     float           NULL,
    snumber    int             NULL,
    fid        int             NOT NULL,
    gid        int             NOT NULL,
    primary key (sid)
);


/* 
 * TABLE: status 
 */
# 订单状态表
CREATE TABLE status(
    sid       int             not null auto_increment,
    status    nvarchar(20)    NOT NULL,
    primary key (sid)
);



/* 
 * TABLE: users 
 */
# 用户信息表
CREATE TABLE users(
    uid         int             not null auto_increment,
    ulogin      nvarchar(20)    NOT NULL,
    uname       nvarchar(20)    NOT NULL,
    upass       nvarchar(20)    NOT NULL,
    usex        nvarchar(2)     NOT NULL,
    uphone      nvarchar(20)    NULL,
    upost       nvarchar(20)    NULL,
    uemail      nvarchar(20)    NULL,
    uaddress    nvarchar(20)    NULL,
    primary key (uid)
);


# 外键
ALTER TABLE category ADD FOREIGN KEY (aid) REFERENCES account(aid);


/* 
 * TABLE: forder 
 */
#主订单表外键
ALTER TABLE forder ADD FOREIGN KEY (uid) REFERENCES users(uid);


ALTER TABLE forder ADD FOREIGN KEY (aid) REFERENCES account(aid);


ALTER TABLE forder ADD FOREIGN KEY (sid) REFERENCES status(sid);


/* 
 * TABLE: goods 
 */
# 货物表
ALTER TABLE goods ADD FOREIGN KEY (cid) REFERENCES category(cid);


/* 
 * TABLE: sorder 
 */

ALTER TABLE sorder ADD FOREIGN KEY (fid) REFERENCES forder(fid);


ALTER TABLE sorder ADD FOREIGN KEY (gid) REFERENCES goods(gid);



# 测试用例

SELECT * FROM users;

INSERT INTO users(ulogin,uname,upass,usex,uphone,upost,uemail,uaddress) 
VALUES ('u1','小明','u1','男','13877985456','424435','10000@qq.com','湖南长沙');
INSERT INTO users(ulogin,uname,upass,usex,uphone,upost,uemail,uaddress) 
VALUES ('u1','小云','u2','女','13977985456','424435','10001@qq.com','中国北京');


SELECT * FROM account;

INSERT INTO account(alogin, aname, apass) VALUES ('a1','小王','a1');
INSERT INTO account(alogin, aname, apass) VALUES ('a2','小张','a2');


SELECT * FROM status;

INSERT INTO status(status) VALUES ('未支付');
INSERT INTO status(status) VALUES ('已支付');
INSERT INTO status(status) VALUES ('废单');

SELECT * FROM category;

INSERT INTO category(ctype, chot, aid) VALUES ('男士休闲',true,1);
INSERT INTO category(ctype, chot, aid) VALUES ('女士休闲',false,2);


SELECT * FROM goods;

INSERT INTO goods(gname,gprice, gpic, gremark, gxremark, gdate, giscommend,gisopen, cid)
VALUES ('爱国者mp3',0.01,'1.jpg','爱国者品牌','可以连续听歌n小时',DEFAULT,TRUE,TRUE,1);
INSERT INTO goods(gname,gprice, gpic, gremark, gxremark, gdate, giscommend,gisopen, cid)
VALUES ('惠普电脑',0.1,'2.jpg','HP品牌','4G内存,500GB硬盘.....',DEFAULT,TRUE,FALSE,1);


SELECT * FROM forder;

INSERT INTO forder(fdate, ftotal, fname, fphone, fremark, femail, fpost, uid, aid, sid) 
VALUES (NOW(),'4400','小敏','13245678','周六周日不要配送','33333@qq.com','424412',1,null,1);


SELECT * FROM sorder;

INSERT INTO sorder(sname, sprice, snumber,fid,gid) VALUES ('爱国者mp3',399,1,2016090801,20160908);
INSERT INTO sorder(sname, sprice, snumber,fid,gid) VALUES ('惠普电脑',4001,1,2016090801,20160909);

#####



#####


### 查询订单明细

select * from forder inner join sorder on forder.fid = sorder.fid;

### 查询某个用户今年网购的话费
select sum(cast(ftotal as decimal(10,2))) from forder 
where uid = 1 and year(fdate) = 2016;


### 查询首页显示的商品信息 类别是热点 推荐 有效 三个条件
select * from category;

select * from goods;

select * from goods 
where 
giscommend = true and gisopen = true 
and cid in(select  cid from category where chot = true);


















