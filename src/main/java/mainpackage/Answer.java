/*No-Name
6313139 Ruttiyaporn Kongtrakul 
6313141 Vatcharapong Laklaem
6313174 Natthabodi Bochol
6213202 Nitipoom Soomsakit*/
package mainpackage;


public class Answer {
    private String Answer,tAnswer;
    private String Q1,Q2,Q3,Q4,Q5,Q6;
    protected boolean correct;
    
    public Answer(){
        
        Q1 = "SUNLIGHT";
        Q2 = "CARROT";
        Q3 = "EYECONTACT";
        Q4 = "EGGBENEDICT";
        Q5 = "TABLETENNIS";
        Q6 = "TRANSISTOR";
        
    }
    
    public void SetAnswer(String a){
        Answer = a;
    }
    
    public String GetAnswer(){
        return Answer;
    }
    
    public void SetTempAnswer(String a){
        tAnswer = a;
    }
    
    public String GetTempAnswer(){
        return tAnswer;
    }
    
    public boolean checkAnswer(String a, int p){
        int i = p;
        
        if(i==1){
            if(GetAnswer().equalsIgnoreCase(Q1)){
                correct = true;
            }else{ correct = false; }
        }else if(i==2){
            if(GetAnswer().equalsIgnoreCase(Q2)){
                correct = true;
            }else{ correct = false; }
        }else if(i==3){
            if(GetAnswer().equalsIgnoreCase(Q3)){
                correct = true;
            }else{ correct = false; }
        }else if(i==4){
            if(GetAnswer().equalsIgnoreCase(Q4)){
                correct = true;
            }else{ correct = false; }
        }else if(i==5){
            if(GetAnswer().equalsIgnoreCase(Q5)){
                correct = true;
            }else{ correct = false; }
        }else if(i==6){
            if(GetAnswer().equalsIgnoreCase(Q6)){
                correct = true;
            }else{ correct = false; }
        }
        return correct;
    }
    
}
