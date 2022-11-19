-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.24 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 beyond_platform_db 的数据库结构
CREATE DATABASE IF NOT EXISTS `beyond_platform_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `beyond_platform_db`;


-- 导出  表 beyond_platform_db.ad_promotion 结构
CREATE TABLE IF NOT EXISTS `ad_promotion` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `adPicPath` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '广告图片存储路径',
  `adPV` bigint(50) DEFAULT NULL COMMENT '广告点击量',
  `carouselPosition` int(30) DEFAULT NULL COMMENT '轮播位（1-n）',
  `startTime` datetime DEFAULT NULL COMMENT '起效时间',
  `endTime` datetime DEFAULT NULL COMMENT '失效时间',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.ad_promotion 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `ad_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ad_promotion` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.app_category 结构
CREATE TABLE IF NOT EXISTS `app_category` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `categoryCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类编码',
  `categoryName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '分类名称',
  `parentId` bigint(30) DEFAULT NULL COMMENT '父级节点id',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='手游类别';

-- 正在导出表  beyond_platform_db.app_category 的数据：48 rows
/*!40000 ALTER TABLE `app_category` DISABLE KEYS */;
INSERT INTO `app_category` (`id`, `categoryCode`, `categoryName`, `parentId`, `createdBy`, `creationTime`, `modifyBy`, `modifyDate`) VALUES
	(1, 'ALL_GAME', '全部游戏', NULL, 1, '2016-08-12 18:11:47', NULL, NULL),
	(2, 'GAME_001', '休闲游戏', 1, 1, '2016-08-12 18:11:47', NULL, NULL),
	(3, 'GAME_002', '益智游戏', 1, 1, '2016-08-12 18:11:47', NULL, NULL),
	(4, 'GAME_003', '体育游戏', 1, 1, '2016-08-12 18:11:47', NULL, NULL),
	(5, 'GAME_004', '角色扮演', 1, 1, '2016-08-12 18:11:47', NULL, NULL),
	(115, 'GAME_004_01_02', '局域网', 28, 1, '2016-08-12 18:11:47', NULL, NULL),
	(48, 'GAME_001_02_02', '三国类', 20, 1, '2016-08-12 18:11:47', NULL, NULL),
	(52, 'GAME_002_01_02', '麻将', 22, 1, '2016-08-12 18:11:47', NULL, NULL),
	(53, 'GAME_002_01_03', '围棋', 22, 1, '2016-08-12 18:11:47', NULL, NULL),
	(54, 'GAME_002_02_01', '九宫格', 23, 1, '2016-08-12 18:11:47', NULL, NULL),
	(55, 'GAME_002_02_02', '杀手数独', 23, 1, '2016-08-12 18:11:47', NULL, NULL),
	(56, 'GAME_002_02_03', '梅花桩数独', 23, 1, '2016-08-12 18:11:47', NULL, NULL),
	(57, 'GAME_002_03_01', '车内逃脱', 24, 1, '2016-08-12 18:11:47', NULL, NULL),
	(19, 'GAME_001_01', '养成类', 2, 1, '2016-08-12 18:11:47', NULL, NULL),
	(20, 'GAME_001_02', '塔防类', 2, 1, '2016-08-12 18:11:47', NULL, NULL),
	(21, 'GAME_001_03', '消除类', 2, 1, '2016-08-12 18:11:47', NULL, NULL),
	(22, 'GAME_002_01', '棋牌类', 3, 1, '2016-08-12 18:11:47', NULL, NULL),
	(23, 'GAME_002_02', '数独类', 3, 1, '2016-08-12 18:11:47', NULL, NULL),
	(24, 'GAME_002_03', '密室逃脱类', 3, 1, '2016-08-12 18:11:47', NULL, NULL),
	(25, 'GAME_003_01', '球类', 4, 1, '2016-08-12 18:11:47', NULL, NULL),
	(26, 'GAME_003_02', '赛车类', 4, 1, '2016-08-12 18:11:47', NULL, NULL),
	(28, 'GAME_004_01', '射击类', 5, 1, '2016-08-12 18:11:47', NULL, NULL),
	(120, 'GAME_004_03_02', '多阵营', 42, 1, '2016-08-12 18:11:47', NULL, NULL),
	(119, 'GAME_004_03_01', '双阵营', 42, 1, '2016-08-12 18:11:47', NULL, NULL),
	(118, 'GAME_004_02_02', '3D', 41, 1, '2016-08-12 18:11:47', NULL, NULL),
	(117, 'GAME_004_02_01', '拳皇', 41, 1, '2016-08-12 18:11:47', NULL, NULL),
	(116, 'GAME_004_01_03', '广域网', 28, 1, '2016-08-12 18:11:47', NULL, NULL),
	(112, 'GAME_003_02_01', '汽车', 26, 1, '2016-08-12 18:11:47', NULL, NULL),
	(111, 'GAME_003_01_03', '排球', 25, 1, '2016-08-12 18:11:47', NULL, NULL),
	(110, 'GAME_003_01_02', '篮球', 25, 1, '2016-08-12 18:11:47', NULL, NULL),
	(109, 'GAME_003_01_01', '足球', 25, 1, '2016-08-12 18:11:47', NULL, NULL),
	(58, 'GAME_002_03_02', '房内逃脱', 24, 1, '2016-08-12 18:11:47', NULL, NULL),
	(41, 'GAME_004_02', '格斗类', 5, 1, '2016-08-12 18:11:47', NULL, NULL),
	(42, 'GAME_004_03', '策略对战', 5, 1, '2016-08-12 18:11:47', NULL, NULL),
	(43, 'GAME_004_04', '冒险升级', 5, 1, '2016-08-12 18:11:47', NULL, NULL),
	(44, 'GAME_001_01_01', '庄园类', 19, 1, '2016-08-12 18:11:47', NULL, NULL),
	(45, 'GAME_001_01_02', '荒岛类', 19, 1, '2016-08-12 18:11:47', NULL, NULL),
	(46, 'GAME_001_01_03', '经营类', 19, 1, '2016-08-12 18:11:47', NULL, NULL),
	(47, 'GAME_001_02_01', '丧尸类', 20, 1, '2016-08-12 18:11:47', NULL, NULL),
	(49, 'GAME_001_03_01', '同色消除', 21, 1, '2016-08-12 18:11:47', NULL, NULL),
	(50, 'GAME_001_03_02', '连线消除', 21, 1, '2016-08-12 18:11:47', NULL, NULL),
	(51, 'GAME_002_01_01', '象棋', 22, 1, '2016-08-12 18:11:47', NULL, NULL),
	(114, 'GAME_004_01_01', '单机', 28, 1, '2016-08-12 18:11:47', NULL, NULL),
	(113, 'GAME_003_02_02', '摩托车', 26, 1, '2016-08-12 18:11:47', NULL, NULL),
	(121, 'GAME_004_03_03', '5V5', 42, 1, '2016-08-12 18:11:47', NULL, NULL),
	(122, 'GAME_004_04_01', '单机', 43, 1, '2016-08-12 18:11:47', NULL, NULL),
	(123, 'GAME_004_04_01', '广域网', 43, 11, '2016-08-12 18:11:47', NULL, NULL),
	(59, 'GAME_002_03_03', '其他场景', 24, 1, '2016-08-12 18:11:47', NULL, NULL);
/*!40000 ALTER TABLE `app_category` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.app_info 结构
CREATE TABLE IF NOT EXISTS `app_info` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `softwareName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '软件名称',
  `APKName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'APK名称（唯一）',
  `supportROM` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '支持ROM',
  `interfaceLanguage` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '界面语言',
  `softwareSize` decimal(20,2) DEFAULT NULL COMMENT '软件大小（单位：M）',
  `updateDate` date DEFAULT NULL COMMENT '更新日期',
  `devId` bigint(30) DEFAULT NULL COMMENT '开发者id（来源于：dev_user表的开发者id）',
  `appInfo` varchar(5000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '应用简介',
  `status` bigint(30) DEFAULT NULL COMMENT '状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）',
  `onSaleDate` datetime DEFAULT NULL COMMENT '上架时间',
  `offSaleDate` datetime DEFAULT NULL COMMENT '下架时间',
  `flatformId` bigint(30) DEFAULT NULL COMMENT '所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）',
  `categoryLevel3` bigint(30) DEFAULT NULL COMMENT '所属三级分类（来源于：data_dictionary）',
  `downloads` bigint(30) DEFAULT NULL COMMENT '下载量（单位：次）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `categoryLevel1` bigint(30) DEFAULT NULL COMMENT '所属一级分类（来源于：data_dictionary）',
  `categoryLevel2` bigint(30) DEFAULT NULL COMMENT '所属二级分类（来源于：data_dictionary）',
  `logoPicPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片url路径',
  `logoLocPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LOGO图片的服务器存储路径',
  `versionId` bigint(30) DEFAULT NULL COMMENT '最新的版本id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.app_info 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `app_info` DISABLE KEYS */;
INSERT INTO `app_info` (`id`, `softwareName`, `APKName`, `supportROM`, `interfaceLanguage`, `softwareSize`, `updateDate`, `devId`, `appInfo`, `status`, `onSaleDate`, `offSaleDate`, `flatformId`, `categoryLevel3`, `downloads`, `createdBy`, `creationDate`, `modifyBy`, `modifyDate`, `categoryLevel1`, `categoryLevel2`, `logoPicPath`, `logoLocPath`, `versionId`) VALUES
	(48, '劲乐团U:O2Jam U', 'com.momocorp.o2jamu', '2.3及更高版本', '英文软件', 56.00, NULL, 1, '劲乐团U O2Jam U是一款音乐节拍游戏，跟着音乐的节奏点击屏幕即可，就是跳舞机，需要网络支持。\r\n注意：部分机型会卡死在启动界面或fc，结束进程后重新开启游戏就正常了。', 1, NULL, NULL, 3, 38, 1000, 1, '2016-08-22 11:43:02', NULL, NULL, 2, 19, '/BeyondPlatform/uploadfiles/com.momocorp.o2jamu.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.momocorp.o2jamu.jpg', NULL),
	(49, '塔防名将传', 'com.lbe.security', '2.2及更高版本', '简体中文', 9.00, NULL, 1, '三国塔防名将传是一款手机上的角色扮演类手机游戏，畅爽游戏新激情带来独特的刺激新玩法你在游戏当中也会变得愈加强大，拥有更为强悍的战技多样的冒险等待玩家在游戏里不断的去探索爽快经典优秀的游戏新内容缔造极致', 1, NULL, NULL, 1, 48, 2000, 1, '2016-08-22 11:47:11', NULL, NULL, 1, 3, '/BeyondPlatform/statics/uploadfiles/com.lbe.security2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.lbe.security2.jpg', NULL),
	(50, '和平精英', 'com.sp.protector.free', '2.3及更高版本', '简体中文', 3.00, NULL, 1, '《和平精英》采用虚幻4引擎研发，致力于从画面、地图、射击手感等多个层面，为玩家全方位打造出极具真实感的军事竞赛体验。 ', 1, NULL, NULL, 1, 116, 5000, 1, '2016-08-22 11:49:12', NULL, NULL, 1, 3, '/BeyondPlatform/statics/uploadfiles/com.sp.protector.free2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.sp.protector.free2.jpg', NULL),
	(51, '开心消消乐', 'com.google.android.inputmethod.pinyin', '4.2及更高版本', '简体中文', 16.00, NULL, 1, '《开心消消乐》是一款三消游戏，游戏画面精美、上手简单。玩家只需滑动手指让三个及以上的同色小动物横竖相连即可消除，完成每关的指定消除目标就可以过关。小动物的滑动还会触发很多神奇的效果，比如在四连直线和横线特效相邻时，两个互相拖动，两者同时触发，构成十字架；四连直线可以产生爆炸特效，使横排或竖排四个目标同时清空。\r\n四连直线+爆炸特效，可构成竖着四排，同时清空！威力很强。\r\n\r\n四连横线+爆炸特效，横向四排同时清空，同样威力很强。\r\n\r\n爆炸特效+爆炸特效，爆炸特效的扩大，同样威力很强。\r\n\r\n但横于竖是随即的，全部化为爆炸特效。这个是很实用的特效，大家一定要牢记。\r\n\r\n五连+五连，极难出现。两者相邻相互拖动，直接清屏，这最后一个纯属机缘巧合，玩家也不要强求。', 1, NULL, NULL, 3, 49, 8000, 1, '2016-08-22 11:53:23', NULL, NULL, 1, 3, '/BeyondPlatform/statics/uploadfiles/com.google.android.inputmethod.pinying.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.google.android.inputmethod.pinying.jpg', 37),
	(52, 'QQ飞车手游', 'com.speedsoftware.rootexplorer', '2.3及更高版本', '简体中文', 3.00, NULL, 1, 'qq飞车手游赛车排行-完美兼容手游,高清大屏,完美画质,给你真实享受.超越手机高端运行,PC深度适配,游戏不卡顿,操控无压力!', 1, NULL, NULL, 1, 112, 2340, 1, '2016-08-22 11:55:14', NULL, NULL, 1, 3, '/BeyondPlatform/statics/uploadfiles/com.speedsoftware.rootexplorer2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.speedsoftware.rootexplorer2.jpg', 38),
	(53, 'FIFA 15:终极队伍', 'com.katecca.screenofflockdonate', '2.2及更高版本', '简体中文', 1.00, NULL, 1, '《 FIFA 15：终极队伍 FIFA 15 Ultimate Team》是一款由巨头体育游戏公司EA推出的最新款足球体育游戏。游戏中由着真实球员，真实球队，真实联赛，让玩家不用出门也可以在足球场上一展雄风。欢迎 进入安卓智能手机和平板电脑上最真实的足球游戏。以全新的触摸操作感受每次传球和临门一脚的激动时刻。', 1, NULL, NULL, 1, 109, 20, 1, '2016-08-22 13:07:11', NULL, NULL, 1, 4, '/BeyondPlatform/statics/uploadfiles/com.katecca.screenofflockdonate3.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.katecca.screenofflockdonate3.jpg', NULL),
	(54, '复古传奇', 'com.plexnor.gravityscreenoffpro', '2.2及更高版本', '英文软件', 1.00, NULL, 1, '达叔带你玩儿传奇，\r\n装备秒回收那种。', 1, NULL, NULL, 1, 123, 23, 1, '2016-08-22 13:08:24', NULL, NULL, 1, 4, '/BeyondPlatform/statics/uploadfiles/com.plexnor.gravityscreenoffpro2.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.plexnor.gravityscreenoffpro2.jpg', NULL),
	(55, '机械迷城:Machinarium', 'air.net.machinarium.Machinarium.GP', '2.3及更高版本', '英文软件', 11.00, NULL, 1, '机械迷城Machinarium是一款解密冒险游戏，玩家可以在城市里随意的走动，跟场景或是其他同样是机器人互动，了解他们的需求以及帮忙他们，一步一步往事件的核心探索。 ', 3, NULL, NULL, 1, 122, 277, 1, '2016-08-22 13:09:44', NULL, NULL, 2, 20, '/BeyondPlatform/statics/uploadfiles/air.net.machinarium.Machinarium.GP.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\air.net.machinarium.Machinarium.GP.jpg', 36),
	(56, 'Dont Starve饥荒', 'com.kleientertainment.doNotStarvePocket', '4.0.3及更高版本', '英文软件', 4.00, NULL, 1, 'Don`t Starve: Pocket Edition移动版将深受超过4百万玩家喜爱的热门PC游戏移植到了安卓平台。现在你可以随时随地进入充满科学和魔法元素的世界，体验原汁原味的荒野生存游戏！\r\n你扮演威尔逊，一位被困住并传送到神秘荒野世界的勇敢无畏的绅士科学家。如果威尔逊希望逃出生天并找到回家的路，他必须充分利用所处的环境及这里的各种生物。\r\n进入一个光怪陆离而未经探索的世界，这里充满了奇怪的生物以及形形色色的危险和意外。收集资源以制作符合你的生存风格的物品和建筑。一路解开这块奇怪大陆上的各种谜团。', 5, NULL, '2016-08-22 13:28:16', 2, 122, 390, 1, '2016-08-22 13:11:51', 1, NULL, 2, 19, '/BeyondPlatform/statics/uploadfiles/com.kleientertainment.doNotStarvePocket.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket.jpg', 42),
	(57, '机械世界:Apparatus', 'com.bithack.apparatus', '1.6及更高版本', '英文软件', 11.00, NULL, 1, '在机械世界Apparatus游戏中你需要利用木板、钉子、绳索、圆轮等等各种道具搭建从简单到复杂的机械结构，使得小球可以最终滚落到蓝色方框中。可以利用的可不止重力，包括杠杆原理、滑轮等等，尤其是后面的关卡，你需要足够灵活的头脑才能解决问题，可玩性还是非常高的。', 3, NULL, NULL, 1, 59, 255, 1, '2016-08-22 13:13:27', NULL, NULL, 2, 20, '/BeyondPlatform/statics/uploadfiles/com.bithack.apparatus.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus.jpg', 41),
	(58, '沙盘玩具:The Powder Toy', 'com.doodleapps.powdertoy', '2.2及更高版本', '英文软件', 1.00, NULL, 1, '沙盘玩具The Powder Toy是一款模拟类游戏。想过自己建造核电站吗？或者自己做一个CPU？你甚至可以创建一个虚拟网络。沙盘玩具可以模拟空气的压力，速度，热，重力和无数的不同物质之间的相互作用，游戏提供各种形态的建材，用以构建复杂的机器或是电子元件，你可以模拟超酷的爆炸或是布线出复杂的机器人。欢迎提交您的作品。', 4, NULL, '2016-08-22 13:27:42', 3, 45, 2000, 1, '2016-08-22 13:14:56', 1, NULL, 2, 20, '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy.jpg', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy.jpg', 40),
	(59, '王者荣耀', 'com.timi-wangzherongyao', '2.2及更高版本', '中文软件', 2666.00, NULL, 1, '一款5V5的公平竞技手游', 1, NULL, NULL, 3, 121, 1000, 1, '2020-03-11 18:05:50', 1, '2020-03-11 18:38:27', 2, 26, '/BeyondPlatform/statics/uploadfiles/com.timi-wangzherongyao.png', 'D:\\soft\\apache-tomcat-9.1.4\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.timi-wangzherongyao.png', 43);
/*!40000 ALTER TABLE `app_info` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.app_version 结构
CREATE TABLE IF NOT EXISTS `app_version` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appId` bigint(30) DEFAULT NULL COMMENT 'appId（来源于：app_info表的主键id）',
  `versionNo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本号',
  `versionInfo` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '版本介绍',
  `publishStatus` bigint(30) DEFAULT NULL COMMENT '发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）',
  `downloadLink` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '下载链接',
  `versionSize` decimal(20,2) DEFAULT NULL COMMENT '版本大小（单位：M）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于dev_user开发者信息表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于dev_user开发者信息表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `apkLocPath` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'apk文件的服务器存储路径',
  `apkFileName` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '上传的apk文件名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.app_version 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `app_version` DISABLE KEYS */;
INSERT INTO `app_version` (`id`, `appId`, `versionNo`, `versionInfo`, `publishStatus`, `downloadLink`, `versionSize`, `createdBy`, `creationDate`, `modifyBy`, `modifyDate`, `apkLocPath`, `apkFileName`) VALUES
	(33, 58, 'V1.1.1', 'V1.1.1版本简介', 3, '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.31.apk', 1.00, 1, '2016-08-22 13:17:47', NULL, NULL, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.31.apk', 'com.doodleapps.powdertoy-V1.1.31.apk'),
	(34, 57, 'V1.1.1', '              V1.1.1版本简介', 3, '/BeyondPlatform/statics/uploadfiles/com.bithack.apparatus-V1.1.1.apk', 11.00, 1, '2016-08-22 13:19:42', 1, '2016-08-22 13:19:54', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.1.apk', 'com.bithack.apparatus-V1.1.1.apk'),
	(35, 56, 'V1.1.1', '              V1.1.1简介', 2, '/BeyondPlatform/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.1.apk', 4.00, 1, '2016-08-22 13:21:12', 1, '2016-08-22 13:28:07', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.1.apk', 'com.kleientertainment.doNotStarvePocket-V1.1.1.apk'),
	(36, 55, 'V1.1.1', '              V1.1.1简介', 3, '/BeyondPlatform/statics/uploadfiles/air.net.machinarium.Machinarium.GP-V1.1.1.apk', 11.00, 1, '2016-08-22 13:21:40', 1, '2016-08-22 13:21:57', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\air.net.machinarium.Machinarium.GP-V1.1.1.apk', 'air.net.machinarium.Machinarium.GP-V1.1.1.apk'),
	(37, 51, 'V1.1.1', 'V1.1.1简介', 3, '/BeyondPlatform/statics/uploadfiles/com.google.android.inputmethod.pinyin-V1.1.1.apk', 16.00, 1, '2016-08-22 13:24:07', NULL, NULL, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.google.android.inputmethod.pinyin-V1.1.1.apk', 'com.google.android.inputmethod.pinyin-V1.1.1.apk'),
	(38, 52, 'V1.1.1', 'V1.1.1简介', 3, '/BeyondPlatform/statics/uploadfiles/com.speedsoftware.rootexplorer-V1.1.1.apk', 3.00, 1, '2016-08-22 13:24:35', NULL, NULL, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.speedsoftware.rootexplorer-V1.1.1.apk', 'com.speedsoftware.rootexplorer-V1.1.1.apk'),
	(39, 58, 'V1.1.2', 'V1.1.2', 3, '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.2.apk', 2.00, 1, '2016-08-22 13:26:15', NULL, NULL, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.2.apk', 'com.doodleapps.powdertoy-V1.1.2.apk'),
	(40, 58, 'V1.1.3', 'V1.1.3简介', 2, '/BeyondPlatform/statics/uploadfiles/com.doodleapps.powdertoy-V1.1.3.apk', 2.00, 1, '2016-08-22 13:26:47', 1, '2016-08-22 13:27:42', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.doodleapps.powdertoy-V1.1.3.apk', 'com.doodleapps.powdertoy-V1.1.3.apk'),
	(41, 57, 'V1.1.2', '              V1.1.2简介', 3, '/BeyondPlatform/statics/uploadfiles/com.bithack.apparatus-V1.1.2.apk', 11.00, 1, '2016-08-22 13:27:32', 1, '2016-08-22 15:08:04', 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.bithack.apparatus-V1.1.2.apk', 'com.bithack.apparatus-V1.1.2.apk'),
	(42, 56, 'V1.1.2', 'V1.1.2简介', 3, '/BeyondPlatform/statics/uploadfiles/com.kleientertainment.doNotStarvePocket-V1.1.2.apk', 4.00, 1, '2016-08-22 15:00:32', NULL, NULL, 'D:\\soft\\apache-tomcat-7.0.41\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.kleientertainment.doNotStarvePocket-V1.1.2.apk', 'com.kleientertainment.doNotStarvePocket-V1.1.2.apk'),
	(43, 59, 'v_3.4.11', '一款5V5的公平竞技手游', 3, '/BeyondPlatform/statics/uploadfiles/com.timi-wangzherongyao-v_3.4.11.apk', 2999.00, 1, '2020-03-11 18:09:51', 1, '2020-03-11 18:38:44', 'D:\\java\\tomcat\\apache-tomcat-9.0.14\\webapps\\BeyondPlatform\\statics\\uploadfiles\\com.timi-wangzherongyao-v_3.4.11.apk', 'com.timi-wangzherongyao-v_3.4.11.apk');
/*!40000 ALTER TABLE `app_version` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.backend_user 结构
CREATE TABLE IF NOT EXISTS `backend_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userType` bigint(30) DEFAULT NULL COMMENT '用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  `userPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.backend_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `backend_user` DISABLE KEYS */;
INSERT INTO `backend_user` (`id`, `userCode`, `userName`, `userType`, `createdBy`, `creationDate`, `modifyBy`, `modifyDate`, `userPassword`) VALUES
	(1, 'admin', '系统管理员', 1, 1, '2016-08-20 00:13:41', NULL, NULL, '123456');
/*!40000 ALTER TABLE `backend_user` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.data_dictionary 结构
CREATE TABLE IF NOT EXISTS `data_dictionary` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `typeCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型编码',
  `typeName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型名称',
  `valueId` bigint(30) DEFAULT NULL COMMENT '类型值ID',
  `valueName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '类型值Name',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.data_dictionary 的数据：16 rows
/*!40000 ALTER TABLE `data_dictionary` DISABLE KEYS */;
INSERT INTO `data_dictionary` (`id`, `typeCode`, `typeName`, `valueId`, `valueName`, `createdBy`, `creationDate`, `modifyBy`, `modifyDate`) VALUES
	(1, 'USER_TYPE', '用户类型', 1, '超级管理员', 1, '2016-08-12 18:11:47', NULL, NULL),
	(2, 'USER_TYPE', '用户类型', 2, '财务', 1, '2016-08-12 18:11:47', NULL, NULL),
	(3, 'USER_TYPE', '用户类型', 3, '市场', 1, '2016-08-12 18:11:47', NULL, NULL),
	(4, 'USER_TYPE', '用户类型', 4, '运营', 1, '2016-08-12 18:11:47', NULL, NULL),
	(5, 'USER_TYPE', '用户类型', 5, '销售', 1, '2016-08-12 18:11:47', NULL, NULL),
	(6, 'APP_STATUS', 'APP状态', 1, '待审核', 1, '2016-08-12 18:11:47', NULL, NULL),
	(7, 'APP_STATUS', 'APP状态', 2, '审核通过', 1, '2016-08-12 18:11:47', NULL, NULL),
	(8, 'APP_STATUS', 'APP状态', 3, '审核未通过', 1, '2016-08-12 18:11:47', NULL, NULL),
	(9, 'APP_STATUS', 'APP状态', 4, '已上架', 1, '2016-08-12 18:11:47', NULL, NULL),
	(10, 'APP_STATUS', 'APP状态', 5, '已下架', 1, '2016-08-12 18:11:47', NULL, NULL),
	(11, 'APP_FLATFORM', '所属平台', 1, '手机', 1, '2016-08-12 18:11:47', NULL, NULL),
	(12, 'APP_FLATFORM', '所属平台', 2, '平板', 1, '2016-08-12 18:11:47', NULL, NULL),
	(14, 'PUBLISH_STATUS', '发布状态', 1, '不发布', 1, '2016-08-12 18:11:47', NULL, NULL),
	(15, 'PUBLISH_STATUS', '发布状态', 2, '已发布', 1, '2016-08-12 18:11:47', NULL, NULL),
	(16, 'PUBLISH_STATUS', '发布状态', 3, '预发布', 1, '2016-08-12 18:11:47', NULL, NULL),
	(13, 'APP_FLATFORM', '所属平台', 3, '通用', 1, '2016-08-12 18:11:47', NULL, NULL);
/*!40000 ALTER TABLE `data_dictionary` ENABLE KEYS */;


-- 导出  表 beyond_platform_db.dev_user 结构
CREATE TABLE IF NOT EXISTS `dev_user` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `devCode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者帐号',
  `devName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者名称',
  `devPassword` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者密码',
  `devEmail` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者电子邮箱',
  `devInfo` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '开发者简介',
  `createdBy` bigint(30) DEFAULT NULL COMMENT '创建者（来源于backend_user用户表的用户id）',
  `creationDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` bigint(30) DEFAULT NULL COMMENT '更新者（来源于backend_user用户表的用户id）',
  `modifyDate` datetime DEFAULT NULL COMMENT '最新更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 正在导出表  beyond_platform_db.dev_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `dev_user` DISABLE KEYS */;
INSERT INTO `dev_user` (`id`, `devCode`, `devName`, `devPassword`, `devEmail`, `devInfo`, `createdBy`, `creationDate`, `modifyBy`, `modifyDate`) VALUES
	(1, 'test001', '测试账户001', '123456', NULL, NULL, 1, '2016-08-20 00:13:41', NULL, NULL);
/*!40000 ALTER TABLE `dev_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
