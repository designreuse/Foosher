INSERT INTO `test`.`user` (`enabled`, `firstname`, `lastname`, `password`, `username`) VALUES ('1', 'Admin', 'Foosher', '21232f297a57a5a743894a0e4a801fc3', 'admin');
INSERT INTO `test`.`role` (`enabled`, `code`, `description`) VALUES ('1', 'ROLE_ADMIN', 'Administrator');
INSERT INTO `test`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');