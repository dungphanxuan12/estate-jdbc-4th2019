# estate-jdbc-4th2019
estate project learning from laptrinhjavaweb.com

Cập nhật 24/10/2019 building mapper
-Xây dựng Interface Rowmapper
-Tạo class BuildingMapper implements từ Interface Rowmapper

resultSet->entity->DTO->Controller

restful (API)
DTO->controller
DTO->API

Entity đại diện cho table
DTO trung gian giữa UI,Controller,API -> entity -> DB
...............................................................
*Sửa hàm ResultSetMapmer và thiết kế database phần 2 (4/5/2019)
Lỗi id =  null
vấn đề: mapRow truyền vào BuildingEntity 
		nên mapRow chỉ Scan các trường nằm trong BuildingEntity 
		Nhưng id nằm ở BaseEntity được BuildingEntity kế thừa lại nên không nhận Data
		

...............................................................
Convert DTO <=> Entity
-Model mapper
-Mapstruct

.....................
khi dùng GET chắc chắn tham số sẽ ở trên URL
ex:
/login?username=dungphan&password=123


..............................................................
Bug:
khi new một StringBuilder phải khởi tạo giá trị 
new StringBuilder();//Sai
new StringBuilder("");

..............................................................
Mothod createSQLUpdate()
id chắc chắc sẽ nằm ở phần check parents
vì id nằm trong BaseEntity chứ không nằm trong class hiện tại
.............................................................
DELETE FROM table_name WHERE condition;
.............................................................

PrepareStatement không được boot thẳng tham số vào id =  ?
Statement có thể boot thẳng tham số vào id = 1

............................................................
Sitemesh phần chia giao diện theo url

............................................................
UI Sitemesh

admin.jsp trong default dir là parent (master layout) cho admin
trong đây có <dec:body>
dựa theo url được request thì body sẽ thay đổi cho tương ứng
sẽ dựa vào views gọi ra
nên trong views chỉ có body



























