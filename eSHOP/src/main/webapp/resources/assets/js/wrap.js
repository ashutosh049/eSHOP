$(document).ready(function() {
	
	/*vex.dialog.alert({
	    message: "Congratulations! Your user name is user333. Login again to continue ",
	    className: 'vex-theme-bottom-right-corner'
	});
	*/
	$("#createUserAccount").submit(function(e) {
		 $('#error_msg').text("");
		 $('#success_msg').text("");
		e.preventDefault();
		var argWrapUser = {
				"userName" : null,
				"firstName" : $('#firstName').val(),
				"lastName" : $('#lastName').val(),
				"email" : $('#email').val(),
				"password" : $('#password').val()
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
	
	$("#createUserAccountMdl").submit(function(e) {
		
		 $("input.input").attr("disabled", true);
		 
		 var $form = $(this);
		 
		 $('#error_msg').text("");
		 $('#success_msg').text("");
		
		 e.preventDefault();
		
		 var $this = $('#createUserAccountMdlSbmtBtn');
		  $this.button('loading');
		   /* setTimeout(function() {
		       $this.button('reset');
		    	}, 8000);*/
		
		
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
});
