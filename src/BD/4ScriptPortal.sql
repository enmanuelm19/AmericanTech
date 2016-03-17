--insertando club (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, correo, telf_alternativo, eslogan, activo, logo)
  VALUES  ( 1, 'J-08521135-7', 'Centro Atlético America', 'Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.',
  'Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.',
  'centroatleticoclubamerica@gmail.com', '0251-4411594','Incentivando y promoviendo la participación cultural y deportiva','true', 'http://i.imgur.com/bzOnmjv.png');

-- insertando datos al portal (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO portal (id_portal, instalacion, socio, evento, foto_socio, foto_instalaciones, foto_evento)
VALUES  (1, 'El Centro Atlético América cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Además cuenta con un salón de Fiestas y dos Caneis para el disfrute de sus socios e invitados', 
'Nuestros socios se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de club. ¿Quieres ser un socio del Centro Atlético América?', 
'Nos interesa Motivar la interacción social a través de actividades culturales de intercambio en busca del crecimiento humano mediante la realización de eventos. ¿Quieres participar en nuestros eventos?',
'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');
    