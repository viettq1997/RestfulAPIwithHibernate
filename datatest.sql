
INSERT INTO project VALUES (1,'Google');
INSERT INTO project VALUES (2,'Youtube');
INSERT INTO project(name) VALUES ('Facebook');
INSERT INTO project(name) VALUES ('Baidu');
INSERT INTO project(name) VALUES ('Wikipedia');
INSERT INTO project(name) VALUES ('Yahoo');
INSERT INTO project(name) VALUES ('Reddit');
INSERT INTO project(name) VALUES ('amazon');

INSERT INTO staff VALUES (1,'viettq',1,1,'QuocViet','QuocViet12345@gmail.com','8142219473','imageViet','VietPro1997','QuocViet','NgheAn',1,'leader','02/25/2019','BKAptech',1);
INSERT INTO staff VALUES (3,'viettq',1,1,'QuocViet','QuocViet12345@gmail.com','8142219473','imageViet','VietPro1997','QuocViet','NgheAn',1,'leader','02/25/2019','BKAptech',1);
INSERT INTO staff VALUES (2,'hq',1,0,'QuangHuy','QuangHuy12345@gmail.com','8142219472','imageHuy','HuyPro1998','QuangHuy','HaNoi',1,'leader','03/25/2019','FptAptech',2);
INSERT INTO staff(username,roless,status,names,email,phone,avatar,addr_sky,addr_fb,address,levelss,major,finishs,school,id_project) VALUES ('va',2,0,'VietAnh','VietAnh12345@gmail.com','81422194734','imageAnh','AnhPro1997','VietAnh','HaNoi',1,'leader','04/25/2019','FptAptech',3);
INSERT INTO staff(username,roless,status,names,email,phone,avatar,addr_sky,addr_fb,address,levelss,major,finishs,school,id_project) VALUES ('pn',3,1,'PhamNam','PhamNam12345@gmail.com','8142219475','imageNam','NamPro1997','PhamNam','VinhPhuc',1,'leader','05/25/2019','Aptech',4);
INSERT INTO staff(username,roless,status,names,email,phone,avatar,addr_sky,addr_fb,address,levelss,major,finishs,school,id_project) VALUES ('vq',2,0,'VanQuan','VanQuan12345@gmail.com','8142219477','imageQuan','QuanPro1997','VanQuan','HaNoi',1,'leader','06/25/2019','Aptech',5);

INSERT INTO timesheet VALUES(1,'Google','02/15/2018',1,'',1,1,1);
INSERT INTO timesheet VALUES(2,'Youtube','03/15/2018',0,'',0,2,2);
INSERT INTO timesheet(task,times,results,note,status,id_project,id_staff) VALUES('Facebook','04/15/2018','hoan thanh','',1,3,3);
INSERT INTO timesheet(task,times,results,note,status,id_project,id_staff) VALUES('Baidu','05/15/2018','hoan thanh','',0,4,4);
INSERT INTO timesheet(task,times,results,note,status,id_project,id_staff) VALUES('Wikipedia','06/15/2018','hoan thanh','',1,5,5);


INSERT INTO news VALUES(1,'Th??ng ??nh M? - Tri?u: Vi?t Nam ch? có 10 ngày ?? chu?n b?','image1','02/27/2019','Lãnh ??o B? Thông tin và Truy?n thông, B? Ngo?i giao và thành ph? Hà N?i ??ng ch? trì h?p báo v? công tác chu?n b? c?a Vi?t Nam cho h?i ngh? th??ng ??nh M? - Tri?u.',1);
INSERT INTO news VALUES(2,'N? sinh Vi?t Nam t?ng hoa Ch? t?ch Kim Jong Un: "Ông ?y ?ã nói c?m ?n và c??i r?t t??i','image3','02/27/2019','Lãnh ??o B? Thông tin và Truy?n thông, B? Ngo?i giao và thành ph? Hà N?i ??ng ch? trì h?p báo v? công tác chu?n b? c?a Vi?t Nam cho h?i ngh? th??ng ??nh M? - Tri?u.',2);
INSERT INTO news VALUES(3,'N? sinh Vi?t Nam t?ng hoa Ch? t?ch Kim Jong Un: "Ông ?y ?ã nói c?m ?n và c??i r?t t??i','image3','02/27/2019','Lãnh ??o B? Thông tin và Truy?n thông, B? Ngo?i giao và thành ph? Hà N?i ??ng ch? trì h?p báo v? công tác chu?n b? c?a Vi?t Nam cho h?i ngh? th??ng ??nh M? - Tri?u.',3);
INSERT INTO news(title,image,dates,contentt,id_staff) VALUES('C?n c?nh nhan s?c xinh ??p c?a n? sinh L?ng S?n t?ng hoa ông Kim Jong Un ? ??ng ??ng','image4','02/27/2019','Lãnh ??o B? Thông tin và Truy?n thông, B? Ngo?i giao và thành ph? Hà N?i ??ng ch? trì h?p báo v? công tác chu?n b? c?a Vi?t Nam cho h?i ngh? th??ng ??nh M? - Tri?u.',4);
INSERT INTO news(title,image,dates,contentt,id_staff) VALUES('Hàng lo?t ?n t??ng ??c bi?t v? n? sinh t?ng hoa Ch? t?ch Tri?u Tiên Kim Jong-un','image5','02/27/2019','Lãnh ??o B? Thông tin và Truy?n thông, B? Ngo?i giao và thành ph? Hà N?i ??ng ch? trì h?p báo v? công tác chu?n b? c?a Vi?t Nam cho h?i ngh? th??ng ??nh M? - Tri?u.',5);


INSERT INTO bugs VALUES(1,'Link t? trang này ??n trang khác không ho?t ??ng',3);
INSERT INTO bugs VALUES(2,'Link t? trang này ??n trang khác b? sai',3);
INSERT INTO bugs(names,id_staff) VALUES('L?i khi nh?p các th? HTML,kí t? ??c bi?t,kí t? m? r?ng…và các ô Textbox',3);
INSERT INTO bugs(names,id_staff) VALUES('Không check các tr??ng nh?p li?u liên quan quan ??n ngày tháng',4);
INSERT INTO bugs(names,id_staff) VALUES('Không hi?n th? ho?c hi?n th? sai các thông báo l?i khi x?y ra l?i nh?p li?u trên màn hình',5);



INSERT INTO commentbugs(status,id_bugs,id_staff) VALUES(1,1,1);
INSERT INTO commentbugs(status,id_bugs,id_staff) VALUES(0,2,2);
INSERT INTO commentbugs(status,id_bugs,id_staff) VALUES(1,3,3);
INSERT INTO commentbugs(status,id_bugs,id_staff) VALUES(0,4,4);
INSERT INTO commentbugs(status,id_bugs,id_staff) VALUES(1,5,5);



INSERT INTO request VALUES(1,1,1,1);
INSERT INTO request VALUES(2,2,0,2);
INSERT INTO request(request_type,status,id_staff) VALUES(1,0,3);
INSERT INTO request(request_type,status,id_staff) VALUES(3,0,4);
INSERT INTO request(request_type,status,id_staff) VALUES(4,1,5);


INSERT INTO reports VALUES(1,1,1,null,null,null);
INSERT INTO reports VALUES(2,1,1,null,null,null);
INSERT INTO reports VALUES(3,1,2,'anh anh anh',null,null);
INSERT INTO reports(id_project,id_ts) VALUES(2,2);
INSERT INTO reports(id_project,id_ts) VALUES(2,3);
INSERT INTO reports(id_project,id_ts) VALUES(2,4);
INSERT INTO reports(id_project,id_ts) VALUES(2,5);
INSERT INTO reports(id_project,id_ts) VALUES(1,1);
--select news0_.ID_NEW as ID_NEW1_2_, news0_.CONTENTT as CONTENTT2_2_, news0_.DATES as DATES3_2_, news0_.IMAGE as IMAGE4_2_, news0_.ID_STAFF as ID_STAFF6_2_, news0_.TITLE as TITLE5_2_ from DB_OFFICE_MANAGER.NEWS news0_
--commit
--delete project where id_project = 1;


--select ts.id_project , ts.id_staff,ts.times from Timesheet ts where results = 0
--
--delete timesheet where id_ts = 1 when delete reports where id_ts = 1
