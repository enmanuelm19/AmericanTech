--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.5
-- Dumped by pg_dump version 9.4.5
-- Started on 2016-03-26 16:21:50 VET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2850 (class 0 OID 82586)
-- Dependencies: 279
-- Data for Name: estado_accion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO estado_accion VALUES (1, 'Asociada', true);
INSERT INTO estado_accion VALUES (2, 'En Venta', true);
INSERT INTO estado_accion VALUES (3, 'En Solicitud', true);
INSERT INTO estado_accion VALUES (4, 'Inactiva', true);


--
-- TOC entry 2834 (class 0 OID 82511)
-- Dependencies: 263
-- Data for Name: motivo_postulacion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO motivo_postulacion VALUES (1, 'Beneficios del Club', true);
INSERT INTO motivo_postulacion VALUES (2, 'Inversión', true);
INSERT INTO motivo_postulacion VALUES (3, 'Deporte', true);
INSERT INTO motivo_postulacion VALUES (4, 'Osio', true);
INSERT INTO motivo_postulacion VALUES (5, 'Recreación', true);
INSERT INTO motivo_postulacion VALUES (6, 'Diversión', true);


--
-- TOC entry 2752 (class 0 OID 82103)
-- Dependencies: 181
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2788 (class 0 OID 82292)
-- Dependencies: 217
-- Data for Name: postulado; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2760 (class 0 OID 82143)
-- Dependencies: 189
-- Data for Name: postulacion; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2756 (class 0 OID 82125)
-- Dependencies: 185
-- Data for Name: socio; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO socio VALUES (1, NULL, 'B-0339', 2, true);
INSERT INTO socio VALUES (2, NULL, 'B-0340', 3, true);
INSERT INTO socio VALUES (3, 1, 'B-0341', 4, true);
INSERT INTO socio VALUES (4, 2, 'B-0342', 5, true);
INSERT INTO socio VALUES (5, 3, 'B-0343', 6, true);


--
-- TOC entry 2758 (class 0 OID 82134)
-- Dependencies: 187
-- Data for Name: accion; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 186
-- Name: accion_id_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('accion_id_accion_seq', 11, true);


--
-- TOC entry 2864 (class 0 OID 82651)
-- Dependencies: 293
-- Data for Name: motivo_cancelacion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO motivo_cancelacion VALUES (1, 'Falta de Recursos', true);
INSERT INTO motivo_cancelacion VALUES (2, 'Por Presupuestos', true);
INSERT INTO motivo_cancelacion VALUES (3, 'Actividades Imcompletas', true);


--
-- TOC entry 2840 (class 0 OID 82538)
-- Dependencies: 269
-- Data for Name: cancelacion_evento; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2838 (class 0 OID 82529)
-- Dependencies: 267
-- Data for Name: estado_evento; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO estado_evento VALUES (1, 'Por Planificar', true);
INSERT INTO estado_evento VALUES (2, 'Listo para Ejecutar', true);
INSERT INTO estado_evento VALUES (3, 'En Ejecución', true);
INSERT INTO estado_evento VALUES (4, 'Finalizado', true);
INSERT INTO estado_evento VALUES (5, 'Cancelado', true);


--
-- TOC entry 2772 (class 0 OID 82213)
-- Dependencies: 201
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2774 (class 0 OID 82225)
-- Dependencies: 203
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 202
-- Name: actividad_id_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('actividad_id_actividad_seq', 1, false);


--
-- TOC entry 2824 (class 0 OID 82460)
-- Dependencies: 253
-- Data for Name: tipo_afiliado; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_afiliado VALUES (1, 'Esposo', '-1', true);
INSERT INTO tipo_afiliado VALUES (2, 'Esposa', '-1', true);
INSERT INTO tipo_afiliado VALUES (3, 'Hijo', '-2', true);
INSERT INTO tipo_afiliado VALUES (4, 'Hija', '-2', true);


--
-- TOC entry 2782 (class 0 OID 82265)
-- Dependencies: 211
-- Data for Name: afiliado; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO afiliado VALUES (1, 2, 1, 'B-0339--1', 15, true);
INSERT INTO afiliado VALUES (2, 3, 2, 'B-0340--2', 16, true);
INSERT INTO afiliado VALUES (3, 4, 3, 'B-0341--2', 17, true);
INSERT INTO afiliado VALUES (4, 3, 4, 'B-0342--2', 18, true);
INSERT INTO afiliado VALUES (5, 2, 5, 'B-0343--1', 19, true);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 210
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('afiliado_id_afilado_seq', 1, false);


--
-- TOC entry 2868 (class 0 OID 82668)
-- Dependencies: 297
-- Data for Name: tipo_instalacion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_instalacion VALUES (1, 'Deportivo', true);
INSERT INTO tipo_instalacion VALUES (2, 'Fiesta', true);
INSERT INTO tipo_instalacion VALUES (3, 'Infantil', true);
INSERT INTO tipo_instalacion VALUES (4, 'Caney', true);


--
-- TOC entry 2766 (class 0 OID 82176)
-- Dependencies: 195
-- Data for Name: instalacion; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2780 (class 0 OID 82255)
-- Dependencies: 209
-- Data for Name: reservacion; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2858 (class 0 OID 82625)
-- Dependencies: 287
-- Data for Name: tipo_pago; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_pago VALUES (1, 'Efectivo', true);
INSERT INTO tipo_pago VALUES (2, 'Transferencia', true);
INSERT INTO tipo_pago VALUES (3, 'Depósito', true);


--
-- TOC entry 2804 (class 0 OID 82370)
-- Dependencies: 233
-- Data for Name: alquiler; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 232
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('alquiler_id_alquiler_seq', 1, false);


--
-- TOC entry 2852 (class 0 OID 82595)
-- Dependencies: 281
-- Data for Name: archivo_alquiler; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 280
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('archivo_alquiler_id_archivo_alquiler_seq', 1, false);


--
-- TOC entry 2770 (class 0 OID 82201)
-- Dependencies: 199
-- Data for Name: calendario_fecha; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 198
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('calendario_fecha_id_calendario_fecha_seq', 1, false);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 268
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('cancelacion_evento_id_cancelacion_evento_seq', 1, false);


--
-- TOC entry 2812 (class 0 OID 82406)
-- Dependencies: 241
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO cargo VALUES (1, 'Presidente', true);
INSERT INTO cargo VALUES (2, 'Vicepresidente', true);
INSERT INTO cargo VALUES (3, 'Vocero', true);
INSERT INTO cargo VALUES (4, 'Tesorero', true);
INSERT INTO cargo VALUES (5, 'Secretario(a)', true);
INSERT INTO cargo VALUES (6, 'Coordinador Disciplinario', true);
INSERT INTO cargo VALUES (7, 'Secretario(a) Disciplinario', true);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 240
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('cargo_id_cargo_seq', 4, true);


--
-- TOC entry 2784 (class 0 OID 82274)
-- Dependencies: 213
-- Data for Name: cliente_externo; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 212
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('cliente_externo_id_cliente_seq', 1, false);


--
-- TOC entry 2746 (class 0 OID 82073)
-- Dependencies: 175
-- Data for Name: club; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO club VALUES (1, 'J-08521135-7', 'Centro Atlético América', 'Av. Fuerzas Armadas con Calle 57, Concepción, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.', 'Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus socios y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.', 'http://i.imgur.com/UKvuTwu.png', '0251-4411594', 'centroatleticoclubamerica@gmail.com', NULL, 'Incentivando y Promoviendo la Participación Cultural y Deportiva', true);


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 174
-- Name: club_id_club_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('club_id_club_seq', 1, false);


--
-- TOC entry 2820 (class 0 OID 82442)
-- Dependencies: 249
-- Data for Name: motivo_desvinculacion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO motivo_desvinculacion VALUES (1, 'Venta de Acción', true);
INSERT INTO motivo_desvinculacion VALUES (2, 'Socio Sancionado', true);


--
-- TOC entry 2790 (class 0 OID 82301)
-- Dependencies: 219
-- Data for Name: desvinculacion; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 218
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('desvinculacion_id_desvinculacion_seq', 1, false);


--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 278
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('estado_accion_id_estado_accion_seq', 4, true);


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 266
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('estado_evento_id_estado_evento_seq', 5, true);


--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 200
-- Name: evento_id_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('evento_id_evento_seq', 1, false);


--
-- TOC entry 2848 (class 0 OID 82577)
-- Dependencies: 277
-- Data for Name: tipo_eventualidad; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_eventualidad VALUES (1, 'Estravío de Recursos', true);
INSERT INTO tipo_eventualidad VALUES (2, 'Mala Conducta', true);
INSERT INTO tipo_eventualidad VALUES (3, 'Actos Inmorales', true);
INSERT INTO tipo_eventualidad VALUES (4, 'Daños a Instalación', true);
INSERT INTO tipo_eventualidad VALUES (5, 'Pelea', true);


--
-- TOC entry 2764 (class 0 OID 82164)
-- Dependencies: 193
-- Data for Name: eventualidad; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 192
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('eventualidad_id_eventualidad_seq', 1, false);


--
-- TOC entry 2822 (class 0 OID 82451)
-- Dependencies: 251
-- Data for Name: foto; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO foto VALUES (1, 'http://i.imgur.com/wHrzoYB.jpg', 1, true, 1, true);
INSERT INTO foto VALUES (2, 'http://i.imgur.com/cHPOldS.jpg', 2, true, 1, true);
INSERT INTO foto VALUES (3, 'http://i.imgur.com/2pTsUU6.jpg', 4, true, 1, true);


--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 250
-- Name: foto_id_foto_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('foto_id_foto_seq', 3, true);


--
-- TOC entry 2776 (class 0 OID 82234)
-- Dependencies: 205
-- Data for Name: funcion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO funcion VALUES (1, 'Configuración', ' ', 'z-icon-cogs', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (2, 'Socio', ' ', 'z-icon-user', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (3, 'Instalación', ' ', 'z-icon-home', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (4, 'Evento', ' ', 'z-icon-calendar', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (5, 'Consulta', ' ', 'z-icon-th-list', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (6, 'Adm. del Sistema', ' ', 'z-icon-puzzle-piece', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (7, 'Postulación', ' ', 'z-icon-puzzle-piece', ' ', 0, NULL, true);
INSERT INTO funcion VALUES (8, 'Categorias', ' ', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (9, 'Administrar Socio', ' ', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (10, 'Danos tu Opinión', ' ', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (11, 'Administrar Evento', ' ', 'z-icon-angle-double-right', ' ', 4, NULL, true);
INSERT INTO funcion VALUES (12, 'Estructurados', ' ', 'z-icon-angle-double-right', ' ', 5, NULL, true);
INSERT INTO funcion VALUES (13, 'Motivos Sanción', 'configuracion/categoria/motivoSancion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (14, 'Estadísticos', ' ', 'z-icon-angle-double-right', ' ', 5, NULL, true);
INSERT INTO funcion VALUES (15, 'Seguridad', ' ', 'z-icon-angle-double-right', ' ', 6, NULL, true);
INSERT INTO funcion VALUES (16, 'Perfil del Club', 'configuracion/perfilClub.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (17, 'Junta Directiva', 'configuracion/juntaDirectiva.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (18, 'Instalaciones', 'configuracion/gestionarInstalaciones.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (19, 'Reglas del Club', 'configuracion/reglasClub.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (20, 'Preferencias', 'configuracion/categoria/preferencia.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (21, 'Recursos', 'configuracion/categoria/recursos.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (22, 'Cargos Junta Directiva', 'configuracion/categoria/cargoJunta.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (23, 'Motivos Postulación', 'configuracion/categoria/motivoPostulacion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (24, 'Motivos Venta', 'configuracion/categoria/motivoVenta.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (25, 'Tipos Sugerencia', 'configuracion/categoria/tipoSugerencia.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (26, 'Tipos Preferencia', 'configuracion/categoria/tipoPreferencia.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (27, 'Tipos Instalación', 'configuracion/categoria/tipoInstalacion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (28, 'Tipos Sanción', 'configuracion/categoria/tipoSancion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (29, 'Tipos Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (32, 'Acciones', 'socio/acciones.zul', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (33, 'Mi Perfil', 'socio/miPerfil.zul', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (34, 'Mis Sanciones', 'socio/misSanciones.zul', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (35, 'Solicitar Venta', 'socio/solicitarVenta.zul', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (36, 'Registrar Socio', 'socio/administrarSocio/postulantes.zul', 'z-icon-angle-double-right', ' ', 9, NULL, true);
INSERT INTO funcion VALUES (37, 'Registrar Afiliado', 'socio/administrarSocio/socios.zul', 'z-icon-angle-double-right', ' ', 9, NULL, true);
INSERT INTO funcion VALUES (38, 'Sanciones', 'socio/administrarSocio/sanciones.zul', 'z-icon-angle-double-right', ' ', 9, NULL, true);
INSERT INTO funcion VALUES (39, 'Sugerencias', 'socio/buzon/vistaGeneralSugerencias.zul', 'z-icon-angle-double-right', ' ', 10, NULL, true);
INSERT INTO funcion VALUES (40, 'Opinar Postulación', 'socio/buzon/opinionPostulacion.zul', 'z-icon-angle-double-right', ' ', 10, NULL, true);
INSERT INTO funcion VALUES (41, 'Reservaciones', 'instalacion/misReservaciones.zul', 'z-icon-angle-double-right', ' ', 3, NULL, true);
INSERT INTO funcion VALUES (42, 'Alquileres', 'instalacion/administrarAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, NULL, true);
INSERT INTO funcion VALUES (43, 'Mis Alquileres', 'instalacion/misAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, NULL, true);
INSERT INTO funcion VALUES (44, 'Eventualidades', 'instalacion/registrarEventualidadInst.zul', 'z-icon-angle-double-right', ' ', 2, NULL, true);
INSERT INTO funcion VALUES (45, 'Registrar Eventos', 'evento/administrarEvento/listaEventos.zul', 'z-icon-angle-double-right', ' ', 11, NULL, true);
INSERT INTO funcion VALUES (46, 'Planificar Eventos', 'evento/administrarEvento/planificarEvento.zul', 'z-icon-angle-double-right', ' ', 11, NULL, true);
INSERT INTO funcion VALUES (47, 'Ejecutar Eventos', 'evento/administrarEvento/ejecutarEvento.zul', 'z-icon-angle-double-right', ' ', 11, NULL, true);
INSERT INTO funcion VALUES (49, 'Cartelera', 'administracion/cartelera.zul', 'z-icon-angle-double-right', ' ', 6, NULL, true);
INSERT INTO funcion VALUES (51, 'Usuarios', 'administracion/seguridad/usuarioGeneral.zul', 'z-icon-angle-double-right', ' ', 15, NULL, true);
INSERT INTO funcion VALUES (52, 'Grupos', 'administracion/seguridad/mostrarGrupos.zul', 'z-icon-angle-double-right', ' ', 15, NULL, true);
INSERT INTO funcion VALUES (53, 'Funciones', 'administracion/seguridad/administrarFunciones.zul', 'z-icon-angle-double-right', ' ', 15, NULL, true);
INSERT INTO funcion VALUES (54, 'Postulados', 'postulado/postulado.zul', 'z-icon-angle-double-right', ' ', 7, NULL, true);
INSERT INTO funcion VALUES (55, 'Administrar portal', 'configuracion/administracionPortal.zul', 'z-icon-angle-double-right', ' ', 1, NULL, true);
INSERT INTO funcion VALUES (56, 'Finalizar eventos', 'evento/administrarEvento/finalizarEvento.zul', 'z-icon-angle-double-right', ' ', 11, NULL, true);
INSERT INTO funcion VALUES (57, 'Alquileres', 'consultas/reporteAlquileres.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (58, 'Eventos', 'consultas/reporteEventos.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (59, 'Actividades de Evento', 'consultas/reporteActividadEventos.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (60, 'Socios', 'consultas/reporteSocios.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (61, 'Sanciones', 'consultas/reporteSanciones.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (62, 'Eventualidades', 'consultas/reporteEventualidad.zul', 'z-icon-angle-double-right', ' ', 12, NULL, true);
INSERT INTO funcion VALUES (63, 'Sanciones', 'consultas/reporteSancionesEst.zul', 'z-icon-angle-double-right', ' ', 14, NULL, true);
INSERT INTO funcion VALUES (64, 'Eventualidades', 'consultas/reporteEventualidadesEst.zul', 'z-icon-angle-double-right', ' ', 14, NULL, true);
INSERT INTO funcion VALUES (65, 'Eventos', 'consultas/reporteEventoValorEsperadoRealEst.zul', 'z-icon-angle-double-right', ' ', 14, NULL, true);
INSERT INTO funcion VALUES (66, 'Socios', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, NULL, true);
INSERT INTO funcion VALUES (68, 'Instalaciones', 'consultas/reporteInstalacionesEst.zul', 'z-icon-angle-double-right', ' ', 14, NULL, true);
INSERT INTO funcion VALUES (69, 'Redes Sociales', 'configuracion/categoria/redSocial.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (70, 'Tipos Eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (71, 'Indicadores', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (72, 'Tipos Opinión', 'configuracion/categoria/tipoOpinion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (73, 'Tipos Pago', 'configuracion/categoria/tipoPago.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (74, 'Tipos Noticia', 'configuracion/categoria/tipoNoticia.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (75, 'Motivos Cancelación', 'configuracion/categoria/motivoCancelacion.zul', 'z-icon-angle-double-right', ' ', 8, NULL, true);
INSERT INTO funcion VALUES (76, 'Sugerencias', 'socio/buzon/sugerenciaAdministrativo.zul', 'z-icon-angle-double-right', ' ', 10, NULL, true);


--
-- TOC entry 2750 (class 0 OID 82094)
-- Dependencies: 179
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2778 (class 0 OID 82246)
-- Dependencies: 207
-- Data for Name: funcion_grupo; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 206
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('funcion_grupo_id_funcion_grupo_seq', 1, false);


--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 204
-- Name: funcion_id_funcion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('funcion_id_funcion_seq', 1, false);


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 178
-- Name: grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('grupo_id_grupo_seq', 6, true);


--
-- TOC entry 2842 (class 0 OID 82547)
-- Dependencies: 271
-- Data for Name: indicador; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO indicador VALUES (1, 'Asistencia de Personas', true);
INSERT INTO indicador VALUES (2, 'Ingresos Recolectados', true);
INSERT INTO indicador VALUES (3, 'Utilidad', true);
INSERT INTO indicador VALUES (4, 'Ingresos por Inscripción a Torneos', true);
INSERT INTO indicador VALUES (5, 'Ingresos por Bebidas alcohólicas', true);


--
-- TOC entry 2844 (class 0 OID 82556)
-- Dependencies: 273
-- Data for Name: indicador_evento; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 272
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('indicador_evento_id_indicador_evento_seq', 1, false);


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 270
-- Name: indicador_id_indicador_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('indicador_id_indicador_seq', 5, true);


--
-- TOC entry 2796 (class 0 OID 82331)
-- Dependencies: 225
-- Data for Name: instalacion_evento; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 224
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('instalacion_evento_id_actividad_instalacion_seq', 1, false);


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 194
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('instalacion_id_instalacion_seq', 9, true);


--
-- TOC entry 2808 (class 0 OID 82388)
-- Dependencies: 237
-- Data for Name: junta_directiva; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO junta_directiva VALUES (1, 1, '2016-03-26', '2017-03-26', true);


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 236
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('junta_directiva_id_junta_directiva_seq', 1, false);


--
-- TOC entry 2810 (class 0 OID 82397)
-- Dependencies: 239
-- Data for Name: miembro_junta; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO miembro_junta VALUES (1, 1, 1, 24, true);
INSERT INTO miembro_junta VALUES (3, 1, 2, 25, true);
INSERT INTO miembro_junta VALUES (4, 1, 4, 1, true);
INSERT INTO miembro_junta VALUES (5, 1, 3, 27, true);
INSERT INTO miembro_junta VALUES (6, 1, 6, 29, true);
INSERT INTO miembro_junta VALUES (8, 1, 7, 30, true);


--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 238
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('miembro_junta_id_junta_miembro_seq', 1, false);


--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 292
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('motivo_cancelacion_id_motivo_cancelacion_seq', 3, true);


--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 248
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('motivo_desvinculacion_id_motivo_desvinculacion_seq', 2, true);


--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 262
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('motivo_postulacion_id_motivo_postulacion_seq', 6, true);


--
-- TOC entry 2866 (class 0 OID 82659)
-- Dependencies: 295
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO motivo_sancion VALUES (1, 'Eventualidad', true);
INSERT INTO motivo_sancion VALUES (2, 'Morosidad', true);


--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 294
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('motivo_sancion_id_motivo_sancion_seq', 2, true);


--
-- TOC entry 2836 (class 0 OID 82520)
-- Dependencies: 265
-- Data for Name: motivo_venta; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO motivo_venta VALUES (1, 'Necesidad Económica', true);
INSERT INTO motivo_venta VALUES (2, 'Cambio de Ciudad', true);
INSERT INTO motivo_venta VALUES (3, 'Descontento con el Club', true);
INSERT INTO motivo_venta VALUES (4, 'Otro', true);


--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 264
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('motivo_venta_id_motivo_venta_seq', 4, true);


--
-- TOC entry 2854 (class 0 OID 82604)
-- Dependencies: 283
-- Data for Name: tipo_noticia; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_noticia VALUES (1, 'Evento Auto', '#3300cc', false);
INSERT INTO tipo_noticia VALUES (2, 'Postulación Auto', '#f88514', false);
INSERT INTO tipo_noticia VALUES (3, 'Evento', '#3300cc', true);
INSERT INTO tipo_noticia VALUES (4, 'Postulación', '#f88514', true);
INSERT INTO tipo_noticia VALUES (5, 'Acciones', '#FFFF00', true);
INSERT INTO tipo_noticia VALUES (6, 'Sucesos', '#cc00ff', true);
INSERT INTO tipo_noticia VALUES (7, 'Otros', '#FFA500', true);


--
-- TOC entry 2768 (class 0 OID 82189)
-- Dependencies: 197
-- Data for Name: noticia; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO noticia VALUES (1, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:20:33.75', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (2, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:20:49.523', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (3, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:21:01.145', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (4, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:21:08.963', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (5, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:21:15.307', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (6, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:21:23.035', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (7, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:22:01.331', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (8, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:22:21.006', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (9, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:22:32.608', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (10, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:22:48.248', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (11, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:23:01.766', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (12, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:23:20.464', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (13, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:23:39.357', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (14, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:23:52.154', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (15, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:24:17.597', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (16, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:24:39.648', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (17, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:24:50.74', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (18, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:03.184', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (19, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:14.186', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (20, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:25.402', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (21, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:35.536', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (22, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:46.398', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (23, 'Acci�n en Venta', '�Se a aperturado el proceso de postulaci�n para una acci�n en venta!', NULL, NULL, NULL, 2, '2016-03-26 11:25:56.887', '2016-04-10', true, NULL, true);
INSERT INTO noticia VALUES (34, 'Nueva Postulaci�n', 'El Sr(a). Hilder Hernandez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 8, 'http://i.imgur.com/S0doLDj.jpg', 5, '2016-03-26 12:26:43.146', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (27, 'Nuevo Socio', '�El Sr(a). Jose Abreu es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/Yv0dyo8.jpg', 6, '2016-03-26 12:09:32.541', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (24, 'Nueva Postulaci�n', 'El Sr(a). Jose Abreu, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 1, 'http://i.imgur.com/Yv0dyo8.jpg', 5, '2016-03-26 11:26:33.138', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (28, 'Nuevo Socio', '�El Sr(a). Fidel Aliaga es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/mm8CZWD.jpg', 6, '2016-03-26 12:09:54.99', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (25, 'Nueva Postulaci�n', 'El Sr(a). Fidel Aliaga, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 2, 'http://i.imgur.com/mm8CZWD.jpg', 5, '2016-03-26 12:03:55.454', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (29, 'Nuevo Socio', '�El Sr(a). Anthony Cordero es un nuevo intengrante de la familia americanista', NULL, NULL, 'http://i.imgur.com/aAY7hKL.jpg', 6, '2016-03-26 12:10:11.397', '2016-03-31', true, NULL, true);
INSERT INTO noticia VALUES (26, 'Nueva Postulaci�n', 'El Sr(a). Anthony Cordero, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 3, 'http://i.imgur.com/aAY7hKL.jpg', 5, '2016-03-26 12:05:57.009', '2016-04-10', false, NULL, false);
INSERT INTO noticia VALUES (30, 'Nueva Postulaci�n', 'El Sr(a). Rosmary Fuentes, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 4, 'http://i.imgur.com/qsXtB2A.jpg', 5, '2016-03-26 12:16:52.941', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (31, 'Nueva Postulaci�n', 'El Sr(a). Dixon Garcia, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 5, 'http://i.imgur.com/DxGxqhY.jpg', 5, '2016-03-26 12:20:33.811', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (32, 'Nueva Postulaci�n', 'El Sr(a). Hector Gil, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 6, 'http://i.imgur.com/OPpIMSz.jpg', 5, '2016-03-26 12:22:17.703', '2016-04-10', false, NULL, true);
INSERT INTO noticia VALUES (33, 'Nueva Postulaci�n', 'El Sr(a). Xavier Gutierrez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secci�n de opiniones postulantes!', NULL, 7, 'http://i.imgur.com/Nv1pWz8.jpg', 5, '2016-03-26 12:24:02.634', '2016-04-10', false, NULL, true);


--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 196
-- Name: noticia_id_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('noticia_id_noticia_seq', 1, false);


--
-- TOC entry 2816 (class 0 OID 82424)
-- Dependencies: 245
-- Data for Name: tipo_preferencia; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_preferencia VALUES (1, 'Cultural', '#008000', true);
INSERT INTO tipo_preferencia VALUES (2, 'Deportiva', '#0000FF', true);
INSERT INTO tipo_preferencia VALUES (3, 'Social', '#20B2AA', true);
INSERT INTO tipo_preferencia VALUES (4, 'Jobby', '#20B2AA', true);


--
-- TOC entry 2786 (class 0 OID 82283)
-- Dependencies: 215
-- Data for Name: preferencia; Type: TABLE DATA; Schema: public; Owner: root
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
INSERT INTO preferencia VALUES (10, 'Bebedor Ocasional', 3, true);
INSERT INTO preferencia VALUES (11, 'Televisión', 4, true);
INSERT INTO preferencia VALUES (12, 'Cine', 4, true);
INSERT INTO preferencia VALUES (13, 'Cantar', 4, true);
INSERT INTO preferencia VALUES (14, 'Ciclismo', 2, true);


--
-- TOC entry 2818 (class 0 OID 82433)
-- Dependencies: 247
-- Data for Name: noticia_preferencia; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 246
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('noticia_preferencia_id_noticia_preferencia_seq', 1, false);


--
-- TOC entry 2860 (class 0 OID 82633)
-- Dependencies: 289
-- Data for Name: tipo_opnion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_opnion VALUES (1, 'Lo Recomiendo', true);
INSERT INTO tipo_opnion VALUES (2, 'No lo Recomiendo', true);
INSERT INTO tipo_opnion VALUES (3, 'No lo Conozco', true);


--
-- TOC entry 2744 (class 0 OID 82064)
-- Dependencies: 173
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2762 (class 0 OID 82152)
-- Dependencies: 191
-- Data for Name: opinion; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 190
-- Name: opinion_id_opinion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('opinion_id_opinion_seq', 1, false);


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 180
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('persona_id_persona_seq', 3, true);


--
-- TOC entry 2806 (class 0 OID 82379)
-- Dependencies: 235
-- Data for Name: politica; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO politica VALUES (1, 'Personas que puede traer un socio por visita diaria', 3, 1, true);
INSERT INTO politica VALUES (2, 'Veces que puede traer a un mismo invitado al mes', 3, 1, true);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 234
-- Name: politica_id_politica_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('politica_id_politica_seq', 2, true);


--
-- TOC entry 2856 (class 0 OID 82613)
-- Dependencies: 285
-- Data for Name: portal; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO portal VALUES (1, 'El Centro Atlético América cuenta con canchas de Tenis, Baloncesto, Béisbol, Bolas criollas. Además cuenta con un Salón de Fiestas y dos Caneyes para el disfrute de sus socios e invitados', 'Nuestros Socios Se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de Club. ¿Quieres ser un socio del Centro Atlético América?', 'Nos Interesa Motivar la interacción social a través de actividades culturales de intercambio, en busca del crecimiento humano mediante la Realización de Eventos. ¿Quieres participar en nuestros Eventos?', true, 'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 284
-- Name: portal_id_portal_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('portal_id_portal_seq', 1, false);


--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 188
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('postulacion_id_postulacion_seq', 1, false);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 216
-- Name: postulado_id_postulado_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('postulado_id_postulado_seq', 1, false);


--
-- TOC entry 2826 (class 0 OID 82472)
-- Dependencies: 255
-- Data for Name: preferencia_evento; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 254
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('preferencia_evento_id_preferencia_evento_seq', 1, false);


--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 214
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('preferencia_id_preferencia_seq', 14, true);


--
-- TOC entry 2794 (class 0 OID 82322)
-- Dependencies: 223
-- Data for Name: preferencia_persona; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 222
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('preferencia_persona_id_preferencia_persona_seq', 1, false);


--
-- TOC entry 2798 (class 0 OID 82340)
-- Dependencies: 227
-- Data for Name: recurso; Type: TABLE DATA; Schema: public; Owner: root
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
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 226
-- Name: recurso_id_recurso_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('recurso_id_recurso_seq', 12, true);


--
-- TOC entry 2802 (class 0 OID 82361)
-- Dependencies: 231
-- Data for Name: recurso_instalacion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO recurso_instalacion VALUES (1, 2, 1, 100, true);
INSERT INTO recurso_instalacion VALUES (2, 2, 2, 100, true);


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 230
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('recurso_instalacion_id_recurso_instalacion_seq', 2, true);


--
-- TOC entry 2828 (class 0 OID 82481)
-- Dependencies: 257
-- Data for Name: red_social; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO red_social VALUES (1, 'Facebook', 'http://i.imgur.com/J8nfPwn.png', true);
INSERT INTO red_social VALUES (2, 'Instagram', 'http://i.imgur.com/E6xQKvN.png', true);
INSERT INTO red_social VALUES (3, 'Twitter', 'http://i.imgur.com/rox1qxk.png', true);


--
-- TOC entry 2830 (class 0 OID 82493)
-- Dependencies: 259
-- Data for Name: red_club; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO red_club VALUES (1, 1, 3, 'https://twitter.com/CAAAMERICA', true);
INSERT INTO red_club VALUES (2, 1, 1, 'https://www.facebook.com/accaa', true);


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 258
-- Name: red_club_id_red_club_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('red_club_id_red_club_seq', 2, true);


--
-- TOC entry 2832 (class 0 OID 82502)
-- Dependencies: 261
-- Data for Name: red_persona; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 260
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('red_persona_id_red_persona_seq', 1, false);


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 256
-- Name: red_social_id_red_social_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('red_social_id_red_social_seq', 3, true);


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('reservacion_id_reservacion_seq', 1, false);


--
-- TOC entry 2862 (class 0 OID 82642)
-- Dependencies: 291
-- Data for Name: tipo_sancion; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_sancion VALUES (1, 'Suspensión', true);
INSERT INTO tipo_sancion VALUES (2, 'Multa', true);


--
-- TOC entry 2754 (class 0 OID 82115)
-- Dependencies: 183
-- Data for Name: sancion; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 182
-- Name: sancion_id_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('sancion_id_sancion_seq', 1, false);


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 184
-- Name: socio_id_socio_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('socio_id_socio_seq', 2, true);


--
-- TOC entry 2846 (class 0 OID 82565)
-- Dependencies: 275
-- Data for Name: solicitud_venta; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 274
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('solicitud_venta_id_solicitud_venta_seq', 1, false);


--
-- TOC entry 2814 (class 0 OID 82415)
-- Dependencies: 243
-- Data for Name: tipo_sugerencia; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tipo_sugerencia VALUES (1, 'Pregunta', true);
INSERT INTO tipo_sugerencia VALUES (2, 'Sugerencia', true);
INSERT INTO tipo_sugerencia VALUES (3, 'Comentario', true);
INSERT INTO tipo_sugerencia VALUES (4, 'Queja', true);
INSERT INTO tipo_sugerencia VALUES (5, 'Reclamo', true);


--
-- TOC entry 2800 (class 0 OID 82349)
-- Dependencies: 229
-- Data for Name: sugerencia; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 228
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('sugerencia_id_sugerencia_seq', 1, false);


--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 252
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_afiliado_id_tipo_afiliado_seq', 4, true);


--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 276
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_eventualidad_id_tipo_eventualidad_seq', 5, true);


--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 296
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_instalacion_id_tipo_instalacion_seq', 4, true);


--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 282
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_noticia_id_tipo_noticia_seq', 7, true);


--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 288
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_opnion_id_tipo_opninion_seq', 3, true);


--
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 286
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_pago_id_tipo_pago_seq', 3, true);


--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 244
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_preferencia_id_tipo_preferencia_seq', 4, true);


--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 290
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_sancion_id_tipo_sancion_seq', 2, true);


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 242
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('tipo_sugerencia_id_tipo_sugerencia_seq', 5, true);


--
-- TOC entry 2748 (class 0 OID 82085)
-- Dependencies: 177
-- Data for Name: usuario_grupo; Type: TABLE DATA; Schema: public; Owner: root
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


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 176
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('usuario_grupo_id_usuario_grupo_seq', 1, false);


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 3, true);


--
-- TOC entry 2792 (class 0 OID 82313)
-- Dependencies: 221
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 220
-- Name: venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('venta_id_venta_seq', 1, false);


-- Completed on 2016-03-26 16:21:51 VET

--
-- PostgreSQL database dump complete
--
