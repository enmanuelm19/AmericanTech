--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-03-19 10:18:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

--
-- TOC entry 2834 (class 0 OID 31342)
-- Dependencies: 281
-- Data for Name: estado_accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO estado_accion (id_estado_accion, nombre, activo) VALUES (1, 'Asociada', true);
INSERT INTO estado_accion (id_estado_accion, nombre, activo) VALUES (2, 'En Venta', true);
INSERT INTO estado_accion (id_estado_accion, nombre, activo) VALUES (3, 'En Solicitud', true);
INSERT INTO estado_accion (id_estado_accion, nombre, activo) VALUES (4, 'Inactiva', true);


--
-- TOC entry 2816 (class 0 OID 31258)
-- Dependencies: 263
-- Data for Name: motivo_postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (1, 'Beneficios del Club', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (2, 'InversiÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (3, 'Deporte', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (4, 'Osio', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (5, 'RecreaciÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (6, 'DiversiÃ³n', true);
INSERT INTO motivo_postulacion (id_motivo_postulacion, descripcion, activo) VALUES (7, 'Por amor', true);


--
-- TOC entry 2734 (class 0 OID 30852)
-- Dependencies: 181
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (9, '21140247', 'Mariangel', 'Arrieche', 'http://i.imgur.com/8t2CuRs.png', '1980-03-18', 'F', 'mariangel@gmail.com', '0416555555', '02412222222', 'barquisimeto', false);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (15, '7878186682', 'jhdjdjh', 'kjdjdkkjds', NULL, '1989-08-18', 'F', 'j@h.c', '78389327', NULL, 'hkdhkdshds', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (12, '43353553', 'Maria', 'Rosario', NULL, '1976-09-24', 'F', 'maria@gmail.com', '04243131311', NULL, 'Prados del Golf III, Cabudare', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (11, '11593903', 'Romulo', 'Dominguez', 'http://i.imgur.com/duCXybQ.jpg', '1972-03-03', 'M', 'rdominguez@gmail.com', '04168765555', '02512557654', 'Pardos del Glof III Cabudare', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (10, '373932737', 'Roman', 'Arrieche', 'http://i.imgur.com/krJ9S4R.png', '1992-03-18', 'M', 'roman@gmail.com', '041255555', NULL, 'Barquisimeto', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (4, '55555555', 'Manuel', 'Guerrero', 'http://i.imgur.com/xXp0wXP.png', '1983-06-01', 'M', 'manuel@gmail.com', '04147658877', '02516548265', 'Carrera 25 con calle 12', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (1, '20387728', 'Enmanuel', 'Medina', NULL, '1980-03-01', 'M', 'enmanuelm19@gmail.com', '04146549874', '02516548765', 'Cabudare', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (2, '12345678', 'Carlos', 'Amaro', NULL, '1981-04-01', 'M', 'carlos@gmail.com', '04249876668', '02513348765', 'Barquisimeto', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (3, '11111111', 'Juan', 'Petaquero', NULL, '1982-05-01', 'M', 'juan@gmail.com', '04127896654', '02516548705', 'Valle Hondo, Cabudare', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (5, '33333333', 'Sergio', 'Hernandez', NULL, '1983-07-01', 'M', 'sergio@hotmail.com', '04167779788', '02516540965', 'Av Libertador con calle 12', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (6, '99999999', 'Pedro', 'Camacaro', NULL, '1984-08-01', 'M', 'pedrocamacaro@gmail.com', '04263423433', '0255657432', 'Santa Isabel, Avenida 4', true);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (7, '22186230', 'Fidel', 'Aliaga', 'http://i.imgur.com/mSJl1BZ.jpg', '1985-03-17', 'M', 'fidel.alejos@gmail.com', '04263237394', '02512553545', 'Barquisimeto', false);
INSERT INTO persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) VALUES (8, '19648893', 'Ruben', 'Vivas', 'http://i.imgur.com/ycCM1PJ.jpg', '1991-09-13', 'M', 'rvivas89@gmail.com', '04165438877', '02513456566', 'UrbanizaciÃ³n Las Trinitarias2', false);


--
-- TOC entry 2770 (class 0 OID 31039)
-- Dependencies: 217
-- Data for Name: postulado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO postulado (id_postulado, personaid_persona, activo) VALUES (1, 7, true);
INSERT INTO postulado (id_postulado, personaid_persona, activo) VALUES (2, 8, true);
INSERT INTO postulado (id_postulado, personaid_persona, activo) VALUES (3, 9, true);
INSERT INTO postulado (id_postulado, personaid_persona, activo) VALUES (4, 11, true);


--
-- TOC entry 2742 (class 0 OID 30891)
-- Dependencies: 189
-- Data for Name: postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO postulacion (id_postulacion, postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES (1, 1, '2016-03-17', 'B-0339', 'B-0342', 1, true, false);
INSERT INTO postulacion (id_postulacion, postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES (2, 2, '2016-03-18', 'B-0341', 'B-0342', 2, true, false);
INSERT INTO postulacion (id_postulacion, postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES (3, 3, '2016-03-18', 'B-0342', 'B-0340', 2, true, false);
INSERT INTO postulacion (id_postulacion, postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) VALUES (4, 4, '2016-03-18', 'B-0341', 'B-0340', 1, true, false);


--
-- TOC entry 2738 (class 0 OID 30873)
-- Dependencies: 185
-- Data for Name: socio; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (1, NULL, 'B-0338', 1, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (2, NULL, 'B-0339', 2, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (3, NULL, 'B-0340', 3, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (4, NULL, 'B-0341', 4, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (5, NULL, 'B-0342', 5, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (6, NULL, 'B-0343', 6, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (7, 1, 'B-0344', 7, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (8, 2, 'B-0349', 8, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (9, 3, 'B-0330', 9, true);
INSERT INTO socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) VALUES (10, 4, 'B-0350', 11, true);


--
-- TOC entry 2740 (class 0 OID 30882)
-- Dependencies: 187
-- Data for Name: accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (1, 'A00000001', 10000, 1, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (2, 'A00000002', 10000, 2, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (3, 'A00000003', 10000, 3, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (4, 'A00000004', 10000, 4, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (5, 'A00000005', 10000, 5, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (6, 'A00000006', 10000, 6, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (7, 'A00000007', 10000, 7, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (8, 'A00000008', 10000, 8, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (9, 'A0000009', 10000, 9, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (10, 'A000010', 10000, 10, 1, true);
INSERT INTO accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) VALUES (11, 'A000011', 10000, NULL, 2, true);


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 186
-- Name: accion_id_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('accion_id_accion_seq', 1, false);


--
-- TOC entry 2850 (class 0 OID 31416)
-- Dependencies: 297
-- Data for Name: motivo_cancelacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_cancelacion (id_motivo_cancelacion, descripcion, activo) VALUES (1, 'Falta de Recursos', true);
INSERT INTO motivo_cancelacion (id_motivo_cancelacion, descripcion, activo) VALUES (2, 'Por Presupuestos', true);
INSERT INTO motivo_cancelacion (id_motivo_cancelacion, descripcion, activo) VALUES (3, 'Actividades Imcompletas', true);


--
-- TOC entry 2824 (class 0 OID 31294)
-- Dependencies: 271
-- Data for Name: cancelacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2822 (class 0 OID 31285)
-- Dependencies: 269
-- Data for Name: estado_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO estado_evento (id_estado_evento, nombre, activo) VALUES (1, 'Por Planificar', true);
INSERT INTO estado_evento (id_estado_evento, nombre, activo) VALUES (2, 'Listo para Ejecutar', true);
INSERT INTO estado_evento (id_estado_evento, nombre, activo) VALUES (3, 'En Ejecucion', true);
INSERT INTO estado_evento (id_estado_evento, nombre, activo) VALUES (4, 'Finalizado', true);
INSERT INTO estado_evento (id_estado_evento, nombre, activo) VALUES (5, 'Cancelado', true);


--
-- TOC entry 2754 (class 0 OID 30961)
-- Dependencies: 201
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO evento (id_evento, nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES (3, 'Evento Hilder', 'Este un evento con la noticia corregida', '2016-03-25 00:00:00', '2016-04-01 00:00:00', true, 1, NULL, true);
INSERT INTO evento (id_evento, nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES (2, 'Torneo de Beisbol', 'Disfruta del Torneo de Beisbol', '2016-03-18 00:00:00', '2016-03-19 00:00:00', false, 4, NULL, true);
INSERT INTO evento (id_evento, nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) VALUES (4, 'parrilla osullivan', 'evento  para quitar la presion de los desarrolladores del club america', '2016-03-20 00:00:00', '2016-03-21 00:00:00', true, 4, NULL, true);


--
-- TOC entry 2756 (class 0 OID 30973)
-- Dependencies: 203
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (3, 'Buscar Pelotas', 2, '2016-03-18 00:00:00', '2016-03-18 00:00:00', 250, 300, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (2, 'Buscar bates', 2, '2016-03-18 00:00:00', NULL, 30, NULL, false, false);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (4, 'Buscar Bates', 2, '2016-03-18 00:00:00', '2016-03-18 00:00:00', 100, 100, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (1, 'Buscar pelotas', 2, '2016-03-18 00:00:00', NULL, 50, NULL, false, false);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (5, 'buscar cervezas', 4, '2016-03-20 00:00:00', '2016-03-18 00:00:00', 20, 10, true, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (7, 'buscar refrescos', 4, '2016-03-20 00:00:00', NULL, 10, NULL, false, true);
INSERT INTO actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) VALUES (6, 'buscar kilos de carne', 4, '2016-03-20 00:00:00', NULL, 3, NULL, false, true);


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 202
-- Name: actividad_id_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_id_actividad_seq', 1, false);


--
-- TOC entry 2806 (class 0 OID 31207)
-- Dependencies: 253
-- Data for Name: tipo_afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_afiliado (id_tipo_afiliado, descripcion, subfijo, activo) VALUES (1, 'Esposa', '-1', true);
INSERT INTO tipo_afiliado (id_tipo_afiliado, descripcion, subfijo, activo) VALUES (2, 'Hijo', '-2', true);


--
-- TOC entry 2764 (class 0 OID 31012)
-- Dependencies: 211
-- Data for Name: afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO afiliado (id_afilado, tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (1, 2, 9, 'B-0330--2', 10, true);
INSERT INTO afiliado (id_afilado, tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (2, 1, 10, 'B-0350--1', 12, true);
INSERT INTO afiliado (id_afilado, tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) VALUES (3, 1, 4, 'B-0341--1', 15, true);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 210
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('afiliado_id_afilado_seq', 1, false);


--
-- TOC entry 2854 (class 0 OID 31433)
-- Dependencies: 301
-- Data for Name: tipo_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_instalacion (id_tipo_instalacion, descripcion, activo) VALUES (2, 'Fiesta', true);
INSERT INTO tipo_instalacion (id_tipo_instalacion, descripcion, activo) VALUES (3, 'Infantil', true);
INSERT INTO tipo_instalacion (id_tipo_instalacion, descripcion, activo) VALUES (1, 'Deportiva', true);


--
-- TOC entry 2748 (class 0 OID 30924)
-- Dependencies: 195
-- Data for Name: instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO instalacion (id_instalacion, nombre, descripcion, capacidad, precio_alquiler, alquilable, tipo_instalacionid_tipo_instalacion, activo) VALUES (1, 'Campo de Beisbol', 'espacio para la practica de beisbol', 500, 2000, true, 1, true);
INSERT INTO instalacion (id_instalacion, nombre, descripcion, capacidad, precio_alquiler, alquilable, tipo_instalacionid_tipo_instalacion, activo) VALUES (2, 'Salon de Fiesta', 'Espacio para fiestas y celebraciones', 150, 20000, true, 2, true);
INSERT INTO instalacion (id_instalacion, nombre, descripcion, capacidad, precio_alquiler, alquilable, tipo_instalacionid_tipo_instalacion, activo) VALUES (3, 'Parque Infantil', 'area recreacional para niÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â±os', 150, 2000, false, 3, true);


--
-- TOC entry 2762 (class 0 OID 31003)
-- Dependencies: 209
-- Data for Name: reservacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO reservacion (id_reservacion, instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, condicion, activo) VALUES (1, 1, 4, '2016-03-22 15:00:00', '2016-03-24 19:00:00', 'A', true);
INSERT INTO reservacion (id_reservacion, instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, condicion, activo) VALUES (2, 2, 4, '2016-03-18 00:00:00', '2016-03-20 00:00:00', 'A', true);


--
-- TOC entry 2844 (class 0 OID 31390)
-- Dependencies: 291
-- Data for Name: tipo_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_pago (id_tipo_pago, descripcion, activo) VALUES (1, 'Efectivo', true);
INSERT INTO tipo_pago (id_tipo_pago, descripcion, activo) VALUES (2, 'Debito', true);
INSERT INTO tipo_pago (id_tipo_pago, descripcion, activo) VALUES (3, 'Transferencia', true);


--
-- TOC entry 2786 (class 0 OID 31117)
-- Dependencies: 233
-- Data for Name: alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO alquiler (id_alquiler, reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo) VALUES (1, 1, 1, '2016-03-18', 0, true);
INSERT INTO alquiler (id_alquiler, reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo) VALUES (2, 2, 1, '2016-03-18', 0, true);


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 232
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alquiler_id_alquiler_seq', 1, false);



--
-- TOC entry 2836 (class 0 OID 31351)
-- Dependencies: 283
-- Data for Name: archivo_alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 282
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('archivo_alquiler_id_archivo_alquiler_seq', 1, false);

--
-- TOC entry 2752 (class 0 OID 30949)
-- Dependencies: 199
-- Data for Name: calendario_fecha; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO calendario_fecha (id_calendario_fecha, descripcion, fecha, eventoid_evento, reservacionid_reservacion, activo) VALUES (1, 'espacio para la practica de beisbol', '2016-03-18', NULL, 1, true);
INSERT INTO calendario_fecha (id_calendario_fecha, descripcion, fecha, eventoid_evento, reservacionid_reservacion, activo) VALUES (2, 'Espacio para fiestas y celebraciones', '2016-03-18', NULL, 2, true);


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 198
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('calendario_fecha_id_calendario_fecha_seq', 1, false);


--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 270
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cancelacion_evento_id_cancelacion_evento_seq', 1, false);


--
-- TOC entry 2794 (class 0 OID 31153)
-- Dependencies: 241
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cargo (id_cargo, descripcion, activo) VALUES (1, 'Presidente', true);
INSERT INTO cargo (id_cargo, descripcion, activo) VALUES (2, 'Vicepresidente', true);
INSERT INTO cargo (id_cargo, descripcion, activo) VALUES (3, 'Vocero', true);
INSERT INTO cargo (id_cargo, descripcion, activo) VALUES (4, 'Tesorero', true);


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 240
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_cargo_seq', 1, true);


--
-- TOC entry 2766 (class 0 OID 31021)
-- Dependencies: 213
-- Data for Name: cliente_externo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO cliente_externo (id_cliente, nombre, apellido, correo, activo) VALUES (1, 'Fidel', 'Aliaga', 'fidel.alejos@gmail.com', true);
INSERT INTO cliente_externo (id_cliente, nombre, apellido, correo, activo) VALUES (2, 'Gipsy', 'Martinez', 'gipsy@gmail.com', true);


--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 212
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_externo_id_cliente_seq', 1, false);


--
-- TOC entry 2728 (class 0 OID 30822)
-- Dependencies: 175
-- Data for Name: club; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, logo, telf_alternativo, correo, clave_correo, eslogan, activo) VALUES (1, 'J-08521135-7', 'Centro AtlÃ©tico America', 'Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la uniÃ³n familiar y consolidando el legado de sus fundadores.', 'Constituirnos como la instituciÃ³n social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformaciÃ³n consolidando un ambiente cada dÃ­a mÃ¡s idÃ³neo para el desarrollo biopsicosocial de nuestras generaciones.', 'http://i.imgur.com/bzOnmjv.png', '0251-4411594', 'centroatleticoclubamerica@gmail.com', NULL, 'Incentivando y promoviendo la participaciÃ³n cultural y deportiva', true);


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 174
-- Name: club_id_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('club_id_club_seq', 1, false);


--
-- TOC entry 2802 (class 0 OID 31189)
-- Dependencies: 249
-- Data for Name: motivo_desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2772 (class 0 OID 31048)
-- Dependencies: 219
-- Data for Name: desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 218
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('desvinculacion_id_desvinculacion_seq', 1, false);


--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 280
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_accion_id_estado_accion_seq', 4, true);


--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 268
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_evento_id_estado_evento_seq', 5, true);


--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 200
-- Name: evento_id_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('evento_id_evento_seq', 1, false);


--
-- TOC entry 2832 (class 0 OID 31333)
-- Dependencies: 279
-- Data for Name: tipo_eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_eventualidad (id_tipo_eventualidad, descripcion, activo) VALUES (1, 'Pelea', true);
INSERT INTO tipo_eventualidad (id_tipo_eventualidad, descripcion, activo) VALUES (2, 'DaÃ±os propiedad', true);
INSERT INTO tipo_eventualidad (id_tipo_eventualidad, descripcion, activo) VALUES (3, 'Acto inmoral', true);


--
-- TOC entry 2746 (class 0 OID 30912)
-- Dependencies: 193
-- Data for Name: eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 192
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('eventualidad_id_eventualidad_seq', 1, false);


--
-- TOC entry 2804 (class 0 OID 31198)
-- Dependencies: 251
-- Data for Name: foto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO foto (id_foto, url, instalacionid_instalacion, publico, clubid_club, activo) VALUES (1, 'http://i.imgur.com/wHrzoYB.jpg', 1, true, 1, true);
INSERT INTO foto (id_foto, url, instalacionid_instalacion, publico, clubid_club, activo) VALUES (2, 'http://i.imgur.com/cHPOldS.jpg', 2, true, 1, true);
INSERT INTO foto (id_foto, url, instalacionid_instalacion, publico, clubid_club, activo) VALUES (3, 'http://i.imgur.com/2pTsUU6.jpg', 2, true, 1, true);


--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 250
-- Name: foto_id_foto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('foto_id_foto_seq', 3, true);


--
-- TOC entry 2758 (class 0 OID 30982)
-- Dependencies: 205
-- Data for Name: funcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (1, 'Configuracion', ' ', 'z-icon-cogs', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (2, 'Socios', ' ', 'z-icon-user', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (3, 'Instalaciones', ' ', 'z-icon-home', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (4, 'Eventos', ' ', 'z-icon-calendar', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (5, 'Consulta', ' ', 'z-icon-th-list', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (6, 'Adm. del sistema', ' ', 'z-icon-puzzle-piece', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (7, 'Postulaciones', ' ', 'z-icon-puzzle-piece', ' ', 0, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (8, 'Categorias', ' ', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (9, 'Administrar socio', ' ', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (10, 'Danos tu opinion', ' ', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (11, 'Administrar evento', ' ', 'z-icon-angle-double-right', ' ', 4, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (12, 'Estructurado', ' ', 'z-icon-angle-double-right', ' ', 5, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (13, 'Motivo Sancion', 'configuracion/categoria/motivoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (14, 'Estadisticos', ' ', 'z-icon-angle-double-right', ' ', 5, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (15, 'Seguridad', ' ', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (16, 'Perfil del club', 'configuracion/perfilClub.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (17, 'Junta directiva', 'configuracion/juntaDirectiva.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (18, 'Instalaciones', 'configuracion/gestionarInstalaciones.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (19, 'Reglas club', 'configuracion/reglasClub.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (20, 'Preferencias', 'configuracion/categoria/preferencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (21, 'Recursos', 'configuracion/categoria/recursos.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (22, 'Cargo junta directiva', 'configuracion/categoria/cargoJunta.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (23, 'Motivo postulacion', 'configuracion/categoria/motivoPostulacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (24, 'Motivo venta', 'configuracion/categoria/motivoVenta.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (25, 'Tipo sugerencia', 'configuracion/categoria/tipoSugerencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (26, 'Tipo preferencia', 'configuracion/categoria/tipoPreferencia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (27, 'Tipo instalacion', 'configuracion/categoria/tipoInstalacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (28, 'Tipo sancion', 'configuracion/categoria/tipoSancion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (29, 'Tipo Afiliado', 'configuracion/categoria/tipoAfiliado.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (31, 'Motivo desvinculacion', 'configuracion/categoria/motivoDesvinculacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (32, 'Acciones', 'socio/acciones.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (33, 'Mi perfil', 'socio/miPerfil.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (34, 'Mis sanciones', 'socio/misSanciones.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (35, 'Solicitar venta', 'socio/solicitarVenta.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (36, 'Registrar socio', 'socio/administrarSocio/postulantes.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (37, 'Registrar afiliado', 'socio/administrarSocio/socios.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (38, 'Sanciones', 'socio/administrarSocio/sanciones.zul', 'z-icon-angle-double-right', ' ', 9, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (39, 'Sugerencias', 'socio/buzon/vistaGeneralSugerencias.zul', 'z-icon-angle-double-right', ' ', 10, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (40, 'Opinion postulacion', 'socio/buzon/opinionPostulacion.zul', 'z-icon-angle-double-right', ' ', 10, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (41, 'Reservacion', 'instalacion/misReservaciones.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (42, 'Alquileres', 'instalacion/administrarAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (43, 'Mis alquileres', 'instalacion/misAlquileres.zul', 'z-icon-angle-double-right', ' ', 3, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (44, 'Eventualidades', 'instalacion/registrarEventualidadInst.zul', 'z-icon-angle-double-right', ' ', 2, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (45, 'Registrar eventos', 'evento/administrarEvento/listaEventos.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (46, 'Planificar evento', 'evento/administrarEvento/planificarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (47, 'Ejecutar evento', 'evento/administrarEvento/ejecutarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (48, 'Adjuntar empleados', 'administracion/adjuntarEmpleados.zul', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (49, 'Cartelera', 'administracion/cartelera.zul', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (50, 'Backup BD', ' ', 'z-icon-angle-double-right', ' ', 6, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (51, 'Usuarios', 'administracion/seguridad/usuarioGeneral.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (52, 'Grupos', 'administracion/seguridad/mostrarGrupos.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (53, 'Funciones', 'administracion/seguridad/administrarFunciones.zul', 'z-icon-angle-double-right', ' ', 15, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (54, 'Postulados', 'postulado/postulado.zul', 'z-icon-angle-double-right', ' ', 7, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (55, 'Administrar portal', 'configuracion/administracionPortal.zul', 'z-icon-angle-double-right', ' ', 1, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (56, 'Finalizar evento', 'evento/administrarEvento/finalizarEvento.zul', 'z-icon-angle-double-right', ' ', 11, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (57, 'Alquileres', 'consultas/reporteAlquileres.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (58, 'Eventos', 'consultas/reporteEventos.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (59, 'Actividades de Eventos', 'consultas/reporteActividadEventos.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (60, 'Socios', 'consultas/reporteSocios.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (61, 'Sanciones', 'consultas/reporteSanciones.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (62, 'Eventualidades', 'consultas/reporteEventualidad.zul', 'z-icon-angle-double-right', ' ', 12, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (63, 'Sanciones', 'consultas/reporteSancionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (64, 'Eventualidades', 'consultas/reporteEventualidadesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (65, 'Evento', 'consultas/reporteEventoValorEsperadoRealEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (66, 'Socio', 'consultas/reporteSociosEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (68, 'Instalaciones', 'consultas/reporteInstalacionesEst.zul', 'z-icon-angle-double-right', ' ', 14, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (69, 'Red Social', 'configuracion/categoria/redSocial.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (70, 'Tipo eventualidad', 'configuracion/categoria/tipoEventualidad.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (71, 'Indicador', 'configuracion/categoria/indicador.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (72, 'Tipo Opinion', 'configuracion/categoria/tipoOpinion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (73, 'Tipo Pago', 'configuracion/categoria/tipoPago.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (74, 'Tipo Noticia', 'configuracion/categoria/tipoNoticia.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (75, 'Motivo Cancelacion', 'configuracion/categoria/motivoCancelacion.zul', 'z-icon-angle-double-right', ' ', 8, true);
INSERT INTO funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) VALUES (76, 'Sugerencias', 'socio/buzon/sugerenciaAdministrativo.zul', 'z-icon-angle-double-right', ' ', 10, true);


--
-- TOC entry 2732 (class 0 OID 30843)
-- Dependencies: 179
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (1, 'Socio', true);
INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (3, 'Afiliado', true);
INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (4, 'Seguridad', true);
INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (5, 'Comunicador', true);
INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (6, 'Vigilancia', true);
INSERT INTO grupo (id_grupo, descripcion, activo) VALUES (2, 'Junta', true);


--
-- TOC entry 2760 (class 0 OID 30994)
-- Dependencies: 207
-- Data for Name: funcion_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (1, 33, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (2, 34, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (3, 35, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (4, 39, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (5, 40, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (6, 41, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (7, 43, 1, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (8, 51, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (9, 52, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (10, 53, 4, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (11, 33, 3, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (12, 34, 3, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (13, 49, 5, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (14, 55, 5, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (53, 44, 6, true);
--INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (29, 30, 2, false);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (16, 17, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (33, 37, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (18, 19, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (45, 58, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (61, 76, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (30, 31, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (47, 60, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (35, 42, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (37, 46, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (52, 65, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (44, 57, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (51, 64, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (48, 61, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (55, 70, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (17, 18, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (50, 63, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (39, 48, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (58, 73, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (38, 47, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (25, 26, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (36, 45, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (49, 62, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (23, 24, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (24, 25, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (54, 68, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (60, 75, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (27, 28, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (59, 74, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (34, 38, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (28, 29, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (43, 66, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (40, 50, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (26, 27, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (57, 72, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (19, 20, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (20, 21, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (46, 59, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (31, 32, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (15, 16, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (56, 71, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (21, 22, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (22, 23, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (32, 36, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (42, 56, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (41, 54, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (62, 69, 2, true);
INSERT INTO funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) VALUES (63, 13, 2, true);

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 206
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_grupo_id_funcion_grupo_seq', 61, true);


--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 204
-- Name: funcion_id_funcion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_id_funcion_seq', 1, false);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 178
-- Name: grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('grupo_id_grupo_seq', 6, true);


--
-- TOC entry 2826 (class 0 OID 31303)
-- Dependencies: 273
-- Data for Name: indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO indicador (id_indicador, descripcion, activo) VALUES (1, 'Asistencia de Personas', true);
INSERT INTO indicador (id_indicador, descripcion, activo) VALUES (2, 'Ingresos Recolectados', true);
INSERT INTO indicador (id_indicador, descripcion, activo) VALUES (3, 'Utilidad', true);
INSERT INTO indicador (id_indicador, descripcion, activo) VALUES (4, 'Ingresos por Incripcion a Torneos', true);
INSERT INTO indicador (id_indicador, descripcion, activo) VALUES (5, 'Ingresos por Bebidas alcoholicas', true);


--
-- TOC entry 2828 (class 0 OID 31312)
-- Dependencies: 275
-- Data for Name: indicador_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO indicador_evento (id_indicador_evento, valor_esperado, valor_real, indicadorid_indicador, eventoid_evento, activo) VALUES (2, 20000, NULL, 4, 3, true);
INSERT INTO indicador_evento (id_indicador_evento, valor_esperado, valor_real, indicadorid_indicador, eventoid_evento, activo) VALUES (1, 100, 400, 1, 2, true);
INSERT INTO indicador_evento (id_indicador_evento, valor_esperado, valor_real, indicadorid_indicador, eventoid_evento, activo) VALUES (4, 100, 80, 3, 4, true);
INSERT INTO indicador_evento (id_indicador_evento, valor_esperado, valor_real, indicadorid_indicador, eventoid_evento, activo) VALUES (3, 25, 10, 1, 4, true);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 274
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_evento_id_indicador_evento_seq', 1, false);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 272
-- Name: indicador_id_indicador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_id_indicador_seq', 5, true);


--
-- TOC entry 2778 (class 0 OID 31078)
-- Dependencies: 225
-- Data for Name: instalacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO instalacion_evento (id_actividad_instalacion, instalacionid_instalacion, eventoid_evento, activo) VALUES (1, 1, 3, true);
INSERT INTO instalacion_evento (id_actividad_instalacion, instalacionid_instalacion, eventoid_evento, activo) VALUES (2, 1, 4, true);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 224
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_evento_id_actividad_instalacion_seq', 1, false);


--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 194
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_id_instalacion_seq', 3, true);


--
-- TOC entry 2790 (class 0 OID 31135)
-- Dependencies: 237
-- Data for Name: junta_directiva; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 236
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('junta_directiva_id_junta_directiva_seq', 1, false);


--
-- TOC entry 2792 (class 0 OID 31144)
-- Dependencies: 239
-- Data for Name: miembro_junta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 238
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('miembro_junta_id_junta_miembro_seq', 1, false);


--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 296
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_cancelacion_id_motivo_cancelacion_seq', 1, false);


--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 248
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_desvinculacion_id_motivo_desvinculacion_seq', 1, false);


--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 262
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_postulacion_id_motivo_postulacion_seq', 1, false);


--
-- TOC entry 2852 (class 0 OID 31424)
-- Dependencies: 299
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_sancion (id_motivo_sancion, descripcion, activo) VALUES (1, 'Actos', true);


--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 298
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_sancion_id_motivo_sancion_seq', 1, false);


--
-- TOC entry 2818 (class 0 OID 31267)
-- Dependencies: 265
-- Data for Name: motivo_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO motivo_venta (id_motivo_venta, descripcion, activo) VALUES (1, 'Necesidad Economica', true);
INSERT INTO motivo_venta (id_motivo_venta, descripcion, activo) VALUES (2, 'Cambio de Ciudad', true);
INSERT INTO motivo_venta (id_motivo_venta, descripcion, activo) VALUES (3, 'Descontento con el Club', true);


--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 264
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_venta_id_motivo_venta_seq', 3, true);


--
-- TOC entry 2840 (class 0 OID 31369)
-- Dependencies: 287
-- Data for Name: tipo_noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_noticia (id_tipo_noticia, descripcion, color, activo) VALUES (1, 'Evento', '#3300cc', false);
INSERT INTO tipo_noticia (id_tipo_noticia, descripcion, color, activo) VALUES (2, 'Acciones', '#FFFF00', true);
INSERT INTO tipo_noticia (id_tipo_noticia, descripcion, color, activo) VALUES (3, 'Sucesos', '#cc00ff', true);
INSERT INTO tipo_noticia (id_tipo_noticia, descripcion, color, activo) VALUES (4, 'Otros', '#FFA500', true);
INSERT INTO tipo_noticia (id_tipo_noticia, descripcion, color, activo) VALUES (5, 'Postulación', '#f88514', false);


--
-- TOC entry 2750 (class 0 OID 30937)
-- Dependencies: 197
-- Data for Name: noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (1, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (2, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (3, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (4, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-17', '2016-03-17', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (5, 'Nueva Postulación', 'El Sr(a). Fidel Aliaga, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 'http://i.imgur.com/mSJl1BZ.jpg', 5, '2016-03-17', '2016-03-17', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (6, ' Prepárate para el 89 aniversario del Centro Atlético América', 'En su semana aniversario, la junta directiva, encabezada por el Dr. Víctor Montilla, se complace en invitar a todos los consocios y comunidad larense a disfrutar y compartir del programa de actividades designado.', NULL, 'http://i.imgur.com/JNy9o9V.png', 4, '2016-03-18', '2016-03-20', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (7, 'Jornadas Infociencias XXXII', 'La 32 edición de las Jornadas de Infociencias de la Universidad Centroccidental Lisandro Alvarado, se realizará el día 6 de Abril del presente año en las instalaciones del Decanato de Ciencias y Tecnología, núcleo Obelisco, donde se darán a conocer cuatro proyectos informáticos creados por los estudiantes de Ingeniería en Informática', NULL, 'http://i.imgur.com/JNy9o9V.png', 3, '2016-03-18', '2016-03-20', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (8, 'Nueva Postulación', 'El Sr(a). Ruben Vivas, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!', NULL, 'http://i.imgur.com/ycCM1PJ.jpg', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (9, 'Torneo de Beisbol', 'Disfruta del Torneo de Beisbol', NULL, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-18', '2016-03-19', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (10, 'Evento Hilder', 'Este un evento con la noticia corregida', 3, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-25', '2016-04-01', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (11, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (12, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (13, 'Nueva Postulación', 'El Sr(a). Mariangel Arrieche, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secciÃ³n de opiniones postulantes!', NULL, 'http://i.imgur.com/8t2CuRs.png', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (14, 'Nueva Postulación', 'El Sr(a). Romulo Dominguez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra secciÃ³n de opiniones postulantes!', NULL, 'http://i.imgur.com/duCXybQ.jpg', 5, '2016-03-18', '2016-03-18', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (15, 'Parrilla Osullivan', 'Evento para quitar la presión de los desarrolladores del Club América', 4, 'localhost:8080/america/assets/img/default-placeholder.png', 1, '2016-03-20', '2016-03-21', false, NULL, true);
INSERT INTO noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) VALUES (16, 'Acción en Venta', '¡Se a aperturado el proceso de postulación para una acción en venta!', NULL, NULL, 2, '2016-03-18', '2016-03-18', true, NULL, true);


--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 196
-- Name: noticia_id_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_id_noticia_seq', 7, true);


--
-- TOC entry 2798 (class 0 OID 31171)
-- Dependencies: 245
-- Data for Name: tipo_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_preferencia (id_tipo_preferencia, descripcion, color, activo) VALUES (1, 'Deportiva', '#0099cc', true);
INSERT INTO tipo_preferencia (id_tipo_preferencia, descripcion, color, activo) VALUES (2, 'Cultural', '#cc33cc', true);
INSERT INTO tipo_preferencia (id_tipo_preferencia, descripcion, color, activo) VALUES (3, 'Social', '#009966', true);


--
-- TOC entry 2768 (class 0 OID 31030)
-- Dependencies: 215
-- Data for Name: preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (1, 'Beisbol', 1, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (2, 'Tenis', 1, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (3, 'Futbol', 1, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (4, 'Baloncesto', 1, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (5, 'Danza', 2, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (6, 'Canto', 2, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (7, 'Musica', 2, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (8, 'ProtecciÃ³n Animal', 3, true);
INSERT INTO preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) VALUES (9, 'Ambiente', 3, true);


--
-- TOC entry 2800 (class 0 OID 31180)
-- Dependencies: 247
-- Data for Name: noticia_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 246
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_preferencia_id_noticia_preferencia_seq', 1, false);


--
-- TOC entry 2846 (class 0 OID 31398)
-- Dependencies: 293
-- Data for Name: tipo_opnion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_opnion (id_tipo_opninion, descripcion, activo) VALUES (1, 'Lo Recomiendo', true);
INSERT INTO tipo_opnion (id_tipo_opninion, descripcion, activo) VALUES (2, 'No lo recomiendo', true);
INSERT INTO tipo_opnion (id_tipo_opninion, descripcion, activo) VALUES (3, 'No lo conozco', true);


--
-- TOC entry 2726 (class 0 OID 30813)
-- Dependencies: 173
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (1, '12345678', 'enmanuel', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 1, '2016-02-22', true);
INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (2, '12345678', 'carlos', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 2, '2016-02-22', true);
INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (3, '12345678', 'juan', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 3, '2016-02-22', true);
INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (5, '12345678', 'sergio', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 5, '2016-02-22', true);
INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (6, '12345678', 'pedro', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 6, '2016-02-22', true);
INSERT INTO usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) VALUES (4, '12345678', 'manuel', 'Ã‚Â¿Quien?', 'Capitan garfio en la cocina', 4, '2016-02-22', true);


--
-- TOC entry 2744 (class 0 OID 30900)
-- Dependencies: 191
-- Data for Name: opinion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) VALUES (1, 1, 'Es Confiable', 4, '2016-03-18 00:04:46.067', 3, 1, true);
INSERT INTO opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) VALUES (2, 1, 'Es borracho', 2, '2016-03-18 00:10:48.24', 1, 2, true);
INSERT INTO opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) VALUES (3, 2, 'Es honesto', 4, '2016-03-18 06:54:36.078', 4, 1, true);
INSERT INTO opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) VALUES (4, 3, 'Tiene malas juntas', 4, '2016-03-18 10:41:48.263', 1, 2, true);
INSERT INTO opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) VALUES (5, 4, 'Es amistoso', 4, '2016-03-18 11:53:47.078', 4, 1, true);


--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 190
-- Name: opinion_id_opinion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('opinion_id_opinion_seq', 1, false);


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 180
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('persona_id_persona_seq', 6, true);


--
-- TOC entry 2788 (class 0 OID 31126)
-- Dependencies: 235
-- Data for Name: politica; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO politica (id_politica, descripcion, valor, clubid_club, activo) VALUES (1, 'Personas que puede traer un socio por visita diaria', 3, 1, true);
INSERT INTO politica (id_politica, descripcion, valor, clubid_club, activo) VALUES (2, 'Veces que puede traer a un mismo invitado al mes', 3, 1, true);


--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 234
-- Name: politica_id_politica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('politica_id_politica_seq', 1, false);


--
-- TOC entry 2842 (class 0 OID 31378)
-- Dependencies: 289
-- Data for Name: portal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO portal (id_portal, instalacion, socio, evento, activo, foto_socio, foto_instalaciones, foto_evento) VALUES (1, 'El Centro Atlético America cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Además cuenta con un Salón de Fiestas y dos Caneis para el disfrute de sus socios e invitados', 'Nuestros Socios se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de club. ¿Quieres ser un socio del Centro Atlético America?', 'Nos interesa Motivar la interacción social a través de actividades culturales de intercambio en busca del crecimiento humano mediante la realización de eventos. ¿Quieres participar en nuestros eventos?', true, 'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 288
-- Name: portal_id_portal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('portal_id_portal_seq', 1, false);


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 188
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulacion_id_postulacion_seq', 1, false);


--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 216
-- Name: postulado_id_postulado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulado_id_postulado_seq', 1, false);


--
-- TOC entry 2808 (class 0 OID 31219)
-- Dependencies: 255
-- Data for Name: preferencia_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia_evento (id_preferencia_evento, eventoid_evento, preferenciaid_preferencia, activo) VALUES (1, 3, 1, true);
INSERT INTO preferencia_evento (id_preferencia_evento, eventoid_evento, preferenciaid_preferencia, activo) VALUES (2, 4, 1, true);


--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 254
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_evento_id_preferencia_evento_seq', 1, false);


--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 214
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_id_preferencia_seq', 1, false);


--
-- TOC entry 2776 (class 0 OID 31069)
-- Dependencies: 223
-- Data for Name: preferencia_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (1, 1, 7, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (3, 3, 7, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (2, 8, 7, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (6, 8, 8, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (7, 2, 8, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (10, 2, 9, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (9, 6, 9, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (8, 5, 9, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (11, 7, 10, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (12, 3, 10, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (14, 3, 11, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (13, 1, 11, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (15, 7, 11, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (16, 6, 11, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (17, 7, 12, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (18, 1, 12, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (19, 6, 15, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (4, 5, 4, true);
INSERT INTO preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) VALUES (5, 8, 4, true);


--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 222
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_persona_id_preferencia_persona_seq', 1, false);


--
-- TOC entry 2780 (class 0 OID 31087)
-- Dependencies: 227
-- Data for Name: recurso; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (1, 'Silla', true);
INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (2, 'Mesa', true);
INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (3, 'Parrillera', true);
INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (4, 'Vasos', true);
INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (5, 'Cubiertos', true);
INSERT INTO recurso (id_recurso, descripcion, activo) VALUES (6, 'Lamparas', true);


--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 226
-- Name: recurso_id_recurso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_id_recurso_seq', 1, false);


--
-- TOC entry 2784 (class 0 OID 31108)
-- Dependencies: 231
-- Data for Name: recurso_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 230
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_instalacion_id_recurso_instalacion_seq', 1, false);


--
-- TOC entry 2810 (class 0 OID 31228)
-- Dependencies: 257
-- Data for Name: red_social; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2812 (class 0 OID 31240)
-- Dependencies: 259
-- Data for Name: red_club; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 258
-- Name: red_club_id_red_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_club_id_red_club_seq', 1, false);


--
-- TOC entry 2814 (class 0 OID 31249)
-- Dependencies: 261
-- Data for Name: red_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 260
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_persona_id_red_persona_seq', 1, false);


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 256
-- Name: red_social_id_red_social_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_social_id_red_social_seq', 1, false);


--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reservacion_id_reservacion_seq', 1, false);


--
-- TOC entry 2848 (class 0 OID 31407)
-- Dependencies: 295
-- Data for Name: tipo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_sancion (id_tipo_sancion, descripcion, activo) VALUES (1, 'Morosidad', true);
INSERT INTO tipo_sancion (id_tipo_sancion, descripcion, activo) VALUES (2, 'Eventualidad', true);


--
-- TOC entry 2736 (class 0 OID 30864)
-- Dependencies: 183
-- Data for Name: sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sancion (id_sancion, descripcion, socioid_socio, afiliadoid_afilado, fecha_inic, fecha_fin, monto, eventualidadid_eventualidad, motivo_sancionid_motivo_sancion, tipo_sancionid_tipo_sancion, activo) VALUES (1, 'Debe 3 cuotas', 8, NULL, NULL, NULL, 10000, NULL, NULL, 1, true);
INSERT INTO sancion (id_sancion, descripcion, socioid_socio, afiliadoid_afilado, fecha_inic, fecha_fin, monto, eventualidadid_eventualidad, motivo_sancionid_motivo_sancion, tipo_sancionid_tipo_sancion, activo) VALUES (2, 'Debe 5 cuaotas', 3, NULL, '2016-03-18', '2016-03-21', NULL, NULL, NULL, 1, true);
INSERT INTO sancion (id_sancion, descripcion, socioid_socio, afiliadoid_afilado, fecha_inic, fecha_fin, monto, eventualidadid_eventualidad, motivo_sancionid_motivo_sancion, tipo_sancionid_tipo_sancion, activo) VALUES (3, 'Debe cuotas', 4, NULL, '2016-03-18', '2016-03-21', NULL, NULL, NULL, 1, true);
INSERT INTO sancion (id_sancion, descripcion, socioid_socio, afiliadoid_afilado, fecha_inic, fecha_fin, monto, eventualidadid_eventualidad, motivo_sancionid_motivo_sancion, tipo_sancionid_tipo_sancion, activo) VALUES (4, 'Suspendido por cuotas', 10, NULL, '2016-03-18', '2016-03-21', NULL, NULL, NULL, 1, true);


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 182
-- Name: sancion_id_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sancion_id_sancion_seq', 1, false);


--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 184
-- Name: socio_id_socio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('socio_id_socio_seq', 6, true);


--
-- TOC entry 2830 (class 0 OID 31321)
-- Dependencies: 277
-- Data for Name: solicitud_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 276
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('solicitud_venta_id_solicitud_venta_seq', 1, false);


--
-- TOC entry 2796 (class 0 OID 31162)
-- Dependencies: 243
-- Data for Name: tipo_sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) VALUES (1, 'Pregunta', true);
INSERT INTO tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) VALUES (2, 'Sugerencia', true);
INSERT INTO tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) VALUES (3, 'Comentario', true);
INSERT INTO tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) VALUES (4, 'Queja', true);
INSERT INTO tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) VALUES (5, 'Reclamo', true);


--
-- TOC entry 2782 (class 0 OID 31096)
-- Dependencies: 229
-- Data for Name: sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sugerencia (id_sugerencia, descripcion, fecha, usuarioid_usuario, cliente_externoid_cliente, tipo_sugerenciaid_tipo_sugerencia, activo) VALUES (1, 'Â¿CuÃ¡ndo seran las postulaciones?', '2016-03-18 00:24:56.258', NULL, 1, 1, true);
INSERT INTO sugerencia (id_sugerencia, descripcion, fecha, usuarioid_usuario, cliente_externoid_cliente, tipo_sugerenciaid_tipo_sugerencia, activo) VALUES (2, 'Deberian de habilitar las postulaciones', '2016-03-18 10:14:12.87', NULL, 2, 2, true);


--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 228
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sugerencia_id_sugerencia_seq', 1, false);


--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 252
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_afiliado_id_tipo_afiliado_seq', 1, false);




--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 278
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_eventualidad_id_tipo_eventualidad_seq', 1, false);


--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 300
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_instalacion_id_tipo_instalacion_seq', 3, true);


--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 286
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_noticia_id_tipo_noticia_seq', 4, true);


--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 292
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_opnion_id_tipo_opninion_seq', 1, false);


--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 290
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_pago_id_tipo_pago_seq', 1, false);


--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 244
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_preferencia_id_tipo_preferencia_seq', 1, false);


--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 294
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sancion_id_tipo_sancion_seq', 1, false);


--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 242
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sugerencia_id_tipo_sugerencia_seq', 1, false);


--
-- TOC entry 2730 (class 0 OID 30834)
-- Dependencies: 177
-- Data for Name: usuario_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (2, 1, 6, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (4, 1, 5, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (5, 1, 4, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (6, 1, 2, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (7, 1, 3, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (3, 2, 1, true);
INSERT INTO usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) VALUES (1, 4, 1, true);


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 176
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_grupo_id_usuario_grupo_seq', 7, true);


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 6, true);


--
-- TOC entry 2774 (class 0 OID 31060)
-- Dependencies: 221
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 220
-- Name: venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('venta_id_venta_seq', 1, false);


-- Completed on 2016-03-19 10:18:52

--
-- PostgreSQL database dump complete
--

