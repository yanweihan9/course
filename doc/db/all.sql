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

INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('000','000', '测试大章节1');
INSERT INTO `course`.`chapter` (`id`,course_id, `name`) VALUES ('001','002', '测试大章节2');


