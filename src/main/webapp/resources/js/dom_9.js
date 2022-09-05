
const d1= document.querySelector("#d1");

const d1_2_1_2= document.querySelector("#d1_2_1_2")
const btn = document.querySelector("#btn")



console.log(d1_2_1_2.previousSibling.previousSibling);
console.log(d1_2_1_2.nextSibling.nextSibling)
console.log("----------------------------------")

//parent

console.log(d1_2_1_2.parentNode.parentNode.parentNode)

console.log("-------------------------------")


//btn클릭하면 li를 기준으로 div(d1_2) 삭제 
btn.addEventListener("click",function(){

    console.log(d1_2_1_2.parentNode.parentNode)// d1_2_1_2->ul->div
    d1_2_1_2.parentNode.parentNode.remove();


})
console.log("---------------------")

//-------------------------------------------------------

// console.log(d1.childNodes)
// console.log(d1.childNodes[3].innerHTML);

// console.log(d1.children);
// console.log(d1.children[1].children[0].children[0].innerHTML)

// console.log(d1.childNodes[3].childNodes) // ul테그
// console.log(d1.childNodes[3].childNodes[1].childNodes[1].innerHTML) // li태그 내 1번 innerHTMl

//d1.childNodes(); // d1의 자식코드 가져오기


d1.addEventListener("click",function(){

    // ul 밑에 li태그 삭제 
 console.log("클릭")
    
 console.log(d1.children[1].children[0].children);

 let li= d1.children[1].children[0].children;

 //1.remove
 

//  for (l of li){

//   console.log (l); 
//   l.remove(); 
//  }

//0번만 조지기
for(let i=0; i != li.length;){
    li[0].remove();
}
console.log(li);
})

