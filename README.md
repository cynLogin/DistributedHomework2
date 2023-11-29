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

> 2023.11.29 YQY

接口说明:

- /employee/getcustomerinfo/{customerID},GET:返回客户信息,字段名id,username,gender,phoneNumber,totalConsumption,address
- /employee/order/bycustomerid/{customerID},GET: 返回订单列表,字段:id,orderTime,amountMoney,completionStatus,content(订单内容)
- /employee/orderDetail/{orderID},GET:返回根据id查询到的订单信息
- /employee/createOrder,POST:创建新订单
- /employee/querycustomer,POST: 发送数据{customerName:name,customerPhone:phone},返回到的客户信息

- /employee/addnewproduct,POST:创建新产品,报文内容:{productID,productName,unitPrice},创建成功返回"success"

- /employee/allProduct,GET:获取全部产品信息,返回报文结构应为列表,包括信息:{id,productName,unitPrice,inventoryNum}
