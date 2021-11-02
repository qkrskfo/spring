 /**************** account 왼쪽메뉴변경 **********************/
 var account_left_sidebar_select=function(select_menu){
	    $(".list-group a[href='"+select_menu+"']").addClass('active');
 }
/***************프로필변경 [/user_profile_modify_action_rest]******* */
 var user_profile_modify_action_rest=function(params){
	console.log(params);
	$.ajax({
		url:'user_profile_modify_action_rest',
		method:'POST',
		dataType:'json',
		data:params,
		success:function(user){
	    	if(user.userId==null){
				$('#form-account-update input').css('border','red 1px solid');
			}else{
				$('#form-account-update input').css('border','');
				common_header_cart_info_change();		
			}
	    	
		}
	});
};
