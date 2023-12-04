function renderOrderData(table) {
    var orderInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/order/all",
        success: function (response) {
            orderInfoData = response;
            console.log("全部订单返回:", orderInfoData);
            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: orderInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', title: '订单编号' },
                    { field: 'orderTime', title: '交易日期' },
                    { field: 'amountMoney', title: '订单金额' },
                    { field: 'content', title: '订单内容' },
                    { field: 'completionStatus', title: '订单状态' },
                    { fixed: 'right', align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
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

function renderCustomerData(table) {
    var customerInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/customer/all",
        success: function (response) {
            customerInfoData = response;
            console.log("全部客户返回:", customerInfoData);
            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: customerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', title: '客户编号' },
                    { field: 'userName', title: '客户姓名' },
                    { field: 'sex', title: '客户性别' },
                    { field: 'phoneNumber', title: '客户电话' },
                    { field: 'totalConsumption', title: '消费额' },
                    { fixed: 'right', align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
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