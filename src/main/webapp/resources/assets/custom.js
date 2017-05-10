jQuery(document).ready( function() {

	$('.popover_parent > a').click(function() {
	  $('.popover_parent > a').not(this).parent().removeClass('active');
	  $(this).parent().toggleClass('active');
	  $('.search input[type="text"]').focus();
	});
	//Hide the menu when clicked off
	$('html').click(function() {
	  $('.popover_parent.active').removeClass('active');
	});
	//Don't include button or menu in 'html' click function
	$('.popover, .popover_parent > a').click(function(event){
	   event.stopPropagation();
	});

	/* ==============================================
		TO TOP
	=============================================== */

	/* ==============================================
		Counters

	/* ==============================================
		Owl Carousel 
	=============================================== */
	$("#w-owl").owlCarousel({
 
	items: 2,
      navigation : true, // Show next and prev buttons
	  navigationText: false,
      slideSpeed : 300,
	  pagination:false,
      paginationSpeed : 400,
      singleItem: true,
	  autoPlay: 4000,
	  responsive: true
 
	});
	
	/* ==============================================
		Owl Carousel 1
	=============================================== */
	$("#owl-1").owlCarousel({
 
	items: 2,
      navigation : true, // Show next and prev buttons
	  navigationText: false,
      slideSpeed : 300,
	  pagination:false,
      paginationSpeed : 400,
      singleItem: true,
	  responsive: true
 
	});
	
	/* ==============================================
		Owl Carousel 2
	=============================================== */
	$("#owl-2").owlCarousel({
 
	items: 4,
      navigation : true, // Show next and prev buttons
	  navigationText: false,
      slideSpeed : 300,
	  pagination:false,
      paginationSpeed : 400,
      singleItem: false,
	  responsive: true
 
	});
	
	/* ==============================================
		Owl Carousel 3
	=============================================== */
	$("#owl-3").owlCarousel({
 
	items: 3,
      navigation : false, // Show next and prev buttons
	  navigationText: false,
      slideSpeed : 300,
	  pagination:true,
      paginationSpeed : 400,
      singleItem: false,
	  responsive: true
 
	});
	

	
});