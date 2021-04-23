window.onload = function () 
{
    setDate();
}

function setDate() 
{
    var date = new Date();
    var da = date.toLocaleDateString();
    document.getElementById("date").innerHTML = da;
}

function primeFunction() 
{
    
    var primes = "2";
    var num = document.getElementById("number").value;
    for (var i = 3; i <= num; i++) 
    {
        
        var boo = true
        for (var k = 2; k <= i/2 ; k++) 
        {
            if (i % k == 0) 
            {
                boo = false;
                break;
            }
        }
        if (boo == true) 
        {
            primes = primes + "," + i;
        }
    }
    document.getElementById("textbox").innerHTML = primes;
}