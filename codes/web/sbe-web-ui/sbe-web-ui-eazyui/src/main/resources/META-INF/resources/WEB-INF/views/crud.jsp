<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html style="height:100%;width:100%;">
<head>
  <meta charset="UTF-8">
  <title>Basic CRUD Application - jQuery EasyUI CRUD Demo</title>
  <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
  <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic CRUD Application</h2>
<p>Click the buttons on datagrid toolbar to do crud actions.</p>

<table id="dg" title="Custom List" class="easyui-datagrid"
       url="/user/list"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
  <thead>
  <tr>
    <th field="id" width="50">ID</th>
    <th field="firstName" width="50">First Name</th>
    <th field="lastName" width="50">Last Name</th>
    <th field="phone" width="50">Phone</th>
    <th field="email" width="50">Email</th>
  </tr>
  </thead>
</table>
<div id="toolbar">
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New
    User</a>
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit
    User</a>
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove
    User</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
  <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
    <h3>User Information</h3>
    <div style="margin-bottom:10px">
      <input name="id" class="easyui-textbox" required="true" label="ID:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
      <input name="firstName" class="easyui-textbox" required="true" label="First Name:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
      <input name="lastName" class="easyui-textbox" required="true" label="Last Name:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
      <input name="phone" class="easyui-textbox" required="true" label="Phone:" style="width:100%">
    </div>
    <div style="margin-bottom:10px">
      <input name="email" class="easyui-textbox" required="true" validType="email" label="Email:" style="width:100%">
    </div>
  </form>
</div>
<div id="dlg-buttons">
  <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
  <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
     onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>
<script type="text/javascript">
  var url;

  function newUser() {
    $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'New User');
    $('#fm').form('clear');
    url = '/user/save';
  }

  function editUser() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
      $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit User');
      $('#fm').form('load', row);
      url = '/user/save';
    }
  }

  function saveUser() {
    $('#fm').form('submit', {
      url: url,
      onSubmit: function () {
        return $(this).form('validate');
      },
      success: function (result) {
        var result = eval('(' + result + ')');
        if (result.errorMsg) {
          $.messager.show({
            title: 'Error',
            msg: result.errorMsg
          });
        } else {
          $('#dlg').dialog('close');		// close the dialog
          $('#dg').datagrid('reload');	// reload the user data
        }
      }
    });
  }

  function destroyUser() {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
      $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
        if (r) {
          $.post('destroy_user.php', {id: row.id}, function (result) {
            if (result.success) {
              $('#dg').datagrid('reload');	// reload the user data
            } else {
              $.messager.show({	// show error message
                title: 'Error',
                msg: result.errorMsg
              });
            }
          }, 'json');
        }
      });
    }
  }
</script>
</body>
</html>
