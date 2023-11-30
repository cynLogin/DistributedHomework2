function renderProductData(table) {
    let productData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/allProduct",
        success: function (response) {
            productData = response;

            // 渲染表格
            table.render({
                elem: '#productTable',
                data: productData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '产品编号' },
                    { field: 'productName', width: 100, title: '产品名称' },
                    { field: 'unitPrice', width: 100, title: '单价' },
                    { field: 'inventoryNum', width: 120, title: '库存数量' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });

            //监听行工具事件
            table.on('tool(orderInfoTable)', function (obj) {
                if (obj.event == 'add') {
                    // 查看订单详情
                    let selectedData = obj.data;
                    console.log("添加", selectedData);
                    

                } else if(obj.event == 'delete') {
                    let selectedData = obj.data;
                    console.log("删除", selectedData);

                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}

