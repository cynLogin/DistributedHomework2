function renderQueryCustomerTable(table,queryName,queryPhone,employeeID) {
    let queryCustomerInfoData;
    let queryData = {
        "userName": queryName,
        "phoneNumber": queryPhone,
        "employeeID": employeeID
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/employee/querycustomer",
        data: JSON.stringify(queryData),
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            queryCustomerInfoData = response;
            console.log("查询客户返回:", queryCustomerInfoData);
            // 渲染表格
            table.render({
                elem: '#queryCustomerTable',
                data: queryCustomerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '客户编号' },
                    { field: 'username', width: 100, title: '客户姓名' },
                    { field: 'gender', width: 100, title: '客户性别' },
                    { field: 'phoneNumber', width: 120, title: '客户电话' },
                    { field: 'totalConsumption', width: 120, title: '消费额' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(queryCustomerTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看用户详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/customerDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}
function renderCustomerFollowTable(table,employeeID) {
    let queryCustomerInfoData;
    let formData={
        "employeeID":employeeID
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/employee/getcustomer",
        data: JSON.stringify(formData),
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            queryCustomerInfoData = response;
            console.log("跟进客户返回:", queryCustomerInfoData);
            // 渲染表格
            table.render({
                elem: '#customerFollowTable',
                data: queryCustomerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '客户编号' },
                    { field: 'username', width: 100, title: '客户姓名' },
                    { field: 'gender', width: 100, title: '客户性别' },
                    { field: 'phoneNumber', width: 120, title: '客户电话' },
                    { field: 'totalConsumption', width: 120, title: '消费额' },
                    { field: 'recentOrderTime', width: 120, title: '最近下单时间' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(customerFollowTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看用户详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/customerDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}
function renderOrderTable(table) {
    let queryCustomerInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/getorder",
        success: function (response) {
            queryCustomerInfoData = response;
            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: queryCustomerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '订单编号' },
                    { field: 'orderTime', width: 100, title: '下单时间' },
                    { field: 'amountMoney', width: 100, title: '订单金额' },
                    { field: 'content', width: 120, title: '订单内容' },
                    { field: 'completionStatus', width: 120, title: '完成状态' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(orderTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看用户详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/orderDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}