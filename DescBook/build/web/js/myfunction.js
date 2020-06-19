function myFunction() {
    var a = document.getElementById("log");
    var b = document.getElementById("reg");
    var c = document.getElementById("b1");
    var d = document.getElementById("b2");
    
    if (b.style.display === "none") {
        a.style.display = "none";
        b.style.display = "block";
        c.style.display = "none";
        d.style.display = "block";
    } else {
        a.style.display = "block";
        b.style.display = "none";
        c.style.display = "block";
        d.style.display = "none";
    }
}