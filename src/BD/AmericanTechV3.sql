--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-03-29 01:52:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2917 (class 0 OID 36516)
-- Dependencies: 288
-- Data for Name: estado_accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO estado_accion VALUES (1, 'Asociada', true);
INSERT INTO estado_accion VALUES (2, 'En Venta', true);
INSERT INTO estado_accion VALUES (3, 'En Solicitud', true);
INSERT INTO estado_accion VALUES (4, 'Inactiva', true);


--
-- TOC entry 2901 (class 0 OID 36441)
-- Dependencies: 272
-- Data for Name: motivo_postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_postulacion VALUES (1, 'Beneficios del Club', true);
INSERT INTO motivo_postulacion VALUES (2, 'Inversión', true);
INSERT INTO motivo_postulacion VALUES (3, 'Deporte', true);
INSERT INTO motivo_postulacion VALUES (5, 'Recreación', true);
INSERT INTO motivo_postulacion VALUES (6, 'Diversión', true);
INSERT INTO motivo_postulacion VALUES (7, 'Otros', true);
INSERT INTO motivo_postulacion VALUES (4, 'Ocio', true);


--
-- TOC entry 2819 (class 0 OID 36033)
-- Dependencies: 190
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO persona VALUES (25, '20469561', 'Gipsy', 'Martinez', 'http://i.imgur.com/5OGwIbO.jpg', '1991-06-11', 'F', 'gipsy.martinez@gmail.com', '04245609876', '02513647896', 'Barquisimeto', true);
INSERT INTO persona VALUES (19, '21125804', 'Beatriz', 'Encinoza', 'http://i.imgur.com/ggOJ5iL.jpg', '1991-03-08', 'F', 'beatrizencinoza@gmail.com', '04122345678', NULL, 'Barquisimeto', true);
INSERT INTO persona VALUES (4, '20322921', 'Jose', 'Abreu', 'http://i.imgur.com/Yv0dyo8.jpg', '1990-09-27', 'M', 'joseabreu@gmail.com', '04145559999', '02514449999', 'Av. Fajardo, Quibor', true);
INSERT INTO persona VALUES (5, '22186230', 'Fidel', 'Aliaga', 'http://i.imgur.com/mm8CZWD.jpg', '1992-08-18', 'M', 'fidel.alejos@gmail.com', '041423456788', '02512345678', 'Av. Libertador con calle 13', true);
INSERT INTO persona VALUES (15, '21140247', 'Mariangel', 'Arrieche', 'http://i.imgur.com/TXoivyT.jpg', '1991-04-09', 'F', 'mariangel.491@gmail.com', '04147652345', NULL, 'Av. Libertador con calle13', true);
INSERT INTO persona VALUES (6, '20350342', 'Anthony', 'Cordero', 'http://i.imgur.com/aAY7hKL.jpg', '1990-09-18', 'M', 'anthonycordero@gmail.com', '04145559999', '02512345678', 'Av. Venezuela con Moran', true);
INSERT INTO persona VALUES (27, '20400698', 'Karla', 'Moron', 'http://i.imgur.com/DL7iuGh.jpg', '1993-03-09', 'F', 'karlamoron.ucla1@gmail.com', '042476587654', '025165476543', 'Barquisimeto', true);
INSERT INTO persona VALUES (2, '12345678', 'Prisco', 'Canelón', 'http://i.imgur.com/dQJPfTr.jpg', '1981-04-01', 'M', 'carlos@gmail.com', '04249876668', '02513348765', 'Barquisimeto', true);
INSERT INTO persona VALUES (29, '19551347', 'Jose', 'Moron', 'http://i.imgur.com/7tDsbIt.jpg', '1990-07-04', 'M', 'josemoron@gmail.com', '0424567928', '02516879834', 'Yaritaagua', true);
INSERT INTO persona VALUES (10, '19835796', 'Rosmary', 'Fuentes', 'http://i.imgur.com/qsXtB2A.jpg', '1991-06-19', 'F', 'rosmaryfuentes@gmail.com', '04142345678', '02512567654', 'Yaritagua', true);
INSERT INTO persona VALUES (11, '19123456', 'Dixon', 'Garcia', 'http://i.imgur.com/DxGxqhY.jpg', '1990-05-20', 'M', 'dixongarcia@gmail.com', '04149876543', '02513456789', 'Av. Fajardo, Quibor', true);
INSERT INTO persona VALUES (12, '18892202', 'Hector', 'Gil', 'http://i.imgur.com/OPpIMSz.jpg', '1990-05-08', 'M', 'hg2_28@hotmail.com', '04148762345', '02518761234', 'Av. Lara con capanaparo', true);
INSERT INTO persona VALUES (13, '19104634', 'Xavier', 'Gutierrez', 'http://i.imgur.com/Nv1pWz8.jpg', '1989-01-19', 'M', 'xaviergutierrez@gmail.com', '04144349876', '02512225555', 'Av. Venezuela con calle 8', true);
INSERT INTO persona VALUES (14, '19113871', 'Hilder', 'Hernandez', 'http://i.imgur.com/S0doLDj.jpg', '1990-02-22', 'M', 'hilderhernandez@gmail.com', '04146787654', '02516667777', 'Av. Libertador con 52', true);
INSERT INTO persona VALUES (30, '20188616', 'Eliza', 'Oviedo', 'http://i.imgur.com/jAXMPg7.jpg', '1990-07-30', 'F', 'elisaswann30@gmail.com', '04245645365', '02518762783', 'Barquisimeto', true);
INSERT INTO persona VALUES (3, '12546318', 'Carlos', 'Colmenarez', 'http://i.imgur.com/tQdmrNb.jpg', '1982-05-01', 'M', 'juan@gmail.com', '04127896654', '02516548705', 'Valle Hondo, Cabudare', true);
INSERT INTO persona VALUES (1, '20387728', 'Enmanuel', 'Medina', 'http://i.imgur.com/OSC7mZC.jpg', '1980-03-01', 'M', 'enmanuelm19@gmail.com', '04146549874', '02516548765', 'Cabudare', true);
INSERT INTO persona VALUES (31, '19590948', 'Carlos', 'Peraza', 'http://i.imgur.com/x9S1Av9.jpg', '1990-06-06', 'M', 'carlosperaza@gmail.com', '04248769302', '02518492034', 'Barquisimeto', true);
INSERT INTO persona VALUES (16, '19166184', 'Roman', 'Barrios', 'http://i.imgur.com/6PeAiml.jpg', '1989-09-27', 'M', 'romanbarriosj@gmail.com', '04246548765', NULL, 'Cabudare', true);
INSERT INTO persona VALUES (18, '20189479', 'Wilmer', 'Aponte', 'http://i.imgur.com/zdIRk81.jpg', '1991-02-14', 'M', 'wilmeraponte@gmail.com', '0412359876', NULL, 'Cabudare', true);
INSERT INTO persona VALUES (17, '16481396', 'Mary Carmen', 'Aguiar', 'http://i.imgur.com/PhWSohc.jpg', '1991-05-09', 'F', 'marycarmen@gmail.com', '04267652345', NULL, 'Cabudare', true);
INSERT INTO persona VALUES (32, '20539872', 'Edward', 'Rodriguez', 'http://i.imgur.com/Zc54ZDL.jpg', '1990-05-30', 'M', 'edwardro@gmail.com', '04125635647', '02519876543', 'Barquisimeto', true);
INSERT INTO persona VALUES (24, '18843651', 'Yajaira', 'Marchan', 'http://i.imgur.com/V5mXl7H.jpg', '1988-01-23', 'F', 'yajairamarchan@gmail.com', '02514354324', '04126549876', 'Barquisimeto', true);
INSERT INTO persona VALUES (33, '21125730', 'Anthony', 'Rodriguez', 'http://i.imgur.com/1vKyKPO.jpg', '1991-06-08', 'M', 'anthonyjavierr6@gmail.com', '04123456789', '02518590987', 'Barquisimeto', true);
INSERT INTO persona VALUES (34, '20671198', 'Tony', 'Suarez', 'http://i.imgur.com/H6EuH90.jpg', '1991-03-27', 'M', 'suarezcumare@gmail.com', '04248761265', '02519876543', 'Barquisimeto', true);


--
-- TOC entry 2855 (class 0 OID 36222)
-- Dependencies: 226
-- Data for Name: postulado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO postulado VALUES (1, 4, true);
INSERT INTO postulado VALUES (2, 5, true);
INSERT INTO postulado VALUES (3, 6, true);
INSERT INTO postulado VALUES (4, 10, true);
INSERT INTO postulado VALUES (5, 11, true);
INSERT INTO postulado VALUES (6, 12, true);
INSERT INTO postulado VALUES (7, 13, true);
INSERT INTO postulado VALUES (8, 14, true);


--
-- TOC entry 2827 (class 0 OID 36073)
-- Dependencies: 198
-- Data for Name: postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO postulacion VALUES (1, 1, '2016-03-26', 'B-0340', 'B-0339', 3, true, false);
INSERT INTO postulacion VALUES (2, 2, '2016-03-26', 'B-0340', 'B-0339', 1, true, false);
INSERT INTO postulacion VALUES (3, 3, '2016-03-26', 'B-0340', 'B-0339', 6, true, false);
INSERT INTO postulacion VALUES (4, 4, '2016-03-26', 'B-0340', 'B-0339', 4, false, true);
INSERT INTO postulacion VALUES (5, 5, '2016-03-26', 'B-0340', 'B-0341', 2, false, true);
INSERT INTO postulacion VALUES (6, 6, '2016-03-26', 'B-0340', 'B-0343', 4, false, true);
INSERT INTO postulacion VALUES (7, 7, '2016-03-26', 'B-0340', 'B-0342', 5, false, true);
INSERT INTO postulacion VALUES (8, 8, '2016-03-26', 'B-0340', 'B-0339', 3, false, true);


--
-- TOC entry 2823 (class 0 OID 36055)
-- Dependencies: 194
-- Data for Name: socio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO socio VALUES (1, NULL, 'B-0339', 2, true);
INSERT INTO socio VALUES (2, NULL, 'B-0340', 3, true);
INSERT INTO socio VALUES (3, 1, 'B-0341', 4, true);
INSERT INTO socio VALUES (4, 2, 'B-0342', 5, true);
INSERT INTO socio VALUES (5, 3, 'B-0343', 6, true);


--
-- TOC entry 2825 (class 0 OID 36064)
-- Dependencies: 196
-- Data for Name: accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO accion VALUES (1, 'A00000001', 10000, 1, 1, true);
INSERT INTO accion VALUES (2, 'A00000002', 10000, 2, 1, true);
INSERT INTO accion VALUES (6, 'A00000006', 10000, NULL, 2, true);
INSERT INTO accion VALUES (7, 'A00000007', 10000, NULL, 2, true);
INSERT INTO accion VALUES (12, 'A00000012', 20000, NULL, 2, true);
INSERT INTO accion VALUES (13, 'A00000013', 20000, NULL, 2, true);
INSERT INTO accion VALUES (8, 'A00000008', 10000, NULL, 2, true);
INSERT INTO accion VALUES (9, 'A00000009', 10000, NULL, 2, true);
INSERT INTO accion VALUES (10, 'A00000010', 10000, NULL, 2, true);
INSERT INTO accion VALUES (11, 'A00000011', 10000, NULL, 2, true);
INSERT INTO accion VALUES (15, 'A00000014', 20000, NULL, 2, true);
INSERT INTO accion VALUES (16, 'A00000015', 20000, NULL, 2, true);
INSERT INTO accion VALUES (17, 'A00000016', 20000, NULL, 2, true);
INSERT INTO accion VALUES (18, 'A00000017', 20000, NULL, 2, true);
INSERT INTO accion VALUES (19, 'A00000018', 20000, NULL, 2, true);
INSERT INTO accion VALUES (20, 'A00000019', 20000, NULL, 2, true);
INSERT INTO accion VALUES (21, 'A00000020', 20000, NULL, 2, true);
INSERT INTO accion VALUES (22, 'A00000021', 20000, NULL, 2, true);
INSERT INTO accion VALUES (23, 'A00000022', 20000, NULL, 2, true);
INSERT INTO accion VALUES (24, 'A00000023', 20000, NULL, 2, true);
INSERT INTO accion VALUES (25, 'A00000024', 20000, NULL, 2, true);
INSERT INTO accion VALUES (26, 'A00000025', 20000, NULL, 2, true);
INSERT INTO accion VALUES (27, 'A00000026', 20000, NULL, 2, true);
INSERT INTO accion VALUES (28, 'A00000027', 20000, NULL, 2, true);
INSERT INTO accion VALUES (29, 'A00000028', 20000, NULL, 2, true);
INSERT INTO accion VALUES (30, 'A00000029', 20000, NULL, 2, true);
INSERT INTO accion VALUES (31, 'A00000030', 20000, NULL, 2, true);
INSERT INTO accion VALUES (3, 'A00000003', 10000, 3, 1, true);
INSERT INTO accion VALUES (4, 'A00000004', 10000, 4, 1, true);
INSERT INTO accion VALUES (5, 'A00000005', 10000, 5, 1, true);


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 195
-- Name: accion_id_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('accion_id_accion_seq', 11, true);


--
-- TOC entry 2931 (class 0 OID 36581)
-- Dependencies: 302
-- Data for Name: motivo_cancelacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_cancelacion VALUES (1, 'Falta de Recursos', true);
INSERT INTO motivo_cancelacion VALUES (4, 'Otros', true);
INSERT INTO motivo_cancelacion VALUES (3, 'Actividades Incompletas', true);
INSERT INTO motivo_cancelacion VALUES (2, 'Falta Presupuesto', true);


--
-- TOC entry 2907 (class 0 OID 36468)
-- Dependencies: 278
-- Data for Name: cancelacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cancelacion_evento VALUES (1, 'El presupuesto aprobado no cumplia con las expectativas esperadas para la organizacion de este evento.', 2, true);
INSERT INTO cancelacion_evento VALUES (2, 'La banda declino su participacion en el evento.', 4, true);
INSERT INTO cancelacion_evento VALUES (3, 'La convocatoria no fue suficiente para llevar el torneo a cabo.', 4, true);


--
-- TOC entry 2905 (class 0 OID 36459)
-- Dependencies: 276
-- Data for Name: estado_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO estado_evento VALUES (1, 'Por Planificar', true);
INSERT INTO estado_evento VALUES (2, 'Listo para Ejecutar', true);
INSERT INTO estado_evento VALUES (3, 'En Ejecución', true);
INSERT INTO estado_evento VALUES (4, 'Finalizado', true);
INSERT INTO estado_evento VALUES (5, 'Cancelado', true);


--
-- TOC entry 2839 (class 0 OID 36143)
-- Dependencies: 210
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO evento VALUES (1, 'Semana Aniversario Centro Atlético América', 'Semana donde se conmemora un año más de la fundación del club, el 4 de Septiembre de 1927.', '2016-08-29 00:00:00', '2016-09-04 00:00:00', false, 1, NULL, true);
INSERT INTO evento VALUES (3, 'Jornada de cedulación', 'Cedulación para toda la comunidad cercana al Centro Atlético América.', '2016-03-29 00:00:00', '2016-03-29 00:00:00', false, 4, NULL, true);
INSERT INTO evento VALUES (4, 'Torneo Tradicional Fin de Año', 'Torneo tradicional de beisbol para los socios del club, el cual se lleva a cabo por motivo de fin de año.', '2016-12-30 00:00:00', '2016-12-31 00:00:00', false, 1, NULL, true);
INSERT INTO evento VALUES (6, 'Liga Interclubes Fut-Sala Sub-20', 'Torneo dedicado a la competencia entre los distintos clubes del estado Lara. Categoría Sub-20.', '2016-04-04 00:00:00', '2016-04-24 00:00:00', true, 1, NULL, true);
INSERT INTO evento VALUES (2, 'Torneo Relámpago Beisbol', 'Evento tradicional el cual se realiza luego de Semana Santa. Categoria, master.', '2016-04-02 00:00:00', '2016-04-03 00:00:00', false, 2, NULL, true);
INSERT INTO evento VALUES (5, 'Abierto Regional de Tenis Sub-15', 'Torneo regional categoría Sub-15. Modalidad masculina y femenina.', '2016-04-02 00:00:00', '2016-04-03 00:00:00', false, 2, NULL, true);
INSERT INTO evento VALUES (7, 'Campeonato Natacion 2016 Sub-12', 'Torneo para fomentar la compentencia en esta disciplina en los niños menores a 12 años.', '2016-04-09 00:00:00', '2016-04-10 00:00:00', false, 2, NULL, true);
INSERT INTO evento VALUES (8, 'Torneo de Dominó', 'Torneo clasificatorio para la disciplina Domino libre.', '2016-04-02 00:00:00', '2016-04-03 00:00:00', false, 5, 1, true);
INSERT INTO evento VALUES (9, 'Toque de la Banda Coctel', 'Evento destinado al disfrute de la familia americanista con la finalidad de atraer los amantes de la música de genero Salsa.', '2016-04-23 00:00:00', '2016-04-24 00:00:00', true, 5, 2, true);
INSERT INTO evento VALUES (10, 'Torneo Master Baloncesto', 'Campeonato de baloncesto categoría master. todos los participantes deberan ser mayores a 45 años.', '2016-04-30 00:00:00', '2016-05-01 00:00:00', true, 5, 3, true);
INSERT INTO evento VALUES (11, 'StandUp Comedy Moncho Martinez', 'Humorista venezolano el cual prestara sus servicios de comediante para el publico en general.', '2016-04-27 00:00:00', '2016-04-28 00:00:00', true, 4, NULL, true);


--
-- TOC entry 2841 (class 0 OID 36155)
-- Dependencies: 212
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO actividad VALUES (1, 'Router TP LINK para las redes en equipos del SAIME', 3, '2016-03-28 00:00:00', '2016-03-28 00:00:00', 3, 3, true, true);
INSERT INTO actividad VALUES (3, 'Comidas para los trabajadores del SAIME', 3, '2016-03-28 00:00:00', '2016-03-28 00:00:00', 50, 50, true, true);
INSERT INTO actividad VALUES (2, 'Extensiones de alta calidad para el buen funcionamiento de los equipos del SAIME', 3, '2016-03-25 00:00:00', '2016-03-25 00:00:00', 20, 10, true, true);
INSERT INTO actividad VALUES (4, 'Compra de kit de bases para la cancha de Softball', 2, '2016-03-31 00:00:00', NULL, 2, NULL, false, true);
INSERT INTO actividad VALUES (5, 'Medallas para los jugadores finalistas del torneo', 2, '2016-04-02 00:00:00', NULL, 50, NULL, false, true);
INSERT INTO actividad VALUES (6, 'Compra de cajas de pelotas', 2, '2016-04-01 00:00:00', NULL, 4, NULL, false, true);
INSERT INTO actividad VALUES (7, 'Compra de saco de cal para marcar el terreno de juego', 2, '2016-04-01 00:00:00', NULL, 3, NULL, false, true);
INSERT INTO actividad VALUES (8, 'Contratar anotadores para el torneo', 2, '2016-04-01 00:00:00', NULL, 6, NULL, false, true);
INSERT INTO actividad VALUES (9, 'Trofeos para finalistas del torneo', 2, '2016-04-02 00:00:00', NULL, 2, NULL, false, true);
INSERT INTO actividad VALUES (10, 'Buscar árbitros para los encuentros', 2, '2016-04-01 00:00:00', NULL, 6, NULL, false, true);
INSERT INTO actividad VALUES (11, 'Buscar patrocinadores para la vallas.', 2, '2016-03-31 00:00:00', NULL, 20, NULL, false, true);
INSERT INTO actividad VALUES (13, 'Cajas pelotas Wilson', 5, '2016-04-01 00:00:00', NULL, 200, NULL, false, true);
INSERT INTO actividad VALUES (14, 'Mayas para la cancha', 5, '2016-03-01 00:00:00', NULL, 6, NULL, false, true);
INSERT INTO actividad VALUES (15, 'Medallas para los primeros 3 lugares', 5, '2016-04-01 00:00:00', NULL, 3, NULL, false, true);
INSERT INTO actividad VALUES (16, 'Jueces para los partidos', 5, '2016-04-01 00:00:00', NULL, 20, NULL, false, true);
INSERT INTO actividad VALUES (12, 'Buscar cotizacion de hoteles para estados invitados', 5, '2016-04-01 00:00:00', NULL, 10, NULL, false, true);
INSERT INTO actividad VALUES (18, 'Quimico para el mantenimiento de la piscina', 7, '2016-03-01 00:00:00', NULL, 6, NULL, false, true);
INSERT INTO actividad VALUES (19, 'Trofeo al ganador de la competencia', 7, '2016-03-05 00:00:00', NULL, 1, NULL, false, true);
INSERT INTO actividad VALUES (20, 'Diploma para los primeros 3 lugares', 7, '2016-03-05 00:00:00', NULL, 3, NULL, false, true);
INSERT INTO actividad VALUES (17, 'Medallas para todos los participantes', 7, '2016-04-01 00:00:00', NULL, 200, NULL, false, true);
INSERT INTO actividad VALUES (27, 'Presupuesto de hospedaje para el comediante', 11, '2016-02-29 00:00:00', '2016-02-29 00:00:00', 3, 3, true, true);
INSERT INTO actividad VALUES (21, 'Microfonos Shure', 11, '2016-03-10 00:00:00', '2016-03-03 00:00:00', 5, 3, true, true);
INSERT INTO actividad VALUES (22, 'Impresiones de pases especiales', 11, '2016-03-03 00:00:00', '2016-03-01 00:00:00', 70, 70, true, true);
INSERT INTO actividad VALUES (26, 'Dj para el evento', 11, '2016-03-17 00:00:00', NULL, 1, NULL, false, true);
INSERT INTO actividad VALUES (23, 'Impresion de las entradas', 11, '2016-03-03 00:00:00', '2016-03-02 00:00:00', 700, 700, true, true);
INSERT INTO actividad VALUES (25, 'Equipo de sonido', 11, '2016-03-09 00:00:00', '2016-03-01 00:00:00', 1, 1, true, true);
INSERT INTO actividad VALUES (24, 'Elaboracion de diseño para las entradas', 11, '2016-03-02 00:00:00', '2016-02-29 00:00:00', 3, 3, true, true);


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 211
-- Name: actividad_id_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_id_actividad_seq', 1, false);


--
-- TOC entry 2891 (class 0 OID 36390)
-- Dependencies: 262
-- Data for Name: tipo_afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_afiliado VALUES (1, 'Esposo', '1', true);
INSERT INTO tipo_afiliado VALUES (2, 'Esposa', '1', true);
INSERT INTO tipo_afiliado VALUES (3, 'Hijo', '2', true);
INSERT INTO tipo_afiliado VALUES (4, 'Hija', '2', true);


--
-- TOC entry 2849 (class 0 OID 36195)
-- Dependencies: 220
-- Data for Name: afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO afiliado VALUES (1, 2, 1, 'B-0339-1', 15, true);
INSERT INTO afiliado VALUES (2, 3, 2, 'B-0340-2', 16, true);
INSERT INTO afiliado VALUES (3, 4, 3, 'B-0341-2', 17, true);
INSERT INTO afiliado VALUES (4, 3, 4, 'B-0342-2', 18, true);
INSERT INTO afiliado VALUES (5, 2, 5, 'B-0343-1', 19, true);


--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 219
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('afiliado_id_afilado_seq', 1, false);


--
-- TOC entry 2935 (class 0 OID 36598)
-- Dependencies: 306
-- Data for Name: tipo_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_instalacion VALUES (1, 'Deportivo', true);
INSERT INTO tipo_instalacion VALUES (2, 'Fiesta', true);
INSERT INTO tipo_instalacion VALUES (3, 'Infantil', true);
INSERT INTO tipo_instalacion VALUES (4, 'Caney', true);


--
-- TOC entry 2833 (class 0 OID 36106)
-- Dependencies: 204
-- Data for Name: instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO instalacion VALUES (1, 'Cancha de Softball', 'Espacio para la Práctica de Softball ó Béisbol', 500, 20000, true, 1, true);
INSERT INTO instalacion VALUES (2, 'Salon de Fiesta Principal', 'Espacio de excelente prestancia para Fiestas y Celebraciones', 150, 25000, true, 2, true);
INSERT INTO instalacion VALUES (3, 'Parque Infantil', 'Área recreacional para niños y niñas', 150, 0, false, 3, true);
INSERT INTO instalacion VALUES (4, 'Cancha de Tenis', 'Espacio para la Práctica de Tenis, para el disfrute de todos nuestros socios', 500, 5000, true, 1, true);
INSERT INTO instalacion VALUES (5, 'Cancha de Baloncesto', 'Es un espacio deportivo ideal para quienes Práctican el Baloncesto ', 150, 5000, true, 1, true);
INSERT INTO instalacion VALUES (6, 'Cancha de Bolas Criollas', 'Cancha popular entre nuestros socios, en especial los fines de semana', 150, 5000, true, 1, true);
INSERT INTO instalacion VALUES (7, 'Caney de Rafa', 'Amplio Caney, muy popular entre la Comunidad Americanista', 150, 2000, true, 4, true);
INSERT INTO instalacion VALUES (8, 'Caney de Chevechita', 'Caney que debe su Nombre a un Socio emblemático, desaparecido físicamente desde hace años.', 150, 0, false, 4, true);
INSERT INTO instalacion VALUES (9, 'Piscina', 'Área amplia con Comodidades dignas de la Comunidad Americanista', 150, 35000, true, 3, true);


--
-- TOC entry 2847 (class 0 OID 36185)
-- Dependencies: 218
-- Data for Name: reservacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO reservacion VALUES (1, 4, 5, '2016-03-30 00:00:00', '2016-04-01 00:00:00', 'P', true);
INSERT INTO reservacion VALUES (3, 2, 3, '2016-04-02 00:00:00', '2016-04-02 00:00:00', 'P', true);
INSERT INTO reservacion VALUES (4, 9, 4, '2016-04-02 00:00:00', '2016-04-03 00:00:00', 'A', true);
INSERT INTO reservacion VALUES (2, 5, 5, '2016-04-02 00:00:00', '2016-04-02 00:00:00', 'A', true);


--
-- TOC entry 2925 (class 0 OID 36555)
-- Dependencies: 296
-- Data for Name: tipo_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_pago VALUES (1, 'Efectivo', true);
INSERT INTO tipo_pago VALUES (2, 'Transferencia', true);
INSERT INTO tipo_pago VALUES (3, 'Depósito', true);


--
-- TOC entry 2871 (class 0 OID 36300)
-- Dependencies: 242
-- Data for Name: alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO alquiler VALUES (1, 4, 3, '2016-03-28', 0, true);
INSERT INTO alquiler VALUES (2, 2, 1, '2016-03-28', 0, true);


--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 241
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alquiler_id_alquiler_seq', 1, false);


--
-- TOC entry 2919 (class 0 OID 36525)
-- Dependencies: 290
-- Data for Name: archivo_alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 289
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('archivo_alquiler_id_archivo_alquiler_seq', 1, false);


--
-- TOC entry 2837 (class 0 OID 36131)
-- Dependencies: 208
-- Data for Name: calendario_fecha; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO calendario_fecha VALUES (1, 'Espacio para la Práctica de Tenis, para el disfrute de todos nuestros socios', '2016-03-28', NULL, 1, true);
INSERT INTO calendario_fecha VALUES (2, 'Es un espacio deportivo ideal para quienes Práctican el Baloncesto ', '2016-03-28', NULL, 2, true);
INSERT INTO calendario_fecha VALUES (3, 'Espacio de excelente prestancia para Fiestas y Celebraciones', '2016-03-28', NULL, 3, true);
INSERT INTO calendario_fecha VALUES (4, 'Área amplia con Comodidades dignas de la Comunidad Americanista', '2016-03-28', NULL, 4, true);


--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 207
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('calendario_fecha_id_calendario_fecha_seq', 1, false);


--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 277
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cancelacion_evento_id_cancelacion_evento_seq', 1, false);


--
-- TOC entry 2879 (class 0 OID 36336)
-- Dependencies: 250
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cargo VALUES (1, 'Presidente', true);
INSERT INTO cargo VALUES (2, 'Vicepresidente', true);
INSERT INTO cargo VALUES (3, 'Vocero', true);
INSERT INTO cargo VALUES (4, 'Tesorero', true);
INSERT INTO cargo VALUES (5, 'Secretario(a)', true);
INSERT INTO cargo VALUES (6, 'Coordinador Disciplinario', true);
INSERT INTO cargo VALUES (7, 'Secretario(a) Disciplinario', true);


--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 249
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_cargo_seq', 4, true);


--
-- TOC entry 2851 (class 0 OID 36204)
-- Dependencies: 222
-- Data for Name: cliente_externo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cliente_externo VALUES (1, 'Ivon', 'Miranda', 'ivonmiranda@gmail.com', true);


--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 221
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_externo_id_cliente_seq', 1, false);


--
-- TOC entry 2813 (class 0 OID 36003)
-- Dependencies: 184
-- Data for Name: club; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO club VALUES (1, 'J-08521135-7', 'Centro Atlético América', 'Av. Fuerzas Armadas con Calle 57, Concepción, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.', 'Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus socios y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.', 'http://i.imgur.com/UKvuTwu.png', '0251-4411594', 'centroatleticoclubamerica@gmail.com', NULL, 'Incentivando y Promoviendo la Participación Cultural y Deportiva', true);


--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 183
-- Name: club_id_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('club_id_club_seq', 1, false);


--
-- TOC entry 2887 (class 0 OID 36372)
-- Dependencies: 258
-- Data for Name: motivo_desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_desvinculacion VALUES (1, 'Venta de Acción', true);
INSERT INTO motivo_desvinculacion VALUES (2, 'Socio Sancionado', true);


--
-- TOC entry 2857 (class 0 OID 36231)
-- Dependencies: 228
-- Data for Name: desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 227
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('desvinculacion_id_desvinculacion_seq', 1, false);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 287
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_accion_id_estado_accion_seq', 4, true);


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 275
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_evento_id_estado_evento_seq', 5, true);


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 209
-- Name: evento_id_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('evento_id_evento_seq', 1, false);


--
-- TOC entry 2915 (class 0 OID 36507)
-- Dependencies: 286
-- Data for Name: tipo_eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_eventualidad VALUES (2, 'Mala Conducta', true);
INSERT INTO tipo_eventualidad VALUES (3, 'Actos Inmorales', true);
INSERT INTO tipo_eventualidad VALUES (4, 'Daños a Instalación', true);
INSERT INTO tipo_eventualidad VALUES (5, 'Pelea', true);
INSERT INTO tipo_eventualidad VALUES (6, 'Otros', true);
INSERT INTO tipo_eventualidad VALUES (1, 'Extravío de Recursos', true);


--
-- TOC entry 2831 (class 0 OID 36094)
-- Dependencies: 202
-- Data for Name: eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO eventualidad VALUES (1, 9, 'Según lo dicho por distintas personas en el área, el ciudadano perturbo el bienestar de las personas con que compartía el área. ', '2016-03-27 16:00:00', 2, 2, false);
INSERT INTO eventualidad VALUES (2, 1, 'Según los que estaban presente en la instalación, el ciudadano rompió un vidrio tras exaltarse al terminar un juego.', '2016-03-11 08:00:00', 4, 4, false);
INSERT INTO eventualidad VALUES (3, 8, 'Después de ingerir alcohol, al parecer se fue a las manos con dos ciudadanos que estaban en condición de invitados.', '2016-03-19 23:00:00', 3, 5, true);


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 201
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('eventualidad_id_eventualidad_seq', 1, false);


--
-- TOC entry 2889 (class 0 OID 36381)
-- Dependencies: 260
-- Data for Name: foto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO foto VALUES (1, 'http://i.imgur.com/wHrzoYB.jpg', 1, true, 1, true);
INSERT INTO foto VALUES (2, 'http://i.imgur.com/cHPOldS.jpg', 2, true, 1, true);
INSERT INTO foto VALUES (3, 'http://i.imgur.com/2pTsUU6.jpg', 4, true, 1, true);


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 259
-- Name: foto_id_foto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('foto_id_foto_seq', 3, true);


--
-- TOC entry 2843 (class 0 OID 36164)
-- Dependencies: 214
-- Data for Name: funcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcion VALUES (1, 'Configuración', ' ', 'z-icon-cogs', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (2, 'Socio', ' ', 'z-icon-user', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (3, 'Instalación', ' ', 'z-icon-home', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (4, 'Evento', ' ', 'z-icon-calendar', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (5, 'Consulta', ' ', 'z-icon-th-list', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (6, 'Adm. del Sistema', ' ', 'z-icon-puzzle-piece', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (8, 'Categorias', ' ', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (9, 'Administrar Socio', ' ', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (10, 'Danos tu Opinión', ' ', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (11, 'Administrar Evento', ' ', 'z-icon-angle-double-right', ' ', 4, NULL, true);
INSERT INTO funcion VALUES (12, 'Estructurados', ' ', 'z-icon-angle-double-right', ' ', 5, NULL, true);
INSERT INTO funcion VALUES (14, 'Estadísticos', ' ', 'z-icon-angle-double-right', ' ', 5, NULL, true);
INSERT INTO funcion VALUES (15, 'Seguridad', ' ', 'z-icon-angle-double-right', ' ', 6, NULL, true);
INSERT INTO funcion VALUES (7, 'Postulación', ' ', 'z-icon-group', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (16, 'Perfil del Club', 'configuracion/perfilClub.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y modifica el perfil del club', true);
INSERT INTO funcion VALUES (18, 'Instalaciones', 'configuracion/gestionarInstalaciones.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y odifica las instalaciones del club', true);
INSERT INTO funcion VALUES (17, 'Junta Directiva', 'configuracion/juntaDirectiva.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y modifica la junta directiva', true);
INSERT INTO funcion VALUES (19, 'Reglas del Club', 'configuracion/reglasClub.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y modifica las reglas del club', true);
INSERT INTO funcion VALUES (20, 'Preferencias', 'configuracion/categoria/preferencia.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica las preferencias', true);
INSERT INTO funcion VALUES (21, 'Recursos', 'configuracion/categoria/recursos.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y recursos que pueden estar en las instalaciones', true);
INSERT INTO funcion VALUES (22, 'Cargos Junta Directiva', 'configuracion/categoria/cargoJunta.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y modifica los cargos que pueden estar en la junta directiva', true);
INSERT INTO funcion VALUES (23, 'Motivos Postulación', 'configuracion/categoria/motivoPostulacion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra ly modifica los posibles motivos de postulacion', true);
INSERT INTO funcion VALUES (24, 'Motivos Venta', 'configuracion/categoria/motivoVenta.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los motivos de una venta', true);
INSERT INTO funcion VALUES (25, 'Tipos Sugerencia', 'configuracion/categoria/tipoSugerencia.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipos de sugerencia', true);
INSERT INTO funcion VALUES (26, 'Tipos Preferencia', 'configuracion/categoria/tipoPreferencia.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipo de preferencia', true);
INSERT INTO funcion VALUES (27, 'Tipos Instalación', 'configuracion/categoria/tipoInstalacion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipos de instalacion', true);
INSERT INTO funcion VALUES (29, 'Tipos Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica el parentesco', true);
INSERT INTO funcion VALUES (32, 'Acciones', 'socio/acciones.zul', 'z-icon-angle-double-right', ' ', 2, 'Registra y modifica las acciones', true);
INSERT INTO funcion VALUES (33, 'Mi Perfil', 'socio/miPerfil.zul', 'z-icon-angle-double-right', ' ', 2, 'Modifica el perfil de los usuarios', true);
INSERT INTO funcion VALUES (34, 'Mis Sanciones', 'socio/misSanciones.zul', 'z-icon-angle-double-right', ' ', 2, 'Consulta de las sanciones de un usuario ', true);
INSERT INTO funcion VALUES (35, 'Solicitar Venta', 'socio/solicitarVenta.zul', 'z-icon-angle-double-right', ' ', 2, 'Realiza la solicitud de venta de una accion', true);
INSERT INTO funcion VALUES (36, 'Registrar Socio', 'socio/administrarSocio/postulantes.zul', 'z-icon-angle-double-right', ' ', 9, 'Registra el socio aprobando la postulacion', true);
INSERT INTO funcion VALUES (37, 'Registrar Afiliado', 'socio/administrarSocio/socios.zul', 'z-icon-angle-double-right', ' ', 9, 'Registra afiliados de los distintos socios', true);
INSERT INTO funcion VALUES (38, 'Sanciones', 'socio/administrarSocio/sanciones.zul', 'z-icon-angle-double-right', ' ', 9, 'Registra y modifica sanciones', true);
INSERT INTO funcion VALUES (39, 'Sugerencias', 'socio/buzon/vistaGeneralSugerencias.zul', 'z-icon-angle-double-right', ' ', 10, 'Registra y modifica las sugerencias por parte de los socios y/o afiliados', true);
INSERT INTO funcion VALUES (40, 'Opinar Postulación', 'socio/buzon/opinionPostulacion.zul', 'z-icon-angle-double-right', ' ', 10, 'Registra opiniones sobre postulaciones por parte de socios y/o afiliados', true);
INSERT INTO funcion VALUES (41, 'Reservaciones', 'instalacion/misReservaciones.zul', 'z-icon-angle-double-right', ' ', 3, 'Consulta de las reservaciones de usuario', true);
INSERT INTO funcion VALUES (42, 'Alquileres', 'instalacion/administrarAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, 'Registra y modifica alquileres', true);
INSERT INTO funcion VALUES (43, 'Mis Alquileres', 'instalacion/misAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, 'Consulta de los alquileres del usuario', true);
INSERT INTO funcion VALUES (44, 'Eventualidades', 'socio/registrarEventualidad.zul', 'z-icon-angle-double-right', ' ', 2, 'Registra y modifica eventualidades', true);
INSERT INTO funcion VALUES (45, 'Registrar Eventos', 'evento/administrarEvento/listaEventos.zul', 'z-icon-angle-double-right', ' ', 11, 'Registra y modifica eventos', true);
INSERT INTO funcion VALUES (46, 'Planificar Eventos', 'evento/administrarEvento/planificarEvento.zul', 'z-icon-angle-double-right', ' ', 11, 'Planifica los eventos registrados', true);
INSERT INTO funcion VALUES (47, 'Ejecutar Eventos', 'evento/administrarEvento/ejecutarEvento.zul', 'z-icon-angle-double-right', ' ', 11, 'Ejecuta los eventos planificados', true);
INSERT INTO funcion VALUES (49, 'Cartelera', 'administracion/cartelera.zul', 'z-icon-angle-double-right', ' ', 6, 'Registra y modifica noticias de la cartelera', true);
INSERT INTO funcion VALUES (51, 'Usuarios', 'administracion/seguridad/usuarioGeneral.zul', 'z-icon-angle-double-right', ' ', 15, 'Registra y modifica los usuarios del sistema', true);
INSERT INTO funcion VALUES (52, 'Grupos', 'administracion/seguridad/mostrarGrupos.zul', 'z-icon-angle-double-right', ' ', 15, 'Registra y modifica los grupos funcionales', true);
INSERT INTO funcion VALUES (53, 'Funciones', 'administracion/seguridad/administrarFunciones.zul', 'z-icon-angle-double-right', ' ', 15, 'Consulta de las funciones existentes en el sistema', true);
INSERT INTO funcion VALUES (54, 'Postulados', 'postulado/postulado.zul', 'z-icon-angle-double-right', ' ', 7, 'Consulta de informacion acerca de los postulados', true);
INSERT INTO funcion VALUES (55, 'Administrar portal', 'configuracion/administracionPortal.zul', 'z-icon-angle-double-right', ' ', 1, 'Registra y modifica la informacion del portal', true);
INSERT INTO funcion VALUES (56, 'Finalizar eventos', 'evento/administrarEvento/finalizarEvento.zul', 'z-icon-angle-double-right', ' ', 11, 'Finalizacion de los eventos', true);
INSERT INTO funcion VALUES (57, 'Alquileres', 'consultas/reporteAlquileres.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de los alquileres', true);
INSERT INTO funcion VALUES (58, 'Eventos', 'consultas/reporteEventos.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de los eventos', true);
INSERT INTO funcion VALUES (59, 'Actividades de Evento', 'consultas/reporteActividadEventos.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de actividades de los eventos', true);
INSERT INTO funcion VALUES (60, 'Socios', 'consultas/reporteSocios.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de socios', true);
INSERT INTO funcion VALUES (61, 'Sanciones', 'consultas/reporteSanciones.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de sanciones', true);
INSERT INTO funcion VALUES (62, 'Eventualidades', 'consultas/reporteEventualidad.zul', 'z-icon-angle-double-right', ' ', 12, 'Reporte de eventualidad', true);
INSERT INTO funcion VALUES (63, 'Sanciones', 'consultas/reporteSancionesEst.zul', 'z-icon-angle-double-right', ' ', 14, 'Reporte estadistico de sanciones', true);
INSERT INTO funcion VALUES (64, 'Eventualidades', 'consultas/reporteEventualidadesEst.zul', 'z-icon-angle-double-right', ' ', 14, 'Reporte estadistico de eventualidades', true);
INSERT INTO funcion VALUES (65, 'Eventos', 'consultas/reporteEventoValorEsperadoRealEst.zul', 'z-icon-angle-double-right', ' ', 14, 'Reporte estadistico de eventos', true);
INSERT INTO funcion VALUES (66, 'Socios', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, 'Reporte estadistico de socio', true);
INSERT INTO funcion VALUES (68, 'Instalaciones', 'consultas/reporteInstalacionesEst.zul', 'z-icon-angle-double-right', ' ', 14, 'Reporte estadistico de la instalacion', true);
INSERT INTO funcion VALUES (69, 'Redes Sociales', 'configuracion/categoria/redSocial.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica las redes sociales del club', true);
INSERT INTO funcion VALUES (70, 'Tipos Eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipo de eventualidad', true);
INSERT INTO funcion VALUES (71, 'Indicadores', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los indicadores', true);
INSERT INTO funcion VALUES (72, 'Tipos Opinión', 'configuracion/categoria/tipoOpinion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipo de opinion', true);
INSERT INTO funcion VALUES (73, 'Tipos Pago', 'configuracion/categoria/tipoPago.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica el tipo de pago', true);
INSERT INTO funcion VALUES (74, 'Tipos Noticia', 'configuracion/categoria/tipoNoticia.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modfica los tipo de noticia', true);
INSERT INTO funcion VALUES (76, 'Sugerencias', 'socio/buzon/sugerenciaAdministrativo.zul', 'z-icon-angle-double-right', ' ', 10, 'Consulta de las sugerencias de todos los usuarios', true);
INSERT INTO funcion VALUES (75, 'Motivos Cancelación', 'configuracion/categoria/motivoCancelacion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los motivo de cancelacion', true);
INSERT INTO funcion VALUES (13, 'Motivos Sanción', 'configuracion/categoria/motivoSancion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra los mtivos de sancion', false);
INSERT INTO funcion VALUES (28, 'Motivo Sanción', 'configuracion/categoria/tipoSancion.zul', 'z-icon-angle-double-right', ' ', 8, 'Registra y modifica los tipos de sancion', true);


--
-- TOC entry 2817 (class 0 OID 36024)
-- Dependencies: 188
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO grupo VALUES (1, 'Socio', true);
INSERT INTO grupo VALUES (2, 'Junta', true);
INSERT INTO grupo VALUES (3, 'Afiliado', true);
INSERT INTO grupo VALUES (4, 'Seguridad', true);
INSERT INTO grupo VALUES (5, 'Comunicador', true);
INSERT INTO grupo VALUES (6, 'Vigilancia', true);
INSERT INTO grupo VALUES (7, 'Disciplinario', true);
INSERT INTO grupo VALUES (8, 'Administrativo', true);


--
-- TOC entry 2845 (class 0 OID 36176)
-- Dependencies: 216
-- Data for Name: funcion_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcion_grupo VALUES (1, 33, 1, true);
INSERT INTO funcion_grupo VALUES (2, 34, 1, true);
INSERT INTO funcion_grupo VALUES (3, 35, 1, true);
INSERT INTO funcion_grupo VALUES (4, 39, 1, true);
INSERT INTO funcion_grupo VALUES (5, 40, 1, true);
INSERT INTO funcion_grupo VALUES (6, 41, 1, true);
INSERT INTO funcion_grupo VALUES (7, 43, 1, true);
INSERT INTO funcion_grupo VALUES (8, 51, 4, true);
INSERT INTO funcion_grupo VALUES (9, 52, 4, true);
INSERT INTO funcion_grupo VALUES (10, 53, 4, true);
INSERT INTO funcion_grupo VALUES (11, 33, 3, true);
INSERT INTO funcion_grupo VALUES (12, 34, 3, true);
INSERT INTO funcion_grupo VALUES (13, 49, 5, true);
INSERT INTO funcion_grupo VALUES (14, 55, 5, true);
INSERT INTO funcion_grupo VALUES (53, 44, 6, true);
INSERT INTO funcion_grupo VALUES (16, 17, 2, true);
INSERT INTO funcion_grupo VALUES (33, 37, 2, true);
INSERT INTO funcion_grupo VALUES (18, 19, 2, true);
INSERT INTO funcion_grupo VALUES (45, 58, 2, true);
INSERT INTO funcion_grupo VALUES (61, 76, 2, true);
INSERT INTO funcion_grupo VALUES (47, 60, 2, true);
INSERT INTO funcion_grupo VALUES (35, 42, 2, true);
INSERT INTO funcion_grupo VALUES (37, 46, 2, true);
INSERT INTO funcion_grupo VALUES (52, 65, 2, true);
INSERT INTO funcion_grupo VALUES (44, 57, 2, true);
INSERT INTO funcion_grupo VALUES (51, 64, 2, true);
INSERT INTO funcion_grupo VALUES (48, 61, 2, true);
INSERT INTO funcion_grupo VALUES (55, 70, 2, true);
INSERT INTO funcion_grupo VALUES (17, 18, 2, true);
INSERT INTO funcion_grupo VALUES (50, 63, 2, true);
INSERT INTO funcion_grupo VALUES (58, 73, 2, true);
INSERT INTO funcion_grupo VALUES (38, 47, 2, true);
INSERT INTO funcion_grupo VALUES (25, 26, 2, true);
INSERT INTO funcion_grupo VALUES (36, 45, 2, true);
INSERT INTO funcion_grupo VALUES (49, 62, 2, true);
INSERT INTO funcion_grupo VALUES (23, 24, 2, true);
INSERT INTO funcion_grupo VALUES (24, 25, 2, true);
INSERT INTO funcion_grupo VALUES (54, 68, 2, true);
INSERT INTO funcion_grupo VALUES (60, 75, 2, true);
INSERT INTO funcion_grupo VALUES (27, 28, 2, true);
INSERT INTO funcion_grupo VALUES (59, 74, 2, true);
INSERT INTO funcion_grupo VALUES (34, 38, 2, true);
INSERT INTO funcion_grupo VALUES (28, 29, 2, true);
INSERT INTO funcion_grupo VALUES (43, 66, 2, true);
INSERT INTO funcion_grupo VALUES (26, 27, 2, true);
INSERT INTO funcion_grupo VALUES (57, 72, 2, true);
INSERT INTO funcion_grupo VALUES (19, 20, 2, true);
INSERT INTO funcion_grupo VALUES (20, 21, 2, true);
INSERT INTO funcion_grupo VALUES (46, 59, 2, true);
INSERT INTO funcion_grupo VALUES (31, 32, 2, true);
INSERT INTO funcion_grupo VALUES (15, 16, 2, true);
INSERT INTO funcion_grupo VALUES (56, 71, 2, true);
INSERT INTO funcion_grupo VALUES (21, 22, 2, true);
INSERT INTO funcion_grupo VALUES (22, 23, 2, true);
INSERT INTO funcion_grupo VALUES (32, 36, 2, true);
INSERT INTO funcion_grupo VALUES (42, 56, 2, true);
INSERT INTO funcion_grupo VALUES (41, 54, 2, true);
INSERT INTO funcion_grupo VALUES (62, 69, 2, true);
INSERT INTO funcion_grupo VALUES (63, 13, 2, true);
INSERT INTO funcion_grupo VALUES (64, 70, 7, true);
INSERT INTO funcion_grupo VALUES (65, 38, 7, true);
INSERT INTO funcion_grupo VALUES (66, 13, 7, true);
INSERT INTO funcion_grupo VALUES (67, 44, 7, true);
INSERT INTO funcion_grupo VALUES (68, 28, 7, true);
INSERT INTO funcion_grupo VALUES (69, 13, 8, true);
INSERT INTO funcion_grupo VALUES (70, 39, 8, true);
INSERT INTO funcion_grupo VALUES (71, 25, 8, true);
INSERT INTO funcion_grupo VALUES (72, 34, 8, true);
INSERT INTO funcion_grupo VALUES (73, 56, 8, true);
INSERT INTO funcion_grupo VALUES (74, 24, 8, true);
INSERT INTO funcion_grupo VALUES (75, 32, 8, true);
INSERT INTO funcion_grupo VALUES (76, 42, 8, true);
INSERT INTO funcion_grupo VALUES (77, 59, 8, true);
INSERT INTO funcion_grupo VALUES (78, 18, 8, true);
INSERT INTO funcion_grupo VALUES (79, 74, 8, true);
INSERT INTO funcion_grupo VALUES (80, 20, 8, true);
INSERT INTO funcion_grupo VALUES (81, 53, 8, true);
INSERT INTO funcion_grupo VALUES (82, 58, 8, true);
INSERT INTO funcion_grupo VALUES (83, 27, 8, true);
INSERT INTO funcion_grupo VALUES (84, 69, 8, true);
INSERT INTO funcion_grupo VALUES (85, 72, 8, true);
INSERT INTO funcion_grupo VALUES (86, 28, 8, true);
INSERT INTO funcion_grupo VALUES (87, 29, 8, true);
INSERT INTO funcion_grupo VALUES (88, 46, 8, true);
INSERT INTO funcion_grupo VALUES (89, 51, 8, true);
INSERT INTO funcion_grupo VALUES (90, 17, 8, true);
INSERT INTO funcion_grupo VALUES (91, 65, 8, true);
INSERT INTO funcion_grupo VALUES (92, 52, 8, true);
INSERT INTO funcion_grupo VALUES (93, 75, 8, true);
INSERT INTO funcion_grupo VALUES (94, 60, 8, true);
INSERT INTO funcion_grupo VALUES (95, 66, 8, true);
INSERT INTO funcion_grupo VALUES (96, 36, 8, true);
INSERT INTO funcion_grupo VALUES (97, 54, 8, true);
INSERT INTO funcion_grupo VALUES (98, 16, 8, true);
INSERT INTO funcion_grupo VALUES (99, 44, 8, true);
INSERT INTO funcion_grupo VALUES (100, 40, 8, true);
INSERT INTO funcion_grupo VALUES (101, 38, 8, true);
INSERT INTO funcion_grupo VALUES (102, 45, 8, true);
INSERT INTO funcion_grupo VALUES (103, 22, 8, true);
INSERT INTO funcion_grupo VALUES (104, 33, 8, true);
INSERT INTO funcion_grupo VALUES (105, 37, 8, true);
INSERT INTO funcion_grupo VALUES (106, 41, 8, true);
INSERT INTO funcion_grupo VALUES (107, 23, 8, true);
INSERT INTO funcion_grupo VALUES (108, 55, 8, true);
INSERT INTO funcion_grupo VALUES (109, 71, 8, true);
INSERT INTO funcion_grupo VALUES (110, 47, 8, true);
INSERT INTO funcion_grupo VALUES (111, 49, 8, true);
INSERT INTO funcion_grupo VALUES (112, 70, 8, true);
INSERT INTO funcion_grupo VALUES (113, 21, 8, true);
INSERT INTO funcion_grupo VALUES (114, 26, 8, true);


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 215
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_grupo_id_funcion_grupo_seq', 1, false);


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 213
-- Name: funcion_id_funcion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_id_funcion_seq', 1, false);


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 187
-- Name: grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('grupo_id_grupo_seq', 6, true);


--
-- TOC entry 2909 (class 0 OID 36477)
-- Dependencies: 280
-- Data for Name: indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO indicador VALUES (1, 'Cantidad Asistencia de Personas', true);
INSERT INTO indicador VALUES (2, 'Cantidad Ingresos Recolectados', true);
INSERT INTO indicador VALUES (3, 'Cantidad Utilidad', true);
INSERT INTO indicador VALUES (4, 'Cantidad Ingresos por Inscripción a Torneos', true);
INSERT INTO indicador VALUES (5, 'Cantidad Ingresos por Bebidas alcohólicas', true);


--
-- TOC entry 2911 (class 0 OID 36486)
-- Dependencies: 282
-- Data for Name: indicador_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO indicador_evento VALUES (1, 1000000, NULL, 3, 1, true);
INSERT INTO indicador_evento VALUES (2, 200000, NULL, 4, 1, true);
INSERT INTO indicador_evento VALUES (3, 2000000, NULL, 5, 1, true);
INSERT INTO indicador_evento VALUES (4, 1000, NULL, 1, 1, true);
INSERT INTO indicador_evento VALUES (7, 2000, 1500, 1, 3, true);
INSERT INTO indicador_evento VALUES (8, 500000, NULL, 4, 4, true);
INSERT INTO indicador_evento VALUES (9, 10000000, NULL, 2, 4, true);
INSERT INTO indicador_evento VALUES (10, 2000, NULL, 1, 4, true);
INSERT INTO indicador_evento VALUES (11, 1500000, NULL, 5, 4, true);
INSERT INTO indicador_evento VALUES (12, 200000, NULL, 3, 4, true);
INSERT INTO indicador_evento VALUES (16, 500000, NULL, 4, 6, true);
INSERT INTO indicador_evento VALUES (17, 500, NULL, 1, 6, true);
INSERT INTO indicador_evento VALUES (18, 50000, NULL, 5, 6, true);
INSERT INTO indicador_evento VALUES (19, 1500000, NULL, 2, 6, true);
INSERT INTO indicador_evento VALUES (6, 400000, NULL, 4, 2, true);
INSERT INTO indicador_evento VALUES (5, 500000, NULL, 5, 2, true);
INSERT INTO indicador_evento VALUES (15, 500000, NULL, 5, 5, true);
INSERT INTO indicador_evento VALUES (13, 100000, NULL, 2, 5, true);
INSERT INTO indicador_evento VALUES (14, 1000000, NULL, 1, 5, true);
INSERT INTO indicador_evento VALUES (21, 150000, NULL, 4, 7, true);
INSERT INTO indicador_evento VALUES (22, 500, NULL, 1, 7, true);
INSERT INTO indicador_evento VALUES (20, 500000, NULL, 3, 7, true);
INSERT INTO indicador_evento VALUES (23, 200, NULL, 1, 8, true);
INSERT INTO indicador_evento VALUES (24, 300000, NULL, 2, 8, true);
INSERT INTO indicador_evento VALUES (25, 500000, NULL, 2, 9, true);
INSERT INTO indicador_evento VALUES (26, 200000, NULL, 2, 10, true);
INSERT INTO indicador_evento VALUES (28, 1000000, 1500000, 2, 11, true);
INSERT INTO indicador_evento VALUES (30, 500000, 700000, 5, 11, true);
INSERT INTO indicador_evento VALUES (29, 700000, 900000, 3, 11, true);
INSERT INTO indicador_evento VALUES (27, 700, 890, 1, 11, true);


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 281
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_evento_id_indicador_evento_seq', 1, false);


--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 279
-- Name: indicador_id_indicador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_id_indicador_seq', 5, true);


--
-- TOC entry 2863 (class 0 OID 36261)
-- Dependencies: 234
-- Data for Name: instalacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO instalacion_evento VALUES (1, 6, 1, true);
INSERT INTO instalacion_evento VALUES (2, 1, 1, true);
INSERT INTO instalacion_evento VALUES (3, 9, 1, true);
INSERT INTO instalacion_evento VALUES (4, 4, 1, true);
INSERT INTO instalacion_evento VALUES (5, 2, 1, true);
INSERT INTO instalacion_evento VALUES (7, 2, 3, true);
INSERT INTO instalacion_evento VALUES (8, 1, 4, true);
INSERT INTO instalacion_evento VALUES (10, 5, 6, true);
INSERT INTO instalacion_evento VALUES (6, 1, 2, true);
INSERT INTO instalacion_evento VALUES (9, 4, 5, true);
INSERT INTO instalacion_evento VALUES (11, 9, 7, true);
INSERT INTO instalacion_evento VALUES (12, 7, 8, true);
INSERT INTO instalacion_evento VALUES (13, 2, 9, true);
INSERT INTO instalacion_evento VALUES (14, 5, 10, true);
INSERT INTO instalacion_evento VALUES (15, 2, 11, true);


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 233
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_evento_id_actividad_instalacion_seq', 1, false);


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 203
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_id_instalacion_seq', 9, true);


--
-- TOC entry 2875 (class 0 OID 36318)
-- Dependencies: 246
-- Data for Name: junta_directiva; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO junta_directiva VALUES (1, 1, '2016-03-26', '2017-03-26', true);


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 245
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('junta_directiva_id_junta_directiva_seq', 1, false);


--
-- TOC entry 2877 (class 0 OID 36327)
-- Dependencies: 248
-- Data for Name: miembro_junta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO miembro_junta VALUES (1, 1, 1, 24, true);
INSERT INTO miembro_junta VALUES (3, 1, 2, 25, true);
INSERT INTO miembro_junta VALUES (4, 1, 4, 1, true);
INSERT INTO miembro_junta VALUES (5, 1, 3, 27, true);
INSERT INTO miembro_junta VALUES (6, 1, 6, 29, true);
INSERT INTO miembro_junta VALUES (8, 1, 7, 30, true);


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 247
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('miembro_junta_id_junta_miembro_seq', 1, false);


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 301
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_cancelacion_id_motivo_cancelacion_seq', 3, true);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 257
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_desvinculacion_id_motivo_desvinculacion_seq', 2, true);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 271
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_postulacion_id_motivo_postulacion_seq', 6, true);


--
-- TOC entry 2933 (class 0 OID 36589)
-- Dependencies: 304
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_sancion VALUES (1, 'Eventualidad', true);
INSERT INTO motivo_sancion VALUES (2, 'Morosidad', true);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 303
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_sancion_id_motivo_sancion_seq', 2, true);


--
-- TOC entry 2903 (class 0 OID 36450)
-- Dependencies: 274
-- Data for Name: motivo_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_venta VALUES (1, 'Necesidad Económica', true);
INSERT INTO motivo_venta VALUES (2, 'Cambio de Ciudad', true);
INSERT INTO motivo_venta VALUES (3, 'Descontento con el Club', true);
INSERT INTO motivo_venta VALUES (4, 'Otros', true);


--
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 273
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_venta_id_motivo_venta_seq', 4, true);


--
-- TOC entry 2921 (class 0 OID 36534)
-- Dependencies: 292
-- Data for Name: tipo_noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_noticia VALUES (1, 'Evento Auto', '#009427', false);
INSERT INTO tipo_noticia VALUES (2, 'Postulación Auto', '#f88514', false);
INSERT INTO tipo_noticia VALUES (7, 'Otros', '#0a5f35', true);
INSERT INTO tipo_noticia VALUES (4, 'Postulación', '#b2661a', true);
INSERT INTO tipo_noticia VALUES (6, 'Sucesos', '#7b3a8b', true);
INSERT INTO tipo_noticia VALUES (3, 'Evento', '#cc66ff', true);
INSERT INTO tipo_noticia VALUES (5, 'Acciones', '#cc3300', true);


--
-- TOC entry 2835 (class 0 OID 36119)
-- Dependencies: 206
-- Data for Name: noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO noticia VALUES (34, 'Nueva Postulación', 'El Sr(a). Hilder Hernandez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 8, 'http://i.imgur.com/S0doLDj.jpg', 5, '2016-03-26 12:26:43.146', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (27, 'Nuevo Socio', '¡El Sr(a). Jose Abreu es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/Yv0dyo8.jpg', 6, '2016-03-26 12:09:32.541', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (24, 'Nueva Postulación', 'El Sr(a). Jose Abreu, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 1, 'http://i.imgur.com/Yv0dyo8.jpg', 5, '2016-03-26 11:26:33.138', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (28, 'Nuevo Socio', '¡El Sr(a). Fidel Aliaga es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/mm8CZWD.jpg', 6, '2016-03-26 12:09:54.99', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (25, 'Nueva Postulación', 'El Sr(a). Fidel Aliaga, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 2, 'http://i.imgur.com/mm8CZWD.jpg', 5, '2016-03-26 12:03:55.454', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (29, 'Nuevo Socio', '¡El Sr(a). Anthony Cordero es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/aAY7hKL.jpg', 6, '2016-03-26 12:10:11.397', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (26, 'Nueva Postulación', 'El Sr(a). Anthony Cordero, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 3, 'http://i.imgur.com/aAY7hKL.jpg', 5, '2016-03-26 12:05:57.009', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (30, 'Nueva Postulación', 'El Sr(a). Rosmary Fuentes, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 4, 'http://i.imgur.com/qsXtB2A.jpg', 5, '2016-03-26 12:16:52.941', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (31, 'Nueva Postulación', 'El Sr(a). Dixon Garcia, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 5, 'http://i.imgur.com/DxGxqhY.jpg', 5, '2016-03-26 12:20:33.811', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (32, 'Nueva Postulación', 'El Sr(a). Hector Gil, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 6, 'http://i.imgur.com/OPpIMSz.jpg', 5, '2016-03-26 12:22:17.703', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (33, 'Nueva Postulación', 'El Sr(a). Xavier Gutierrez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 7, 'http://i.imgur.com/Nv1pWz8.jpg', 5, '2016-03-26 12:24:02.634', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (35, 'Semana Aniversario Centro Atlético América', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Semana Aniversario Centro Atlético América Desde: 29/08/2016 Hasta: 04/09/2016', 1, NULL, 'http://localhost:8080/america/assets/portal/img/noticiadefecto.png', 1, '2016-03-28 23:22:30.572', '2016-09-04', false, NULL, true);
INSERT INTO noticia VALUES (36, 'Torneo Relámpago Beisbol', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Torneo Relámpago Beisbol Desde: 02/04/2016 Hasta: 03/04/2016', 2, NULL, 'http://localhost:8080/america/assets/portal/img/noticiadefecto.png', 1, '2016-03-28 23:28:36.38', '2016-04-03', false, NULL, true);
INSERT INTO noticia VALUES (1, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:20:33.75', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (2, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:20:49.523', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (3, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:21:01.145', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (4, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:21:08.963', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (5, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:21:15.307', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (6, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:21:23.035', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (7, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:22:01.331', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (8, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:22:21.006', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (9, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:22:32.608', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (10, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:22:48.248', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (11, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:23:01.766', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (12, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:23:20.464', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (13, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:23:39.357', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (14, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:23:52.154', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (15, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:24:17.597', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (16, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:24:39.648', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (17, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:24:50.74', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (18, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:03.184', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (19, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:14.186', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (20, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:25.402', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (21, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:35.536', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (22, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:46.398', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (23, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 'http://i.imgur.com/E9BHBju.png', 2, '2016-03-26 11:25:56.887', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (37, 'Jornada de cedulación', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Jornada de cedulación Desde: 29/03/2016 Hasta: 29/03/2016', 3, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-28 23:50:01.903', '2016-03-29', false, NULL, true);
INSERT INTO noticia VALUES (38, 'Torneo Tradicional Fin de Año', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Torneo Tradicional Fin de Año Desde: 30/12/2016 Hasta: 31/12/2016', 4, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 00:12:49.138', '2016-12-31', false, NULL, true);
INSERT INTO noticia VALUES (39, 'Abierto Regional de Tenis Sub-15', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Abierto Regional de Tenis Sub-15 Desde: 02/04/2016 Hasta: 03/04/2016', 5, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 00:18:50.473', '2016-04-03', false, NULL, true);
INSERT INTO noticia VALUES (40, 'Liga Interclubes Fut-Sala Sub-20', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Liga Interclubes Fut-Sala Sub-20 Desde: 04/04/2016 Hasta: 24/04/2016', 6, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 00:24:17.56', '2016-04-24', true, NULL, true);
INSERT INTO noticia VALUES (41, 'Campeonato Natacion 2016 Sub-12', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: Campeonato Natacion 2016 Sub-12 Desde: 09/04/2016 Hasta: 10/04/2016', 7, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 00:55:58.372', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (42, 'Cancelacion del evento Torneo de Dominó', 'Se le informa a nuestra familia americanista la cancelacion del evento: Torneo de Dominó por motivo: Falta Presupuesto; El presupuesto aprobado no cumplia con las expectativas esperadas para la organizacion de este evento.', 8, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 01:22:57.481', '2016-04-03', false, NULL, true);
INSERT INTO noticia VALUES (43, 'Cancelacion del evento Toque de la Banda Coctel', 'Se le informa a nuestra familia americanista la cancelacion del evento: Toque de la Banda Coctel por motivo: Otros; La banda declino su participacion en el evento.', 9, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 01:26:53.901', '2016-04-24', true, NULL, true);
INSERT INTO noticia VALUES (44, 'Cancelacion del evento Torneo Master Baloncesto', 'Se le informa a nuestra familia americanista la cancelacion del evento: Torneo Master Baloncesto por motivo: Otros; La convocatoria no fue suficiente para llevar el torneo a cabo.', 10, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 01:32:11.148', '2016-05-01', true, NULL, true);
INSERT INTO noticia VALUES (45, 'StandUp Comedy Moncho Martinez', 'Nos complace informarle a nuestra familia americanista la realizacion de evento: StandUp Comedy Moncho Martinez Desde: 27/04/2016 Hasta: 28/04/2016', 11, NULL, 'http://i.imgur.com/wGVOjvQ.png', 1, '2016-03-29 01:40:51.382', '2016-04-28', true, NULL, true);


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 205
-- Name: noticia_id_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_id_noticia_seq', 1, false);


--
-- TOC entry 2883 (class 0 OID 36354)
-- Dependencies: 254
-- Data for Name: tipo_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_preferencia VALUES (3, 'Social', '#20B2AA', true);
INSERT INTO tipo_preferencia VALUES (4, 'Hobbie', '#0099cc', true);
INSERT INTO tipo_preferencia VALUES (2, 'Deportiva', '#009427', true);
INSERT INTO tipo_preferencia VALUES (1, 'Cultural', '#660000', true);


--
-- TOC entry 2853 (class 0 OID 36213)
-- Dependencies: 224
-- Data for Name: preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia VALUES (1, 'Beisbol', 2, true);
INSERT INTO preferencia VALUES (2, 'Futbol', 2, true);
INSERT INTO preferencia VALUES (3, 'Tenis', 2, true);
INSERT INTO preferencia VALUES (4, 'Bolas Criollas', 2, true);
INSERT INTO preferencia VALUES (5, 'Natacion', 2, true);
INSERT INTO preferencia VALUES (6, 'Kickingball', 2, true);
INSERT INTO preferencia VALUES (7, 'Voleibol', 2, true);
INSERT INTO preferencia VALUES (8, 'Baile', 3, true);
INSERT INTO preferencia VALUES (9, 'Musica', 3, true);
INSERT INTO preferencia VALUES (11, 'Televisión', 4, true);
INSERT INTO preferencia VALUES (12, 'Cine', 4, true);
INSERT INTO preferencia VALUES (13, 'Cantar', 4, true);
INSERT INTO preferencia VALUES (14, 'Ciclismo', 2, true);
INSERT INTO preferencia VALUES (15, 'Balie Tradicional', 1, true);
INSERT INTO preferencia VALUES (10, 'Folklore', 3, true);
INSERT INTO preferencia VALUES (16, 'Interés Público', 3, true);
INSERT INTO preferencia VALUES (17, 'Dominó', 2, true);
INSERT INTO preferencia VALUES (18, 'Baloncesto', 2, true);
INSERT INTO preferencia VALUES (19, 'Comedia', 3, true);


--
-- TOC entry 2885 (class 0 OID 36363)
-- Dependencies: 256
-- Data for Name: noticia_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO noticia_preferencia VALUES (1, 1, 35, true);
INSERT INTO noticia_preferencia VALUES (2, 9, 35, true);
INSERT INTO noticia_preferencia VALUES (3, 5, 35, true);
INSERT INTO noticia_preferencia VALUES (4, 2, 35, true);
INSERT INTO noticia_preferencia VALUES (5, 4, 35, true);
INSERT INTO noticia_preferencia VALUES (6, 8, 35, true);
INSERT INTO noticia_preferencia VALUES (7, 3, 35, true);
INSERT INTO noticia_preferencia VALUES (8, 6, 35, true);
INSERT INTO noticia_preferencia VALUES (9, 1, 36, true);
INSERT INTO noticia_preferencia VALUES (10, 16, 37, true);
INSERT INTO noticia_preferencia VALUES (11, 1, 38, true);
INSERT INTO noticia_preferencia VALUES (12, 3, 39, true);
INSERT INTO noticia_preferencia VALUES (13, 2, 40, true);
INSERT INTO noticia_preferencia VALUES (14, 5, 41, true);
INSERT INTO noticia_preferencia VALUES (15, 17, 42, true);
INSERT INTO noticia_preferencia VALUES (17, 8, 43, true);
INSERT INTO noticia_preferencia VALUES (18, 16, 43, true);
INSERT INTO noticia_preferencia VALUES (16, 9, 43, true);
INSERT INTO noticia_preferencia VALUES (19, 18, 44, true);
INSERT INTO noticia_preferencia VALUES (20, 16, 45, true);


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 255
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_preferencia_id_noticia_preferencia_seq', 1, false);


--
-- TOC entry 2927 (class 0 OID 36563)
-- Dependencies: 298
-- Data for Name: tipo_opnion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_opnion VALUES (1, 'Lo Recomiendo', true);
INSERT INTO tipo_opnion VALUES (2, 'No lo Recomiendo', true);
INSERT INTO tipo_opnion VALUES (3, 'No lo Conozco', true);


--
-- TOC entry 2811 (class 0 OID 35994)
-- Dependencies: 182
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario VALUES (4, '12345678', 'jose', '¿Quien?', 'Capitan garfio en la cocina', 4, '2016-03-26', true);
INSERT INTO usuario VALUES (5, '12345678', 'fidi', '¿Quien?', 'Capitan garfio en la cocina', 5, '2016-03-26', true);
INSERT INTO usuario VALUES (6, '12345678', 'anthony', '¿Quien?', 'Capitan garfio en la cocina', 6, '2016-03-26', true);
INSERT INTO usuario VALUES (9, '12345678', 'bea', '¿Quien?', 'Capitan garfio en la cocina', 19, '2016-03-26', true);
INSERT INTO usuario VALUES (10, '12345678', 'mariangel', '¿Quien?', 'Capitan garfio en la cocina', 15, '2016-03-26', true);
INSERT INTO usuario VALUES (2, '12345678', 'prisco', '¿Nombre de mi Madre?', 'raquel', 2, '2016-03-26', true);
INSERT INTO usuario VALUES (3, '12345678', 'carlos', '¿Nombre de mi Abuela?', 'esperanza', 3, '2016-03-26', true);
INSERT INTO usuario VALUES (1, '12345678', 'enmanuel', '¿Quién?', 'administrador', 1, '2016-03-26', true);
INSERT INTO usuario VALUES (11, '12345678', 'roman', '¿Quien?', 'Capitan garfio en la cocina', 16, '2016-03-26', true);
INSERT INTO usuario VALUES (12, '12345678', 'wilmer', '¿Quien?', 'Capitan garfio en la cocina', 18, '2016-03-26', true);
INSERT INTO usuario VALUES (13, '12345678', 'mary', '¿Quien?', 'Capitan garfio en la cocina', 17, '2016-03-26', true);
INSERT INTO usuario VALUES (14, '12345678', 'yajaira', '¿Quien?', 'Capitan garfio en la cocina', 24, '2016-03-26', true);
INSERT INTO usuario VALUES (15, '12345678', 'gipsy', '¿Quien?', 'Capitan garfio en la cocina', 25, '2016-03-26', true);
INSERT INTO usuario VALUES (16, '12345678', 'karla', '¿Quien?', 'Capitan garfio en la cocina', 27, '2016-03-26', true);
INSERT INTO usuario VALUES (17, '12345678', 'joseM', '¿Quien?', 'Capitan garfio en la cocina', 29, '2016-03-26', true);
INSERT INTO usuario VALUES (18, '12345678', 'eliza', '¿Quien?', 'Capitan garfio en la cocina', 30, '2016-03-26', true);
INSERT INTO usuario VALUES (19, '12345678', 'carlosP', '¿Quien?', 'Capitan garfio en la cocina', 31, '2016-03-26', true);
INSERT INTO usuario VALUES (20, '12345678', 'edward', '¿Quien?', 'Capitan garfio en la cocina', 32, '2016-03-26', true);
INSERT INTO usuario VALUES (21, '12345678', 'anthonyJ', '¿Quien?', 'Capitan garfio en la cocina', 33, '2016-03-26', true);
INSERT INTO usuario VALUES (22, '12345678', 'tony', '¿Quien?', 'Capitan garfio en la cocina', 34, '2016-03-26', true);


--
-- TOC entry 2829 (class 0 OID 36082)
-- Dependencies: 200
-- Data for Name: opinion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 199
-- Name: opinion_id_opinion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('opinion_id_opinion_seq', 1, false);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 189
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('persona_id_persona_seq', 3, true);


--
-- TOC entry 2873 (class 0 OID 36309)
-- Dependencies: 244
-- Data for Name: politica; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO politica VALUES (1, 'Personas que puede traer un socio por visita diaria', 3, 1, true);
INSERT INTO politica VALUES (2, 'Veces que puede traer a un mismo invitado al mes', 3, 1, true);


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 243
-- Name: politica_id_politica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('politica_id_politica_seq', 2, true);


--
-- TOC entry 2923 (class 0 OID 36543)
-- Dependencies: 294
-- Data for Name: portal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO portal VALUES (1, 'El Centro Atlético América cuenta con canchas de Tenis, Baloncesto, Béisbol, Bolas criollas. Además cuenta con un Salón de Fiestas y dos Caneyes para el disfrute de sus socios e invitados', 'Nuestros Socios Se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de Club. ¿Quieres ser un socio del Centro Atlético América?', 'Nos Interesa Motivar la interacción social a través de actividades culturales de intercambio, en busca del crecimiento humano mediante la Realización de Eventos. ¿Quieres participar en nuestros Eventos?', true, 'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 293
-- Name: portal_id_portal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('portal_id_portal_seq', 1, false);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 197
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulacion_id_postulacion_seq', 1, false);


--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 225
-- Name: postulado_id_postulado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulado_id_postulado_seq', 1, false);


--
-- TOC entry 2893 (class 0 OID 36402)
-- Dependencies: 264
-- Data for Name: preferencia_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia_evento VALUES (1, 1, 8, true);
INSERT INTO preferencia_evento VALUES (2, 1, 5, true);
INSERT INTO preferencia_evento VALUES (3, 1, 3, true);
INSERT INTO preferencia_evento VALUES (4, 1, 1, true);
INSERT INTO preferencia_evento VALUES (5, 1, 4, true);
INSERT INTO preferencia_evento VALUES (6, 1, 2, true);
INSERT INTO preferencia_evento VALUES (7, 1, 9, true);
INSERT INTO preferencia_evento VALUES (8, 1, 6, true);
INSERT INTO preferencia_evento VALUES (10, 3, 16, true);
INSERT INTO preferencia_evento VALUES (11, 4, 1, true);
INSERT INTO preferencia_evento VALUES (13, 6, 2, true);
INSERT INTO preferencia_evento VALUES (9, 2, 1, true);
INSERT INTO preferencia_evento VALUES (12, 5, 3, true);
INSERT INTO preferencia_evento VALUES (14, 7, 5, true);
INSERT INTO preferencia_evento VALUES (15, 8, 17, true);
INSERT INTO preferencia_evento VALUES (18, 9, 9, true);
INSERT INTO preferencia_evento VALUES (16, 9, 8, true);
INSERT INTO preferencia_evento VALUES (17, 9, 16, true);
INSERT INTO preferencia_evento VALUES (19, 10, 18, true);
INSERT INTO preferencia_evento VALUES (20, 11, 16, true);


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 263
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_evento_id_preferencia_evento_seq', 1, false);


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 223
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_id_preferencia_seq', 14, true);


--
-- TOC entry 2861 (class 0 OID 36252)
-- Dependencies: 232
-- Data for Name: preferencia_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia_persona VALUES (37, 7, 15, true);
INSERT INTO preferencia_persona VALUES (41, 8, 15, true);
INSERT INTO preferencia_persona VALUES (42, 9, 15, true);
INSERT INTO preferencia_persona VALUES (38, 6, 15, true);
INSERT INTO preferencia_persona VALUES (40, 13, 15, true);
INSERT INTO preferencia_persona VALUES (39, 5, 15, true);
INSERT INTO preferencia_persona VALUES (36, 3, 15, true);
INSERT INTO preferencia_persona VALUES (47, 10, 16, true);
INSERT INTO preferencia_persona VALUES (45, 12, 16, true);
INSERT INTO preferencia_persona VALUES (43, 2, 16, true);
INSERT INTO preferencia_persona VALUES (46, 11, 16, true);
INSERT INTO preferencia_persona VALUES (44, 5, 16, true);
INSERT INTO preferencia_persona VALUES (1, 1, 4, true);
INSERT INTO preferencia_persona VALUES (2, 10, 4, true);
INSERT INTO preferencia_persona VALUES (3, 11, 4, true);
INSERT INTO preferencia_persona VALUES (7, 12, 5, true);
INSERT INTO preferencia_persona VALUES (6, 10, 5, true);
INSERT INTO preferencia_persona VALUES (5, 4, 5, true);
INSERT INTO preferencia_persona VALUES (4, 3, 5, true);
INSERT INTO preferencia_persona VALUES (58, 12, 18, true);
INSERT INTO preferencia_persona VALUES (57, 11, 18, true);
INSERT INTO preferencia_persona VALUES (60, 7, 18, true);
INSERT INTO preferencia_persona VALUES (9, 8, 6, true);
INSERT INTO preferencia_persona VALUES (10, 10, 6, true);
INSERT INTO preferencia_persona VALUES (11, 14, 6, true);
INSERT INTO preferencia_persona VALUES (8, 1, 6, true);
INSERT INTO preferencia_persona VALUES (12, 3, 10, true);
INSERT INTO preferencia_persona VALUES (13, 8, 10, true);
INSERT INTO preferencia_persona VALUES (14, 9, 10, true);
INSERT INTO preferencia_persona VALUES (15, 13, 10, true);
INSERT INTO preferencia_persona VALUES (16, 6, 10, true);
INSERT INTO preferencia_persona VALUES (17, 5, 10, true);
INSERT INTO preferencia_persona VALUES (18, 2, 11, true);
INSERT INTO preferencia_persona VALUES (19, 10, 11, true);
INSERT INTO preferencia_persona VALUES (20, 11, 11, true);
INSERT INTO preferencia_persona VALUES (21, 12, 11, true);
INSERT INTO preferencia_persona VALUES (22, 14, 11, true);
INSERT INTO preferencia_persona VALUES (23, 4, 12, true);
INSERT INTO preferencia_persona VALUES (24, 8, 12, true);
INSERT INTO preferencia_persona VALUES (25, 13, 12, true);
INSERT INTO preferencia_persona VALUES (26, 10, 12, true);
INSERT INTO preferencia_persona VALUES (27, 1, 13, true);
INSERT INTO preferencia_persona VALUES (28, 2, 13, true);
INSERT INTO preferencia_persona VALUES (29, 7, 13, true);
INSERT INTO preferencia_persona VALUES (30, 10, 13, true);
INSERT INTO preferencia_persona VALUES (31, 14, 13, true);
INSERT INTO preferencia_persona VALUES (32, 2, 14, true);
INSERT INTO preferencia_persona VALUES (33, 9, 14, true);
INSERT INTO preferencia_persona VALUES (34, 5, 14, true);
INSERT INTO preferencia_persona VALUES (35, 4, 14, true);
INSERT INTO preferencia_persona VALUES (55, 4, 18, true);
INSERT INTO preferencia_persona VALUES (56, 8, 18, true);
INSERT INTO preferencia_persona VALUES (59, 14, 18, true);
INSERT INTO preferencia_persona VALUES (48, 3, 17, true);
INSERT INTO preferencia_persona VALUES (51, 6, 17, true);
INSERT INTO preferencia_persona VALUES (54, 8, 17, true);
INSERT INTO preferencia_persona VALUES (53, 9, 17, true);
INSERT INTO preferencia_persona VALUES (49, 5, 17, true);
INSERT INTO preferencia_persona VALUES (50, 7, 17, true);
INSERT INTO preferencia_persona VALUES (52, 13, 17, true);
INSERT INTO preferencia_persona VALUES (61, 7, 19, true);
INSERT INTO preferencia_persona VALUES (66, 5, 19, true);
INSERT INTO preferencia_persona VALUES (65, 13, 19, true);
INSERT INTO preferencia_persona VALUES (63, 9, 19, true);
INSERT INTO preferencia_persona VALUES (62, 6, 19, true);
INSERT INTO preferencia_persona VALUES (64, 8, 19, true);


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 231
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_persona_id_preferencia_persona_seq', 1, false);


--
-- TOC entry 2865 (class 0 OID 36270)
-- Dependencies: 236
-- Data for Name: recurso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO recurso VALUES (1, 'Sillas de Plástico', true);
INSERT INTO recurso VALUES (2, 'Sillas de Madera', true);
INSERT INTO recurso VALUES (3, 'Mesas Redondas', true);
INSERT INTO recurso VALUES (4, 'Mesas Cuadradas', true);
INSERT INTO recurso VALUES (5, 'Manteles', true);
INSERT INTO recurso VALUES (6, 'Hieleras', true);
INSERT INTO recurso VALUES (7, 'Cornetas', true);
INSERT INTO recurso VALUES (8, 'Parrilleras', true);
INSERT INTO recurso VALUES (9, 'Vasos', true);
INSERT INTO recurso VALUES (10, 'Cubiertos', true);
INSERT INTO recurso VALUES (11, 'Lamparas', true);
INSERT INTO recurso VALUES (12, 'Neveras', true);


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 235
-- Name: recurso_id_recurso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_id_recurso_seq', 12, true);


--
-- TOC entry 2869 (class 0 OID 36291)
-- Dependencies: 240
-- Data for Name: recurso_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO recurso_instalacion VALUES (3, 1, 7, 4, true);
INSERT INTO recurso_instalacion VALUES (2, 2, 2, 100, true);
INSERT INTO recurso_instalacion VALUES (1, 2, 1, 100, true);
INSERT INTO recurso_instalacion VALUES (4, 3, 8, 2, true);
INSERT INTO recurso_instalacion VALUES (5, 4, 11, 10, true);
INSERT INTO recurso_instalacion VALUES (6, 5, 1, 50, true);
INSERT INTO recurso_instalacion VALUES (7, 6, 4, 5, true);
INSERT INTO recurso_instalacion VALUES (8, 6, 2, 100, true);
INSERT INTO recurso_instalacion VALUES (9, 7, 3, 10, true);
INSERT INTO recurso_instalacion VALUES (10, 7, 1, 50, true);
INSERT INTO recurso_instalacion VALUES (11, 7, 6, 4, true);
INSERT INTO recurso_instalacion VALUES (12, 8, 4, 4, true);
INSERT INTO recurso_instalacion VALUES (13, 8, 2, 10, true);
INSERT INTO recurso_instalacion VALUES (14, 9, 1, 50, true);


--
-- TOC entry 2982 (class 0 OID 0)
-- Dependencies: 239
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_instalacion_id_recurso_instalacion_seq', 2, true);


--
-- TOC entry 2895 (class 0 OID 36411)
-- Dependencies: 266
-- Data for Name: red_social; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO red_social VALUES (1, 'Facebook', 'http://i.imgur.com/J8nfPwn.png', true);
INSERT INTO red_social VALUES (2, 'Instagram', 'http://i.imgur.com/E6xQKvN.png', true);
INSERT INTO red_social VALUES (3, 'Twitter', 'http://i.imgur.com/rox1qxk.png', true);


--
-- TOC entry 2897 (class 0 OID 36423)
-- Dependencies: 268
-- Data for Name: red_club; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO red_club VALUES (1, 1, 3, 'https://twitter.com/CAAAMERICA', true);
INSERT INTO red_club VALUES (2, 1, 1, 'https://www.facebook.com/accaa', true);


--
-- TOC entry 2983 (class 0 OID 0)
-- Dependencies: 267
-- Name: red_club_id_red_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_club_id_red_club_seq', 2, true);


--
-- TOC entry 2899 (class 0 OID 36432)
-- Dependencies: 270
-- Data for Name: red_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 269
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_persona_id_red_persona_seq', 1, false);


--
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 265
-- Name: red_social_id_red_social_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_social_id_red_social_seq', 3, true);


--
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 217
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reservacion_id_reservacion_seq', 1, false);


--
-- TOC entry 2929 (class 0 OID 36572)
-- Dependencies: 300
-- Data for Name: tipo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_sancion VALUES (1, 'Morosidad', true);
INSERT INTO tipo_sancion VALUES (2, 'Eventualidad', true);


--
-- TOC entry 2821 (class 0 OID 36045)
-- Dependencies: 192
-- Data for Name: sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sancion VALUES (1, 'Según lo dicho por distintas personas en el área, el ciudadano perturbo el bienestar de las personas con que compartía el área. ', 1, NULL, '2016-03-28', '2016-04-01', NULL, 1, NULL, 2, true);
INSERT INTO sancion VALUES (2, 'Según los que estaban presente en la instalación, el ciudadano rompió un vidrio tras exaltarse al terminar un juego.', 3, NULL, NULL, NULL, 15000, 2, NULL, 2, true);


--
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 191
-- Name: sancion_id_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sancion_id_sancion_seq', 1, false);


--
-- TOC entry 2988 (class 0 OID 0)
-- Dependencies: 193
-- Name: socio_id_socio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('socio_id_socio_seq', 2, true);


--
-- TOC entry 2913 (class 0 OID 36495)
-- Dependencies: 284
-- Data for Name: solicitud_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2989 (class 0 OID 0)
-- Dependencies: 283
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('solicitud_venta_id_solicitud_venta_seq', 1, false);


--
-- TOC entry 2881 (class 0 OID 36345)
-- Dependencies: 252
-- Data for Name: tipo_sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_sugerencia VALUES (1, 'Pregunta', true);
INSERT INTO tipo_sugerencia VALUES (2, 'Sugerencia', true);
INSERT INTO tipo_sugerencia VALUES (3, 'Comentario', true);
INSERT INTO tipo_sugerencia VALUES (4, 'Queja', true);
INSERT INTO tipo_sugerencia VALUES (5, 'Reclamo', true);


--
-- TOC entry 2867 (class 0 OID 36279)
-- Dependencies: 238
-- Data for Name: sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sugerencia VALUES (1, 'Quede encantada con las instalaciones del club. Me gustaría comprar una acción', '2016-03-28 23:00:09.198', NULL, 1, 3, true);


--
-- TOC entry 2990 (class 0 OID 0)
-- Dependencies: 237
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sugerencia_id_sugerencia_seq', 1, false);


--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 261
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_afiliado_id_tipo_afiliado_seq', 4, true);


--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 285
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_eventualidad_id_tipo_eventualidad_seq', 5, true);


--
-- TOC entry 2993 (class 0 OID 0)
-- Dependencies: 305
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_instalacion_id_tipo_instalacion_seq', 4, true);


--
-- TOC entry 2994 (class 0 OID 0)
-- Dependencies: 291
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_noticia_id_tipo_noticia_seq', 7, true);


--
-- TOC entry 2995 (class 0 OID 0)
-- Dependencies: 297
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_opnion_id_tipo_opninion_seq', 3, true);


--
-- TOC entry 2996 (class 0 OID 0)
-- Dependencies: 295
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_pago_id_tipo_pago_seq', 3, true);


--
-- TOC entry 2997 (class 0 OID 0)
-- Dependencies: 253
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_preferencia_id_tipo_preferencia_seq', 4, true);


--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 299
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sancion_id_tipo_sancion_seq', 2, true);


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 251
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sugerencia_id_tipo_sugerencia_seq', 5, true);


--
-- TOC entry 2815 (class 0 OID 36015)
-- Dependencies: 186
-- Data for Name: usuario_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario_grupo VALUES (8, 4, 1, true);
INSERT INTO usuario_grupo VALUES (9, 5, 1, true);
INSERT INTO usuario_grupo VALUES (10, 6, 1, true);
INSERT INTO usuario_grupo VALUES (12, 9, 3, true);
INSERT INTO usuario_grupo VALUES (13, 10, 3, true);
INSERT INTO usuario_grupo VALUES (3, 2, 1, true);
INSERT INTO usuario_grupo VALUES (11, 3, 1, true);
INSERT INTO usuario_grupo VALUES (5, 1, 4, true);
INSERT INTO usuario_grupo VALUES (2, 1, 6, true);
INSERT INTO usuario_grupo VALUES (6, 1, 2, true);
INSERT INTO usuario_grupo VALUES (4, 1, 5, true);
INSERT INTO usuario_grupo VALUES (7, 1, 3, true);
INSERT INTO usuario_grupo VALUES (14, 11, 3, true);
INSERT INTO usuario_grupo VALUES (15, 12, 3, true);
INSERT INTO usuario_grupo VALUES (16, 13, 3, true);
INSERT INTO usuario_grupo VALUES (17, 14, 2, true);
INSERT INTO usuario_grupo VALUES (18, 14, 5, true);
INSERT INTO usuario_grupo VALUES (19, 15, 2, true);
INSERT INTO usuario_grupo VALUES (21, 16, 5, true);
INSERT INTO usuario_grupo VALUES (20, 16, 2, true);
INSERT INTO usuario_grupo VALUES (22, 17, 7, true);
INSERT INTO usuario_grupo VALUES (23, 18, 7, true);
INSERT INTO usuario_grupo VALUES (24, 19, 6, true);
INSERT INTO usuario_grupo VALUES (25, 20, 6, true);
INSERT INTO usuario_grupo VALUES (26, 21, 8, true);
INSERT INTO usuario_grupo VALUES (27, 22, 8, true);


--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_grupo_id_usuario_grupo_seq', 1, false);


--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 181
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 3, true);


--
-- TOC entry 2859 (class 0 OID 36243)
-- Dependencies: 230
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 229
-- Name: venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('venta_id_venta_seq', 1, false);


-- Completed on 2016-03-29 01:52:25

--
-- PostgreSQL database dump complete
--
