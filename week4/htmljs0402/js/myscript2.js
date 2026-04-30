var myArray=[1,2,3,7,8,9];
var getTagValue=function() {
    var tag=document.getElementById("tag1");
    alert(tag.innerText);
}
var addElement=() => {
   var e1=prompt("Please enter a value to the End:");
   myArray.push(e1);
   console.log("The array is: " + myArray);  

   e1=prompt("Please enter a value to the head:");
   myArray.unshift(e1);
   console.log("The array is: " + myArray);  

}

var deleteElement=() => {
   var v1=prompt("Please enter a value to delete:");
   var index=myArray.indexOf(parseInt(v1));
   if(index>=0){
     myArray.splice(index,1);
     console.log("The array is: " + myArray);  
   }else{
        alert("The value is not in the array!");
   }
}

var combineElement=() => {
    var a1=[4,5,6];
    var a2=[7,8,9];
    var a3=a1.concat(a2);
    console.log("The combined array is: " + a3);
    //var a4=[...a1,...a2];
    var a4=[...a1,...a2];
    console.log("The combined array is: " + a4);
};
var createObject=() => {
        var user={
            name:"Tom",
            age:20
        };
        console.log("The user name is: " + user.name);
        console.log("The user age is: " + user.age);

        var obj=new Object();
        obj.mail="Jerry@test.com";
        obj.address="TPE";
        console.log("The user mail is: " + obj.mail);
        console.log("The user address is: " + obj.address); 
};
var createObject2=() => {
    var fruits={vendor:"Fruit Store A"};
    fruits={...fruits,name:"Apple",price:60};
    console.log("The fruit vendor is: " + fruits.vendor);
    console.log("The fruit name is: " + fruits.name);
    console.log("The fruit price is: " + fruits.price);
};

var createFruitsArray=() => {
    var fruits=[];
    f1={vendor:"Fruit Store A",name:"Apple",price:60};
    f2={vendor:"Fruit Store B",name:"Banana",price:30};
    f3={vendor:"Fruit Store C",name:"Grape",price:90};
    fruits=[...fruits,f1,f2,f3];
    console.log("The fruits array is: " + JSON.stringify(fruits));
    // for(var i=0;i<fruits.length;i++){
    //     console.log("The fruit name is: " + fruits[i].name);
    //     console.log("The fruit price is: " + fruits[i].price);
    //     console.log("The fruit vendor is: " + fruits[i].vendor);
    // }

}