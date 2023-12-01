function renderEmployeeTable(table) {
    let queryCustomerInfoData;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/admin/allemployee",
        success: function (response) {
            queryCustomerInfoData = response;
            // 渲染表格
            table.render({
                elem: '#employeeTable',
                data: queryCustomerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '员工编号' },
                    { field: 'username', width: 100, title: '员工姓名' },
                    { field: 'gender', width: 100, title: '员工性别' },
                    { field: 'phoneNumber', width: 120, title: '员工电话' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(employeeTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看用户详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/admin/employeeDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}
function renderEmployeeQueryTable(table,queryName,queryPhone) {
    let queryCustomerInfoData;
    let queryData = {
        "username": queryName,
        "phoneNumber": queryPhone
    };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/admin/queryemployee",
        data: JSON.stringify(queryData),
        contentType: "application/json;charset=utf-8",
        success: function (response) {
            queryCustomerInfoData = response;
            // 渲染表格
            table.render({
                elem: '#employeeQueryTable',
                data: queryCustomerInfoData,
                toolbar: '#toolbar',
                defaultToolbar: ['filter', 'exports'],
                cols: [[
                    { field: 'id', width: 100, title: '员工编号' },
                    { field: 'username', width: 100, title: '员工姓名' },
                    { field: 'gender', width: 100, title: '员工性别' },
                    { field: 'phoneNumber', width: 120, title: '员工电话' },
                    { fixed: 'right', width: 200, align: 'center', toolbar: '#bar', title: '操作' }
                ]],
                page: true
            });
            //监听行工具事件
            table.on('tool(employeeQueryTable)', function (obj) {
                if (obj.event == 'click') {
                    // 查看用户详情
                    var selectedData = obj.data;
                    console.log("查看", selectedData);
                    window.location.href = "http://localhost:8080/admin/employeeDetail/" + selectedData.id;
                } 
            });
        },
        error: function (error) {
            console.log("Error:" + error);
        }
    });
}