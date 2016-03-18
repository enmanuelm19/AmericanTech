--insertando club (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, correo, telf_alternativo, eslogan, activo, logo)
  VALUES  ( 1, 'J-08521135-7', 'Centro Atl閠ico America', 'Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la uni贸n familiar y consolidando el legado de sus fundadores.',
  'Constituirnos como la instituci贸n social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformaci贸n consolidando un ambiente cada d铆a m谩s id贸neo para el desarrollo biopsicosocial de nuestras generaciones.',
  'centroatleticoclubamerica@gmail.com', '0251-4411594','Incentivando y promoviendo la participaci贸n cultural y deportiva','true', 'http://i.imgur.com/bzOnmjv.png');

-- insertando datos al portal (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO portal (id_portal, instalacion, socio, evento, foto_socio, foto_instalaciones, foto_evento)
VALUES  (1, 'El Centro Atl閠ico Am茅rica cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Adem谩s cuenta con un sal贸n de Fiestas y dos Caneis para el disfrute de sus socios e invitados', 
'Nuestros socios se caracterizan por su familiaridad y buen comportamiento, ayudando as铆 a mantener las tradiciones de club. 驴Quieres ser un socio del Centro Atl茅tico Am茅rica?', 
'Nos interesa Motivar la interacci贸n social a trav茅s de actividades culturales de intercambio en busca del crecimiento humano mediante la realizaci贸n de eventos. 驴Quieres participar en nuestros eventos?',
'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');


--Fotos para la galeria de instalaciones
INSERT INTO foto (url, instalacionid_instalacion, publico, clubid_club, activo)
VALUES( http://i.imgur.com/wHrzoYB.jpg ,1,true, 1, true);

INSERT INTO foto (url, instalacionid_instalacion, publico, clubid_club, activo)
VALUES( http://i.imgur.com/cHPOldS.jpg, 2,true, 1, true)

INSERT INTO foto (url, instalacionid_instalacion, publico, clubid_club, activo)
VALUES( http://i.imgur.com/2pTsUU6.jpg, 2,true, 1, true)
    
    