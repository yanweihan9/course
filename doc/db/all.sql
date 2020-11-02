drop table if exists test;
CREATE TABLE `test` (
                        `id` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `course`.`test` (`id`, `name`) VALUES ('1', 'rr');

# ------------------
drop table if exists chapter;
CREATE TABLE `chapter` (
                        `id` char(8) not null comment 'ID',
                        `course_id` char(8) comment '课程ID',
                        `name` varchar(50) comment '名称',
primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment '大章';

INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('001','000', '测试大章节01');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('002','000', '测试大章节02');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('003','000', '测试大章节03');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('004','000', '测试大章节04');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('005','000', '测试大章节05');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('006','000', '测试大章节06');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('007','000', '测试大章节07');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('008','000', '测试大章节08');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('009','000', '测试大章节09');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('010','000', '测试大章节10');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('011','000', '测试大章节11');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('012','000', '测试大章节12');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('013','000', '测试大章节13');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('014','000', '测试大章节14');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('015','000', '测试大章节15');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('016','000', '测试大章节16');


-- 小节
drop table if exists `section`;
create table `section`
(
    `id`         char(8)     not null default '' comment 'id',
    `title`      varchar(50) not null comment '标题',
    `course_id`  char(8) comment '课程|course.id',
    `chapter_id` char(8) comment '大章|chapter.id',
    `video`      varchar(200) comment '视频',
    `time`       int comment '时长|单位秒',
    `charge`     char(1) comment '收费|C 收费；F 免费',
    `sort`       int comment '顺序',
    `created_at` datetime(3) comment '创建时间',
    `updated_at` datetime(3) comment '修改时间',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='小节';

alter table `section`
    add column (`vod` char(32) comment 'vod|阿里云vod');

insert into `section` (id, title, course_id, chapter_id, video, time, charge, sort, created_at, updated_at)
values ('00000001', '测试小节01', '00000001', '00000000', '', 500, 'f', 1, now(), now());

-- 分类
drop table if exists `category`;
create table `category`
(
    `id`     char(8)     not null default '' comment 'id',
    `parent` char(8)     not null default '' comment '父id',
    `name`   varchar(50) not null comment '名称',
    `sort`   int comment '顺序',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='分类';

insert into `category` (id, parent, name, sort)
values ('00000100', '00000000', '前端技术', 100);
insert into `category` (id, parent, name, sort)
values ('00000101', '00000100', 'html/css', 101);
insert into `category` (id, parent, name, sort)
values ('00000102', '00000100', 'javascript', 102);
insert into `category` (id, parent, name, sort)
values ('00000103', '00000100', 'vue.js', 103);
insert into `category` (id, parent, name, sort)
values ('00000104', '00000100', 'react.js', 104);
insert into `category` (id, parent, name, sort)
values ('00000105', '00000100', 'angular', 105);
insert into `category` (id, parent, name, sort)
values ('00000106', '00000100', 'node.js', 106);
insert into `category` (id, parent, name, sort)
values ('00000107', '00000100', 'jquery', 107);
insert into `category` (id, parent, name, sort)
values ('00000108', '00000100', '小程序', 108);
insert into `category` (id, parent, name, sort)
values ('00000200', '00000000', '后端技术', 200);
insert into `category` (id, parent, name, sort)
values ('00000201', '00000200', 'java', 201);
insert into `category` (id, parent, name, sort)
values ('00000202', '00000200', 'springboot', 202);
insert into `category` (id, parent, name, sort)
values ('00000203', '00000200', 'spring cloud', 203);
insert into `category` (id, parent, name, sort)
values ('00000204', '00000200', 'ssm', 204);
insert into `category` (id, parent, name, sort)
values ('00000205', '00000200', 'python', 205);
insert into `category` (id, parent, name, sort)
values ('00000206', '00000200', '爬虫', 206);
insert into `category` (id, parent, name, sort)
values ('00000300', '00000000', '移动开发', 300);
insert into `category` (id, parent, name, sort)
values ('00000301', '00000300', 'android', 301);
insert into `category` (id, parent, name, sort)
values ('00000302', '00000300', 'ios', 302);
insert into `category` (id, parent, name, sort)
values ('00000303', '00000300', 'react native', 303);
insert into `category` (id, parent, name, sort)
values ('00000304', '00000300', 'ionic', 304);
insert into `category` (id, parent, name, sort)
values ('00000400', '00000000', '前沿技术', 400);
insert into `category` (id, parent, name, sort)
values ('00000401', '00000400', '微服务', 401);
insert into `category` (id, parent, name, sort)
values ('00000402', '00000400', '区块链', 402);
insert into `category` (id, parent, name, sort)
values ('00000403', '00000400', '机器学习', 403);
insert into `category` (id, parent, name, sort)
values ('00000404', '00000400', '深度学习', 404);
insert into `category` (id, parent, name, sort)
values ('00000405', '00000400', '数据分析&挖掘', 405);
insert into `category` (id, parent, name, sort)
values ('00000500', '00000000', '云计算&大数据', 500);
insert into `category` (id, parent, name, sort)
values ('00000501', '00000500', '大数据', 501);
insert into `category` (id, parent, name, sort)
values ('00000502', '00000500', 'hadoop', 502);
insert into `category` (id, parent, name, sort)
values ('00000503', '00000500', 'spark', 503);
insert into `category` (id, parent, name, sort)
values ('00000504', '00000500', 'hbase', 504);
insert into `category` (id, parent, name, sort)
values ('00000505', '00000500', '阿里云', 505);
insert into `category` (id, parent, name, sort)
values ('00000506', '00000500', 'docker', 506);
insert into `category` (id, parent, name, sort)
values ('00000507', '00000500', 'kubernetes', 507);
insert into `category` (id, parent, name, sort)
values ('00000600', '00000000', '运维&测试', 600);
insert into `category` (id, parent, name, sort)
values ('00000601', '00000600', '运维', 601);
insert into `category` (id, parent, name, sort)
values ('00000602', '00000600', '自动化运维', 602);
insert into `category` (id, parent, name, sort)
values ('00000603', '00000600', '中间件', 603);
insert into `category` (id, parent, name, sort)
values ('00000604', '00000600', 'linux', 604);
insert into `category` (id, parent, name, sort)
values ('00000605', '00000600', '测试', 605);
insert into `category` (id, parent, name, sort)
values ('00000606', '00000600', '自动化测试', 606);
insert into `category` (id, parent, name, sort)
values ('00000700', '00000000', '数据库', 700);
insert into `category` (id, parent, name, sort)
values ('00000701', '00000700', 'mysql', 701);
insert into `category` (id, parent, name, sort)
values ('00000702', '00000700', 'redis', 702);
insert into `category` (id, parent, name, sort)
values ('00000703', '00000700', 'mongodb', 703);

# 课程分类
drop table if exists `course_category`;
create table `course_category`
(
    `id`          char(8) not null default '' comment 'id',
    `course_id`   char(8) comment '课程|course.id',
    `category_id` char(8) comment '分类|course.id',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='课程分类';

-- 课程内容
drop table if exists `course_content`;
create table `course_content`
(
    `id`      char(8)    not null default '' comment '课程id',
    `content` mediumtext not null comment '课程内容',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='课程内容';

-- 课程内容文件
drop table if exists `course_content_file`;
create table `course_content_file`
(
    `id`        char(8) not null default '' comment 'id',
    `course_id` char(8) not null comment '课程id',
    `url`       varchar(100) comment '地址',
    `name`      varchar(100) comment '文件名',
    `size`      int comment '大小|字节b',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='课程内容文件';

-- 讲师
drop table if exists `teacher`;
create table `teacher`
(
    `id`       char(8)     not null default '' comment 'id',
    `name`     varchar(50) not null comment '姓名',
    `nickname` varchar(50) comment '昵称',
    `image`    varchar(100) comment '头像',
    `position` varchar(50) comment '职位',
    `motto`    varchar(50) comment '座右铭',
    `intro`    varchar(500) comment '简介',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='讲师';

-- 文件
drop table if exists `file`;
create table `file`
(
    `id`         char(8)      not null default '' comment 'id',
    `path`       varchar(100) not null comment '相对路径',
    `name`       varchar(100) comment '文件名',
    `suffix`     varchar(10) comment '后缀',
    `size`       int comment '大小|字节B',
    `use`        char(1) comment '用途|枚举[FileUseEnum]：COURSE("C", "讲师"), TEACHER("T", "课程")',
    `created_at` datetime(3) comment '创建时间',
    `updated_at` datetime(3) comment '修改时间',
    primary key (`id`),
    unique key `path_unique` (`path`)
) engine = innodb
  default charset = utf8mb4 comment ='文件';

alter table `file`
    add column (`shard_index` int comment '已上传分片');
alter table `file`
    add column (`shard_size` int comment '分片大小|B');
alter table `file`
    add column (`shard_total` int comment '分片总数');
alter table `file`
    add column (`key` varchar(32) comment '文件标识');
alter table `file`
    add unique key key_unique (`key`);
alter table `file`
    add column (`vod` char(32) comment 'vod|阿里云vod');

drop table if exists `user`;
create table `user`
(
    `id`         char(8)     not null default '' comment 'id',
    `login_name` varchar(50) not null comment '登陆名',
    `name`       varchar(50) comment '昵称',
    `password`   char(32)    not null comment '密码',
    primary key (`id`),
    unique key `login_name_unique` (`login_name`)
) engine = innodb
  default charset = utf8mb4 comment ='用户';

# 初始test/test
insert into `user` (id, login_name, name, password)
values ('10000000', 'test', '测试', 'e70e2222a9d67c4f2eae107533359aa4');

-- 资源
drop table if exists `resource`;
create table `resource`
(
    `id`      char(6)      not null default '' comment 'id',
    `name`    varchar(100) not null comment '名称|菜单或按钮',
    `page`    varchar(50)  null comment '页面|路由',
    `request` varchar(200) null comment '请求|接口',
    `parent`  char(6) comment '父id',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='资源';

insert into `resource`
values ('01', '系统管理', null, null, null);
insert into `resource`
values ('0101', '用户管理', '/system/user', null, '01');
insert into `resource`
values ('010101', '保存', null, '["/system/admin/user/list", "/system/admin/user/save"]', '0101');
insert into `resource`
values ('010102', '删除', null, '["/system/admin/user/delete"]', '0101');
insert into `resource`
values ('010103', '重置密码', null, '["/system/admin/user/save-password"]', '0101');
insert into `resource`
values ('0102', '资源管理', '/system/resource', null, '01');
insert into `resource`
values ('010201', '保存/显示', null, '["/system/admin/resource"]', '0102');
insert into `resource`
values ('0103', '角色管理', '/system/role', null, '01');
insert into `resource`
values ('010301', '角色/权限管理', null, '["/system/admin/role"]', '0103');

drop table if exists `role`;
create table `role`
(
    `id`   char(8)      not null default '' comment 'id',
    `name` varchar(50)  not null comment '角色',
    `desc` varchar(100) not null comment '描述',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='角色';

insert into `role`
values ('00000000', '系统管理员', '管理用户、角色权限');
insert into `role`
values ('00000001', '开发', '维护资源');
insert into `role`
values ('00000002', '业务管理员', '负责业务管理');

drop table if exists `role_resource`;
create table `role_resource`
(
    `id`          char(8) not null default '' comment 'id',
    `role_id`     char(8) not null comment '角色|id',
    `resource_id` char(6) not null comment '资源|id',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='角色资源关联';

insert into `role_resource`
values ('00000000', '00000000', '01');
insert into `role_resource`
values ('00000001', '00000000', '0101');
insert into `role_resource`
values ('00000002', '00000000', '010101');
insert into `role_resource`
values ('00000003', '00000000', '010102');
insert into `role_resource`
values ('00000004', '00000000', '010103');
insert into `role_resource`
values ('00000005', '00000000', '0102');
insert into `role_resource`
values ('00000006', '00000000', '010201');
insert into `role_resource`
values ('00000007', '00000000', '0103');
insert into `role_resource`
values ('00000008', '00000000', '010301');

drop table if exists `role_user`;
create table `role_user`
(
    `id`      char(8) not null default '' comment 'id',
    `role_id` char(8) not null comment '角色|id',
    `user_id` char(8) not null comment '用户|id',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='角色用户关联';

insert into `role_user`
values ('00000000', '00000000', '10000000');

-- 会员
drop table if exists `member`;
create table `member`
(
    `id`            char(8)     not null default '' comment 'id',
    `mobile`        varchar(11) not null comment '手机号',
    `password`      char(32)    not null comment '密码',
    `name`          varchar(50) comment '昵称',
    `photo`         varchar(200) comment '头像url',
    `register_time` datetime(3) comment '注册时间',
    primary key (`id`),
    unique key `mobile_unique` (`mobile`)
) engine = innodb
  default charset = utf8mb4 comment ='会员';

# 初始test/test
insert into `member` (id, mobile, password, name, photo, register_time)
values ('00000000', '12345678901', 'e70e2222a9d67c4f2eae107533359aa4', '测试', null, now());

# 短信验证码
drop table if exists `sms`;
create table `sms`
(
    `id`     char(8)     not null default '' comment 'id',
    `mobile` varchar(50) not null comment '手机号',
    `code`   char(6)     not null comment '验证码',
    `use`    char(1)     not null comment '用途|枚举[SmsUseEnum]：REGISTER("R", "注册"), FORGET("F", "忘记密码")',
    `at`     datetime(3) not null comment '生成时间',
    `status` char(1)     not null comment '用途|枚举[SmsStatusEnum]：USED("U", "已使用"), NOT_USED("N", "未使用")',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='短信验证码';

insert into `sms` (id, mobile, code, `use`, at, status)
values ('00000000', '12345678901', '123456', 'R', now(), 'N');

# 会员课程报名
drop table if exists `member_course`;
create table `member_course`
(
    `id`        char(8)     not null default '' comment 'id',
    `member_id` char(8)     not null comment '会员id',
    `course_id` char(8)     not null comment '课程id',
    `at`        datetime(3) not null comment '报名时间',
    primary key (`id`),
    unique key `member_course_unique` (`member_id`, `course_id`)
) engine = innodb
  default charset = utf8mb4 comment ='会员课程报名';

# ---------------------- 测试

drop table if exists `test`;
create table `test`
(
    `id`   char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment ='测试';

insert into `test` (id, name)
values (1, '测试');
insert into `test` (id, name)
values (2, '测试2');




