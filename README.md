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

## 网址说明

- http://localhost:8080/admin/home/{ID}; 管理员主页(admin-home.html)



- "http://localhost:8080/customerDetail/" {ID}; 客户详情页(customer-detail.html)
- "http://localhost:8080/customerModify/" {ID} ; 客户信息修改页(customer-control.html)



- http://localhost:8080/employee/home/{ID} ; 员工主页(employee-home.html)
- "http://localhost:8080/employeeinfo/"+emplyeeID; 员工信息修改页(employee-control.html)
- "http://localhost:8080/admin/employeecontrol"; 员工管理页(employee-management.html)



- "http://localhost:8080/orderDetail/" + selectedData.id; 订单详情页(order-detail.html)

- "http://localhost:8080/employee/addorder"+{employeeID} ; 添加订单页(order-add.html)

  

- "http://localhost:8080/admin/productcontrol"; 产品管理页(product-management.html)

- "http://localhost:8080/admin/productModify/" + selectedData.id; 产品信息修改页(product-control.html)

  

## customer-detail界面

- "http://localhost:8080/getcustomerinfo/" + customerID,GET

​		根据客户ID返回客户信息

```javascript
$.ajax({
                    type: "GET",
                    url: "http://localhost:8080/getcustomerinfo/" + customerID,
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

- http://localhost:8080/customerModify/" {ID} 

​		跳转到修改客户信息页面

## cusotmer-control界面

- "http://localhost:8080/modifycustomer",POST

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

- http://localhost:8080/modifycustomer/delete, POST

  删除根据客户ID删除客户,报文内容:

```js
let formData = {
                    id: customerID
                };
```

## emplyee-control.html

- "http://localhost:8080/getemployeeinfo/" + employeeID,GET

​	根据员工ID获取员工信息

- "http://localhost:8080/modifyemployee",POST 

  根据员工ID修改员工信息,员工ID在报文中,报文数据如下:

```js
let formData = {
                id: employeeID,
                newName: newName,
                newGender: newGender,
                newPhone: newPhone,
            }
```

- "http://localhost:8080/modifyemployee/delete", POST

​		根据ID删除员工,员工ID在报文中

```js
let formData = {
                id: employeeID
            };
```

## emplyee-home.页面

- http://localhost:8080/employee/querycustomer , POST

  根据输入的姓名,电话和员工ID查询该员工的客户,返回查询到的客户列表,注意姓名和用户都为""时返回该员工所有客户

  发送报文和返回格式:

```js
let queryData = {
        "userName": queryName,
        "phoneNumber": queryPhone,
        "employeeID": employeeID
    };

cols: [[
                    { field: 'id', width: 100, title: '客户编号' },
                    { field: 'username', width: 100, title: '客户姓名' },
                    { field: 'gender', width: 100, title: '客户性别' },
                    { field: 'phoneNumber', width: 120, title: '客户电话' },
                    { field: 'totalConsumption', width: 120, title: '消费额' },
                ]],
```

- http://localhost:8080/employee/getcustomer ,POST

  返回该员工的,发送数据为员工ID,所有用户,按最近下单时间排序,返回格式为:

```js
let formData={
        "employeeID":employeeID
    }

cols: [[
                    { field: 'id', width: 100, title: '客户编号' },
                    { field: 'username', width: 100, title: '客户姓名' },
                    { field: 'gender', width: 100, title: '客户性别' },
                    { field: 'phoneNumber', width: 120, title: '客户电话' },
                    { field: 'totalConsumption', width: 120, title: '消费额' },
                    { field: 'recentOrderTime', width: 120, title: '最近下单时间' },
                ]],
```

- http://localhost:8080/getorder , GET

  返回所有订单的列表,返回格式:

```js
cols: [[
                    { field: 'id', width: 100, title: '订单编号' },
                    { field: 'orderTime', width: 100, title: '下单时间' },
                    { field: 'amountMoney', width: 100, title: '订单金额' },
                    { field: 'content', width: 120, title: '订单内容' },
                    { field: 'completionStatus', width: 120, title: '完成状态' },
                ]],
```

## employee-management页面

- "http://localhost:8080/admin/allemployee" GET

​		获取所有员工信息,返回格式如下:

```js
cols: [[
                    { field: 'id', width: 100, title: '员工编号' },
                    { field: 'username', width: 100, title: '员工姓名' },
                    { field: 'gender', width: 100, title: '员工性别' },
                    { field: 'phoneNumber', width: 120, title: '员工电话' },             
                ]],
```

- http://localhost:8080/admin/queryemployee , POST

​		根据员工姓名和电话查询员工,返回格式与上一个相同,报文格式如下:

```js
let queryData = {
        "username": queryName,
        "phoneNumber": queryPhone
    };
```

- http://localhost:8080/admin/addemployee ,POST

​		添加新员工,发送员工姓名,性别,电话,若添加成功返回"success",数据格式如下:

```js
let formData={
                    addName:addName,
                    addPhone:addPhone,
                    addGender:addGender
                }
```

## order-add页面

- http://localhost:8080/queryProduct , POST

​		根据产品名称查询产品,若产品名称为"",则返回全部产品,如果查询成功,返回"success",数据格式:

```js
let queryData = {
        "name": queryName
    }

cols: [[
                    { field: 'id', width: 100, title: '产品编号' },
                    { field: 'productName', width: 100, title: '产品名称' },
                    { field: 'unitPrice', width: 100, title: '单价' },
                    { field: 'inventoryNum', width: 120, title: '库存数量' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar2', title: '操作' }
                ]],
```

- http://localhost:8080/addorder ,POST

​		根据发送的数据创建订单,创建成功返回"succes",数据格式如下:

​		包括客户姓名,订单备注,订单总金额,订单内容列表[{产品ID,数量}]

```js
let requestOrderContent=[];
    orderContent.forEach(function (product) {
        let requestProduct={
            "productId":product.id,
            "quantity":product.quantity
        };
        requestOrderContent.push(requestProduct);
    });
    
    let formData={
        "customerName":customerName,
        "orderRemark":orderRemark,
        "totalPrice":totalPrice,
        "orderContent":requestOrderContent
    };
```

## order-detail 页面

- http://localhost:8080/getorderinfo/" + orderID , GET

​		根据订单编号返回订单信息,返回的信息如下:

```js
success: function (response) {
                            $("#orderID").val(response.id);
                            $("#price").val(response.amountMoney);
                            $("#date").val(response.orderTime);
                            $("#remark").val(response.remark);
                            $("#content").val(response.content);
                            // 产品列表
                            let data=response.content;
                            renderOrderContentTable(table,data);
                            customerID=response.consumerId;
                        },
```

- "http://localhost:8080/updateorderstatus , POST

​		根据订单编号改变订单状态,修改成功返回"success",数据格式如下

```js
let formData={
                        "status":status,
                        "orderID":orderID
                    }
```

- http://localhost:8080/deleteorder , POST

​		根据发送的订单ID删除订单,删除成功返回"success",数据格式如下:

```js
let formData={
                        "orderID":orderID
                    }
```

## product-control 页面

- http://localhost:8080/admin/modifyproduct , POST

​		根据产品ID修改产品信息,修改成功返回"success"

```js
let formData={
                    "id":id,
                    "name":name,
                    "price":price,
                    "inventory":inventory
                };
```

- http://localhost:8080/admin/getproduct ,POST

​		根据ID返回产品信息

```js
let formData = {
                id: productID
            };

success: function (response) {
                    $("#queryID").val(response.id);
                    $("#queryName").val(response.productName);
                    $("#queryPrice").val(response.unitPrice);
                    $("#queryInventory").val(response.inventoryNum);
                },
```

- "http://localhost:8080/admin/deleteproduct",POST

​		根据产品ID删除产品,删除成功返回"success"

```js
let formData = {
                id: productID
            };
```

## product-management 页面

- "http://localhost:8080/admin/addproduct" POST

​		添加新产品,添加成功返回"success"

```js
let formData={
                    "id":productID,
                    "productName":productName,
                    "unitPrice":unitPrice
                }
```

- http://localhost:8080/allProduct ,GET

​		返回全部产品的信息列表,

```js
cols: [[
                    { field: 'id', width: 100, title: '产品编号' },
                    { field: 'productName', width: 100, title: '产品名称' },
                    { field: 'unitPrice', width: 100, title: '单价' },
                    { field: 'inventoryNum', width: 120, title: '库存数量' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
```

> 2023.12.2 YQY

- http://localhost:8080/employee/addcustomer/ + employID ; 注册客户页(customer-add.html)



- http://localhost:8080/employee/addcustomer POST

​		根据发送的数据注册新客户,注册成功返回"success"

```js
let formData={
                    username: name,
                    gender: gender,
                    phoneNumber: phone,
                    address: address,
                    employeeID: employeeID
                }
```

# 测试

> YQY

## 测试不通过

- http://localhost:8080/admin/employeecontrol

​		解决: 删除路由中的{ID}

- 

## 测试通过

- http://localhost:8080/admin/home/1 OK
- http://localhost:8080/admin/productcontrol OK
- http://localhost:8080/employee/home/1 OK
- http://localhost:8080/employee/addorder/1 OK
- http://localhost:8080/employeeinfo/1 OK
- http://localhost:8080/customerDetail/1 OK
- http://localhost:8080/customerModify/1 OK
- http://localhost:8080/orderDetail/1 OK
- http://localhost:8080/admin/productModify/1
