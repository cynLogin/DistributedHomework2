function renderOrderContentTable(table,data) {
    data.forEach(function (product) {
        product.price = calculateAmount(product);
    });
    // 渲染表格
    table.render({
        elem: '#orderContentTable',
        data: data,
        toolbar: '#toolbar',
        defaultToolbar: ['filter', 'exports'],
        cols: [[
            { field: 'id', width: 100, title: '产品编号' },
            { field: 'productName', width: 100, title: '产品名称' },
            { field: 'unitPrice', width: 100, title: '单价' },
            { field: 'quantity', width: 120, title: '数量' },
            { field: 'price', width: 120, title: '金额' },
        ]],
        page: true
    });
}
function calculateAmount(product) {
    return product.unitPrice * product.quantity;
}