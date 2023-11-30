function renderOrderData(table) {
    var orderInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/order/all",
        success: function (response) {
            orderInfoData = response;

            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: orderInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '订单编号' },
                    { field: 'orderTime', width: 100, title: '交易日期' },
                    { field: 'amountMoney', width: 100, title: '订单金额' },
                    { field: 'content', width: 120, title: '订单内容' },
                    { field: 'completionStatus', width: 120, title: '订单状态' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/admin/orderDetail/" + selectedData.id;
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

            // 渲染表格
            table.render({
                elem: '#orderTable',
                data: customerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '客户编号' },
                    { field: 'userName', width: 100, title: '客户姓名' },
                    { field: 'gender', width: 100, title: '客户性别' },
                    { field: 'phoneNumber', width: 120, title: '客户电话' },
                    { field: 'totalConsumption', width: 120, title: '消费额' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看订单详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/admin/customerDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}