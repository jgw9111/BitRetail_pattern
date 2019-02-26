var inherit = (()=>{
	return{
		main:()=>{
			let emp1 = new Employee();
			emp1.setSalary("5000");
			emp1.setPosition("과장");
			alert("연봉 정보 :"+emp1.getSalary()+","+emp1.getPosition());
			
			let cust1 = new Customer();
			cust1.setCustNo('1234');
			cust1.setGrade('실버등급');
			alert("고객 정보 :"+cust1.getCustNo()+","+cust1.getGrade());
		}
	};
})();

function Employee(){
	let _salary,_position;
	return {
	setSalary : (salary)=>{this._salary = salary;},
	setPosition : (position)=>{this._position = position;},
	getSalary : ()=>{return this._salary;},
	getPosition : ()=>{return this._position;}
	};
};

function Customer(){
	let _custNo,_grade;
	return {
	setCustNo : (custNo)=>{this._custNo = custNo;},
	setGrade : (grade)=>{this._grade = grade;},
	getCustNo : ()=>{return this._custNo;},
	getGrade : ()=>{return this._grade;}
	};
};

//---------------- encap(은닉화)
var encap = (()=>{ 
	var main = ()=>{

		person.setName('정지우');
		person.setAge('24');
		person.setGender('여');
		person.setJob( '학생');
		alert('spec :' +person.toString());
	}
	return {main:main};
})();

var person = (()=>{
	/*var _= this;*/
	let _name, _age, _gender,_job; // let 지역변수, var 전역
	return{setName:(name)=>{this._name = name;},
		setAge:(Age)=>{this._Age = Age;},
		setGender:(Gender)=>{this._Gender= Gender;},
		setJob:(job)=>{this._job = job;},
		getName:()=>{return this._job;},
		getAge:()=>{return this._age;},
		getGender:()=>{return this._gender;},
		getJob:()=>{return this._job;},
		toString : ()=>{
		        return this._name + ','+this._age + ','  +this._gender + ','+this._job}
	} 
})();