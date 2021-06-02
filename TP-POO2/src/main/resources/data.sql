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

INSERT INTO `bd-grupo-08-oo2-2021`.`persona` VALUES(1,'Macario',sysdate(),35855188,'Sebastián Matías',sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`persona` VALUES(2,'Macario',sysdate(),35855187,'Martín Nahuel',sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`persona` VALUES(3,'Torrez Salvatierra',sysdate(),40000000,'Facundo',sysdate());
INSERT INTO `bd-grupo-08-oo2-2021`.`persona` VALUES(4,'Rivera',sysdate(),40000001,'Tomás',sysdate());

INSERT INTO `bd-grupo-08-oo2-2021`.`rodado` VALUES(1,sysdate(),'res543',sysdate(),'Renault 12');
INSERT INTO `bd-grupo-08-oo2-2021`.`rodado` VALUES(2,sysdate(),'has764',sysdate(),'Renault Fluence');
INSERT INTO `bd-grupo-08-oo2-2021`.`rodado` VALUES(3,sysdate(),'jer663',sysdate(),'Toyota Etios');
INSERT INTO `bd-grupo-08-oo2-2021`.`rodado` VALUES(4,sysdate(),'oop232',sysdate(),'Toyota Hilux');

INSERT INTO `bd-grupo-08-oo2-2021`.`permiso` (`id_permiso`, `createdat`, `fecha`, `updatedat`, `id_persona`) VALUES ('5', '2021-05-30 18:08:54.000000', '2021-05-31', '2021-05-30 18:08:54.000000', '1');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso` (`id_permiso`, `createdat`, `fecha`, `updatedat`, `id_persona`) VALUES ('4', '2021-05-30 18:08:55.000000', '2021-05-15', '2021-05-30 18:08:55.000000', '2');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso` (`id_permiso`, `createdat`, `fecha`, `updatedat`, `id_persona`) VALUES ('6', '2021-05-30 18:08:56.000000', '2021-06-01', '2021-05-30 18:08:56.000000', '3');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso` (`id_permiso`, `createdat`, `fecha`, `updatedat`, `id_persona`) VALUES ('7', '2021-05-30 18:08:57.000000', '2021-06-10', '2021-05-30 18:08:57.000000', '4');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso` (`id_permiso`, `createdat`, `fecha`, `updatedat`, `id_persona`) VALUES ('8', '2021-05-30 18:08:58.000000', '2021-06-20', '2021-05-30 18:08:58.000000', '1');

INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_diario` (`motivo`, `id_permiso_diario`) VALUES ('Visita a familiar', '4');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_diario` (`motivo`, `id_permiso_diario`) VALUES ('Visita Medica', '6');

INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_periodo` (`cant_dias`, `vacacion`, `id_permiso_periodo`, `id_rodado`) VALUES ('7', b'1', '5', '1');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_periodo` (`cant_dias`, `vacacion`, `id_permiso_periodo`, `id_rodado`) VALUES ('10', b'0', '7', '3');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_periodo` (`cant_dias`, `vacacion`, `id_permiso_periodo`, `id_rodado`) VALUES ('14', b'1', '8', '2');

INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('4', '1');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('4', '3');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('5', '2');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('5', '4');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('6', '5');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('6', '4');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('7', '5');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('8', '4');
INSERT INTO `bd-grupo-08-oo2-2021`.`permiso_lugar` (`id_permiso`, `id_lugar`) VALUES ('8', '5');
