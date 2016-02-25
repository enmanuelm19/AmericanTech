CREATE TABLE usuario (
  id_usuario         SERIAL NOT NULL, 
  contrasenna       varchar(20) NOT NULL, 
  username          varchar(60) NOT NULL, 
  pregunta          varchar(60) NOT NULL, 
  respuesta         varchar(60) NOT NULL, 
  personaid_persona int2 NOT NULL, 
  fecha             date NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_usuario));
CREATE TABLE club (
  id_club           SERIAL NOT NULL, 
  rif              varchar(20) NOT NULL, 
  nombre           varchar(60) NOT NULL, 
  direccion        varchar(60) NOT NULL, 
  telefono         varchar(12) NOT NULL, 
  mision           varchar(250) NOT NULL, 
  vision           varchar(250) NOT NULL, 
  logo             int2 NOT NULL, 
  telf_alternativo varchar(12) NOT NULL, 
  correo           varchar(75) NOT NULL, 
  eslogan          varchar(255), 
  activo           bool, 
  PRIMARY KEY (id_club));
CREATE TABLE usuario_grupo (
  id_usuario_grupo   SERIAL NOT NULL, 
  usuarioid_usuario int2 NOT NULL, 
  grupoid_grupo     int2 NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_usuario_grupo));
CREATE TABLE grupo (
  id_grupo     SERIAL NOT NULL, 
  descripcion varchar(100) NOT NULL, 
  activo      bool NOT NULL, 
  PRIMARY KEY (id_grupo));
CREATE TABLE persona (
  id_persona      SERIAL NOT NULL, 
  identificacion varchar(20), 
  nombre         varchar(30) NOT NULL, 
  apellido       varchar(30) NOT NULL, 
  foto           int2, 
  fecha_nac      date, 
  sexo           varchar(1) NOT NULL, 
  correo         varchar(80), 
  telefono       varchar(12), 
  telefono_fijo  varchar(12), 
  direccion      varchar(120), 
  activo         bool NOT NULL, 
  PRIMARY KEY (id_persona));
CREATE TABLE sancion (
  id_sancion                SERIAL NOT NULL, 
  descripcion              varchar(200) NOT NULL, 
  socioid_socio            int2, 
  fecha_inic               date NOT NULL, 
  fecha_fin                date NOT NULL, 
  monto                    float4, 
  tipo_sanciontipo_sancion int2 NOT NULL, 
  activo                   bool NOT NULL, 
  PRIMARY KEY (id_sancion));
CREATE TABLE socio (
  id_socio                   SERIAL NOT NULL, 
  postulacionid_postulacion int2, 
  nro_carnet                varchar(20) NOT NULL, 
  personaid_persona         int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_socio));
CREATE TABLE accion (
  id_accion                      SERIAL NOT NULL, 
  nro_accion                    varchar(50) NOT NULL, 
  valor                         float4 NOT NULL, 
  socioid_socio                 int2 NOT NULL, 
  estado_accionid_estado_accion int2 NOT NULL, 
  activo                        bool NOT NULL, 
  PRIMARY KEY (id_accion));
CREATE TABLE postulacion (
  id_postulacion                           SERIAL NOT NULL, 
  Postuladoid_postulado                   int2 NOT NULL, 
  fecha                                   date NOT NULL, 
  carnet_padrino1                         int2 NOT NULL, 
  carnet_padrino2                         int2 NOT NULL, 
  motivo_postulacionid_motivo_postulacion int2 NOT NULL, 
  Ventaid_venta                           int2 NOT NULL, 
  aprobado                                bool NOT NULL, 
  activo                                  bool NOT NULL, 
  CONSTRAINT carnet_padrino1 
    PRIMARY KEY (id_postulacion));
CREATE TABLE opinion (
  id_opinion                 SERIAL NOT NULL, 
  postulacionid_postulacion int2 NOT NULL, 
  descripcion               varchar(9) NOT NULL, 
  usuarioid_usuario         int2 NOT NULL, 
  fecha                     date NOT NULL, 
  calificacion              int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_opinion));
CREATE TABLE eventualidad (
  id_eventualidad                        SERIAL NOT NULL, 
  instalacionid_instalacion             int2, 
  descripcion                           varchar(9) NOT NULL, 
  fecha                                 date NOT NULL, 
  sancionid_sancion                     int2, 
  personaid_persona                     int2 NOT NULL, 
  tipo_eventualidadid_tipo_eventualidad int2 NOT NULL, 
  activo                                bool NOT NULL, 
  PRIMARY KEY (id_eventualidad));
CREATE TABLE instalacion (
  id_instalacion                       SERIAL NOT NULL, 
  descripcion                         varchar(255) NOT NULL, 
  capacidad                           int2 NOT NULL, 
  precio_alquiler                     float4 NOT NULL, 
  tipo_instalacionid_tipo_instalacion int2 NOT NULL, 
  activo                              bool NOT NULL, 
  nombre                              varchar(180) NOT NULL, 
  PRIMARY KEY (id_instalacion));
CREATE TABLE noticia (
  id_noticia       SERIAL NOT NULL, 
  titulo          varchar(70), 
  descripcion     varchar(255) NOT NULL, 
  eventoid_evento int2, 
  foto            int2, 
  condicion       bool NOT NULL, 
  caducidad       date NOT NULL, 
  publico         bool NOT NULL, 
  enlace          varchar(255), 
  fecha_creacion  date NOT NULL, 
  activo          bool NOT NULL, 
  PRIMARY KEY (id_noticia));
CREATE TABLE calendario_fecha (
  id_calendario_fecha        SERIAL NOT NULL, 
  descripcion               varchar(80) NOT NULL, 
  fecha                     date NOT NULL, 
  reservacionid_reservacion int2, 
  eventoid_evento           int2, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_calendario_fecha));
CREATE TABLE evento (
  id_evento                      SERIAL NOT NULL, 
  nombre                        varchar(200) NOT NULL, 
  descripcion                   varchar(150) NOT NULL, 
  fecha_inicio                  date NOT NULL, 
  fecha_fin                     date NOT NULL, 
  publico                       bool NOT NULL, 
  estado_eventoid_estado_evento int2 NOT NULL, 
  activo                        bool NOT NULL, 
  PRIMARY KEY (id_evento));
CREATE TABLE actividad (
  id_actividad                     SERIAL NOT NULL, 
  descripcion                     varchar(80) NOT NULL, 
  condicion                       varchar(9) NOT NULL, 
  tipo_actividadid_tipo_actividad int2 NOT NULL, 
  eventoid_evento                 int2 NOT NULL, 
  activo                          bool NOT NULL, 
  PRIMARY KEY (id_actividad));
CREATE TABLE patrocinante (
  id_patrocinante  SERIAL NOT NULL, 
  nombre          varchar(80) NOT NULL, 
  direccion       varchar(150) NOT NULL, 
  telefono        int2 NOT NULL, 
  correo          int2 NOT NULL, 
  activo          bool NOT NULL, 
  PRIMARY KEY (id_patrocinante));
CREATE TABLE partocinante_evento (
  id_patrocinante_evento       SERIAL NOT NULL, 
  patrocinanteid_patrocinante int2 NOT NULL, 
  eventoid_evento             int2 NOT NULL, 
  activo                      bool NOT NULL, 
  PRIMARY KEY (id_patrocinante_evento));
CREATE TABLE proveedor (
  id_proveedor  SERIAL NOT NULL, 
  nombre       varchar(30) NOT NULL, 
  direccion    varchar(150) NOT NULL, 
  telefono     varchar(12) NOT NULL, 
  correo       varchar(50) NOT NULL, 
  activo       bool NOT NULL, 
  PRIMARY KEY (id_proveedor));
CREATE TABLE proveedor_actividad (
  id_proveedor_actividad  SERIAL NOT NULL, 
  proveedorid_proveedor  int2 NOT NULL, 
  actividadid_actividad  int2 NOT NULL, 
  detalle                varchar(150), 
  activo                 bool NOT NULL, 
  PRIMARY KEY (id_proveedor_actividad));
CREATE TABLE funcion (
  id_funcion  SERIAL NOT NULL, 
  nombre     varchar(100) NOT NULL, 
  pagina     varchar(255) NOT NULL, 
  icon_uri   varchar(255) NOT NULL, 
  clase      varchar(120) NOT NULL, 
  activo     bool NOT NULL, 
  PRIMARY KEY (id_funcion));
CREATE TABLE funcion_grupo (
  id_funcion_grupo   SERIAL NOT NULL, 
  funcionid_funcion int2 NOT NULL, 
  grupoid_grupo     int2 NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_funcion_grupo));
CREATE TABLE reservacion (
  id_reservacion             SERIAL NOT NULL, 
  instalacionid_instalacion int2 NOT NULL, 
  socioid_socio             int2 NOT NULL, 
  fecha_inicio              date NOT NULL, 
  fecha_fin                 int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_reservacion));
CREATE TABLE afiliado (
  id_afilado                     SERIAL NOT NULL, 
  tipo_afiliadoid_tipo_afiliado int2 NOT NULL, 
  socioid_socio                 int2 NOT NULL, 
  nro_carnet                    varchar(20) NOT NULL, 
  personaid_persona             int2 NOT NULL, 
  activo                        bool NOT NULL, 
  PRIMARY KEY (id_afilado));
CREATE TABLE cliente_externo (
  id_cliente  SERIAL NOT NULL, 
  nombre     varchar(30) NOT NULL, 
  apellido   varchar(30) NOT NULL, 
  correo     varchar(80) NOT NULL, 
  activo     bool NOT NULL, 
  PRIMARY KEY (id_cliente));
CREATE TABLE preferencia (
  id_preferencia                       SERIAL NOT NULL, 
  descripcion                         varchar(80) NOT NULL, 
  tipo_preferenciaid_tipo_preferencia int2 NOT NULL, 
  activo                              bool NOT NULL, 
  PRIMARY KEY (id_preferencia));
CREATE TABLE Postulado (
  id_postulado       SERIAL NOT NULL, 
  personaid_persona int2 NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_postulado));
CREATE TABLE desvinculacion (
  id_desvinculacion                              SERIAL NOT NULL, 
  accionid_accion                               int2 NOT NULL, 
  socioid_socio                                 int2 NOT NULL, 
  fecha                                         date NOT NULL, 
  motivo                                        varchar(200) NOT NULL, 
  motivo_desvinculacionid_motivo_desvinculacion int2 NOT NULL, 
  activo                                        bool NOT NULL, 
  PRIMARY KEY (id_desvinculacion));
CREATE TABLE Venta (
  id_venta                     SERIAL NOT NULL, 
  accionid_accion             int2 NOT NULL, 
  fecha                       date NOT NULL, 
  monto                       float4 NOT NULL, 
  motivo_ventaid_motivo_venta int2 NOT NULL, 
  activo                      bool NOT NULL, 
  PRIMARY KEY (id_venta));
CREATE TABLE preferencia_persona (
  id_preferencia_persona     SERIAL NOT NULL, 
  preferenciaid_preferencia int2 NOT NULL, 
  personaid_persona         int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_preferencia_persona));
CREATE TABLE instalacion_evento (
  id_actividad_instalacion   SERIAL NOT NULL, 
  instalacionid_instalacion int2 NOT NULL, 
  eventoid_evento           int2 NOT NULL, 
  fecha_fin                 date NOT NULL, 
  fecha_inicio              date NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_actividad_instalacion));
CREATE TABLE recurso (
  id_recurso   SERIAL NOT NULL, 
  descripcion varchar(40) NOT NULL, 
  activo      bool NOT NULL, 
  PRIMARY KEY (id_recurso));
CREATE TABLE sugerencia (
  id_sugerencia                      SERIAL NOT NULL, 
  descripcion                       varchar(150) NOT NULL, 
  fecha                             date NOT NULL, 
  usuarioid_usuario                 int2, 
  cliente_externoid_cliente         int2, 
  tipo_sugerenciaid_tipo_sugerencia int2 NOT NULL, 
  activo                            bool NOT NULL, 
  PRIMARY KEY (id_sugerencia));
CREATE TABLE recurso_instalacion (
  id_recurso_instalacion     SERIAL NOT NULL, 
  instalacionid_instalacion int2 NOT NULL, 
  recursoid_recurso         int2 NOT NULL, 
  cantidad                  int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_recurso_instalacion));
CREATE TABLE alquiler (
  id_alquiler                SERIAL NOT NULL, 
  reservacionid_reservacion int2 NOT NULL, 
  fecha                     date NOT NULL, 
  nro_transaccion           varchar(30) NOT NULL, 
  monto                     float4 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_alquiler));
CREATE TABLE politica (
  id_politica                    SERIAL NOT NULL, 
  descripcion                   varchar(255) NOT NULL, 
  frecuencia                    int4, 
  cantidad_invitados            int4, 
  tipo_politicaid_tipo_politica int2 NOT NULL, 
  tipo_afiliadoid_tipo_afiliado int2 NOT NULL, 
  atributo                      varchar(30) NOT NULL, 
  activo                        bool NOT NULL, 
  PRIMARY KEY (id_politica));
CREATE TABLE junta_directiva (
  id_junta_directiva  SERIAL NOT NULL, 
  clubid_club        int2 NOT NULL, 
  fecha_inic         date NOT NULL, 
  fecha_fin          date NOT NULL, 
  activo             bool NOT NULL, 
  PRIMARY KEY (id_junta_directiva));
CREATE TABLE miembro_junta (
  id_junta_miembro                   SERIAL NOT NULL, 
  junta_directivaid_junta_directiva int2 NOT NULL, 
  cargoid_cargo                     int2 NOT NULL, 
  personaid_persona                 int2 NOT NULL, 
  activo                            bool NOT NULL, 
  PRIMARY KEY (id_junta_miembro));
CREATE TABLE cargo (
  id_cargo     SERIAL NOT NULL, 
  descripcion varchar(90) NOT NULL, 
  activo      bool NOT NULL, 
  PRIMARY KEY (id_cargo));
CREATE TABLE tipo_sugerencia (
  id_tipo_sugerencia  SERIAL NOT NULL, 
  descripcion        varchar(30) NOT NULL, 
  activo             bool NOT NULL, 
  PRIMARY KEY (id_tipo_sugerencia));
CREATE TABLE tipo_preferencia (
  id_tipo_preferencia  SERIAL NOT NULL, 
  descripcion         varchar(80) NOT NULL, 
  color               varchar(12), 
  activo              bool NOT NULL, 
  PRIMARY KEY (id_tipo_preferencia));
CREATE TABLE calendario_hora (
  id_calendario_hora                   SERIAL NOT NULL, 
  horaid_hora                         int2 NOT NULL, 
  calendario_fechaid_calendario_fecha int2 NOT NULL, 
  activo                              bool NOT NULL, 
  PRIMARY KEY (id_calendario_hora));
CREATE TABLE hora (
  id_hora        SERIAL NOT NULL, 
  valor_horario time NOT NULL, 
  activo        bool NOT NULL, 
  PRIMARY KEY (id_hora));
CREATE TABLE tipo_actividad (
  id_tipo_actividad  SERIAL NOT NULL, 
  descripcion       varchar(20) NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_tipo_actividad));
CREATE TABLE noticia_preferencia (
  id_noticia_preferencia     SERIAL NOT NULL, 
  preferenciaid_preferencia int2 NOT NULL, 
  noticiaid_noticia         int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_noticia_preferencia));
CREATE TABLE motivo_sancion (
  id_motivo_sancion  SERIAL NOT NULL, 
  descripcion       varchar(100) NOT NULL, 
  activo            bool NOT NULL, 
  PRIMARY KEY (id_motivo_sancion));
CREATE TABLE motivo_desvinculacion (
  id_motivo_desvinculacion  SERIAL NOT NULL, 
  descripcion              varchar(30) NOT NULL, 
  activo                   bool NOT NULL, 
  PRIMARY KEY (id_motivo_desvinculacion));
CREATE TABLE foto (
  id_foto                    SERIAL NOT NULL, 
  url                       varchar(255) NOT NULL, 
  nombre_foto               varchar(120) NOT NULL, 
  extencion                 varchar(50) NOT NULL, 
  instalacionid_instalacion int2, 
  publico                   bool NOT NULL, 
  clubid_club               int2, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_foto));
CREATE TABLE tipo_afiliado (
  id_tipo_afiliado  SERIAL NOT NULL, 
  descripcion      varchar(60) NOT NULL, 
  activo           bool NOT NULL, 
  PRIMARY KEY (id_tipo_afiliado));
CREATE TABLE preferencia_evento (
  id_preferencia_evento      SERIAL NOT NULL, 
  eventoid_evento           int2 NOT NULL, 
  preferenciaid_preferencia int2 NOT NULL, 
  activo                    bool NOT NULL, 
  PRIMARY KEY (id_preferencia_evento));
CREATE TABLE red_social (
  id_red_social  SERIAL NOT NULL, 
  descripcion   varchar(60) NOT NULL, 
  activo        bool NOT NULL, 
  PRIMARY KEY (id_red_social));
CREATE TABLE red_club (
  id_red_club              SERIAL NOT NULL, 
  clubid_club             int2 NOT NULL, 
  red_socialid_red_social int2, 
  enlace                  varchar(255) NOT NULL, 
  activo                  bool NOT NULL, 
  PRIMARY KEY (id_red_club));
CREATE TABLE red_persona (
  id_red_persona           SERIAL NOT NULL, 
  enlace                  varchar(255) NOT NULL, 
  red_socialid_red_social int2 NOT NULL, 
  personaid_persona       int2 NOT NULL, 
  activo                  bool NOT NULL, 
  PRIMARY KEY (id_red_persona));
CREATE TABLE tipo_empleado (
  id_tipo_empleado  SERIAL NOT NULL, 
  descripcion      varchar(20) NOT NULL, 
  activo           bool NOT NULL, 
  PRIMARY KEY (id_tipo_empleado));
CREATE TABLE empleado (
  id_empleado                    SERIAL NOT NULL, 
  personaid_persona             int2 NOT NULL, 
  tipo_empleadoid_tipo_empleado int2 NOT NULL, 
  fecha_contratado              date NOT NULL, 
  activo                        bool NOT NULL, 
  PRIMARY KEY (id_empleado));
CREATE TABLE motivo_postulacion (
  id_motivo_postulacion  SERIAL NOT NULL, 
  descripcion           varchar(80) NOT NULL, 
  activo                bool NOT NULL, 
  PRIMARY KEY (id_motivo_postulacion));
CREATE TABLE motivo_venta (
  id_motivo_venta  SERIAL NOT NULL, 
  descripcion     varchar(80) NOT NULL, 
  activo          bool NOT NULL, 
  PRIMARY KEY (id_motivo_venta));
CREATE TABLE tipo_instalacion (
  id_tipo_instalacion  SERIAL NOT NULL, 
  descripcion         varchar(60) NOT NULL, 
  activo              bool NOT NULL, 
  PRIMARY KEY (id_tipo_instalacion));
CREATE TABLE archivo (
  id_archivo  SERIAL NOT NULL, 
  url        varchar(255) NOT NULL, 
  nombre     varchar(120) NOT NULL, 
  extension  varchar(50) NOT NULL, 
  activo     bool NOT NULL, 
  PRIMARY KEY (id_archivo));
CREATE TABLE tipo_politica (
  id_tipo_politica  SERIAL NOT NULL, 
  descripcion      varchar(60), 
  activo           bool NOT NULL, 
  PRIMARY KEY (id_tipo_politica));
CREATE TABLE estado_evento (
  id_estado_evento  SERIAL NOT NULL, 
  nombre           varchar(40) NOT NULL, 
  activo           bool NOT NULL, 
  PRIMARY KEY (id_estado_evento));
CREATE TABLE motivo_cancelacion (
  id_motivo_cancelacion  SERIAL NOT NULL, 
  descipcion            varchar(255) NOT NULL, 
  eventoid_evento       int2 NOT NULL, 
  activo                bool NOT NULL, 
  PRIMARY KEY (id_motivo_cancelacion));
CREATE TABLE indicador (
  id_indicador  SERIAL NOT NULL, 
  descripcion  varchar(150) NOT NULL, 
  activo       bool NOT NULL, 
  PRIMARY KEY (id_indicador));
CREATE TABLE indicador_evento (
  id_indicador_evento    SERIAL NOT NULL, 
  valor_esperado        int2 NOT NULL, 
  valor_real            int2, 
  indicadorid_indicador int2 NOT NULL, 
  eventoid_evento       int2 NOT NULL, 
  activo                bool NOT NULL, 
  PRIMARY KEY (id_indicador_evento));
CREATE TABLE solicitud_venta (
  id_solicitud_venta  SERIAL NOT NULL, 
  accionid_accion    int2 NOT NULL, 
  motivo             varchar(200) NOT NULL, 
  activo             bool NOT NULL, 
  PRIMARY KEY (id_solicitud_venta));
CREATE TABLE preferencia_solicitud (
  id_preferencia_solicitud             SERIAL NOT NULL, 
  solicitud_eventoid_solicitud_evento int2 NOT NULL, 
  preferenciaid_preferencia           int2 NOT NULL, 
  activo                              bool NOT NULL, 
  PRIMARY KEY (id_preferencia_solicitud));
CREATE TABLE tipo_eventualidad (
  id_tipo_eventualidad  SERIAL NOT NULL, 
  descripcion          varchar(50) NOT NULL, 
  activo               bool NOT NULL, 
  PRIMARY KEY (id_tipo_eventualidad));
CREATE TABLE estado_accion (
  id_estado_accion  SERIAL NOT NULL, 
  nombre           varchar(80) NOT NULL, 
  activo           bool NOT NULL, 
  PRIMARY KEY (id_estado_accion));
CREATE TABLE archivo_alquiler (
  id_archivo_alquiler          SERIAL NOT NULL, 
  archivoid_archivo           int2 NOT NULL, 
  alquilerid_alquiler         int2 NOT NULL, 
  tipo_archivoid_tipo_archivo int2 NOT NULL, 
  activo                      bool NOT NULL, 
  PRIMARY KEY (id_archivo_alquiler));
CREATE TABLE tipo_archivo (
  id_tipo_archivo  SERIAL NOT NULL, 
  nombre          varchar(80) NOT NULL, 
  activo          bool NOT NULL, 
  PRIMARY KEY (id_tipo_archivo));
ALTER TABLE usuario_grupo ADD CONSTRAINT FKusuario_gr55454 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE usuario_grupo ADD CONSTRAINT FKusuario_gr690051 FOREIGN KEY (grupoid_grupo) REFERENCES grupo (id_grupo);
ALTER TABLE opinion ADD CONSTRAINT FKopinion612647 FOREIGN KEY (postulacionid_postulacion) REFERENCES postulacion (id_postulacion);
ALTER TABLE eventualidad ADD CONSTRAINT FKeventualid168495 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion (id_instalacion);
ALTER TABLE noticia ADD CONSTRAINT FKnoticia587974 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE partocinante_evento ADD CONSTRAINT FKpartocinan400277 FOREIGN KEY (patrocinanteid_patrocinante) REFERENCES patrocinante (id_patrocinante);
ALTER TABLE proveedor_actividad ADD CONSTRAINT FKproveedor_808304 FOREIGN KEY (proveedorid_proveedor) REFERENCES proveedor (id_proveedor);
ALTER TABLE proveedor_actividad ADD CONSTRAINT FKproveedor_351724 FOREIGN KEY (actividadid_actividad) REFERENCES actividad (id_actividad);
ALTER TABLE funcion_grupo ADD CONSTRAINT FKfuncion_gr570137 FOREIGN KEY (funcionid_funcion) REFERENCES funcion (id_funcion);
ALTER TABLE funcion_grupo ADD CONSTRAINT FKfuncion_gr71738 FOREIGN KEY (grupoid_grupo) REFERENCES grupo (id_grupo);
ALTER TABLE opinion ADD CONSTRAINT FKopinion960425 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE reservacion ADD CONSTRAINT FKreservacio233681 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion (id_instalacion);
ALTER TABLE socio ADD CONSTRAINT FKsocio389286 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE sancion ADD CONSTRAINT FKsancion45887 FOREIGN KEY (socioid_socio) REFERENCES socio (id_socio);
ALTER TABLE accion ADD CONSTRAINT FKaccion88177 FOREIGN KEY (socioid_socio) REFERENCES socio (id_socio);
ALTER TABLE postulacion ADD CONSTRAINT FKpostulacio459411 FOREIGN KEY (Postuladoid_postulado) REFERENCES Postulado (id_postulado);
ALTER TABLE desvinculacion ADD CONSTRAINT FKdesvincula306726 FOREIGN KEY (accionid_accion) REFERENCES accion (id_accion);
ALTER TABLE Venta ADD CONSTRAINT FKVenta357573 FOREIGN KEY (accionid_accion) REFERENCES accion (id_accion);
ALTER TABLE preferencia_persona ADD CONSTRAINT FKpreferenci433464 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE reservacion ADD CONSTRAINT FKreservacio957114 FOREIGN KEY (socioid_socio) REFERENCES socio (id_socio);
ALTER TABLE afiliado ADD CONSTRAINT FKafiliado425484 FOREIGN KEY (socioid_socio) REFERENCES socio (id_socio);
ALTER TABLE instalacion_evento ADD CONSTRAINT FKinstalacio63093 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion (id_instalacion);
ALTER TABLE afiliado ADD CONSTRAINT FKafiliado416 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE desvinculacion ADD CONSTRAINT FKdesvincula576211 FOREIGN KEY (socioid_socio) REFERENCES socio (id_socio);
ALTER TABLE usuario ADD CONSTRAINT FKusuario844503 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE sugerencia ADD CONSTRAINT FKsugerencia689242 FOREIGN KEY (usuarioid_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE sugerencia ADD CONSTRAINT FKsugerencia16271 FOREIGN KEY (cliente_externoid_cliente) REFERENCES cliente_externo (id_cliente);
ALTER TABLE recurso_instalacion ADD CONSTRAINT FKrecurso_in291982 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion (id_instalacion);
ALTER TABLE recurso_instalacion ADD CONSTRAINT FKrecurso_in94123 FOREIGN KEY (recursoid_recurso) REFERENCES recurso (id_recurso);
ALTER TABLE alquiler ADD CONSTRAINT FKalquiler792396 FOREIGN KEY (reservacionid_reservacion) REFERENCES reservacion (id_reservacion);
ALTER TABLE socio ADD CONSTRAINT FKsocio256923 FOREIGN KEY (postulacionid_postulacion) REFERENCES postulacion (id_postulacion);
ALTER TABLE junta_directiva ADD CONSTRAINT FKjunta_dire372831 FOREIGN KEY (clubid_club) REFERENCES club (id_club);
ALTER TABLE miembro_junta ADD CONSTRAINT FKmiembro_ju484923 FOREIGN KEY (junta_directivaid_junta_directiva) REFERENCES junta_directiva (id_junta_directiva);
ALTER TABLE miembro_junta ADD CONSTRAINT FKmiembro_ju155866 FOREIGN KEY (cargoid_cargo) REFERENCES cargo (id_cargo);
ALTER TABLE calendario_fecha ADD CONSTRAINT FKcalendario334586 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE calendario_fecha ADD CONSTRAINT FKcalendario317419 FOREIGN KEY (reservacionid_reservacion) REFERENCES reservacion (id_reservacion);
ALTER TABLE partocinante_evento ADD CONSTRAINT FKpartocinan36644 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE preferencia_persona ADD CONSTRAINT FKpreferenci734891 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia (id_preferencia);
ALTER TABLE Postulado ADD CONSTRAINT FKPostulado961751 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE sugerencia ADD CONSTRAINT FKsugerencia963242 FOREIGN KEY (tipo_sugerenciaid_tipo_sugerencia) REFERENCES tipo_sugerencia (id_tipo_sugerencia);
ALTER TABLE preferencia ADD CONSTRAINT FKpreferenci914864 FOREIGN KEY (tipo_preferenciaid_tipo_preferencia) REFERENCES tipo_preferencia (id_tipo_preferencia);
ALTER TABLE calendario_hora ADD CONSTRAINT FKcalendario739729 FOREIGN KEY (horaid_hora) REFERENCES hora (id_hora);
ALTER TABLE actividad ADD CONSTRAINT FKactividad480912 FOREIGN KEY (tipo_actividadid_tipo_actividad) REFERENCES tipo_actividad (id_tipo_actividad);
ALTER TABLE calendario_hora ADD CONSTRAINT FKcalendario730879 FOREIGN KEY (calendario_fechaid_calendario_fecha) REFERENCES calendario_fecha (id_calendario_fecha);
ALTER TABLE sancion ADD CONSTRAINT FKsancion754008 FOREIGN KEY (tipo_sanciontipo_sancion) REFERENCES motivo_sancion (id_motivo_sancion);
ALTER TABLE desvinculacion ADD CONSTRAINT FKdesvincula942861 FOREIGN KEY (motivo_desvinculacionid_motivo_desvinculacion) REFERENCES motivo_desvinculacion (id_motivo_desvinculacion);
ALTER TABLE foto ADD CONSTRAINT FKfoto999055 FOREIGN KEY (instalacionid_instalacion) REFERENCES instalacion (id_instalacion);
ALTER TABLE afiliado ADD CONSTRAINT FKafiliado278652 FOREIGN KEY (tipo_afiliadoid_tipo_afiliado) REFERENCES tipo_afiliado (id_tipo_afiliado);
ALTER TABLE miembro_junta ADD CONSTRAINT FKmiembro_ju46124 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE preferencia_evento ADD CONSTRAINT FKpreferenci116119 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE preferencia_evento ADD CONSTRAINT FKpreferenci990568 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia (id_preferencia);
ALTER TABLE noticia_preferencia ADD CONSTRAINT FKnoticia_pr462545 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia (id_preferencia);
ALTER TABLE noticia_preferencia ADD CONSTRAINT FKnoticia_pr955333 FOREIGN KEY (noticiaid_noticia) REFERENCES noticia (id_noticia);
ALTER TABLE red_club ADD CONSTRAINT FKred_club653742 FOREIGN KEY (red_socialid_red_social) REFERENCES red_social (id_red_social);
ALTER TABLE red_club ADD CONSTRAINT FKred_club340293 FOREIGN KEY (clubid_club) REFERENCES club (id_club);
ALTER TABLE red_persona ADD CONSTRAINT FKred_person553235 FOREIGN KEY (red_socialid_red_social) REFERENCES red_social (id_red_social);
ALTER TABLE red_persona ADD CONSTRAINT FKred_person55530 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE empleado ADD CONSTRAINT FKempleado150195 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE empleado ADD CONSTRAINT FKempleado895856 FOREIGN KEY (tipo_empleadoid_tipo_empleado) REFERENCES tipo_empleado (id_tipo_empleado);
ALTER TABLE postulacion ADD CONSTRAINT FKpostulacio263619 FOREIGN KEY (motivo_postulacionid_motivo_postulacion) REFERENCES motivo_postulacion (id_motivo_postulacion);
ALTER TABLE instalacion ADD CONSTRAINT FKinstalacio183404 FOREIGN KEY (tipo_instalacionid_tipo_instalacion) REFERENCES tipo_instalacion (id_tipo_instalacion);
ALTER TABLE Venta ADD CONSTRAINT FKVenta48717 FOREIGN KEY (motivo_ventaid_motivo_venta) REFERENCES motivo_venta (id_motivo_venta);
ALTER TABLE foto ADD CONSTRAINT FKfoto370704 FOREIGN KEY (clubid_club) REFERENCES club (id_club);
ALTER TABLE persona ADD CONSTRAINT FKpersona828994 FOREIGN KEY (foto) REFERENCES archivo (id_archivo);
ALTER TABLE noticia ADD CONSTRAINT FKnoticia350899 FOREIGN KEY (foto) REFERENCES archivo (id_archivo);
ALTER TABLE club ADD CONSTRAINT FKclub505885 FOREIGN KEY (logo) REFERENCES archivo (id_archivo);
ALTER TABLE politica ADD CONSTRAINT FKpolitica857480 FOREIGN KEY (tipo_politicaid_tipo_politica) REFERENCES tipo_politica (id_tipo_politica);
ALTER TABLE postulacion ADD CONSTRAINT FKpostulacio568877 FOREIGN KEY (Ventaid_venta) REFERENCES Venta (id_venta);
ALTER TABLE evento ADD CONSTRAINT FKevento600923 FOREIGN KEY (estado_eventoid_estado_evento) REFERENCES estado_evento (id_estado_evento);
ALTER TABLE motivo_cancelacion ADD CONSTRAINT FKmotivo_can874505 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE actividad ADD CONSTRAINT FKactividad322003 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE indicador_evento ADD CONSTRAINT FKindicador_457606 FOREIGN KEY (indicadorid_indicador) REFERENCES indicador (id_indicador);
ALTER TABLE indicador_evento ADD CONSTRAINT FKindicador_952117 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE instalacion_evento ADD CONSTRAINT FKinstalacio726736 FOREIGN KEY (eventoid_evento) REFERENCES evento (id_evento);
ALTER TABLE eventualidad ADD CONSTRAINT FKeventualid666497 FOREIGN KEY (sancionid_sancion) REFERENCES sancion (id_sancion);
ALTER TABLE eventualidad ADD CONSTRAINT FKeventualid316997 FOREIGN KEY (personaid_persona) REFERENCES persona (id_persona);
ALTER TABLE solicitud_venta ADD CONSTRAINT FKsolicitud_549112 FOREIGN KEY (accionid_accion) REFERENCES accion (id_accion);
ALTER TABLE preferencia_solicitud ADD CONSTRAINT FKpreferenci464882 FOREIGN KEY (preferenciaid_preferencia) REFERENCES preferencia (id_preferencia);
ALTER TABLE eventualidad ADD CONSTRAINT FKeventualid821934 FOREIGN KEY (tipo_eventualidadid_tipo_eventualidad) REFERENCES tipo_eventualidad (id_tipo_eventualidad);
ALTER TABLE accion ADD CONSTRAINT FKaccion803928 FOREIGN KEY (estado_accionid_estado_accion) REFERENCES estado_accion (id_estado_accion);
ALTER TABLE politica ADD CONSTRAINT FKpolitica680525 FOREIGN KEY (tipo_afiliadoid_tipo_afiliado) REFERENCES tipo_afiliado (id_tipo_afiliado);
ALTER TABLE archivo_alquiler ADD CONSTRAINT FKarchivo_al422819 FOREIGN KEY (archivoid_archivo) REFERENCES archivo (id_archivo);
ALTER TABLE archivo_alquiler ADD CONSTRAINT FKarchivo_al266100 FOREIGN KEY (alquilerid_alquiler) REFERENCES alquiler (id_alquiler);
ALTER TABLE archivo_alquiler ADD CONSTRAINT FKarchivo_al163068 FOREIGN KEY (tipo_archivoid_tipo_archivo) REFERENCES tipo_archivo (id_tipo_archivo);