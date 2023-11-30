function renderOrderData(table, customerId) {
    var orderInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/order/bycustomerid/"+customerId,
        success: function (response) {
            orderInfoData = response;

            // 渲染表格
            table.render({
                elem: '#orderInfoTable',
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
                    window.location.href = "http://localhost:8080/employee/orderDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}

