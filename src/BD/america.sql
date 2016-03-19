--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.4
-- Dumped by pg_dump version 9.4.4
-- Started on 2016-03-19 10:08:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 302 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 302
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 30882)
-- Name: accion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE accion (
    id_accion integer NOT NULL,
    nro_accion character varying(50) NOT NULL,
    valor real NOT NULL,
    socioid_socio smallint,
    estado_accionid_estado_accion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE accion OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 30880)
-- Name: accion_id_accion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE accion_id_accion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE accion_id_accion_seq OWNER TO postgres;

--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 186
-- Name: accion_id_accion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE accion_id_accion_seq OWNED BY accion.id_accion;


--
-- TOC entry 203 (class 1259 OID 30973)
-- Name: actividad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE actividad (
    id_actividad integer NOT NULL,
    descripcion character varying(150) NOT NULL,
    eventoid_evento smallint NOT NULL,
    fecha_tope timestamp without time zone,
    fecha_realizacion timestamp without time zone,
    valor_esperado integer,
    valor_real integer,
    finalizada boolean NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE actividad OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 30971)
-- Name: actividad_id_actividad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE actividad_id_actividad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE actividad_id_actividad_seq OWNER TO postgres;

--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 202
-- Name: actividad_id_actividad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE actividad_id_actividad_seq OWNED BY actividad.id_actividad;


--
-- TOC entry 211 (class 1259 OID 31012)
-- Name: afiliado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE afiliado (
    id_afilado integer NOT NULL,
    tipo_afiliadoid_tipo_afiliado smallint NOT NULL,
    socioid_socio smallint NOT NULL,
    nro_carnet character varying(40) NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE afiliado OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 31010)
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE afiliado_id_afilado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE afiliado_id_afilado_seq OWNER TO postgres;

--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 210
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE afiliado_id_afilado_seq OWNED BY afiliado.id_afilado;


--
-- TOC entry 233 (class 1259 OID 31117)
-- Name: alquiler; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE alquiler (
    id_alquiler integer NOT NULL,
    reservacionid_reservacion smallint NOT NULL,
    tipo_pagoid_tipo_pago smallint NOT NULL,
    fecha date NOT NULL,
    monto real NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE alquiler OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 31115)
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE alquiler_id_alquiler_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE alquiler_id_alquiler_seq OWNER TO postgres;

--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 232
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE alquiler_id_alquiler_seq OWNED BY alquiler.id_alquiler;


--
-- TOC entry 267 (class 1259 OID 31276)
-- Name: archivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE archivo (
    id_archivo integer NOT NULL,
    url character varying(255) NOT NULL,
    nombre character varying(120) NOT NULL,
    extension character varying(50) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE archivo OWNER TO postgres;

--
-- TOC entry 283 (class 1259 OID 31351)
-- Name: archivo_alquiler; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE archivo_alquiler (
    id_archivo_alquiler integer NOT NULL,
    archivoid_archivo smallint NOT NULL,
    alquilerid_alquiler smallint NOT NULL,
    tipo_archivoid_tipo_archivo smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE archivo_alquiler OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 31349)
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE archivo_alquiler_id_archivo_alquiler_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE archivo_alquiler_id_archivo_alquiler_seq OWNER TO postgres;

--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 282
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE archivo_alquiler_id_archivo_alquiler_seq OWNED BY archivo_alquiler.id_archivo_alquiler;


--
-- TOC entry 266 (class 1259 OID 31274)
-- Name: archivo_id_archivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE archivo_id_archivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE archivo_id_archivo_seq OWNER TO postgres;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 266
-- Name: archivo_id_archivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE archivo_id_archivo_seq OWNED BY archivo.id_archivo;


--
-- TOC entry 199 (class 1259 OID 30949)
-- Name: calendario_fecha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE calendario_fecha (
    id_calendario_fecha integer NOT NULL,
    descripcion text NOT NULL,
    fecha date NOT NULL,
    eventoid_evento smallint,
    reservacionid_reservacion smallint,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE calendario_fecha OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 30947)
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE calendario_fecha_id_calendario_fecha_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE calendario_fecha_id_calendario_fecha_seq OWNER TO postgres;

--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 198
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE calendario_fecha_id_calendario_fecha_seq OWNED BY calendario_fecha.id_calendario_fecha;


--
-- TOC entry 271 (class 1259 OID 31294)
-- Name: cancelacion_evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cancelacion_evento (
    id_cancelacion_evento integer NOT NULL,
    descipcion character varying(255) NOT NULL,
    motivo_cancelacionid_motivo_cancelacion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE cancelacion_evento OWNER TO postgres;

--
-- TOC entry 270 (class 1259 OID 31292)
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cancelacion_evento_id_cancelacion_evento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cancelacion_evento_id_cancelacion_evento_seq OWNER TO postgres;

--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 270
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cancelacion_evento_id_cancelacion_evento_seq OWNED BY cancelacion_evento.id_cancelacion_evento;


--
-- TOC entry 241 (class 1259 OID 31153)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cargo (
    id_cargo integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE cargo OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 31151)
-- Name: cargo_id_cargo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cargo_id_cargo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cargo_id_cargo_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 240
-- Name: cargo_id_cargo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cargo_id_cargo_seq OWNED BY cargo.id_cargo;


--
-- TOC entry 213 (class 1259 OID 31021)
-- Name: cliente_externo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente_externo (
    id_cliente integer NOT NULL,
    nombre character varying(60) NOT NULL,
    apellido character varying(60) NOT NULL,
    correo character varying(80) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE cliente_externo OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 31019)
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_externo_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cliente_externo_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 212
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_externo_id_cliente_seq OWNED BY cliente_externo.id_cliente;


--
-- TOC entry 175 (class 1259 OID 30822)
-- Name: club; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE club (
    id_club integer NOT NULL,
    rif character varying(40) NOT NULL,
    nombre character varying(60) NOT NULL,
    direccion character varying(250) NOT NULL,
    telefono character varying(20) NOT NULL,
    mision text NOT NULL,
    vision text NOT NULL,
    logo text,
    telf_alternativo character varying(20) NOT NULL,
    correo character varying(90) NOT NULL,
    clave_correo text,
    eslogan text,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE club OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 30820)
-- Name: club_id_club_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE club_id_club_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE club_id_club_seq OWNER TO postgres;

--
-- TOC entry 2873 (class 0 OID 0)
-- Dependencies: 174
-- Name: club_id_club_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE club_id_club_seq OWNED BY club.id_club;


--
-- TOC entry 219 (class 1259 OID 31048)
-- Name: desvinculacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE desvinculacion (
    id_desvinculacion integer NOT NULL,
    accionid_accion smallint NOT NULL,
    socioid_socio smallint NOT NULL,
    fecha date NOT NULL,
    motivo text,
    motivo_desvinculacionid_motivo_desvinculacion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE desvinculacion OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 31046)
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE desvinculacion_id_desvinculacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE desvinculacion_id_desvinculacion_seq OWNER TO postgres;

--
-- TOC entry 2874 (class 0 OID 0)
-- Dependencies: 218
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE desvinculacion_id_desvinculacion_seq OWNED BY desvinculacion.id_desvinculacion;


--
-- TOC entry 281 (class 1259 OID 31342)
-- Name: estado_accion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estado_accion (
    id_estado_accion integer NOT NULL,
    nombre character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE estado_accion OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 31340)
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE estado_accion_id_estado_accion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estado_accion_id_estado_accion_seq OWNER TO postgres;

--
-- TOC entry 2875 (class 0 OID 0)
-- Dependencies: 280
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estado_accion_id_estado_accion_seq OWNED BY estado_accion.id_estado_accion;


--
-- TOC entry 269 (class 1259 OID 31285)
-- Name: estado_evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estado_evento (
    id_estado_evento integer NOT NULL,
    nombre character varying(40) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE estado_evento OWNER TO postgres;

--
-- TOC entry 268 (class 1259 OID 31283)
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE estado_evento_id_estado_evento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estado_evento_id_estado_evento_seq OWNER TO postgres;

--
-- TOC entry 2876 (class 0 OID 0)
-- Dependencies: 268
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE estado_evento_id_estado_evento_seq OWNED BY estado_evento.id_estado_evento;


--
-- TOC entry 201 (class 1259 OID 30961)
-- Name: evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE evento (
    id_evento integer NOT NULL,
    nombre character varying(200) NOT NULL,
    descripcion text NOT NULL,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    publico boolean NOT NULL,
    estado_eventoid_estado_evento smallint NOT NULL,
    cancelacion_eventoid_cancelacion_evento smallint,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE evento OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 30959)
-- Name: evento_id_evento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE evento_id_evento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento_id_evento_seq OWNER TO postgres;

--
-- TOC entry 2877 (class 0 OID 0)
-- Dependencies: 200
-- Name: evento_id_evento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE evento_id_evento_seq OWNED BY evento.id_evento;


--
-- TOC entry 193 (class 1259 OID 30912)
-- Name: eventualidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE eventualidad (
    id_eventualidad integer NOT NULL,
    instalacionid_instalacion smallint,
    descripcion text NOT NULL,
    fecha timestamp without time zone NOT NULL,
    personaid_persona smallint NOT NULL,
    tipo_eventualidadid_tipo_eventualidad smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE eventualidad OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 30910)
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE eventualidad_id_eventualidad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE eventualidad_id_eventualidad_seq OWNER TO postgres;

--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 192
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE eventualidad_id_eventualidad_seq OWNED BY eventualidad.id_eventualidad;


--
-- TOC entry 251 (class 1259 OID 31198)
-- Name: foto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE foto (
    id_foto integer NOT NULL,
    url character varying(255) NOT NULL,
    instalacionid_instalacion smallint,
    publico boolean NOT NULL,
    clubid_club smallint,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE foto OWNER TO postgres;

--
-- TOC entry 250 (class 1259 OID 31196)
-- Name: foto_id_foto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE foto_id_foto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE foto_id_foto_seq OWNER TO postgres;

--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 250
-- Name: foto_id_foto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE foto_id_foto_seq OWNED BY foto.id_foto;


--
-- TOC entry 205 (class 1259 OID 30982)
-- Name: funcion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE funcion (
    id_funcion integer NOT NULL,
    nombre character varying(100) NOT NULL,
    pagina character varying(255) NOT NULL,
    icon_uri character varying(255) NOT NULL,
    clase character varying(120) NOT NULL,
    padreid_funcion integer,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE funcion OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 30994)
-- Name: funcion_grupo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE funcion_grupo (
    id_funcion_grupo integer NOT NULL,
    funcionid_funcion smallint NOT NULL,
    grupoid_grupo smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE funcion_grupo OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 30992)
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE funcion_grupo_id_funcion_grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE funcion_grupo_id_funcion_grupo_seq OWNER TO postgres;

--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 206
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE funcion_grupo_id_funcion_grupo_seq OWNED BY funcion_grupo.id_funcion_grupo;


--
-- TOC entry 204 (class 1259 OID 30980)
-- Name: funcion_id_funcion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE funcion_id_funcion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE funcion_id_funcion_seq OWNER TO postgres;

--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 204
-- Name: funcion_id_funcion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE funcion_id_funcion_seq OWNED BY funcion.id_funcion;


--
-- TOC entry 179 (class 1259 OID 30843)
-- Name: grupo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE grupo (
    id_grupo integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE grupo OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 30841)
-- Name: grupo_id_grupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE grupo_id_grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE grupo_id_grupo_seq OWNER TO postgres;

--
-- TOC entry 2882 (class 0 OID 0)
-- Dependencies: 178
-- Name: grupo_id_grupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE grupo_id_grupo_seq OWNED BY grupo.id_grupo;


--
-- TOC entry 273 (class 1259 OID 31303)
-- Name: indicador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador (
    id_indicador integer NOT NULL,
    descripcion character varying(150) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE indicador OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 31312)
-- Name: indicador_evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE indicador_evento (
    id_indicador_evento integer NOT NULL,
    valor_esperado integer NOT NULL,
    valor_real integer,
    indicadorid_indicador smallint NOT NULL,
    eventoid_evento smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE indicador_evento OWNER TO postgres;

--
-- TOC entry 274 (class 1259 OID 31310)
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_evento_id_indicador_evento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE indicador_evento_id_indicador_evento_seq OWNER TO postgres;

--
-- TOC entry 2883 (class 0 OID 0)
-- Dependencies: 274
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_evento_id_indicador_evento_seq OWNED BY indicador_evento.id_indicador_evento;


--
-- TOC entry 272 (class 1259 OID 31301)
-- Name: indicador_id_indicador_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE indicador_id_indicador_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE indicador_id_indicador_seq OWNER TO postgres;

--
-- TOC entry 2884 (class 0 OID 0)
-- Dependencies: 272
-- Name: indicador_id_indicador_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE indicador_id_indicador_seq OWNED BY indicador.id_indicador;


--
-- TOC entry 195 (class 1259 OID 30924)
-- Name: instalacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE instalacion (
    id_instalacion integer NOT NULL,
    nombre character varying(180) NOT NULL,
    descripcion text NOT NULL,
    capacidad smallint NOT NULL,
    precio_alquiler real NOT NULL,
    alquilable boolean DEFAULT true NOT NULL,
    tipo_instalacionid_tipo_instalacion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE instalacion OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 31078)
-- Name: instalacion_evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE instalacion_evento (
    id_actividad_instalacion integer NOT NULL,
    instalacionid_instalacion smallint NOT NULL,
    eventoid_evento smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE instalacion_evento OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 31076)
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE instalacion_evento_id_actividad_instalacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE instalacion_evento_id_actividad_instalacion_seq OWNER TO postgres;

--
-- TOC entry 2885 (class 0 OID 0)
-- Dependencies: 224
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE instalacion_evento_id_actividad_instalacion_seq OWNED BY instalacion_evento.id_actividad_instalacion;


--
-- TOC entry 194 (class 1259 OID 30922)
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE instalacion_id_instalacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE instalacion_id_instalacion_seq OWNER TO postgres;

--
-- TOC entry 2886 (class 0 OID 0)
-- Dependencies: 194
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE instalacion_id_instalacion_seq OWNED BY instalacion.id_instalacion;


--
-- TOC entry 237 (class 1259 OID 31135)
-- Name: junta_directiva; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE junta_directiva (
    id_junta_directiva integer NOT NULL,
    clubid_club smallint NOT NULL,
    fecha_inic date NOT NULL,
    fecha_fin date NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE junta_directiva OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 31133)
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE junta_directiva_id_junta_directiva_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE junta_directiva_id_junta_directiva_seq OWNER TO postgres;

--
-- TOC entry 2887 (class 0 OID 0)
-- Dependencies: 236
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE junta_directiva_id_junta_directiva_seq OWNED BY junta_directiva.id_junta_directiva;


--
-- TOC entry 239 (class 1259 OID 31144)
-- Name: miembro_junta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE miembro_junta (
    id_junta_miembro integer NOT NULL,
    junta_directivaid_junta_directiva smallint NOT NULL,
    cargoid_cargo smallint NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE miembro_junta OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 31142)
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE miembro_junta_id_junta_miembro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE miembro_junta_id_junta_miembro_seq OWNER TO postgres;

--
-- TOC entry 2888 (class 0 OID 0)
-- Dependencies: 238
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE miembro_junta_id_junta_miembro_seq OWNED BY miembro_junta.id_junta_miembro;


--
-- TOC entry 297 (class 1259 OID 31416)
-- Name: motivo_cancelacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_cancelacion (
    id_motivo_cancelacion integer NOT NULL,
    descripcion character varying(150) NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE motivo_cancelacion OWNER TO postgres;

--
-- TOC entry 296 (class 1259 OID 31414)
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE motivo_cancelacion_id_motivo_cancelacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE motivo_cancelacion_id_motivo_cancelacion_seq OWNER TO postgres;

--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 296
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE motivo_cancelacion_id_motivo_cancelacion_seq OWNED BY motivo_cancelacion.id_motivo_cancelacion;


--
-- TOC entry 249 (class 1259 OID 31189)
-- Name: motivo_desvinculacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_desvinculacion (
    id_motivo_desvinculacion integer NOT NULL,
    descripcion character varying(200) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE motivo_desvinculacion OWNER TO postgres;

--
-- TOC entry 248 (class 1259 OID 31187)
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE motivo_desvinculacion_id_motivo_desvinculacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE motivo_desvinculacion_id_motivo_desvinculacion_seq OWNER TO postgres;

--
-- TOC entry 2890 (class 0 OID 0)
-- Dependencies: 248
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE motivo_desvinculacion_id_motivo_desvinculacion_seq OWNED BY motivo_desvinculacion.id_motivo_desvinculacion;


--
-- TOC entry 263 (class 1259 OID 31258)
-- Name: motivo_postulacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_postulacion (
    id_motivo_postulacion integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE motivo_postulacion OWNER TO postgres;

--
-- TOC entry 262 (class 1259 OID 31256)
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE motivo_postulacion_id_motivo_postulacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE motivo_postulacion_id_motivo_postulacion_seq OWNER TO postgres;

--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 262
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE motivo_postulacion_id_motivo_postulacion_seq OWNED BY motivo_postulacion.id_motivo_postulacion;


--
-- TOC entry 299 (class 1259 OID 31424)
-- Name: motivo_sancion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_sancion (
    id_motivo_sancion integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE motivo_sancion OWNER TO postgres;

--
-- TOC entry 298 (class 1259 OID 31422)
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE motivo_sancion_id_motivo_sancion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE motivo_sancion_id_motivo_sancion_seq OWNER TO postgres;

--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 298
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE motivo_sancion_id_motivo_sancion_seq OWNED BY motivo_sancion.id_motivo_sancion;


--
-- TOC entry 265 (class 1259 OID 31267)
-- Name: motivo_venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE motivo_venta (
    id_motivo_venta integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE motivo_venta OWNER TO postgres;

--
-- TOC entry 264 (class 1259 OID 31265)
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE motivo_venta_id_motivo_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE motivo_venta_id_motivo_venta_seq OWNER TO postgres;

--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 264
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE motivo_venta_id_motivo_venta_seq OWNED BY motivo_venta.id_motivo_venta;


--
-- TOC entry 197 (class 1259 OID 30937)
-- Name: noticia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE noticia (
    id_noticia integer NOT NULL,
    titulo character varying(90),
    descripcion text NOT NULL,
    eventoid_evento smallint,
    foto text,
    tipo_noticiaid_tipo_noticia smallint,
    fecha_creacion date NOT NULL,
    caducidad date NOT NULL,
    publico boolean NOT NULL,
    enlace character varying(255),
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE noticia OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 30935)
-- Name: noticia_id_noticia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE noticia_id_noticia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE noticia_id_noticia_seq OWNER TO postgres;

--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 196
-- Name: noticia_id_noticia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE noticia_id_noticia_seq OWNED BY noticia.id_noticia;


--
-- TOC entry 247 (class 1259 OID 31180)
-- Name: noticia_preferencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE noticia_preferencia (
    id_noticia_preferencia integer NOT NULL,
    preferenciaid_preferencia smallint NOT NULL,
    noticiaid_noticia smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE noticia_preferencia OWNER TO postgres;

--
-- TOC entry 246 (class 1259 OID 31178)
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE noticia_preferencia_id_noticia_preferencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE noticia_preferencia_id_noticia_preferencia_seq OWNER TO postgres;

--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 246
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE noticia_preferencia_id_noticia_preferencia_seq OWNED BY noticia_preferencia.id_noticia_preferencia;


--
-- TOC entry 191 (class 1259 OID 30900)
-- Name: opinion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE opinion (
    id_opinion integer NOT NULL,
    postulacionid_postulacion smallint NOT NULL,
    descripcion text NOT NULL,
    usuarioid_usuario smallint NOT NULL,
    fecha timestamp without time zone NOT NULL,
    calificacion smallint NOT NULL,
    tipo_opnionid_tipo_opninion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE opinion OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 30898)
-- Name: opinion_id_opinion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE opinion_id_opinion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE opinion_id_opinion_seq OWNER TO postgres;

--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 190
-- Name: opinion_id_opinion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE opinion_id_opinion_seq OWNED BY opinion.id_opinion;


--
-- TOC entry 181 (class 1259 OID 30852)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    id_persona integer NOT NULL,
    identificacion character varying(20),
    nombre character varying(60) NOT NULL,
    apellido character varying(60) NOT NULL,
    foto text,
    fecha_nac date,
    sexo character varying(1) NOT NULL,
    correo character varying(80),
    telefono character varying(12),
    telefono_fijo character varying(12),
    direccion character varying(120),
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE persona OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 30850)
-- Name: persona_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE persona_id_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE persona_id_persona_seq OWNER TO postgres;

--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 180
-- Name: persona_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE persona_id_persona_seq OWNED BY persona.id_persona;


--
-- TOC entry 235 (class 1259 OID 31126)
-- Name: politica; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE politica (
    id_politica integer NOT NULL,
    descripcion character varying(255) NOT NULL,
    valor bigint,
    clubid_club smallint,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE politica OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 31124)
-- Name: politica_id_politica_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE politica_id_politica_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE politica_id_politica_seq OWNER TO postgres;

--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 234
-- Name: politica_id_politica_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE politica_id_politica_seq OWNED BY politica.id_politica;


--
-- TOC entry 289 (class 1259 OID 31378)
-- Name: portal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE portal (
    id_portal integer NOT NULL,
    instalacion text,
    socio text,
    evento text,
    activo boolean DEFAULT true NOT NULL,
    foto_socio text,
    foto_instalaciones text,
    foto_evento text
);


ALTER TABLE portal OWNER TO postgres;

--
-- TOC entry 288 (class 1259 OID 31376)
-- Name: portal_id_portal_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE portal_id_portal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE portal_id_portal_seq OWNER TO postgres;

--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 288
-- Name: portal_id_portal_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE portal_id_portal_seq OWNED BY portal.id_portal;


--
-- TOC entry 189 (class 1259 OID 30891)
-- Name: postulacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE postulacion (
    id_postulacion integer NOT NULL,
    postuladoid_postulado smallint NOT NULL,
    fecha date NOT NULL,
    carnet_padrino1 character varying(40) NOT NULL,
    carnet_padrino2 character varying(40) NOT NULL,
    motivo_postulacionid_motivo_postulacion smallint NOT NULL,
    aprobado boolean NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE postulacion OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 30889)
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE postulacion_id_postulacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE postulacion_id_postulacion_seq OWNER TO postgres;

--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 188
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE postulacion_id_postulacion_seq OWNED BY postulacion.id_postulacion;


--
-- TOC entry 217 (class 1259 OID 31039)
-- Name: postulado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE postulado (
    id_postulado integer NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE postulado OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 31037)
-- Name: postulado_id_postulado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE postulado_id_postulado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE postulado_id_postulado_seq OWNER TO postgres;

--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 216
-- Name: postulado_id_postulado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE postulado_id_postulado_seq OWNED BY postulado.id_postulado;


--
-- TOC entry 215 (class 1259 OID 31030)
-- Name: preferencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE preferencia (
    id_preferencia integer NOT NULL,
    descripcion character varying(80) NOT NULL,
    tipo_preferenciaid_tipo_preferencia smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE preferencia OWNER TO postgres;

--
-- TOC entry 255 (class 1259 OID 31219)
-- Name: preferencia_evento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE preferencia_evento (
    id_preferencia_evento integer NOT NULL,
    eventoid_evento smallint NOT NULL,
    preferenciaid_preferencia smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE preferencia_evento OWNER TO postgres;

--
-- TOC entry 254 (class 1259 OID 31217)
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE preferencia_evento_id_preferencia_evento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE preferencia_evento_id_preferencia_evento_seq OWNER TO postgres;

--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 254
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE preferencia_evento_id_preferencia_evento_seq OWNED BY preferencia_evento.id_preferencia_evento;


--
-- TOC entry 214 (class 1259 OID 31028)
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE preferencia_id_preferencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE preferencia_id_preferencia_seq OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 214
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE preferencia_id_preferencia_seq OWNED BY preferencia.id_preferencia;


--
-- TOC entry 223 (class 1259 OID 31069)
-- Name: preferencia_persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE preferencia_persona (
    id_preferencia_persona integer NOT NULL,
    preferenciaid_preferencia smallint NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE preferencia_persona OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 31067)
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE preferencia_persona_id_preferencia_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE preferencia_persona_id_preferencia_persona_seq OWNER TO postgres;

--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 222
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE preferencia_persona_id_preferencia_persona_seq OWNED BY preferencia_persona.id_preferencia_persona;


--
-- TOC entry 227 (class 1259 OID 31087)
-- Name: recurso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recurso (
    id_recurso integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE recurso OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 31085)
-- Name: recurso_id_recurso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recurso_id_recurso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recurso_id_recurso_seq OWNER TO postgres;

--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 226
-- Name: recurso_id_recurso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recurso_id_recurso_seq OWNED BY recurso.id_recurso;


--
-- TOC entry 231 (class 1259 OID 31108)
-- Name: recurso_instalacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE recurso_instalacion (
    id_recurso_instalacion integer NOT NULL,
    instalacionid_instalacion smallint NOT NULL,
    recursoid_recurso smallint NOT NULL,
    cantidad integer NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE recurso_instalacion OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 31106)
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE recurso_instalacion_id_recurso_instalacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recurso_instalacion_id_recurso_instalacion_seq OWNER TO postgres;

--
-- TOC entry 2906 (class 0 OID 0)
-- Dependencies: 230
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE recurso_instalacion_id_recurso_instalacion_seq OWNED BY recurso_instalacion.id_recurso_instalacion;


--
-- TOC entry 259 (class 1259 OID 31240)
-- Name: red_club; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE red_club (
    id_red_club integer NOT NULL,
    clubid_club smallint NOT NULL,
    red_socialid_red_social smallint NOT NULL,
    enlace character varying(255) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE red_club OWNER TO postgres;

--
-- TOC entry 258 (class 1259 OID 31238)
-- Name: red_club_id_red_club_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE red_club_id_red_club_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE red_club_id_red_club_seq OWNER TO postgres;

--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 258
-- Name: red_club_id_red_club_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE red_club_id_red_club_seq OWNED BY red_club.id_red_club;


--
-- TOC entry 261 (class 1259 OID 31249)
-- Name: red_persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE red_persona (
    id_red_persona integer NOT NULL,
    enlace character varying(255) NOT NULL,
    red_socialid_red_social smallint NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE red_persona OWNER TO postgres;

--
-- TOC entry 260 (class 1259 OID 31247)
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE red_persona_id_red_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE red_persona_id_red_persona_seq OWNER TO postgres;

--
-- TOC entry 2908 (class 0 OID 0)
-- Dependencies: 260
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE red_persona_id_red_persona_seq OWNED BY red_persona.id_red_persona;


--
-- TOC entry 257 (class 1259 OID 31228)
-- Name: red_social; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE red_social (
    id_red_social integer NOT NULL,
    descripcion character varying(120) NOT NULL,
    imagen text NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE red_social OWNER TO postgres;

--
-- TOC entry 256 (class 1259 OID 31226)
-- Name: red_social_id_red_social_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE red_social_id_red_social_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE red_social_id_red_social_seq OWNER TO postgres;

--
-- TOC entry 2909 (class 0 OID 0)
-- Dependencies: 256
-- Name: red_social_id_red_social_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE red_social_id_red_social_seq OWNED BY red_social.id_red_social;


--
-- TOC entry 209 (class 1259 OID 31003)
-- Name: reservacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE reservacion (
    id_reservacion integer NOT NULL,
    instalacionid_instalacion smallint NOT NULL,
    socioid_socio smallint NOT NULL,
    fecha_inicio timestamp without time zone NOT NULL,
    fecha_fin timestamp without time zone NOT NULL,
    condicion character(255),
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE reservacion OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 31001)
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE reservacion_id_reservacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE reservacion_id_reservacion_seq OWNER TO postgres;

--
-- TOC entry 2910 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE reservacion_id_reservacion_seq OWNED BY reservacion.id_reservacion;


--
-- TOC entry 183 (class 1259 OID 30864)
-- Name: sancion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sancion (
    id_sancion integer NOT NULL,
    descripcion character varying(200) NOT NULL,
    socioid_socio smallint,
    afiliadoid_afilado smallint,
    fecha_inic date,
    fecha_fin date,
    monto real,
    eventualidadid_eventualidad smallint,
    motivo_sancionid_motivo_sancion smallint DEFAULT 1,
    tipo_sancionid_tipo_sancion smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE sancion OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 30862)
-- Name: sancion_id_sancion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sancion_id_sancion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sancion_id_sancion_seq OWNER TO postgres;

--
-- TOC entry 2911 (class 0 OID 0)
-- Dependencies: 182
-- Name: sancion_id_sancion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sancion_id_sancion_seq OWNED BY sancion.id_sancion;


--
-- TOC entry 185 (class 1259 OID 30873)
-- Name: socio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE socio (
    id_socio integer NOT NULL,
    postulacionid_postulacion smallint,
    nro_carnet character varying(40) NOT NULL,
    personaid_persona smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE socio OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 30871)
-- Name: socio_id_socio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE socio_id_socio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE socio_id_socio_seq OWNER TO postgres;

--
-- TOC entry 2912 (class 0 OID 0)
-- Dependencies: 184
-- Name: socio_id_socio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE socio_id_socio_seq OWNED BY socio.id_socio;


--
-- TOC entry 277 (class 1259 OID 31321)
-- Name: solicitud_venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE solicitud_venta (
    id_solicitud_venta integer NOT NULL,
    accionid_accion smallint NOT NULL,
    motivo text,
    fecha date NOT NULL,
    motivo_ventaid_motivo_venta smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE solicitud_venta OWNER TO postgres;

--
-- TOC entry 276 (class 1259 OID 31319)
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE solicitud_venta_id_solicitud_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE solicitud_venta_id_solicitud_venta_seq OWNER TO postgres;

--
-- TOC entry 2913 (class 0 OID 0)
-- Dependencies: 276
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE solicitud_venta_id_solicitud_venta_seq OWNED BY solicitud_venta.id_solicitud_venta;


--
-- TOC entry 229 (class 1259 OID 31096)
-- Name: sugerencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sugerencia (
    id_sugerencia integer NOT NULL,
    descripcion text NOT NULL,
    fecha timestamp without time zone NOT NULL,
    usuarioid_usuario smallint,
    cliente_externoid_cliente smallint,
    tipo_sugerenciaid_tipo_sugerencia smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE sugerencia OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 31094)
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sugerencia_id_sugerencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sugerencia_id_sugerencia_seq OWNER TO postgres;

--
-- TOC entry 2914 (class 0 OID 0)
-- Dependencies: 228
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sugerencia_id_sugerencia_seq OWNED BY sugerencia.id_sugerencia;


--
-- TOC entry 253 (class 1259 OID 31207)
-- Name: tipo_afiliado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_afiliado (
    id_tipo_afiliado integer NOT NULL,
    descripcion character varying(90) NOT NULL,
    subfijo text,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_afiliado OWNER TO postgres;

--
-- TOC entry 252 (class 1259 OID 31205)
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_afiliado_id_tipo_afiliado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_afiliado_id_tipo_afiliado_seq OWNER TO postgres;

--
-- TOC entry 2915 (class 0 OID 0)
-- Dependencies: 252
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_afiliado_id_tipo_afiliado_seq OWNED BY tipo_afiliado.id_tipo_afiliado;


--
-- TOC entry 285 (class 1259 OID 31360)
-- Name: tipo_archivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_archivo (
    id_tipo_archivo integer NOT NULL,
    nombre character varying(80) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_archivo OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 31358)
-- Name: tipo_archivo_id_tipo_archivo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_archivo_id_tipo_archivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_archivo_id_tipo_archivo_seq OWNER TO postgres;

--
-- TOC entry 2916 (class 0 OID 0)
-- Dependencies: 284
-- Name: tipo_archivo_id_tipo_archivo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_archivo_id_tipo_archivo_seq OWNED BY tipo_archivo.id_tipo_archivo;


--
-- TOC entry 279 (class 1259 OID 31333)
-- Name: tipo_eventualidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_eventualidad (
    id_tipo_eventualidad integer NOT NULL,
    descripcion character varying(90) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_eventualidad OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 31331)
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_eventualidad_id_tipo_eventualidad_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_eventualidad_id_tipo_eventualidad_seq OWNER TO postgres;

--
-- TOC entry 2917 (class 0 OID 0)
-- Dependencies: 278
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_eventualidad_id_tipo_eventualidad_seq OWNED BY tipo_eventualidad.id_tipo_eventualidad;


--
-- TOC entry 301 (class 1259 OID 31433)
-- Name: tipo_instalacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_instalacion (
    id_tipo_instalacion integer NOT NULL,
    descripcion character varying(60) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_instalacion OWNER TO postgres;

--
-- TOC entry 300 (class 1259 OID 31431)
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_instalacion_id_tipo_instalacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_instalacion_id_tipo_instalacion_seq OWNER TO postgres;

--
-- TOC entry 2918 (class 0 OID 0)
-- Dependencies: 300
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_instalacion_id_tipo_instalacion_seq OWNED BY tipo_instalacion.id_tipo_instalacion;


--
-- TOC entry 287 (class 1259 OID 31369)
-- Name: tipo_noticia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_noticia (
    id_tipo_noticia integer NOT NULL,
    descripcion character varying(200) NOT NULL,
    color character varying(100),
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_noticia OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 31367)
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_noticia_id_tipo_noticia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_noticia_id_tipo_noticia_seq OWNER TO postgres;

--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 286
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_noticia_id_tipo_noticia_seq OWNED BY tipo_noticia.id_tipo_noticia;


--
-- TOC entry 293 (class 1259 OID 31398)
-- Name: tipo_opnion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_opnion (
    id_tipo_opninion integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_opnion OWNER TO postgres;

--
-- TOC entry 292 (class 1259 OID 31396)
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_opnion_id_tipo_opninion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_opnion_id_tipo_opninion_seq OWNER TO postgres;

--
-- TOC entry 2920 (class 0 OID 0)
-- Dependencies: 292
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_opnion_id_tipo_opninion_seq OWNED BY tipo_opnion.id_tipo_opninion;


--
-- TOC entry 291 (class 1259 OID 31390)
-- Name: tipo_pago; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_pago (
    id_tipo_pago integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    activo boolean NOT NULL
);


ALTER TABLE tipo_pago OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 31388)
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_pago_id_tipo_pago_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_pago_id_tipo_pago_seq OWNER TO postgres;

--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 290
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_pago_id_tipo_pago_seq OWNED BY tipo_pago.id_tipo_pago;


--
-- TOC entry 245 (class 1259 OID 31171)
-- Name: tipo_preferencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_preferencia (
    id_tipo_preferencia integer NOT NULL,
    descripcion character varying(80) NOT NULL,
    color character varying(12),
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_preferencia OWNER TO postgres;

--
-- TOC entry 244 (class 1259 OID 31169)
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_preferencia_id_tipo_preferencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_preferencia_id_tipo_preferencia_seq OWNER TO postgres;

--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 244
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_preferencia_id_tipo_preferencia_seq OWNED BY tipo_preferencia.id_tipo_preferencia;


--
-- TOC entry 295 (class 1259 OID 31407)
-- Name: tipo_sancion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_sancion (
    id_tipo_sancion integer NOT NULL,
    descripcion character varying(80) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_sancion OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 31405)
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_sancion_id_tipo_sancion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_sancion_id_tipo_sancion_seq OWNER TO postgres;

--
-- TOC entry 2923 (class 0 OID 0)
-- Dependencies: 294
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_sancion_id_tipo_sancion_seq OWNED BY tipo_sancion.id_tipo_sancion;


--
-- TOC entry 243 (class 1259 OID 31162)
-- Name: tipo_sugerencia; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_sugerencia (
    id_tipo_sugerencia integer NOT NULL,
    descripcion character varying(30) NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE tipo_sugerencia OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 31160)
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_sugerencia_id_tipo_sugerencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE tipo_sugerencia_id_tipo_sugerencia_seq OWNER TO postgres;

--
-- TOC entry 2924 (class 0 OID 0)
-- Dependencies: 242
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_sugerencia_id_tipo_sugerencia_seq OWNED BY tipo_sugerencia.id_tipo_sugerencia;


--
-- TOC entry 173 (class 1259 OID 30813)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    contrasenna character varying(20) NOT NULL,
    username character varying(60) NOT NULL,
    pregunta character varying(60) NOT NULL,
    respuesta character varying(60) NOT NULL,
    personaid_persona smallint NOT NULL,
    fecha date NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 30834)
-- Name: usuario_grupo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario_grupo (
    id_usuario_grupo integer NOT NULL,
    usuarioid_usuario smallint NOT NULL,
    grupoid_grupo smallint NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE usuario_grupo OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 30832)
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_grupo_id_usuario_grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_grupo_id_usuario_grupo_seq OWNER TO postgres;

--
-- TOC entry 2925 (class 0 OID 0)
-- Dependencies: 176
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_grupo_id_usuario_grupo_seq OWNED BY usuario_grupo.id_usuario_grupo;


--
-- TOC entry 172 (class 1259 OID 30811)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2926 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;


--
-- TOC entry 221 (class 1259 OID 31060)
-- Name: venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE venta (
    id_venta integer NOT NULL,
    accionid_accion smallint NOT NULL,
    postulacionid_postulacion smallint NOT NULL,
    fecha date NOT NULL,
    monto real NOT NULL,
    activo boolean DEFAULT true NOT NULL
);


ALTER TABLE venta OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 31058)
-- Name: venta_id_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE venta_id_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venta_id_venta_seq OWNER TO postgres;

--
-- TOC entry 2927 (class 0 OID 0)
-- Dependencies: 220
-- Name: venta_id_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE venta_id_venta_seq OWNED BY venta.id_venta;


--
-- TOC entry 2295 (class 2604 OID 30885)
-- Name: id_accion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY accion ALTER COLUMN id_accion SET DEFAULT nextval('accion_id_accion_seq'::regclass);


--
-- TOC entry 2312 (class 2604 OID 30976)
-- Name: id_actividad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad ALTER COLUMN id_actividad SET DEFAULT nextval('actividad_id_actividad_seq'::regclass);


--
-- TOC entry 2320 (class 2604 OID 31015)
-- Name: id_afilado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afiliado ALTER COLUMN id_afilado SET DEFAULT nextval('afiliado_id_afilado_seq'::regclass);


--
-- TOC entry 2342 (class 2604 OID 31120)
-- Name: id_alquiler; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alquiler ALTER COLUMN id_alquiler SET DEFAULT nextval('alquiler_id_alquiler_seq'::regclass);


--
-- TOC entry 2376 (class 2604 OID 31279)
-- Name: id_archivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY archivo ALTER COLUMN id_archivo SET DEFAULT nextval('archivo_id_archivo_seq'::regclass);


--
-- TOC entry 2392 (class 2604 OID 31354)
-- Name: id_archivo_alquiler; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY archivo_alquiler ALTER COLUMN id_archivo_alquiler SET DEFAULT nextval('archivo_alquiler_id_archivo_alquiler_seq'::regclass);


--
-- TOC entry 2308 (class 2604 OID 30952)
-- Name: id_calendario_fecha; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendario_fecha ALTER COLUMN id_calendario_fecha SET DEFAULT nextval('calendario_fecha_id_calendario_fecha_seq'::regclass);


--
-- TOC entry 2380 (class 2604 OID 31297)
-- Name: id_cancelacion_evento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cancelacion_evento ALTER COLUMN id_cancelacion_evento SET DEFAULT nextval('cancelacion_evento_id_cancelacion_evento_seq'::regclass);


--
-- TOC entry 2350 (class 2604 OID 31156)
-- Name: id_cargo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cargo ALTER COLUMN id_cargo SET DEFAULT nextval('cargo_id_cargo_seq'::regclass);


--
-- TOC entry 2322 (class 2604 OID 31024)
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente_externo ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_externo_id_cliente_seq'::regclass);


--
-- TOC entry 2282 (class 2604 OID 30825)
-- Name: id_club; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY club ALTER COLUMN id_club SET DEFAULT nextval('club_id_club_seq'::regclass);


--
-- TOC entry 2328 (class 2604 OID 31051)
-- Name: id_desvinculacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desvinculacion ALTER COLUMN id_desvinculacion SET DEFAULT nextval('desvinculacion_id_desvinculacion_seq'::regclass);


--
-- TOC entry 2390 (class 2604 OID 31345)
-- Name: id_estado_accion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_accion ALTER COLUMN id_estado_accion SET DEFAULT nextval('estado_accion_id_estado_accion_seq'::regclass);


--
-- TOC entry 2378 (class 2604 OID 31288)
-- Name: id_estado_evento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estado_evento ALTER COLUMN id_estado_evento SET DEFAULT nextval('estado_evento_id_estado_evento_seq'::regclass);


--
-- TOC entry 2310 (class 2604 OID 30964)
-- Name: id_evento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY evento ALTER COLUMN id_evento SET DEFAULT nextval('evento_id_evento_seq'::regclass);


--
-- TOC entry 2301 (class 2604 OID 30915)
-- Name: id_eventualidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eventualidad ALTER COLUMN id_eventualidad SET DEFAULT nextval('eventualidad_id_eventualidad_seq'::regclass);


--
-- TOC entry 2360 (class 2604 OID 31201)
-- Name: id_foto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY foto ALTER COLUMN id_foto SET DEFAULT nextval('foto_id_foto_seq'::regclass);


--
-- TOC entry 2314 (class 2604 OID 30985)
-- Name: id_funcion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcion ALTER COLUMN id_funcion SET DEFAULT nextval('funcion_id_funcion_seq'::regclass);


--
-- TOC entry 2316 (class 2604 OID 30997)
-- Name: id_funcion_grupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcion_grupo ALTER COLUMN id_funcion_grupo SET DEFAULT nextval('funcion_grupo_id_funcion_grupo_seq'::regclass);


--
-- TOC entry 2286 (class 2604 OID 30846)
-- Name: id_grupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY grupo ALTER COLUMN id_grupo SET DEFAULT nextval('grupo_id_grupo_seq'::regclass);


--
-- TOC entry 2382 (class 2604 OID 31306)
-- Name: id_indicador; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador ALTER COLUMN id_indicador SET DEFAULT nextval('indicador_id_indicador_seq'::regclass);


--
-- TOC entry 2384 (class 2604 OID 31315)
-- Name: id_indicador_evento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_evento ALTER COLUMN id_indicador_evento SET DEFAULT nextval('indicador_evento_id_indicador_evento_seq'::regclass);


--
-- TOC entry 2303 (class 2604 OID 30927)
-- Name: id_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion ALTER COLUMN id_instalacion SET DEFAULT nextval('instalacion_id_instalacion_seq'::regclass);


--
-- TOC entry 2334 (class 2604 OID 31081)
-- Name: id_actividad_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion_evento ALTER COLUMN id_actividad_instalacion SET DEFAULT nextval('instalacion_evento_id_actividad_instalacion_seq'::regclass);


--
-- TOC entry 2346 (class 2604 OID 31138)
-- Name: id_junta_directiva; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY junta_directiva ALTER COLUMN id_junta_directiva SET DEFAULT nextval('junta_directiva_id_junta_directiva_seq'::regclass);


--
-- TOC entry 2348 (class 2604 OID 31147)
-- Name: id_junta_miembro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY miembro_junta ALTER COLUMN id_junta_miembro SET DEFAULT nextval('miembro_junta_id_junta_miembro_seq'::regclass);


--
-- TOC entry 2405 (class 2604 OID 31419)
-- Name: id_motivo_cancelacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_cancelacion ALTER COLUMN id_motivo_cancelacion SET DEFAULT nextval('motivo_cancelacion_id_motivo_cancelacion_seq'::regclass);


--
-- TOC entry 2358 (class 2604 OID 31192)
-- Name: id_motivo_desvinculacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_desvinculacion ALTER COLUMN id_motivo_desvinculacion SET DEFAULT nextval('motivo_desvinculacion_id_motivo_desvinculacion_seq'::regclass);


--
-- TOC entry 2372 (class 2604 OID 31261)
-- Name: id_motivo_postulacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_postulacion ALTER COLUMN id_motivo_postulacion SET DEFAULT nextval('motivo_postulacion_id_motivo_postulacion_seq'::regclass);


--
-- TOC entry 2406 (class 2604 OID 31427)
-- Name: id_motivo_sancion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_sancion ALTER COLUMN id_motivo_sancion SET DEFAULT nextval('motivo_sancion_id_motivo_sancion_seq'::regclass);


--
-- TOC entry 2374 (class 2604 OID 31270)
-- Name: id_motivo_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY motivo_venta ALTER COLUMN id_motivo_venta SET DEFAULT nextval('motivo_venta_id_motivo_venta_seq'::regclass);


--
-- TOC entry 2306 (class 2604 OID 30940)
-- Name: id_noticia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia ALTER COLUMN id_noticia SET DEFAULT nextval('noticia_id_noticia_seq'::regclass);


--
-- TOC entry 2356 (class 2604 OID 31183)
-- Name: id_noticia_preferencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia_preferencia ALTER COLUMN id_noticia_preferencia SET DEFAULT nextval('noticia_preferencia_id_noticia_preferencia_seq'::regclass);


--
-- TOC entry 2299 (class 2604 OID 30903)
-- Name: id_opinion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY opinion ALTER COLUMN id_opinion SET DEFAULT nextval('opinion_id_opinion_seq'::regclass);


--
-- TOC entry 2288 (class 2604 OID 30855)
-- Name: id_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona ALTER COLUMN id_persona SET DEFAULT nextval('persona_id_persona_seq'::regclass);


--
-- TOC entry 2345 (class 2604 OID 31129)
-- Name: id_politica; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY politica ALTER COLUMN id_politica SET DEFAULT nextval('politica_id_politica_seq'::regclass);


--
-- TOC entry 2398 (class 2604 OID 31381)
-- Name: id_portal; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY portal ALTER COLUMN id_portal SET DEFAULT nextval('portal_id_portal_seq'::regclass);


--
-- TOC entry 2297 (class 2604 OID 30894)
-- Name: id_postulacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY postulacion ALTER COLUMN id_postulacion SET DEFAULT nextval('postulacion_id_postulacion_seq'::regclass);


--
-- TOC entry 2326 (class 2604 OID 31042)
-- Name: id_postulado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY postulado ALTER COLUMN id_postulado SET DEFAULT nextval('postulado_id_postulado_seq'::regclass);


--
-- TOC entry 2324 (class 2604 OID 31033)
-- Name: id_preferencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia ALTER COLUMN id_preferencia SET DEFAULT nextval('preferencia_id_preferencia_seq'::regclass);


--
-- TOC entry 2364 (class 2604 OID 31222)
-- Name: id_preferencia_evento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_evento ALTER COLUMN id_preferencia_evento SET DEFAULT nextval('preferencia_evento_id_preferencia_evento_seq'::regclass);


--
-- TOC entry 2332 (class 2604 OID 31072)
-- Name: id_preferencia_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_persona ALTER COLUMN id_preferencia_persona SET DEFAULT nextval('preferencia_persona_id_preferencia_persona_seq'::regclass);


--
-- TOC entry 2336 (class 2604 OID 31090)
-- Name: id_recurso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recurso ALTER COLUMN id_recurso SET DEFAULT nextval('recurso_id_recurso_seq'::regclass);


--
-- TOC entry 2340 (class 2604 OID 31111)
-- Name: id_recurso_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recurso_instalacion ALTER COLUMN id_recurso_instalacion SET DEFAULT nextval('recurso_instalacion_id_recurso_instalacion_seq'::regclass);


--
-- TOC entry 2368 (class 2604 OID 31243)
-- Name: id_red_club; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_club ALTER COLUMN id_red_club SET DEFAULT nextval('red_club_id_red_club_seq'::regclass);


--
-- TOC entry 2370 (class 2604 OID 31252)
-- Name: id_red_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_persona ALTER COLUMN id_red_persona SET DEFAULT nextval('red_persona_id_red_persona_seq'::regclass);


--
-- TOC entry 2366 (class 2604 OID 31231)
-- Name: id_red_social; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_social ALTER COLUMN id_red_social SET DEFAULT nextval('red_social_id_red_social_seq'::regclass);


--
-- TOC entry 2318 (class 2604 OID 31006)
-- Name: id_reservacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservacion ALTER COLUMN id_reservacion SET DEFAULT nextval('reservacion_id_reservacion_seq'::regclass);


--
-- TOC entry 2290 (class 2604 OID 30867)
-- Name: id_sancion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion ALTER COLUMN id_sancion SET DEFAULT nextval('sancion_id_sancion_seq'::regclass);


--
-- TOC entry 2293 (class 2604 OID 30876)
-- Name: id_socio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY socio ALTER COLUMN id_socio SET DEFAULT nextval('socio_id_socio_seq'::regclass);


--
-- TOC entry 2386 (class 2604 OID 31324)
-- Name: id_solicitud_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_venta ALTER COLUMN id_solicitud_venta SET DEFAULT nextval('solicitud_venta_id_solicitud_venta_seq'::regclass);


--
-- TOC entry 2338 (class 2604 OID 31099)
-- Name: id_sugerencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sugerencia ALTER COLUMN id_sugerencia SET DEFAULT nextval('sugerencia_id_sugerencia_seq'::regclass);


--
-- TOC entry 2362 (class 2604 OID 31210)
-- Name: id_tipo_afiliado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_afiliado ALTER COLUMN id_tipo_afiliado SET DEFAULT nextval('tipo_afiliado_id_tipo_afiliado_seq'::regclass);


--
-- TOC entry 2394 (class 2604 OID 31363)
-- Name: id_tipo_archivo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_archivo ALTER COLUMN id_tipo_archivo SET DEFAULT nextval('tipo_archivo_id_tipo_archivo_seq'::regclass);


--
-- TOC entry 2388 (class 2604 OID 31336)
-- Name: id_tipo_eventualidad; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_eventualidad ALTER COLUMN id_tipo_eventualidad SET DEFAULT nextval('tipo_eventualidad_id_tipo_eventualidad_seq'::regclass);


--
-- TOC entry 2408 (class 2604 OID 31436)
-- Name: id_tipo_instalacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_instalacion ALTER COLUMN id_tipo_instalacion SET DEFAULT nextval('tipo_instalacion_id_tipo_instalacion_seq'::regclass);


--
-- TOC entry 2396 (class 2604 OID 31372)
-- Name: id_tipo_noticia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_noticia ALTER COLUMN id_tipo_noticia SET DEFAULT nextval('tipo_noticia_id_tipo_noticia_seq'::regclass);


--
-- TOC entry 2401 (class 2604 OID 31401)
-- Name: id_tipo_opninion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_opnion ALTER COLUMN id_tipo_opninion SET DEFAULT nextval('tipo_opnion_id_tipo_opninion_seq'::regclass);


--
-- TOC entry 2400 (class 2604 OID 31393)
-- Name: id_tipo_pago; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_pago ALTER COLUMN id_tipo_pago SET DEFAULT nextval('tipo_pago_id_tipo_pago_seq'::regclass);


--
-- TOC entry 2354 (class 2604 OID 31174)
-- Name: id_tipo_preferencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_preferencia ALTER COLUMN id_tipo_preferencia SET DEFAULT nextval('tipo_preferencia_id_tipo_preferencia_seq'::regclass);


--
-- TOC entry 2403 (class 2604 OID 31410)
-- Name: id_tipo_sancion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_sancion ALTER COLUMN id_tipo_sancion SET DEFAULT nextval('tipo_sancion_id_tipo_sancion_seq'::regclass);


--
-- TOC entry 2352 (class 2604 OID 31165)
-- Name: id_tipo_sugerencia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_sugerencia ALTER COLUMN id_tipo_sugerencia SET DEFAULT nextval('tipo_sugerencia_id_tipo_sugerencia_seq'::regclass);


--
-- TOC entry 2280 (class 2604 OID 30816)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- TOC entry 2284 (class 2604 OID 30837)
-- Name: id_usuario_grupo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_grupo ALTER COLUMN id_usuario_grupo SET DEFAULT nextval('usuario_grupo_id_usuario_grupo_seq'::regclass);


--
-- TOC entry 2330 (class 2604 OID 31063)
-- Name: id_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta ALTER COLUMN id_venta SET DEFAULT nextval('venta_id_venta_seq'::regclass);


--
-- TOC entry 2740 (class 0 OID 30882)
-- Dependencies: 187
-- Data for Name: accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY accion (id_accion, nro_accion, valor, socioid_socio, estado_accionid_estado_accion, activo) FROM stdin;
1	A00000001	10000	1	1	t
2	A00000002	10000	2	1	t
3	A00000003	10000	3	1	t
4	A00000004	10000	4	1	t
5	A00000005	10000	5	1	t
6	A00000006	10000	6	1	t
7	A00000007	10000	7	1	t
8	A00000008	10000	8	1	t
9	A0000009	10000	9	1	t
10	A000010	10000	10	1	t
11	A000011	10000	\N	2	t
\.


--
-- TOC entry 2928 (class 0 OID 0)
-- Dependencies: 186
-- Name: accion_id_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('accion_id_accion_seq', 1, false);


--
-- TOC entry 2756 (class 0 OID 30973)
-- Dependencies: 203
-- Data for Name: actividad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY actividad (id_actividad, descripcion, eventoid_evento, fecha_tope, fecha_realizacion, valor_esperado, valor_real, finalizada, activo) FROM stdin;
3	Buscar Pelotas	2	2016-03-18 00:00:00	2016-03-18 00:00:00	250	300	t	t
2	Buscar bates	2	2016-03-18 00:00:00	\N	30	\N	f	f
4	Buscar Bates	2	2016-03-18 00:00:00	2016-03-18 00:00:00	100	100	t	t
1	Buscar pelotas	2	2016-03-18 00:00:00	\N	50	\N	f	f
5	buscar cervezas	4	2016-03-20 00:00:00	2016-03-18 00:00:00	20	10	t	t
7	buscar refrescos	4	2016-03-20 00:00:00	\N	10	\N	f	t
6	buscar kilos de carne	4	2016-03-20 00:00:00	\N	3	\N	f	t
\.


--
-- TOC entry 2929 (class 0 OID 0)
-- Dependencies: 202
-- Name: actividad_id_actividad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('actividad_id_actividad_seq', 1, false);


--
-- TOC entry 2764 (class 0 OID 31012)
-- Dependencies: 211
-- Data for Name: afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY afiliado (id_afilado, tipo_afiliadoid_tipo_afiliado, socioid_socio, nro_carnet, personaid_persona, activo) FROM stdin;
1	2	9	B-0330--2	10	t
2	1	10	B-0350--1	12	t
3	1	4	B-0341--1	15	t
\.


--
-- TOC entry 2930 (class 0 OID 0)
-- Dependencies: 210
-- Name: afiliado_id_afilado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('afiliado_id_afilado_seq', 1, false);


--
-- TOC entry 2786 (class 0 OID 31117)
-- Dependencies: 233
-- Data for Name: alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY alquiler (id_alquiler, reservacionid_reservacion, tipo_pagoid_tipo_pago, fecha, monto, activo) FROM stdin;
1	1	1	2016-03-18	0	t
2	2	1	2016-03-18	0	t
\.


--
-- TOC entry 2931 (class 0 OID 0)
-- Dependencies: 232
-- Name: alquiler_id_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('alquiler_id_alquiler_seq', 1, false);


--
-- TOC entry 2820 (class 0 OID 31276)
-- Dependencies: 267
-- Data for Name: archivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY archivo (id_archivo, url, nombre, extension, activo) FROM stdin;
\.


--
-- TOC entry 2836 (class 0 OID 31351)
-- Dependencies: 283
-- Data for Name: archivo_alquiler; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY archivo_alquiler (id_archivo_alquiler, archivoid_archivo, alquilerid_alquiler, tipo_archivoid_tipo_archivo, activo) FROM stdin;
\.


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 282
-- Name: archivo_alquiler_id_archivo_alquiler_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('archivo_alquiler_id_archivo_alquiler_seq', 1, false);


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 266
-- Name: archivo_id_archivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('archivo_id_archivo_seq', 1, false);


--
-- TOC entry 2752 (class 0 OID 30949)
-- Dependencies: 199
-- Data for Name: calendario_fecha; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY calendario_fecha (id_calendario_fecha, descripcion, fecha, eventoid_evento, reservacionid_reservacion, activo) FROM stdin;
1	espacio para la practica de beisbol	2016-03-18	\N	1	t
2	Espacio para fiestas y celebraciones	2016-03-18	\N	2	t
\.


--
-- TOC entry 2934 (class 0 OID 0)
-- Dependencies: 198
-- Name: calendario_fecha_id_calendario_fecha_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('calendario_fecha_id_calendario_fecha_seq', 1, false);


--
-- TOC entry 2824 (class 0 OID 31294)
-- Dependencies: 271
-- Data for Name: cancelacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cancelacion_evento (id_cancelacion_evento, descipcion, motivo_cancelacionid_motivo_cancelacion, activo) FROM stdin;
\.


--
-- TOC entry 2935 (class 0 OID 0)
-- Dependencies: 270
-- Name: cancelacion_evento_id_cancelacion_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cancelacion_evento_id_cancelacion_evento_seq', 1, false);


--
-- TOC entry 2794 (class 0 OID 31153)
-- Dependencies: 241
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cargo (id_cargo, descripcion, activo) FROM stdin;
1	Presidente	t
2	Vicepresidente	t
3	Vocero	t
4	Tesorero	t
\.


--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 240
-- Name: cargo_id_cargo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cargo_id_cargo_seq', 1, true);


--
-- TOC entry 2766 (class 0 OID 31021)
-- Dependencies: 213
-- Data for Name: cliente_externo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente_externo (id_cliente, nombre, apellido, correo, activo) FROM stdin;
1	Fidel	Aliaga	fidel.alejos@gmail.com	t
2	Gipsy	Martinez	gipsy@gmail.com	t
\.


--
-- TOC entry 2937 (class 0 OID 0)
-- Dependencies: 212
-- Name: cliente_externo_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_externo_id_cliente_seq', 1, false);


--
-- TOC entry 2728 (class 0 OID 30822)
-- Dependencies: 175
-- Data for Name: club; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY club (id_club, rif, nombre, direccion, telefono, mision, vision, logo, telf_alternativo, correo, clave_correo, eslogan, activo) FROM stdin;
1	J-08521135-7	Centro Atlético America	Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.	0251-4410025	Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.	Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.	http://i.imgur.com/bzOnmjv.png	0251-4411594	centroatleticoclubamerica@gmail.com	\N	Incentivando y promoviendo la participación cultural y deportiva	t
\.


--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 174
-- Name: club_id_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('club_id_club_seq', 1, false);


--
-- TOC entry 2772 (class 0 OID 31048)
-- Dependencies: 219
-- Data for Name: desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY desvinculacion (id_desvinculacion, accionid_accion, socioid_socio, fecha, motivo, motivo_desvinculacionid_motivo_desvinculacion, activo) FROM stdin;
\.


--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 218
-- Name: desvinculacion_id_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('desvinculacion_id_desvinculacion_seq', 1, false);


--
-- TOC entry 2834 (class 0 OID 31342)
-- Dependencies: 281
-- Data for Name: estado_accion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estado_accion (id_estado_accion, nombre, activo) FROM stdin;
1	Asociada	t
2	En Venta	t
3	En Solicitud	t
4	Inactiva	t
\.


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 280
-- Name: estado_accion_id_estado_accion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_accion_id_estado_accion_seq', 4, true);


--
-- TOC entry 2822 (class 0 OID 31285)
-- Dependencies: 269
-- Data for Name: estado_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY estado_evento (id_estado_evento, nombre, activo) FROM stdin;
1	Por Planificar	t
2	Listo para Ejecutar	t
3	En Ejecucion	t
4	Finalizado	t
5	Cancelado	t
\.


--
-- TOC entry 2941 (class 0 OID 0)
-- Dependencies: 268
-- Name: estado_evento_id_estado_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('estado_evento_id_estado_evento_seq', 5, true);


--
-- TOC entry 2754 (class 0 OID 30961)
-- Dependencies: 201
-- Data for Name: evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY evento (id_evento, nombre, descripcion, fecha_inicio, fecha_fin, publico, estado_eventoid_estado_evento, cancelacion_eventoid_cancelacion_evento, activo) FROM stdin;
3	Evento Hilder	Este un evento con la noticia corregida	2016-03-25 00:00:00	2016-04-01 00:00:00	t	1	\N	t
2	Torneo de Beisbol	Disfruta del Torneo de Beisbol	2016-03-18 00:00:00	2016-03-19 00:00:00	f	4	\N	t
4	parrilla osullivan	evento  para quitar la presion de los desarrolladores del club america	2016-03-20 00:00:00	2016-03-21 00:00:00	t	4	\N	t
\.


--
-- TOC entry 2942 (class 0 OID 0)
-- Dependencies: 200
-- Name: evento_id_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('evento_id_evento_seq', 1, false);


--
-- TOC entry 2746 (class 0 OID 30912)
-- Dependencies: 193
-- Data for Name: eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY eventualidad (id_eventualidad, instalacionid_instalacion, descripcion, fecha, personaid_persona, tipo_eventualidadid_tipo_eventualidad, activo) FROM stdin;
\.


--
-- TOC entry 2943 (class 0 OID 0)
-- Dependencies: 192
-- Name: eventualidad_id_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('eventualidad_id_eventualidad_seq', 1, false);


--
-- TOC entry 2804 (class 0 OID 31198)
-- Dependencies: 251
-- Data for Name: foto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY foto (id_foto, url, instalacionid_instalacion, publico, clubid_club, activo) FROM stdin;
1	http://i.imgur.com/wHrzoYB.jpg	1	t	1	t
2	http://i.imgur.com/cHPOldS.jpg	2	t	1	t
3	http://i.imgur.com/2pTsUU6.jpg	2	t	1	t
\.


--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 250
-- Name: foto_id_foto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('foto_id_foto_seq', 3, true);


--
-- TOC entry 2758 (class 0 OID 30982)
-- Dependencies: 205
-- Data for Name: funcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY funcion (id_funcion, nombre, pagina, icon_uri, clase, padreid_funcion, activo) FROM stdin;
1	Configuracion	 	z-icon-cogs	 	0	t
2	Socios	 	z-icon-user	 	0	t
3	Instalaciones	 	z-icon-home	 	0	t
4	Eventos	 	z-icon-calendar	 	0	t
5	Consulta	 	z-icon-th-list	 	0	t
6	Adm. del sistema	 	z-icon-puzzle-piece	 	0	t
7	Postulaciones	 	z-icon-puzzle-piece	 	0	t
8	Categorias	 	z-icon-angle-double-right	 	1	t
9	Administrar socio	 	z-icon-angle-double-right	 	2	t
10	Danos tu opinion	 	z-icon-angle-double-right	 	2	t
11	Administrar evento	 	z-icon-angle-double-right	 	4	t
12	Estructurado	 	z-icon-angle-double-right	 	5	t
14	Estadisticos	 	z-icon-angle-double-right	 	5	t
15	Seguridad	 	z-icon-angle-double-right	 	6	t
16	Perfil del club	configuracion/perfilClub.zul	z-icon-angle-double-right	 	1	t
17	Junta directiva	configuracion/juntaDirectiva.zul	z-icon-angle-double-right	 	1	t
18	Instalaciones	configuracion/gestionarInstalaciones.zul	z-icon-angle-double-right	 	1	t
19	Reglas club	configuracion/reglasClub.zul	z-icon-angle-double-right	 	1	t
20	Preferencias	configuracion/categoria/preferencia.zul	z-icon-angle-double-right	 	8	t
21	Recursos	configuracion/categoria/recursos.zul	z-icon-angle-double-right	 	8	t
22	Cargo junta directiva	configuracion/categoria/cargoJunta.zul	z-icon-angle-double-right	 	1	t
23	Motivo postulacion	configuracion/categoria/motivoPostulacion.zul	z-icon-angle-double-right	 	8	t
24	Motivo venta	configuracion/categoria/motivoVenta.zul	z-icon-angle-double-right	 	8	t
25	Tipo sugerencia	configuracion/categoria/tipoSugerencia.zul	z-icon-angle-double-right	 	8	t
26	Tipo preferencia	configuracion/categoria/tipoPreferencia.zul	z-icon-angle-double-right	 	8	t
27	Tipo instalacion	configuracion/categoria/tipoInstalacion.zul	z-icon-angle-double-right	 	8	t
28	Tipo sancion	configuracion/categoria/tipoSancion.zul	z-icon-angle-double-right	 	8	t
29	Tipo Afiliado	configuracion/categoria/tipoAfiliado.zul	z-icon-angle-double-right	 	8	t
30	Tipo actividad	configuracion/categoria/tipoActividad.zul	z-icon-angle-double-right	 	8	t
31	Motivo desvinculacion	configuracion/categoria/motivoDesvinculacion.zul	z-icon-angle-double-right	 	8	t
32	Acciones	socio/acciones.zul	z-icon-angle-double-right	 	2	t
33	Mi perfil	socio/miPerfil.zul	z-icon-angle-double-right	 	2	t
34	Mis sanciones	socio/misSanciones.zul	z-icon-angle-double-right	 	2	t
35	Solicitar venta	socio/solicitarVenta.zul	z-icon-angle-double-right	 	2	t
36	Registrar socio	socio/administrarSocio/postulantes.zul	z-icon-angle-double-right	 	9	t
37	Registrar afiliado	socio/administrarSocio/socios.zul	z-icon-angle-double-right	 	9	t
38	Sanciones	socio/administrarSocio/sanciones.zul	z-icon-angle-double-right	 	9	t
39	Sugerencias	socio/buzon/vistaGeneralSugerencias.zul	z-icon-angle-double-right	 	10	t
40	Opinion postulacion	socio/buzon/opinionPostulacion.zul	z-icon-angle-double-right	 	10	t
41	Reservacion	instalacion/misReservaciones.zul	z-icon-angle-double-right	 	3	t
42	Alquileres	instalacion/administrarAlquileres.zul	z-icon-angle-double-right	 	3	t
43	Mis alquileres	instalacion/misAlquileres.zul	z-icon-angle-double-right	 	3	t
44	Eventualidades	instalacion/registrarEventualidadInst.zul	z-icon-angle-double-right	 	2	t
45	Registrar eventos	evento/administrarEvento/listaEventos.zul	z-icon-angle-double-right	 	11	t
46	Planificar evento	evento/administrarEvento/planificarEvento.zul	z-icon-angle-double-right	 	11	t
47	Ejecutar evento	evento/administrarEvento/ejecutarEvento.zul	z-icon-angle-double-right	 	11	t
48	Adjuntar empleados	administracion/adjuntarEmpleados.zul	z-icon-angle-double-right	 	6	t
49	Cartelera	administracion/cartelera.zul	z-icon-angle-double-right	 	6	t
50	Backup BD	 	z-icon-angle-double-right	 	6	t
51	Usuarios	administracion/seguridad/usuarioGeneral.zul	z-icon-angle-double-right	 	15	t
52	Grupos	administracion/seguridad/mostrarGrupos.zul	z-icon-angle-double-right	 	15	t
53	Funciones	administracion/seguridad/administrarFunciones.zul	z-icon-angle-double-right	 	15	t
54	Postulados	postulado/postulado.zul	z-icon-angle-double-right	 	7	t
55	Administrar portal	configuracion/administracionPortal.zul	z-icon-angle-double-right	 	1	t
56	Finalizar evento	evento/administrarEvento/finalizarEvento.zul	z-icon-angle-double-right	 	11	t
57	Alquileres	consultas/reporteAlquileres.zul	z-icon-angle-double-right	 	12	t
58	Eventos	consultas/reporteEventos.zul	z-icon-angle-double-right	 	12	t
59	Actividades de Eventos	consultas/reporteActividadEventos.zul	z-icon-angle-double-right	 	12	t
60	Socios	consultas/reporteSocios.zul	z-icon-angle-double-right	 	12	t
61	Sanciones	consultas/reporteSanciones.zul	z-icon-angle-double-right	 	12	t
62	Eventualidades	consultas/reporteEventualidad.zul	z-icon-angle-double-right	 	12	t
63	Sanciones	consultas/reporteSancionesEst.zul	z-icon-angle-double-right	 	14	t
64	Eventualidades	consultas/reporteEventualidadesEst.zul	z-icon-angle-double-right	 	14	t
65	Evento	consultas/reporteEventoValorEsperadoRealEst.zul	z-icon-angle-double-right	 	14	t
66	Socio	consultas/reporteSociosEst.zul	z-icon-angle-double-right	 	14	t
68	Evento	consultas/reporteEventoValorEsperadoRealEst.zul.zul	z-icon-angle-double-right	 	14	t
69	Red Social	configuracion/categoria/redSocial.zul	z-icon-angle-double-right	 	8	t
70	Tipo eventualidad	configuracion/categoria/tipoEventualidad.zul	z-icon-angle-double-right	 	8	t
71	Indicador	configuracion/categoria/indicador.zul	z-icon-angle-double-right	 	8	t
72	Tipo Opinion	configuracion/categoria/tipoOpinion.zul	z-icon-angle-double-right	 	8	t
73	Tipo Pago	configuracion/categoria/tipoPago.zul	z-icon-angle-double-right	 	8	t
74	Tipo Noticia	configuracion/categoria/tipoNoticia.zul	z-icon-angle-double-right	 	8	t
75	Motivo Cancelacion	configuracion/categoria/motivoCancelacion.zul	z-icon-angle-double-right	 	8	t
76	Sugerencias	socio/buzon/sugerenciaAdministrativo.zul	z-icon-angle-double-right	 	10	t
\.


--
-- TOC entry 2760 (class 0 OID 30994)
-- Dependencies: 207
-- Data for Name: funcion_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY funcion_grupo (id_funcion_grupo, funcionid_funcion, grupoid_grupo, activo) FROM stdin;
1	33	1	t
2	34	1	t
3	35	1	t
4	39	1	t
5	40	1	t
6	41	1	t
7	43	1	t
8	51	4	t
9	52	4	t
10	53	4	t
11	33	3	t
12	34	3	t
13	49	5	t
14	55	5	t
53	44	6	t
29	30	2	f
16	17	2	t
33	37	2	t
18	19	2	t
45	58	2	t
61	76	2	t
30	31	2	t
47	60	2	t
35	42	2	t
37	46	2	t
52	65	2	t
44	57	2	t
51	64	2	t
48	61	2	t
55	70	2	t
17	18	2	t
50	63	2	t
39	48	2	t
58	73	2	t
38	47	2	t
25	26	2	t
36	45	2	t
49	62	2	t
23	24	2	t
24	25	2	t
54	68	2	t
60	75	2	t
27	28	2	t
59	74	2	t
34	38	2	t
28	29	2	t
43	66	2	t
40	50	2	t
26	27	2	t
57	72	2	t
19	20	2	t
20	21	2	t
46	59	2	t
31	32	2	t
15	16	2	t
56	71	2	t
21	22	2	t
22	23	2	t
32	36	2	t
42	56	2	t
41	54	2	t
\.


--
-- TOC entry 2945 (class 0 OID 0)
-- Dependencies: 206
-- Name: funcion_grupo_id_funcion_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_grupo_id_funcion_grupo_seq', 61, true);


--
-- TOC entry 2946 (class 0 OID 0)
-- Dependencies: 204
-- Name: funcion_id_funcion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('funcion_id_funcion_seq', 1, false);


--
-- TOC entry 2732 (class 0 OID 30843)
-- Dependencies: 179
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY grupo (id_grupo, descripcion, activo) FROM stdin;
1	Socio	t
3	Afiliado	t
4	Seguridad	t
5	Comunicador	t
6	Vigilancia	t
2	Junta	t
\.


--
-- TOC entry 2947 (class 0 OID 0)
-- Dependencies: 178
-- Name: grupo_id_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('grupo_id_grupo_seq', 6, true);


--
-- TOC entry 2826 (class 0 OID 31303)
-- Dependencies: 273
-- Data for Name: indicador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY indicador (id_indicador, descripcion, activo) FROM stdin;
1	Asistencia de Personas	t
2	Ingresos Recolectados	t
3	Utilidad	t
4	Ingresos por Incripcion a Torneos	t
5	Ingresos por Bebidas alcoholicas	t
\.


--
-- TOC entry 2828 (class 0 OID 31312)
-- Dependencies: 275
-- Data for Name: indicador_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY indicador_evento (id_indicador_evento, valor_esperado, valor_real, indicadorid_indicador, eventoid_evento, activo) FROM stdin;
2	20000	\N	4	3	t
1	100	400	1	2	t
4	100	80	3	4	t
3	25	10	1	4	t
\.


--
-- TOC entry 2948 (class 0 OID 0)
-- Dependencies: 274
-- Name: indicador_evento_id_indicador_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_evento_id_indicador_evento_seq', 1, false);


--
-- TOC entry 2949 (class 0 OID 0)
-- Dependencies: 272
-- Name: indicador_id_indicador_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('indicador_id_indicador_seq', 5, true);


--
-- TOC entry 2748 (class 0 OID 30924)
-- Dependencies: 195
-- Data for Name: instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY instalacion (id_instalacion, nombre, descripcion, capacidad, precio_alquiler, alquilable, tipo_instalacionid_tipo_instalacion, activo) FROM stdin;
1	Campo de Beisbol	espacio para la practica de beisbol	500	2000	t	1	t
2	Salon de Fiesta	Espacio para fiestas y celebraciones	150	20000	t	2	t
3	Parque Infantil	area recreacional para niÃƒÆ’Ã‚Â±os	150	2000	f	3	t
\.


--
-- TOC entry 2778 (class 0 OID 31078)
-- Dependencies: 225
-- Data for Name: instalacion_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY instalacion_evento (id_actividad_instalacion, instalacionid_instalacion, eventoid_evento, activo) FROM stdin;
1	1	3	t
2	1	4	t
\.


--
-- TOC entry 2950 (class 0 OID 0)
-- Dependencies: 224
-- Name: instalacion_evento_id_actividad_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_evento_id_actividad_instalacion_seq', 1, false);


--
-- TOC entry 2951 (class 0 OID 0)
-- Dependencies: 194
-- Name: instalacion_id_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('instalacion_id_instalacion_seq', 3, true);


--
-- TOC entry 2790 (class 0 OID 31135)
-- Dependencies: 237
-- Data for Name: junta_directiva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY junta_directiva (id_junta_directiva, clubid_club, fecha_inic, fecha_fin, activo) FROM stdin;
\.


--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 236
-- Name: junta_directiva_id_junta_directiva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('junta_directiva_id_junta_directiva_seq', 1, false);


--
-- TOC entry 2792 (class 0 OID 31144)
-- Dependencies: 239
-- Data for Name: miembro_junta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY miembro_junta (id_junta_miembro, junta_directivaid_junta_directiva, cargoid_cargo, personaid_persona, activo) FROM stdin;
\.


--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 238
-- Name: miembro_junta_id_junta_miembro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('miembro_junta_id_junta_miembro_seq', 1, false);


--
-- TOC entry 2850 (class 0 OID 31416)
-- Dependencies: 297
-- Data for Name: motivo_cancelacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_cancelacion (id_motivo_cancelacion, descripcion, activo) FROM stdin;
1	Falta de Recursos	t
2	Por Presupuestos	t
3	Actividades Imcompletas	t
\.


--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 296
-- Name: motivo_cancelacion_id_motivo_cancelacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_cancelacion_id_motivo_cancelacion_seq', 1, false);


--
-- TOC entry 2802 (class 0 OID 31189)
-- Dependencies: 249
-- Data for Name: motivo_desvinculacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_desvinculacion (id_motivo_desvinculacion, descripcion, activo) FROM stdin;
\.


--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 248
-- Name: motivo_desvinculacion_id_motivo_desvinculacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_desvinculacion_id_motivo_desvinculacion_seq', 1, false);


--
-- TOC entry 2816 (class 0 OID 31258)
-- Dependencies: 263
-- Data for Name: motivo_postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_postulacion (id_motivo_postulacion, descripcion, activo) FROM stdin;
1	Beneficios del Club	t
2	Inversión	t
3	Deporte	t
4	Osio	t
5	Recreación	t
6	Diversión	t
7	Por amor	t
\.


--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 262
-- Name: motivo_postulacion_id_motivo_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_postulacion_id_motivo_postulacion_seq', 1, false);


--
-- TOC entry 2852 (class 0 OID 31424)
-- Dependencies: 299
-- Data for Name: motivo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_sancion (id_motivo_sancion, descripcion, activo) FROM stdin;
1	Actos	t
\.


--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 298
-- Name: motivo_sancion_id_motivo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_sancion_id_motivo_sancion_seq', 1, false);


--
-- TOC entry 2818 (class 0 OID 31267)
-- Dependencies: 265
-- Data for Name: motivo_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY motivo_venta (id_motivo_venta, descripcion, activo) FROM stdin;
1	Necesidad Economica	t
2	Cambio de Ciudad	t
3	Descontento con el Club	t
\.


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 264
-- Name: motivo_venta_id_motivo_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('motivo_venta_id_motivo_venta_seq', 3, true);


--
-- TOC entry 2750 (class 0 OID 30937)
-- Dependencies: 197
-- Data for Name: noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY noticia (id_noticia, titulo, descripcion, eventoid_evento, foto, tipo_noticiaid_tipo_noticia, fecha_creacion, caducidad, publico, enlace, activo) FROM stdin;
1	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-17	2016-03-17	t	\N	t
2	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-17	2016-03-17	t	\N	t
3	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-17	2016-03-17	t	\N	t
4	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-17	2016-03-17	t	\N	t
5	Nueva Postulación	El Sr(a). Fidel Aliaga, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!	\N	http://i.imgur.com/mSJl1BZ.jpg	5	2016-03-17	2016-03-17	f	\N	t
6	 Prepárate para el 89 aniversario del Centro Atlético América	En su semana aniversario, la junta directiva, encabezada por el Dr. Víctor Montilla, se complace en invitar a todos los consocios y comunidad larense a disfrutar y compartir del programa de actividades designado.	\N	http://i.imgur.com/JNy9o9V.png	4	2016-03-18	2016-03-20	t	\N	t
7	Jornadas Infociencias XXXII	 La 32 edición de las Jornadas de Infociencias de la Universidad Centroccidental Lisandro Alvarado, se realizará el día 6 de Abril del presente año en las instalaciones del Decanato de Ciencias y Tecnología, núcleo Obelisco, donde se darán a conocer cuatro proyectos informáticos creados por los estudiantes de Ingeniería en Informática	\N	http://i.imgur.com/JNy9o9V.png	3	2016-03-18	2016-03-20	t	\N	t
8	Nueva Postulación	El Sr(a). Ruben Vivas, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!	\N	http://i.imgur.com/ycCM1PJ.jpg	5	2016-03-18	2016-03-18	f	\N	t
9	Torneo de Beisbol	Disfruta del Torneo de Beisbol	\N	localhost:8080/america/assets/img/default-placeholder.png	1	2016-03-18	2016-03-19	f	\N	t
10	Evento Hilder	Este un evento con la noticia corregida	3	localhost:8080/america/assets/img/default-placeholder.png	1	2016-03-25	2016-04-01	t	\N	t
11	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-18	2016-03-18	t	\N	t
12	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-18	2016-03-18	t	\N	t
13	Nueva Postulación	El Sr(a). Mariangel Arrieche, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!	\N	http://i.imgur.com/8t2CuRs.png	5	2016-03-18	2016-03-18	f	\N	t
14	Nueva Postulación	El Sr(a). Romulo Dominguez, se ha postulado para pertenecer a la familia americanista. Opina sobre el en nuestra sección de opiniones postulantes!	\N	http://i.imgur.com/duCXybQ.jpg	5	2016-03-18	2016-03-18	f	\N	t
15	parrilla osullivan	evento  para quitar la presion de los desarrolladores del club america	4	localhost:8080/america/assets/img/default-placeholder.png	1	2016-03-20	2016-03-21	f	\N	t
16	Acción en Venta	¡Se a aperturado el proceso de postulación para una acción en venta!	\N	\N	2	2016-03-18	2016-03-18	t	\N	t
\.


--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 196
-- Name: noticia_id_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_id_noticia_seq', 7, true);


--
-- TOC entry 2800 (class 0 OID 31180)
-- Dependencies: 247
-- Data for Name: noticia_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY noticia_preferencia (id_noticia_preferencia, preferenciaid_preferencia, noticiaid_noticia, activo) FROM stdin;
\.


--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 246
-- Name: noticia_preferencia_id_noticia_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('noticia_preferencia_id_noticia_preferencia_seq', 1, false);


--
-- TOC entry 2744 (class 0 OID 30900)
-- Dependencies: 191
-- Data for Name: opinion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY opinion (id_opinion, postulacionid_postulacion, descripcion, usuarioid_usuario, fecha, calificacion, tipo_opnionid_tipo_opninion, activo) FROM stdin;
1	1	Es Confiable	4	2016-03-18 00:04:46.067	3	1	t
2	1	Es borracho	2	2016-03-18 00:10:48.24	1	2	t
3	2	Es honesto	4	2016-03-18 06:54:36.078	4	1	t
4	3	Tiene malas juntas	4	2016-03-18 10:41:48.263	1	2	t
5	4	Es amistoso	4	2016-03-18 11:53:47.078	4	1	t
\.


--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 190
-- Name: opinion_id_opinion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('opinion_id_opinion_seq', 1, false);


--
-- TOC entry 2734 (class 0 OID 30852)
-- Dependencies: 181
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona (id_persona, identificacion, nombre, apellido, foto, fecha_nac, sexo, correo, telefono, telefono_fijo, direccion, activo) FROM stdin;
9	21140247	Mariangel	Arrieche	http://i.imgur.com/8t2CuRs.png	1980-03-18	F	mariangel@gmail.com	0416555555	02412222222	barquisimeto	f
15	7878186682	jhdjdjh	kjdjdkkjds	\N	1989-08-18	F	j@h.c	78389327	\N	hkdhkdshds	t
12	43353553	Maria	Rosario	\N	1976-09-24	F	maria@gmail.com	04243131311	\N	Prados del Golf III, Cabudare	t
11	11593903	Romulo	Dominguez	http://i.imgur.com/duCXybQ.jpg	1972-03-03	M	rdominguez@gmail.com	04168765555	02512557654	Pardos del Glof III Cabudare	t
10	373932737	Roman	Arrieche	http://i.imgur.com/krJ9S4R.png	1992-03-18	M	roman@gmail.com	041255555	\N	Barquisimeto	t
4	55555555	Manuel	Guerrero	http://i.imgur.com/xXp0wXP.png	1983-06-01	M	manuel@gmail.com	04147658877	02516548265	Carrera 25 con calle 12	t
1	20387728	Enmanuel	Medina	\N	1980-03-01	M	enmanuelm19@gmail.com	04146549874	02516548765	Cabudare	t
2	12345678	Carlos	Amaro	\N	1981-04-01	M	carlos@gmail.com	04249876668	02513348765	Barquisimeto	t
3	11111111	Juan	Petaquero	\N	1982-05-01	M	juan@gmail.com	04127896654	02516548705	Valle Hondo, Cabudare	t
5	33333333	Sergio	Hernandez	\N	1983-07-01	M	sergio@hotmail.com	04167779788	02516540965	Av Libertador con calle 12	t
6	99999999	Pedro	Camacaro	\N	1984-08-01	M	pedrocamacaro@gmail.com	04263423433	0255657432	Santa Isabel, Avenida 4	t
7	22186230	Fidel	Aliaga	http://i.imgur.com/mSJl1BZ.jpg	1985-03-17	M	fidel.alejos@gmail.com	04263237394	02512553545	Barquisimeto	f
8	19648893	Ruben	Vivas	http://i.imgur.com/ycCM1PJ.jpg	1991-09-13	M	rvivas89@gmail.com	04165438877	02513456566	Urbanización Las Trinitarias2	f
\.


--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 180
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('persona_id_persona_seq', 6, true);


--
-- TOC entry 2788 (class 0 OID 31126)
-- Dependencies: 235
-- Data for Name: politica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY politica (id_politica, descripcion, valor, clubid_club, activo) FROM stdin;
1	Personas que puede traer un socio por visita diaria	3	1	t
2	Veces que puede traer a un mismo invitado al mes	3	1	t
\.


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 234
-- Name: politica_id_politica_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('politica_id_politica_seq', 1, false);


--
-- TOC entry 2842 (class 0 OID 31378)
-- Dependencies: 289
-- Data for Name: portal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY portal (id_portal, instalacion, socio, evento, activo, foto_socio, foto_instalaciones, foto_evento) FROM stdin;
1	El Centro Atlético America cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Además cuenta con un salón de Fiestas y dos Caneis para el disfrute de sus socios e invitados	Nuestros socios se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de club. ¿Quieres ser un socio del Centro Atlético America?	Nos interesa Motivar la interacción social a través de actividades culturales de intercambio en busca del crecimiento humano mediante la realización de eventos. ¿Quieres participar en nuestros eventos?	t	http://i.imgur.com/lCSPRiL.png	http://i.imgur.com/ccWOi9A.png	http://i.imgur.com/KBRnFaM.png
\.


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 288
-- Name: portal_id_portal_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('portal_id_portal_seq', 1, false);


--
-- TOC entry 2742 (class 0 OID 30891)
-- Dependencies: 189
-- Data for Name: postulacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY postulacion (id_postulacion, postuladoid_postulado, fecha, carnet_padrino1, carnet_padrino2, motivo_postulacionid_motivo_postulacion, aprobado, activo) FROM stdin;
1	1	2016-03-17	B-0339	B-0342	1	t	f
2	2	2016-03-18	B-0341	B-0342	2	t	f
3	3	2016-03-18	B-0342	B-0340	2	t	f
4	4	2016-03-18	B-0341	B-0340	1	t	f
\.


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 188
-- Name: postulacion_id_postulacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulacion_id_postulacion_seq', 1, false);


--
-- TOC entry 2770 (class 0 OID 31039)
-- Dependencies: 217
-- Data for Name: postulado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY postulado (id_postulado, personaid_persona, activo) FROM stdin;
1	7	t
2	8	t
3	9	t
4	11	t
\.


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 216
-- Name: postulado_id_postulado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('postulado_id_postulado_seq', 1, false);


--
-- TOC entry 2768 (class 0 OID 31030)
-- Dependencies: 215
-- Data for Name: preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preferencia (id_preferencia, descripcion, tipo_preferenciaid_tipo_preferencia, activo) FROM stdin;
1	Beisbol	1	t
2	Tenis	1	t
3	Futbol	1	t
4	Baloncesto	1	t
5	Danza	2	t
6	Canto	2	t
7	Musica	2	t
8	Protección Animal	3	t
9	Ambiente	3	t
\.


--
-- TOC entry 2808 (class 0 OID 31219)
-- Dependencies: 255
-- Data for Name: preferencia_evento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preferencia_evento (id_preferencia_evento, eventoid_evento, preferenciaid_preferencia, activo) FROM stdin;
1	3	1	t
2	4	1	t
\.


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 254
-- Name: preferencia_evento_id_preferencia_evento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_evento_id_preferencia_evento_seq', 1, false);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 214
-- Name: preferencia_id_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_id_preferencia_seq', 1, false);


--
-- TOC entry 2776 (class 0 OID 31069)
-- Dependencies: 223
-- Data for Name: preferencia_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY preferencia_persona (id_preferencia_persona, preferenciaid_preferencia, personaid_persona, activo) FROM stdin;
1	1	7	t
3	3	7	t
2	8	7	t
6	8	8	t
7	2	8	t
10	2	9	t
9	6	9	t
8	5	9	t
11	7	10	t
12	3	10	t
14	3	11	t
13	1	11	t
15	7	11	t
16	6	11	t
17	7	12	t
18	1	12	t
19	6	15	t
4	5	4	t
5	8	4	t
\.


--
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 222
-- Name: preferencia_persona_id_preferencia_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('preferencia_persona_id_preferencia_persona_seq', 1, false);


--
-- TOC entry 2780 (class 0 OID 31087)
-- Dependencies: 227
-- Data for Name: recurso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recurso (id_recurso, descripcion, activo) FROM stdin;
1	Silla	t
2	Mesa	t
3	Parrillera	t
4	Vasos	t
5	Cubiertos	t
6	Lamparas	t
\.


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 226
-- Name: recurso_id_recurso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_id_recurso_seq', 1, false);


--
-- TOC entry 2784 (class 0 OID 31108)
-- Dependencies: 231
-- Data for Name: recurso_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY recurso_instalacion (id_recurso_instalacion, instalacionid_instalacion, recursoid_recurso, cantidad, activo) FROM stdin;
\.


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 230
-- Name: recurso_instalacion_id_recurso_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('recurso_instalacion_id_recurso_instalacion_seq', 1, false);


--
-- TOC entry 2812 (class 0 OID 31240)
-- Dependencies: 259
-- Data for Name: red_club; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY red_club (id_red_club, clubid_club, red_socialid_red_social, enlace, activo) FROM stdin;
\.


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 258
-- Name: red_club_id_red_club_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_club_id_red_club_seq', 1, false);


--
-- TOC entry 2814 (class 0 OID 31249)
-- Dependencies: 261
-- Data for Name: red_persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY red_persona (id_red_persona, enlace, red_socialid_red_social, personaid_persona, activo) FROM stdin;
\.


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 260
-- Name: red_persona_id_red_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_persona_id_red_persona_seq', 1, false);


--
-- TOC entry 2810 (class 0 OID 31228)
-- Dependencies: 257
-- Data for Name: red_social; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY red_social (id_red_social, descripcion, imagen, activo) FROM stdin;
\.


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 256
-- Name: red_social_id_red_social_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('red_social_id_red_social_seq', 1, false);


--
-- TOC entry 2762 (class 0 OID 31003)
-- Dependencies: 209
-- Data for Name: reservacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY reservacion (id_reservacion, instalacionid_instalacion, socioid_socio, fecha_inicio, fecha_fin, condicion, activo) FROM stdin;
1	1	4	2016-03-22 15:00:00	2016-03-24 19:00:00	A                                                                                                                                                                                                                                                              	t
2	2	4	2016-03-18 00:00:00	2016-03-20 00:00:00	A                                                                                                                                                                                                                                                              	t
\.


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 208
-- Name: reservacion_id_reservacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('reservacion_id_reservacion_seq', 1, false);


--
-- TOC entry 2736 (class 0 OID 30864)
-- Dependencies: 183
-- Data for Name: sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sancion (id_sancion, descripcion, socioid_socio, afiliadoid_afilado, fecha_inic, fecha_fin, monto, eventualidadid_eventualidad, motivo_sancionid_motivo_sancion, tipo_sancionid_tipo_sancion, activo) FROM stdin;
1	Debe 3 cuotas	8	\N	\N	\N	10000	\N	\N	1	t
2	Debe 5 cuaotas	3	\N	2016-03-18	2016-03-21	\N	\N	\N	1	t
3	Debe cuotas	4	\N	2016-03-18	2016-03-21	\N	\N	\N	1	t
4	Suspendido por cuotas	10	\N	2016-03-18	2016-03-21	\N	\N	\N	1	t
\.


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 182
-- Name: sancion_id_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sancion_id_sancion_seq', 1, false);


--
-- TOC entry 2738 (class 0 OID 30873)
-- Dependencies: 185
-- Data for Name: socio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY socio (id_socio, postulacionid_postulacion, nro_carnet, personaid_persona, activo) FROM stdin;
1	\N	B-0338	1	t
2	\N	B-0339	2	t
3	\N	B-0340	3	t
4	\N	B-0341	4	t
5	\N	B-0342	5	t
6	\N	B-0343	6	t
7	1	B-0344	7	t
8	2	B-0349	8	t
9	3	B-0330	9	t
10	4	B-0350	11	t
\.


--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 184
-- Name: socio_id_socio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('socio_id_socio_seq', 6, true);


--
-- TOC entry 2830 (class 0 OID 31321)
-- Dependencies: 277
-- Data for Name: solicitud_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY solicitud_venta (id_solicitud_venta, accionid_accion, motivo, fecha, motivo_ventaid_motivo_venta, activo) FROM stdin;
\.


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 276
-- Name: solicitud_venta_id_solicitud_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('solicitud_venta_id_solicitud_venta_seq', 1, false);


--
-- TOC entry 2782 (class 0 OID 31096)
-- Dependencies: 229
-- Data for Name: sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sugerencia (id_sugerencia, descripcion, fecha, usuarioid_usuario, cliente_externoid_cliente, tipo_sugerenciaid_tipo_sugerencia, activo) FROM stdin;
1	¿Cuándo seran las postulaciones?	2016-03-18 00:24:56.258	\N	1	1	t
2	Deberian de habilitar las postulaciones	2016-03-18 10:14:12.87	\N	2	2	t
\.


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 228
-- Name: sugerencia_id_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sugerencia_id_sugerencia_seq', 1, false);


--
-- TOC entry 2806 (class 0 OID 31207)
-- Dependencies: 253
-- Data for Name: tipo_afiliado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_afiliado (id_tipo_afiliado, descripcion, subfijo, activo) FROM stdin;
1	Esposa	-1	t
2	Hijo	-2	t
\.


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 252
-- Name: tipo_afiliado_id_tipo_afiliado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_afiliado_id_tipo_afiliado_seq', 1, false);


--
-- TOC entry 2838 (class 0 OID 31360)
-- Dependencies: 285
-- Data for Name: tipo_archivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_archivo (id_tipo_archivo, nombre, activo) FROM stdin;
\.


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 284
-- Name: tipo_archivo_id_tipo_archivo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_archivo_id_tipo_archivo_seq', 1, false);


--
-- TOC entry 2832 (class 0 OID 31333)
-- Dependencies: 279
-- Data for Name: tipo_eventualidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_eventualidad (id_tipo_eventualidad, descripcion, activo) FROM stdin;
1	Pelea	t
2	Daños propiedad	t
3	Acto inmoral	t
\.


--
-- TOC entry 2982 (class 0 OID 0)
-- Dependencies: 278
-- Name: tipo_eventualidad_id_tipo_eventualidad_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_eventualidad_id_tipo_eventualidad_seq', 1, false);


--
-- TOC entry 2854 (class 0 OID 31433)
-- Dependencies: 301
-- Data for Name: tipo_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_instalacion (id_tipo_instalacion, descripcion, activo) FROM stdin;
2	Fiesta	t
3	Infantil	t
1	Deportiva	t
\.


--
-- TOC entry 2983 (class 0 OID 0)
-- Dependencies: 300
-- Name: tipo_instalacion_id_tipo_instalacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_instalacion_id_tipo_instalacion_seq', 3, true);


--
-- TOC entry 2840 (class 0 OID 31369)
-- Dependencies: 287
-- Data for Name: tipo_noticia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_noticia (id_tipo_noticia, descripcion, color, activo) FROM stdin;
1	Evento	#FF0000	t
2	Acciones	#FFFF00	t
3	Sucesos	#A52A2A	t
4	Otros	#FFA500	t
5	Postulación	#339966	t
\.


--
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 286
-- Name: tipo_noticia_id_tipo_noticia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_noticia_id_tipo_noticia_seq', 4, true);


--
-- TOC entry 2846 (class 0 OID 31398)
-- Dependencies: 293
-- Data for Name: tipo_opnion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_opnion (id_tipo_opninion, descripcion, activo) FROM stdin;
1	Lo Recomiendo	t
2	No lo recomiendo	t
3	No lo conozco	t
\.


--
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 292
-- Name: tipo_opnion_id_tipo_opninion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_opnion_id_tipo_opninion_seq', 1, false);


--
-- TOC entry 2844 (class 0 OID 31390)
-- Dependencies: 291
-- Data for Name: tipo_pago; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_pago (id_tipo_pago, descripcion, activo) FROM stdin;
1	Efectivo	t
2	Debito	t
3	Transferencia	t
\.


--
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 290
-- Name: tipo_pago_id_tipo_pago_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_pago_id_tipo_pago_seq', 1, false);


--
-- TOC entry 2798 (class 0 OID 31171)
-- Dependencies: 245
-- Data for Name: tipo_preferencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_preferencia (id_tipo_preferencia, descripcion, color, activo) FROM stdin;
1	Deportiva	#0099cc	t
2	Cultural	#cc33cc	t
3	Social	#009966	t
\.


--
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 244
-- Name: tipo_preferencia_id_tipo_preferencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_preferencia_id_tipo_preferencia_seq', 1, false);


--
-- TOC entry 2848 (class 0 OID 31407)
-- Dependencies: 295
-- Data for Name: tipo_sancion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_sancion (id_tipo_sancion, descripcion, activo) FROM stdin;
1	Morosidad	t
2	Eventualidad	t
\.


--
-- TOC entry 2988 (class 0 OID 0)
-- Dependencies: 294
-- Name: tipo_sancion_id_tipo_sancion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sancion_id_tipo_sancion_seq', 1, false);


--
-- TOC entry 2796 (class 0 OID 31162)
-- Dependencies: 243
-- Data for Name: tipo_sugerencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_sugerencia (id_tipo_sugerencia, descripcion, activo) FROM stdin;
1	Pregunta	t
2	Sugerencia	t
3	Comentario	t
4	Queja	t
5	Reclamo	t
\.


--
-- TOC entry 2989 (class 0 OID 0)
-- Dependencies: 242
-- Name: tipo_sugerencia_id_tipo_sugerencia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_sugerencia_id_tipo_sugerencia_seq', 1, false);


--
-- TOC entry 2726 (class 0 OID 30813)
-- Dependencies: 173
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id_usuario, contrasenna, username, pregunta, respuesta, personaid_persona, fecha, activo) FROM stdin;
1	12345678	enmanuel	Â¿Quien?	Capitan garfio en la cocina	1	2016-02-22	t
2	12345678	carlos	Â¿Quien?	Capitan garfio en la cocina	2	2016-02-22	t
3	12345678	juan	Â¿Quien?	Capitan garfio en la cocina	3	2016-02-22	t
5	12345678	sergio	Â¿Quien?	Capitan garfio en la cocina	5	2016-02-22	t
6	12345678	pedro	Â¿Quien?	Capitan garfio en la cocina	6	2016-02-22	t
4	12345678	manuel	Â¿Quien?	Capitan garfio en la cocina	4	2016-02-22	t
\.


--
-- TOC entry 2730 (class 0 OID 30834)
-- Dependencies: 177
-- Data for Name: usuario_grupo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario_grupo (id_usuario_grupo, usuarioid_usuario, grupoid_grupo, activo) FROM stdin;
2	1	6	t
4	1	5	t
5	1	4	t
6	1	2	t
7	1	3	t
3	2	1	t
1	4	1	t
\.


--
-- TOC entry 2990 (class 0 OID 0)
-- Dependencies: 176
-- Name: usuario_grupo_id_usuario_grupo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_grupo_id_usuario_grupo_seq', 7, true);


--
-- TOC entry 2991 (class 0 OID 0)
-- Dependencies: 172
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 6, true);


--
-- TOC entry 2774 (class 0 OID 31060)
-- Dependencies: 221
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY venta (id_venta, accionid_accion, postulacionid_postulacion, fecha, monto, activo) FROM stdin;
\.


--
-- TOC entry 2992 (class 0 OID 0)
-- Dependencies: 220
-- Name: venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('venta_id_venta_seq', 1, false);


--
-- TOC entry 2425 (class 2606 OID 30888)
-- Name: accion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY accion
    ADD CONSTRAINT accion_pkey PRIMARY KEY (id_accion);


--
-- TOC entry 2441 (class 2606 OID 30979)
-- Name: actividad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT actividad_pkey PRIMARY KEY (id_actividad);


--
-- TOC entry 2449 (class 2606 OID 31018)
-- Name: afiliado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY afiliado
    ADD CONSTRAINT afiliado_pkey PRIMARY KEY (id_afilado);


--
-- TOC entry 2471 (class 2606 OID 31123)
-- Name: alquiler_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY alquiler
    ADD CONSTRAINT alquiler_pkey PRIMARY KEY (id_alquiler);


--
-- TOC entry 2521 (class 2606 OID 31357)
-- Name: archivo_alquiler_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY archivo_alquiler
    ADD CONSTRAINT archivo_alquiler_pkey PRIMARY KEY (id_archivo_alquiler);


--
-- TOC entry 2505 (class 2606 OID 31282)
-- Name: archivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY archivo
    ADD CONSTRAINT archivo_pkey PRIMARY KEY (id_archivo);


--
-- TOC entry 2437 (class 2606 OID 30958)
-- Name: calendario_fecha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY calendario_fecha
    ADD CONSTRAINT calendario_fecha_pkey PRIMARY KEY (id_calendario_fecha);


--
-- TOC entry 2509 (class 2606 OID 31300)
-- Name: cancelacion_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cancelacion_evento
    ADD CONSTRAINT cancelacion_evento_pkey PRIMARY KEY (id_cancelacion_evento);


--
-- TOC entry 2479 (class 2606 OID 31159)
-- Name: cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id_cargo);


--
-- TOC entry 2427 (class 2606 OID 30897)
-- Name: carnet_padrino1; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY postulacion
    ADD CONSTRAINT carnet_padrino1 PRIMARY KEY (id_postulacion);


--
-- TOC entry 2451 (class 2606 OID 31027)
-- Name: cliente_externo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente_externo
    ADD CONSTRAINT cliente_externo_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 2413 (class 2606 OID 30831)
-- Name: club_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY club
    ADD CONSTRAINT club_pkey PRIMARY KEY (id_club);


--
-- TOC entry 2457 (class 2606 OID 31057)
-- Name: desvinculacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY desvinculacion
    ADD CONSTRAINT desvinculacion_pkey PRIMARY KEY (id_desvinculacion);


--
-- TOC entry 2519 (class 2606 OID 31348)
-- Name: estado_accion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estado_accion
    ADD CONSTRAINT estado_accion_pkey PRIMARY KEY (id_estado_accion);


--
-- TOC entry 2507 (class 2606 OID 31291)
-- Name: estado_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estado_evento
    ADD CONSTRAINT estado_evento_pkey PRIMARY KEY (id_estado_evento);


--
-- TOC entry 2439 (class 2606 OID 30970)
-- Name: evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY evento
    ADD CONSTRAINT evento_pkey PRIMARY KEY (id_evento);


--
-- TOC entry 2431 (class 2606 OID 30921)
-- Name: eventualidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY eventualidad
    ADD CONSTRAINT eventualidad_pkey PRIMARY KEY (id_eventualidad);


--
-- TOC entry 2489 (class 2606 OID 31204)
-- Name: foto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY foto
    ADD CONSTRAINT foto_pkey PRIMARY KEY (id_foto);


--
-- TOC entry 2445 (class 2606 OID 31000)
-- Name: funcion_grupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY funcion_grupo
    ADD CONSTRAINT funcion_grupo_pkey PRIMARY KEY (id_funcion_grupo);


--
-- TOC entry 2443 (class 2606 OID 30991)
-- Name: funcion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY funcion
    ADD CONSTRAINT funcion_pkey PRIMARY KEY (id_funcion);


--
-- TOC entry 2417 (class 2606 OID 30849)
-- Name: grupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (id_grupo);


--
-- TOC entry 2513 (class 2606 OID 31318)
-- Name: indicador_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador_evento
    ADD CONSTRAINT indicador_evento_pkey PRIMARY KEY (id_indicador_evento);


--
-- TOC entry 2511 (class 2606 OID 31309)
-- Name: indicador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY indicador
    ADD CONSTRAINT indicador_pkey PRIMARY KEY (id_indicador);


--
-- TOC entry 2463 (class 2606 OID 31084)
-- Name: instalacion_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instalacion_evento
    ADD CONSTRAINT instalacion_evento_pkey PRIMARY KEY (id_actividad_instalacion);


--
-- TOC entry 2433 (class 2606 OID 30934)
-- Name: instalacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT instalacion_pkey PRIMARY KEY (id_instalacion);


--
-- TOC entry 2475 (class 2606 OID 31141)
-- Name: junta_directiva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY junta_directiva
    ADD CONSTRAINT junta_directiva_pkey PRIMARY KEY (id_junta_directiva);


--
-- TOC entry 2477 (class 2606 OID 31150)
-- Name: miembro_junta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY miembro_junta
    ADD CONSTRAINT miembro_junta_pkey PRIMARY KEY (id_junta_miembro);


--
-- TOC entry 2535 (class 2606 OID 31421)
-- Name: motivo_cancelacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_cancelacion
    ADD CONSTRAINT motivo_cancelacion_pkey PRIMARY KEY (id_motivo_cancelacion);


--
-- TOC entry 2487 (class 2606 OID 31195)
-- Name: motivo_desvinculacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_desvinculacion
    ADD CONSTRAINT motivo_desvinculacion_pkey PRIMARY KEY (id_motivo_desvinculacion);


--
-- TOC entry 2501 (class 2606 OID 31264)
-- Name: motivo_postulacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_postulacion
    ADD CONSTRAINT motivo_postulacion_pkey PRIMARY KEY (id_motivo_postulacion);


--
-- TOC entry 2537 (class 2606 OID 31430)
-- Name: motivo_sancion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_sancion
    ADD CONSTRAINT motivo_sancion_pkey PRIMARY KEY (id_motivo_sancion);


--
-- TOC entry 2503 (class 2606 OID 31273)
-- Name: motivo_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY motivo_venta
    ADD CONSTRAINT motivo_venta_pkey PRIMARY KEY (id_motivo_venta);


--
-- TOC entry 2435 (class 2606 OID 30946)
-- Name: noticia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY noticia
    ADD CONSTRAINT noticia_pkey PRIMARY KEY (id_noticia);


--
-- TOC entry 2485 (class 2606 OID 31186)
-- Name: noticia_preferencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY noticia_preferencia
    ADD CONSTRAINT noticia_preferencia_pkey PRIMARY KEY (id_noticia_preferencia);


--
-- TOC entry 2429 (class 2606 OID 30909)
-- Name: opinion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY opinion
    ADD CONSTRAINT opinion_pkey PRIMARY KEY (id_opinion);


--
-- TOC entry 2419 (class 2606 OID 30861)
-- Name: persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id_persona);


--
-- TOC entry 2473 (class 2606 OID 31132)
-- Name: politica_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY politica
    ADD CONSTRAINT politica_pkey PRIMARY KEY (id_politica);


--
-- TOC entry 2527 (class 2606 OID 31387)
-- Name: portal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY portal
    ADD CONSTRAINT portal_pkey PRIMARY KEY (id_portal);


--
-- TOC entry 2455 (class 2606 OID 31045)
-- Name: postulado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY postulado
    ADD CONSTRAINT postulado_pkey PRIMARY KEY (id_postulado);


--
-- TOC entry 2493 (class 2606 OID 31225)
-- Name: preferencia_evento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY preferencia_evento
    ADD CONSTRAINT preferencia_evento_pkey PRIMARY KEY (id_preferencia_evento);


--
-- TOC entry 2461 (class 2606 OID 31075)
-- Name: preferencia_persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY preferencia_persona
    ADD CONSTRAINT preferencia_persona_pkey PRIMARY KEY (id_preferencia_persona);


--
-- TOC entry 2453 (class 2606 OID 31036)
-- Name: preferencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY preferencia
    ADD CONSTRAINT preferencia_pkey PRIMARY KEY (id_preferencia);


--
-- TOC entry 2469 (class 2606 OID 31114)
-- Name: recurso_instalacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recurso_instalacion
    ADD CONSTRAINT recurso_instalacion_pkey PRIMARY KEY (id_recurso_instalacion);


--
-- TOC entry 2465 (class 2606 OID 31093)
-- Name: recurso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY recurso
    ADD CONSTRAINT recurso_pkey PRIMARY KEY (id_recurso);


--
-- TOC entry 2497 (class 2606 OID 31246)
-- Name: red_club_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY red_club
    ADD CONSTRAINT red_club_pkey PRIMARY KEY (id_red_club);


--
-- TOC entry 2499 (class 2606 OID 31255)
-- Name: red_persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY red_persona
    ADD CONSTRAINT red_persona_pkey PRIMARY KEY (id_red_persona);


--
-- TOC entry 2495 (class 2606 OID 31237)
-- Name: red_social_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY red_social
    ADD CONSTRAINT red_social_pkey PRIMARY KEY (id_red_social);


--
-- TOC entry 2447 (class 2606 OID 31009)
-- Name: reservacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY reservacion
    ADD CONSTRAINT reservacion_pkey PRIMARY KEY (id_reservacion);


--
-- TOC entry 2421 (class 2606 OID 30870)
-- Name: sancion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT sancion_pkey PRIMARY KEY (id_sancion);


--
-- TOC entry 2423 (class 2606 OID 30879)
-- Name: socio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY socio
    ADD CONSTRAINT socio_pkey PRIMARY KEY (id_socio);


--
-- TOC entry 2515 (class 2606 OID 31330)
-- Name: solicitud_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY solicitud_venta
    ADD CONSTRAINT solicitud_venta_pkey PRIMARY KEY (id_solicitud_venta);


--
-- TOC entry 2467 (class 2606 OID 31105)
-- Name: sugerencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sugerencia
    ADD CONSTRAINT sugerencia_pkey PRIMARY KEY (id_sugerencia);


--
-- TOC entry 2491 (class 2606 OID 31216)
-- Name: tipo_afiliado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_afiliado
    ADD CONSTRAINT tipo_afiliado_pkey PRIMARY KEY (id_tipo_afiliado);


--
-- TOC entry 2523 (class 2606 OID 31366)
-- Name: tipo_archivo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_archivo
    ADD CONSTRAINT tipo_archivo_pkey PRIMARY KEY (id_tipo_archivo);


--
-- TOC entry 2517 (class 2606 OID 31339)
-- Name: tipo_eventualidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_eventualidad
    ADD CONSTRAINT tipo_eventualidad_pkey PRIMARY KEY (id_tipo_eventualidad);


--
-- TOC entry 2539 (class 2606 OID 31439)
-- Name: tipo_instalacion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_instalacion
    ADD CONSTRAINT tipo_instalacion_pkey PRIMARY KEY (id_tipo_instalacion);


--
-- TOC entry 2525 (class 2606 OID 31375)
-- Name: tipo_noticia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_noticia
    ADD CONSTRAINT tipo_noticia_pkey PRIMARY KEY (id_tipo_noticia);


--
-- TOC entry 2531 (class 2606 OID 31404)
-- Name: tipo_opnion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_opnion
    ADD CONSTRAINT tipo_opnion_pkey PRIMARY KEY (id_tipo_opninion);


--
-- TOC entry 2529 (class 2606 OID 31395)
-- Name: tipo_pago_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_pago
    ADD CONSTRAINT tipo_pago_pkey PRIMARY KEY (id_tipo_pago);


--
-- TOC entry 2483 (class 2606 OID 31177)
-- Name: tipo_preferencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_preferencia
    ADD CONSTRAINT tipo_preferencia_pkey PRIMARY KEY (id_tipo_preferencia);


--
-- TOC entry 2533 (class 2606 OID 31413)
-- Name: tipo_sancion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_sancion
    ADD CONSTRAINT tipo_sancion_pkey PRIMARY KEY (id_tipo_sancion);


--
-- TOC entry 2481 (class 2606 OID 31168)
-- Name: tipo_sugerencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_sugerencia
    ADD CONSTRAINT tipo_sugerencia_pkey PRIMARY KEY (id_tipo_sugerencia);


--
-- TOC entry 2415 (class 2606 OID 30840)
-- Name: usuario_grupo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario_grupo
    ADD CONSTRAINT usuario_grupo_pkey PRIMARY KEY (id_usuario_grupo);


--
-- TOC entry 2411 (class 2606 OID 30819)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 2459 (class 2606 OID 31066)
-- Name: venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_pkey PRIMARY KEY (id_venta);


--
-- TOC entry 2551 (class 2606 OID 31725)
-- Name: fkaccion803928; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY accion
    ADD CONSTRAINT fkaccion803928 FOREIGN KEY (estado_accionid_estado_accion) REFERENCES estado_accion(id_estado_accion);


--
-- TOC entry 2550 (class 2606 OID 31495)
-- Name: fkaccion88177; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY accion
    ADD CONSTRAINT fkaccion88177 FOREIGN KEY (socioid_socio) REFERENCES socio(id_socio);


--
-- TOC entry 2567 (class 2606 OID 31690)
-- Name: fkactividad322003; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY actividad
    ADD CONSTRAINT fkactividad322003 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2574 (class 2606 OID 31625)
-- Name: fkafiliado278652; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afiliado
    ADD CONSTRAINT fkafiliado278652 FOREIGN KEY (tipo_afiliadoid_tipo_afiliado) REFERENCES tipo_afiliado(id_tipo_afiliado);


--
-- TOC entry 2573 (class 2606 OID 31535)
-- Name: fkafiliado416; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afiliado
    ADD CONSTRAINT fkafiliado416 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2572 (class 2606 OID 31525)
-- Name: fkafiliado425484; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY afiliado
    ADD CONSTRAINT fkafiliado425484 FOREIGN KEY (socioid_socio) REFERENCES socio(id_socio);


--
-- TOC entry 2592 (class 2606 OID 31765)
-- Name: fkalquiler655186; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alquiler
    ADD CONSTRAINT fkalquiler655186 FOREIGN KEY (tipo_pagoid_tipo_pago) REFERENCES tipo_pago(id_tipo_pago);


--
-- TOC entry 2591 (class 2606 OID 31570)
-- Name: fkalquiler792396; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY alquiler
    ADD CONSTRAINT fkalquiler792396 FOREIGN KEY (reservacionid_reservacion) REFERENCES reservacion(id_reservacion);


--
-- TOC entry 2615 (class 2606 OID 31740)
-- Name: fkarchivo_al163068; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY archivo_alquiler
    ADD CONSTRAINT fkarchivo_al163068 FOREIGN KEY (tipo_archivoid_tipo_archivo) REFERENCES tipo_archivo(id_tipo_archivo);


--
-- TOC entry 2614 (class 2606 OID 31735)
-- Name: fkarchivo_al266100; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY archivo_alquiler
    ADD CONSTRAINT fkarchivo_al266100 FOREIGN KEY (alquilerid_alquiler) REFERENCES alquiler(id_alquiler);


--
-- TOC entry 2613 (class 2606 OID 31730)
-- Name: fkarchivo_al422819; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY archivo_alquiler
    ADD CONSTRAINT fkarchivo_al422819 FOREIGN KEY (archivoid_archivo) REFERENCES archivo(id_archivo);


--
-- TOC entry 2564 (class 2606 OID 31785)
-- Name: fkcalendario317419; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendario_fecha
    ADD CONSTRAINT fkcalendario317419 FOREIGN KEY (reservacionid_reservacion) REFERENCES reservacion(id_reservacion);


--
-- TOC entry 2563 (class 2606 OID 31780)
-- Name: fkcalendario334586; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY calendario_fecha
    ADD CONSTRAINT fkcalendario334586 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2608 (class 2606 OID 31795)
-- Name: fkcancelacio877481; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cancelacion_evento
    ADD CONSTRAINT fkcancelacio877481 FOREIGN KEY (motivo_cancelacionid_motivo_cancelacion) REFERENCES motivo_cancelacion(id_motivo_cancelacion);


--
-- TOC entry 2577 (class 2606 OID 31505)
-- Name: fkdesvincula306726; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desvinculacion
    ADD CONSTRAINT fkdesvincula306726 FOREIGN KEY (accionid_accion) REFERENCES accion(id_accion);


--
-- TOC entry 2578 (class 2606 OID 31540)
-- Name: fkdesvincula576211; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desvinculacion
    ADD CONSTRAINT fkdesvincula576211 FOREIGN KEY (socioid_socio) REFERENCES socio(id_socio);


--
-- TOC entry 2579 (class 2606 OID 31615)
-- Name: fkdesvincula942861; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY desvinculacion
    ADD CONSTRAINT fkdesvincula942861 FOREIGN KEY (motivo_desvinculacionid_motivo_desvinculacion) REFERENCES motivo_desvinculacion(id_motivo_desvinculacion);


--
-- TOC entry 2565 (class 2606 OID 31685)
-- Name: fkevento600923; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY evento
    ADD CONSTRAINT fkevento600923 FOREIGN KEY (estado_eventoid_estado_evento) REFERENCES estado_evento(id_estado_evento);


--
-- TOC entry 2566 (class 2606 OID 31800)
-- Name: fkevento717938; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY evento
    ADD CONSTRAINT fkevento717938 FOREIGN KEY (cancelacion_eventoid_cancelacion_evento) REFERENCES cancelacion_evento(id_cancelacion_evento);


--
-- TOC entry 2557 (class 2606 OID 31455)
-- Name: fkeventualid168495; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eventualidad
    ADD CONSTRAINT fkeventualid168495 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion(id_instalacion);


--
-- TOC entry 2558 (class 2606 OID 31710)
-- Name: fkeventualid316997; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eventualidad
    ADD CONSTRAINT fkeventualid316997 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2559 (class 2606 OID 31720)
-- Name: fkeventualid821934; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY eventualidad
    ADD CONSTRAINT fkeventualid821934 FOREIGN KEY (tipo_eventualidadid_tipo_eventualidad) REFERENCES tipo_eventualidad(id_tipo_eventualidad);


--
-- TOC entry 2601 (class 2606 OID 31680)
-- Name: fkfoto370704; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY foto
    ADD CONSTRAINT fkfoto370704 FOREIGN KEY (clubid_club) REFERENCES club(id_club);


--
-- TOC entry 2600 (class 2606 OID 31620)
-- Name: fkfoto999055; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY foto
    ADD CONSTRAINT fkfoto999055 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion(id_instalacion);


--
-- TOC entry 2568 (class 2606 OID 31465)
-- Name: fkfuncion_gr570137; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcion_grupo
    ADD CONSTRAINT fkfuncion_gr570137 FOREIGN KEY (funcionid_funcion) REFERENCES funcion(id_funcion);


--
-- TOC entry 2569 (class 2606 OID 31470)
-- Name: fkfuncion_gr71738; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcion_grupo
    ADD CONSTRAINT fkfuncion_gr71738 FOREIGN KEY (grupoid_grupo) REFERENCES grupo(id_grupo);


--
-- TOC entry 2609 (class 2606 OID 31695)
-- Name: fkindicador_457606; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_evento
    ADD CONSTRAINT fkindicador_457606 FOREIGN KEY (indicadorid_indicador) REFERENCES indicador(id_indicador);


--
-- TOC entry 2610 (class 2606 OID 31700)
-- Name: fkindicador_952117; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY indicador_evento
    ADD CONSTRAINT fkindicador_952117 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2560 (class 2606 OID 31815)
-- Name: fkinstalacio183404; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion
    ADD CONSTRAINT fkinstalacio183404 FOREIGN KEY (tipo_instalacionid_tipo_instalacion) REFERENCES tipo_instalacion(id_tipo_instalacion);


--
-- TOC entry 2584 (class 2606 OID 31530)
-- Name: fkinstalacio63093; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion_evento
    ADD CONSTRAINT fkinstalacio63093 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion(id_instalacion);


--
-- TOC entry 2585 (class 2606 OID 31705)
-- Name: fkinstalacio726736; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY instalacion_evento
    ADD CONSTRAINT fkinstalacio726736 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2594 (class 2606 OID 31580)
-- Name: fkjunta_dire372831; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY junta_directiva
    ADD CONSTRAINT fkjunta_dire372831 FOREIGN KEY (clubid_club) REFERENCES club(id_club);


--
-- TOC entry 2596 (class 2606 OID 31590)
-- Name: fkmiembro_ju155866; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY miembro_junta
    ADD CONSTRAINT fkmiembro_ju155866 FOREIGN KEY (cargoid_cargo) REFERENCES cargo(id_cargo);


--
-- TOC entry 2597 (class 2606 OID 31630)
-- Name: fkmiembro_ju46124; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY miembro_junta
    ADD CONSTRAINT fkmiembro_ju46124 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2595 (class 2606 OID 31585)
-- Name: fkmiembro_ju484923; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY miembro_junta
    ADD CONSTRAINT fkmiembro_ju484923 FOREIGN KEY (junta_directivaid_junta_directiva) REFERENCES junta_directiva(id_junta_directiva);


--
-- TOC entry 2562 (class 2606 OID 31745)
-- Name: fknoticia363644; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia
    ADD CONSTRAINT fknoticia363644 FOREIGN KEY (tipo_noticiaid_tipo_noticia) REFERENCES tipo_noticia(id_tipo_noticia);


--
-- TOC entry 2561 (class 2606 OID 31460)
-- Name: fknoticia587974; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia
    ADD CONSTRAINT fknoticia587974 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2598 (class 2606 OID 31645)
-- Name: fknoticia_pr462545; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia_preferencia
    ADD CONSTRAINT fknoticia_pr462545 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia(id_preferencia);


--
-- TOC entry 2599 (class 2606 OID 31650)
-- Name: fknoticia_pr955333; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY noticia_preferencia
    ADD CONSTRAINT fknoticia_pr955333 FOREIGN KEY (noticiaid_noticia) REFERENCES noticia(id_noticia);


--
-- TOC entry 2556 (class 2606 OID 31770)
-- Name: fkopinion153903; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY opinion
    ADD CONSTRAINT fkopinion153903 FOREIGN KEY (tipo_opnionid_tipo_opninion) REFERENCES tipo_opnion(id_tipo_opninion);


--
-- TOC entry 2554 (class 2606 OID 31450)
-- Name: fkopinion612647; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY opinion
    ADD CONSTRAINT fkopinion612647 FOREIGN KEY (postulacionid_postulacion) REFERENCES postulacion(id_postulacion);


--
-- TOC entry 2555 (class 2606 OID 31475)
-- Name: fkopinion960425; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY opinion
    ADD CONSTRAINT fkopinion960425 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2593 (class 2606 OID 31750)
-- Name: fkpolitica881306; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY politica
    ADD CONSTRAINT fkpolitica881306 FOREIGN KEY (clubid_club) REFERENCES club(id_club);


--
-- TOC entry 2553 (class 2606 OID 31675)
-- Name: fkpostulacio263619; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY postulacion
    ADD CONSTRAINT fkpostulacio263619 FOREIGN KEY (motivo_postulacionid_motivo_postulacion) REFERENCES motivo_postulacion(id_motivo_postulacion);


--
-- TOC entry 2552 (class 2606 OID 31500)
-- Name: fkpostulacio459411; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY postulacion
    ADD CONSTRAINT fkpostulacio459411 FOREIGN KEY (postuladoid_postulado) REFERENCES postulado(id_postulado);


--
-- TOC entry 2576 (class 2606 OID 31600)
-- Name: fkpostulado961751; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY postulado
    ADD CONSTRAINT fkpostulado961751 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2602 (class 2606 OID 31635)
-- Name: fkpreferenci116119; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_evento
    ADD CONSTRAINT fkpreferenci116119 FOREIGN KEY (eventoid_evento) REFERENCES evento(id_evento);


--
-- TOC entry 2582 (class 2606 OID 31515)
-- Name: fkpreferenci433464; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_persona
    ADD CONSTRAINT fkpreferenci433464 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2583 (class 2606 OID 31595)
-- Name: fkpreferenci734891; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_persona
    ADD CONSTRAINT fkpreferenci734891 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia(id_preferencia);


--
-- TOC entry 2575 (class 2606 OID 31610)
-- Name: fkpreferenci914864; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia
    ADD CONSTRAINT fkpreferenci914864 FOREIGN KEY (tipo_preferenciaid_tipo_preferencia) REFERENCES tipo_preferencia(id_tipo_preferencia);


--
-- TOC entry 2603 (class 2606 OID 31640)
-- Name: fkpreferenci990568; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY preferencia_evento
    ADD CONSTRAINT fkpreferenci990568 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia(id_preferencia);


--
-- TOC entry 2589 (class 2606 OID 31560)
-- Name: fkrecurso_in291982; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recurso_instalacion
    ADD CONSTRAINT fkrecurso_in291982 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion(id_instalacion);


--
-- TOC entry 2590 (class 2606 OID 31565)
-- Name: fkrecurso_in94123; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY recurso_instalacion
    ADD CONSTRAINT fkrecurso_in94123 FOREIGN KEY (recursoid_recurso) REFERENCES recurso(id_recurso);


--
-- TOC entry 2605 (class 2606 OID 31660)
-- Name: fkred_club340293; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_club
    ADD CONSTRAINT fkred_club340293 FOREIGN KEY (clubid_club) REFERENCES club(id_club);


--
-- TOC entry 2604 (class 2606 OID 31655)
-- Name: fkred_club653742; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_club
    ADD CONSTRAINT fkred_club653742 FOREIGN KEY (red_socialid_red_social) REFERENCES red_social(id_red_social);


--
-- TOC entry 2606 (class 2606 OID 31665)
-- Name: fkred_person553235; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_persona
    ADD CONSTRAINT fkred_person553235 FOREIGN KEY (red_socialid_red_social) REFERENCES red_social(id_red_social);


--
-- TOC entry 2607 (class 2606 OID 31670)
-- Name: fkred_person55530; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY red_persona
    ADD CONSTRAINT fkred_person55530 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2570 (class 2606 OID 31480)
-- Name: fkreservacio233681; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservacion
    ADD CONSTRAINT fkreservacio233681 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion(id_instalacion);


--
-- TOC entry 2571 (class 2606 OID 31520)
-- Name: fkreservacio957114; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY reservacion
    ADD CONSTRAINT fkreservacio957114 FOREIGN KEY (socioid_socio) REFERENCES socio(id_socio);


--
-- TOC entry 2546 (class 2606 OID 31805)
-- Name: fksancion174634; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT fksancion174634 FOREIGN KEY (afiliadoid_afilado) REFERENCES afiliado(id_afilado);


--
-- TOC entry 2547 (class 2606 OID 31810)
-- Name: fksancion24094; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT fksancion24094 FOREIGN KEY (motivo_sancionid_motivo_sancion) REFERENCES motivo_sancion(id_motivo_sancion);


--
-- TOC entry 2543 (class 2606 OID 31490)
-- Name: fksancion45887; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT fksancion45887 FOREIGN KEY (socioid_socio) REFERENCES socio(id_socio);


--
-- TOC entry 2545 (class 2606 OID 31775)
-- Name: fksancion525894; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT fksancion525894 FOREIGN KEY (tipo_sancionid_tipo_sancion) REFERENCES tipo_sancion(id_tipo_sancion);


--
-- TOC entry 2544 (class 2606 OID 31760)
-- Name: fksancion982820; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sancion
    ADD CONSTRAINT fksancion982820 FOREIGN KEY (eventualidadid_eventualidad) REFERENCES eventualidad(id_eventualidad);


--
-- TOC entry 2549 (class 2606 OID 31575)
-- Name: fksocio256923; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY socio
    ADD CONSTRAINT fksocio256923 FOREIGN KEY (postulacionid_postulacion) REFERENCES postulacion(id_postulacion);


--
-- TOC entry 2548 (class 2606 OID 31485)
-- Name: fksocio389286; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY socio
    ADD CONSTRAINT fksocio389286 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2611 (class 2606 OID 31715)
-- Name: fksolicitud_549112; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_venta
    ADD CONSTRAINT fksolicitud_549112 FOREIGN KEY (accionid_accion) REFERENCES accion(id_accion);


--
-- TOC entry 2612 (class 2606 OID 31755)
-- Name: fksolicitud_857177; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY solicitud_venta
    ADD CONSTRAINT fksolicitud_857177 FOREIGN KEY (motivo_ventaid_motivo_venta) REFERENCES motivo_venta(id_motivo_venta);


--
-- TOC entry 2587 (class 2606 OID 31555)
-- Name: fksugerencia16271; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sugerencia
    ADD CONSTRAINT fksugerencia16271 FOREIGN KEY (cliente_externoid_cliente) REFERENCES cliente_externo(id_cliente);


--
-- TOC entry 2586 (class 2606 OID 31550)
-- Name: fksugerencia689242; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sugerencia
    ADD CONSTRAINT fksugerencia689242 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2588 (class 2606 OID 31605)
-- Name: fksugerencia963242; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sugerencia
    ADD CONSTRAINT fksugerencia963242 FOREIGN KEY (tipo_sugerenciaid_tipo_sugerencia) REFERENCES tipo_sugerencia(id_tipo_sugerencia);


--
-- TOC entry 2540 (class 2606 OID 31545)
-- Name: fkusuario844503; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT fkusuario844503 FOREIGN KEY (personaid_persona) REFERENCES persona(id_persona);


--
-- TOC entry 2541 (class 2606 OID 31440)
-- Name: fkusuario_gr55454; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_grupo
    ADD CONSTRAINT fkusuario_gr55454 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario(id_usuario);


--
-- TOC entry 2542 (class 2606 OID 31445)
-- Name: fkusuario_gr690051; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_grupo
    ADD CONSTRAINT fkusuario_gr690051 FOREIGN KEY (grupoid_grupo) REFERENCES grupo(id_grupo);


--
-- TOC entry 2581 (class 2606 OID 31790)
-- Name: fkventa326071; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT fkventa326071 FOREIGN KEY (postulacionid_postulacion) REFERENCES postulacion(id_postulacion);


--
-- TOC entry 2580 (class 2606 OID 31510)
-- Name: fkventa357573; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT fkventa357573 FOREIGN KEY (accionid_accion) REFERENCES accion(id_accion);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-03-19 10:08:58

--
-- PostgreSQL database dump complete
--

