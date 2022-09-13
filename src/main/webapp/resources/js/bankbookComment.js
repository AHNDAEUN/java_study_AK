//bankbookcomment

//const commentAdd = document.getElementById("commentAdd")
const commentAdd= document.querySelector("#commentAdd")
const writer = document.querySelector("#writer")
const contents =document.getElementById("contents")
const commentList = document.querySelector("#commentList")

let page=1; //page 번호 담는 변수 more버튼 클릭했을때 증가
const bookNum=commentAdd.getAttribute("data-book-num")   //bookNum을 담을 변수
getCommentList(page,bookNum);
commentAdd.addEventListener("click", function(){

console.log(writer.value)

console.log(contents.value)
//console.log(commentAdd.data-book-num)
console.log(commentAdd.getAttribute("data-book-num"))
//let bookNum = commentAdd.getAttribute("data-book-num")
let wv = writer.value;
let cv=contents.value;

});


//------------------------ajax----------------------
// 1. XMLHttpRequest 작성

const xhttp = new XMLHttpRequest();

//2. method, url 준비

xhttp.open("post","./commentAdd");

//3. enctype
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

//4. 요청발생 (post일 경우 파라미터 추가)
xhttp.send( "bookNum=" +bookNum+"&writer="+wv+"&contents="+cv);


//5. 응답처리 
xhttp.onreadystatechange= function(){

  if(this.readyState==4 && this.status==200){
   let result= xhttp.responseText.trim();

   //json타입 변환
   result= JSON.parse(result);

   //result 값이 1이면 댓글동록 alert창

   if(result.result==1){

    alert("댓글 등록")
    // 등록하고 새로 받아오는 것이라 여기서 지워도 됨
        for(let i=0; i<commentList.children.length;){
            commentList.children[0].remove();
        }
    //  if(commentList.children.length!=0){
   //     commentList.children[0].remove();
    //}
    page=1;
    getCommentList(1,bookNum);
  // console.log(result);
  } else{

   }
  }
}// click Event 끝

function getCommentList(){
/// 페이지 로딩이 끝났을때 리스트를 불러옴 

// 1. XMLHttpRequest 생성

const xhttp = new XMLHttpRequest();

// 2. method, url
xhttp.open("GET","./commentList?page="+p+"&bookNum="+bn);

// 3. 요청전송
xhttp.send();

// 4.응답처리

xhttp.addEventListener("readystatechange",function(){
    if(xhttp.readyState==4 && xhttp.status==200){
        console.log(xtttp.responseText);
            //1. jsp를 사용한 결과물
        commentList.innerHTML=xhttp.responseText.trim();
            //2. json을 사용한 결과물 
        let result =JSON.parse(xhttp.responseText.trim())
        // let result = document.createElement("table")
        // let  resultAttr = document.createAttribute("class")
        // resultAttr.value="table table-dark table-striped";
        // result.setAttributeNode(resultAttr)// <table class= table table-dark table-striped"></table>


        let ar = result.list; // 배열 꺼내오기, 댓글리스트
        let pager = result.pager; //commentPager

        for (let i=0; i<ar.list.length;i++){
            let tr = document.createElement("tr")// <tr></tr>
            let td = document.createElement("td")// <td></td>
            let tdText = document.createTextNode(ar[i].contents)
           
            td.appendChild(tdText);

            td.appendChild(td);

            td= document.createElement("td")
            tdText= document.createTextNode(ar[i].writer)
            td.appendChild(tdText)

            tr.appendChild(td)

            td= document.createElement("td")
            // 날짜 format으로 변경 

            // let date = new date(ar[i].regDate);// 현재 날짜
            // console.log(date);
            // let year = date.getFullYear();
            // let month= date.getMonth()+1;
            // let d = date.getDate()+1;

            // console.log(year);
            // console.log(month);
            // console.log(d);
            // tdText= document.createTextNode(year+"-"+month+"-"+d)



            tdText= document.createTextNode(ar[i].regDate)
            td.appendChild(tdText)
            tr.appendChild(td);

            


            td= document.createElement("td")
            tdText= document.createTextNode("수정")
            let tdAttr = document.createAttribute("class")
            tdAttr.value="update";
            td.setAttributeNode(tdAttr)
            td.appendChild(tdText)
            tr.appendChild(td);

            tdAttr.document.createAttribute("data-comment-num")
            tdAttr.value=ar[i].num;
            td.setAttributeNode(tdAttr);

            td= document.createElement("td")
            tdText= document.createTextNode("삭제")
            tdAttr = document.createAttribute("class")
            tdAttr.value="delete";
            td.setAttributeNode(tdAttr)
            td.appendChild(tdText)

            tdAttr.document.createAttribute("data-comment-num")
            tdAttr.value=ar[i].num;
            td.setAttributeNode(tdAttr);




            result.appendChild(tr)
            // console.log(ar[i]) // dto 1개와 같음
            // console.log(ar[i].contents)
            // console.log(ar[i].writer)

            commentList.append(tr)

                if(page >= pager.totalPage){
                    more.classList.add("disabled");
                }else{
                    more.classList.remove("disabled")
                }
        }

       // commentList.append(result);
       // commentList.removeChild();
        // console.log(result)
        // console.log( commentList.children)
        // console.log (commentList.firstChild)
        // let t = commentList.children
        // if (t.length !=0){
        //     commentList.children[0].remove();
        // }
        //     try{console.log()}

    }

    commentList.append(result);

            
        

})



}

//--------- 더보기  
//more 버튼 클릭시 이벤트 발생
//more를 클릭했을때 보내줘야하는 페이지 수
//현재 1 보내줘야하는 페이지 2
const more = document.querySelector("#more")

more.addEventListener("click", function(){

    console.log("more 실행")
    page++;//page=page+1;
  //  const bookNum = commentAdd.getAttribute("data-book-num")
    console.log(page)
    console.log(bookNum)

    getCommentList(page,bookNum)


})


//----------------delete--------------
// class delete에 클릭 이벤트 걸기
//html 로딩이 끝난 다음 발생됨
//이벤트 위임을 이용함

CommentList.addEventListener("click", function(event){
        console.log(event.target);
    
    if(event.target.className=="delete"){
        console.log("delete")
       let check = window.confirm("삭제할..꺼야..?")
    // 확인 true 
        
    if (check){
        let num =event.target.getAttribute("data-comment-num")
        console.log("num:",num)
    }
   
    }
    
})



//---------------------- delete,update------


commentList.addEventListener("click", function(){


    //----update
    if(Event.target.className=="update"){
        
        let contents= Event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer= Event.target.previousSibling.previousSibling.innerHTML="writer";
        let num = Event.target.getAttribute("data-comment-num") 
       
       console.log=(contents);
        document.querySelector("#updateContents").valueL=contents;
        document.querySelector("#updateWriter").value=writer;
       document.querySelector("#num").value=num;
        document.querySelector("#up").click();

    }
})




//--------------- modal update button click----------------
const update = document.querySelector("#update");
update.addEventListener("click", function(){
// console.log("update");

// modal에서 수정해야할 파라미터 넘겨줘야함 (num,contents 가져오기)
// 가지고 오면 ajax를 통해 넘겨줌 

let num = document.getElementById("num").value;
let contents= document.querySelector("#updateContents").value;


// -----------ajax---------------------
// 1. XMLHttpRequest 작성
// 안바뀌고 싶으면 const or 변수이면 let
let xhttp =new XMLHttpRequest();

// 2,url,method 준비 (request정보 작성)

xhttp.open("POST","commentUpdate");

//3. header 정보 (enctype)
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");


//4. 요청 실행

xhttp.send("num="+num+"&contents="+contents);// ()파라미터 값 넣기 파라미터 이름 =값

//5. 응답 처리

xhttp.onreadystatechange=function(){
   if( xhttp.readyState==4 && xhttp.status==200){
    // 전송이 확인되면 1. console.log(xhttp.responseText.trim());
   let result = xhttp.responseText.trim(); //2.

   if (result>0){

    alert(" 댓글이 수정되었습니다.");

    for (let i=0; i<commentList.children.length;){
        commentList.children[0].remove();
    }

    page=1;

   }else{

    alert("댓글 수정이 실패되었습니다.");
   }
}
}
// 전송 후 controller



});