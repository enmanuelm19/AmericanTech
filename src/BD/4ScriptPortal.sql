--insertando club (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, correo, telf_alternativo, eslogan, activo, logo)
  VALUES  ( 1, 'J-08521135-7', 'Centro Atl�tico America', 'Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.', '0251-4410025', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la uni�n familiar y consolidando el legado de sus fundadores.',
  'Constituirnos como la instituci�n social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformaci�n consolidando un ambiente cada d�a m�s id�neo para el desarrollo biopsicosocial de nuestras generaciones.',
  'centroatleticoclubamerica@gmail.com', '0251-4411594','Incentivando y promoviendo la participaci�n cultural y deportiva','true', 'http://i.imgur.com/bzOnmjv.png');

-- insertando datos al portal (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO portal (id_portal, instalacion, socio, evento, foto_socio, foto_instalaciones, foto_evento)
VALUES  (1, 'El Centro Atl�tico America cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Adem�s cuenta con un sal�n de Fiestas y dos Caneis para el disfrute de sus socios e invitados', 
'Nuestros socios se caracterizan por su familiaridad y buen comportamiento, ayudando as� a mantener las tradiciones de club. �Quieres ser un socio del Centro Atl�tico America?', 
'Nos interesa Motivar la interacci�n social a trav�s de actividades culturales de intercambio en busca del crecimiento humano mediante la realizaci�n de eventos. �Quieres participar en nuestros eventos?',
'http://i.imgur.com/lCSPRiL.png', 'http://i.imgur.com/ccWOi9A.png', 'http://i.imgur.com/KBRnFaM.png');
    