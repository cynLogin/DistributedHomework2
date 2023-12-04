# 测试

> YQY : 视图测试

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
- http://localhost:8080/admin/productModify/1 OK



> 接口测试

##  cusotmer-detail界面

- "http://localhost:8080/getcustomerinfo/" + customerID,GET OK
-  加载订单列表失败

## customer-control 界面

- "http://localhost:8080/modifycustomer",POST 通过

- http://localhost:8080/modifycustomer/delete, POST 通过

## employee-control界面

- "http://localhost:8080/getemployeeinfo/" + employeeID,GET 通过
- "http://localhost:8080/modifyemployee",POST  通过

- "http://localhost:8080/modifyemployee/delete", POST 通过

## employee-home界面

- http://localhost:8080/employee/querycustomer , POST 不通过,模糊查询没有返回值
  - 修改后通过

- http://localhost:8080/employee/getcustomer ,POST 不通过,数据库不一致,没有最近创建订单时间的列
  - 通过,但后端没有返回最近创建订单时间,需要修改
  - 修改后通过




## employee-management页面

- /admin/allemployee GET 通过,需要修改前端表格
- http://localhost:8080/admin/queryemployee , POST 通过
- http://localhost:8080/admin/addemployee , POST 通过





## order-add页面

-  http://localhost:8080/queryProduct , POST 查询产品 通过
- http://localhost:8080/addorder ,POST 待测





## order-detail 页面

- http://localhost:8080/getorderinfo/" + orderID , GET

- "http://localhost:8080/updateorderstatus , POST

- http://localhost:8080/deleteorder , POST

## product-control 页面

- http://localhost:8080/admin/modifyproduct , POST 修改产品信息,通过

- http://localhost:8080/admin/getproduct ,POST 通过 获取产品信息 通过
- "http://localhost:8080/admin/deleteproduct",POST  通过



## product-management 页面

- http://localhost:8080/admin/addproduct" POST 通过
- http://localhost:8080/allProduct ,GET 通过

- http://localhost:8080/admin/getproduct ,POST 通过

# 需要添加功能

- "http://localhost:8080/modifyemployee/password" POST 发送原密码和新密码和员工ID,进行修改

```js
let formData = {
                id: employeeID,
                nowPassword: nowPassword,
                newPassword: newPassword,
            }
```

- http://localhost:8080/admin/order/all GET 返回所有订单信息
- http://localhost:8080/admin/customer/all GET 返回所有客户信息
- 添加订单和订单详情页的功能
