//function info() {
//	$.get('/conductor/choose').done(function (data) {
//		let chooseData = JSON.parse(data);
//		let searchArray = $.map(chooseData, function (item) {
//			return item.name;
//		});
//
//		$("#tags").autocomplete({
//			source: searchArray
//		});
//
//		for (let i = 0; i < chooseData.length; i++) {
//			$("#container").append($('<div class="row">\n\
//									<div class="col-md-2 col-md-offset-3">\n\
//										<p  id="' + i + '">' + chooseData[i].name + '</p>\n\
//									</div>\n\
//									<div class="col-md-2">\n\
//										<p >' + chooseData[i].coreSize + '</p>\n\
//									</div>\n\
//									<div class="col-md-2">\n\
//										<button type="button" class="btn btn-success" onclick="choose(' + i + ')">Избери</button>\n\
//									</div>\n\
//								</div><hr />'));
//		}
//	});
//
//}
//
//function choose(index) {
//	let currentCore = $('#' + index).text();
//	$('#core').text(currentCore);
//	$('#myModal').modal('toggle');
//	$("#container").empty();
//}

$(document).ready(function () {

	getAllRequest();

	$("input[name='core']").focus(function () {
		$.get('/conductor/choose').done(function (data) {
			let chooseData = JSON.parse(data);
			$("#tags").autocomplete({
				source: chooseData
			});
		});
	});

	$('ul li').click(function () {
		$(this).addClass('active').siblings().removeClass('active');
	});



	$("#myBtn").click(function () {
		$("#myModal").modal();
	});
});


function getAllRequest() {

	$.get('/allRequest').done(function (requests) {
		let requestArray = JSON.parse(requests);

		drowTable(requestArray);
	});
}
;


function drowTable(requests) {

	for (let i = 0; i < requests.length; i++) {
		let tr = $('<tr></tr>');
		$('<td>' + (i + 1) + '</td>').appendTo(tr);
		$('<td>' + requests[i].date + '</td>').appendTo(tr);
		$('<td>' + requests[i].cable.name + '</td>').appendTo(tr);
		$('<td>' + requests[i].length + '</td>').appendTo(tr);
		$('<button type="button" class="btn btn-success btn-sm"  onclick="test2()">Печат</button>').appendTo(tr);
		tr.appendTo('#requestTableBody');

	}



}
;

function modal(id) {


	$.get('/request/' + id).done(function (requests) {
		$("#myModal").modal();
		let currentRequest = JSON.parse(requests);
		$('.modal-title').text(currentRequest.cable.name);
	});


}
;





function getConductors() {


	$.get('/conductor/getAll').done(function (requests) {
		$("#myModal").modal();
		let currentRequest = JSON.parse(requests);
		console.dir(currentRequest);
		$('.modal-title').text('Жила');
		for (var i = 0; i < currentRequest.length; i++) {
			$('<p></p>').text(currentRequest[i].name).appendTo('#conductorsName');
		}

	});

}


function test2() {

	$.ajax({
		type: 'GET',
		url: '/request/test',
		xhrFields: {
			responseType: 'blob'
		},
		success: function (data) {
			var file = new Blob([data], {type: 'application/pdf'}),
					url = URL.createObjectURL(file),
					_iFrame = document.createElement('iframe');
			_iFrame.setAttribute('src', url);
			_iFrame.setAttribute('width', '890px');
			_iFrame.setAttribute('height', '500px');

			$("#pdf").empty();
			$("#myModal").modal();
			
			$('.modal-title').text('Поръчка');
			$('#pdf').append(_iFrame);
		}
	});
}



