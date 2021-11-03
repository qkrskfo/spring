<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<title>좌석예매</title>
		
		<link href='https://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="css/jquery.seat-charts.css">
		
	</head>
	
	<body>
		<div class="wrapper">
			<div class="container">

				<div id="seat-map">
					<div class="front-indicator">SCREEN</div>
					
				</div>
				<div class="booking-details">
					<h2>예약상세</h2>
					
					<h3> 선택한 좌석 (<span id="counter">0</span>):</h3>
					<ul id="selected-seats"></ul>
					
					총계: <b><span id="total">0</span>원</b>
					
					<button id="checkout" class="checkout-button"> 결제 &raquo;</button>
					
					<div id="legend"></div>
				</div>
			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="js/jquery.seat-charts.min.js"></script>
		
		<script>
		let bookedSeatList = [];
		"<c:forEach items='${bookedSeatList }' var='bookedSeat'>"
			bookedSeatList.push("${bookedSeat.seat.seatCode}");
		"</c:forEach>"
			console.log(bookedSeatList);
		
			$(document).ready(function() {
				var $cart = $('#selected-seats'),
					$counter = $('#counter'),
					$total = $('#total'),
					sc = $('#seat-map').seatCharts({
					map: [
						'eee_eeeeee_eee',
						'eee_eeeeee_eee',
						'eee_eeeeee_eee',
						'eee_eeeeee_eee',
						'eee_effffe_eee',
						'eee_effffe_eee',
						'eee_eeeeee_eee',
						'eee_eeeeee_eee',
					],
					seats: {
						f: {
							price   : 14000,
							classes : 'first-class', //your custom CSS class
							category: '프라임'
						},
						e: {
							price   : 12000,
							classes : 'economy-class', //your custom CSS class
							category: '스탠다드'
						}					
					
					},
					naming : {
						top : false,
						getId  : function(character, row, column) {
						if(column < 10) {
							return row + "0" + column;
						}
						return row + '' + column;
						},
						getLabel : function (character, row, column) {
							return column;
						},
						rows : ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"],
						columns : ["1", "2", "3", "", "4", "5", "6", "7", "8", "9", "", "10", "11", "12"]
					},
					legend : {
						node : $('#legend'),
					    items : [
							[ 'f', 'available',   '프라임' ],
							[ 'e', 'available',   '스탠다드'],
							[ 'u', 'unavailable', '예약된 좌석']
					    ]					
					},
					click: function () {
						if (this.status() == 'available') {
							//let's create a new <li> which we'll add to the cart items

							$('<li>'+this.data().category+' '+this.settings.id+': <b>'+this.data().price+'원</b> <a href="#" class="cancel-cart-item">[X]</a></li>')
								.attr('id', 'cart-item-'+this.settings.id)
								.data('seatId', this.settings.id)
								.appendTo($cart);
							
							/*
							 * Lets update the counter and total
							 *
							 * .find function will not find the current seat, because it will change its stauts only after return
							 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
							 */
							$counter.text(sc.find('selected').length+1);
							$total.text(recalculateTotal(sc)+this.data().price);
							
							return 'selected';
						} else if (this.status() == 'selected') {
							//update the counter
							$counter.text(sc.find('selected').length-1);
							//and total
							$total.text(recalculateTotal(sc)-this.data().price);
						
							//remove the item from our cart
							$('#cart-item-'+this.settings.id).remove();
						
							//seat has been vacated
							return 'available';
						} else if (this.status() == 'unavailable') {
							//seat has been already booked
							return 'unavailable';
						} else {
							return this.style();
						}
					}
				});

				//this will handle "[cancel]" link clicks
				$('#selected-seats').on('click', '.cancel-cart-item', function () {
					//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
					sc.get($(this).parents('li:first').data('seatId')).click();
				});

				//let's pretend some seats have already been booked
				sc.get(bookedSeatList).status('unavailable');
		
		});

		function recalculateTotal(sc) {
			var total = 0;
		
			//basically find every selected seat and sum its price
			sc.find('selected').each(function () {
				total += this.data().price;
			});
			
			return total;
		}
		
		$("#checkout").click(function(e) {
			console.log($("#selected-seats").children());
			let seat = [];
			$("#selected-seats").children().each(function(i, element) {
				seat.push($(element).data("seatId"));
				console.log($(element).data("seatId"));
			});
			location.href = "pay_action?timeCode=${timeCode}&seat=" + seat + "&payCost=" + $("#total").text(); 
		});
		
		
		</script>
	</body>
</html>