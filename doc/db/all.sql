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



