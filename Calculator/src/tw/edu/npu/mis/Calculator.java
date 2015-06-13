/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;
import static org.omg.CORBA.ORB.init;
/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
     String digital ="";
     double x,y,a,b =0,c;
     String z = "",r = "0";

   
    
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
     digital += String.valueOf(digit);
     getDisplay();
    }
    /**
     * 小數點
     * @param d 
     */
    public void appendDot(String d) {
      digital +=d;
      getDisplay();
        
    }
    /**
     * 運算
     * @param operator 
     */
    public void performOperation(Operator operator)
    {
        /**
         * C
         */
       if(operator == Operator.CLEAR)
       {
           
            digital ="0";
            b = 0;
           getDisplay();
            digital="";
           
       }
        /**
         * 按下 ＣE　功能
         */
        if(operator == Operator.CLEAR_ENTRY)
        {
            digital = "0";
            getDisplay();
            digital ="";
        }
        /**
         * 加法
         */
        if(operator == Operator.PLUS)
        {
            if(digital.length()>0)
            {
               x = Double.parseDouble(digital);
               digital = "";
               z = "+";
            }
            else
            {
                x = b;
                b = 0;
                digital = "";
                z ="+";
            }
        }
         /**
        *減法 
        */
        if(operator == Operator.MINUS)
        {
            if(digital.length()>0)
            {
              x = Double.parseDouble(digital);
              digital ="";
              z = "-";
            }else
            {
                x = b;
                b = 0;
                digital ="";
                z = "-";
            }
        }
        /**
         * 乘法
         */
        if(operator == Operator.TIMES)
        {
            if(digital.length()>0)
            {
              x = Double.parseDouble(digital);
              digital ="";
              z = "*";
            }else
            {
                x = b;
                b = 0;
                digital ="";
                z = "*";
            }
        }
        /**
         * 除法
         */
        if(operator == Operator.OVER)
        {
            if(digital.length()>0)
            {
              x = Double.parseDouble(digital);
              digital ="";
              z = "/";
            }else
            {
                x = b;
          
                digital ="";
                z = "/";
            }
        }
        /**
         * 等於
         */
        if(operator == Operator.EQUAL)
        {
            if(z == "+")
        
        {
            y = Double.parseDouble(digital);
            digital = String.valueOf(x+y);
            if(digital.indexOf(".0")==digital.length()-2)
            {
                digital = String.valueOf((int)(x+y));
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
            else
            {
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
        
        }
        }
        if (z == "-")
        {
            y = Double.parseDouble(digital);
            digital = String.valueOf(x-y);
            if(digital.indexOf(".0")==digital.length()-2)
            {
                digital = String.valueOf((int)(x-y));
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
            else
            {
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
        
        }
          if (z == "*")
        {
            y = Double.parseDouble(digital);
            digital = String.valueOf(x*y);
            if(digital.indexOf(".0")==digital.length()-2)
            {
                digital = String.valueOf((int)(x*y));
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
            else
            {
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
        }
        if (z == "/")
        {
            y = Double.parseDouble(digital);
            digital = String.valueOf(x/y);
            if(digital.indexOf(".0")==digital.length()-2)
            {
                digital = String.valueOf((int)(x/y));
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
            else
            {
                getDisplay();
                b = Double.parseDouble(digital);
                digital = "";
            }
        }
    
            
    
   
  
        }
    
    
    /**
     *  上載資料
     * @return 
     */
    public String getDisplay() {
        // TODO code application logic here
        setChanged();
        notifyObservers(digital);
        return null;
    }
    /**
     * 存取運算符號
     * @param b 
     */
    public void bn(String text){
    if(text =="+") performOperation(Operator.PLUS);
    if(text =="-") performOperation(Operator.MINUS);
    if(text =="*") performOperation(Operator.TIMES);
    if(text =="/") performOperation(Operator.OVER);
    if(text =="C") performOperation(Operator.CLEAR);
    if(text =="=") performOperation(Operator.EQUAL);
    if(text =="CE")performOperation(Operator.CLEAR_ENTRY);
    }
}

    /**
     * @param args the command line arguments
     */
   