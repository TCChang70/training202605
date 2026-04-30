    var randomNum = Math.floor(Math.random() * 10) + 1;
    var square=function(n){
        return n*n;
    };
    var cube=(n)=>{  //ES6 arrow function
        return n*n*n;
    };
    function guess() {       
        var userGuess = parseInt(prompt("Guess a number between 1 and 10:"));
        while (true) {
            if (userGuess < randomNum) {
                alert("Too low! Try again.");
            } else if (userGuess > randomNum) {
                alert("Too high! Try again.");
            }else{                
                var playAgain = confirm("Congratulations! You guessed the correct number: " + userGuess + ". Do you want to play again?");
                if (!playAgain) {
                    alert("Thanks for playing! Goodbye!");
                    return;
                }
                randomNum = Math.floor(Math.random() * 10) + 1;
                userGuess = parseInt(prompt("Guess a number between 1 and 10:"));
            }
            userGuess = parseInt(prompt("Guess a number between 1 and 10:"));
        }
        //alert("Congratulations! You guessed the correct number: " + randomNum);

    }
    function relationOP(){
        var s1="5";
        var s2=5;
        console.log("Using == operator: " + (s1 == s2));
        console.log("Using === operator: " + (s1 === s2));
    }
    function checkValue() {
           var n= prompt("Please enter a value:");
           if (n) {
               alert("You entered: " + n);
           } else {
               console.log("The value entered is: " + n);
               alert("You entered an empty value or canceled the prompt.");
           }
     }
     
     function myarray() {
           var arr = [1, 2, 3, 4, 5];
           console.log("The array is: " + arr);
           console.log("The type of the array is: " + Array.isArray(arr));
           var obj={"username":"John", "age":30};
           console.log("The object is: " + JSON.stringify(obj));
           console.log("The type of the object is: " + typeof(obj));
       }
       function myprompt(){
          var n1=prompt("Please enter a number:");
          console.log("The value entered is: " + typeof(n1));
          n1++;
          alert("The result after incrementing is: " + n1);
       }
       function typeCheck() {
           let num1 = 10;
           var num2 = true;
           var num3 = "Hello";
           var num4 = null;           
           var num5; // undefined
           var num6 = 3.14; // float
           console.log("The type of num1 is: " + typeof(num1));
           console.log("The type of num2 is: " + typeof(num2));
           console.log("The type of num3 is: " + typeof(num3));
           console.log("The type of num4 is: " + typeof(num4));
           console.log("The type of num5 is: " + typeof(num5));
           console.log("The type of num6 is: " + typeof(num6));
       }