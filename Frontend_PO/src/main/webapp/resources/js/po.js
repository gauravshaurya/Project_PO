function Add(){
    $("#tableData tbody").append(
        "<tr>"+
        "<td><input type='text'/></td>"+
        "<td><input type='text'/></td>"+
        "<td><class='btnSave'><class='btnDelete'/></td>"+
        "</tr>");

        $(".btnSave").bind("click", Save);     
        $(".btnDelete").bind("click", Delete);
};

function Save(){ var par = $(this).parent().parent(); //tr 
var tdItem = par.children("td:nth-child(1)"); 
var tdQuantity = par.children("td:nth-child(2)"); 
var tdButtons = par.children("td:nth-child(4)");

tdItem.html(tdItem.children("input[type=text]").val()); 
/*tdQuantity.html(tdItem.children("input[type=text]").val());
tdButtons.html(<class='btnDelete'/>"); 
*/
$(".btnDelete").bind("click", Delete); 
};

function Delete(){ var par = $(this).parent().parent(); //tr 
par.remove(); 
};

$(function(){
    //Add, Save, Edit and Delete functions code
    $(".btnDelete").bind("click", Delete);
    $("#btnAdd").bind("click", Add);
});