use `bd-grupo-08-oo2-2021`;
INSERT INTO `bd-grupo-08-oo2-2021`.`perfil` VALUES (1, sysdate(), 'ROLE_ADMIN',  sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`perfil` VALUES (2, sysdate(), 'ROLE_AUDIT',  sysdate());

INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (1, 'Macario', sysdate(), 'martin@gmail.com', 1, 'Martin', 'martin', 35855187, '$2a$10$Ls/ihw98dBx4CJCrdJ.fKOqDhwICbHLmpTuAu1GTMqnx59jlNTCBK', 'DNI', sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (2, 'Macario', sysdate(), 'sebastian@gmai.com', 1, 'Sebastian', 'sebastian', 35855188, '$2a$10$5twZzQQA9NcFH6/ACjeCL.1W5l93V/JJobVNkghWhvrXZne59Nghi', 'DNI', sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (3, 'Rivera', sysdate(), 'tomas@gmai.com', 1, 'Tomas', 'tomas', 40000000, '$2a$10$iab9QMFdqe58R8q.L.Wyv.mdSoN0Yo1W.F.oH4MRA9IysqYEDj/3e', 'DNI', sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (4, 'Torrez', sysdate(), 'facundo@gmai.com', 1, 'Facundo', 'facundo', 40000001, '$2a$10$HUBgSAYippeVJ3niYaTKju5jXgXls7Ng5Zv/FLzCelT7Mlne6BV8K', 'DNI', sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (5, 'Admin', sysdate(), 'admin@gmail.com', 1, 'Admin', 'admin', 35000000, '$2a$10$TjadzzHEbWGySM8226q0heJepvH4P1DxSNCD1nC.H1lBDrqxs8urK', 'DNI', sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (6, 'User', sysdate(), 'user@gmail.com', 1, 'User', 'user', 35000001, '$2a$10$9al.utxvti55jNhN47UW2uTVKNt60eY8ZH1GD5pQQIUhNceld/KP6', 'DNI', sysdate(), 2);

commit;