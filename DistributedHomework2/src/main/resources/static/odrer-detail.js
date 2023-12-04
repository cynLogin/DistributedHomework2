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
            { field: 'id',  title: '产品编号' },
            { field: 'productName',  title: '产品名称' },
            { field: 'unitPrice',  title: '单价' },
            { field: 'quantity',  title: '数量' },
            { field: 'price',  title: '金额' },
        ]],
        page: true
    });
}
function calculateAmount(product) {
    return product.unitPrice * product.quantity;
}