--insertando club (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO club (id_club, rif, nombre, direccion, telefono, mision, vision, correo, telf_alternativo, eslogan, activo)
	VALUES  ( 1, 'J-2015871-0', 'Centro Atlético America', 'Av. Fuerzas Armadas con Calle 57, Concepcion, Barquisimeto.', '0251-8837841', 'Brindar y promover el disfrute de sus socios y familiares, en espacios aptos para actividades deportivas, culturales y sociales, fomentando la unión familiar y consolidando el legado de sus fundadores.',
	'Constituirnos como la institución social por excelencia dedicada a consolidar valores sociales, culturales y deportivos que permitan el crecimiento de sus afiliados y sus familiares e impulsar la transformación consolidando un ambiente cada día más idóneo para el desarrollo biopsicosocial de nuestras generaciones.',
	'centro_atletico_america@gmail.com', '0251-3654785','Incentivando y promoviendo la participación cultural y deportiva
como medio de fortalecimiento de relaciones familiares y sociales','true');

-- insertando datos al portal (OBLIGATORIAMENTE EL ID DEBE SER 1 FAVOR NO CAMBIAR, YA QUE NO FUNCIONARA)
INSERT INTO portal (id_portal, instalacion, socio, evento)
VALUES  (1, 'El Centro Atlético América cuenta con canchas de tenis, baloncesto, beisbol, bolas criollas. Además cuenta con un salón de Fiestas y dos Caneis para el disfrute de sus socios e invitados', 
'Nuestros socios se caracterizan por su familiaridad y buen comportamiento, ayudando así a mantener las tradiciones de club. ¿Quieres ser un socio del Centro Atlético América?', 
'Nos interesa Motivar la interacción social a través de actividades culturales de intercambio en busca del crecimiento humano mediante la realización de eventos. ¿Quieres participar en nuestros eventos?');
		