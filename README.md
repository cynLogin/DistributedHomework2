# DistributedHomework2
已经搭建好基本框架，数据库application.yml里的数据库名、密码等还没写，使用JDK21，java17

>功能设计
- 两个面板：管理人员面板、销售人员面板
- 销售人员：
- 1. 查询自己的客户（ID，姓名，手机号，最近交涉时间（感觉可以根据他的所有订单里最新更新的时间为最新时间））
  2. 点开客户，有该客户的订单（时间倒序）
  3. 更新某个客户的某个订单是否完成
  4. 创建订单（自动创建客户）
- 管理人员：
  1. 管理销售
  2. 查询销售人

cynLogin
1. 数据库设计，写出数据库代码

YQYJin
1. Web设计，设计需要的html页面，并先构建出静态的页面，js先不写

之后就是前端提需求，后端实现，留接口

>2023.11.13 YQY
- 用户登录,管理员登录模板界面
- 添加 */resource/mysql/database.sql* 作为构建数据库的sql文件,数据库操作都通过向该文件
中添加sql代码执行,以保证数据库一致性



> 2023.12.1 YQY

## customer-detail界面

- "http://localhost:8080/employee/getcustomerinfo/" + customerID,GET

​		根据客户ID返回客户信息

```javascript
$.ajax({
                    type: "GET",
                    url: "http://localhost:8080/employee/getcustomerinfo/" + customerID,
                    success: function (response) {
                        $("#userID").val(response.id);
                        $("#userName").val(response.username);
                        $("#gender").val(response.gender);
                        $("#phone").val(response.phoneNumber);
                        $("#consumption").val(response.totalConsumption);
                        $("#address").val(response.address);
                    },
                    error: function (error) {
                        console.log("Error:" + error);
                    }
                });
```

- http://localhost:8080/employee/modifycustomer/"+customerID 

​		跳转到修改客户信息页面

## cusotmer-managemetn界面

- "http://localhost:8080/employee/getcustomerinfo/" + customerID,GET

​		同上

- "http://localhost:8080/employee/modifycustomer",POST

​		根据发送的报文信息修改客户信息,报文内容如下

```js
let formData={
                    id:customerID,
                    newName:newName,
                    newGender:newGender,
                    newPhone:newPhone,
                    newConsumption:newConsumption,
                    newAddress:newAddress
                }
```

- http://localhost:8080/employee/modifycustomer/delete, POST

  删除根据客户ID删除客户,报文内容:

```js
let formData = {
                    id: customerID
                };
```

## emplyee-control.html

- http://localhost:8080/employee/getemployeeinfo/" + employeeID,GET

​	根据员工ID获取员工信息

- "http://localhost:8080/employee/modifyemployee",POST 

  根据员工ID修改员工信息,员工ID在报文中,报文数据如下:

```js
let formData = {
                id: employeeID,
                newName: newName,
                newGender: newGender,
                newPhone: newPhone,
            }
```

- "http://localhost:8080/employee/modifyemployee/delete", POST

​		根据ID删除员工,员工ID在报文中

```js
let formData = {
                id: employeeID
            };
```

## emplyee-home.html

