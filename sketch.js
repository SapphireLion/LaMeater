//let SAOFont;
let textX = 300;
let questionText;
let rulesText;
let cond1;
let cond2;
let cond3;
let questionCount;
let optionAText;
let optionBText;
let optionCText;
let optionDText;
let optionEText;
let correctOption;

// question Texts
let questionText1;
let questionText2;
let questionText3;
let questionText4;
let questionText5;

//option A Texts
let optionAText1;
let optionAText2;
let optionAText3;
let optionAText4;
let optionAText5;

//option B Texts
let optionBText1;
let optionBText2;
let optionBText3;
let optionBText4;
let optionBText5;

//option C Texts
let optionCText1;
let optionCText2;
let optionCText3;
let optionCText4;
let optionCText5;

//option D Texts
let optionDText1;
let optionDText2;
let optionDText3;
let optionDText4;
let optionDText5;

//option E Texts
let optionEText1;
let optionEText2;
let optionEText3;
let optionEText4;
let optionEText5;

//Correct Options
let correctOption1;
let correctOption2;
let correctOption3;
let correctOption4;
let correctOption5;

let headcirc;
let bodyline;
let arm1;
let arm2;
let leg1;
let leg2;

let wrongCount;


function preload(){
    //SAOFont=loadFont('assets/SAOWelcomeAnotherTT-Bold.ttf');
}

function setup() {
    createCanvas(1280, 640);
    background(255);
    optionAbtn = createButton('Pick A');
    optionAbtn.position(730, 410);
    optionAbtn.mousePressed(checkA);
    optionBbtn = createButton('Pick B');
    optionBbtn.position(730, 450);
    optionBbtn.mousePressed(checkB);
    optionCbtn = createButton('Pick C');
    optionCbtn.position(730, 490);
    optionCbtn.mousePressed(checkC);
    optionDbtn = createButton('Pick D');
    optionDbtn.position(730, 530);
    optionDbtn.mousePressed(checkD);
    optionEbtn = createButton('Pick E');
    optionEbtn.position(730, 570);
    optionEbtn.mousePressed(checkE);
    //hanger
    fill(0);
    strokeWeight(4);
    line(300,100,300,800);
    line(300,100,450,100);
    line(450,100,450,200);

    //hangman
    //bodyline = line(450, 300, 450, 500);
    //arm1 = line(450, 350, 550, 450);
    //arm2 = line(450, 350, 350, 450);
    //leg1 = line(450, 500, 550,  600);
    //leg2 = line(450, 500, 350, 600);
    questionCount=0;
    wrongCount = 0;


    rulesText="A movie sutdio is scheduling the release of six films -- Fiesta, Glaciers, Hurricanes, Jets, Kangaroos, and Lovebird. No two of these films can be released on the same date. The release schedule is governed by the following conditions:";
    cond1="Fiesta must be released earlier than both Jets and Lovebird.";
    cond2="Kangaroos must be released earlier than Jets, and Jets must be released earlier than Hurricanes.";
    cond3= "Lovebird must be released earlier than Glaciers";

    //Question 1 Setup
    questionText1= "Which one of the following CANNOT be true?";
    optionAText1="A. Fiesta is released second.";
    optionBText1="B. Glaciers is released third.";
    optionCText1="C. Hurricanes is released fourth.";
    optionDText1="D. Kangaroos is released fourth";
    optionEText1="E. Kangaroos is released fifth.";
    correctOption1 = 'E';

    //Question 2 setup
    questionText2= "Which one of the following must be true?";
    optionAText2="A. Fiesta is released earlier than Hurricanes.";
    optionBText2="B. Jets is released earlier than Glaciers.";
    optionCText2="C. Kangaroos is released earlier than Glaciers.";
    optionDText2= "D. Lovebird is released earlier than Glaciers.";
    optionEText2="E. Lovebird is released earlier than Jets.";
    correctOption2 = 'A';

    //Question 3 Setup
    questionText3= "If Glaciers is released earlier than Hurricanes, then each of the followibg could be true EXCEPT:";
    optionAText3="A. Glaciers is released fourth.";
    optionBText3="B. Jets is released third.";
    optionCText3="C. Kangaroos is released second.";
    optionDText3="D. Lovebird is released third.";
    optionEText3="E. Lovebird is released fifth.";
    correctOption3 = 'E';

    //formatting
    questionDiv = createDiv();
    rulesDiv = createDiv();
    feedbackDiv = createDiv('You have not answered yet!');
    feedbackDiv.position(700,650);

    winorlose = createDiv();
    winorlose.position(700,700);

    rulesDiv.position(800,0);
    rulesDiv.size(450, AUTO);
    rulesheader = createElement('h1', 'Rules').parent(rulesDiv);

    questionDiv.position(800, 300);
    questionDiv.size(450, AUTO);
    questionheader = createElement('h1', 'Question').parent(questionDiv);

    rulesPar = createP(rulesText).parent(rulesDiv);
    cond1Par = createP(cond1).parent(rulesDiv);
    cond2Par = createP(cond2).parent(rulesDiv);
    cond3Par = createP(cond3).parent(rulesDiv);

    cond1Par.style('font-style', 'italic');
    cond2Par.style('font-style', 'italic');
    cond3Par.style('font-style', 'italic');
    questionPar = createP(questionText).parent(questionDiv);
    optionApar = createP(optionAText).parent(questionDiv);
    optionBpar = createP(optionBText).parent(questionDiv);
    optionCpar = createP(optionCText).parent(questionDiv);
    optionDpar = createP(optionDText).parent(questionDiv);
    optionEpar = createP(optionEText).parent(questionDiv);
    optionApar.style('text-indent', '20px');
    optionBpar.style('text-indent', '20px');
    optionCpar.style('text-indent', '20px');
    optionDpar.style('text-indent', '20px');
    optionEpar.style('text-indent', '20px');

}

function draw() {


    switch (questionCount){
        case 0:
            questionText = questionText1;
            correctOption=correctOption1;
            optionAText=optionAText1;
            optionBText=optionBText1;
            optionCText=optionCText1;
            optionDText=optionDText1;
            optionEText=optionEText1;
            break;
        case 1:
            questionText = questionText2;
            correctOption = correctOption2;
            optionAText=optionAText2;
            optionBText=optionBText2;
            optionCText=optionCText2;
            optionDText=optionDText2;
            optionEText=optionEText2;
            break;
        case 2:
            questionText = questionText3;
            correctOption = correctOption3;
            optionAText=optionAText3;
            optionBText=optionBText3;
            optionCText=optionCText3;
            optionDText=optionDText3;
            optionEText=optionEText3;
            break;
        case 3:
            winorlose.html("YOU WIN!!!!!");
            winorlose.style('color', 'green');
            winorlose.style('font-size','200%');
    }

    //textSize(32);
    //textFont('Georgia');
    //text('Rules',100,0,100,100);
    //fill(0,0,0);
    //textFont('Arial');
    //textSize(10);
    //text(rulesText,textX,100,100,200);
    //fill(0,0,0);
    //text(cond1,textX,200,100,100);
    //fill(0,0,0);
    //text(cond2,textX,300,100,100);
    //fill(0,0,0);
    //text(cond3,textX,400,100,100);
    //fill(0,0,0);
    //textSize(32);
    //textFont('Georgia');
    //text('Question',textX,100,500,500);
    //fill(0,0,0);    textFont('Arial');
    //textSize(24);
    //text(questionText);
    //fill(0,0,0);

    //shows current question/options on screen
    questionPar.html(questionText);
    optionApar.html(optionAText);
    optionBpar.html(optionBText);
    optionCpar.html(optionCText);
    optionDpar.html(optionDText);
    optionEpar.html(optionEText);

}
function wrongAnswer(){
    if(wrongCount === 0){
        headcirc = circle(450, 250, 100);
        wrongCount += 1;
        return;
    }
    if(wrongCount === 1){
        bodyline = line(450, 300, 450, 500);
        wrongCount +=1;
        return;
    }
    if(wrongCount === 2){
        arm1 = line(450, 350, 550, 450);
        wrongCount +=1;
        return;
    }
    if(wrongCount === 3){
        arm2 = line(450, 350, 350, 450);
        wrongCount +=1;
        return;
    }
    if(wrongCount === 4){
        leg1 = line(450, 500, 550,  600);
        wrongCount +=1;
        return;
    }
    if(wrongCount === 5){
        leg2 = line(450, 500, 350, 600);
        winorlose.html("YOU LOSE!!!");
        winorlose.style('color', 'red');
        winorlose.style('font-size', '200%');
        return;
    }
}
function checkA(){
    answer = 'A';
    if(answer === correctOption){
        feedbackDiv.html("You are correct! WOW!");
        questionCount += 1;
    }
    else{
        wrongAnswer();
        feedbackDiv.html("You are incorrect! Sorry!")
    }
}

function checkB(){
    answer = "B";
    if(answer === correctOption){
        feedbackDiv.html("You are correct! WOW!");
        questionCount += 1;
    }
    else{
        wrongAnswer();
        feedbackDiv.html("You are incorrect! Sorry!")
    }
}
function checkC(){
    answer = "C";
    if(answer === correctOption){
        feedbackDiv.html("You are correct! WOW!");
        questionCount += 1;
    }
    else{
        wrongAnswer();
        feedbackDiv.html("You are incorrect! Sorry!")
    }
}
function checkD(){
    answer = "D";
    if(answer === correctOption){
        feedbackDiv.html("You are correct! WOW!");
        questionCount += 1;
    }
    else{
        wrongAnswer();
        feedbackDiv.html("You are incorrect! Sorry!")
    }
}
function checkE(){
    answer = "E";
    if(answer === correctOption){
        feedbackDiv.html("You are correct! WOW!");
        questionCount += 1;
    }
    else{
        wrongAnswer();
        feedbackDiv.html("You are incorrect! Sorry!")
    }
}