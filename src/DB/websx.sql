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
('唐海龙','511304199806082214','重庆市巴南区李家沱正街169号2栋8-1',1,'1998-06-08','生活不止眼前的苟且,还有诗和远方');

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

insert into account(uid,name,password,email,phone,time,type,logo,status) values
(1,'Tang223333','Thl082214','1755517380@qq.com','18502321550',now(),2,'',0);


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

select * from game;

#dispose（配置表）
create table dispose(
gid int(11) comment '游戏id',
systemDown varchar(200) comment '操作系统低',
handlerDown varchar(200) comment '处理器低',
ramDown varchar(200) comment '内存低',
gpuDown varchar(200) comment '显卡低',
storeDown varchar(200) comment '存储低',
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
fid int(11) comment '游戏id',
aid int(11) comment '账户id',
time datetime comment '关注时间',
primary key(id),
constraint foreign key(fid) references forum(id),
constraint foreign key(aid) references account(id)
)engine=InnoDB default charset=utf8;

insert into concern_forum(fid,aid,time)
values(1,1,now());

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

select * from img;

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

select * from news_collect;

select * from concern_forum where aid=1 and fid=1;