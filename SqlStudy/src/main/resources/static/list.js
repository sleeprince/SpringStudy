$(document).ready(() =>{
	const EVENT1 = (e) => {
		
	}
	const getList = (data) => {
		//console.log(data);
		$("#list").empty();
		$.each(data, (index, item) => {
			//console.log(index);
			//console.log(item);
			let html = "";
			if(index%2 == 0){
				html = `<tr class="table-secondary board-list"><td>${item.no}</td><td>${item.title}</td></td><td>${item.content}</td></td><td>${item.user}</td></td><td>${item.role}</td></tr>`;
			}else{
				html = `<tr class="board-list"><td>${item.no}</td><td>${item.title}</td></td><td>${item.content}</td></td><td>${item.user}</td></td><td>${item.role}</td></tr>`;
			}
			$("#list").append(html);
		});
		$(".board-list").on("click", function(){
			console.log(this);
			let num = this.firstChild.innerText;
			//alert(`글 번호 ${num}에 접근 권한이 없습니다.`);
			getData(`/check/${num}`, alarm);				
		});
	}
	const alarm = (data) =>{
		console.log(data);
		alert(data);		
	}
	const getData = (url, event) =>{
		$.post(url).done(event);	
	}
	getData("/", getList);
	$("button").on("click", EVENT1);
});