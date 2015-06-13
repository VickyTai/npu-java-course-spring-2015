/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;
import tw.edu.npu.mis.Calculator.Operator;
/**
 *
 * @author USER
 */
public class Contorller {
    
    work mview;
    Calculator mmodel;

   public  Contorller(Calculator M) {
        mmodel=M;
    }

   
    /**
     * 宣告變數
     * @param data 
     */
// public void Controller(Calculator data) {
// /**
//  * 使model存取資料
//  */
//    mmodel = data;
//     
//     
//   }
 public void work(work v ){
     /**
      * 讓work存取controller
      */
     mview = v;
     mmodel.getDisplay();
     
    }
    /**
     * 傳送數字
     */
   public void send (String num ){
       mmodel.appendDigit(Integer.parseInt(num));
   }
   /**
    * 傳送小數點
    */
   public void dot (String d ){
       mmodel.appendDot(d);
   }
   /**
    * 傳送運算符號
    */
   public void bn (String b){
       mmodel.bn(b);
   } 
           
           
}
