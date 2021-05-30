use `bd-grupo-08-oo2-2021`;

INSERT INTO `bd-grupo-08-oo2-2021`.`perfil` VALUES (1, sysdate(), 'ROLE_ADMIN',  sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`perfil` VALUES (2, sysdate(), 'ROLE_AUDIT',  sysdate());

INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (1, 'Macario', sysdate(), 'martin@gmail.com', 1, 'Martin', 'martin', 35855187, '$2a$10$Ls/ihw98dBx4CJCrdJ.fKOqDhwICbHLmpTuAu1GTMqnx59jlNTCBK', 1, sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (2, 'Macario', sysdate(), 'sebastian@gmail.com', 1, 'Sebastian', 'sebastian', 35855188, '$2a$10$5twZzQQA9NcFH6/ACjeCL.1W5l93V/JJobVNkghWhvrXZne59Nghi', 1, sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (3, 'Rivera', sysdate(), 'tomas@gmail.com', 1, 'Tomas', 'tomas', 40000000, '$2a$10$iab9QMFdqe58R8q.L.Wyv.mdSoN0Yo1W.F.oH4MRA9IysqYEDj/3e', 2, sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (4, 'Torrez', sysdate(), 'facundo@gmail.com', 1, 'Facundo', 'facundo', 40000001, '$2a$10$HUBgSAYippeVJ3niYaTKju5jXgXls7Ng5Zv/FLzCelT7Mlne6BV8K', 3, sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (5, 'Admin', sysdate(), 'admin@gmail.com', 1, 'Admin', 'admin', 35000000, '$2a$10$TjadzzHEbWGySM8226q0heJepvH4P1DxSNCD1nC.H1lBDrqxs8urK', 3, sysdate(), 1);
INSERT INTO `bd-grupo-08-oo2-2021`.`usuario` VALUES (6, 'User', sysdate(), 'user@gmail.com', 1, 'User', 'user', 35000001, '$2a$10$GjKL5jibD0w70oJwCcYJIOr..lNWpph8dnHJmpMbf5yF7J8QwYnpS', 0, sysdate(), 2);

INSERT INTO `bd-grupo-08-oo2-2021`.`lugar` VALUES(1,"1832",sysdate(),"Lomas de Zamora",sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`lugar` VALUES(2,"1834",sysdate(),"Temperley",sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`lugar` VALUES(3,"1828",sysdate(),"Banfield",sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`lugar` VALUES(4,"1820",sysdate(),"Lanus",sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`lugar` VALUES(5,"1609",sysdate(),"Beccar",sysdate()); 



commit;