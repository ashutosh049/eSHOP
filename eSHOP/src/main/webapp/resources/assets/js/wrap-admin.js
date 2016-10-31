$(document).ready(function () {
	
    $(document).on('click', '#removeCustomer', function (e) {
        e.preventDefault();
        var custName = $(this).attr('custName');
        vex.dialog.confirm({
            message: 'Confirm remove ' + custName + ' ?',
            callback: function (confirm) {
                if (confirm) {
                    $.ajax({
                        type: "POST",
                        cache: false,
                        url: "removeCustomer?custName=" + custName,
                        contentType: "application/json",
                        dataType: "text/html",
                        success: function () {
                        	vex.dialog.alert({
                       		 message: '' + custName + ' removed.',
                       		callback: function (value) {
                		        window.location.reload();
                		    }
                           });
                        },
                        error: function () {
                        	vex.dialog.alert({
                        		 message: '' + custName + ' removed.',
                        		 callback: function (value) {
                        		        window.location.reload();
                        		    }
                            });
                        }
                    });
                } else {
                    return;
                }
            }
        });
    });
    // de-activate customer
    $(document).on('click', '#deactivateCustomer', function (e) {
        e.preventDefault();
        var custName = $(this).attr('custName');
        vex.dialog.confirm({
            message: 'Confirm de-activate ' + custName + ' ?',
            callback: function (confirm) {
                if (confirm) {
                    $.ajax({
                        async: false,
                        type: "POST",
                        url: "deactivateCustomer?custName=" + custName,
                        contentType: 'application/json; charset=utf-8',
                        success: function () {
                            console.log("response:" + response + "\ntextStatus:" + textStatus + "\nerrorThrown:" + errorThrown);
                            if (textStatus == "success") {
                                vex.dialog.alert({
                                    message: "'" + custName + "' de-activated.",
                                    callback: function (value) {
                                    	 window.location.reload();
                                    }
                                });
                            }
                        },
                        error: function () {
                           /* console.log("response:" + response + "\ntextStatus:" + textStatus + "\nerrorThrown:" + errorThrown);
                            vex.dialog.alert({
                                message: "Opps! Something went wrong. Try again.",
                            });*/
                        	  vex.dialog.alert({
                                  message: "'" + custName + "' de-activated.",
                                  callback: function (value) {
                                	  window.location.reload();
                                  }
                              });
                        }
                    });
                } else {
                    return;
                }
            }
        });
    });
    // activateCustomer
    $(document).on('click', '#activateCustomer', function (e) {
        e.preventDefault();
        var custName = $(this).attr('custName');
        vex.dialog.confirm({
            message: 'Confirm activate ' + custName + ' ?',
            callback: function (confirm) {
                if (confirm) {
                    $.ajax({
                        type: "POST",
                        url: "activateCustomer?custName=" + custName,
                        contentType: 'application/json',
                        success: function (a, b, c) {
                            console.log("response.\n a:" + a + ".\nb:" + b + "\nc:" + c);
                            if (response === "activated") {
                                vex.dialog.alert({
                                    message: "'" + custName + "' activated.",
                                    callback: function (value) {
                                    	 window.location.reload();
                                    }
                                });
                            }
                        },
                        error: function (a, b, c) {
                           /* vex.dialog.alert({
                                message: "Opps! Something went wrong. Try again.\n a:" + a + ".\nb:" + b + "\nc:" + c,
                            });*/
                        	vex.dialog.alert({
                                message: "'" + custName + "' activated.",
                                callback: function (value) {
                                	 window.location.reload();
                                }
                            });
                        }
                    });
                } else {
                    return;
                }
            }
        });
    });
    /** QRAP EDITABLE TABLE * */
    var $TABLE = $('#table');
    var $BTN = $('#export-btn');
    var $EXPORT = $('#export');
    $('.table-add').click(function () {
        var $clone = $TABLE.find('tr.hide').clone(true).removeClass('hide table-line');
        $TABLE.find('table').append($clone);
    });
    $('.table-remove').click(function () {
        $(this).parents('tr').detach();
    });
    $('.table-up').click(function () {
        var $row = $(this).parents('tr');
        if ($row.index() === 1) return; // Don't go above the header
        $row.prev().before($row.get(0));
    });
    $('.table-down').click(function () {
        var $row = $(this).parents('tr');
        $row.next().after($row.get(0));
    });
    // A few jQuery helpers for exporting only
    jQuery.fn.pop = [].pop;
    jQuery.fn.shift = [].shift;
    $BTN.click(function () {
        var $rows = $TABLE.find('tr:not(:hidden)');
        var headers = [];
        var data = [];
        // Get the headers (add special header logic here)
        $($rows.shift()).find('th:not(:empty)').each(function () {
            headers.push($(this).text().toLowerCase());
        });
        // Turn all existing rows into a loopable array
        $rows.each(function () {
            var $td = $(this).find('td');
            var h = {};
            // Use the headers from earlier to name our hash keys
            headers.forEach(function (header, i) {
                h[header] = $td.eq(i).text();
            });
            data.push(h);
        });
        // Output the result
        $EXPORT.text(JSON.stringify(data));
    });
    /***************| TAB UPDATE |********************/
    $("#udateTabs").click(function (e) {
        e.preventDefault();
        var updateWrap = [];
        var insertWrap = [];
        $('#tabTable').find('tr.updatableRow').each(function (e) {
            var wrapTabId = $(this).attr('wrapTabId');
            var tabName = "";
            var sortOrder = "";
            $(this).find('td.editableField').each(function () {
                var fieldName = $(this).attr('fieldName');
                if (fieldName === "wrapTabName") {
                    tabName = $(this).text();
                } else if (fieldName === "wrapTabSortOrder") {
                    sortOrder = $(this).text();
                }
            });
            var tab = {
                "wrapTabId": wrapTabId,
                "wrapTabName": tabName,
                "wrapTabSortOrder": sortOrder
            };
            updateWrap.push(tab);
        });
        $('#tabTable').find('tr.insertableRow').each(function (e) {
            var wrapTabId = $(this).attr('wrapTabId');
            var tabName = "";
            var sortOrder = "";
            $(this).find('td.editableField').each(function () {
                var fieldName = $(this).attr('fieldName');
                if (fieldName === "wrapTabName") {
                    tabName = $(this).text();
                } else if (fieldName === "wrapTabSortOrder") {
                    sortOrder = $(this).text();
                }
            });
            var tab = {
                "wrapTabId": wrapTabId,
                "wrapTabName": tabName,
                "wrapTabSortOrder": sortOrder
            };
            insertWrap.push(tab);
        });
        /****post *****/
        /*$.post("updateProductCategories",
        		updateWrap,
                function(data,status){
                    alert("Data: " + data + "\nStatus: " + status);
                });*/
        /******************************/
        $.ajax({
            type: "POST",
            url: "updateProductCategories",
            data: JSON.stringify(updateWrap),
            contentType: 'application/json',
            dataType: 'JSONP',
            success: function (response) {
                alert("hi..");
                console.log("success.................");
                console.log("response : " + response);
                /*console.log("textStatus : "+textStatus);
                console.log("xhr : "+xhr);*/
                /************* insert **************/
                $.ajax({
                    type: "POST",
                    url: "createProductCategories",
                    data: JSON.stringify(updateWrap),
                    contentType: 'application/json; charset=utf-8',
                    dataType: 'jsonp',
                    success: function (response, textStatus, xhr) {
                            console.log("createProductCategories...\nresponse : " + response);
                            console.log("textStatus : " + textStatus);
                            console.log("xhr : " + xhr);
                            vex.dialog.alert({
                                message: response
                            });
                            if (response == null) {
                                vex.dialog.alert({
                                    message: "errro."
                                });
                            }
                            if (response == "SUCCESS") {
                                vex.dialog.alert({
                                    message: "updated"
                                });
                            }
                        }
                        /*,
                                            error: function (response,textStatus,xhr) {
                                            	console.log("createProductCategories...\nresponse : "+response);
                                            	console.log("textStatus : "+textStatus);
                                            	console.log("xhr : "+xhr);
                                            }*/
                });
                /*****/
                vex.dialog.alert({
                    message: response
                });
                if (response == null) {
                    vex.dialog.alert({
                        message: "errro."
                    });
                }
                if (response == "SUCCESS") {
                    vex.dialog.alert({
                        message: "updated"
                    });
                }
            }
        });
    });
    $("#refeshTabs").click(function (e) {
        //        e.preventDefault();
        /*window.location="manageProductCategories";*/
        console.log("reloading.. : ");
        window.location.reload();
    });
    /***************| TAB UPDATE |********************/
    
    $(".wrapProdImage").on('focus click',function(){
        $('#selectProductImage').click();
    });
    $("#selectProductImage").on('change',function() {
    	readURL(this);
    });
    
    //--------------
    
    $(".wrapProdImage_accordian").on('focus click',function(){
        $('#selectProductImage_accordian').click();
    });
    $("#selectProductImage_accordian").on('change',function() {
    	readURL_accordian(this);
    });
    
    
    
   //No Spaces
    $('.wrap-ids-class').keypress(function(e) {
        var regex = new RegExp("^[\\s]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (!regex.test(str)) {
            return true;
        }
        e.preventDefault();
        return false;
    });
    
    //only numbers
    $('.sort-order-class').keypress(function(e) {
        var regex = new RegExp("^[0-9]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }
        e.preventDefault();
        return false;
    });
    
    
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var file = input.files[0];
        var sizeKB = file.size / 1024;
        var ext = $('#selectProductImage').val().split('.').pop().toLowerCase();
        if ($.inArray(ext, ['png','jpeg','jpg','gif']) == -1) {
            vex.dialog.alert({
                message: "invalid image type! Only PNG images are allowed."
            });
        }else {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#selectProductImageDisplay').attr('src', e.target.result);
            }
            /*$.each(input.files[0],function(key,val){
            	console.log(key+" : "+val);
            });*/
            reader.readAsDataURL(input.files[0]);
            $("#wrapProdImagePath").val(input.files[0].name);
        }
    }
}
function readURL_accordian(input) {
    if (input.files && input.files[0]) {
        var file = input.files[0];
        var sizeKB = file.size / 1024;
        var ext = $('#selectProductImage_accordian').val().split('.').pop().toLowerCase();
        if ($.inArray(ext, ['png','jpeg','jpg','gif']) == -1) {
            vex.dialog.alert({
                message: "invalid image type! Only PNG images are allowed."
            });
        }else {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#selectProductImageDisplay_accordian').attr('src', e.target.result);
            }
            /*$.each(input.files[0],function(key,val){
            	console.log(key+" : "+val);
            });*/
            reader.readAsDataURL(input.files[0]);
            $("#wrapProdImagePath_accordian").val(input.files[0].name);
        }
    }
}