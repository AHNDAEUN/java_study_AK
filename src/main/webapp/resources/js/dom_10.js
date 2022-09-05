//const d2 =document.getElementById("d2")
const d2 =document.querySelector("#d2")
const d1 =document.querySelector("#d1")
const d3 = document.querySelector("#d3")
const d4 = document.querySelector("#d4")

d2.addEventListener("click", function(){

    console.log("Enter")
    console.log(d1.class)
    console.log(d1.getAttribute("class"))

    //d1.className="c2";
    d1.classList.replace("c3", "c2")// c3클래스명을 c2로 바꾸자
   //마우스가 들어갔을때 배경색이 파랑색이 됨

    //css 중 회원가입 검증시 사용됨
})

d2.addEventListener("mouseleave", function(){

    console.log("Leave")
    console.log(d1.className)
    console.log(d1.classList)
    d1.classList.add("c4") // 클래스명 c4추가되며 css magin-top이 적용
    
})

d3.addEventListener("click",function(){

    console.log("toggle")
    d2.classList.toggle("c2") // 없으면 넣고 있으면 빼
    console.log(d2.classList.contains("c2"))
})


d4.addEventListener("click", function(){

    console.log("request 실행")
  //  location.href="./dom_9.html" // 요청한 주소로 이동하는데 새페이지 뛰움
   console.log("origin",location.origin)
    console.log("hostname",location.hostname)
    console.log("pathname",location.pathname)//ip 뒤에 나오는 경로
    console.log("search",location.search) // url에 파라미터값을 넣었을때 search에 파라미터값이 나옴
    location.href="./dom_9.html?a=10"
})

