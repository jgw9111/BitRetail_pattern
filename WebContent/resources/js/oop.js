function People(name,age,gender,job){
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}
People.prototype.setName=name=>{this.name = name;};
People.prototype.setAge=age=>{this.age = age;};
People.prototype.setGender=gender=>{this.gender = gender;};
People.prototype.setJob=job=>{this.job = job;};
People.prototype.getName=()=>{return this.name;};
People.prototype.getAge=()=>{return this.age;};
People.prototype.getGender=()=>{return this.gender;};
People.prototype.getJob=()=>{return this.job;};

function Customer(grade,custNo){
	People.apply(this,arguments);
	this.grade = grade;
	this.custNo = custNo;
}
Customer.prototype = new People();
Customer.prototype.setName=name=>{
	//this.name = '[닉네임] '+name; < 자바 문법임 
	Object.getPrototypeOf(Customer.prototype).setName('[닉네임] '+name);
	};
Customer.prototype.setGrade=grade=>{this.grade = grade;};
Customer.prototype.setCustNo=custNo=>{this.custNo = custNo;};
Customer.prototype.getGrade=()=>{return this.gender;};
Customer.prototype.getCustNo=()=>{return this.custNo;};


var test2 ={ main: ()=>{
		let cust = new Customer();
		cust.setName('정지우');
		cust.setAge('28세');
		cust.setGender('여');
		cust.setJob('학생12');
		cust.setGrade('a');
		cust.setCustNo('154');
		/*alert('고객 정보 : '+cust.getName()+','+cust.getAge()+','+cust.getGender()+','+cust.getJob()+','+cust.getGrade()+','+cust.getCustNo());*/
		}};


function Product(name, price){
	this.name = name;
	this.price = price; 
}
function Food(name,price){
	Product.call(this, name, price);
	this.category = 'food';
}

var test = (()=>{
	let food = ()=>{
		let food = new Food('cheese',5);
		alert(food.category);
		alert(food.name);
	}
	return {food:food};
})();


/*var inherit = (()=>{
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
}

function Customer(){
	let _custNo,_grade;
	return {
	setCustNo : (custNo)=>{this._custNo = custNo;},
	setGrade : (grade)=>{this._grade = grade;},
	getCustNo : ()=>{return this._custNo;},
	getGrade : ()=>{return this._grade;}
	};
}

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
	var _= this;
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
})();*/