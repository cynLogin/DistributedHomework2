// 用于存储查询到的产品信息
var productInfo;
// 用于存储订单内容
var orderContent = [];
function renderProductTable(table, layer, queryName) {
    // 如果queryName为空字符串，则查询所有产品
    let queryData = {
        "name": queryName
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/queryProduct",
        data: JSON.stringify(queryData),
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            productInfo = response;
            console.log("查询产品返回:", productInfo);
            // 渲染表格
            table.render({
                elem: '#productQueryTable',
                data: productInfo,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '产品编号' },
                    { field: 'productName', width: 100, title: '产品名称' },
                    { field: 'unitPrice', width: 100, title: '单价' },
                    { field: 'inventoryNum', width: 120, title: '库存数量' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar2', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(productQueryTable)', function (obj) {
                if (obj.event == 'add') {
                    // 添加订单内容
                    let selectedData = obj.data;
                    console.log("添加产品", selectedData);

                    layer.open({
                        type: 1,
                        title: '输入数量',
                        area: ['400px', '200px'],
                        content: $('#quantityPopup'),
                        success: function (layero, index) {
                            // 清空输入框
                            $("input[name='quantity']").val('');
                        }
                    });

                    $("#okBtn").on("click", function () {
                        let quantity = $("#quantity").val();
                        console.log('数量：', quantity);
                        layer.closeAll();
                        $("#okBtn").off("click");
                        $("#cancelBtn").off("click");
                        // 添加产品数量
                        selectedData.quantity = quantity;

                        // 计算本条金额
                        let price = calculateAmount(selectedData);
                        selectedData.price = price;
                        // 添加到订单内容中
                        orderContent.push(selectedData);
                    });
                    $("#cancelBtn").on("click", function () {
                        $("#okBtn").off("click");
                        $("#cancelBtn").off("click");
                        layer.closeAll();
                    });
                }
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}
function renderOrderContentTable(table) {
    table.render({
        elem: '#orderContentTable',
        data: productInfo,
        toolbar: '#toolbar',
        defaultToolbar: ['filter', 'exports'],
        cols: [[
            { field: 'id', width: 100, title: '产品编号' },
            { field: 'productName', width: 100, title: '产品名称' },
            { field: 'unitPrice', width: 100, title: '单价' },
            { field: 'quantity', width: 120, title: '数量' },
            { field: 'price', width: 120, title: '金额' },
            { fixed: 'right', width: 200, align: 'center', toolbar: '#bar1', title: '操作' }
        ]],
        page: true
    });
    //监听行工具事件
    table.on('tool(orderContentTable)', function (obj) {
        if (obj.event == 'delete') {
            let selectedData = obj.data;
            console.log("删除产品", selectedData);
            let deleteName = selectedData.productName;
            let deletedList = orderContent.filter(function (obj) {
                return obj.productName !== deleteName;
            });
            orderContent = deletedList;
            renderOrderContentTable(table);
            // 计算总金额
            let totalAmount = calculateTotalAmount(orderContent);
            $("#totalPrice").val(totalAmount);
        }
    });
}
function addOrder(){
    let customerName = $("#customerName").val();
    let orderRemark = $("#orderRemark").val();
    let totalPrice=$("#totalPrice").val();
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

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/addorder",

        data: JSON.stringify(formData),
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            return response;
        },
        error: function (error) {
            console.log("Error:" + error);
            return "fail";
        }
    });
    return "fail";
}

// 用于计算订单总价
function calculateAmount(product) {
    return product.unitPrice * product.quantity;
}

// 计算整个数组的总金额
function calculateTotalAmount(products) {
    // 初始总金额为0
    let totalAmount = 0;

    // 遍历数组，累加每个产品的金额
    products.forEach(function (product) {
        totalAmount += calculateAmount(product);
    });

    return totalAmount;
}