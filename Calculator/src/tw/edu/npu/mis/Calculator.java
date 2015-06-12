/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import static org.omg.CORBA.ORB.init;
/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
    String number = "" ;
    double x,y,z=0;
    
    /**
     * The available operators of the calculator.
     */
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    /**
     * button按下數字
     * @param digit 
     */
    public void appendDigit(int digit) {
     number += String.valueOf(digit);
     getDisplay();
    }
    /**
     * 小數點
     * @param d 
     */
    public void appendDot(String d) {
      number +=d;
      getDisplay();
        
    }
    /**
     * 運算
     * @param operator 
     */
    public void performOperation(Operator operator) {
        /**
         * C
         */
       if(operator == Operator.CLEAR){
           
           number ="0";
           z = 0;
           getDisplay();
           number="";
           
       }
        
    }
    /**
     *  上載資料
     * @return 
     */
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(number);
        return null;
    }
    /**
     * 存取運算符號
     * @param b 
     */
    public void bn(String b){
    if(b =="+") performOperation(Operator.PLUS);
    if(b =="-") performOperation(Operator.MINUS);
    if(b =="x") performOperation(Operator.TIMES);
    if(b =="/") performOperation(Operator.OVER);
    if(b =="c") performOperation(Operator.CLEAR);
    if(b =="=") performOperation(Operator.EQUAL);
      
    }
}

    /**
     * @param args the command line arguments
     */
   