/******주문상세보기[order_detail_rest]*******/
var order_detail_rest=function(params){
	
	$.ajax({
		url:'order_detail_rest',
		method:'POST',
		data:params,
		dataType:'json',
		success:function(order){
			$('#orderDetails').find('.modal-header .modal-title').html('Order No  - #'+order.o_no);
			$('#orderDetails .shopping-cart table > tbody').html('');
			let totPrice=0;
			$.each(order.orderItemList,function(i,orderItem){
				totPrice+= orderItem.oi_qty*orderItem.product.p_price;
				$('#orderDetails .shopping-cart table > tbody').append(`
						<tr>
	                    <td>
	                      <div class="product-item"><a class="product-thumb" href="shop-single"><img src="img/shop/cart/${orderItem.product.p_image}" alt="Product"></a>
	                        <div class="product-info">
	                          <h4 class="product-title"><a href="shop-single.html">${orderItem.product.p_name}<small>x ${orderItem.oi_qty}</small></a></h4><span><em>Size:</em> 소형</span><span><em>Color:</em> Dark Blue</span>
	                        </div>
	                      </div>
	                    </td>
	                    <td class="text-center text-lg text-medium">₩ ${(orderItem.oi_qty*orderItem.product.p_price).toLocaleString('en')}</td>
	                  </tr>
					`);
			});
			
			$('#orderDetails').find('.tot-price').html(`₩ ${totPrice.toLocaleString('en')}`);
			
		}
	});
	
}
