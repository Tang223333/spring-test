#create database websx;

#user表
create table user(
id int(11) auto_increment comment '用户id',
name varchar(50) comment '用户名',
number varchar(18) comment '生份证号',
address varchar(200) comment '家庭住址',
sex int(2) comment '性别',
birthday date comment '出生日期',
style varchar(200) comment '个性签名',
primary key(id)
)engine=InnoDB default charset=utf8;

insert into user(name,number,address,sex,birthday,style) values
('唐海龙','511304199806082214','重庆市巴南区李家沱正街169号2栋8-1',1,'1998-06-08','生活不止眼前的苟且,还有诗和远方'),
('余松柏','500382199702098277','重庆市南岸区上新街',1,'1997-02-10','我就是对错,我就是真理'),
("游姚","510382199702098277",'重庆市巴南区',2,'1999-02-09','我喜欢看书,就是喜欢'),
("老王","500382199003098277",'重庆市江津区',1,'1990-02-09','前后端通杀'),
("谢谢","500382198002098277",'重庆市合川区',1,'1980-02-09','java我都会'),
("任亮","500382198502098277",'重庆市万州',1,'1985-02-09','js作业交了??'),
("陈宇","500382199902098277",'重庆市万州',1,'1999-02-09','这个dnf打起还是可以'),
("琪琪","500382200002098277",'北京市东城区',2,'2000-02-09','我是一个爱吃肉的女孩'),
("张福军","500382199708098277",'北京市东城区',1,'1997-08-09','愉快的java'),
("康龙海","500382199909098277",'北京市西城区',1,'1999-09-09','龙游在天'),
("王菲","500382199002098277",'北京市海淀区',2,'1990-02-09','唱歌to be number one'),
("周迅","500382198002098277",'北京市朝阳区',2,'1980-02-09','我要我的张扬'),
("李宇春","500382198502098277",'北京市门头沟',2,'1985-02-09','去冲去放肆'),
("张晓荣","500382198103098277",'安徽省安徽市',2,'1981-03-09','以我为荣'),
("代昊林","500382199503108277",'福建省福州市',1,'1995-03-10','全能型文书双全'),
("蒋振东","510382199710098277",'广东省广州市',1,'1997-10-09','写个vue玩玩'),
("潘红飞","511382199810118277",'贵州省贵阳市',1,'1998-10-11','我有无尽可能'),
("张媛媛","500382200002098277",'海南省海口市',2,'2000-02-09','逛街!逛街'),
("田林","500382200110108277",'河南省郑州市',2,'2001-10-10','爱笑女孩运气中不会差'),
("貂蝉","500382190003118277",'湖北省武汉市',2,'1900-03-11','闭月之美,无可比拟');

select * from user;


#account(账户)
create table account(
id int(11) auto_increment comment '账户id',
uid int(11) comment '用户id',
name varchar(18) comment '账号名',
password varchar(20) comment '账号密码',
email varchar(50) comment '邮箱',
phone varchar(11) comment '手机号',
time datetime comment '创建时间',
type int(10) comment '账户类别',
status int(10) comment '账户状态',
logo varchar(200) comment '账户图片',
primary key(id),
constraint foreign key(uid) references user(id)
)engine=InnoDB default charset=utf8;

select u.*,a.name as accountName,a.password,a.email,a.phone,a.time,a.status,a.logo from user u left outer join account a on a.uid=u.id;

insert into account(uid,name,password,email,phone,time,type,logo,status) values
(1,'Tang223333','Thl082214','1755517380@qq.com','18502321550',now(),2,'',0);
insert into account(uid,name,password,email,phone,time,type,logo) value(2,'fishdominator',1234,'1325871848@qq.com','17318213833','1999-09-22 11:30:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(3,'memories','12345','1325871666@qq.com','18318213833','1998-09-22 14:38:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(4,'wang123','12345','1825871666@qq.com','12318213833','1990-09-22 17:38:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(5,'xie123','12345','1326771666@qq.com','18318212033','1990-09-12 20:38:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(6,'renliang','123','1325871066@qq.com','10318213833','1980-09-22 21:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(7,'chenyu','123','1925871066@qq.com','19318213833','1992-09-22 21:30:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(8,'qq','qq123','1725071066@qq.com','11418213833','1999-08-22 10:11:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(9,'junjun','j123','1655871066@qq.com','18318213833','2000-09-22 21:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(10,'longlong','ll123','1325871066@163.com','1318213833','1880-09-22 22:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(11,'feifei','long123','1625871066@qq.com','19318213833','2001-09-22 21:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(12,'zhou','fei123','1525871066@qq.com','14318213833','2000-10-22 10:38:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(13,'buliyucun','z123','1735871066@163.com','17898213833','2010-09-22 21:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(14,'xiaorong','1liyucun23','1895871066@126.com','15918213833','2010-09-22 14:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(15,'dai','xiao123','1665871066@163.com','17318212633','1999-10-22 21:38:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(16,'jiang','dai123','1995871066@qq.com','16618213833','2011-11-22 22:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(17,'hongfei','jiang123','1395871066@qq.com','17618213833','2012-01-22 23:38:30',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(18,'zhang12','hongfei123','1235871066@163.com','17618213833','2013-10-22 22:11:30',1,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(19,'tiantian','zdai123','1095871066@qq.com','11118213833','2001-11-22 22:38:29',2,'');
insert into account(uid,name,password,email,phone,time,type,logo) value(20,'diaodiao','tian123','1395871066@qq.com','14618213833','2008-03-22 14:38:30',2,'');


select * from account;

#game(游戏)
create table game(
id int(11) auto_increment comment '游戏id',
name varchar(18) comment '游戏名',
describes longtext comment '描述',
videos varchar(100) comment '游戏视频',
imgs varchar(100) comment '游戏图片',
types varchar(50) comment '游戏类型',
pType int(20) comment '平台类型',
developer varchar(50) comment '开发商',
publisher varchar(50) comment '发行商',
team varchar(200) comment '制作团队',
time datetime comment '发布时间',
status int(11) comment '发布时间',
primary key(id)
)engine=InnoDB default charset=utf8;

insert into game(name,describes,videos,imgs,types,pType,developer,publisher,team,time,status) values
('OUTBUDDIES DX','走进位于南大西洋深海的Bahlam，一座上古众神的沉没之城。一场海难之后，冒险者与海洋考古学家Nikolay Bernstein在约11000米深的海底清醒过来。他身负重伤，而且在不知情的情况下和一个超自然球形小跟班关联在了一起。为调查自己流落至此的原因，我们的主角开始深入探索这座失落的地下城，同时也逐渐意识到，有一个不祥的存在盘踞在它阴暗的洞穴中。'
,'video_game_01','img_game_01','type_game_01',1,'Julian Laufer','Headup','朱利安·劳弗（Julian Laufer），游戏设计师和开发人员',now(),1);
insert into game value(2,'NBA 2K20','经过长时间发展进化，《NBA 2K》系列俨然已成为超越篮球模拟游戏的存在。《NBA 2K20》不但拥有顶级的图像画面与游戏性、还拥有创新的游戏模式和无与伦比的球员操纵及自定义，重新定义了体育游戏的全新可能。此外，本作还拥有巨大的开放世界街区，如同全新上线的社交平台。玩家和球友们齐聚于此，帮助篮球文化再下一程。','video_game_02','img_game_02','type_game_02',1
,'Visual Concepts','2K','Fish','2020-06-21 11:11:12',2);
insert into game value(3,'七龙珠Z 卡卡洛特','《七龙珠Z 卡卡洛特》里可体验到悟空及其他Z战士的故事！除了史诗级的对战外，在七龙珠Z世界里亦可以与悟空、悟饭及贝吉达等等角色​​进行打斗、钓鱼、用餐及训练。请尽情探索新区域、体验故事中的冒险活动并加深与七龙珠Z其他英雄人物之间的羁绊吧。','video_game_03','img_game_03','type_game_03',1
,'VisualTop','4K','wwwwww','2019-05-21 20:11:12',1);
insert into game value(4,'刺客信条','从一名流浪者蜕变成传奇人物，踏上这趟奥德赛之旅，找出你过往的秘密并改变古希腊的命运。','video_game_04','img_game_04','type_game_04',1
,'VTop','uuu','wwiiii','2017-05-21 18:20:12',1);
insert into game value(5,'怒之铁拳4','《怒之铁拳》系列是史上经典清版动作游戏。已经发售的三部作品以其不会过时的游戏机制与电子舞曲风的背景音乐而佳评连连。作为系列的最新作品，《怒之铁拳4》（又译：格斗五人组/格斗三人组4/格斗四人组4）以经典为基础添加了新的游戏机制，精致的手绘特效与大师级音乐团队所创作的背景音乐','video_game_05','img_game_05','type_game_05',1
,'hello','kkK','wwwfish','2011-05-21 20:11:12',1);
insert into game value(6,'港诡实录','《港诡实录》（原名《牛一》）是一款以现代香港为背景的恐怖冒险游戏，融合了大量香港本地的都市传说，玩家能够从中体验到许多独特的本地文化和中国传统民俗习惯。同时，游戏中还原了唐楼、粤剧戏棚、港式屋邨等极具中国地方文化特色的建筑，玩家可以在其中自由探索，感受浓厚的香港氛围。','video_game_06','img_game_06','type_game_06',1
,'helloworld','w3school','wjjkkk','2013-02-21 10:11:12',1);
insert into game value(7,'TheCrew™2','革命性赛车游戏推出最新力作了！《The Crew® 2》将让你在前所未有的开放世界中，体验精彩刺激的美式赛车精神。欢迎来到动力世界，这个巨大、内容丰富且风貌多变的美丽赛场是专为全美各项动力竞速所打造的，可尽情从陆、海、空三个不同的领域体验不受拘束的探索旅程。来自全国各地的街头赛车手、职业赛车手、越野探险家及无限制竞速者都齐聚一堂，在各种类型的赛事中一较高下。与他们一起参加速度感满点的激烈赛事，然后与全世界一同分享每个光荣时刻吧。','video_game_07','img_game_07','type_game_07',1
,'Ilove','LOve','uuww','2009-05-21 13:11:12',1);
insert into game value(8,'古剑奇谭三(Gujian3)','《古剑奇谭三：梦付千秋星垂野》是网元圣唐旗下上海烛龙研发的大型3D单机角色扮演游戏。作为古剑系列的最新力作，本代采用了全即时战斗模式，战斗体验更加自由爽快。在前作基础上，本作进一步扩充古剑世界观，以写实唯美的风格描绘广阔的山川河岳，将久远的人情世故以全新的画面表现，带给玩家更贴近真实的游戏世界体验！','video_game_08','img_game_08','type_game_08',1
,'LastBads','ppK','zzz','2000-05-21 20:11:12',2);
insert into game value(9,'CivilizationVI','最早由传奇游戏设计大师席德·梅尔创作出来的《文明》是一款回合制策略游戏，让玩家尝试建立起一个帝国，并接受时间的考验。玩家将创建及带领自己的文明从石器时代迈向信息时代，并成为世界的领导者。在尝试建立起世界上赫赫有名的伟大文明的过程中，玩家将启动战争、实行外交、促进文化，同时正面对抗历史上的众多伟大领袖。','video_game_09','img_game_09','type_game_09',1
,'Tom','kkkkK','ktone','2011-05-21 06:11:12',1);
insert into game value(10,'王国纪元','王国纪元 (Lords Mobile)是一款千万玩家级多人在线&即时策略游戏。作为奇幻世界中一名伟大的领主，您将建立属于自己的王国，征召传奇英雄，打造强大军队，攻城掠地，与百人联盟携手合作，在总兵量高达230万以上全球史诗级战争之中，击溃所有敌人，最终成为世界之王！','video_game_10','img_game_10','type_game_10',1
,'comebaby','bb','bbnainai','2008-05-21 20:01:12',1);

select * from game;

#dispose（配置表）
create table dispose(
gid int(11) comment '游戏id',
systemDown varchar(200) comment '操作系统低',
handlerDown varchar(200) comment '处理器低',
ramDown varchar(200) comment '内存低',
gpuDown varchar(200) comment '显卡低',
storeDown varchar(200) comment '存储news_mutual低',
deviceDown varchar(200) comment '声卡低',
systemUp varchar(200) comment '操作系统高',
handlerUp varchar(200) comment '处理器高',
ramUp varchar(200) comment '内存高',
gpuUp varchar(200) comment '显卡高',
storeUp varchar(200) comment '存储高',
deviceUp varchar(200) comment '声卡高',
care varchar(50) comment '注意',
constraint foreign key(gid) references game(id)
)engine=InnoDB default charset=utf8;

insert into dispose(gid,systemDown,handlerDown,ramDown,gpuDown,storeDown,deviceDown,systemUp,handlerUp,ramUp,gpuUp,storeUp,deviceUp,care)
values(1
,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 750 MB 可用空间',''
,' Windows 7 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 750 MB 可用空间','','');
insert into dispose value(2,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 7 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 800 MB 可用空间','','');
insert into dispose value(3,'Windows 8 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 10 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 750 MB 可用空间','','');
insert into dispose value(4,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 1G 可用空间','',
' Windows 10 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 1G 可用空间','','');
insert into dispose value(5,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 8 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 1G  可用空间','','');
insert into dispose value(6,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 900 MB 可用空间','',
' Windows 8 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 900 MB 可用空间','','');
insert into dispose value(7,'Windows 7 or better','CPU @ 3,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 7 or better',' CPU @ 3,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 750 MB 可用空间','','');
insert into dispose value(8,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 7 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 800 MB 可用空间','','');
insert into dispose value(9,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 1G 可用空间','',
' Windows 7 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要 750 MB 可用空间','','');
insert into dispose value(10,'Windows 7 or better','CPU @ 2,2 GHZ',' 2 GB RAM',' Intel HD Graphics or better','需要 800 MB 可用空间','',
' Windows 7 or better',' CPU @ 2,4 GHZ Dual-Core','4 GB RAM','Intel HD Graphics or better','需要  1G 可用空间','','');

select * from dispose;

#game_mutual（配置表）
create table game_mutual(
gid int(11) comment '游戏id',
collects double(10,0) comment '收藏数',
comments double(10,0) comment '评论数',
grades int(10) comment '评分',
goods double(10,0) comment '好评数',
bads double(10,0) comment '差评数',
constraint foreign key(gid) references game(id)
);

insert into game_mutual(gid,collects,comments,grades,goods,bads)
values(1,1,1,9,1,0);
insert into game_mutual value(2,1,1,10,5,0);
insert into game_mutual value(3,2,3,7,6,2);
insert into game_mutual value(4,3,2,10,4,0);
insert into game_mutual value(5,4,2,2,2,1);
insert into game_mutual value(6,1,1,2,1,3);
insert into game_mutual value(7,4,2,6,3,1);
insert into game_mutual value(8,2,2,9,5,1);
insert into game_mutual value(9,3,1,4,1,3);
insert into game_mutual value(10,2,3,10,4,0);
select * from game_mutual;

#game_comment表（评论表）
create table game_comment(
id int(11) auto_increment comment '游戏评论id',
gid int(11) comment '游戏id',
aid int(11) comment '账户id',
content longtext comment '内容',
goodOrBad int(11) comment '好评或差评',
grade int(11) comment '评分',
ip varchar(200) comment 'ip地址',
time datetime comment '评论时间',
primary key(id),
constraint foreign key(gid) references game(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) values(1,1,'天下熙熙，皆为利来。天下攘攘，皆为利往。',1,9,'172.25.60.48',now());
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(2,11,"玩起来不错,有种特别的感觉",1,8,'173.25.60.48','2019-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(3,13,"糟糕极了",0,8,'173.29.60.48','2019-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(3,11,"啥子狗游戏",0,8,'163.25.60.48','2019-06-22 17:11:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(3,1,"玩起来还不错",1,8,'113.25.60.48','2019-06-22 17:36:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(4,13,"很不错啊",1,7,'153.25.60.48','2011-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(4,15,"差强人意",0,1,'203.25.60.48','2019-12-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(5,19,"挺刺激的",1,10,'210.11.60.48','2019-06-22 20:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(5,20,"让人迷醉",1,8,'222.25.60.48','2010-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(6,9,"不好不坏",1,6,'223.25.60.48','2019-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(7,4,"不知道干啥子",0,2,'199.25.60.48','2019-06-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(8,20,"玩起来不错,充值还欠火候",1,6,'200.115.66.66','2001-11-22 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(9,11,"这个游戏的场景做的不错",1,7,'111.111.111.48','2011-11-11 17:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(10,20,"兄弟来一起嗨",1,8,'119.119.60.48','2000-01-22 17:06:33');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(10,16,"谁来谁倒霉",0,2,'134.123.11.48','2013-07-28 23:06:25');
insert into game_comment(gid,aid,content,goodOrBad,grade,ip,time) value(10,17,"有钱就是大哥,老子真生气",0,1,'173.25.60.48','2019-06-22 17:06:25');

select * from game_comment;

#game_collect(游戏收藏)
create table game_collect(
id int(11) auto_increment comment '游戏收藏id',
gid int(11) comment '游戏id',
aid int(11) comment '账户id',
time datetime comment '收藏时间',
primary key(id),
constraint foreign key(gid) references game(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into game_collect(gid,aid,time)
values(1,1,now());
insert into game_collect(gid,aid,time) values(2,3,now());
insert into game_collect(gid,aid,time) values(3,11,now());
insert into game_collect(gid,aid,time) values(3,13,now());
insert into game_collect(gid,aid,time) values(4,17,now());
insert into game_collect(gid,aid,time) values(4,15,now());
insert into game_collect(gid,aid,time) values(4,13,now());
insert into game_collect(gid,aid,time) values(5,20,now());
insert into game_collect(gid,aid,time) values(5,16,now());
insert into game_collect(gid,aid,time) values(5,14,now());
insert into game_collect(gid,aid,time) values(5,13,now());
insert into game_collect(gid,aid,time) values(6,19,now());
insert into game_collect(gid,aid,time) values(7,3,now());
insert into game_collect(gid,aid,time) values(7,7,now());
insert into game_collect(gid,aid,time) values(7,20,now());
insert into game_collect(gid,aid,time) values(8,10,'2010-06-29 11:47:34');
insert into game_collect(gid,aid,time) values(8,13,'2013-06-29 11:47:34');
insert into game_collect(gid,aid,time) values(9,11,'2020-06-30 11:47:34');
insert into game_collect(gid,aid,time) values(9,12,'2020-05-30 11:47:34');
insert into game_collect(gid,aid,time) values(9,19,'2020-02-10 12:47:34');
insert into game_collect(gid,aid,time) values(10,1,now());

select * from game_collect;

#forum表
create table forum(
id int(11) auto_increment comment '论坛id',
aid int(11) comment '账号id',
concerns int(11) comment '关注数',
invitations int(11) comment '帖子数',
views int(11) comment '观看数',
name varchar(20) comment '论坛名',
logo longtext comment '论坛图片',
ip varchar(200) comment 'ip地址',
primary key(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into forum(aid,concerns,invitations,views,name,logo,ip) values
(1,1,1,1,'唐海龙的论坛','','172.25.60.48');
insert  into forum(aid,concerns,invitations,views,name,logo,ip) value(9,1,1,1,'chenyu论坛','','177.125.160.48');
insert  into forum(aid,concerns,invitations,views,name,logo,ip) value(11,1,1,1,'君君论坛','','177.125.160.48');
insert  into forum(aid,concerns,invitations,views,name,logo,ip) value(19,1,1,1,'非','','177.125.160.50');
insert  into forum(aid,concerns,invitations,views,name,logo,ip) value(13,1,1,1,'飞飞论坛','','177.125.160.130');
insert  into forum(aid,concerns,invitations,views,name,logo,ip) value(20,1,1,1,'甜甜论坛','','177.115.160.148');

select * from forum;

#invitation表
create table invitation(
id int(11) auto_increment comment '论坛id',
fid int(11) comment '论坛id',
aid int(11) comment '账号id',
content longtext comment '内容',
goods int(11) comment '点赞数',
bads int(11) comment '不点赞数',
collects int(11) comment '收藏数',
comments int(11) comment '评论数',
time datetime comment '发帖时间',
imgs longtext comment '帖子图片',
videos longtext comment '帖子视屏',
ip varchar(20) comment 'ip地址',
primary key(id),
constraint foreign key(fid) references forum(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip) values
(1,1,'我有一套5张卡片，可容纳250颗宝石...如果您感兴趣，请告诉我。',100,1,1,1,now(),'img_invitation_01','video_invitation_01','172.25.60.48');
insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip)
value(2,9,'这个游戏账号要不要',10,2,1,1,'2012-06-12 17:06:25','img_invitation_02','','177.125.160.48');
insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip)
value(3,11,'这个要不要',5,3,1,1,'2011-11-12 17:06:25','img_invitation_03','','177.125.160.48');
insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip)
value(4,19,'看我这个',3,2,1,1,'2015-11-12 17:06:25','img_invitation_04','','177.125.160.50');
insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip)
value(5,13,'可以来私聊',4,1,1,1,'2010-01-01 17:06:25','img_invitation_05','','177.125.160.130');
insert into invitation(fid,aid,content,goods,bads,collects,comments,time,imgs,videos,ip)
value(6,20,'看看',3,1,1,1,'2012-06-12 17:06:25','img_invitation_06','','177.115.160.148');

select * from invitation;

#invitation_comment表（评论表）
create table invitation_comment(
id int(11) auto_increment comment '论坛id',
iid int(11) comment '帖子id',
aid int(11) comment '账户id',
content longtext comment '内容',
time datetime comment '发帖时间',
imgs longtext comment '帖子图片',
videos longtext comment '帖子视屏',
ip varchar(20) comment 'ip地址',
primary key(id),
constraint foreign key(iid) references invitation(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into invitation_comment(iid,aid,content,time,imgs,videos) values
(1,1,'上帝就是上帝',now(),'img_invitation_comment_01','video_invitation_comment_01');

select * from invitation_comment;

#concern_forum(关注论坛)
create table concern_forum(
id int(11) auto_increment comment '游戏收藏id',
fid int(11) comment '论坛id',
aid int(11) comment '账户id',
time datetime comment '关注时间',
primary key(id),
constraint foreign key(fid) references forum(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into concern_forum(fid,aid,time)
values(1,1,now());
insert into concern_forum(fid,aid,time) value(2,9,'2020-05-22 17:06:26');
insert into concern_forum(fid,aid,time) value(3,11,'2011-01-22 17:06:26');
insert into concern_forum(fid,aid,time) value(4,19,'2001-11-20 17:06:26');
insert into concern_forum(fid,aid,time) value(5,13,'2010-10-20 11:06:26');
insert into concern_forum(fid,aid,time) value(6,20,'2017-02-22 20:06:26');

select * from concern_forum;

#invitation_collect(游戏收藏)
create table invitation_collect(
id int(11) auto_increment comment '游戏收藏id',
iid int(11) comment '游戏id',
aid int(11) comment '账户id',
time datetime comment '收藏时间',
primary key(id),
constraint foreign key(iid) references invitation(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into invitation_collect(iid,aid,time)
values(1,1,now());

select * from invitation_collect where aid=1 and iid=1;


create table type(
id int(11) auto_increment comment '游戏类型id',
tKeys varchar(200) comment '游戏类型key',
value int(10) comment '游戏类型',
primary key(id)
);

insert into type(tKeys,value) values
('type_game_01',1),
('type_game_01',2),
('type_game_01',3);
insert into type(tKeys,value) value('type_game_02',4);
insert into type(tKeys,value) value('type_game_02',5);
insert into type(tKeys,value) value('type_game_02',6);
insert into type(tKeys,value) value('type_game_03',1);
insert into type(tKeys,value) value('type_game_03',3);
insert into type(tKeys,value) value('type_game_03',6);
insert into type(tKeys,value) value('type_game_04',2);
insert into type(tKeys,value) value('type_game_04',3);
insert into type(tKeys,value) value('type_game_04',6);
insert into type(tKeys,value) value('type_game_05',2);
insert into type(tKeys,value) value('type_game_05',5);
insert into type(tKeys,value) value('type_game_05',6);
insert into type(tKeys,value) value('type_game_06',1);
insert into type(tKeys,value) value('type_game_06',2);
insert into type(tKeys,value) value('type_game_06',3);
insert into type(tKeys,value) value('type_game_07',1);
insert into type(tKeys,value) value('type_game_07',3);
insert into type(tKeys,value) value('type_game_07',4);
insert into type(tKeys,value) value('type_game_08',1);
insert into type(tKeys,value) value('type_game_08',2);
insert into type(tKeys,value) value('type_game_08',5);
insert into type(tKeys,value) value('type_game_09',1);
insert into type(tKeys,value) value('type_game_09',5);
insert into type(tKeys,value) value('type_game_09',6);
insert into type(tKeys,value) value('type_game_10',1);
insert into type(tKeys,value) value('type_game_10',2);
insert into type(tKeys,value) value('type_game_10',3);

select * from type;

create table video(
id int(11) auto_increment comment '视屏id',
vKeys varchar(200) comment '视频key',
value varchar(200) comment '地址',
primary key(id)
);

insert into video(vKeys,value) values
('video_invitation_01','https://steamcdn-a.akamaihd.net/steam/apps/256768767/movie480.webm?t=1579196676'),
('video_invitation_comment_01','https://steamcdn-a.akamaihd.net/steam/apps/256775685/movie480.webm?t=1582120745'),
('video_game_01','https://steamcdn-a.akamaihd.net/steam/apps/256787873/movie480_vp9.webm?t=1591377921'),
('video_news_01','https://steamcdn-a.akamaihd.net/steam/apps/256789524/movie480_vp9.webm?t=1592321391');

insert into video(vKeys,value) values
('video_game_02','https://media.st.dl.pinyuncloud.com/steam/apps/256761260/movie480.webm?t=1567806881'),
('video_game_03','https://media.st.dl.pinyuncloud.com/steam/apps/256773292/movie480.webm?t=1579881659'),
('video_game_04','https://media.st.dl.pinyuncloud.com/steam/apps/2033803/movie480.webm?t=1447363033'),
('video_game_05','https://media.st.dl.pinyuncloud.com/steam/apps/256783873/movie480_vp9.webm?t=1588284716'),
('video_game_06','https://media.st.dl.pinyuncloud.com/steam/apps/256765753/movie480.webm?t=1572488956'),
('video_game_07','https://media.st.dl.pinyuncloud.com/steam/apps/256686716/movie480.webm?t=1556554070'),
('video_game_08','https://media.st.dl.pinyuncloud.com/steam/apps/256767332/movie480.webm?t=1573817134'),
('video_game_09','https://media.st.dl.pinyuncloud.com/steam/apps/256672699/movie480.webm?t=1476737071'),
('video_game_10','https://media.st.dl.pinyuncloud.com/steam/apps/256790441/movie480_vp9.webm?t=1592894970');

select * from video;

CREATE TABLE img (
    id INT(11) AUTO_INCREMENT COMMENT '图片id',
    iKeys VARCHAR(200) COMMENT '图片key',
    value VARCHAR(200) COMMENT '地址',
    PRIMARY KEY (id)
);

select * from img where iKeys='img_game_01';

insert into img(iKeys,value) values
('img_invitation_01','https://steamcdn-a.akamaihd.net/steam/apps/897450/ss_19dc10c05ea4b05f742f8830e432d2a9a3fa58ab.600x338.jpg?t=1592476720'),
('img_invitation_01','https://steamcdn-a.akamaihd.net/steam/apps/897450/ss_3717262740e6e1b8a04b76d917b880b721df7870.600x338.jpg?t=1592476720'),
('img_invitation_comment_01','https://steamcdn-a.akamaihd.net/steam/apps/897450/ss_0b984826fecae5c162d3b0a18ff07afda0ee634b.600x338.jpg?t=1592476720'),
('img_invitation_comment_01','https://steamcdn-a.akamaihd.net/steam/apps/897450/ss_5c39f5cfa84050b4d9970f9b97d7fd54736a99a8.600x338.jpg?t=1592476720'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_acbef5e9da1d0ece67a0e493d5adbe0284e6ab77.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_6bb98d1c1f269f1bfbdbccf3e15e88715288897c.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_b6302993f983cf66e34e71bdf0b19d01a1063362.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_ea9a912b509f9e129ba4d2f46a77a7871e08d04b.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_fa48fbf7430e350f6832cd123ced7bb5a5ce3737.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_d8a7e8c2daaed769de94b4e9cb1e76c469ebc113.600x338.jpg?t=1591377941'),
('img_game_01','https://steamcdn-a.akamaihd.net/steam/apps/1083310/ss_8d8804cc5012fb7b1315e45f606a0cc0b9224341.600x338.jpg?t=1591377941'),
('img_news_01','https://steamcdn-a.akamaihd.net/steam/apps/610370/ss_0278ff2c4d3a7bc4b2e2968f27b07db332d81edf.600x338.jpg?t=1592462429');
insert into img(iKeys,value) value('img_game_02','https://media.st.dl.pinyuncloud.com/steam/apps/1089350/ss_cca9e0f6d522e7c0bd8ae1e9ac59712ccce43c4e.600x338.jpg?t=1573674198');
insert into img(iKeys,value) value('img_game_02','https://media.st.dl.pinyuncloud.com/steam/apps/1089350/ss_5232cc57a6a7e3aa5e4aad208b78113baa0d8e72.600x338.jpg?t=1573674198');
insert into img(iKeys,value) value('img_game_02','https://media.st.dl.pinyuncloud.com/steam/apps/1089350/ss_cdca0829735c8a803e32e5826e2aa5e34569a140.600x338.jpg?t=1573674198');
insert into img(iKeys,value) value('img_game_03','https://media.st.dl.pinyuncloud.com/steam/apps/851850/ss_99df46ea315597e06b62dfe15107db7b7c8ed1cb.600x338.jpg?t=1592517730');
insert into img(iKeys,value) value('img_game_03','https://media.st.dl.pinyuncloud.com/steam/apps/851850/ss_d2ccffa12841ccf7862914d80f38dd609a00ed81.600x338.jpg?t=1592517730');
insert into img(iKeys,value) value('img_game_03','https://media.st.dl.pinyuncloud.com/steam/apps/851850/ss_a3eb8f33e81877127d0ebf0ba23f2a82056eba05.600x338.jpg?t=1592517730');
insert into img(iKeys,value) value('img_game_04','https://media.st.dl.pinyuncloud.com/steam/apps/289650/ss_d825c8fd7c5472d17732bf3480760dd88924e551.600x338.jpg?t=1575045099');
insert into img(iKeys,value) value('img_game_04','https://media.st.dl.pinyuncloud.com/steam/apps/289650/ss_74122312de60a4f3e951e25f41dcd8f5f779a523.600x338.jpg?t=1575045099');
insert into img(iKeys,value) value('img_game_04','https://media.st.dl.pinyuncloud.com/steam/apps/289650/ss_facd76eb6789402e9caea63d0d0b18b84abdabae.600x338.jpg?t=1575045099');
insert into img(iKeys,value) value('img_game_05','https://media.st.dl.pinyuncloud.com/steam/apps/985890/ss_0cbc51b8ec12859e9f180217bee8b973f9b99924.600x338.jpg?t=1593104846');
insert into img(iKeys,value) value('img_game_05','https://media.st.dl.pinyuncloud.com/steam/apps/985890/ss_f1717ac6324e90d581fc0ed6ded94a0ff41ee6f7.600x338.jpg?t=1593104846');
insert into img(iKeys,value) value('img_game_05','https://media.st.dl.pinyuncloud.com/steam/apps/985890/ss_4dcdd6d0cb38e3bcb747ac7cf69b6b608ae2d46a.600x338.jpg?t=1593104846');
insert into img(iKeys,value) value('img_game_06','https://media.st.dl.pinyuncloud.com/steam/apps/1178490/ss_f5d8eae635d250fd19e957c578e8ffbeaa37052b.600x338.jpg?t=1582699231');
insert into img(iKeys,value) value('img_game_06','https://media.st.dl.pinyuncloud.com/steam/apps/1178490/ss_5c14c02d8bf86e985635d8c2fa21ca206f5ccfd6.600x338.jpg?t=1582699231');
insert into img(iKeys,value) value('img_game_06','https://media.st.dl.pinyuncloud.com/steam/apps/1178490/ss_08e6d076426f398a092680bec6e1dd3a44d9721e.600x338.jpg?t=1582699231');
insert into img(iKeys,value) value('img_game_07','https://media.st.dl.pinyuncloud.com/steam/apps/646910/ss_34662385e6d2ab37b49eae52bee0800f5e2dc767.600x338.jpg?t=1586868345');
insert into img(iKeys,value) value('img_game_07','https://media.st.dl.pinyuncloud.com/steam/apps/646910/ss_d7a89f47597c4c1ce2d0b49b0fc3e5f5e8e671e6.600x338.jpg?t=1586868345');
insert into img(iKeys,value) value('img_game_07','https://media.st.dl.pinyuncloud.com/steam/apps/646910/ss_75f2de49e2e2d78bb6d3415bc3e1427b58d8a8c2.600x338.jpg?t=1586868345');
insert into img(iKeys,value) value('img_game_08','https://media.st.dl.pinyuncloud.com/steam/apps/994280/ss_165106596f3f24f5ca2ca9e17748a72c597dd9b6.600x338.jpg?t=1589336425');
insert into img(iKeys,value) value('img_game_08','https://media.st.dl.pinyuncloud.com/steam/apps/994280/ss_c13b734ecac0283e2d46d057437c7f8047b9cf57.600x338.jpg?t=1589336425');
insert into img(iKeys,value) value('img_game_08','https://media.st.dl.pinyuncloud.com/steam/apps/994280/ss_841a30b8033ec89cf1f54e8b0aadc6213906a844.600x338.jpg?t=1589336425');
insert into img(iKeys,value) value('img_game_09','https://media.st.dl.pinyuncloud.com/steam/apps/289070/ss_36c63ebeb006b246cb740fdafeb41bb20e3b330d.600x338.jpg?t=1590082071');
insert into img(iKeys,value) value('img_game_09','https://media.st.dl.pinyuncloud.com/steam/apps/289070/ss_f501156a69223131ee8b12452f3003698334e964.600x338.jpg?t=1590082071');
insert into img(iKeys,value) value('img_game_09','https://media.st.dl.pinyuncloud.com/steam/apps/289070/ss_fd6bbe6791ee8ab68f8a91455fa3c25b4dd9bca7.600x338.jpg?t=1590082071');
insert into img(iKeys,value) value('img_game_10','https://media.st.dl.pinyuncloud.com/steam/apps/1041320/ss_af1fa603d9f4edb1675bbfc7cc6f7bac623d683f.600x338.jpg?t=1592894975');
insert into img(iKeys,value) value('img_game_10','https://media.st.dl.pinyuncloud.com/steam/apps/1041320/ss_9f6eccff0aa1ebfa90d9742db91c36c694b6923b.600x338.jpg?t=1592894975');
insert into img(iKeys,value) value('img_game_10','https://media.st.dl.pinyuncloud.com/steam/apps/1041320/ss_9f6eccff0aa1ebfa90d9742db91c36c694b6923b.600x338.jpg?t=1592894975');
insert into img(iKeys,value)  value('img_news_02','https://cdn2-unrealengine-1251447533.file.myqcloud.com/2kgmkt-bl3-bounty-of-blood-epic-product-feature-1920x1080-1920x1080-295190935.jpg?h=480&resize=1&w=854');
insert into img(iKeys,value)  value('img_news_03','https://cdn2.unrealengine.com/egs-strangerthings3thegame-bonusxp-g1a-00-1920x1080-235932723.jpg?h=480&resize=1&w=854');
insert into img(iKeys,value)  value('img_news_04','https://cdn2.unrealengine.com/egs-aermemoriesofold-forgottenkey-g1a-01-1920x1080-242875523.jpg?h=480&resize=1&w=854');
insert into img(iKeys,value) value('img_invitation_02','https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Fsamurai-shodown-reboot%2Fhome%2FEGS_SAMURAISHODOWN_SNKCORPORATION_G2_01-1920x1080-2ef9cd7303c86ff028db73cdd0f502412cde3e8e.jpg?');
insert into img(iKeys,value) value('img_invitation_03','https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Floon%2Fhome%2FScreenshots_SRTT_Brute_02-3840x2160-ecf8bf6576e415a8e004dde885388d13431547de.PNG?');
insert into img(iKeys,value) value('img_invitation_04','https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Fcontrol%2Fhome%2F004_RTX_ON-3840x2160-272c9f5fb7075fcfff99b3c687570d70e969bd9f.png?');
insert into img(iKeys,value) value('img_invitation_05','https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Fheather%2Fhome%2FEGS_RockstarGames_RedDeadRedemption2_G1A_04-1920x1080-3e2c5e1e843eac593d1957ea22ef5f128c34b995.jpg?');
insert into img(iKeys,value) value('img_invitation_06','https://cdn2.unrealengine.com/windbound-pre-order-beauty-shot-1920x1080-1920x1080-164311125.png');


select * from img;

select * from account order by id limit 10,10;

create table news(
id int(11) auto_increment comment '新闻id',
aid int(11) comment '账户id',
title varchar(200) comment '新闻题目',
writer varchar(200) comment '新闻作者',
time datetime comment '新闻时间',
content longtext comment '新闻内容',
videos varchar(200) comment '新闻视频',
imgs varchar(200) comment '新闻图片',
ip varchar(50) comment 'ip地址',
status int(11) comment '状态',
primary key(id),
constraint foreign key(aid) references account(id)
);

select * from news;

insert into news(aid,title,writer,time,content,videos,imgs,ip,status) values
(1,'Epic游戏商城参展 2020 年 PC Gaming Show','','2020-6-14',"大家好，\t\n
Epic游戏商城团队很高兴为今年的 PC Gaming Show 提供支持，展示数百名充满激情、才华横溢的开发人员的集体工作成果。\t\n
电脑游戏世界即将呈献超棒游戏，其中许多很快会在 Epic游戏商城中推出！\t\n
有什么吸引你眼球的么？想要了解特定游戏详情？在此 查看 2020 年 PC Gaming Show 的所有亮点。\t\n
现已推出\t\n
《Among Trees》抢先体验 在 6 月 20 日前省 15%！\t\n
《Dauntless:Call of the Void》更新\t\n
预购 & 愿望清单\t\n
《Mortal Shell》 2020 年即将推出\t\n
一款深度动作类 RPG 游戏。在这个支离破碎的世界中，你的精神和适应能力都将受到严峻的挑战。你的对手毫无怜悯之心，只有在生存的欲望中磨炼出的超强感知力和精准度。\t\n
《Unexplored 2:The Wayfarer's Legacy》 2021 年即将推出\t\n
一款雄心勃勃的轻度 rogue 动作角色扮演游戏，主打先进的世界、关卡和任务生成，更有华丽的视效风格以及优美的交响原声。\t\n
《Twin Mirror》 2020 年即将推出\t\n
山姆·希格斯被迫面对自己的过去，用自己独特的智能，解开家乡的黑暗秘密。但是，如果连自己都不知道能不能相信，又怎么会知道该信任谁呢？\t\n
《Airborne Kingdom》 2020 年秋季即将推出，在 6 月 20 日前预购可享 20% 折扣！\t\n
贫瘠的风景永远不会让你久留，但是也许你的努力可以将世界恢复至前乌托邦状态。发展部落、开发科技、发现失落王国。 \t\n
《Iron Harvest》 2020 年 9 月 1 日即将推出\t\n
一款让众多粉丝望穿秋水的即时战略游戏，背景设定在 1920+ 的平行世界中。控制巨型柴油朋克机甲，结合史诗级单人和合作战役，以及战场上充满激烈动作感的遭遇战。\t\n
《Ooblets》 2020 年抢先体验\t\n
集农场经营、动植物收集和小镇生活于一体的游戏，你可以在此探索 Oob 世界、参与斗舞、管理农场、定制房屋和角色，并结交 ooblet 伙伴。\t\n
《Surgeon Simulator 2》 2020 年 8 月即将推出\t\n
激动人心的续作，在原作的基础上，加上了大量疯狂的想法，如同注射了肾上腺素一般，把所有内容都提升到了新的高度……你会在旅途中遇到一大把（或者四大把？）惊喜（吓）！\t\n
《The Last Campfire》 2020 年夏季即将推出\t\n
来自 Hello Games 的一款冒险游戏，讲述了困于迷惘之地的孤独萤火找寻自身意义和归乡旅程的故事。\t\n
《Tony Hawk's Pro Skater 1 & 2》 9 月 4 日即将推出\t\n
重制版史诗级游戏合集，让你重新体验有史以来最具标志性的滑板游戏。 \t\n
《Phantom Brigade》 2021 年即将推出\t\n
一款回合制即时策略角色扮演游戏，专注深度的用户自定义玩法，故事剧情发展也全由玩家自行推进。\t\n
《Super Meat Boy Forever》 2020 年即将推出\t\n
事情就像发生在昨天一样历历在目，Meat Boy 和 Bandage Girl 从天空中一个爆炸的实验室逃了出来。现在，在这部  经典平台系列游戏最新的章节中，他们必须将女儿 Nugget 从怪物医生的手中解救出来。\t\n
《刺客信条：英灵殿》 2020 年末即将推出\t\n
扮演追求荣耀的的传奇维京战士艾沃尔，劫掠敌人、发展定居地并培育政治力量。\t\n
《Godfall》 2020 年末即将推出\t\n
来拯救阿派朗吧！维拉伦骑士是装备有传奇护甲套装勇者板甲的战斗大师。而你，则是最后一名维拉伦骑士。Godfall 这一近战动作及角色扮演类游戏，亦是刷宝杀戮类游戏的开山之作，恭候你来登顶。\t\n
《The Outlast Trials》\t\n
《Outlast》系列游戏最新作品。《The Outlast Trials》游戏背景设定在冷战时期，让玩家面对自己或其他试验对象所面临的恐怖……",'video_news_01','img_news_01','172.25.60.48',1);
insert into news(aid,title,writer,time,content,videos,imgs,ip,status) value(11,'《无主之地 3》最新 DLC 已推出：《浴血镖客》。前往残酷的火狱星边境星球，与当地人团结一致，消灭一个名叫"恶灵骑士"的野兽骑佣军暴力团伙。','','2020-06-25 00:00:00',
'你来到了荒蛮的边缘星球火狱星，在那里尝试打倒骑着野兽的 "恶灵骑士" 邪恶帮派，领取赏金。和本地硬派居民组队，保护并重建遗迹镇。骑乘新增载具喷气野兽，使用全新可互动物品，在神秘旁白的陪伴下，向恶灵骑士进击，塑造自己的硬核故事。','','img_news_02','172.25.60.48',1);
insert into news(aid,title,writer,time,content,videos,imgs,ip,status) value(13,'《Stranger Things 3:The Game》限时免费！这款冒险游戏是原创热剧《Stranger Things》第 3 季的官方伴侣游戏，集复古艺术风格与现代游戏机制于一体，打造出怀旧的合作冒险。 ','','2020-06-25 01:11:00',
'《Stranger Things 3:The Game》是热剧《Stranger Things》第 3 季的官方伴侣游戏！体验原作中熟悉的事件，发掘前所未有的任务、人物互动和秘密！此冒险游戏将特色复古艺术风格和现代游戏机制相结合，为你带来有着独特全新风味的欢乐复古作品。
和热剧《Stranger Things》一样，在《Stranger Things 3:The Game》中，团队合作是一切的核心。粉丝们可两人一组，扮演剧中十二位令人喜爱的角色之一，在本地合作游戏中探索 Hawkins 世界，解决谜题，对抗 The Upside Down 中出现的邪恶存在。','','img_news_03','192.111.60.48',1);
insert into news(aid,title,writer,time,content,videos,imgs,ip,status) value(20,'《AER Memories of Old》','','2020-06-25 18:18:50',
'古老的诸神已被遗忘，迷失在让世界分崩离析的大事件中，只在天空中留下零落的岛屿。这个充满无尽天空、多彩岛屿和古代遗迹的神秘世界，正面临着跌入黑暗深渊的危险。作为仅存的变形者之一，你被派去朝拜诸神之地。揭开可以帮你拯救现实的秘密。','','img_news_04','199.111.66.48',1);
select * from news;

create table news_mutual(
nid int(11) comment '新闻id',
views double(10,0) comment '观看数',
goods double(10,0) comment '点赞数',
bads double(10,0) comment '差评数',
constraint foreign key(nid) references news(id)
);

insert into news_mutual(nid,views,goods,bads)
values(1,1,1,1);
insert into news_mutual value(2,4,3,5);
insert into news_mutual value(3,3,2,1);
insert into news_mutual value(4,4,3,1);

select * from news_mutual;

#game_collect(游戏收藏)
create table news_collect(
id int(11) auto_increment comment '游戏收藏id',
nid int(11) comment '游戏id',
aid int(11) comment '账户id',
time datetime comment '收藏时间',
primary key(id),
constraint foreign key(nid) references news(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into news_collect(nid,aid,time)
values(1,1,now());
insert  into  news_collect(nid,aid,time) value(2,11,'2011-06-22 17:06:27');
insert  into  news_collect(nid,aid,time) value(3,17,'2020-11-22 17:06:27');
insert  into  news_collect(nid,aid,time) value(4,19,'2010-01-22 11:11:11');

select * from news_collect;