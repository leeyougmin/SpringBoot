$(document).ready(function (){
	CommonApp.init();
});

var CommonApp = {
  init() {
  	CommonApp.evtHandler()
  },
  evtHandler(){
		$("nav span").on('click', function() {
			$(this).next().children().slideToggle("100");
		});
	},
	
}