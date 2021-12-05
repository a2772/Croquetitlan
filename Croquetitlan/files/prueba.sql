USE croquetitlan_db;
-- Pruebas
-- select d.email, d.nombre, d.apPat from catjerarquia cj,datos d,trabajadores t,pass p where cj.idjerarquia=t.idjerarquia2 and d.iddatos=t.iddatos2 and t.idtrabajador=p.idtrabajador and d.email='paris.140815@gmail.com' and p.pass='passw0rd';
-- select * from catjerarquia cj,datos d,trabajadores t,pass p where cj.idjerarquia=t.idjerarquia2 and d.iddatos=t.iddatos2 and t.idtrabajador=p.idtrabajador and d.email= 'paris.140815@gmail.com' and p.pass= 'passw0rd';
-- SELECT *,IF(pagado, 'true', 'false') pagado2 FROM gastos g, catgastos cg where g.idgastos=cg.idgastos;
-- SELECT * FROM catestados ce, catmunicipios cm, clientefrecuente cf, datos d, catestatus e where cf.iddatos=d.iddatos and cf.idestatus=e.idestatus and ce.idestado=cm.idestado and cm.idmunicipio=d.idmunicipio;
-- SELECT * FROM catestados ce, catmunicipios cm, datos d, trabajadores t, pass p where t.iddatos2=d.iddatos and p.idtrabajador=t.idtrabajador and ce.idestado=cm.idestado and cm.idmunicipio=d.idmunicipio;
-- select * from vproductoent ve, transacciones tr, producto pr, catproducto cp where ve.idtransaccion=tr.idtransaccion and ve.idprod=pr.idprod and pr.idproducto2=cp.idproducto;
-- select * from vproductogra vg, transacciones tr, gramaje gr, catgramaje cg, catproducto cp where vg.idtransaccion2=tr.idtransaccion and vg.idgram=gr.idgram and gr.idgramaje=cg.idgramaje and cp.idproducto=cg.idproducto;
update producto set fechacaducidad='2000-01-01',cantidad=2,preciouni=2,pesocostal=2 where idprod=10;
select * from producto;