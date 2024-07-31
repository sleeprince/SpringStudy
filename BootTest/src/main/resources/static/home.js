/**
 * 
 */
import {$post, $get} from "./ajax.js";

const table = {	
	tableList : ["<tr><th>이름</th><th>나이</th><th>성별</th></tr>"],
	add : (data) => {table.tableList.push(`<tr><td>${data.nm}</td><td>${data.age}</td><td>${data.gend}</td></tr>`)},	
};


const btns = document.getElementsByClassName("btn");

const draw = (data) => {
	let content = data.response
	console.log(content);
	if(content != ""){
		let list = JSON.parse(content);
		console.log(list);
		for(let row of list){
			table.add(row);			
		}
	}
	let html = "";
	for(let row of table.tableList){
		/*console.log(row);*/
		html += row;
	}
	document.getElementsByTagName("table")[0].innerHTML = html;
};

const getData = (url, param) => {
	$post(url, param, draw);
};

const btnEvent = (e) => {
	switch(e.target.id){
		case '0':
			getData("/insert", {});
			break;
		case '1':
			getData("/save", {});
			break;
		case '2':					
			getData("/rollback", {});
			break;
		default:
			break;
	}
}

for(let btn of btns){
	btn.onclick = btnEvent;
}

getData("/", {});