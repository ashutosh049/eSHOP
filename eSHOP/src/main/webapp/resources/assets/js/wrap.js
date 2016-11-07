$(document).ready(function() {
	
	/*vex.dialog.alert({
	    message: "Congratulations! Your user name is user333. Login again to continue ",
	    className: 'vex-theme-bottom-right-corner'
	});
	*/
	$("#createUserAccount").submit(function(e) {
		
		var $this = $('#createUserAccountSbmtBtnn');
		 $this.button('loading');	
		
		$('#error_msg').text("");
		 $('#success_msg').text("");
		e.preventDefault();
		var argWrapUser = {
				"userName" : null,
				"firstName" : $('#createFirstName').val(),
				"lastName" : $('#createLastName').val(),
				"email" : $('#createEmail').val(),
				"password" : $('#createPassword').val()
		};
		
		if($('#createPassword').val()=="" || $('#createPassword').val()==null){
			alert("password null");
			return false;
		}
		
		$.ajax({
			type : "POST",
			url : "createUserAccount",
			data : JSON.stringify(argWrapUser),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(argWrapUser) {
				if(argWrapUser== null){
					swal('something went wrong.. try again');
				}
				$.each( argWrapUser, function( key, value ) {
					  if(key==="userName"){
						  $this.button('reset');
						  $('#success_msg').text("Congratulations! Your user name is '"+value+"'. Login again to continue ");
						  vex.dialog.alert({
							    message: "Congratulations! Your user name is '"+value+"'. Login again to continue ",
							    callback: function (value) {
							        window.location = "index";
							    }
							});
					  }
					});
			},
			error : function(xhr) {
				 $('#error_msg').text("Opps! Something went wrong. Try again.");
			}
		});

	});
	
	$("#loginUserAccountMdlSbmtForm").submit(function(e) {
		 var $this = $('#loginUserAccountMdlSbmtBtn');
		 $this.button('loading');
		 $this.attr('disabled','disabled');
	});
	
	$("#loginUserAccountForm").submit(function(e) {
		 var $this = $('#"loginUserAccountSbmBtn"');
		 $this.button('loading');
		 $this.attr('disabled','disabled');
	});
	
	$("#createUserAccountMdl").submit(function(e) {
		
		 $("input.input").attr("disabled", true);
		 
		 var $form = $(this);
		 
		 $('#error_msg').text("");
		 $('#success_msg').text("");
		
		 e.preventDefault();
		
		 var $this = $('#createUserAccountMdlSbmtBtn');
		 $this.button('loading');		
		
		var argWrapUser = {
				"userName" : null,
				"firstName" : $('#firstNameMdl').val(),
				"lastName" : $('#lastNameMdl').val(),
				"email" : $('#emailMdl').val(),
				"password" : $('#passwordMdl').val()
		};

		$.ajax({
			type : "POST",
			url : "createUserAccount",
			data : JSON.stringify(argWrapUser),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(argWrapUser) {
				if(argWrapUser== null){
					swal('something went wrong.. try again');
				}
				$.each( argWrapUser, function( key, value ) {
					  if(key==="userName"){
						  $('#createUserAccountMdl')[0].reset();
						  $this.button('reset');
						  $('#ModalSignup').modal('hide');
						  $('#success_msg').text("Congratulations! Your user name is '"+value+"'. Login again to continue ");
						  vex.dialog.alert({
							    message: "Congratulations '"+value+"'! Your have been successfully registered. Kindly verify your email.",
							    callback: function (value) {
							        window.location = "index";
							    }
							})
					  }
					});
			},
			error : function(xhr) {
				 $('#error_msg').text("Opps! Something went wrong. Try again.");
			}
		});

	});
	
	// ADD COMBO TO CART
	$(document).on('click', '#addToCartBtn', function (e) {
        e.preventDefault();
        
        var wrapProductList = [];
        $('#comboItemsList').find('a.comboItems').each(function (e) {
        	
        	var wrapTabId=$(this).attr('wrapTabId');
        	var wrapColId=$(this).attr('wrapColId');
        	var wrapCatId=$(this).attr('wrapCatId');
        	var wrapProdId=$(this).attr('wrapProdId');
        	
            var prod = {
                "wrapTabId": wrapTabId,
                "wrapColId": wrapColId,
                "wrapCatId": wrapCatId,
                "wrapProdId":wrapProdId
            };
            wrapProductList.push(prod);
        });
        
        $.ajax({
            type: "POST",
            url: "addComboToCart",
            data: JSON.stringify(wrapProductList),
            contentType: 'application/json',
            dataType: 'JSON',
            success: function (response, textStatus, errorThrown) {
            	 vex.dialog.alert({
                     message: "Combo addedd to cart.",
                     className: 'vex-theme-bottom-right-corner'
                 });
            	 setTimeout(function(){ 
            		 vex.closeAll(); 
            		 }, 2500);
            },
            error: function (response, textStatus, errorThrown) {
                console.log("response:" + response + "\ntextStatus:" + textStatus + "\nerrorThrown:" + errorThrown);
                vex.dialog.alert({
                    message: "Opps! Something went wrong. Try again.",
                });
            }
        });
    });
	
	
	
	 $(document).on('click', '#makeDefaultAddress', function (e) {
	        
		 e.preventDefault();
	        
	        var userName = $(this).attr('userName');
	        var user_address_id = $(this).attr('user_address_id');
	        
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

	 /*select default addresss*/

	 //iradio_square-green iChk iCheck-margin checked
	 /*if($('.iradio_square-green').hasClass('checked')){
		 alert("check");
	 }*/
	 
	 
	 //iradio_square-green iChk iCheck-margin checked
	 $(document).on('click', '.iradio_square-green', function (e) {
		 alert("click");
	 });
	 
	 alert($('#radio1').is(':checked'));
	 
	/* $(document).on('change', '.iradio_square-green', function (e) {
		 var userName=$(this).attr('userName');
		 var user_address_id=$(this).attr('user_address_id');
		 alert("userName : "+userName+"\nuser_address_id : "+user_address_id);
	 });
	 */
	
});
