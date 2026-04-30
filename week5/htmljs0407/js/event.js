 window.addEventListener('load', function(){
    document.getElementById('bt1').addEventListener('click', function(){
        alert('Button Clicked!');
    });
    document.getElementById('div1').addEventListener('mouseenter', function(){
            this.style.backgroundColor = 'yellow';
    });
    document.getElementById('div1').addEventListener('mouseleave', function(){
            this.style.backgroundColor = 'aqua';
    });
  });   